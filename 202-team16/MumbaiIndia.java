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

    int life = 0;
    int hint = 1;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;
    PirateWorld world ;
    Pirates pirate;

    public MumbaiIndia(){
        textHintPath = "";
        imageHintpath = "";

        backgroundImgPath = "images/Mumbai/Mumbackgroud.jpg";
        textHintPath = "";
        soundHintPath="";
        imageHintpath = "/images/Australia/mumbai.jpg";
        answerOption1Path = "images/Australia/MumIncorrectop2.jpg";
        answerOption2Path = "images/Australia/mumcorrectop.jpg";
        answerOption3Path = "images/Australia/Mumicorrectop3.jpg";
        answerOption4Path = "images/Australia/Mumincorrectop1.jpg";

    }

    public void draw(){
        initialize();
        setBackground(backgroundImgPath);
        showHint1(textHintPath);
        hint= hint+1;
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,true);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        //showHurdle();
        //showHurdle();
    }

   
    public void act() 
    {
        // Add your action code here.
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
