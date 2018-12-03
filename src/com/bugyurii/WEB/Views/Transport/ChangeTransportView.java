package com.bugyurii.WEB.Views.Transport;

import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.TransportController.changeTransport;

public class ChangeTransportView extends ConsoleView {
    public ChangeTransportView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter vehicle certificate");
        String certificateChange = in.next();
        System.out.println("Enter speed");
        double speed = in.nextDouble();
        System.out.println("Enter capacity");
        int capacity = in.nextInt();
        System.out.println(changeTransport(certificateChange, speed, capacity ));
    }
}
