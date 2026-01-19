package sigh;

//import all packages
import processing.core.PApplet;
import processing.core.PImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
This is the main class, where most logic code is 
 * @author amy
 * @version 1.0
 * @since 2026-01-18
 */
public class MainSketch extends PApplet {
    //***************************
    //Images n graphics
    //***************************
    //array of image frames for GIF
    PImage[] images; 
    //bg for gardne
    Village_bg plantbg;
    //array of all map backgrounds
    Village_bg[] backgrounds = new Village_bg[12]; 
    int imgIndex = 0; 
    //total number of frames for animation
    public static final int IMAGE_FRAMES = 39;
    items title;                         
    //***************************
    //dialogue n goals and objectives
    //***************************
    //cureent user dialogue image name
    String ctxt = "txtU1(1)";             
    //feedback panel
    dialoge feedback;                      
    //main dialogue box
    dialoge textbox;   
    //king dialogue box for endings
    dialoge finaltxtbox;                   
    dialoge gno;                           
    dialoge currentgno; 

    //different character dialoge arrays holding their dialoge
    String[][] UserdiaArray = new String[2][];       
    String[][] micahdiaArray = new String[3][];    
    String[][] kiyomidiaArray = new String[1][];    
    String[][] mickydiaArray = new String[1][];     
    String[][] catherinediaArray = new String[1][]; 

    String[] kingdiaArray = new String[3];  
    String[] WindiaArray = new String[6];   
    String[] losediaArray = new String[5];  
//win message display
    dialoge Win_message;
    //los mess display
    dialoge loser_mess; 
    //most common word 
    String mostCommonWord = "";             

    //***************************
    //characters
    //***************************
    //hold all npcs and characters
    private chara character;                
    private Person micah;                   
    private Person kiyomi;                   
    private Person micky;                    
    private Person catherine;            

    //***************************
    //game objects / buttons
    //***************************
     //start button
    private StartButton start; 
    //feedback button
    private StartButton start1; 
    
    private StartButton map;              

    items plantPOPup;                        
    items exit;                       
    WaterBucket waterBucket;              
    Soil soil;                             
    items activeItem = null;                

    //***************************
    //gameplay / stage tracking
    //***************************
    private int stage = 0;                    
    private int currentBackground = 10;       

    int row_dia = 0;                          
    int collom_dia = 0;                       
    int ending_row = 0;                        

    boolean king_talking = false;            //Is king talking
    boolean user_talking = true;             //Is user talking
    boolean micky_talking = false;           //Is Micky talking
    boolean suni_talking = false;            //Is Suni talking
    boolean kiyomi_talking = false;          //Is Kiyomi talking
    boolean micah_talking = false;           //Is Micah talking
    boolean cat_talking = false;             //Is Catherine talking

    boolean show_seed = false;               //Show seed selection
    boolean seedPlanted = false;             //Has seed been planted
    boolean showPlantPopup = false;      
    boolean seedChosen = false;          
    boolean king_choice = false;          
    boolean choseWin = false;                //Did the player choose the winning ending
    boolean playEnd = false;                
    boolean showFeed = false;          
    boolean feedChoice = false;            
    boolean homePage = false;          

    boolean spacelock = false;               
    boolean maplock = false;                 
    boolean start_userdia = true;            
    boolean map_open = false;              

    //has player chosen for kiyomi dialoge
    boolean kiyomi_choice = false;         
    int kiyomi_row = 0;                 
    int king_row = 0;                        

    //count of villagers spoken to
    int villagers_talked2 = 0;         

    //***************************
    //different seeds
    //***************************
    //all the different seeds
    seeds chillseed;                         
    seeds peachseed;                        
    seeds radishseed;           
    seeds grapeseed; 
    
    //Currently selected seed
    seeds seed_select;                    

    //***************************
    //timers n levels
    //***************************
    //water and soil elvels
    float waterLevel = 100;                   
    float soilLevel = 100;                 

    //stage 4 start time in millsec
    int stage4StartTime;                       
    //int fiveMinutes = 5 * 60 * 1000; 
    int fiveMinutes = 45 * 1000;              
    
