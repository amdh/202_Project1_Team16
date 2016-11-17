import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Actor
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
