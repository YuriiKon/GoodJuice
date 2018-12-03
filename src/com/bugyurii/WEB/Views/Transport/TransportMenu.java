package com.bugyurii.WEB.Views.Transport;

import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.TransportController.*;

public class TransportMenu extends ConsoleView {

    public TransportMenu() {

        run();
    }

    @Override
    public void run(){
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
            int menuId = in.nextInt();
            switch (menuId){
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
                    addTransport();
                    break;
                case 4:
                    removeTransport();
                    break;
                case 5:
                    changeTransport();
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
