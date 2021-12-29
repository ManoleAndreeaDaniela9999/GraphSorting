package com.sort_app.factories;

import com.sort_app.frameComponents.GrafCanvas;
import com.sort_app.frameComponents.OrientedGrafCanvas;
import com.sort_app.frameComponents.SimpleGrafCanvas;

public class GrafCanvasFactory {

    public static GrafCanvas initGrafCanvas(boolean isSimple) {
        GrafCanvas grafCanvas;
        try {
            if(isSimple)
            grafCanvas = new SimpleGrafCanvas();
            else
                grafCanvas = new OrientedGrafCanvas();
        } catch (Exception e) {
            System.out.println("Canvas initialization failed!");
            return null;
        }
        return grafCanvas;
    }
}
