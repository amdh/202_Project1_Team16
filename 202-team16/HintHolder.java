import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HintHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HintHolder extends Actor
{

    private static int sharkKilledCnt = 0;
    private static int skeletonKilledCnt = 0;

    public HintHolder(){
       
    }

    public void act() 
    {
        setLocation(getX() + 2, getY());        
        Actor shark  = getOneObjectAtOffset(0,0,Shark.class);
        Actor skeleton = getOneIntersectingObject(Skeleton.class);

        if(shark !=null){  
            killShark(shark);
        }else if(skeleton != null){
            killSkeleton(skeleton);
        } 
        else if(isAtEdge()){
            getWorld().removeObject(this);
        }

        //killShark();
        //killSkeleton();
    }

    public static int getSharkKilledCount(){
        return sharkKilledCnt;
    }

    public static void incrSharkKilledCount(){
        sharkKilledCnt++;
    }

    public static void incrSkeletonKilledCount(){
        skeletonKilledCnt++;
    }

    public static int getSkeletonKilledCount(){
        return skeletonKilledCnt;
    }

    public void killSkeleton(Actor skeleton){
            System.out.println("skeleton killed");
            getWorld().removeObject(skeleton);
            skeletonKilledCnt++;
            getWorld().removeObject(this);
            // break;
        }

    public void killShark(Actor shark){
        System.out.println("shark killed");
        getWorld().removeObject(shark);
        sharkKilledCnt++;
        getWorld().removeObject(this);
    }
}


