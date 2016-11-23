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
    Pirates pirate;
    public Skull(){
        world =  getWorldOfType(PirateWorld.class);  
    }

    public void act() 
    {
        // Add your action code here.
        pirate = (Pirates) getOneObjectAtOffset(0,0,Pirates.class);
        if(pirate != null)
            killPirate();
    }    

    public void killPirate(){
        System.out.println("pirate eaten by skull");
        pirate.removeLife();

    }
}
