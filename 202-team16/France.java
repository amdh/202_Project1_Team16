import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Australia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class France extends IPlace
{

    String backgroundImgPath;
    String textHintPath;
    String soundHintPath;
    String imageHintpath ;
    String answerOption1Path ;
    String answerOption2Path;
    String answerOption3Path ;
    String answerOption4Path;
    GreenfootSound audioHint, wrongAns, correctAns;

    int life = 0;
    int hint = 1,i=1000;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;
    PirateWorld world;
    IObserver pirate;

    public France(){
        backgroundImgPath = "images/France/world_4.jpg";
        textHintPath = "Hint1: World's most famous beach, runs for 3 miles?";
        imageHintpath = "images/copacabana/imgHint.png";
        answerOption1Path = "images/copacabana/ans1.jpg";
        answerOption2Path = "images/copacabana/ans2.jpg";
        answerOption3Path = "images/copacabana/ans3.jpg";
        answerOption4Path = "images/copacabana/ans4.jpg";
        audioHint=new GreenfootSound("images/copacabana/audioHint.mp3");
        wrongAns = new GreenfootSound("sounds/WrongAns.mp3");
        correctAns = new GreenfootSound("sounds/yeaahh.mp3");
    }

    public void draw(){
        initialize(); 
        //getPirateWorld().removeObject(world.getObjects(BasePlace.class).get(0));
        setBackground(backgroundImgPath);
        world.showHint1(textHintPath);
        //hint= hint+1;

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
        checkLifeCount();
        if(Greenfoot.mouseClicked(ansOP1))
        {
            audioHint.stop();
            System.out.println("perform correct answer function");
            doCorrectAnswer();
        }else if(Greenfoot.mouseClicked(ansOP2) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4))
        {
            audioHint.stop();
            System.out.println(" eee  answer clicked is incorrect");
            doIncorrectAnswer();
        }
        if (hint>=4){   
            if (i%100==0)
            world.showHint3("You will be promoted to the next State in "+i/100);
            i--;
            if (i == 0)
            {
                doCorrectAnswer();
            }
        }
    }    

    public  void doIncorrectAnswer(){
        System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
             wrongAns.stop();
             wrongAns.play();
             removeLife();
             hint = hint + 1;
             
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"Hint2: Major Sporting Event for 2016 were held at?");
                //hint = hint +1;                
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                //hint = hint + 1;
                world.removeObject(hintImg);
                world.showHint3("Hint3: Place referenced in the song?");
                audioHint.play();
            }
    }
    public  void doCorrectAnswer(){
        //move to next stage
        cleanPlace();
        correctAns.play();
        //audioHint.stop();
        setNextPlace(PirateWorld.hurdleShark);
    }
    public  void showHurdle(){}
    public  void setNextPlace(String placeName){
        world.setPlace(placeName);
    }
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
    
     private void checkLifeCount(){
        pirate.checkLifeCount(audioHint);
    }
}
