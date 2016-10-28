import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SugarloafMountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopacabanaBrazil extends Place
{
    /**
     * Act - do whatever the SugarloafMountain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CopacabanaBrazil(){

        GreenfootImage image = new GreenfootImage("images/copacabana/ans1.png");
        image.scale(100,100);
        //getWorld().getBackground().drawImage(image, 200,200);

    }

    public void act() 
    {
        // Add your action code here.
       // setRotation(getRotation() + 5);       
        move(1);
    }    
    
     public void draw(){
    }
    
    public void cleanPlace(){
    }
}
