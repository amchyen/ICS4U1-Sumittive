package sigh;

import processing.core.PApplet;
import processing.core.PImage;


/**
 *The items class is an application that defines a items object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class items {
    //Initialize Variables
    //x and y cords
    private int x, y;
    //graphic associated to object
    public PImage image;
    protected PApplet app;

    /**
     * Constructor for Person object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     */
    public items(PApplet app, String imagePath, int x, int y) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
    }
    /**
     * draws the object
     */
    public void draw() {
        app.image(image, x, y);
    }
    
    /**
     * Mouse Collision 
     * @param mouseX mouses x cord
     * @param mouseY mouses y cord
     * @return true if the mouse click is in the circular area of the object’s image, and false otherwise.
     */
    public boolean isClicked(int mouseX, int mouseY){
        float centerX = x + image.width / 2f;
        float centerY = y + image.height / 2f;
        float radius = image.width / 2f;
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < radius;
    }
    /**
    * Use items in game
    * @param game the MainSketch instance where item is used
    */
    public void use(MainSketch game) {
        System.out.println("use, items");
    }
}