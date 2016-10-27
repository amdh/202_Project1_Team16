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

    Place MumbaiIndia;
    Place GoldengateBridge;
    Place CapeTownAfrica;
    Place NewYork;
    Place Australia;
    Place France;
    Place CopacabanaBrazil;
    Place basePlace;
    Place state;

    Life pirateBoat;
    Message message;
    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500  , 880   , 1,true);
        prepare(); 
        Australia = new Australia();
        basePlace = new BasePlace();
        MumbaiIndia = new MumbaiIndia();
        NewYork=new NewYork();
        message = new Message();
    }

    public void prepare(){

        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());

        startGame = new StartGame();
        addObject(startGame, 800,600);
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

    public void setState(Place state)
    {
        this.state = state;
        addObject(state,0,0);
        state.draw();
    }

    public Place getMumbaiIndia() {
        return MumbaiIndia;
    }

    public Place getGoldengateBridge() {
        return GoldengateBridge;
    }

    public Place getAustralia() {
        return Australia;
    }

    public Place getFrance() {
        return France;
    }

    public Place getNewYork() {
        return NewYork;
    }

    public Place getCopacabannaBrazil() {
        return CopacabanaBrazil;
    }

    public Place getCapeTownAfrica() {
        return CapeTownAfrica;
    }

    public Place getBasePlace(){
        return basePlace;
    }

    public void started(){
        // Greenfoot.playSound("sounds/theme.mp3");
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
        state.draw();

    }

    public List<Life> getLife()
    {
        return LivesLeft;
    }

    public Pirates getPirate()
    {
        return pirate;
    }

    public void setLife(){
        int i=0 , x= 1000 , y = 50;
        ListIterator listIterator = LivesLeft.listIterator();
        while(listIterator.hasNext()){
            Life obj = (Life)listIterator.next();
            obj.getImage().scale(50,50);
            addObject(obj,x,y);
            i++;
            x+=60;           
        }
    }

    public void setPirate(){
        Greenfoot.delay(10);
        addObject(pirate,50,600);
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
        addObject(message,200,250);
    }

    public void showHint2(AnswerOption hintImg, String msg){
        message.display(msg);       
        hintImg.getImage().scale(200,180);
        addObject(hintImg, 350,400);
    }

    public void removeLife(){

        if(!LivesLeft.isEmpty())
        {
            while(!LivesLeft.get(0).isAtEdge())
            {
                System.out.println("Moving the life");
                Greenfoot.delay(2);
                LivesLeft.get(0).move(5);
            }
            removeObject(LivesLeft.get(0));
            System.out.println("Lives:- " + LivesLeft.size());
            LivesLeft.remove(0);
        }
        repaint();
    }
}
