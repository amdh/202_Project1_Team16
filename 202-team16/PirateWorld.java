import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class MyWorld here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PirateWorld extends World
{
    static final String basePlace = "BASEPLACE";
    static final String firstPlace =  "AUSTRALIA";
    static final String secondPlace = "MUMBAI";
    static final String thirdPlace =  "CAPETOWN";
    static final String forthPlace = "FRANCE";
    static final String fifthPlace =  "BRAZIL";
    static final String sixthPlace = "NEWYORK";
    static final String seventhPlace = "GOLDENGATE";
    static final String hurdleShark= " HURDLESHARK";
    static final String hurdleSkeleton = "HURDLESKELETON";

    static boolean multiUser = false;
    static boolean isHurdle = false;

    private static final String URL = "http://pirates-c7d5c1a1-1.4e53aff4.cont.dockerapp.io:8181/pirategameroom";//"http://pirates-c7d5c1a1-1.4e53aff4.cont.dockerapp.io:8181/pirategameroom";

    private ClientResource client ; 

    Button startGame, quit, play, rules;
    Pirates pirate;
    IPlace currentPlace;
    Life pirateBoat;
    Story story;
    DisRule rule; 
    Message message;
    String pirateName;
    int pirateID;
    String winner;
    GreenfootSound sound = new GreenfootSound("sounds/theme.mp3");
    GreenfootSound gameOver = new GreenfootSound("sounds/GameOver.mp3");

    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500  , 880   , 1);
        setWelcomeScreen(); 
        message = new Message();
        if(multiUser)
            client = new ClientResource( URL ); 
    }

    //shows first screen
    public void setWelcomeScreen(){
        startGame = new StartGame();
        addObject(startGame, 1300,700);
    }

    //shows introduction about game with story, rules and quit play opions
    public void setIntroScreen(){
        play = new Play();
        quit = new Quit();
        rules = new Rules();
        story = new Story();
        play.getImage().scale(80,80);
        quit.getImage().scale(70,70);
        rules.getImage().scale(65,65);
        addObject(story, 1250,400);
        addObject(play, 1410,700);
        addObject(quit, 1180,700);
        addObject(rules, 1300,700);
    }

    //shows game over screen
    public void setGameOver(){

        gameOver.play();
        Greenfoot.stop();      
        removeObjects(getObjects(null)); //removes all the objects in the world;
        addObject(new GameOver(), getWidth()/2, getHeight()/2); //adds the game over screen in the middle of the world;  
    }

    //shows the winner screen
    public void setWinnerScreen(){
        Greenfoot.stop();
        removeObjects(getObjects(null)); //removes all the objects in the world;
        addObject(new GameWon(), getWidth()/2, getHeight()/2); //adds gamewon screen
    }

    //sets the game rules
    public void setRules(){
        if(story!=null)
            removeObject(story);
        if(rule!=null)
        {
            removeObject(rule);
            story = new Story();
            addObject(story, 1250,400);
        }
        else
        {   rule = new DisRule();
            addObject(rule, 1250,320);
        }
    }

    //add player into gameroom
    private void callPOSTAPI(){

        JSONObject json_start = new JSONObject();
        json_start.put("stage",this.currentPlace.getClass().getName());

        Representation result_string = client.post(new JsonRepresentation(json_start), MediaType.APPLICATION_JSON);
        try {
            JSONObject json = new JSONObject( result_string.getText() ) ;

            if(!json.isNull("Error"))
            {
                Message msg = new Message();
                msg.display("Maximum number of players already allocated.");
                addObject(msg, getWidth()/2, getHeight()/2);
                Greenfoot.delay(150);
                System.exit(1);
            }
            else
            {
                pirateName= "Player"+(int) json.get("player") ;
                pirateID = (int) json.get("player");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage()) ;
        }  
        Message player = new Message();
        player.display(pirateName);
        addObject(player,1400,50);
        System.out.println(pirateName);

    }

    //update the player current place
    private void callPUTAPI(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pirateID);
        json_update.put("stage",currentPlace.getClass().getName());
        Representation result_string = client.put(new JsonRepresentation(json_update), MediaType.APPLICATION_JSON);
    }

    //update player with winner when he wins the game
    public void callPUTAPI_WINNER(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pirateID);
        json_update.put("stage","WINNER");
        Representation result_string = client.put(new JsonRepresentation(json_update), MediaType.APPLICATION_JSON);
    }

    //update player with dead when players looses game
    public void callPUTAPI_LOOSER(){
        JSONObject json_update = new JSONObject();
        json_update.put("player",pirateID);
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
            winner = json.getString("player");            
        }
        catch (Exception e) {
            winner = e.getMessage() ;
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
    private void doPlayAPI(){
        if(multiUser){
            if(callGETAPI_ISWINNER()){
                if(winner.equals(pirateID)){
                    setWinnerScreen();
                }else{
                    setGameOver();
                }
            }
            callPUTAPI();  
        }
    }

    // calls post api for entering player into gameroom
    //if already 5 players error is displayed
    //if less than 5 playes , waiting messesage is displayed till player count becomes 5
    //if 5 then proceed
    private void doEnterAPI(){
        if(multiUser){ 
            callPOSTAPI();       

            Message msg = new Message();
            msg.display("Please wait for all 5 members to join the room.");    
            addObject(msg, getWidth()/2, getHeight()/2);
            repaint();//needed to repaint the message before executing the loop
            do{     
                int count = callGETAPI_PLAYERCOUNT();
                if( count == 5){
                    break;
                }else if(count < 5){
                    continue;                     
                }

            }while(true);
            removeObject(msg);
        }
    }

    //sets the current place 
    public void setPlace(String placename)
    {
        if(this.currentPlace != null){
            removeObject(this.currentPlace);
        }
        System.out.println(placename);

        switch(placename.toUpperCase()){

            case basePlace:  this.currentPlace = new BasePlace();
            doEnterAPI();
            break;
            case firstPlace: this.currentPlace = new Australia();
            doPlayAPI();
            break;
            case forthPlace: this.currentPlace = new France();
            doPlayAPI();           
            break;
            case secondPlace: this.currentPlace = new MumbaiIndia();
            doPlayAPI();
            break;
            case thirdPlace: this.currentPlace = new CapetownAfrica();
            doPlayAPI();
            break;
            case fifthPlace: this.currentPlace = new CopacabanaBrazil();
            doPlayAPI();
            break;
            case sixthPlace: this.currentPlace = new NewYork();
            doPlayAPI();
            break;                
            case seventhPlace: this.currentPlace = new GoldenGateBridge();
            doPlayAPI();
            break;
            case hurdleShark: this.currentPlace = new HurdleShark();
            isHurdle = true;
            doPlayAPI();
            break;
            case hurdleSkeleton: this.currentPlace = new HurdleSkeleton();
            isHurdle = true;
            doPlayAPI();
            break;
            default : this.currentPlace = new BasePlace();

        }

        addObject(currentPlace,0,0);
        currentPlace.draw();
    }

    //when game starts play the background music
    public void started(){
        sound.play();
    }

    //stop the backfground music
    public void stopped(){
        sound.stop();
    }

    //sets the pirate for the game
    public void setPirate(){
        sound.stop();
        pirate = new Pirates();
        pirateBoat = new Life();
        pirateBoat.getImage().scale(500,400);
        Greenfoot.delay(10);
        addObject(pirate,150,750);
        pirate.setLife();
    }

    public Message getMessage(){
        return message;
    }

    public Pirates getPirate()
    {
        return pirate;
    }

    public IPlace getCurrentPlace(){
        return currentPlace;
    }

    public void cleanIntro(){
        removeObject(play);
        removeObject(quit);
        removeObject(rules);
        if(story!=null)
            removeObject(story);
        if(rule!=null)
            removeObject(rule);
    }

    //sets the answer optiosn for the current place
    public void setAnswerOptions(AnswerOption ans1, AnswerOption ans2, AnswerOption ans3, AnswerOption ans4 ){

        Greenfoot.delay(30);
        int x =70 , y = 100;
        ans1.getImage().scale(180,180);
        addObject(ans1,x,y);
        x=x+195;
        ans2.getImage().scale(180,180);
        addObject(ans2,x,y);
        x=x+195;
        ans3.getImage().scale(180,180);
        addObject(ans3,x,y);
        x=x+195;
        ans4.getImage().scale(180,180);
        addObject(ans4,x,y);

    }

    //shows the first hint for next place
    public void showHint1(String msg){
        Greenfoot.delay(20);
        message.display(msg);
        addObject(message,360,250);
    }

    //shows the second hint for next place
    public void showHint2(AnswerOption hintImg, String msg){
        message.display(msg);       
        hintImg.getImage().scale(200,180);
        addObject(hintImg, 200,400);
    }

    //shows the third hint for next place
    public void showHint3(String msg){
        message.display(msg);
    }

    //shows the general message
    public void showMessage(String msg){
        message.display(msg);
    }

}
