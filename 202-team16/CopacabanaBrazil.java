import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SugarloafMountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopacabanaBrazil extends IPlace
{
    /**
     * Act - do whatever the SugarloafMountain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CopacabanaBrazil(){

        GreenfootImage image = new GreenfootImage("images/copacabana/background.jpg");
        image.scale(100,100);
        //getWorld().getBackground().drawImage(image, 200,200);

    }

    public void act() 
    {
        // Add your action code here.
       // setRotation(getRotation() + 5);       
        move(1);
    }    
    
     public void draw(){
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
       

    }

    private void initialize(){
       
    }

    private void setBackground(String backgroundPath){
      
    }

    private void removeLife(){
       
    }
}
