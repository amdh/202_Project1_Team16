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

    int life = 0;
    int hint = 1;

    AnswerOption ansOP1;
    AnswerOption ansOP2;
    AnswerOption ansOP3;
    AnswerOption ansOP4;
    AnswerOption hintImg;
    PirateWorld world ;
    
    public Australia(){
        
        textHintPath = "Smallest continent in the world?";
        imageHintpath = "images/baseplace/AusHintImage.jpg";
        
        backgroundImgPath = "images/Australia/AusBackground.jpg";
        textHintPath = "Bollywood is here.";
        soundHintPath="";
        imageHintpath = "/images/Australia/mumbai.jpg";
        answerOption1Path = "images/Australia/MumIncorrectop2.jpg";
        answerOption2Path = "images/Australia/mumcorrectop.jpg";
        answerOption3Path = "images/Australia/Mumicorrectop3.jpg";
        answerOption4Path = "images/Australia/Mumincorrectop1.jpg";
       // correctAnswerPath = "";

    }
    
    public void draw(){
        world =  getWorldOfType(PirateWorld.class);
        //world.removeObject(world.getObjects(StartGame.class).get(1));

        world.setBackground(backgroundImgPath);

        world.setLife();
        world.setPirate();

        List<Life> pirateLife = world.getLife();
        life = pirateLife.size();

        world.showHint1(textHintPath);
        hint= hint+1;

        ansOP1 = new  AnswerOption(answerOption1Path,false);
        ansOP2 = new  AnswerOption(answerOption2Path,true);
        ansOP3 = new  AnswerOption(answerOption3Path,false);
        ansOP4 = new  AnswerOption(answerOption4Path,false);
        world.setAnswerOptions(ansOP1,ansOP2,ansOP3,ansOP4);

        showHurdle();
        //showHurdle();
    }
    
    /**
     * Act - do whatever the Australia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void act() 
    {
       if(Greenfoot.mouseClicked(ansOP2))
       {

            System.out.println("weeee answer clicked is correct");
            //move to next stage
            cleanPlace();
            world.setState(world.getMumbaiIndia());

        }else if(Greenfoot.mouseClicked(ansOP1) || Greenfoot.mouseClicked(ansOP3) || Greenfoot.mouseClicked(ansOP4))
        {
            System.out.println(" eee  answer clicked is incorrect");
            //remove life and repaint the screen
            world.removeLife();
            if(hint==2){
                System.out.println("you are asking for 2nd hint");
                hintImg = new AnswerOption(imageHintpath);
                world.showHint2(hintImg,"National Animal of...?");
                hint = hint +1;
            }
            else if(hint==3){
                //playsound
                System.out.println("you are asking for 3rd hint");
                hint = hint + 1;
            }
       }
    }    
    
    public void showHurdle(){

    }

    public void cleanPlace(){
        world.removeObject(ansOP2);
        world.removeObject(ansOP1);
        world.removeObject(ansOP3);
        world.removeObject(ansOP4);
        if(null != hintImg){
        world.removeObject(hintImg);
        }
        
    }
}
