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

    public NewYork(){
       backgroundImgPath = "images/NewYork/base.jpg";
        textHintPath = "You can find the world's most crooked street over here!!";
        soundHintPath="";
        imageHintpath = "images/GoldenGateBridge/hintImg.jpg";
        answerOption1Path = "images/GoldenGateBridge/op1.jpg";
        answerOption2Path = "images/GoldenGateBridge/op2.jpg";
        answerOption3Path = "images/GoldenGateBridge/op3.jpg";
        answerOption4Path = "images/GoldenGateBridge/op4.jpg";
        audioHint=new GreenfootSound("images/GoldenGateBridge/audioHint.mp3");

    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(ansOP2)){

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            setNextPlace(PirateWorld.seventhPlace);
            audioHint.stop();
        }else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4)){
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"The garden is Japenese but not in Japan!!");
                hint = hint +1;
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                world.removeObject(hintImg);
                hint = hint + 1;
                world.showHint3("Place referenced in the song?");
                audioHint.play();
            }
        }
    }    

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(StartGame.class).get(0));
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,true);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
    }

    public  void doIncorrectAnswer(){}

    public  void doCorrectAnswer(){}

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){}

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
    }

    private void setBackground(String backgroundPath){
    }

    private void removeLife(){
    }
}
