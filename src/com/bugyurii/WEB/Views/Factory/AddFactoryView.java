package com.bugyurii.WEB.Views.Factory;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.FactoryController.addFactory;

public class AddFactoryView extends ConsoleView {

    public AddFactoryView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter factory's name");
        String nameFactory = in.next();
        System.out.println("Enter Location");
        System.out.println("Enter latitude");
        double latitudeFactory = in.nextDouble();
        System.out.println("Enter longitude");
        double longitudeFactory = in.nextDouble();
        addFactory(nameFactory, new Location(latitudeFactory,longitudeFactory));
        System.out.println("Factory successfully created");
    }
}
