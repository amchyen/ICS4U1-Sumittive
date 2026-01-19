package sigh;

import processing.core.PApplet;


/**
 *The seeds class is an application that defines a seeds object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class seeds extends items {
    //Initialize variables
    String seedType = "";
    private WaterBucket bucket; 
    private Soil soil;             
 /**
  * Constructor for seeds object
  * @param app processing sketch that this item belongs to
  * @param imagePath which image to use
  * @param x x cord
  * @param y y cord
  * @param bucket which water bucket object to use
  * @param soil which soil object to use
  */      
    public seeds(PApplet app, String imagePath, int x, int y, WaterBucket bucket, Soil soil) {
        super(app, imagePath, x, y);
        this.bucket = bucket;
        this.soil = soil;
        this.seedType = seedType;
    }
 /**
  * Constructor for seeds object
  * @param app processing sketch that this item belongs to
  * @param imagePath which image to use
  * @param x x cord
  * @param y y cord
  * @param bucket which water bucket object to use
  * @param soil which soil object to use
  */      
    public seeds(PApplet app, String imagePath, int x, int y) {
        super(app, imagePath, x, y);

    }
/**
 * Plants seed in the game when this item is used.
 * @param game the MainSketch instance where seed will be planted
 */
    @Override
    public void use(MainSketch game) {
        game.startPlanting();
    }
    
    /**
     * Setter: sets the object image to a new one
     * @param path image name and folder
     */
    public void setImage(String path){
        this.image = app.loadImage(path);
    }
    /**
     * Uses the water or soil
     * @param game which game object we are in 
     * @param itemType what item do you wanna use 
     */
    public void useItem(MainSketch game, String itemType) {
        if ("water".equals(itemType) && bucket != null) {
            bucket.use(game);
        } else if ("soil".equals(itemType) && soil != null) {
            soil.use(game);
        }
    }
}

