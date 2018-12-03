package com.bugyurii;
import com.bugyurii.BLL.CompanyService;
import com.bugyurii.Entities.*;
import com.bugyurii.WEB.Controllers.HomeController;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static Company comp;

    public static void main(String[] args) {
        comp = new Company("Good juice", 123);
        Shop s = new Shop(new Location(1d,1d),comp,"JuiceShop");
        Transport t = new Transport("123", "BigCar", comp);
        Factory f = new Factory(new Location(2d,2d),comp,"FirstFactory");
        new HomeController(new CompanyService(comp));
    }
}
