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

    Button startGame;
    Pirates pirate;
    
    List<Life> LivesLeft = new ArrayList<Life>();
    
    PlaceInterface MumbaiIndia;
    PlaceInterface GoldengateBridge;
    PlaceInterface CapeTownAfrica;
    PlaceInterface NewYork;
    PlaceInterface Australia;
    PlaceInterface France;
    PlaceInterface CopacabanaBrazil;
    
    PlaceInterface state = MumbaiIndia;
    
    
    Life pirateBoat;
    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500  , 880   , 1);
        prepare(); 
        
        France = new France();
        
    }

    public void prepare(){

        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        
        
        
        
        startGame = new StartGame();
        addObject(startGame, 1300,700);
        pirate = new Pirates();
        pirateBoat = new Life();
        pirateBoat.getImage().scale(250,150);
        //while(!LivesLeft.isEmpty())
        //{
        //    System.out.println("Lives:- " + LivesLeft.size());
        //    LivesLeft.remove(0);
        //}
        
        //Greenfoot.playSound("sounds/theme.mp3");

    }
    
    
    public void setState(PlaceInterface state)
    {
        this.state = state;
    }
    
    public PlaceInterface getMumbaiIndia() {
        return MumbaiIndia;
    }

    public PlaceInterface getGoldengateBridge() {
        return GoldengateBridge;
    }

    public PlaceInterface getAustralia() {
        return Australia;
    }

    public PlaceInterface getFrance() {
        return France;
    }

    public PlaceInterface getNewYork() {
        return NewYork;
    }
    
    public PlaceInterface getCopacabannaBrazil() {
        return CopacabanaBrazil;
    }
    
    public PlaceInterface getCapeTownAfrica() {
        return CapeTownAfrica;
    }
    
    

    public void start(){
        Greenfoot.playSound("sounds/theme.mp3");
    }

    public void setFirstPlace(){
        removeObject(startGame);
        //  setBackground()
       
        setState(France);
        //addObject(new France(),0,0);
        state.draw();
        
        
        
    }

    
    public void setFrance(){
        removeObject(startGame);
        //  setBackground()
        addObject(new France(),0,0);
        addObject(pirateBoat,70, 520);
        addObject(pirate, 100,500);
      
    }
    
    public void setPlace(Button button, Place place){

        removeObject(button);
        addObject(place,0,0);

    }
}
