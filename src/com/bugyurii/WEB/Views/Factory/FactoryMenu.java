package com.bugyurii.WEB.Views.Factory;

import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.FactoryController.*;

public class FactoryMenu extends ConsoleView {

    public FactoryMenu() {

        run();
    }

    @Override
    public void run(){
        boolean temp = true;
        while(temp){
            System.out.println("Factory menu");
            System.out.println("1. Show all factories");
            System.out.println("2. Find factory");
            System.out.println("3. Create and add factory to the company");
            System.out.println("4. Remove factory");
            System.out.println("5. Set factory's parameters");
            System.out.println("0. Return to main menu");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuId = in.nextInt();
            switch (menuId){
                case 1:
                    showFactories();
                    goNext();
                    break;
                case 2:
                    System.out.println("Enter factory's name");
                    String name = in.next();
                    findFactory(name);
                    goNext();
                    break;
                case 3:
                    addFactory();
                    break;
                case 4:
                    removeFactory();
                    break;
                case 5:
                    changeFactory();
                    break;
                case 0:
                    temp = false;
                    break;
                default:
                    gap();
                    System.out.println("Please enter another value");
                    break;
            }
        }
    }
}