    //sas water and soil been collected
    boolean waterCollected = false; 
    boolean soilCollected = false; 
    //is soil or water being used
    boolean soilPressed = false;               
    boolean waterPressed = false;          

   
   
   
/**
 * Change stages and size of playing screen
 * @param newStage the stage that's being changed into 
 */  
    void changeStage(int newStage) {
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
        
        //Set images and cords for home page images
        start = new StartButton(this, "images/startsign.png", 320, 210);
        start1 = new StartButton(this, "images/abtgamesign.png", 300, 320);
        map = new StartButton(this, "images/map.png", 50, 30);
        plantbg = new Village_bg(this, "images/graden.png");

        //load user array with correct images
        /**
         * txt - text
            U - User
            1 - first set of dialoge
            (1) - first image
         */
        UserdiaArray[0] = new String[2];
        UserdiaArray[1] = new String [3];
        UserdiaArray[0][0] = "images/txtU1(1).png";
        UserdiaArray[0][1] = "images/txtU1(2).png";
        UserdiaArray[1][0] = "images/txtU2(1).png";
        UserdiaArray[1][1] = "images/txtU2(2).png";
        UserdiaArray[1][2] = "images/txtU2(3).png";

        //load all dialouge for kiyomi 
        kiyomidiaArray[0] = new String[4];
        kiyomidiaArray[0][0] = "images/txtK1(1).png";
        kiyomidiaArray[0][1] = "images/txtK1(2).png";
        kiyomidiaArray[0][2] = "images/txtK1(3).png"; 
        kiyomidiaArray[0][3] = "images/txtK1(4).png";
        
        //load all dialouge for micah 
        micahdiaArray[0] = new String[3];
        micahdiaArray[0][0] = "images/txtM1(1).png";
        micahdiaArray[0][1] = "images/txtM1(2).png";
        micahdiaArray[0][2] = "images/txtM1(3).png";
        
        //load all dialouge for micky
        mickydiaArray[0] = new String[4];
        mickydiaArray[0][0] = "images/txtMy1(1).png";
        mickydiaArray[0][1] = "images/txtMy1(2).png";
        mickydiaArray[0][2] = "images/txtMy1(3).png";
        mickydiaArray[0][3] = "images/txtMy1(4).png";

        //load all dialouge for cat 
        catherinediaArray[0] = new String [2];
        catherinediaArray[0][0] = "images/txtC2(1).png";
        catherinediaArray[0][1] = "images/txtC2(2).png";
        
        //Initiazlize the size of the image array
        images = new PImage[IMAGE_FRAMES];
        //run through num 1-39 to load each corisponding frame into the array
        for (int i = 0; i < IMAGE_FRAMES; i++) {
            //Load all the frames of the GIF into the array
            images[i] = loadImage("images/frame_" + i + ".png");
        }
        
        //load all parts of backgrounds  
        backgrounds[0] = new Village_bg(this, "images/row-1-column-1.png");
        backgrounds[1] = new Village_bg(this, "images/row-1-column-2.png");
        backgrounds[2] = new Village_bg(this, "images/row-1-column-3.png");
        backgrounds[3] = new Village_bg(this, "images/row-2-column-3.png");
        backgrounds[4] = new Village_bg(this, "images/row-2-column-2.png");
        backgrounds[5] = new Village_bg(this, "images/row-2-column-1.png");
        backgrounds[6] = new Village_bg(this, "images/row-3-column-1.png");
        backgrounds[7] = new Village_bg(this, "images/row-3-column-2.png");
        backgrounds[8] = new Village_bg(this, "images/row-3-column-3.png");
        backgrounds[9] = new Village_bg(this, "images/userhome.png", 61, 40);
        backgrounds[11] = new Village_bg(this, "images/king.png");
        
        //Add corisponding image and cord of character to vairbales
        character = new chara(this, "images/character.png", 300,240, "user");
        micah = new Person(this, "images/villager1.png", 450, 200, "micah");
        kiyomi = new Person(this, "images/villager2.png", 28, 96, "kiyomi");
        micky = new Person(this, "images/villager3.png", 290,430, "micky");
        catherine = new Person(this, "images/catherine.png" , 420,330, "cat");
        
        chillseed = new seeds(this, "images/chillseed.png", 50,100);
        peachseed = new seeds(this, "images/peachseed.png", 140,100);
        radishseed = new seeds(this, "images/radishseed.png", 250,100);
        grapeseed = new seeds(this, "images/grapeseed.png", 400,100);
        seed_select = new seeds(this, "images/sel_chill.png", 20, 420, waterBucket, soil);

        finaltxtbox = new dialoge(this, "images/txtK1(1)_1.png", 100,100);  
        textbox = new dialoge(this, "images/" + ctxt+".png", 111,295);
        gno = new dialoge(this, "images/3.png", 3,5);
        currentgno = new dialoge(this, "images/gno1.png", 5,25);
        title = new items(this, "images/title.png", 200,25);
        
        //gardening stuff
        plantPOPup = new items(this, "images/yOn.png", 100, 240-91);
        exit = new items(this, "images/exit.png", 5, 5);
        waterBucket = new WaterBucket(this, "images/waterbucket.png", 14, 360);
        soil = new Soil(this, "images/soil.png", 20, 420);
        
        
        //Load king dia array
        kingdiaArray[0] = "txtK1(1)_1";
        kingdiaArray[1] = "txtK1(2)_1";
        kingdiaArray[2] = "txtK1(3)_1";
        //Load winning dia array
        WindiaArray[0] = "txtU3G(1)";
        WindiaArray[1] = "txtU3G(2)";
        WindiaArray[2] = "txtK1G(1)";
        WindiaArray[3] = "txtK1G(2)";
        WindiaArray[4] = "txtK1G(3)";
        WindiaArray[5] = "txtK1G(4)";
        //Load losing dia array
        losediaArray[0] = "txtU3B(1)";
        losediaArray[1] = "txtU3B(2)";
        losediaArray[2] = "txtK1B(1)";
        losediaArray[3] = "txtU3B(3)";
        losediaArray[4] = "txtK1B(2)";

        //load winning message
        Win_message = new dialoge (this, "images/WINN.png", 20,20);
        //load lsing message
        loser_mess = new dialoge (this, "images/lose.png", 20,20);
        //load feedback message
        feedback = new dialoge(this, "images/feedback_base.png", -10,-3);
    }

    
    
