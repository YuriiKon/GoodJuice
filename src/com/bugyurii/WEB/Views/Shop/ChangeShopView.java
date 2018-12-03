package com.bugyurii.WEB.Views.Shop;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.ShopController.changeShop;

public class ChangeShopView extends ConsoleView {

    public ChangeShopView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter shop's name");
        String nameShopChange = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeShopChange = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeShopChange = in.nextDouble();
        System.out.println("Enter selling ability");
        int sellingAbility = in.nextInt();
        System.out.println("Enter storage capacity");
        int storageCapacity = in.nextInt();
        System.out.println(changeShop(nameShopChange, new Location(latitudeShopChange,longitudeShopChange),sellingAbility,storageCapacity));
    }
}
