import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Australia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Australia extends IPlace
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

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;

    PirateWorld world;
    Pirates pirate;

    public Australia(){
        backgroundImgPath = "images/AusBackground.jpg";
        textHintPath = "Bollywood is Here?";
        imageHintpath = "images/Mumbai/MumbaiImgHint.jpg";
        answerOption1Path = "images/Mumbai/Mumicorrectop3.jpg";
        answerOption2Path = "images/Mumbai/MumIncorrectop2.jpg";
        answerOption3Path = "images/Mumbai/mumcorrectop.jpg";
        answerOption4Path = "images/Mumbai/Mumicorrectop1.jpg";
        audioHint=new GreenfootSound("images/Mumbai/mumbai.mp3");

    }

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(BasePlace.class).get(0));
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,true);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

    }

    /**
     * Act - do whatever the Australia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void act() 
    {
        checkLifeCount();
        
        if(Greenfoot.mouseClicked(ansOP3))
        {

            System.out.println("weeee answer clicked is correct");
            doCorrectAnswer();

        }else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP4))
        {
            System.out.println(" eee  answer clicked is incorrect");
            doIncorrectAnswer();
        }
    }    

    public  void doIncorrectAnswer(){
        //remove life and repaint the screen
        removeLife();
        if(hint==2){
            System.out.println("you are asking for 2nd hint");
            hintImg = new AnswerOption(imageHintpath);
            world.showHint2(hintImg,"This famous fast food belongs to?");
            hint = hint +1;
        }
        else if(hint==3){
            //playsound
            System.out.println("you are asking for 3rd hint");
            hint = hint + 1;
            world.removeObject(hintImg);
            world.showHint3("Place referenced in the song?");
            audioHint.play();
        }
    }

    public  void doCorrectAnswer(){
        //move to next stage
        cleanPlace();
        audioHint.stop();
        setNextPlace(PirateWorld.secondPlace);
    }

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){
        world.setPlace(placeName);
    }

    public  IEnemy getEnemy(String type){return null;}
    //private methods
    private void cleanPlace(){
        world.removeObject(ansOP2);
        world.removeObject(ansOP1);
        world.removeObject(ansOP3);
        world.removeObject(ansOP4);
        if(null != hintImg){
            world.removeObject(hintImg);
        }
        world.showHint1("");

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
