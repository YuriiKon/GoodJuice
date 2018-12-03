package com.bugyurii.Entities;

import com.bugyurii.BLL.CompanyService;

import java.util.Objects;

public class Factory {

    private Location location;

    private int production = 20;
    private int warehouseCapacity = 500;
    private int warehouseGoods = warehouseCapacity/5;

    private String name = "unnamedFactory";

    private Company company;

    public Factory(Location location, String name) {
        this.location = location;
        setName(name);
    }
    public Factory(Location location, Company company) {
        this.location = location;
        setCompany(company);
        CompanyService cs = new CompanyService(company);
        cs.addFactory(this);
    }

    public Factory(Location location, Company company, String name) {
        this.location = location;
        setCompany(company);
        CompanyService cs = new CompanyService(company);
        cs.addFactory(this);
        setName(name);
    }

    public Factory(Location location, int warehouseCapacity, String name, Company company) {
        this.location = location;
        setWarehouseCapacity(warehouseCapacity);
        setName(name);
        setCompany(company);
        CompanyService cs = new CompanyService(company);
        cs.addFactory(this);
    }

    //region get-set
    public Location getLocation() {
        return location;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(int warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public int getWarehouseGoods() {
        return warehouseGoods;
    }

    public void setWarehouseGoods(int warehouseGoods) {
        this.warehouseGoods = warehouseGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    //endregion

    @Override
    public String toString() {
        return " FactoryName= '" + name + '\'' + " " +
                "Capacity : " + warehouseCapacity + "\n" +
                "Goods in warehouse : " + warehouseGoods + "\n" +
                "Production : " + production + "\n" +
                location + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factory)) return false;
        Factory factory = (Factory) o;
        return Objects.equals(getLocation(), factory.getLocation()) &&
                Objects.equals(getName(), factory.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getName());
    }
}
