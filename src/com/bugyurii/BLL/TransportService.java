package com.bugyurii.BLL;

import com.bugyurii.Entities.*;

public class TransportService {

    Transport transport;

    public TransportService(Transport transport) {
        this.transport = transport;
    }

    //region get-set
    public void setCapacity(int capacity) {

        transport.setCapacity(capacity);
    }

    public String getVehicleCertificate() {

        return transport.getVehicleCertificate();
    }

    public int getCapacity() {

        return transport.getCapacity();
    }

    public String getName() {

        return transport.getName();
    }

    public void setName(String name) {

        transport.setName(name);
    }

    public Company getCompany() {

        return transport.getCompany();
    }

    public void setCompany(Company company) {

        transport.setCompany(company);
    }

    public Status getStatus() {

        return transport.getStatus();
    }

    public void setStatus(Status status) {

        transport.setStatus(status);
    }

    public int getStatusDuration() {

        return transport.getStatusDuration();
    }

    public int getFullness() {

        return transport.getFullness();
    }

    public void setFullness(int fullness) {

        transport.setFullness(fullness);
    }

    public void setStatusDuration(int statusDuration) {

        transport.setStatusDuration(statusDuration);
    }

    public int getLastStatusDuration() {

        return transport.getLastStatusDuration();
    }

    public void setLastStatusDuration(int lastStatusDuration) {

        transport.setLastStatusDuration(lastStatusDuration);
    }

    public Shop getDestinationShop() {

        return transport.getDestinationShop();
    }

    public void setDestinationShop(Shop destinationShop) {

        transport.setDestinationShop(destinationShop);
    }

    public double getSpeed() {

        return transport.getSpeed();
    }

    public void setSpeed(double speed) {

        transport.setSpeed(speed);
    }

    //endregion

    public void sendDeliver(Shop shop, Factory factory, int fullness){
        transport.setStatus(Status.Deliver);
        transport.setStatusDuration((int)(
                //Pythagorean theorem for Location
                Math.ceil(
                        Math.sqrt(Math.pow(shop.getLocation().getLatitude() - factory.getLocation().getLatitude(),2) +
                        Math.pow(shop.getLocation().getLongitude() - factory.getLocation().getLongitude(),2)))/ transport.getSpeed()
            )
        );
        transport.setLastStatusDuration(transport.getStatusDuration());
        transport.setFullness(fullness);
        transport.setDestinationShop(shop);
    }

    public Transport skipDay(){
        if(transport.getStatusDuration() > 0)transport.setStatusDuration(transport.getStatusDuration()-1);
        else {
            switch (transport.getStatus()) {
                case Deliver: {
                    transport.setStatus(Status.Return);
                    transport.setStatusDuration(transport.getLastStatusDuration());
                    transport.setFullness(0);
                    transport.getDestinationShop().setStorageGoods(transport.getDestinationShop().getAbstractStorageGoods());
                    break;
                }
                case Return: {
                    transport.setStatus(Status.OnFactory);
                    transport.setLastStatusDuration(0);
                    break;
                }
            }
        }
        return transport;
    }
}
