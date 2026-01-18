package sigh;

import processing.core.PApplet;
import processing.core.PImage;

public class MainSketch extends PApplet {
    PImage[] images;  
    Village_bg plantbg;
    int imgIndex = 0; 
    int numImages = 39;
    
    String ctxt = "txtU1(1)";
    private StartButton start;
    private StartButton start1;
    private StartButton map;
    
    private int stage = 0;
    private chara character;
    private Person micah;
    private Person kiyomi;
    private Person micky;
    private Person catherine;
    
    private dialoge textbox;
    private dialoge finaltxtbox;
    private dialoge gno;
    private dialoge currentgno;
    private Person title;
    private int currentBackground = 1;
    Village_bg[] backgrounds = new Village_bg[12];
    int row_dia = 0;
    int collom_dia = 0;
    
    String [][] UserdiaArray = new String [2][];
    String [][] micahdiaArray = new String [3][];
    String[][] kiyomidiaArray = new String[1][];
    String[][] mickydiaArray = new String[1][];
    String[][] catherinediaArray = new String[1][];
    String[] kingdiaArray = new String [3];
    String[] WindiaArray = new String [6];
    String[] losediaArray = new String [5];
    
    dialoge Win_message;
    dialoge loser_mess;



    boolean king_talking = false;
    boolean user_talking = true;
    boolean micky_talking = false;
    boolean suni_talking = false;
    boolean kiyomi_talking = false;
    boolean micah_talking = false;
    boolean cat_talking = false;
    boolean show_seed =false;
    boolean seedPlanted = false;
    boolean showPlantPopup = false;
    boolean seedChosen = false;
    
    items plantPOPup;
    items exit;
    items waterBucket;
    items soil;
    
   boolean spacelock = false;
   boolean maplock = false;
   boolean start_userdia = true;
   boolean map_open = false;
   
    boolean kiyomi_choice = false;  
    int kiyomi_row = 0;
    int king_row = 0;
   
   int villagers_talked2 = 0;
   
   StartButton chillseed;
   StartButton peachseed;
   StartButton radishseed;
   StartButton grapeseed;
   
   seeds seed_select;
   float waterLevel = 100;
    float soilLevel = 100;
    int stage4StartTime;
    //int fiveMinutes = 5 * 60 * 1000; 
    int fiveMinutes = 30 * 1000; 

    boolean waterCollected = false;
    boolean soilCollected = false
           ;
    boolean soilPressed = false;
    boolean waterPressed = false;
   
   
   
   
   
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
        map = new StartButton(this, "images/map.png", 50, 30);
        plantbg = new Village_bg(this, "images/graden.png", 0, 0);

        
        UserdiaArray[0] = new String[2];
        UserdiaArray[1] = new String [3];
        UserdiaArray[0][0] = "images/txtU1(1).png";
        UserdiaArray[0][1] = "images/txtU1(2).png";
        UserdiaArray[1][0] = "images/txtU2(1).png";
        UserdiaArray[1][1] = "images/txtU2(2).png";
        UserdiaArray[1][2] = "images/txtU2(3).png";

        
        kiyomidiaArray[0] = new String[4];
        kiyomidiaArray[0][0] = "images/txtK1(1).png";
        kiyomidiaArray[0][1] = "images/txtK1(2).png";
        kiyomidiaArray[0][2] = "images/txtK1(3).png"; 
        kiyomidiaArray[0][3] = "images/txtK1(4).png";
        
        micahdiaArray[0] = new String[3];
        micahdiaArray[0][0] = "images/txtM1(1).png";
        micahdiaArray[0][1] = "images/txtM1(2).png";
        micahdiaArray[0][2] = "images/txtM1(3).png";
        
        //if time make micky stand when clicked 
        mickydiaArray[0] = new String[4];
        mickydiaArray[0][0] = "images/txtMy1(1).png";
        mickydiaArray[0][1] = "images/txtMy1(2).png";
        mickydiaArray[0][2] = "images/txtMy1(3).png";
        mickydiaArray[0][3] = "images/txtMy1(4).png";

        catherinediaArray[0] = new String [2];
        catherinediaArray[0][0] = "images/txtC2(1).png";
        catherinediaArray[0][1] = "images/txtC2(2).png";
        
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
        backgrounds[11] = new Village_bg(this, "images/king.png", 0,0);
        
        
        character = new chara(this, "images/character.png", 300,240);
        micah = new Person(this, "images/villager1.png", 450, 200);
        kiyomi = new Person(this, "images/villager2.png", 28, 96);
        micky = new Person(this, "images/villager3.png", 290,430);
        catherine = new Person(this, "images/catherine.png" , 420,330);
        
