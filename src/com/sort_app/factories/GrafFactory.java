package com.sort_app.factories;

import com.sort_app.Graf;

public class GrafFactory {

    public static Graf initGraf(boolean isSimple) {
        Graf graf;
        try {
            graf = new Graf(isSimple);
        } catch (Exception e) {
            System.out.println("GraphFrame initialization failed!");
            return null;
        }
        return graf;
    }
}
