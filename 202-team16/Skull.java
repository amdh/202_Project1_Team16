import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skull here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skull extends IEnemy
{
    PirateWorld world ;
    public Skull(){

        world =  getWorldOfType(PirateWorld.class);  
    }

    public void act() 
    {
        // Add your action code here.
        //killPirate();
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

    public void killPirate(){
        Pirates pirate = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);
        
        if(this.intersects(pirate)){
            System.out.println("pirate eaten by skull");
            pirate.removeLife();
        }
    }
}
