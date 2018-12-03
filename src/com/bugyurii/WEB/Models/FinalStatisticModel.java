package com.bugyurii.WEB.Models;

public class FinalStatisticModel {

    public int day;
    public int income;
    public String name;
    public int shopsCount;
    public int factoriesCount;
    public int transportsCount;

    public FinalStatisticModel(int day, int income, String name, int shopsCount, int factoriesCount, int transportsCount) {
        this.day = day;
        this.income = income;
        this.name = name;
        this.shopsCount = shopsCount;
        this.factoriesCount = factoriesCount;
        this.transportsCount = transportsCount;
    }
}
