package com.bugyurii;

import java.util.Objects;

public class Shop {
    private Location location;
    private int selling_ability = 10;
    private int storage_capacity;
    private int storage_goods;
    private Company company;
    private String name = "unnamedShop";

    public Shop(Location location, Company company, String name) {
        this.location = location;
        this.company = company;
        this.name = name;
    }

    public Shop(Location location, int storage_capacity, Company company, String name) {
        this.location = location;
        this.storage_capacity = storage_capacity;
        this.company = company;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelling_ability() {
        return selling_ability;
    }

    public void setSelling_ability(int selling_ability) {
        this.selling_ability = selling_ability;
    }

    public int getStorage_goods() {
        return storage_goods;
    }

    public void setStorage_goods(int storage_goods) {
        this.storage_goods = storage_goods;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getStorage_capacity() {
        return storage_capacity;
    }

    public void setStorage_capacity(int storage_capacity) {
        this.storage_capacity = storage_capacity;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return  "ShopName= '" + name + '\'' + " " + location + " " + company;
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
