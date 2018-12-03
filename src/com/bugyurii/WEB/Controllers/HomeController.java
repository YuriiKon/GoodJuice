package com.bugyurii.WEB.Controllers;

import com.bugyurii.BLL.*;
import com.bugyurii.WEB.Models.*;
import com.bugyurii.WEB.Views.ConsoleView;
import com.bugyurii.WEB.Views.Home.*;

import java.util.stream.Collectors;

public class HomeController extends Controller{

    private static CompanyService comp;

    public HomeController(CompanyService comp) {
        this.comp = comp;
        view();
    }

    public static void shopMenu(){
        new ShopController(comp);
    }

    public static void factoryMenu(){ new FactoryController(comp); }

    public static void transportMenu(){
        new TransportController(comp);
    }

    public static ConsoleView view(){

        return new HomeMenu(
                new HomeMenuModel(
                comp.getIncomeSum(),
                comp.getName()));
    }


    public static ConsoleView showCompanyInfo(){

        return new CompanyInfoView(
                new CompanyInfoModel(
                        comp.getName(),
                        comp.getShopList(),
                        comp.getFactoryList(),
                        comp.getTransportList()));

    }

    public static ConsoleView finalStats(int day){

        return new FinalStatisticView(
                new FinalStatisticModel(
                        day,
                        comp.getIncomeSum(),
                        comp.getName(),
                        comp.getShopList().size(),
                        comp.getFactoryList().size(),
                        comp.getTransportList().size()));

    }

    public static HomeMenuModel nextDay(){
        comp.setShopList(comp.getShopList().stream()
                .map(x -> new ShopService(x).skipDay())
                .collect(Collectors.toList()));
        comp.setFactoryList(comp.getFactoryList().stream()
                .map(x -> new FactoryService(x).skipDay())
                .collect(Collectors.toList()));
        comp.setTransportList(comp.getTransportList().stream()
                .map(x -> new TransportService(x).skipDay())
                .collect(Collectors.toList()));
        return new HomeMenuModel(comp.getIncomeSum(), comp.getName());
    }
}
