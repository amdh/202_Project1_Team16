import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldenGateBridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenGateBridge extends Place
{
    /**
     * Act - do whatever the GoldenGateBridge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void draw(){
    }
    
    
    public void cleanPlace(){
    }
}
/*import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class NewYork here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewYork extends Place
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

    public NewYork(){
        backgroundImgPath = "images/NewYork/base.jpg";
        textHintPath = "City that never sleeps?";
        soundHintPath="";
        imageHintpath = "images/NewYork/hint.jpg";
        answerOption1Path = "images/NewYork/op1.jpg";
        answerOption2Path = "images/NewYork/op2.jpg";
        answerOption3Path = "images/NewYork/op3.jpg";
        answerOption4Path = "images/NewYork/op4.jpg";
        audioHint=new GreenfootSound("images/NewYork/audioHint.mp3");

    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(ansOP4)){

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            setNextPlace(new MumbaiIndia());
            audioHint.stop();
        }else if(Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP1)){
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                showHint2(hintImg,"Where is this statue......?");
                hint = hint +1;
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                hint = hint + 1;
                audioHint.play();
            }
        }
    }    

    public void draw(){
        initialize(); 
        getPirateWorld().removeObject(world.getObjects(StartGame.class).get(0));
        setBackground(backgroundImgPath);
        showHint1(textHintPath);
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,true);
        setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
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
}*/
