import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends IEnemy
{
    /**
     * Act - do whatever the Skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     PirateWorld world ;
     GreenfootSound hurt;
    public Skeleton(){
        world =  getWorldOfType(PirateWorld.class);
        hurt = new GreenfootSound("sounds/Hurt.mp3");
    }
    
    public void act() 
    {
        // Add your action code here.
        setLocation(getX()-2, getY());
    }    

    public void killPirate(){
        Pirates pirate = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);

        if(pirate != null){
            hurt.stop();
            hurt.play();
            System.out.println("pirate eaten by skeleton");
            pirate.removeLife();
            world.removeObject(this);
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
