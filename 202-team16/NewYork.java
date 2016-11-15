import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class NewYork here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewYork extends IPlace
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
    int hint = 1,i=1000;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;
    PirateWorld world ;
    Pirates pirate;

    public NewYork(){
       backgroundImgPath = "images/NewYork/world_6.jpg";
        textHintPath = "World's most crooked street are here??";
        soundHintPath="";
        imageHintpath = "images/GoldenGateBridge/hintImg.jpg";
        answerOption1Path = "images/GoldenGateBridge/op1.jpg";
        answerOption2Path = "images/GoldenGateBridge/op2.jpg";
        answerOption3Path = "images/GoldenGateBridge/op3.jpg";
        answerOption4Path = "images/GoldenGateBridge/op4.jpg";
        audioHint=new GreenfootSound("images/GoldenGateBridge/audioHint.mp3");
        wrongAns = new GreenfootSound("sounds/WrongAns.mp3");

    }

    public void act() 
    {
        checkLifeCount();
        if(Greenfoot.mouseClicked(ansOP2)){

             System.out.println("perform correct answer function");
            doCorrectAnswer();
        }
        else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4)){
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
        //getPirateWorld().removeObject(world.getObjects(StartGame.class).get(0));
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        //hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,true);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
    }

    public  void doIncorrectAnswer(){
        //remove life and repaint the screen
             wrongAns.stop();
             removeLife();
             hint = hint + 1;
             wrongAns.play();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"The garden is Japenese but not in Japan!!");
                //hint = hint +1;
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                world.removeObject(hintImg);
                //hint = hint + 1;
                world.showHint3("Place referenced in the song?");
                audioHint.play();
            }
    }

    public  void doCorrectAnswer(){
        //move to next stage
        cleanPlace();
        audioHint.stop();
        setNextPlace(PirateWorld.seventhPlace);
    }

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){
         world.setPlace(placeName);
    }

    public  IEnemy getEnemy(String type){
        return null;
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
