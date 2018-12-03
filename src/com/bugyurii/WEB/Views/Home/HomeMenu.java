package com.bugyurii.WEB.Views.Home;

import com.bugyurii.WEB.Models.HomeMenuModel;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.HomeController.*;

public class HomeMenu extends ConsoleView {

    private HomeMenuModel homeMenuModel;

    public HomeMenu(HomeMenuModel homeMenuModel) {
        this.homeMenuModel = homeMenuModel;
        run();
    }
    @Override
    public void run(){
        int day = 1;
        while(true){
            System.out.println("Day: " + day + " " + homeMenuModel.name + "Global income " + homeMenuModel.income + " \u20BD");
            System.out.println("1. Show information about the company");
            System.out.println("2. Go to shop menu");
            System.out.println("3. Go to factory menu");
            System.out.println("4. Go to transport menu");
            System.out.println("5. Finish day");
            System.out.println("0. Exit");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuId = in.nextInt();
            switch (menuId){
                case 1:
                    showCompanyInfo();
                    goNext();
                    break;
                case 2:
                    shopMenu();
                    break;
                case 3:
                    factoryMenu();
                    break;
                case 4:
                    transportMenu();
                    break;
                case 5:
                    homeMenuModel = nextDay();
                    day++;
                    break;
                case 0:
                    finalStats(day);
                    break;
                default:
                    gap();
                    System.out.println("Please enter another value");
                    break;
            }
        }
    }


}
