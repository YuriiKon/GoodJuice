package com.bugyurii.WEB.Views.Transport;

import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.TransportController.addTransport;

public class AddTransportView extends ConsoleView {

    public AddTransportView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter transport's name");
        String nameTransport = in.next();
        System.out.println("Enter vehicle certificate");
        String certificate = in.next();
        addTransport(nameTransport, certificate);
        System.out.println("Transport successfully created");
    }
}
