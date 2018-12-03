package com.bugyurii.WEB.Views.Shop;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.ShopController.removeShop;

public class RemoveShopView extends ConsoleView {
    public RemoveShopView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter shop's name");
        String nameShopRemove = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeShopRemove = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeShopRemove = in.nextDouble();
        System.out.println(removeShop(nameShopRemove, new Location(latitudeShopRemove,longitudeShopRemove)));
    }
}
