package com.bugyurii.WEB.Controllers;

import com.bugyurii.BLL.CompanyService;
import com.bugyurii.Entities.Factory;
import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;
import com.bugyurii.WEB.Views.Factory.*;

public class FactoryController extends Controller {

    private static CompanyService companyService;

    public FactoryController(CompanyService companyService) {

        this.companyService = companyService;
        view();
    }

    public static ConsoleView view(){
        return new FactoryMenu();
    }

    public static void showFactories(){
        companyService.getFactoryList()
                .stream()
                .forEach(System.out::println);
    }

    public static void findFactory(String name){
        companyService.getFactoriesByName(name)
                .stream()
                .forEach(System.out::println);
    }

    //region AddFactory
    public static ConsoleView addFactory(){

        return new AddFactoryView(){};
    }

    public static void addFactory(String name, Location loc){

        new Factory(loc, companyService.getCompany(), name);
    }
    //endregion

    //region RemoveFactory
    public static ConsoleView removeFactory(){

        return new RemoveFactoryView(){};
    }

    public static String removeFactory(String name, Location loc){
        if (companyService.removeFactory(new Factory(loc, companyService.getCompany(), name))) {
            return "Factory successfully removed";
        } else {
            return "Factory not exist";
        }
    }
    //endregion

    //region ChangeFactory
    public static ConsoleView changeFactory(){

        return new ChangeFactoryView(){};
    }

    public static String changeFactory(String name, Location loc, int warehouseCapacity, int production){

        try {
            Factory f = companyService.getFactoryByNameAndLocation(name, loc);
            f.setWarehouseCapacity(warehouseCapacity);
            f.setProduction(production);
            return "Factory successfully changed";
        }catch (Exception ex){
            return "Factory not exist";
        }

    }
    //endregion
}
