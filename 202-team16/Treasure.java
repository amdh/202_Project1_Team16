import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Actor
{

    
    public void act() 
    {
        // Add your action code here.
        Pirates pirate  = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);

        if(pirate != null){
            System.out.println("pirate won");
            grabTreasure();
        }
    }   

    public void grabTreasure(){
        PirateWorld world =  getWorldOfType(PirateWorld.class);  
        if(PirateWorld.multiUser){
            world.callPUTAPI_WINNER();
        }
        world.setWinnerScreen();
    }

    boolean checkIntersectingObjects(Pirates t)
    {
        if(this.intersects(t))
        {
            return true;
        }
        else
            return false;
    } 
}
