package com.sort_app;

public class GrafFactory {

    public static Graf initGraf(boolean isSimple) {
        Graf graf;
        try {
            graf = new Graf(isSimple);
        } catch (Exception e) {
            System.out.println("Main menu initialization failed!");
            return null;
        }
        return graf;
    }
}
