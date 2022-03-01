package com.company;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.util.ArrayList;

public class Main extends JComponent implements KeyListener, ActionListener {

    static int WindowSizeX = 1400;

    static int WindowSizeY = 1400;

    Timer timer = new Timer(1, this);

    ArrayList<Planet> planets = new ArrayList<>();

    public static void main(String[] args) {

        Main main = new Main();

        JFrame jFrame = new JFrame("Солнечная система");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setSize(WindowSizeX,WindowSizeY);

        jFrame.setResizable(false);

        jFrame.setVisible(true);

        jFrame.add(main);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        repaint();

    }

    @Override

    public void keyTyped(KeyEvent e) {}

    @Override

    public void keyPressed(KeyEvent e) {}

    @Override

    public void keyReleased(KeyEvent e) {}

    public void AddPlanets(ArrayList<Planet> planets) {

        planets.add(new Planet(0,   0,    1392684,7000, "D:\\2.png"));              //солнце (в км.с; относительно расстояния от Земли до Солнц; в км; коэффициент; путь к файлу)

        planets.add(new Planet(47.87,   0.5,  4878,700, "D:\\3.png"));              //Меркурий

        planets.add(new Planet(35.02,   0.72,   6050,700, "D:\\4.png"));            //Венера

        planets.add(new Planet(29.78,   1,      12756,1000, "D:\\5.png"));          //Земля

        planets.add(new Planet(24.13,   1.52,   6780,250, "D:\\6.png"));            //Марс

        planets.add(new Planet(13.07,   5.2 /1.5,    142600,3000, "D:\\7.png"));    //Юпитер

        planets.add(new Planet(9.69,    9.54 /2,   120600,3000, "D:\\8.png"));      //Сатурн

        planets.add(new Planet(6.81,    19.18 /3,  51200,3000, "D:\\9.png"));       //Уран

        planets.add(new Planet(5.43,    30.06 /3.75,  49500,3000, "D:\\10.png"));   //Нептун

    }

    public void drawTheSolarSystem(Graphics g) {

        int w = getWidth();

        int h = getHeight();

        if (planets.size() < 9) {

            AddPlanets(planets);

        }
        Graphics2D g2 = (Graphics2D) g;

        Image imageBG = new ImageIcon("D:\\1.jpg").getImage();

        g2.drawImage(imageBG, 0, 0,WindowSizeX,WindowSizeY, null);

        for (int i = planets.size() - 1; i >=0; i--) {

            g2.drawImage(planets.get(i).getPicture(), w / 2 + (int)(planets.get(i).getRadiusOfMovement() * Math.cos(planets.get(i).getRad())) - planets.get(i).errorRate(), h / 2 + (int)(planets.get(i).getRadiusOfMovement() * Math.sin(planets.get(i).getRad())) - planets.get(i).errorRate(), planets.get(i).getPlanetDiameter(), planets.get(i).getPlanetDiameter(), null);

        }

        for (int i = 1; i < planets.size(); i++) {

            planets.get(i).plusRad();

        }

        timer.start();

    }

    @Override

    public void paintComponent(Graphics g){

        super.paintComponents(g);

        drawTheSolarSystem(g);

    }
}
