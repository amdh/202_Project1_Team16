import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PirateWorld extends World
{

    Button startGame, quit, play, rules;
    Pirates pirate;
    Place currentPlace;
    Life pirateBoat;
    Story story;
    DisRule rule; 
    Message message;
    GreenfootSound sound = new GreenfootSound("sounds/theme.mp3");

    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500  , 880   , 1);
        setWelcomeScreen(); 
        message = new Message();
    }

    public void setWelcomeScreen(){
        startGame = new StartGame();
        addObject(startGame, 1300,700);
    }

    public void setIntroScreen(){
        play = new Play();
        quit = new Quit();
        rules = new Rules();
        story = new Story();
        play.getImage().scale(100,100);
        quit.getImage().scale(100,100);
        rules.getImage().scale(100,100);
        addObject(story, 1250,400);
        addObject(play, 1410,700);
        addObject(quit, 1180,700);
        addObject(rules, 1300,700);
    }
    
     public void setRules(){
        if(story!=null)
        removeObject(story);
        if(rule!=null)
        {
            removeObject(rule);
            story = new Story();
            addObject(story, 1250,400);
        }
       else
        {
            rule = new DisRule();
            addObject(rule, 1250,400);
        }
    }
    
    public void setPlace(Place place)
    {
        if(this.currentPlace != null){
            removeObject(this.currentPlace);
        }
        this.currentPlace = place;
        addObject(currentPlace,0,0);
        currentPlace.draw();
    }

    public void started(){
        sound.play();
    }
    
    public void stopped(){
        sound.stop();
    }


    public void setPirate(){
        sound.stop();
        pirate = new Pirates();
        pirateBoat = new Life();
        pirateBoat.getImage().scale(250,150);
        Greenfoot.delay(10);
        addObject(pirate,50,600);
        pirate.setLife();
    }
    public Message getMessage(){
        return message;
    }

    public Pirates getPirate()
    {
        return pirate;
    }

    public Place getCurrentPlace(){
        return currentPlace;
    }

    public void cleanIntro(){
        removeObject(play);
        removeObject(quit);
        removeObject(rules);
        if(story!=null)
        removeObject(story);
        if(rule!=null)
        removeObject(rule);
    }
}
