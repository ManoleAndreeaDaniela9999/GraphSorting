package com.sort_app.factories;

import com.sort_app.frameComponents.*;

import java.awt.event.MouseAdapter;

public class MouseAdapterFactory {

    public static  MouseAdapter initCanvasMouseAdapter(boolean isSimple) {
        MouseAdapter ma;
        try {
            if(isSimple)
                ma = new SimpleGraphMouseAdapter();
            else
                ma = new OrientedGraphMouseAdapter();
        } catch (Exception e) {
            System.out.println("MouseAdapter initialization failed!");
            return null;
        }
        return ma;
    }

}
