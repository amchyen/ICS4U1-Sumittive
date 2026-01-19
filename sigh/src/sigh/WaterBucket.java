package sigh;

import processing.core.PApplet;

public class WaterBucket extends items {
    
    /**
     * Constructor for Person object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     */
    public WaterBucket(PApplet app, String imagePath, int x, int y) {
        super(app, imagePath, x, y);
    }
/**
 * Refills the water in the game when this item is used.
 * @param game the MainSketch instance where water will be refilled
 */
    @Override
    public void use(MainSketch game) {
        game.refillWater();
    }
}