        chillseed = new StartButton(this, "images/chillseed.png", 50,100);
        peachseed = new StartButton(this, "images/peachseed.png", 140,100);
        radishseed = new StartButton(this, "images/radishseed.png", 250,100);
        grapeseed = new StartButton(this, "images/grapeseed.png", 400,100);
        seed_select = new seeds(this, "images/sel_chill.png", 20, 420);

        finaltxtbox = new dialoge(this, "images/txtK1(1).png", 0,295);  
        textbox = new dialoge(this, "images/" + ctxt+".png", 111,295);
        gno = new dialoge(this, "images/3.png", 3,5);
        currentgno = new dialoge(this, "images/gno1.png", 5,25);
        title = new Person(this, "images/title.png", 200,25);
        
        //gardening stuff
        plantPOPup = new items(this, "images/yOn.png", 100, 240-91);
        exit = new items(this, "images/exit.png", 5, 5);
        waterBucket = new items (this, "images/waterbucket.png", 14, 360);
        soil = new items (this, "images/soil.png", 20,420);
        
        
        
        kingdiaArray[0] = "txtK1(1)";
        kingdiaArray[1] = "txtK1(2)";
        kingdiaArray[2] = "txtK1(3)";
        
        WindiaArray[0] = "txtU3G(1)";
        WindiaArray[1] = "txtU3G(2)";
        WindiaArray[2] = "txtU1K(1)";
        WindiaArray[3] = "txtU1K(2)";
        WindiaArray[4] = "txtU1K(3)";
        WindiaArray[5] = "txtU1K(4)";
        
