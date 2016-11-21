import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends IEnemy
{
    PirateWorld world ;
    public Shark(){

        world =  getWorldOfType(PirateWorld.class);  
    }
    public void act() 
    {
        //setLocation(getX()-2, getY());
        //killPirate();
    }    
    
    public void killPirate(){
        Pirates pirate = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);

        if(pirate != null){
            System.out.println("pirate eaten by shark");
           pirate.removeLife();
        }
    }    
    public boolean checkIntersectingObjects(Pirates t)
    {
            if(this.intersects(t))
        {
            return true;
        }
        else
            return false;
    }
    
}
