package com.bugyurii.WEB.Views.Factory;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.FactoryController.changeFactory;

public class ChangeFactoryView extends ConsoleView {

    public ChangeFactoryView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter factory's name");
        String nameFactoryChange = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeFactoryChange = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeFactoryChange = in.nextDouble();
        System.out.println("Enter warehouse capacity");
        int warehouseCapacity = in.nextInt();
        System.out.println("Enter production");
        int production = in.nextInt();
        System.out.println(changeFactory(nameFactoryChange, new Location(latitudeFactoryChange,longitudeFactoryChange),warehouseCapacity,production));
    }
}
