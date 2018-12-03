package com.bugyurii.Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Company {

    private String name;
    private int tin; //ИНН

    private List<Shop> shopList = new ArrayList<>();
    private List<Factory> factoryList = new ArrayList<>();
    private List<Transport> transportList = new ArrayList<>();

    public Company(String name, int tin) {
        this.name = name;
        this.tin = tin;
    }

    //region get-set

    public String getName() {
        return name;
    }

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
