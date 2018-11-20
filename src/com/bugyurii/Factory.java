package com.bugyurii;

import java.util.Objects;

public class Factory {

    private Location location;
    private int production;
    private int warehouse;
    private String name = "unnamedFactory";
    private Company company;

    public Factory(Location location, String name) {
        this.location = location;
        this.name = name;
    }
    public Factory(Location location, Company company) {
        this.location = location;
        setCompany(company);
        company.addFactory(this);
    }

    public Factory(Location location, Company company, String name) {
        this.location = location;
        this.company = company;
        this.name = name;
    }

    public Factory(Location location, int warehouse, String name, Company company) {
        this.location = location;
        this.warehouse = warehouse;
        this.name = name;
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
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

    @Override
    public String toString() {
        return " FactoryName= '" + name + '\'' + " " + location;

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
