package com.bugyurii.WEB.Views;

import java.util.Scanner;

public abstract class ConsoleView{

    public ConsoleView() { }
    public void run() { }
    protected void goNext(){
        System.out.println("Enter any key to continue");
        Scanner in = new Scanner(System.in);
        in.next();
    }
    protected void gap(){
        System.out.println("------------------------------");
    }

}
