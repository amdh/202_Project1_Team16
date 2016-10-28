import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Button
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
        Place p = world.getBasePlace();
       world.setState(p);
        PirateWorld world = getWorldOfType(PirateWorld.class); 
         world.setPirate();
        world.setPlace(new BasePlace());
       
       //getWorld().addObject(new CopacabanaBrazil(),0,0);
    }
}
