package com.bugyurii.WEB.Views.Shop;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.ShopController.addShop;

public class AddShopView extends ConsoleView {

    public AddShopView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter shop's name");
        String nameShop = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeShop = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeShop = in.nextDouble();
        addShop(nameShop, new Location(latitudeShop,longitudeShop));
        System.out.println("Shop successfully created");
    }
}
