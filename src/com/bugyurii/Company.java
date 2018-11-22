package com.bugyurii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Company {

    private String name;
    private int tin;

    private List<Shop> shopList = new ArrayList<>();
    private List<Factory> factoryList = new ArrayList<>();
    private List<Transport> transportList = new ArrayList<>();

    public Company(String name, int tin) {
        this.name = name;
        this.tin = tin;
    }


    public String getName() {
        return name;
    }

    public void addShop(Shop shop){
        shopList.add(shop);
        shopList = shopList.stream()
                            .distinct()
                            .collect(Collectors.toList());
    }

    public boolean removeShop(Shop shop){
        return shopList.remove(shop);
    }

    public void addFactory(Factory factory){
        factoryList.add(factory);
        factoryList = factoryList.stream()
                                .distinct()
                                .collect(Collectors.toList());
    }

    public void addTransport(Transport transport){
        transportList.add(transport);
        transportList = transportList.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
    }

    public List<Shop> getShopsByName(String name){
        return shopList.stream().filter(x -> name.equals(x.getName())).collect(Collectors.toList());
    }

    public Shop getShop(String name, Location loc){
        return shopList.stream().filter(x -> x.getLocation().equals(loc)&&x.getName().equals(name)).findFirst().get();
    }

    //region get-set
    public List<Shop> getShopList() {
        return shopList;
    }

    public List<Factory> getFactoryList() {
        return factoryList;
    }

    public List<Transport> getTransportList() {
        return transportList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public void setFactoryList(List<Factory> factoryList) {
        this.factoryList = factoryList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    public int getTin() {
        return tin;
    }
    //endregion

    public String orderJuice(Shop shop, int count){
        int temp = (shop.getStorageCapacity() - shop.getAbstractStorageGoods())<count
                ?(shop.getStorageCapacity() - shop.getAbstractStorageGoods())
                :count;
        shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() + temp);
        factoryList = getFactoryList().stream()
                .sorted(Comparator.comparing(x -> x.getWarehouseGoods()))
                .collect(Collectors.toList());
        List<Transport> transportOnFactoryList = getTransportList().stream()
                .filter(x -> x.getStatus() == Status.OnFactory)
                .sorted((x1,x2)->Integer.compare(x2.getCapacity(),x1.getCapacity()))
                .collect(Collectors.toList());
        for(int i=0;i<factoryList.size()&&temp>0;i++){
            Factory fac = factoryList.get(i);
            for(int j=0;j<transportOnFactoryList.size()&&fac.getWarehouseGoods()>0&&temp>0;j++){
                Transport t = transportOnFactoryList.get(j);
                if(fac.getWarehouseGoods() >= t.getCapacity()){
                    if(temp >= t.getCapacity()) {
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - t.getCapacity());
                        t.sendDeliver(shop, fac, t.getCapacity());
                        temp -= t.getCapacity();
                    }else{
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - temp);
                        t.sendDeliver(shop, fac, temp);
                        temp -= temp;
                    }
                }else{
                    if(temp >= fac.getWarehouseGoods()) {
                        t.sendDeliver(shop, fac, fac.getWarehouseGoods());
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - fac.getWarehouseGoods());
                        temp -= fac.getWarehouseGoods();
                    }else{
                        fac.setWarehouseGoods(fac.getWarehouseGoods() - temp);
                        t.sendDeliver(shop, fac, temp);
                        temp -= temp;
                    }
                }
            }
        }
        shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() - temp);
        return temp>0?"Order not completed or partially completed":"Order successfully created";

    }

    public int getIncomeSum(){
        return shopList.stream().reduce(0,(x,y) -> x + y.getIncome(),(x,y) -> x + y);
    }

    @Override
    public String toString() {
        return  "CompanyName : '" + name + '\'' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getTin() == company.getTin();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTin());
    }
}
