package com.bugyurii;

public class Transport {
    String vehicle_certificate;
    int capacity;

    public Transport(String vehicle_certificate, int capacity) {
        setCapacity(capacity);
        this.vehicle_certificate = vehicle_certificate;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVehicle_certificate() {
        return vehicle_certificate;
    }

    public int getCapacity() {
        return capacity;
    }

}
