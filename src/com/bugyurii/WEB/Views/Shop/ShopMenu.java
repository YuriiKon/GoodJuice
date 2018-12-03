package com.bugyurii.WEB.Views.Shop;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.ShopController.*;

public class ShopMenu extends ConsoleView {

    public ShopMenu() {
        run();
    }

    @Override
    public void run(){
        boolean temp = true;
        while(temp){
            System.out.println("Shop menu");
            System.out.println("1. Show all shops");
            System.out.println("2. Find shop");
            System.out.println("3. Create and add shop to the company");
            System.out.println("4. Remove shop");
            System.out.println("5. Order juice");
            System.out.println("6. Set shop's parameters");
            System.out.println("0. Return to main menu");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuid = in.nextInt();
            switch (menuid){
                case 1:
                    showShops();
                    goNext();
                    break;
                case 2:
                    System.out.println("Enter shop's name");
                    String name = in.next();
                    findShop(name);
                    goNext();
                    break;
                case 3:
                    addShop();
                    break;
                case 4:
                    removeShop();
                    break;
                case 5:
                    orderJuice();
                    break;
                case 6:
                    changeShop();
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
