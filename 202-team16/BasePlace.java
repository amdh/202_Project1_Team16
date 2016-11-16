import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BasePlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasePlace extends IPlace
{
    String backgroundImgPath;
    String textHintPath;
    String imageHintpath ;
    String answerOption1Path ;
    String answerOption2Path;
    String answerOption3Path ;
    String answerOption4Path;
    GreenfootSound audioHint, wrongAns, correctAns;

    int life = 0;
    int hint = 1,i=1000;
    boolean hurdle = false;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;

    PirateWorld world;
    Pirates pirate;

    public BasePlace(){
        backgroundImgPath = "images/baseplace/world_0.jpg";
        textHintPath = "Smallest continent in the world is?";
        imageHintpath = "images/baseplace/AusHintImage.jpg";
        answerOption1Path = "images/baseplace/AusCorrectop.jpg";
        answerOption2Path = "images/baseplace/Ausincorrectop2.jpg";
        answerOption3Path = "images/baseplace/Ausincorrectop3.jpg";
        answerOption4Path = "images/baseplace/Ausincorrectop1.jpg";
        audioHint=new GreenfootSound("images/baseplace/audioHint.mp3");
        wrongAns = new GreenfootSound("sounds/WrongAns.mp3");
        correctAns = new GreenfootSound("sounds/yeaahh.mp3");
    }

    public void act() 
    {
        /*if(hurdle){
            if (Greenfoot.getRandomNumber(300)<3){
                world.addObject(getEnemy("shark"), 1500,800);
            }
        }*/
        checkLifeCount();
        if(Greenfoot.mouseClicked(ansOP1)){
            audioHint.stop();
            System.out.println("perform correct answer function");
            doCorrectAnswer();
        }else if(Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4)){
            audioHint.stop();
            System.out.println(" eee  answer clicked is incorrect");
            doIncorrectAnswer();
        }
        if (hint>=4){   
            if (i%100==0)
            world.showHint3("You will be promoted to the next step in "+i/100);
            i--;
            if (i == 0)
            {
                doCorrectAnswer();
            }
        }
    }    

    public void draw(){
        initialize(); 
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        //hint= hint+1;
        ansOP1 = new  AnswerOption(answerOption1Path,true);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);
        //showHurdle();
    }

    public void showHurdle(){
        EnemyFactory f = new EnemyFactory();
        IEnemy s1 = f.getEnemy("shark");
        s1.getImage().scale(250,300);
        world.addObject(s1,1400,700); 
        IEnemy s2 = f.getEnemy("shark");
        s2.getImage().scale(250,300);
        world.addObject(s2,1500,800); 
    }

    public void setNextPlace(String placeName){
        world.setPlace(placeName);
    }

    public void doCorrectAnswer(){
        //move to next stage
        correctAns.play();
        cleanPlace();
        //audioHint.stop();
        setNextPlace(PirateWorld.firstPlace);
    }

    public void doIncorrectAnswer(){
        //remove life and repaint the screen
        wrongAns.stop();
        removeLife();
        hint = hint + 1;
        System.out.println(hint);
        wrongAns.play();
        if(hint==2){
            System.out.println("you are asking for 2nd hint");
            hintImg = new AnswerOption(imageHintpath);
            world.showHint2(hintImg,"This is National animal of which country?");
        }
        else if(hint==3){
            //playsound
            System.out.println("you are asking for 3rd hint"); 
            world.removeObject(hintImg);
            world.showHint3("This Song belongs to famous band from?");
            audioHint.play(); 
        }
    }

    public IEnemy getEnemy(String type){
        EnemyFactory f = new EnemyFactory();
        IEnemy s1 = f.getEnemy(type);
        return s1;
    }

    //end of implemented methods
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
