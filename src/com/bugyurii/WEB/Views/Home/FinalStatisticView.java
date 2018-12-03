package com.bugyurii.WEB.Views.Home;

import com.bugyurii.WEB.Models.FinalStatisticModel;
import com.bugyurii.WEB.Views.ConsoleView;

public class FinalStatisticView extends ConsoleView {

    private FinalStatisticModel finalStatisticModel;

    public FinalStatisticView(FinalStatisticModel finalStatisticModel) {
        this.finalStatisticModel = finalStatisticModel;
        run();
    }

    public void run(){
        System.out.println("Rest In Pepperoni");
        gap();
        System.out.println("'" + finalStatisticModel.name + "'");
        System.out.println(finalStatisticModel.day + " days");
        System.out.println("Income " + finalStatisticModel.income  + " \u20BD");
        gap();
        System.out.println("Shops : " + finalStatisticModel.shopsCount);
        System.out.println("Factories : " + finalStatisticModel.factoriesCount);
        System.out.println("Cars : " + finalStatisticModel.transportsCount);
        gap();
        System.exit(1);
    }
}
