package com.bugyurii.WEB.Views.Factory;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.FactoryController.removeFactory;

public class RemoveFactoryView extends ConsoleView {
    public RemoveFactoryView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter factory's name");
        String nameFactoryRemove = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeFactoryRemove = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeFactoryRemove = in.nextDouble();
        System.out.println(removeFactory(nameFactoryRemove, new Location(latitudeFactoryRemove,longitudeFactoryRemove)));
    }
}
