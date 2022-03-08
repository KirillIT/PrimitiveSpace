package com.company;

import javax.swing.*;

import java.awt.*;

public class Planet {

    private static final int distance = 50;

    private final double speed;

    private final double radiusOfMovement;

    private final int planetDiameter;

    private final Image im;

    private final int k;

    private double rad = 0;

    public Planet(double speed, double radiusOfMovement, int planetDiameter,int k, String path){

        this.k = k;

        im = new ImageIcon(path).getImage();

        this.speed = speed;

        this.radiusOfMovement = radiusOfMovement;

        this.planetDiameter = planetDiameter;

    }

    public Image getPicture(){

        return im;

    }

    public double getRad(){

        return rad;

    }

    public void plusRad(){

        rad += speed/radiusOfMovement * 0.0008;

    }

    public int getRadiusOfMovement(){

        return (int)(radiusOfMovement * distance);

    }

    public int errorRate(){

        return planetDiameter / k / 2;

    }

    public int getPlanetDiameter(){

        return planetDiameter / k;

    }
}