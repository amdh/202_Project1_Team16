import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pirates here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pirates extends Actor
{
    
    public Pirates()
    {
         GreenfootImage image = getImage() ; 
        image.scale( 150, 200 ) ; 
    }
    
    /**
     * Act - do whatever the Pirates wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       // move(1); 
        int mouseX, mouseY ;

        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);  
        } 
    }    
}
