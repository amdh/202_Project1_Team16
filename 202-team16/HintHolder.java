import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HintHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HintHolder extends Actor
{
   
    private static int sharkKilledCnt;
    
    public HintHolder(){
       
    }

    public void act() 
    {
        setLocation(getX() + 2, getY());        


        killShark();
        killSkeleton();
        
        
        if( getX() == (getWorld().getWidth() - 10)){
            getWorld().removeObject(this);
        }
        //getWorld().removeObject(this);
    }

    public void killShark(){
        Actor shark = getOneObjectAtOffset(0,0,Shark.class);

        if(shark != null){
            System.out.println("shark killed");
            getWorld().removeObject(shark);
            
            // break;
            sharkKilledCnt++;
        }
    }

    public static int getSharkKilledCount(){
        return sharkKilledCnt;
    }
    public void killSkeleton(){
        Actor skeleton = getOneObjectAtOffset(0,0,Skeleton.class);

        if(skeleton != null){
            System.out.println("shark killed");
            getWorld().removeObject(skeleton);
            // getWorld().removeObject(this);
            // break;
        }
    }

}
