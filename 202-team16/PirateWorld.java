import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PirateWorld extends World
{

    Button startGame;
    Pirates pirate;
    Life life1;
    Life life2;
    Life life3;
    Life life4;
    Life life5;
    Life pirateBoat;
    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(930, 600, 1);
        prepare();
    }

    public void prepare(){

        startGame = new StartGame();
        addObject(startGame, 800,500);
        pirate = new Pirates();
        pirateBoat = new Life();
        pirateBoat.getImage().scale(250,150);
        life1 = new Life();
        life1.getImage().scale(50,50);
        life2 = new Life();
        life2.getImage().scale(50,50);
        life3 = new Life();
        life3.getImage().scale(50,50);
        life4  = new Life();
        life4.getImage().scale(50,50);
        life5  = new Life();
        life5.getImage().scale(50,50);
        //Greenfoot.playSound("sounds/theme.mp3");

    }

    public void start(){
        Greenfoot.playSound("sounds/theme.mp3");
    }

    public void setFirstPlace(){
        removeObject(startGame);
        //  setBackground()
        addObject(new CopacabanaBrazil(),0,0);
        addObject(pirateBoat,70, 520);
        addObject(pirate, 100,500);
        addObject(life1,700,50);
        addObject(life2,760,50);
        addObject(life3,820,50);
        addObject(life4,880,50);
        addObject(life5,640,50);
    }

    public void setPlace(Button button, Place place){

        removeObject(button);
        addObject(place,0,0);

    }
}
