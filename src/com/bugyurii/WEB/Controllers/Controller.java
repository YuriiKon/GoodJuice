package com.bugyurii.WEB.Controllers;

import com.bugyurii.WEB.Views.ConsoleView;

public abstract class Controller {
    public static ConsoleView view(){ return new ConsoleView(){}; }
}