    public void draw() {  
        System.out.println(king_talking +"," +!spacelock+"," +!playEnd);
    //open map if a is pressed   
    if (keyPressed && key == 'a' && !maplock) {
        //indicate a is being pressed
        maplock = true;
        map_open = !map_open;
    }
    if (!keyPressed || key != 'a') {
        //indicate a has been released
        maplock = false;
    }
    
    //escape garden when e is pressed
    if (currentBackground == 11 && keyPressed && (key == 'e' || key == 'E')) {
     //change bg to 2 when user leave the garden   
    currentBackground = 2; 
}
    //if the user has talked to all three vilagers
    if (villagers_talked2 >= 3)
        //progress to next goal
            stage =2;
        if (stage == 2){
            //show net goal
           currentgno.setImage("images/gno2.png");
           //reset variables so other componates of stage 1 don't get used
           villagers_talked2 = 0;
        }
       
        
        //change playing screen size
        background(0);
        //check is garden is open
        if (currentBackground == 11){
                    //draw all elements for garden

            plantbg.draw();
            exit.draw();
            //call garden method
            gardening();

           }
        //if stage is 0     
        if (stage == 0){
            //play throug all images of the array images
            image(images[imgIndex], 0, 0, width, height);
            //new frame of the gif every 10 frames of the game
            if (frameCount % 10 == 0) {
                //increase image by one
                imgIndex++;
                if (imgIndex >= images.length) {
                    //start the array again
                    imgIndex = 0; 
                }
            }
            //draw startpage items
            start1.draw();
            start.draw();
            title.draw();
            
                      
        }
        //draw village background if i isnt on the home page or garden
        if (stage!=0 && currentBackground != 11){
           backgrounds[currentBackground-1].draw();
           //draw character
           character.draw();
           //check is current bg is 12
           if (currentBackground !=12){
               //draw goals and current goal
           gno.draw();
           currentgno.draw();}
           //System.out.println(character.x +","+ character.y);
           
           
           //check is a key was pressed
           if (keyPressed) {
               //call method notBG12
               if (notBG12()){
                   //character movement
                if (keyCode == LEFT) 
                  //move 3 pixal left 
                  character.x -= 3;
                
                if (keyCode == RIGHT) {
                   //move 3 pixal right 
                  character.x += 3;
                }
                if (keyCode == UP && notBG12()) {
                  //move 3 pixal up 
                  character.y -= 3;
                }
                if (keyCode == DOWN && notBG12()) {
                  //move 3 pixal  down
                  character.y += 3;
                }
               }
               else {
                   //wlak slower on bg12
                if (keyCode == RIGHT && character.x < 297 && !king_talking) {
                  character.x += 2;
                if (keyCode == RIGHT && character.x > 297) {
                    //enable king talking when character hits this 
                    king_talking = true;
                    king_row = 0;
                    
                }
               }
               }
               //start user dialoge logic
                if (key == ' '){
                    //is user supposed to be talking rn
                    if (user_talking && !spacelock){
                        if (start_userdia || stage == 5){
                    //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    row_dia++;
                    //if it isnt the last dialouge
                    if (row_dia != UserdiaArray[collom_dia].length)
                        //change image of textbox to next one
                        textbox.setImage(UserdiaArray[collom_dia][row_dia]);
                    //stop dialouge if there isnt anymore to play
                    if (row_dia >= UserdiaArray[collom_dia].length) {
                        //reset all vairables
                        user_talking = false;
                        row_dia = 0;
                        start_userdia = false;
                        collom_dia++;
                }   
            }
                    }
                    //is micah supposed tp be taling
                    if (micah_talking && !spacelock){
                    //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    row_dia++;
                    if (row_dia != micahdiaArray[0].length)
                         //change image of textbox to next one/ current index one
                        textbox.setImage(micahdiaArray[0][row_dia]);
                    //stop dialouge if there isnt anymore to play
                    if (row_dia >= micahdiaArray[0].length) {
                        micah_talking = false;
                        row_dia = 0;
                }   
                    }

           }
                if (key == ' ' && kiyomi_talking && !spacelock && !kiyomi_choice) {
                //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    kiyomi_row++;
                if (kiyomi_row < kiyomidiaArray[0].length-2) {
                         //change image of textbox to next one/ current index one
                    textbox.setImage(kiyomidiaArray[0][kiyomi_row]);

                    if (kiyomi_row == 1) {
                        kiyomi_choice = true;
                    }
                }
//stop dialouge if there isnt anymore to play
                else {
                    //reset all vairables
                    kiyomi_talking = false;
                    kiyomi_row = 0;
                    kiyomi_choice = false;
                }
            }

            if (key == ' ' && micky_talking && !spacelock) {
                //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    row_dia++;

                if (row_dia != mickydiaArray[0].length)
                         //change image of textbox to next one/ current index one
                        textbox.setImage(mickydiaArray[0][row_dia]);

                    if (row_dia >= mickydiaArray[0].length) {
                        //reset variables
                        micky_talking = false;
                        row_dia = 0;
                }   
                    }
            
            
            if (key == ' ' && cat_talking && !spacelock) {
                //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    row_dia++;
                if (row_dia != catherinediaArray[0].length)
                         //change image of textbox to next one/ current index one
                        textbox.setImage(catherinediaArray[0][row_dia]);

                    if (row_dia >= catherinediaArray[0].length) {
                        //reset variables
                        cat_talking = false;
                        row_dia = 0;
                        show_seed = false;
                        stage = 3;
                        //change goal to 3
                        currentgno.setImage("images/gno3.png");

                        

                }   
                    }
            
             if (key == ' ' && king_talking && !spacelock && !playEnd) {
                //tell code that space is being pressed        
                    spacelock=true;
                    //play next dialoge when spacee is pressed
                    king_row++;
                //Normal king dialogue
                if (king_row < kingdiaArray.length) {
                   //change image of textbox to next one/ current index one
                    finaltxtbox.setImage("images/" + kingdiaArray[king_row] + ".png");

                    if (king_row == 2) {
                        //is it time to chose a choice in player dialoge
                        king_choice = true;
                    }
                }
            }  
             
            if (key == ' ' && playEnd && !spacelock) {
                //tell code that space is being pressed        
                spacelock = true;
                String[] currentArray;
                //check which option player chose
                if (choseWin) {
                    currentArray = WindiaArray;
                } else {
                    currentArray = losediaArray;
                }
            if (ending_row < currentArray.length) {
                 //change image of textbox to next one/ current index one
                finaltxtbox.setImage("images/" + currentArray[ending_row] + ".png");
                //increase ending_row
                ending_row++;
            }
            else {
                playEnd = false;
            }
        }
        
        //was h pressed
        if (playEnd && key == 'h'){
            //run method resetGame()
            resetGame();
            //Troublshooting
            println("game reset");
            changeStage(0);
            homePage = true;
        }
                   }
           //is space being pressed
        if (!keyPressed || key != ' ') {
            spacelock = false;
    }
        //check which bg is on right now
           if (currentBackground == 1) {
               //run boarder logic for current background
               updateBackground1();
               //draw micky npa on bg1
               micky.draw();
           }
        //check which bg is on right now
           else if (currentBackground == 2) {
               //run boarder logic for current background
               updateBackground2();
           }
        //check which bg is on right now
           else if (currentBackground == 3) {
               //updateBackground3();
           }
        //check which bg is on right now
           else if (currentBackground == 4) {
               //run boarder logic for current background
               updateBackground4();
               //draw kiyomi npa on bg1
               kiyomi.draw();
           }
        //check which bg is on right now
           else if (currentBackground == 5) {
               //run boarder logic for current background
               updateBackground5();
               //draw micah npa on bg1
               micah.draw();
           }
        //check which bg is on right now
           else if (currentBackground == 6) {
               updateBackground6();
           }
        //check which bg is on right now
           else if (currentBackground == 7) {
               //run boarder logic for current background
               updateBackground7();
           }
           else if (currentBackground == 8) {
               updateBackground8();
               if (stage ==2)
                                  //draw catehrine npa on bg1
                catherine.draw();
           }
           else if (currentBackground == 9) {
               updateBackground9();
           }
           else if (currentBackground == 10) {
               updateEliasHome();
           }
           
         //if any of these people are talking draw the textbox  
         if (cat_talking || user_talking || kiyomi_talking || micah_talking || micky_talking)
            textbox.draw();
           
        }
        //draw map if map_op is true
                if (map_open){
                    //draw map
            map.draw();
        }
                
                
       //show seed true?         
       if (show_seed){
           //draw all four seeds
           chillseed.draw();
           peachseed.draw();
           radishseed.draw();
           grapeseed.draw();
           
       }
       
//check if stage is 4 
if (stage == 4) {
    // Gradually decrease water and soil levels over time, 
    // ensuring they stay within the valid range of 0 to 100
        waterLevel = constrain(waterLevel - 0.01f, 0, 100);
        soilLevel = constrain(soilLevel - 0.01f, 0, 100);
        //draw soil and water bars
        drawSurvivalBars();
        
        //if cur_bg isnt 11
        if (currentBackground != 11) {
            //did user collect water
            if (waterCollected) {
                //show water in inventory
                fill(0, 150, 255);
                rect(20, height - 40, 20, 20); 
                fill(255);
                textSize(10);
                //draw water label 
                text("WATER", 15, height - 45);
            }
            if (soilCollected) {
                //draw soil in inventory
                fill(139, 69, 19);
                rect(60, height - 40, 20, 20); 
                fill(255);
                //draw soil label
                text("SOIL", 60, height - 45);
            }
        }
//if current bg ==11 aka garden
        if (currentBackground == 11) {
            //did user collect water
            if (waterCollected) {
                waterBucket.draw(); //Draws the actual bucket image in the garden inventory
            }
            //did user collect water
            if (soilCollected) {
                soil.draw(); //Draws the actual soil image in the garden inven
            }
            //show yes or no use item 
            if (showPlantPopup) {
                //draw yes or no
                plantPOPup.draw();
            }
        }
        //if current time in mill sec - when stage 4 started is over time limit for stage 4
        if (millis() - stage4StartTime >= fiveMinutes) {
            //change to stage 5
            stage = 5;
            //show goal 5
            currentgno.setImage("images/gno5.png");
            //make user talk
            user_talking = true;
            textbox.setImage(UserdiaArray[1][0]);
        }
    }
//if in king castle
    if (currentBackground == 12){
        //check if king is talking
        if (king_talking){
            //draw king dialouge
        finaltxtbox.draw();
if (playEnd) {
    //checks if user chose the winning path or losing one
    if (choseWin) {
        //check is win dialouge is done
        if (ending_row >= WindiaArray.length) {
            Win_message.draw();
        }
    } 
    else {
        //check is win dialouge is done
        if (ending_row >= losediaArray.length) {
            loser_mess.draw();
        }
    }
}
    }
    }
    
    //if we are on homepage and user clicked show feedback button
           if (showFeed && width == 837) {
            feedback.draw();
           
           
           if (feedChoice){
               //check which feedback is most common and display the corisponding feedback bg
               if (mostCommonWord.equals("story")){
                   feedback.setImage("images/story.png");
               }
               else if (mostCommonWord.equals("INpie")){
                   feedback.setImage("images/INpie.png");
               }
                else if (mostCommonWord.equals("graphics")){
                   feedback.setImage("images/Graphics.png");
               }
                else {
                //show base feedback page (neutral)
                feedback.setImage("images/feedback_base.png");
            }
           }
           
           
       }
}
    
    
        //Mouse click detection
    public void mousePressed() {
        //check if user clicked about the game button
        if (start1.isClicked(mouseX, mouseY) && homePage){
            //reset variables to show feedbakc page
            playEnd = false;
            showFeed = true;
            stage = 0;
            homePage = false;
        }
        
        else if (showFeed && !feedChoice){
            try{
               //Initialize writing variable
               FileWriter writer;
               writer = new FileWriter("feedback.txt", true);
               PrintWriter output = new PrintWriter(writer);
               //write to file
               //which option the user clicked is dependant on the mouse clicked Y-cord
                if (mouseY <280){
                    //write the user clicked story into the file
                        output.println("story");
                }
               //write the user clicked interactive pieces into the file
                else if (mouseY < 357){
                        output.println("INpie");
                }
                    //write the user clicked graphics into the file
                    else{
                       output.println("graphics");
                }
                //save written info
                output.close();      
                }
           catch(IOException e){
           }
            MostCommonWordCount();
            //user picked which element they liked the most
           feedChoice = true;

            }

          
        if (cat_talking){
        //Check if the player has picked the chilly seed
        if (chillseed.isClicked(mouseX, mouseY)) {
            //Set seed_select object as the chilly seed used later in the inventory 
            seed_select.setImage("images/sel_chill.png");
            seedChosen = true;
            //Used for trouble shooting
            System.out.print("chill");
        }
        //Check if the player has picked the peach seed
        else if (peachseed.isClicked(mouseX, mouseY)) {
            //Set seed_select object as the chilly seed used later in the inventory 
            seed_select.setImage("images/sel_peach.png");
            //Set seedChosen as true telling the code the player has chosen a seed
            seedChosen = true;
            //Used for trouble shooting
            System.out.print("peach");
        }
        //Check if the player has picked the radish seed
        else if (radishseed.isClicked(mouseX, mouseY)) {
            //Set seed_select object as the radish seed used later in the inventory 
            seed_select.setImage("images/sel_radish.png");
            //Set seedChosen as true telling the code the player has chosen a seed
            seedChosen = true;
            //Used for trouble shooting
            System.out.print("radish");          

        }
        else if (grapeseed.isClicked(mouseX, mouseY)) {
           //Set seed_select object as the radish seed used later in the inventory 
            seed_select.setImage("images/sel_grapes.png");
            //Set seedChosen as true telling the code the player has chosen a seed
            seedChosen = true;
            //Used for trouble shooting
            System.out.print("grape");
        }
        }
        
        //Mouse detection for starting the game 
        if (start.isClicked(mouseX, mouseY) && stage == 0) {
            //change the stage if user has clicked the start button and its stage 0
            stage = 1;
            //change setup size
            changeStage(1);
}
        //if micah was clicked    
        if (micah.isClicked(mouseX, mouseY) && stage == 1){
            //increase villagers by 1
            villagers_talked2 ++;
            //run method interact with to make micah talking true
            interactWith(micah);
            user_talking = false;
            //reset variables
            row_dia = 0;
            textbox.setImage(micahdiaArray[0][0]);

        }
        //check is micky was clicked
        if (micky.isClicked(mouseX, mouseY)&& stage == 1 ){
            //increase villagers by 1
            villagers_talked2 ++;
            //run method interact with to make micky talking true
            interactWith(micky);
            user_talking = false;
            
            row_dia = 0;
            textbox.setImage(mickydiaArray[0][0]);

        }
        
        //check is catherine was clicked
        if (catherine.isClicked(mouseX, mouseY) && stage == 2){
            //run method interact with to make micky talking true
           interactWith(catherine);
           
            row_dia = 0;
           textbox.setImage(catherinediaArray[0][0]);
           if (show_seed)
               show_seed = !show_seed;
           else
            show_seed = true; 
        }

        //check is kiyomi was clicked
        if (stage == 1 && kiyomi.isClicked(mouseX, mouseY) && !kiyomi_talking) {
            //run method interact with to make micky talking true
        interactWith(kiyomi);
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
            //user wants to use seed in inventory
        if (seed_select.isClicked(mouseX, mouseY)) {
            showPlantPopup = true;
            //set water and soil to 100
            seed_select.useItem(this, "water");
            seed_select.useItem(this, "soil");

        }
        
        //player planted seed
        else if (showPlantPopup) {
            if (mouseX < 480 / 2) {
                //set variables for player planting seeds
                seedPlanted = true;
                showPlantPopup = false;
                //move one to next stages
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
        
        if (currentBackground == 5 && !waterCollected) {
            //check is user collected water basd on cords
            if (mouseX > 309 && mouseY < 121) {
                
                waterCollected = true;
                System.out.println("Water Bucket Collected!");
            }
        }

        //COLLECTION: Background 7 (Soil Patch)
        if (currentBackground == 6 && !soilCollected) {
           //check is user collected soil basd on cords
            if (mouseX > 393 && mouseY > 256) {
                //set variables for soil being collected
                soilCollected = true;
                showPlantPopup = false;
                soilPressed = false;
                System.out.println("Soil Collected!");
            }
        }

        if (currentBackground == 11) {
            //Open popup if player clicks plant AND has an item
            if (!showPlantPopup && waterBucket.isClicked(mouseX, mouseY)) {
                if (waterCollected) {
                    //show popup and water ahs been pressed
                    showPlantPopup = true;
                    waterPressed = true;
                    
                
                }}
            if (!showPlantPopup && soil.isClicked(mouseX, mouseY)) {
                 if (soilCollected){
                    soilPressed = true;
                    refillSoil();
                 }
             
            }
            //Handle the Yes/No click on the shared popup
            else if (showPlantPopup) {
                if (mouseX < 480 / 2) { //Clicked "YES"
                        if (seed_select.isClicked(mouseX, mouseY)) {
                            //which item does user want to use
                            activeItem = seed_select;
                        }
                        else if (waterBucket.isClicked(mouseX, mouseY)) {
                            //tells us which item does user want to use
                            activeItem = waterBucket;
                        }
                        else if (soil.isClicked(mouseX, mouseY)) {
                            //tells us which item does user want to use
                            activeItem = soil;
                        }
                        
                        if (activeItem != null) {
                            System.out.println("hi");
                            activeItem.use(this);
                        }
                    showPlantPopup = false;
                } else { //Clicked no
                    showPlantPopup = false;
                }
            }
        }
    }

//check which coice the player made based on mouse cords
if (king_choice && !playEnd) {
    if (mouseY < 241) {
        //player chose to win
        choseWin = true;
        startEnding(WindiaArray, true);
    }
    else if (mouseY > 241) {
        //player chose to lose
        choseWin = false;
        startEnding(losediaArray, false);
    }
}


}
    
/**
 * This method is used to set boarders users home
 */      
    void updateEliasHome() {
    if (character.x > 501 && character.x < 570 && character.y > 366) {
        currentBackground = 2;
        character.setPos(336, 369);
    }
    //prevents character to run off screen
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

 /**
 This method is used to set boarders in bg1 and detect player movement
 * 
 */   
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
            //set characters position to this for bg12
            character.setPos(0,360);
            //change characters image to run right
            character.setImage("images/chara_right.png");
        }
    }
/**
 This method is used to set boarders in bg2 and detect player movement
 * 
 */
    void updateBackground2() {
        if (character.y < 334 && character.x > 160) {
            currentBackground = 10;
            character.setPos(523, 345);
        }
        //prevents character from walking off screen
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
            //set characters position to this for bg5
            character.setPos(234, 52);
        }
        
        if (character.x>-1 && character.x<42 && character.y<256){
            currentBackground = 11;
            //set characters position to this for bg11
            character.setPos(character.x,263);
        }
        
    }
    /**
 This method is used to set boarders in bg4 and detect player movement
 * 
 */
    void updateBackground4() {
        if (character.x > 292) character.x = 292;
        if (character.y > 168 && character.y < 248 && character.x < 50) {
            currentBackground = 5;
            //set characters position to this for bg5
            character.setPos(634, 204);
        }
        if (character.x > 85 && character.x < 140 && character.y > 460) {
            currentBackground = 9;
            //set characters position to this for bg9
            character.setPos(112, 42);
        }
        if (character.x > 68 && character.x < 228 && character.y < 42) {
            character.setPos(356, 356);
        }
     
    }
/**
 This method is used to set boarders in bg5 and detect player movement
 * 
 */
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
        
