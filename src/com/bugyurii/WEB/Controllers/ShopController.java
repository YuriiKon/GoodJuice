package com.bugyurii.WEB.Controllers;

import com.bugyurii.BLL.*;
import com.bugyurii.Entities.*;
import com.bugyurii.WEB.Views.ConsoleView;
import com.bugyurii.WEB.Views.Shop.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopController extends Controller {

    private static CompanyService companyService;

    public ShopController(CompanyService companyService) {
        this.companyService = companyService;
        view();
    }

    public static ConsoleView view(){
        return new ShopMenu();
    }

    public static void showShops(){
        companyService.getShopList()
                .stream()
                .forEach(System.out::println);
    }

    public static void findShop(String name){
        companyService.getShopsByName(name)
                .stream()
                .forEach(System.out::println);
    }

    //region AddShop
    public static ConsoleView addShop(){

        return new AddShopView(){};
    }

    public static void addShop(String name, Location loc){
        new Shop(loc, companyService.getCompany(), name);
    }
    //endregion

    //region RemoveShop
    public static ConsoleView removeShop(){

        return new RemoveShopView(){};
    }

    public static String removeShop(String name, Location loc){
        if (companyService.removeShop(new Shop(loc, companyService.getCompany(), name))) {
            return "Shop successfully removed";
        } else {
            return "Shop not exist" ;
        }
    }
    //endregion

    //region OrderJuice
    public static ConsoleView orderJuice(){

        return new OrderJuiceView(){};
    }

    public static String orderJuice(String name, Location loc, int count){
        Shop shop;

        try {

            shop = companyService.getShopByNameAndLocation(name, loc);

        }catch (Exception ex){ return "Shop isn't found"; }

        int temp = (shop.getStorageCapacity() - shop.getAbstractStorageGoods())<count
                ?(shop.getStorageCapacity() - shop.getAbstractStorageGoods())
                :count;
        shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() + temp);
        companyService.setFactoryList(
                companyService.getFactoryList()
                        .stream()
                        .sorted(Comparator.comparing(Factory::getWarehouseGoods))
                        .collect(Collectors.toList())
        );
        List<Transport> transportOnFactoryList =
                companyService.getTransportList()
                        .stream()
                        .filter(x -> x.getStatus() == Status.OnFactory)
                        .sorted((x1,x2)->Integer.compare(x2.getCapacity(),x1.getCapacity()))
                        .collect(Collectors.toList());

        for(int i=0;i<companyService.getFactoryList().size()&&temp>0;i++){
            Factory fac = companyService.getFactoryList().get(i);
            for(int j=0;j<transportOnFactoryList.size()&&fac.getWarehouseGoods()>0&&temp>0;j++){
                Transport t = transportOnFactoryList.get(j);
                TransportService ts = new TransportService(t);
                if(fac.getWarehouseGoods() >= t.getCapacity()){
                    if(temp >= t.getCapacity()) {
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - t.getCapacity());
                        ts.sendDeliver(shop, fac, t.getCapacity());
                        temp -= t.getCapacity();
                    }else{
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - temp);
                        ts.sendDeliver(shop, fac, temp);
                        temp -= temp;
                    }
                }else{
                    if(temp >= fac.getWarehouseGoods()) {
                        ts.sendDeliver(shop, fac, fac.getWarehouseGoods());
                        fac.setWarehouseGoods(0);
                        temp -= fac.getWarehouseGoods();
                    }else{
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - temp);
                        ts.sendDeliver(shop, fac, temp);
                        temp -= temp;
                    }
                }
            }
        }
        shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() - temp);
        return temp>0?"Order not completed or partially completed":"Order successfully created";
    }
    //endregion

    //region ChangeShop
    public static ConsoleView changeShop(){

        return new ChangeShopView(){};
    }

    public static String changeShop(String name, Location loc, int sellingAbility, int storageCapacity){
        try {
            Shop s = companyService.getShopByNameAndLocation(name, loc);
            s.setStorageCapacity(storageCapacity);
            s.setSellingAbility(sellingAbility);
            return "Shop successfully changed";
        }catch (Exception ex){
            return "Shop not exist";
        }

    }
    //endregion
}
