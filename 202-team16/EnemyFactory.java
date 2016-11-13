import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFactory extends Actor
{
    public IEnemy getEnemy(String type){

        if(type.equalsIgnoreCase("shark")){
            return new Shark();
        }else if(type.equalsIgnoreCase("skeleton")){
            return new Skeleton();
        }
        return null;
    } 

    public IEnemy[] getEnemy(String type, int count){

        IEnemy[] enemies = null;
        if(type.equalsIgnoreCase("shark")){
            enemies = new Shark[count];
            for(int i =0;i < count ; i++){
                enemies [i ] = new Shark();
            }
        }else if(type.equalsIgnoreCase("skeleton")){
            enemies = new Skeleton[count];
            for(int i =0;i < count ; i++){
                enemies [i ] = new Skeleton();
            }
        }
        return enemies;
    }
}
