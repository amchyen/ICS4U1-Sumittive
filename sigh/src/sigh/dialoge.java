package sigh;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *The dialoge class is an application that defines a dialoge object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class dialoge {
    //Initialize Variables
    //x and y cords
    private int x, y;
    //graphic associated to object
    public PImage image;
    private PApplet app;

    /**
     * Constructor for Person object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     */
    public dialoge (PApplet app, String imagePath, int x, int y) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
    }
    /**
     * draws the object
     */
    public void draw(){ 
        app.image(image, x, y); 
    }
    
    public void setImage(String path){
        this.image = app.loadImage(path);
    }
  

}