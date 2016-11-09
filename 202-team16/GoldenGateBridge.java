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
    GreenfootSound audioHint;
    int life = 0;
    int hint = 1;
    Shark s;
    PirateWorld world ;

    public GoldenGateBridge(){
       s=new Shark();
backgroundImgPath = "images/GoldenGateBridge/base.jpg";
    }

    public void act() 
    {
        Greenfoot.delay(5);
        s.turn(4);
        s.move(2);
    }    

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(StartGame.class).get(0));
        setBackground(backgroundImgPath);
        
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
       
    }

    private void setBackground(String backgroundPath){
      
    }

    private void removeLife(){
       
    }
}
