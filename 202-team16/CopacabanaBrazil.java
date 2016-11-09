import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class CopacabanaBrazil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopacabanaBrazil extends IPlace
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
     PirateWorld world ;
    Pirates pirate;

    public CopacabanaBrazil(){
        backgroundImgPath = "images/Copacabana/base.jpe";
        textHintPath = "City that never sleeps?";
        imageHintpath = "images/NewYork/imgHint.jpg";
        answerOption1Path = "images/NewYork/op1.jpg";
        answerOption2Path = "images/NewYork/op2.jpg";
        answerOption3Path = "images/NewYork/op3.jpg";
        answerOption4Path = "images/NewYork/op4.jpg";
        audioHint=new GreenfootSound("images/NewYork/audioHint.mp3");

    }

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(BasePlace.class).get(0));
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,true);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
    }

    /**
     * Act - do whatever the Australia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void act() 
    {
        if(Greenfoot.mouseClicked(ansOP4))
        {

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            audioHint.stop();
            setNextPlace(PirateWorld.sixthPlace);

        }else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP3))
        {
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"Where is this statue......?");
                hint = hint +1;
                removeLife();
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
    }    


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

    public  void doIncorrectAnswer(){}

    public  void doCorrectAnswer(){}

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){}

    public  IEnemy getEnemy(String type){
        return null;
    }

    private void initialize(){

    }

    private void setBackground(String backgroundPath){

    }

    private void removeLife(){

    }
}
