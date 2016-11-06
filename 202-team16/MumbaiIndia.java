import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MumbaiIndia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MumbaiIndia extends Place
{
    /**
     * Act - do whatever the MumbaiIndia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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

    public MumbaiIndia(){
        backgroundImgPath = "images/Mumbai/background.jpg";
        textHintPath = "To win there is a cape of good hope";
        soundHintPath="";
        imageHintpath = "images/CapeTownAfrica/hintimg.jpg";
        
        answerOption1Path = "images/CapeTownAfrica/CapeTownCorrectOption.jpg";
        answerOption2Path = "images/CapeTownAfrica/CapeTownIncorrectOption1.jpg";
        answerOption3Path = "images/CapeTownAfrica/CapeTownIncorrectOption2.jpg";
        answerOption4Path = "images/CapeTownAfrica/CapeTownIncorrectOption3.jpg";
        
        audioHint=new GreenfootSound("images/CapeTownAfrica/audioHint.mp3");  
    }

    public void draw(){
        initialize();
        setBackground(backgroundImgPath);
        showHint1(textHintPath);
        hint= hint+1;
        
        ansOP1 = new  AnswerOption(answerOption1Path,true);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        //showHurdle();
        //showHurdle();
    }

   
    public void act() 
    {
        // Add your action code here.
        // Add your action code here.
        if(Greenfoot.mouseClicked(ansOP1))
        {

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            audioHint.stop();
            setNextPlace(new CapetownAfrica());
            

        }else if(Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4))
        {
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                showHint2(hintImg,"Penguins in Boulder Island...");
                hint = hint +1;
                removeLife();
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                hint = hint + 1;
                world.removeObject(hintImg);
                showHint3("In the search for the shores of her bay");
                audioHint.play();
            }
        }
    }    
     public void showHurdle(){

    }
    public void cleanPlace(){
        getPirateWorld().removeObject(ansOP2);
        getPirateWorld().removeObject(ansOP1);
        getPirateWorld().removeObject(ansOP3);
        getPirateWorld().removeObject(ansOP4);
        if(null != hintImg){
            getPirateWorld().removeObject(hintImg);
        }
        showHint1("");
    }
}
