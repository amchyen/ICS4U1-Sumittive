package sigh;

import processing.core.PApplet;
import processing.core.PImage;

public class MainSketch extends PApplet {
    PImage[] images;  
    int imgIndex = 0; 
    int numImages = 39;
    
    String ctxt = "txtU1(1)";
    private StartButton start;
    private StartButton start1;
    private int stage = 0;
    private chara character;
    private Person villager1;
    private Person villager2;
    private dialoge textbox;
    private dialoge gno;
    private dialoge currentgno;
    private Person title;
    private int currentBackground = 10;
    Village_bg[] backgrounds = new Village_bg[10];    
    
    
    void changeStage(int newStage) {
        stage = newStage;

        if (stage == 0) {
            surface.setSize(837, 522);
        } 
        else if (stage == 1) {
            surface.setSize(683, 480);
        }
}
    public void settings() {
           size(837, 522);
        }

    public void setup() {
        start = new StartButton(this, "images/startsign.png", 320, 210);
        start1 = new StartButton(this, "images/abtgamesign.png", 300, 320);

        images = new PImage[numImages];
        for (int i = 0; i < numImages; i++) {
            images[i] = loadImage("images/frame_" + i + ".png");
        }
        
        backgrounds[0] = new Village_bg(this, "images/row-1-column-1.png", 0, 0);
        backgrounds[1] = new Village_bg(this, "images/row-1-column-2.png", 0, 0);
        backgrounds[2] = new Village_bg(this, "images/row-1-column-3.png", 0, 0);
        backgrounds[3] = new Village_bg(this, "images/row-2-column-3.png", 0, 0);
        backgrounds[4] = new Village_bg(this, "images/row-2-column-2.png", 0, 0);
        backgrounds[5] = new Village_bg(this, "images/row-2-column-1.png", 0, 0);
        backgrounds[6] = new Village_bg(this, "images/row-3-column-1.png", 0, 0);
        backgrounds[7] = new Village_bg(this, "images/row-3-column-2.png", 0, 0);
        backgrounds[8] = new Village_bg(this, "images/row-3-column-3.png", 0, 0);
        backgrounds[9] = new Village_bg(this, "images/userhome.png", 61, 40);
        
        
        character = new chara(this, "images/character.png", 300,240);
        villager1 = new Person(this, "images/villager1.png", 450, 200);
        villager2 = new Person(this, "images/villager2.png", 28, 96);
        textbox = new dialoge(this, "images/" + ctxt+".png", 111,295);
        gno = new dialoge(this, "images/3.png", 395,5);
        currentgno = new dialoge(this, "images/4.png", 480,25);
        title = new Person(this, "images/title.png", 200,25);
    }

    public void draw() {
        background(0);
        if (stage == 0){
            image(images[imgIndex], 0, 0, width, height);
            if (frameCount % 10 == 0) {
                imgIndex++;
                if (imgIndex >= images.length) {
                    imgIndex = 0; 
                }
            }
            
            start.draw();
            start1.draw();
            title.draw();
            
                      
        }
        
        if (stage==1){
           backgrounds[currentBackground-1].draw();
           character.draw();
           
           textbox.draw();
           gno.draw();
           currentgno.draw();
           //System.out.println(character.x +","+ character.y);

           if (keyPressed) {
                if (keyCode == LEFT) {
                  character.x -= 3;
                }
                if (keyCode == RIGHT) {
                  character.x += 3;
                }
                if (keyCode == UP) {
                  character.y -= 3;
                }
                if (keyCode == DOWN) {
                  character.y += 3;
                }
                if (key == ' ') {
                    textbox.setImage("images/txtU1(2).png");
                }
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
               villager2.draw();
           }
           else if (currentBackground == 5) {
               updateBackground5();
               villager1.draw();
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
           else if (currentBackground == 9) {
               updateBackground9();
           }
           else if (currentBackground == 10) {
               updateEliasHome();
           }
           
        }
    
        // Mouse click detection
    public void mousePressed() {
        if (start1.isClicked(mouseX, mouseY)) {
            stage = 1;
            changeStage(1);
        }
    }
    
    
    void updateEliasHome() {
    if (character.x > 501 && character.x < 570 && character.y > 366) {
        currentBackground = 2;
        character.setPos(336, 369);
        System.out.println("hii");
    }
    else if (character.x > 581) {
        character.x = 581;
    }
    if (character.x < 60) {
        character.x = 60;
    }
    if (character.y > 366) {
        character.y = 366;
    }
    if (character.y < 117) {
        character.y = 117;
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
        
        if (character.x <=121)
            character.x =121;
        
    }

    void updateBackground2() {
        if (character.y < 334 && character.x > 160) {
            currentBackground = 10;
            character.setPos(523, 345);
        }
        if (character.x > 406) 
            character.x = 406;
        if (character.y > 420) 
            character.y = 420;
        if (character.y < 0)
            character.y = 0;
        if (character.x < 0)
            character.x = 0;
        if (character.y > 416 && character.x > 198 && character.x < 286) {
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
        if (character.x > 320 && character.x < 370 && character.y > 460) {
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
        if (character.x > 320 && character.x < 390 && character.y >= 0 && character.y < 30) {
            currentBackground = 6;
            character.setPos(330, 460);
        }
        if (character.y > 8 && character.y < 132 && character.x > 660) {
            currentBackground = 8;
            character.setPos(51, 60);
        }
        
        //if (character)
    }

    void updateBackground8() {
        if (character.x > 413) character.x = 413;
        if (character.y > 110 && character.x < 317) {
            if (character.y >= 120) character.x = 317;
            else character.y = 110;
        }
        if (character.x > 305 && character.x < 400 && character.y >= 0 && character.y < 16) {
            currentBackground = 5;
            character.setPos(350, 440);
        } 
        else if (character.x > 0 && character.x < 50 && character.y >= 33 && character.y < 125) {
            currentBackground = 7;
            character.setPos(660, 100);
        }
        
        if (character.y <= 0){
            character.y = 0;
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