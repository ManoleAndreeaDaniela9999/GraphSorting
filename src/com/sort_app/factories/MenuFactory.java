package com.sort_app.factories;

import com.sort_app.MainMenu;

public class MenuFactory {
    public static MainMenu initGrafMainMenu() {
        MainMenu menu;
        try {
            menu = new MainMenu();
        } catch (Exception e) {
            System.out.println("Main menu initialization failed!");
            return null;
        }
        return menu;
    }
}
