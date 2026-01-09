/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigh;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author amy
 */
public class Village_bg {
        private int x, y;
    private String name;
    private int age;
    public PImage image;
    private PApplet app;

    public Village_bg (PApplet app, String imagePath, int x, int y) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy){ x += dx; y += dy; }
    public void moveTo(int dx, int dy){ x = dx; y = dy; }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void draw(){ 
        app.image(image, x, y); 
    }

}
