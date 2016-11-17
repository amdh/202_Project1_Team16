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
    static final String basePlace = "BASEPLACE" ;
    static final String firstPlace =  "AUSTRALIA";
    static final String secondPlace = "MUMBAI";
    static final String thirdPlace =  "CAPETOWN";
    static final String forthPlace = "FRANCE";
    static final String fifthPlace =  "BRAZIL";
    static final String sixthPlace = "NEWYORK";
    static final String seventhPlace = "GOLDENGATE";

    Button startGame, quit, play, rules;
    Pirates pirate;
    IPlace currentPlace;
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
        play.getImage().scale(80,80);
        quit.getImage().scale(70,70);
        rules.getImage().scale(65,65);
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
        {        rule = new DisRule();
            addObject(rule, 1250,400);
        }
    }

    public void setPlace(String placename)
    {
        if(this.currentPlace != null){
            removeObject(this.currentPlace);
        }
        System.out.println(placename);
        switch(placename.toUpperCase()){

            case basePlace:  this.currentPlace = new BasePlace();
            break;
            case firstPlace: this.currentPlace = new Australia();
            break;
            case forthPlace: this.currentPlace = new France();
            break;
            case secondPlace: this.currentPlace = new MumbaiIndia();
            break;
            case thirdPlace: this.currentPlace = new CapetownAfrica();
            break;
            case fifthPlace: this.currentPlace = new CopacabanaBrazil();
            break;
            case sixthPlace: this.currentPlace = new NewYork();
            break;                
            case seventhPlace: this.currentPlace = new GoldenGateBridge();
            break;
            default : this.currentPlace = new BasePlace();
        }

        addObject(currentPlace,0,0);
        currentPlace.draw();
    }

    public void setPlace(IPlace place)
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
        pirateBoat.getImage().scale(500,400);
        Greenfoot.delay(10);
        addObject(pirate,150,750);
        pirate.setLife();
    }

    public Message getMessage(){
        return message;
    }

    public Pirates getPirate()
    {
        return pirate;
    }

    public IPlace getCurrentPlace(){
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

    public void setAnswerOptions(AnswerOption ans1, AnswerOption ans2, AnswerOption ans3, AnswerOption ans4 ){

        Greenfoot.delay(30);
        int x =70 , y = 100;
        ans1.getImage().scale(180,180);
        addObject(ans1,x,y);
        x=x+195;
        ans2.getImage().scale(180,180);
        addObject(ans2,x,y);
        x=x+195;
        ans3.getImage().scale(180,180);
        addObject(ans3,x,y);
        x=x+195;
        ans4.getImage().scale(180,180);
        addObject(ans4,x,y);

    }

    public void showHint1(String msg){
        Greenfoot.delay(20);
        message.display(msg);
        addObject(message,360,250);
    }

    public void showHint2(AnswerOption hintImg, String msg){
        message.display(msg);       
        hintImg.getImage().scale(200,180);
        addObject(hintImg, 200,400);
    }

    public void showHint3(String msg){
        message.display(msg);
    }
}
