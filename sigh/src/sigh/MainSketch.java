package sigh;

import processing.core.PApplet;
import processing.core.PImage;

public class MainSketch extends PApplet {
    PImage[] images;  // array to hold images
    int imgIndex = 0; // current image
    int numImages = 39; // total number of images
    private StartButton start;
    private StartButton start1;
    private int stage = 0;
    private chara character;
    private int currentBackground =1;
    Village_bg[] backgrounds = new Village_bg[10];    
    
    
    void changeStage(int newStage) {
        stage = newStage;

        if (stage == 0) {
            surface.setSize(837, 522);
        } 
        else if (stage == 1) {
            surface.setSize(682, 479);
        }
}
    public void settings() {
           size(837, 522);
        }

    public void setup() {
        start = new StartButton(this, "images/upsign (4).png", 320, 210);
        start1 = new StartButton(this, "images/upsign (3).png", 300, 320);

        images = new PImage[numImages];
        for (int i = 0; i < numImages; i++) {
            images[i] = loadImage("images/frame_" + i + ".png");
        }
        
        backgrounds[0] = new Village_bg(this, "images/row-1-column-1.png", 0, 0);
        backgrounds[1] = new Village_bg(this, "images/row-1-column-2.png", 0, 0);
        backgrounds[2] = new Village_bg(this, "images/row-1-column-3.png", 0, 0);
        backgrounds[3] = new Village_bg(this, "images/row-2-column-1.png", 0, 0);
        backgrounds[4] = new Village_bg(this, "images/row-2-column-2.png", 0, 0);
        backgrounds[5] = new Village_bg(this, "images/row-2-column-3.png", 0, 0);
        backgrounds[6] = new Village_bg(this, "images/row-2-column-3.png", 0, 0);
        backgrounds[7] = new Village_bg(this, "images/row-3-column-1.png", 0, 0);
        backgrounds[8] = new Village_bg(this, "images/row-3-column-2.png", 0, 0);
        backgrounds[9] = new Village_bg(this, "images/row-3-column-3.png", 0, 0);
        
        character = new chara(this, "images/char.png", 22,33);


    }

    public void draw() {
        background(0); // clears previous frame
        if (stage == 0){
            image(images[imgIndex], 0, 0, width, height); // draw current image

            // Change image every 10 frames
            if (frameCount % 10 == 0) {
                imgIndex++;
                if (imgIndex >= images.length) {
                    imgIndex = 0; // loop back to first image
                }
            }
            
            start.draw();
            start1.draw();
            
        }
        
        if (stage==1){
           backgrounds[currentBackground-1].draw();
           character.draw();
           if (keyPressed) {
                if (keyCode == LEFT) {
                  character.x -= 2;
                }
                if (keyCode == RIGHT) {
                  character.x += 2;
                }
                if (keyCode == UP) {
                  character.y -= 2;
                }
                if (keyCode == DOWN) {
                  character.y += 2;
                }
              }
           if (currentBackground == 1) {
               updateBackground1();
           }
           else if (currentBackground == 2) {
               updateBackground2();
           }
           else if (currentBackground == 3) {
               //updateBackground3();
           }
           else if (currentBackground == 4) {
               updateBackground4();
           }
           else if (currentBackground == 5) {
               updateBackground5();
           }
           else if (currentBackground == 6) {
               updateBackground6();
           }
           else if (currentBackground == 7) {
               updateBackground7();
           }
           else if (currentBackground == 8) {
               updateBackground8();
           }
           
           
           
        }
    }
        // Mouse click detection
    public void mousePressed() {
        if (start1.isClicked(mouseX, mouseY)) {
            stage = 1;
            changeStage(1);
        }
    }
    
     void updateBackground1() {
        if (character.x < 330 && character.y < 404){
            
        }
        if (character.y > 460 && character.x > 390 && character.x < 480) {
            currentBackground = 6;
            System.out.println("heheh");
            character.setPos(430, 82);
        }
    }

    void updateBackground2() {
        if (character.y < 334 && character.x > 160) {
            character.setPos(378, 360);
        }
        if (character.x > 400) character.x = 400;
        if (character.y < 196) character.y = 196;
        if (character.y > 460 && character.x > 202 && character.x < 290) {
            currentBackground = 5;
            character.setPos(234, 52);
        }
    }

    void updateBackground4() {
        if (character.x > 292) character.x = 292;
        if (character.y > 168 && character.y < 248 && character.x < 50) {
            currentBackground = 5;
            character.setPos(634, 204);
        }
        if (character.x > 85 && character.x < 140 && character.y > 460) {
            currentBackground = 9;
            character.setPos(112, 42);
        }
        if (character.x > 68 && character.x < 228 && character.y < 42) {
            character.setPos(356, 356);
        }
     
    }

    void updateBackground5() {
        if (character.y < 188 && character.x > 486) {
            if (character.x < 494) character.x = 486;
            else character.y = 188;
        }
        if (character.y > 232 && character.x < 317) {
            if (character.y >= 240) character.x = 317;
            else character.y = 232;
        }
        if (character.x > 180 && character.x < 300 && character.y >= 0 && character.y < 50) {
            currentBackground = 2;
            character.setPos(234, 418);
        } 
        else if (character.x > 314 && character.x < 414 && character.y > 450 && character.y < 480) {
            currentBackground = 8;
            character.setPos(350, 80);
        } 
        else if (character.x > 678 && character.y > 168 && character.y < 248) {
            currentBackground = 4;
            character.setPos(64, 210);
        }
    }

    void updateBackground6() {
        if (character.x < 266) character.x = 266;
        if (character.x > 562) character.x = 562;
        if (character.x > 340 && character.x < 390 && character.y > 460) {
            currentBackground = 7;
            character.setPos(366, 100);
        }
        if (character.x > 394 && character.x < 490 && character.y < 50) {
            currentBackground = 1;
            character.setPos(430, 460);
        }
    }

    void updateBackground7() {
        if (character.x < 274) character.x = 274;
        if (character.y > 144) character.y = 144;
        if (character.x > 320 && character.x < 390 && character.y >= 0 && character.y < 50) {
            currentBackground = 6;
            character.setPos(366, 460);
        }
        if (character.y > 8 && character.y < 132 && character.x > 660) {
            currentBackground = 8;
            character.setPos(51, 60);
        }
    }

    void updateBackground8() {
        if (character.x > 413) character.x = 413;
        if (character.y > 110 && character.x < 317) {
            if (character.y >= 120) character.x = 317;
            else character.y = 110;
        }
        if (character.x > 305 && character.x < 400 && character.y >= 0 && character.y < 50) {
            currentBackground = 5;
            character.setPos(350, 440);
        } 
        else if (character.x > 0 && character.x < 50 && character.y >= 38 && character.y < 120) {
            currentBackground = 7;
            character.setPos(660, 100);
        }

   
    }

    void updateBackground9() {
        if (character.y > 200) character.y = 200;
        if (character.x > 393) character.x = 393;
        if (character.x > 88 && character.x < 148 && character.y < 30) {
            currentBackground = 4;
            character.setPos(124, 460);
        }
    }
}