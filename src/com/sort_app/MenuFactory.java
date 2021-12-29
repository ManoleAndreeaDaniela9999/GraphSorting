package com.sort_app;

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
