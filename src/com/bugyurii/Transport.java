package com.bugyurii;

import java.util.Objects;
enum Status {  Deliver, Return, OnFactory}

public class Transport {

    final static Double SPEED = 2d;

    private Company company;

    private String vehicle_certificate;
    private int capacity = 50;
    private String name = "unnamedTransport";

    private int fullness = 0;
    private Status status = Status.OnFactory;
    private int statusDuration = 0;
    private int lastStatusDuration = 0;
    private Shop destinationShop;

    public Transport(String vehicle_certificate, String name, Company company) {
        this.vehicle_certificate = vehicle_certificate;
        setName(name);
        setCompany(company);
        company.addTransport(this);
    }

    //region get-set
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVehicle_certificate() {
        return vehicle_certificate;
    }

    public int getCapacity() {
        return capacity;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStatusDuration() {
        return statusDuration;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public void setStatusDuration(int statusDuration) {
        this.statusDuration = statusDuration;
    }

    public int getLastStatusDuration() {
        return lastStatusDuration;
    }

    public void setLastStatusDuration(int lastStatusDuration) {
        this.lastStatusDuration = lastStatusDuration;
    }

    public Shop getDestinationShop() {
        return destinationShop;
    }

    public void setDestinationShop(Shop destinationShop) {
        this.destinationShop = destinationShop;
    }

    public static Double getSPEED() {
        return SPEED;
    }

    //endregion

    public void sendDeliver(Shop shop, Factory factory, int fullness){
        status = Status.Deliver;
        statusDuration = (int)(Math.ceil(Math.sqrt(Math.pow(shop.getLocation().getLatitude() - factory.getLocation().getLatitude(),2) +
                Math.pow(shop.getLocation().getLongitude() - factory.getLocation().getLongitude(),2)))/SPEED);
        lastStatusDuration = statusDuration;
        setFullness(fullness);
        setDestinationShop(shop);
    }

    public Transport skipDay(){
        if(getStatusDuration() > 0)setStatusDuration(getStatusDuration()-1);
        else {
            switch (status) {
                case Deliver: {
                    setStatus(Status.Return);
                    setStatusDuration(getLastStatusDuration());
                    setFullness(0);
                    getDestinationShop().setStorageGoods(getDestinationShop().getAbstractStorageGoods());
                    break;
                }
                case Return: {
                    setStatus(Status.OnFactory);
                    setLastStatusDuration(0);
                    break;
                }
            }
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;
        Transport transport = (Transport) o;
        return Objects.equals(getVehicle_certificate(), transport.getVehicle_certificate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicle_certificate());
    }

    @Override
    public String toString() {
        return "TransportName : \'" + name + '\'' +
                "\nCapacity : " + capacity +
                "\nStatus " + status.name() +
                (status!=Status.OnFactory?"\nStatus duration - "+ statusDuration:"") +
                "\nFullness : " + fullness;
    }
}
