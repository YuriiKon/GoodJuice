package com.bugyurii.WEB.Controllers;

import com.bugyurii.BLL.CompanyService;
import com.bugyurii.Entities.Location;
import com.bugyurii.Entities.Transport;
import com.bugyurii.WEB.Views.ConsoleView;
import com.bugyurii.WEB.Views.Transport.*;

public class TransportController extends Controller{

    private static CompanyService companyService;

    public TransportController(CompanyService companyService) {

        this.companyService = companyService;
        view();
    }

    public static ConsoleView view(){
        return new TransportMenu();
    }

    public static void showTransport(){
        companyService.getTransportList()
                .stream()
                .forEach(System.out::println);
    }

    public static void findTransport(String name){
        companyService.getTransportByName(name)
                .stream()
                .forEach(System.out::println);
    }

    //region AddTransport
    public static ConsoleView addTransport(){

        return new AddTransportView(){};
    }

    public static void addTransport(String name, String certificate){

        new Transport(certificate, name, companyService.getCompany());
    }

    //endregion

    //region RemoveFactory
    public static ConsoleView removeTransport(){

        return new RemoveTransportView(){};
    }

    public static String removeTransport(String certificate){
        try {
            Transport t = companyService.getTransportByCertificate(certificate);
            companyService.removeTransport(t);
            return "Transport successfully removed";
        }catch (Exception ex){
            return "Transport not exist";
        }
    }
    //endregion

    //region ChangeFactory
    public static ConsoleView changeTransport(){

        return new ChangeTransportView(){};
    }

    public static String changeTransport(String certificate, double speed, int capacity){

        try {
            Transport t = companyService.getTransportByCertificate(certificate);
            t.setSpeed(speed);
            t.setCapacity(capacity);
            return "Transport successfully changed";
        }catch (Exception ex){
            return "Transport not exist";
        }
    }

    //endregion
}
