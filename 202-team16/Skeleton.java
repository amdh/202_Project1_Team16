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
    public void act() 
    {
        // Add your action code here.
    }    

    public void killPirate(){
        Pirates pirate = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);

        if(pirate != null){
            System.out.println("pirate eaten");
            pirate.removeLife();
        }
    }
}
