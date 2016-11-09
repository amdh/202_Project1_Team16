import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class IPlace extends Actor
{

    public  abstract void draw();
    public abstract void doIncorrectAnswer();
    public abstract void doCorrectAnswer();
    public abstract void showHurdle();
    public abstract void setNextPlace(String placeName);
    public abstract IEnemy getEnemy(String type);
    
   
}
