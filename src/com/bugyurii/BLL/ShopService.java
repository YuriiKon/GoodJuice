package com.bugyurii.BLL;

import com.bugyurii.Entities.Company;
import com.bugyurii.Entities.Location;
import com.bugyurii.Entities.Shop;

public class ShopService {

    Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
    }

    //region get-set
    public String getName() {

        return shop.getName();
    }

    public void setName(String name) {

        shop.setName(name);
    }

    public int getSellingAbility() {

        return shop.getSellingAbility();
    }

    public void setSellingAbility(int sellingAbility) {

        shop.setSellingAbility(sellingAbility);
    }

    public int getStorageGoods() {

        return shop.getStorageGoods();
    }

    public void setStorageGoods(int storageGoods) {

        shop.setStorageGoods(storageGoods);
        shop.setAbstractStorageGoods(storageGoods);
    }

    public Company getCompany() {

        return shop.getCompany();
    }

    public void setCompany(Company company) {

        shop.setCompany(company);
    }

    public int getStorageCapacity() {

        return shop.getStorageCapacity();
    }

    public void setStorageCapacity(int storageCapacity) {

        shop.setStorageCapacity(storageCapacity);
    }

    public Location getLocation() {

        return shop.getLocation();
    }

    public int getAbstractStorageGoods() {

        return shop.getAbstractStorageGoods();
    }

    public void setAbstractStorageGoods(int abstractStorageGoods) {
        shop.setAbstractStorageGoods(abstractStorageGoods);
    }

    public int getIncome() {
        return shop.getIncome();
    }

    public void setIncome(int income) {
        shop.setIncome(income);
    }

    public int getPRICE() {
        return shop.getPrice();
    }

    //endregion

    public Shop skipDay(){
        if(shop.getStorageGoods() - shop.getSellingAbility() > 0){
            shop.setIncome(shop.getIncome() + shop.getSellingAbility() * shop.getPrice());
            shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() - shop.getSellingAbility());
            shop.setStorageGoods((shop.getStorageGoods() - shop.getSellingAbility()));
        }else{
            shop.setIncome(shop.getIncome() + shop.getStorageGoods() * shop.getPrice());
            shop.setAbstractStorageGoods(shop.getAbstractStorageGoods() - shop.getStorageGoods());
            shop.setStorageGoods((shop.getStorageGoods()- shop.getStorageGoods()));
        }
        return shop;
    }

}
