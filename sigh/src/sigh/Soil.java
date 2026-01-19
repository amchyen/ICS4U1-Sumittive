package sigh;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *The soil class is an application that defines a soil object and has methods based on this item.
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class Soil extends items {
    
    /**
     * Constructor for Soil object
     * @param app processing sketch that this item belongs to
     * @param imagePath which image to use
     * @param x x cord
     * @param y y cord
     */
    public Soil(PApplet app, String imagePath, int x, int y) {
        super(app, imagePath, x, y);
    }
/**
 * Refills the soil in the game when this item is used.
 * @param game the MainSketch instance where soil will be refilled
 */
@Override
public void use(MainSketch game) {
    game.refillSoil();
}
}