        //Prevents character from walking off
        //Checks if character x or y is off screen
        if (character.x < 0)
            //Contains them inside the screen
            character.x = 0;
        if (character.x > 683)
            //Contains them inside the screen
            character.x = 683;
        
        
        if (character.y > 480)
         //Contains them inside the screen
            character.y = 480;
        if (character.y < 0)
            //Contains them inside the screen
            character.y = 0;
    }
/**
 This method is used to set boarders in bg6 and detect player movement
 * 
 */
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
/**
 This method is used to set boarders in bg7 and detect player movement
 * 
 */
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
/**
 This method is used to set boarders in bg8 and detect player movement
 * 
 */
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
/**
 This method is used to set boarders in bg9 and detect player movement
  
 */
    void updateBackground9() {
        //Check is player has gone off the "path" on the map
        if (character.y > 200) 
            //Prevents them from going off path
            character.y = 200;
        //Check is player has gone off the "path" on the map
        if (character.x > 393)
            //Prevents them from going off path
            character.x = 393;
        //Check if player wants to go to another part of the map
        if (character.x > 88 && character.x < 148 && character.y < 30) {
            //change map background
            currentBackground = 4;
            //move player to correct potion for bg4
            character.setPos(124, 460);
        }
    }
/**
 * draw seed inside inventory and does popup logic
 */    
