import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Place extends Actor
{
     PirateWorld world;
     Pirates pirate;

    public void act() 
    {
        // Add your action code here.

    }    

    public  abstract void draw();

    public abstract void cleanPlace();

    public void setNextPlace(Place p){
        world.setPlace(p);
    }
    
    public PirateWorld getPirateWorld(){
        return world;
    }
    
    public Pirates getPirate(){
        return pirate;
    }

    public void initialize(){
        world =  getWorldOfType(PirateWorld.class);        
        pirate =  world.getPirate();
    }
    
    public void setBackground(String backgroundPath){
        world.setBackground(backgroundPath);
    }
    
    public void removeLife(){
        pirate.removeLife();
    }

    public void setAnswerOptions(AnswerOption ans1, AnswerOption ans2, AnswerOption ans3, AnswerOption ans4 ){

        Greenfoot.delay(30);
        int x =70 , y = 100;
        ans1.getImage().scale(180,180);
        world.addObject(ans1,x,y);
        x=x+195;
        ans2.getImage().scale(180,180);
        world.addObject(ans2,x,y);
        x=x+195;
        ans3.getImage().scale(180,180);
        world.addObject(ans3,x,y);
        x=x+195;
        ans4.getImage().scale(180,180);
        world.addObject(ans4,x,y);

    }

    public void showHint1(String msg){
        Greenfoot.delay(20);
        world.getMessage().display(msg);
        world.addObject(world.getMessage(),200,250);
    }

    public void showHint2(AnswerOption hintImg, String msg){
        world.getMessage().display(msg);       
        hintImg.getImage().scale(200,180);
        world.addObject(hintImg, 200,400);
    }

    public void showHint3(String msg){
        world.getMessage().display(msg);
    }


}
