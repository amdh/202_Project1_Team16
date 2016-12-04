import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class IObserver extends Actor
{
   public abstract void setLife();
   public abstract void removeLife();     //observer method called from events taken place at each place
   public abstract void checkLifeCount(GreenfootSound sound);
   public abstract int getSharkKilledCount();
   public abstract int getSkeletonKilledCount();
}
