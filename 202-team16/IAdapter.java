import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Adapter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IAdapter
{
    
    //add player into gameroom
    public void callPOSTAPI();

    
    //update the player current place
    public void callPUTAPI();

    
    //update player with winner when he wins the game
    public void callPUTAPI_WINNER();

    
    //update player with dead when players looses game
    public void callPUTAPI_LOOSER();

    
    //returns if there there is any player if yes sets the winner 
    public boolean callGETAPI_ISWINNER();

    
    //returns total player count
    public int callGETAPI_PLAYERCOUNT();
    
    
    //check if there is winner else call put to update the player stage
    public void doPlayAPI();
    
    
    
}