void gardening(){
    if (!seedPlanted) { //hasnt been planted
        seed_select.draw();}
    if (showPlantPopup) {
        plantPOPup.draw();
    
        }
    }
/**
 * draws all survial bars
 */
void drawSurvivalBars() {
    //Position settings
    int barWidth = 100;
    int barHeight = 15;
    int xPos = width - 120;
    
    //Water Bar
    fill(50); //Dark grey background for the bar
    rect(xPos, 30, barWidth, barHeight); 
    fill(0, 150, 255); //Blue
    rect(xPos, 30, waterLevel, barHeight); 
    fill(255);
    textSize(12);
    text("WATER", xPos, 25);

    //Soil Bar
    fill(50); 
    rect(xPos, 70, barWidth, barHeight); 
    fill(139, 69, 19); //Brown
    rect(xPos, 70, soilLevel, barHeight); 
    fill(255);
    text("SOIL HEALTH", xPos, 65);
}


/**
 * This method takes endingArray and sets the finaltxtbox to it. 
 * It also changes required variables to continue with the game
 * @param endingArray This is the choice the user has made in the final ut scene (lie or tell the truth)
 */
public void startEnding(String[] endingArray, boolean didWin) {
    //Set playEnd to true to start game ending
    playEnd = true;
    //Disables players ability to chose in the final
    king_choice = false;
    //Tracks which image in the array is being shown
    ending_row = 0;
    choseWin = didWin;
    //Set the txt box being shown the the one the player chose
    finaltxtbox.setImage("images/" + endingArray[0] + ".png");
}
public void resetGame() {
    //Go back to home page
    changeStage(0);
    stage = 0;
    currentBackground = 1;
    
    //return character to starting position, and image
    character.setPos(300, 240);
    character.setImage("images/character.png");

    //Return all talking flags to false
    interactWith(character);
    micah_talking = false;
    kiyomi_talking = false;
    micky_talking = false;
    cat_talking = false;
    king_talking = false;

    //Revert all dialoge variables to 0 
    row_dia = 0;
    collom_dia = 0;
    start_userdia = true;

    //Set textbox to first dialoge
    textbox.setImage(UserdiaArray[0][0]);
    currentgno.setImage("images/gno1.png");

    //Revert all variables to orgional value
    king_choice = false;
    choseWin = false;
    king_row = 0;
    villagers_talked2 = 0;

    show_seed = false;
    seedChosen = false;
    seedPlanted = false;
    showPlantPopup = false;

    waterCollected = false;
    soilCollected = false;
    waterPressed = false;
    soilPressed = false;

    waterLevel = 100;
    soilLevel = 100;

    map_open = false;
    maplock = false;
    spacelock = false;

    stage4StartTime = 0;
}

