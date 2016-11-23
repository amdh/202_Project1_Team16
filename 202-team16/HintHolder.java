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
    private static int skeletonKilledCnt;

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
            System.out.println("skeleton killed");
            getWorld().removeObject(skeleton);
            skeletonKilledCnt++;
            getWorld().removeObject(this);           
        } else if(isAtEdge()){
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

    public void killSkeleton(){
        Actor skeleton = getOneIntersectingObject(Skeleton.class);

        if(skeleton != null){
            System.out.println("shark killed");
            getWorld().removeObject(skeleton);
            getWorld().removeObject(this);
            // break;
        }
    }

    public void killShark(Actor shark){
        System.out.println("shark killed");
        getWorld().removeObject(shark);
        sharkKilledCnt++;
        getWorld().removeObject(this);
    }
}