        losediaArray[0] = "txtU3B(1)";
        losediaArray[0] = "txtU3B(2)";
        losediaArray[0] = "txtK1B(1)";
        losediaArray[0] = "txtU3B(3)";
        losediaArray[0] = "txtK1B(2)";

    
    dialoge Win_message = new dialoge (this, "images/WINN.png", 20,20);;
    dialoge loser_mess = new dialoge (this, "images/lose.png", 20,20);;
    }

    public void draw() {
    if (keyPressed && key == 'a' && !maplock) {
        maplock = true;
        map_open = !map_open;
    }

    if (!keyPressed || key != 'a') {
        maplock = false;
    }

    if (currentBackground == 11 && keyPressed && (key == 'e' || key == 'E')) {
    currentBackground = 2; 
}
    if (villagers_talked2 >= 3)
            stage =2;
        if (stage == 2){
           currentgno.setImage("images/gno2.png");
           villagers_talked2 = 0;
        }
       
        
        
        background(0);
        if (currentBackground == 11){
            plantbg.draw();
            exit.draw();
            gardening();

           }
             
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
        
        if (stage!=0 && currentBackground != 11 && currentBackground !=12){
           backgrounds[currentBackground-1].draw();
           character.draw();
           gno.draw();
           currentgno.draw();
           //System.out.println(character.x +","+ character.y);

           if (keyPressed) {
               if (currentBackground != 12){
                if (keyCode == LEFT) {
                  character.x -= 3;
                }
                if (keyCode == RIGHT) {
                  character.x += 3;
                }
                if (keyCode == UP && currentBackground != 12) {
                  character.y -= 3;
                }
                if (keyCode == DOWN && currentBackground != 12) {
                  character.y += 3;
                }
               }
               else {
                if (keyCode == RIGHT && character.x < 297 && !king_talking) {
                  character.x += 2;
                if (keyCode == RIGHT && character.x > 297) {
                    king_talking = true;
                    king_row = 0;
                    
                }
               }
               }
               
                if (key == ' '){
                    if (user_talking && !spacelock){
                        if (start_userdia || stage == 5){
                    spacelock=true;
                    row_dia++;
                    if (row_dia != UserdiaArray[collom_dia].length)
                        textbox.setImage(UserdiaArray[collom_dia][row_dia]);

                    if (row_dia >= UserdiaArray[collom_dia].length) {
                        user_talking = false;
                        row_dia = 0;
                        start_userdia = false;
                        collom_dia++;
                }   
            }
                    }
                    if (micah_talking && !spacelock){
                     spacelock=true;
                    row_dia++;
                    if (row_dia != micahdiaArray[0].length)
                        textbox.setImage(micahdiaArray[0][row_dia]);

                    if (row_dia >= micahdiaArray[0].length) {
                        micah_talking = false;
                        row_dia = 0;
                }   
                    }

           }
                if (key == ' ' && kiyomi_talking && !spacelock && !kiyomi_choice) {
                spacelock = true;
                kiyomi_row++;

                if (kiyomi_row < kiyomidiaArray[0].length-2) {
                    textbox.setImage(kiyomidiaArray[0][kiyomi_row]);

                    if (kiyomi_row == 1) {
                        kiyomi_choice = true;
                    }
                } 
                else {
                    kiyomi_talking = false;
                    kiyomi_row = 0;
                    kiyomi_choice = false;
                }
            }

            if (key == ' ' && micky_talking && !spacelock) {
                spacelock = true;
                row_dia++;

                if (row_dia != mickydiaArray[0].length)
                        textbox.setImage(mickydiaArray[0][row_dia]);

                    if (row_dia >= mickydiaArray[0].length) {
                        micky_talking = false;
                        row_dia = 0;
                }   
                    }
            
            
            if (key == ' ' && cat_talking && !spacelock) {
                spacelock = true;
                row_dia++;

                if (row_dia != catherinediaArray[0].length)
                        textbox.setImage(catherinediaArray[0][row_dia]);

                    if (row_dia >= catherinediaArray[0].length) {
                        cat_talking = false;
                        row_dia = 0;
                        show_seed = false;
                        stage = 3;
                        currentgno.setImage("images/gno3.png");

                        

                }   
                    }
               


           }
        if (!keyPressed || key != ' ') {
            spacelock = false;
    }
 
           if (currentBackground == 1) {
               updateBackground1();
               micky.draw();
           }
           else if (currentBackground == 2) {
               updateBackground2();
           }
           else if (currentBackground == 3) {
               //updateBackground3();
           }
           else if (currentBackground == 4) {
               updateBackground4();
               kiyomi.draw();
           }
           else if (currentBackground == 5) {
               updateBackground5();
               micah.draw();
           }
           else if (currentBackground == 6) {
               updateBackground6();
           }
           else if (currentBackground == 7) {
               updateBackground7();
           }
           else if (currentBackground == 8) {
               updateBackground8();
               if (stage ==2)
                catherine.draw();
           }
           else if (currentBackground == 9) {
               updateBackground9();
           }
           else if (currentBackground == 10) {
               updateEliasHome();
           }
           
           
         if (cat_talking || user_talking || kiyomi_talking || micah_talking || micky_talking)
            textbox.draw();
           
        }
        
                if (map_open){
            map.draw();
        }
                
                
                
       if (show_seed){
           chillseed.draw();
           peachseed.draw();
           radishseed.draw();
           grapeseed.draw();
           
       }
       
 
if (stage == 4) {
        // 1. DRAIN LOGIC: Keep the levels updating
        waterLevel = constrain(waterLevel - 0.01f, 0, 100);
        soilLevel = constrain(soilLevel - 0.01f, 0, 100);
        drawSurvivalBars();
        if (currentBackground != 11) {
            if (waterCollected) {
                fill(0, 150, 255);
                rect(20, height - 40, 20, 20); 
                fill(255);
                textSize(10);
                text("WATER", 15, height - 45);
            }
            if (soilCollected) {
                fill(139, 69, 19);
                rect(60, height - 40, 20, 20); 
                fill(255);
                text("SOIL", 60, height - 45);
            }
        }

        // 4. GARDEN SPECIFIC: Show the clickable items only when in the Garden
        if (currentBackground == 11) {
            if (waterCollected) {
                waterBucket.draw(); // Draws the actual bucket image in the garden
            }
            if (soilCollected) {
                soil.draw(); // Draws the actual soil image in the garden
            }
            
            if (showPlantPopup) {
                plantPOPup.draw();
            }
        }

        // 5. TIMER: Transitions to stage 5
        if (millis() - stage4StartTime >= fiveMinutes) {
            stage = 5;
            currentgno.setImage("images/gno5.png");
            user_talking = true;
            textbox.setImage(UserdiaArray[1][0]);
        }
    }




    if (currentBackground == 12 && king_talking){
        finaltxtbox.draw();
    }
}
    
    
        // Mouse click detection
    public void mousePressed() {
        if (cat_talking){
        if (chillseed.isClicked(mouseX, mouseY)) {
            seed_select.setImage("images/sel_chill.png");
            seedChosen = true;
            System.out.print("chill");
        }
        else if (peachseed.isClicked(mouseX, mouseY)) {
            seed_select.setImage("images/sel_peach.png");
            seedChosen = true;
            System.out.print("peach");
        }
        else if (radishseed.isClicked(mouseX, mouseY)) {
            seed_select.setImage("images/sel_radish.png");
            seedChosen = true;
            System.out.print("radish");

        }
        else if (grapeseed.isClicked(mouseX, mouseY)) {
            seed_select.setImage("images/sel_grape.png");
            seedChosen = true;
            System.out.print("grape");
        }
        }
        if (start1.isClicked(mouseX, mouseY) && stage == 0) {
            stage = 1;
            changeStage(1);
}
            
        if (micah.isClicked(mouseX, mouseY)){
            villagers_talked2 ++;
            micah_talking = true;
            user_talking = false;
            
            row_dia = 0;
            textbox.setImage(micahdiaArray[0][0]);

        }
        
        if (micky.isClicked(mouseX, mouseY)){
            villagers_talked2 ++;
            micky_talking = true;
            user_talking = false;
            
            row_dia = 0;
            textbox.setImage(mickydiaArray[0][0]);

        }
        
        
        if (catherine.isClicked(mouseX, mouseY)){
           cat_talking = true;
           
            row_dia = 0;
           textbox.setImage(catherinediaArray[0][0]);
           if (show_seed)
               show_seed = !show_seed;
           else
            show_seed = true; 
        }


        if (stage == 1 && kiyomi.isClicked(mouseX, mouseY) && !kiyomi_talking) {
        kiyomi_talking = true;
        user_talking = false;
        villagers_talked2++;

        kiyomi_row = 0;
        kiyomi_choice = false;
        textbox.setImage(kiyomidiaArray[0][0]);
    }
        if (kiyomi_talking && kiyomi_choice) {
            if (mouseY < 420) {
                textbox.setImage(kiyomidiaArray[0][2]);
            }
            else {
                textbox.setImage(kiyomidiaArray[0][3]);
            }

    kiyomi_choice = false; 
    

    

}
        if (currentBackground == 11 && !seedPlanted) {
        if (seed_select.isClicked(mouseX, mouseY)) {
            showPlantPopup = true;
        }

        else if (showPlantPopup) {
            if (mouseX < 480 / 2) {
                seedPlanted = true;
                showPlantPopup = false;
                stage = 4;
                currentgno.setImage("images/gno4.png");
                stage4StartTime = millis(); 
            }

            else {
                showPlantPopup = false;
            }
    }
}    
        
if (stage == 4) {
        // COLLECTION: Background 5 (Well)
        if (currentBackground == 5 && !waterCollected) {
            if (mouseX > 309 && mouseY < 121) {
                waterCollected = true;
                System.out.println("Water Bucket Collected!");
            }
        }

        // COLLECTION: Background 7 (Soil Patch)
        if (currentBackground == 6 && !soilCollected) {
            if (mouseX > 393 && mouseY > 256) {
                soilCollected = true;
                showPlantPopup = false;
                soilPressed = false;
                System.out.println("Soil Collected!");
            }
        }

        // USAGE: Background 11 (Garden)
        if (currentBackground == 11) {
            // Open popup if player clicks plant AND has an item
            if (!showPlantPopup && waterBucket.isClicked(mouseX, mouseY)) {
                if (waterCollected) {
                    showPlantPopup = true;
                    waterPressed = true;
                    
                
                }}
            if (!showPlantPopup && soil.isClicked(mouseX, mouseY)) {
                 if (soilCollected){
                    showPlantPopup = true;
                    soilPressed = true;}
            }
            // Handle the Yes/No click on the shared popup
            else if (showPlantPopup) {
                if (mouseX < 480 / 2) { // Clicked "YES"
                    if (waterCollected && waterPressed) {
                        waterLevel = 100;
                        waterCollected = false;
                        waterPressed = false;
                    } else if (soilCollected && soilPressed) {
                        soilLevel = 100;
                        soilCollected = false; // Item consumed
                        soilPressed = false;
                    }
                    showPlantPopup = false;
                } else { // Clicked "NO"
                    showPlantPopup = false;
                }
            }
        }
    }

}
    
    
    
    
    
    void updateEliasHome() {
    if (character.x > 501 && character.x < 570 && character.y > 366) {
        currentBackground = 2;
        character.setPos(336, 369);
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
            character.setPos(430, 82);
        }
        
        if (character.x <=121)
            character.x =121;
        if (character.y< 0  && stage == 5){
            currentBackground = 12;
            character.setPos(0,360);
            character.setImage("images/chara_right.png");
        }
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
        
        if (character.x>-1 && character.x<42 && character.y<256){
            currentBackground = 11;
            character.setPos(character.x,263);
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
        else if (character.x > 678 && character.y > 150 && character.y < 248) {
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
    
void gardening(){
    if (!seedPlanted) { //hasnt been planted
        seed_select.draw();}
    if (showPlantPopup) {
        plantPOPup.draw();
    
        }
    }
void drawSurvivalBars() {
    // Position settings
    int barWidth = 100;
    int barHeight = 15;
    int xPos = width - 120;
    
    // Water Bar
    fill(50); // Dark grey background for the bar
    rect(xPos, 30, barWidth, barHeight); 
    fill(0, 150, 255); // Blue
    rect(xPos, 30, waterLevel, barHeight); 
    fill(255);
    textSize(12);
    text("WATER", xPos, 25);

    // Soil Bar
    fill(50); 
    rect(xPos, 70, barWidth, barHeight); 
    fill(139, 69, 19); // Brown
    rect(xPos, 70, soilLevel, barHeight); 
    fill(255);
    text("SOIL HEALTH", xPos, 65);
}}