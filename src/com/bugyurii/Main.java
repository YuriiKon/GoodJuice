package com.bugyurii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Company comp;

    public static void main(String[] args) {
	// write your code here
        comp = new Company("Good juice", 123);
        test();
    }
    static void test(){
        int day = 1;
        while(true){
            mainmenu(day);
            day++;
            gap();
        }

    }
    static void gap(){
        System.out.println("------------------------------");
    }

    static void mainmenu(int day){
        boolean temp = true;
        while(temp){
            System.out.println("Day: " + day + " " + comp);
            System.out.println("1. Show information about the company");
            System.out.println("2. Go to shop menu");
            System.out.println("3. Go to factory menu");
            System.out.println("4. Go to transport menu");
            System.out.println("5. Finish day");
            System.out.println("0. Exit");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuid = in.nextInt();
            switch (menuid){
                case 1:

                    break;
                case 2:
                    shopmenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    temp = false;
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    gap();
                    System.out.println("Please enter another value");
                    break;
            }
        }
    }
    static void shopmenu(){
        boolean temp = true;
        while(temp){
            System.out.println("Shop menu");
            System.out.println("1. Show all shops");
            System.out.println("2. Find shop");
            System.out.println("3. Create and add shop to the company");
            System.out.println("4. Remove shop");
            System.out.println("5. Order juice");
            System.out.println("0. Return to main menu");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuid = in.nextInt();
            switch (menuid){
                case 1:
                    showShops();
                    break;
                case 2:
                    String name = in.next();
                    findShop(name);
                    break;
                case 3:
                    break;
                case 4:

                    break;
                case 5:
                    temp = false;
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

    static void showShops(){
        List<Shop> shopList = comp.getShopList();
        for(int i = 0; i < shopList.size(); i++){
            System.out.println(i + ". " + shopList.get(i));
        }
    }
    static void findShop(String name){
        List<Shop> shopList = comp.getShopList();
        System.out.println(shopList.indexOf(new Company("Good juice", 123)));
    }
    static void addShop(){

    }
}
