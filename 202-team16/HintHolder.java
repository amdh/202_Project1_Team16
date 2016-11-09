import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HintHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HintHolder extends Actor
{
    /**
     * Act - do whatever the HintHolder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + 2, getY());

        Actor shark = getOneObjectAtOffset(0,0,Shark.class);

        if(shark != null){
            System.out.println("shark killed");
            getWorld().removeObject(shark);
            getWorld().removeObject(this);
            // break;
        }
        
        if( getX() == (getWorld().getWidth() - 20)){

            getWorld().removeObject(this);
        }
    }    
}
