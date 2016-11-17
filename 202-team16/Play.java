import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            startAction();
        }

    }    

    public void startAction(){
        PirateWorld world = getWorldOfType(PirateWorld.class);    
        world.cleanIntro();      
        world.setPirate();
        world.setPlace(PirateWorld.basePlace);

    }
}
