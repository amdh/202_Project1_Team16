import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnswerOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnswerOption extends Actor
{
    boolean isCorrectAnswer;
    
    public AnswerOption(String img, boolean isCorrect){
        this.isCorrectAnswer = isCorrect;
        setImage(img);
        //getImage().scale(50,50);
    }
    
     public AnswerOption(String img){
        this.isCorrectAnswer = false;
        setImage(img);
       
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
            if(isCorrectAnswer()){
              System.out.println(" answer clicked is correct");  
            }
           
        }
    }    
    
    public boolean isCorrectAnswer(){
        return isCorrectAnswer;
    }
}
