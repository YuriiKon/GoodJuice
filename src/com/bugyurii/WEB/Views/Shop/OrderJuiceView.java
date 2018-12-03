package com.bugyurii.WEB.Views.Shop;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.ShopController.orderJuice;

public class OrderJuiceView extends ConsoleView {
    public OrderJuiceView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter shop's name");
        String nameOrderShop = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeOrderShop = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeOrderShop = in.nextDouble();
        System.out.println("Enter juice's count");
        int countJuice = in.nextInt();
        System.out.println(orderJuice(nameOrderShop, new Location(latitudeOrderShop,longitudeOrderShop),countJuice));
    }
}
