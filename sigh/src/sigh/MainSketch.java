package sigh;

import processing.core.PApplet;
import processing.core.PImage;

public class MainSketch extends PApplet {
    PImage[] images;  // array to hold images
    int imgIndex = 0; // current image
    int numImages = 39; // total number of images

    public void settings() {
        size(837, 522);
    }

    public void setup() {
        images = new PImage[numImages];
        for (int i = 0; i < numImages; i++) {
            images[i] = loadImage("images/frame_" + i + ".png");
        }
    }

    public void draw() {
        background(0); // clears previous frame
        image(images[imgIndex], 0, 0, width, height); // draw current image

        // Change image every 10 frames
        if (frameCount % 10 == 0) {
            imgIndex++;
            if (imgIndex >= images.length) {
                imgIndex = 0; // loop back to first image
            }
        }
    }
}