package com.bugyurii.WEB.Views.Transport;

import com.bugyurii.Entities.Location;
import com.bugyurii.WEB.Views.ConsoleView;

import java.util.Scanner;

import static com.bugyurii.WEB.Controllers.TransportController.removeTransport;

public class RemoveTransportView extends ConsoleView {

    public RemoveTransportView() {

        run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter vehicle certificate");
        String certificateRemove = in.next();
        System.out.println(removeTransport(certificateRemove));
    }
}
