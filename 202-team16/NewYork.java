import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewYork here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewYork extends Place
{
    /**
     * Act - do whatever the NewYork wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public NewYork(){

        GreenfootImage image = new GreenfootImage("images/nyc.jpg");
        image.scale(100,100);
        //getWorld().getBackground().drawImage(image, 200,200);

    }

    public void act() 
    {
        move(1);
    }    
}
