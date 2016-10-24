import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Australia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Australia extends Place
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
    
    public Australia(){
        backgroundImgPath = "images/Australia/AusBackground.jpg";
        textHintPath = "";
        soundHintPath="";
        imageHintpath = "";
        answerOption1Path = "images/Australia/MumIncorrectop2.jpg";
        answerOption2Path = "images/Australia/mumcorrectop";
        answerOption3Path = "images/Australia/Mumicorrectop3";
        answerOption4Path = "images/Australia/Mumincorrectop1";
       // correctAnswerPath = "";

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

        //showHurdle();
    }
    
    /**
     * Act - do whatever the Australia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
