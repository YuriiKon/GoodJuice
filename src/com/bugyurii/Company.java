package com.bugyurii;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        boolean temp = shopList.stream().anyMatch(shop::equals);
        if(!temp)shopList.add(shop);
        else System.out.println("The shop is already linked");
    }

    public void addFactory(Factory factory){
        boolean temp = factoryList.stream().anyMatch(factory::equals);
        if(!temp)factoryList.add(factory);
        else System.out.println("The factory is already linked");
    }

    public void addTransport(Transport transport){
        boolean temp = transportList.stream().anyMatch(transport::equals);
        if(!temp)transportList.add(transport);
        else System.out.println("The transport is already linked");
    }

    public List<Shop> getShopsByName(String name){
        return shopList.stream().filter(x -> name.equals(x.getName())).collect(Collectors.toList());
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public List<Factory> getFactoryList() {
        return factoryList;
    }

    public int getTin() {
        return tin;
    }

    @Override
    public String toString() {
        return  "CompanyName : '" + name + '\'';
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
