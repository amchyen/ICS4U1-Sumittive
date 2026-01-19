/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigh;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *The Village_bg class is an application that defines a Village_bg object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class Village_bg {
    //Initialize Variables
    //x and y cords
    private int x, y;
    //graphic associated to object
    public PImage image;
    private PApplet app;
    
    /**
     * Constructor for VIllage_bg object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     */    
    public Village_bg (PApplet app, String imagePath, int x, int y) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
    }
    
        /**
     * Constructor for Village_bg object, sets cords to (0,0)
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     */
    public Village_bg (PApplet app, String imagePath) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = 0;
        this.y = 0;
    }
    
        /**
     * draws the object
     */
    public void draw(){ 
        app.image(image, x, y); 
    }
    


}
