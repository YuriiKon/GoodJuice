package com.bugyurii.WEB.Views.Home;

import com.bugyurii.WEB.Models.CompanyInfoModel;
import com.bugyurii.WEB.Views.ConsoleView;

public class CompanyInfoView extends ConsoleView {

    private CompanyInfoModel companyInfoModel;

    public CompanyInfoView(CompanyInfoModel companyInfoModel) {
        this.companyInfoModel = companyInfoModel;
        run();
    }

    public void run(){
        System.out.println(companyInfoModel.name +
                "Shops:\n" + companyInfoModel.shopsList +
                "\nFactories\n" + companyInfoModel.factoriesList +
                "\nTransport\n" + companyInfoModel.transportsList);
    }

}