public void MostCommonWordCount() {
    //Initialize variables for this method
    int storyCount = 0;
    int inpieCount = 0;
    int graphicsCount = 0;
    
    //open try
    try {
        //Create a scanner object for the file "feedback.txt"
        Scanner scanner = new Scanner(new File("feedback.txt"));

        //does file have another line
        while (scanner.hasNextLine()) {
            //load file line into variable line
            String line = scanner.nextLine();
            //set word as a trim of line to take out spaces
                String word = line.trim();
                //count the number on times each word shows up
                if (word.equals("story")) storyCount++;
                else if (word.equals("INpie")) inpieCount++;
                else if (word.equals("graphics")) graphicsCount++;
            }
        
        //close scanner
        scanner.close();

        //Find the highest number 
        if (storyCount >= inpieCount && storyCount >= graphicsCount) {
            //Set most common word to story
            mostCommonWord = "story";
        } else if (inpieCount >= storyCount && inpieCount >= graphicsCount) {
            //Set most common word to INpie
            mostCommonWord = "INpie";
        } else {
            //Set most common word to graphics
            mostCommonWord = "graphics";
        }

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    }
}
public void startPlanting() {
    seedPlanted = true;
    showPlantPopup = false;
    stage = 4;
    currentgno.setImage("images/gno4.png");
    stage4StartTime = millis();
}

