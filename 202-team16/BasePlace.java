import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BasePlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasePlace extends Place
{
    String backgroundImgPath;
    String textHintPath;
    String soundHintPath;
    String imageHintpath ;
    String answerOption1Path ;
    String answerOption2Path;
    String answerOption3Path ;
    String answerOption4Path;
    String correctAnswerPath;
    int life = 0;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;

    public BasePlace(){
        backgroundImgPath = "images/base.jpg";
        textHintPath = "";
        soundHintPath="";
        imageHintpath = "";
        answerOption1Path = "images/boat1.png";
        answerOption2Path = "";
        answerOption3Path = "";
        answerOption4Path = "";
        correctAnswerPath = "";

    }
    public void act() 
    {
        // Add your action code here.
    }    

    public void draw(){
        PirateWorld world = getWorldOfType(PirateWorld.class);
        List<Life> pirateLife = world.getLife();
        life = pirateLife.size();
        world.setBackground(backgroundImgPath);
        world.showText("Kangaroo is the nation animal of ...",200,200 );

        Greenfoot.delay(10);
        Pirates p = world.getPirate();
        world.addObject(p,50,600);

        ansOP1 = new  AnswerOption(answerOption1Path);
        ansOP2 = new  AnswerOption(answerOption2Path);
        ansOP3 = new  AnswerOption(answerOption3Path);
        ansOP4 = new  AnswerOption(answerOption4Path);
        ansOP1.getImage().scale(50,50);
        world.addObject(ansOP1,100,50);

        showHurdle();
    }

    public void showHurdle(){

    }
}