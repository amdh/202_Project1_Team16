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
    HintHolder anchor = new HintHolder();

    private String stageName;
    private int pirateId;

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

    public void act() 
    {
        if(PirateWorld.multiUser){
            if(world.callGETAPI_ISWINNER())
                world.setGameOver(); 
        }
   
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
             setLocation(mouse.getX(), mouse.getY());  
        } 
        if(PirateWorld.isHurdle){
            fireAnchor();
            killedByShark();
        }
    }    

    public void killedByShark(){
        Actor shark = (Shark)getOneObjectAtOffset(0,0,Shark.class);
        if(shark != null){
            removeLife();           
            world.removeObject(shark);
            HintHolder.incrSharkKilledCount();
            System.out.println("shark pirate killed");
        }
    }

    public void fireAnchor(){
         if(Greenfoot.mouseClicked(this)){
            sound.stop();
            MouseInfo mouse = Greenfoot.getMouseInfo();             
            anchor.getImage().scale(30,30);
            world.addObject(anchor,0,0);
            anchor.setLocation(mouse.getX(), mouse.getY());
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
            while(!LivesLeft.get(0).isAtEdge()){
                Greenfoot.delay(5);
                LivesLeft.get(0).move(15);
            }
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
            if(null != audio)
                audio.stop();
            if(PirateWorld.multiUser)
                world.callPUTAPI_LOOSER();
            world.setGameOver();
        }
    }

    public int getSharkKilledCount(){
        return HintHolder.getSharkKilledCount();
    }

    public void setStage(String name){
        this.stageName = name;
    }

    public void setPirateID(int id){
        this.pirateId = id;
    }
}
