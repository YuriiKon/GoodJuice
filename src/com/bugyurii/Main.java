package com.bugyurii;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static Company comp;

    public static void main(String[] args) {
        comp = new Company("Good juice", 123);
        Shop s = new Shop(new Location(1d,1d),comp,"JuiceShop");
        Transport t = new Transport("123", "BigCar", comp);
        Factory f = new Factory(new Location(2d,2d),comp,"FirstFactory");
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
    static void gonext(){
        System.out.println("Enter anykey to continue");
        Scanner in = new Scanner(System.in);
        in.next();
    }

    static void mainmenu(int day){
        boolean temp = true;
        while(temp){
            System.out.println("Day: " + day + " " + comp + "Global income " + comp.getIncomeSum() + " \u20BD");
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
                    showCompanyInfo();
                    gonext();
                    break;
                case 2:
                    shopmenu();
                    break;
                case 3:
                    factorymenu();
                    break;
                case 4:
                    break;
                case 5:
                    temp = false;
                    nextDay();
                    break;
                case 0:
                    System.out.println("R.I.P.");
                    gap();
                    System.out.println("'" + comp.getName() + "'");
                    System.out.println(day + " days");
                    System.out.println("Income " + comp.getIncomeSum()  + " \u20BD");
                    gap();
                    System.out.println("Shops : " + comp.getShopList().size());
                    System.out.println("Factories : " + comp.getFactoryList().size());
                    System.out.println("Cars : " + comp.getTransportList().size());
                    gap();
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
                    gonext();
                    break;
                case 2:
                    System.out.println("Enter shop's name");
                    String name = in.next();
                    findShop(name);
                    gonext();
                    break;
                case 3:
                    System.out.println("Enter shop's name");
                    String nameShop = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    Double latitudeShop = in.nextDouble();
                    System.out.println("Enter longitude");
                    Double longitudeShop = in.nextDouble();
                    addShop(nameShop, new Location(latitudeShop,longitudeShop));
                    System.out.println("Shop successfully created");
                    break;
                case 4:
                    System.out.println("Enter shop's name");
                    String nameShopRemove = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    Double latitudeShopRemove = in.nextDouble();
                    System.out.println("Enter longitude");
                    Double longitudeShopRemove = in.nextDouble();
                    removeShop(nameShopRemove, new Location(latitudeShopRemove,longitudeShopRemove));
                    break;
                case 5:
                    System.out.println("Enter shop's name");
                    String nameOrderShop = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    Double latitudeOrderShop = in.nextDouble();
                    System.out.println("Enter longitude");
                    Double longitudeOrderShop = in.nextDouble();
                    System.out.println("Enter juice's count");
                    int countJuice = in.nextInt();
                    orderJuice(nameOrderShop, new Location(latitudeOrderShop,longitudeOrderShop),countJuice);
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
        comp.getShopList().stream()
                .forEach(System.out::println);
    }
    static void findShop(String name){
        comp.getShopsByName(name).stream()
                .forEach(System.out::println);
    }
    static void showCompanyInfo(){
        System.out.println(comp +
                "Shops:\n" + comp.getShopList() +
                "\nFactories\n" + comp.getFactoryList() +
                "\nTransport\n" + comp.getTransportList());
    }

    static void addShop(String name, Location loc){
        new Shop(loc, comp, name);
    }

    static void removeShop(String name, Location loc){
        if (comp.removeShop(new Shop(loc, comp, name))) {
            System.out.println("Shop successfully removed");
        } else {
            System.out.println("Shop not exist");
        }
    }

    static void orderJuice(String name, Location loc, int count){

        try {
            Shop shop = comp.getShop(name, loc);
            System.out.println(comp.orderJuice(shop,count));

        }catch (Exception ex){System.out.println("Shop isn't found");}

    }

    static void nextDay(){
        comp.setShopList(comp.getShopList().stream()
                .map(x -> x.skipDay())
                .collect(Collectors.toList()));
        comp.setFactoryList(comp.getFactoryList().stream()
                .map(x -> x.skipDay())
                .collect(Collectors.toList()));
        comp.setTransportList(comp.getTransportList().stream()
                .map(x -> x.skipDay())
                .collect(Collectors.toList()));
    }
}
