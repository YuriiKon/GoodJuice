package com.bugyurii.BLL;

import com.bugyurii.Entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {

    Company company;

    public CompanyService(Company company) {
        this.company = company;
    }

    //region removes
    public boolean removeShop(Shop shop){
        return company.getShopList().remove(shop);
    }

    public boolean removeFactory(Factory factory){
        return company.getFactoryList().remove(factory);
    }

    public boolean removeTransport(Transport transport){
        return company.getTransportList().remove(transport);
    }
    //endregion

    //region adds
    public void addFactory(Factory factory){
        company.getFactoryList().add(factory);
        company.setFactoryList(
                company.getFactoryList().stream()
                    .distinct()
                    .collect(Collectors.toList())
        );
    }

    public void addTransport(Transport transport){
        company.getTransportList().add(transport);
        company.setTransportList(
                company.getTransportList().stream()
                    .distinct()
                    .collect(Collectors.toList())
        );
    }

    public void addShop(Shop shop){
        company.getShopList().add(shop);
        company.setShopList(
                company.getShopList()
                        .stream()
                        .distinct()
                        .collect(Collectors.toList())
        );
    }

    //endregion

    //region gets

    public Company getCompany() {
        return company;
    }

    public List<Shop> getShopsByName(String name){
        return company.getShopList()
                .stream()
                .filter(x ->
                        name.equals(x.getName())
                )
                .collect(Collectors.toList());
    }

    public List<Factory> getFactoriesByName(String name){
        return company.getFactoryList()
                .stream()
                .filter(x ->
                        name.equals(x.getName())
                )
                .collect(Collectors.toList());
    }

    public List<Transport> getTransportByName(String name){
        return company.getTransportList()
                .stream()
                .filter(x ->
                        name.equals(x.getName())
                )
                .collect(Collectors.toList());
    }

    public Shop getShopByNameAndLocation(String name, Location loc){
        return company.getShopList()
                .stream()
                .filter(x ->
                        x.getLocation().equals(loc)
                                &&
                         x.getName().equals(name)
                ).findFirst()
                .get();
    }

    public Transport getTransportByCertificate(String certificate){
        return company.getTransportList()
                .stream()
                .filter(x ->
                        x.getVehicleCertificate().equals(certificate)
                )
                .findFirst()
                .get();
    }

    public Factory getFactoryByNameAndLocation(String name, Location loc) {
        return company.getFactoryList()
                .stream()
                .filter(x ->
                        x.getLocation().equals(loc)
                                &&
                        x.getName().equals(name)
                )
                .findFirst()
                .get();
    }
    //endregion

    //region get-set

    public String getName() {

        return company.getName();
    }

    public List<Shop> getShopList() {

        return company.getShopList();
    }

    public List<Factory> getFactoryList() {

        return company.getFactoryList();
    }

    public List<Transport> getTransportList() {

        return company.getTransportList();
    }

    public void setShopList(List<Shop> shopList) {

        company.setShopList(shopList);
    }

    public void setFactoryList(List<Factory> factoryList) {

        company.setFactoryList(factoryList);
    }

    public void setTransportList(List<Transport> transportList) {

        company.setTransportList(transportList);
    }

    public int getTin() {

        return company.getTin();
    }
    //endregion //

    public int getIncomeSum(){

        return company.getShopList()
                .stream()
                .reduce(0,(x,y) -> x + y.getIncome(),(x,y) -> x + y);
    }
}
