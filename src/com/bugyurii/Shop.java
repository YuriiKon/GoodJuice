package com.bugyurii;

import java.util.Objects;

public class Shop {
    private Location location;

    final static int PRICE = 20;

    private int sellingAbility = 20;
    private int storageCapacity = 100;
    private int storageGoods = 60;
    private int abstractStorageGoods = 60;

    private int income = 0;

    private Company company;

    private String name = "unnamedShop";

    public Shop(Location location, String name) {
        this.location = location;
        setName(name);
    }

    public Shop(Location location, Company company, String name) {
        this.location = location;
        setCompany(company);
        setName(name);
        company.addShop(this);
    }

    public Shop(Location location, int storageCapacity, Company company, String name) {
        this.location = location;
        setStorageCapacity(storageCapacity);
        setCompany(company);
        setName(name);
        company.addShop(this);
        setStorageGoods(storageCapacity);
        abstractStorageGoods = storageGoods;
    }
    public Shop skipDay(){
        if(getStorageGoods() - getSellingAbility() > 0){
            setIncome(getIncome() + getSellingAbility() * PRICE);
            setAbstractStorageGoods(getAbstractStorageGoods() - getSellingAbility());
            storageGoods = (getStorageGoods() - getSellingAbility());
        }else{
            setIncome(getIncome() + getStorageGoods() * PRICE);
            setAbstractStorageGoods(getAbstractStorageGoods() - getStorageGoods());
            storageGoods = (getStorageGoods()- getStorageGoods());
        }
        return this;
    }

    //region get-set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellingAbility() {
        return sellingAbility;
    }

    public void setSellingAbility(int sellingAbility) {
        this.sellingAbility = sellingAbility;
    }

    public int getStorageGoods() {
        return storageGoods;
    }

    public void setStorageGoods(int storageGoods) {
        this.storageGoods = storageGoods;
        abstractStorageGoods = storageGoods;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public Location getLocation() {
        return location;
    }

    public int getAbstractStorageGoods() {
        return abstractStorageGoods;
    }

    public void setAbstractStorageGoods(int abstractStorageGoods) {
        this.abstractStorageGoods = abstractStorageGoods;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    //endregion

    @Override
    public String toString() {
        return  "ShopName= '" + getName() + '\'' +
                "\nIncome : " + getIncome()  + " \u20BD" +
                "\nSelling ability " + getSellingAbility() +
                "\nStorage Capacity : " + getStorageCapacity() +
                "\nJuice in stock : " + getStorageGoods() +
                (getAbstractStorageGoods() - getStorageGoods()>0?"\nJuice on the way : "+(getAbstractStorageGoods() - getStorageGoods()):"") + "\n" +
                getLocation() + "\n" +
                getCompany();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(getLocation(), shop.getLocation()) &&
                Objects.equals(getName(), shop.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getName());
    }
}
