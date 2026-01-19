package sigh;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *The Person class is an application that defines a soil object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class Person {
    //Initialize variables
    protected int x, y;
    private int age;
    public PImage image;
    protected PApplet app;
    //persons name
    private String name;

    /**
     * Constructor for Person object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     * @param name holds the objects name
     */
    public Person(PApplet app, String imagePath, int x, int y, String name) {
        this.app = app;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
        this.name = name;
    }

    
    /**
     * draws the object
     */
    public void draw(){ app.image(image, x, y); }

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
     * Getter: Returns name
     * @return name
     */
    public String getName(){
        return name;
    }


}