public void refillWater() {
    waterLevel = 100;
    waterCollected = false;
    waterPressed = false;
}
/**
 * Called when the player has used soil on plant
 */
public void refillSoil() {
    soilLevel = 100;
    soilCollected = false;
    soilPressed = false;
}
/**
 * Used to check if the current background is 12
 * Allows better readability is draw() method
 * @return if the current background 12 (t or f)
 */
public boolean notBG12() {
    return currentBackground != 12; 
}

public void interactWith(Person p) {
    //check if p is a chara
    if (p instanceof chara) {
        //downcast to access chara-specific methods
        chara child = (chara) p; 
        if (child.getName().equals("user"))
        user_talking = true;
    } 
    else { 
        //gets name of p then checks who it is
        switch(p.getName()) {
            //Check if its micah
            case "micah": 
                //makes person talking true
                micah_talking = true; 
                //end switch case
                break;
            //Check if its kiyomi
            case "kiyomi":
                //makes person talking true
                kiyomi_talking = true;
                //end switch case
                break;
            //Check if its micky
            case "micky":
                //makes person talking true
                micky_talking = true; 
                //end switch case
                break;
            //Check if its catherine
            case "cat": 
                //makes person talking true
                cat_talking = true; 
                //end switch case
                break;
        }
    }
}
}