package com.bugyurii.BLL;

import com.bugyurii.Entities.Company;
import com.bugyurii.Entities.Factory;
import com.bugyurii.Entities.Location;

public class FactoryService {

    Factory factory;

    public FactoryService(Factory factory) {
        this.factory = factory;
    }

    //region get-set
    public Location getLocation() {
        return factory.getLocation();
    }

    public int getProduction() {
        return factory.getProduction();
    }

    public void setProduction(int production) {
        factory.setProduction(production);
    }

    public int getWarehouseCapacity() {
        return factory.getWarehouseCapacity();
    }

    public void setWarehouseCapacity(int warehouseCapacity) {
        factory.setWarehouseCapacity(warehouseCapacity);
    }

    public int getWarehouseGoods() {
        return factory.getWarehouseGoods();
    }

    public void setWarehouseGoods(int warehouseGoods) {
        factory.setWarehouseGoods(warehouseGoods);
    }

    public String getName() {
        return factory.getName();
    }

    public void setName(String name) {
        factory.setName(name);
    }

    public Company getCompany() {
        return factory.getCompany();
    }

    public void setCompany(Company company) {
        factory.setCompany(company);
    }
    //endregion

    public Factory skipDay(){
        if(getWarehouseGoods()+getProduction()>getWarehouseCapacity())setWarehouseGoods(getWarehouseCapacity());
        else setWarehouseGoods(getWarehouseGoods()+getProduction());
        return factory;
    }

}
