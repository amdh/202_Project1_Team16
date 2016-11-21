import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class IEnemy extends Actor
{
   public  abstract void killPirate();
   public abstract boolean checkIntersectingObjects(Pirates pirate);
}
