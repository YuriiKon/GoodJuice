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
            mainMenu(day);
            day++;
            gap();
        }

    }
    static void gap(){
        System.out.println("------------------------------");
    }
    static void goNext(){
        System.out.println("Enter any key to continue");
        Scanner in = new Scanner(System.in);
        in.next();
    }

    static void mainMenu(int day){
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
    static void shopMenu(){
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
                    System.out.println("Enter shop's name");
                    String nameShop = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    double latitudeShop = in.nextDouble();
                    System.out.println("Enter longitude");
                    double longitudeShop = in.nextDouble();
                    addShop(nameShop, new Location(latitudeShop,longitudeShop));
                    System.out.println("Shop successfully created");
                    break;
                case 4:
                    System.out.println("Enter shop's name");
                    String nameShopRemove = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    double latitudeShopRemove = in.nextDouble();
                    System.out.println("Enter longitude");
                    double longitudeShopRemove = in.nextDouble();
                    removeShop(nameShopRemove, new Location(latitudeShopRemove,longitudeShopRemove));
                    break;
                case 5:
                    System.out.println("Enter shop's name");
                    String nameOrderShop = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    double latitudeOrderShop = in.nextDouble();
                    System.out.println("Enter longitude");
                    double longitudeOrderShop = in.nextDouble();
                    System.out.println("Enter juice's count");
                    int countJuice = in.nextInt();
                    orderJuice(nameOrderShop, new Location(latitudeOrderShop,longitudeOrderShop),countJuice);
                    break;
                case 6:
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
                    setValuesToShop(nameShopChange, new Location(latitudeShopChange,longitudeShopChange),sellingAbility,storageCapacity);
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

    static void factoryMenu(){
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
            int menuid = in.nextInt();
            switch (menuid){
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
                    System.out.println("Enter factory's name");
                    String nameFactory = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    double latitudeFactory = in.nextDouble();
                    System.out.println("Enter longitude");
                    double longitudeFactory = in.nextDouble();
                    addFactory(nameFactory, new Location(latitudeFactory,longitudeFactory));
                    System.out.println("Factory successfully created");
                    break;
                case 4:
                    System.out.println("Enter factory's name");
                    String nameFactoryRemove = in.next();
                    System.out.println("Enter Location");
                    System.out.println("Enter latitude");
                    double latitudeFactoryRemove = in.nextDouble();
                    System.out.println("Enter longitude");
                    double longitudeFactoryRemove = in.nextDouble();
                    removeFactory(nameFactoryRemove, new Location(latitudeFactoryRemove,longitudeFactoryRemove));
                    break;
                case 5:
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
                    setValuesToFactory(nameFactoryChange, new Location(latitudeFactoryChange,longitudeFactoryChange),warehouseCapacity,production);
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

    static void transportMenu(){
        boolean temp = true;
        while(temp){
            System.out.println("Transport menu");
            System.out.println("1. Show all transport");
            System.out.println("2. Find transport");
            System.out.println("3. Create and add transport to the company");
            System.out.println("4. Remove transport");
            System.out.println("5. Set transport's parameters");
            System.out.println("0. Return to main menu");
            System.out.println();
            Scanner in = new Scanner(System.in);
            int menuid = in.nextInt();
            switch (menuid){
                case 1:
                    showTransport();
                    goNext();
                    break;
                case 2:
                    System.out.println("Enter transport's name");
                    String name = in.next();
                    findTransport(name);
                    goNext();
                    break;
                case 3:
                    System.out.println("Enter transport's name");
                    String nameTransport = in.next();
                    System.out.println("Enter vehicle certificate");
                    String certificate = in.next();
                    addTransport(nameTransport, certificate);
                    System.out.println("Transport successfully created");
                    break;
                case 4:
                    System.out.println("Enter vehicle certificate");
                    String certificateRemove = in.next();
                    removeTransport(certificateRemove);
                    break;
                case 5:
                    System.out.println("Enter vehicle certificate");
                    String certificateChange = in.next();
                    System.out.println("Enter speed");
                    double speed = in.nextDouble();
                    System.out.println("Enter capacity");
                    int capacity = in.nextInt();
                    setValuesToTransport(certificateChange, speed, capacity );
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

    static void setValuesToShop(String name, Location loc, int sellingAbility, int storageCapacity){
        try {
            Shop s = comp.getShop(name, loc);
            s.setStorageCapacity(storageCapacity);
            s.setSellingAbility(sellingAbility);
            System.out.println("Shop successfully changed");
        }catch (Exception ex){
            System.out.println("Shop not exist");
        }

    }

    static void setValuesToFactory(String name, Location loc, int warehouseCapacity, int production){

        try {
            Factory f = comp.getFactory(name, loc);
            f.setWarehouseCapacity(warehouseCapacity);
            f.setProduction(production);
            System.out.println("Factory successfully changed");
        }catch (Exception ex){
            System.out.println("Factory not exist");
        }

    }

    static void setValuesToTransport(String certificate, double speed, int capacity){

        try {
            Transport t = comp.getTransport(certificate);
            t.setSpeed(speed);
            t.setCapacity(capacity);
            System.out.println("Transport successfully changed");
        }catch (Exception ex){
            System.out.println("Transport not exist");
        }
    }

    static void showFactories(){
        comp.getFactoryList().stream()
                .forEach(System.out::println);
    }

    static void showTransport(){
        comp.getTransportList().stream()
                .forEach(System.out::println);
    }

    static void showShops(){
        comp.getShopList().stream()
                .forEach(System.out::println);
    }
    static void findShop(String name){
        comp.getShopsByName(name).stream()
                .forEach(System.out::println);
    }

    static void findFactory(String name){
        comp.getFactoriesByName(name).stream()
                .forEach(System.out::println);
    }

    static void findTransport(String name){
        comp.getTransportByName(name).stream()
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

    static void addFactory(String name, Location loc){
        new Factory(loc, comp, name);
    }

    static void addTransport(String name, String certificate){
        new Transport(certificate, name, comp);
    }

    static void removeShop(String name, Location loc){
        if (comp.removeShop(new Shop(loc, comp, name))) {
            System.out.println("Shop successfully removed");
        } else {
            System.out.println("Shop not exist");
        }
    }

    static void removeFactory(String name, Location loc){
        if (comp.removeFactory(new Factory(loc, comp, name))) {
            System.out.println("Factory successfully removed");
        } else {
            System.out.println("Factory not exist");
        }
    }

    static void removeTransport(String certificate){
        try {
            Transport t = comp.getTransport(certificate);
            comp.removeTransport(t);
            System.out.println("Transport successfully removed");
        }catch (Exception ex){
            System.out.println("Transport not exist");
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
