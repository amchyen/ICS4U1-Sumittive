/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sigh;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *The chara class is an application that defines a chara object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class chara extends Person{
    
    /**
     * Constructor for Person object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     * @param name holds the objects name
     */    public chara (PApplet app, String imagePath, int x, int y, String name) {
        super(app,imagePath,x,y,name);
    }
    /**
     * Sets a new position for character
     * @param x new x cord
     * @param y new x cord
     */
    public void setPos(int x, int y){
        super.x=x;
        super.y=y;
    }
    /**
     * Sets a new image to object
     * @param path new image path
     */
        public void setImage(String path){
        super.image = super.app.loadImage(path);
    }
        
        public String getName(){
            return "user";
        }
}