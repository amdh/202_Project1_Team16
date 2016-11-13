import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Pirates here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pirates extends Actor
{
    List<Life> LivesLeft ;
    PirateWorld world;
    GreenfootSound sound = new GreenfootSound("sounds/FireAnchor.mp3");
    GreenfootSound Die = new GreenfootSound("sounds/GameOver.mp3");

    public Pirates()
    {
        GreenfootImage image = getImage() ; 
        image.scale( 300, 300 ) ; 
        System.out.println("creating lives");
        LivesLeft = new ArrayList<Life>();
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());
        LivesLeft.add(new Life());

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
        if(Greenfoot.mouseClicked(this)){

            sound.stop();
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY(); 
            HintHolder h = new HintHolder();
            h.getImage().scale(30,30);
            world.addObject(h,mouseX, mouseY);
            sound.play();
            
            
        }
    }    

    public void setLife(){
        world =  getWorldOfType(PirateWorld.class);
        int x= 1000 , y = 50;
        ListIterator listIterator = LivesLeft.listIterator();
        while(listIterator.hasNext()){
            Life obj = (Life)listIterator.next();
            obj.getImage().scale(50,50);
            world.addObject(obj,x,y);           
            x+=60;           
        }
    }

    public void removeLife(){
        if(!LivesLeft.isEmpty())
        {
            world.removeObject(LivesLeft.get(0));
            System.out.println("Lives:- " + LivesLeft.size());
            LivesLeft.remove(0);
        }
        //world.repaint();
    }
    
    public void addLife(){
        LivesLeft.add(new Life());
        world.repaint();        
    }
    
    public void checkLifeCount(GreenfootSound audio){
        if (LivesLeft.size() == 0)
        {
            audio.stop();
            Die.play();
            Greenfoot.stop();
            GameOver endgame;
            endgame = new GameOver();
            world.removeObjects(world.getObjects(null)); //removes all the objects in the world;
            world.addObject(new GameOver(), world.getWidth()/2, world.getHeight()/2); //adds the game over screen in the middle of the world;             
        }
    }
}
