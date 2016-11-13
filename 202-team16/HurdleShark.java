import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HurdleShark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HurdleShark extends Actor
{
    PirateWorld world;
    Pirates pirate;
    int cnt=0;

    public HurdleShark(){
        world =  getWorldOfType(PirateWorld.class);        
        pirate =  world.getPirate();
        world.setBackground("images/hurdleShark.jpg");

    }

    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.getRandomNumber(300)<3){
            world.addObject(getEnemy("shark"), 1500,800);
        }
    }  

    public IEnemy getEnemy(String type){
        EnemyFactory f = new EnemyFactory();

        IEnemy s1 = f.getEnemy(type);
        return s1;
    }
}
