import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class ClientAdapter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClientAdapter implements IAdapter
{
   private static final String URL = "http://piratesv3-fb7fbfa7-1.c43b8203.cont.dockerapp.io:8080/pirategameroom";//"http://localhost:8080/pirategameroom";
   PirateWorld pWorld;
    private ClientResource client ; 
    public ClientAdapter(PirateWorld p)
    {
         client = new ClientResource( URL ); 
         this.pWorld = p;
    }
    
    //add player into gameroom
    public void callPOSTAPI(){

        JSONObject json_start = new JSONObject();
        json_start.put("stage",pWorld.currentPlace.getClass().getName());

        Representation result_string = client.post(new JsonRepresentation(json_start), MediaType.APPLICATION_JSON);
        try {
            JSONObject json = new JSONObject( result_string.getText() ) ;

            if(!json.isNull("Error"))
            {
                Message msg = new Message();
                msg.display("Maximum number of players already allocated.");
                pWorld.addObject(msg, pWorld.getWidth()/2, pWorld.getHeight()/2);
                Greenfoot.delay(150);
                System.exit(1);
            }
            else
            {
                pWorld.pirateName= "Player"+(int) json.get("player") ;
                pWorld.pirateID = (int) json.get("player");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage()) ;
        }  
        Message player = new Message();
        player.display(pWorld.pirateName);
        pWorld.addObject(player,1400,50);
        System.out.println(pWorld.pirateName);

    }

    //update the player current place
    public void callPUTAPI(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pWorld.pirateID);
        json_update.put("stage",pWorld.currentPlace.getClass().getName());
        Representation result_string = client.put(new JsonRepresentation(json_update), MediaType.APPLICATION_JSON);
    }

    //update player with winner when he wins the game
    public void callPUTAPI_WINNER(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pWorld.pirateID);
        json_update.put("stage","WINNER");
        Representation result_string = client.put(new JsonRepresentation(json_update), MediaType.APPLICATION_JSON);
    }

    //update player with dead when players looses game
    public void callPUTAPI_LOOSER(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pWorld.pirateID);
        json_update.put("stage","DEAD");
        Representation result_string = client.put(new JsonRepresentation(json_update), MediaType.APPLICATION_JSON);
    }

    //returns if there there is any player if yes sets the winner 
    public boolean callGETAPI_ISWINNER(){
        boolean isWinner = false;      
        Representation result_string = client.get();
        try {
            JSONObject json = new JSONObject( result_string.getText() ) ;
            isWinner= (boolean) json.get("winner") ;
            pWorld.winner = json.getString("player");            
        }
        catch (Exception e) {
            pWorld.winner = e.getMessage() ;
        } 
        return isWinner;
    }

    //returns total player count
    public int callGETAPI_PLAYERCOUNT(){
        int playerCount = 0;
        String winner;
        Representation result_string = client.get();
        try {
            JSONObject json = new JSONObject( result_string.getText() ) ;
            playerCount= (int) json.get("playerCount") ;
            winner = json.getString("player");            
        }
        catch (Exception e) {
            winner = e.getMessage() ;
        } 
        return playerCount;
    }

    //check if there is winner else call put to update the player stage
    public void doPlayAPI(){
        if(pWorld.multiUser){
            if(callGETAPI_ISWINNER()){
                if(pWorld.winner.equals(pWorld.pirateID)){
                    pWorld.setWinnerScreen();
                }else{
                    pWorld.setGameOver();
                }
            }
            callPUTAPI();  
        }
    }

    // calls post api for entering player into gameroom
    //if already 5 players error is displayed
    //if less than 5 playes , waiting messesage is displayed till player count becomes 5
    //if 5 then proceed
    public void doEnterAPI(){
        if(pWorld.multiUser){ 
            callPOSTAPI();       

            Message msg = new Message();
            msg.display("Please wait for all 5 members to join the room.");    
            pWorld.addObject(msg, pWorld.getWidth()/2, pWorld.getHeight()/2);
            pWorld.repaint();//needed to repaint the message before executing the loop
            do{     
                int count = callGETAPI_PLAYERCOUNT();
                if( count == 5){
                    break;
                }else if(count < 5){
                    continue;                     
                }

            }while(true);
            pWorld.removeObject(msg);
        }
    }
}
