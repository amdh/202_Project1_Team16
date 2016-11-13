import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class GoldenGateBridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenGateBridge extends IPlace
{
    String backgroundImgPath;
    String textHintPath;
    String soundHintPath;
    String imageHintpath ;
    String answerOption1Path ;
    String answerOption2Path;
    String answerOption3Path ;
    String answerOption4Path;
    GreenfootSound audioHint, wrongAns;
    int life = 0;
    int hint = 1;
    Shark s;
    Skull sk;
    PirateWorld world ;
    Pirates pirate;
    public GoldenGateBridge(){
        s=new Shark();
        sk = new Skull();
        s.getImage().scale(50,50);
        sk.getImage().scale(50,50);
        backgroundImgPath = "images/GoldenGateBridge/world_7.jpg";
    }

    public void act() 
    {
        checkLifeCount();
        Greenfoot.delay(5);
        s.turn(4);
        s.move(2);
        sk.turn(-4);
        sk.move(-2);
       /*s.setLocation(250, 250);
        s.setLocation(350, 150);
         s.setLocation(450, 250);
          s.setLocation(350, 350);*/
    }    

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(StartGame.class).get(0));
        setBackground(backgroundImgPath);
        world.addObject(sk, 150,150);
        world.addObject(s,250,250);
    }

    public  void doIncorrectAnswer(){}
    public  void doCorrectAnswer(){}
    public  void showHurdle(){}
    public  void setNextPlace(String placeName){}
    public  IEnemy getEnemy(String type){
        return null;
    }

    //private methods
    private void cleanPlace(){

    }
    private void initialize(){
        world =  getWorldOfType(PirateWorld.class);        
        pirate =  world.getPirate();
    }

    private void setBackground(String backgroundPath){
        world.setBackground(backgroundPath);
    }

    private void removeLife(){
        pirate.removeLife();
    }

    private void checkLifeCount(){
        pirate.checkLifeCount(audioHint);
    }
}
