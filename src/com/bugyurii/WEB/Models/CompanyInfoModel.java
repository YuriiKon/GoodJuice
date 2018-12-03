package com.bugyurii.WEB.Models;

import com.bugyurii.Entities.Factory;
import com.bugyurii.Entities.Shop;
import com.bugyurii.Entities.Transport;

import java.util.List;

public class CompanyInfoModel {
    public String name;
    public List<Shop> shopsList;
    public List<Factory> factoriesList;
    public List<Transport> transportsList;

    public CompanyInfoModel(String name, List<Shop> shopsList, List<Factory> factoriesList, List<Transport> transportsList) {
        this.name = name;
        this.shopsList = shopsList;
        this.factoriesList = factoriesList;
        this.transportsList = transportsList;
    }
}
