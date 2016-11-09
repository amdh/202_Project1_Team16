import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CapetownAfrica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CapetownAfrica extends IPlace
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
    
    public CapetownAfrica()
    {
        backgroundImgPath = "images/CapeTownAfrica/background.jpg";
        textHintPath = "Da Vinci Code was shot in it's capital city ";
        soundHintPath="images/France/audioHint.mp3";
        imageHintpath = "images/France/hintimg.jpg";
        
        answerOption1Path = "images/France/IncorrectOption1.jpg";
        answerOption2Path = "images/France/IncorrectOption2.jpg";
        answerOption3Path = "images/France/CorrectOption.png";
        answerOption4Path = "images/France/IncorrectOption3.jpg";
        
        audioHint=new GreenfootSound("images/France/audioHint.mp3");  
    }
    
    public void draw(){
        initialize();
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        hint= hint+1;
        //hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,false);
        ansOP3 = new  AnswerOption(answerOption3Path,true);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
    }
    
   
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mouseClicked(ansOP3))
        {

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            audioHint.stop();
            setNextPlace(PirateWorld.forthPlace);

        }else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP4))
        {
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"Romance Capital");
                hint = hint +1;
                removeLife();
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                hint = hint + 1;
                world.removeObject(hintImg);
                world.showHint3("Try to guess from audio..");
                audioHint.play();
            }
        }
    } 
    
    public  void doIncorrectAnswer(){}
    public  void doCorrectAnswer(){}
    public  void showHurdle(){}
    public  void setNextPlace(String placeName){}
    public  IEnemy getEnemy(String type){
        return null;
    }

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
}

