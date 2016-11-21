import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class GoldenGateBridge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenGateBridge extends IPlace
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
    int hint = 1;
    IEnemy shark;
    IEnemy skull1;
    IEnemy skull2;
    PirateWorld world ;
    EnemyFactory factory;
    Pirates pirate;
    Treasure treasure;
    public static int x;
    public static int y;
    public static int id1;
    public static int id2;
    public GoldenGateBridge(){
        factory = new EnemyFactory();
        shark=getEnemy("shark");
        skull1 = getEnemy("skull");

        skull2 = getEnemy("skull");
        shark.getImage().scale(100,100);
        skull1.getImage().scale(100,100);

        skull2.getImage().scale(100,100);
        x=30;
        y=-30;
        id1=0;
        id2=0;
        backgroundImgPath = "images/GoldenGateBridge/world_7.jpg";
        treasure = new Treasure();
        treasure.getImage().scale(100,100);
    }

    public void act() 
    {
        checkLifeCount();
        Greenfoot.delay(5);
        if(shark.isAtEdge()){
            id1++;
            System.out.println(id1);
        }
        if(skull1.isAtEdge()){
            id2++;
        }
        if(id2%2==0){
            shark.move(x);
        }
        else{
            shark.move(y);
        }
        if(id2%2==0){
            skull1.move(y);
            skull2.move(y);
        }
        else{
            skull1.move(x);
            skull2.move(x);
        }
       if(skull1.checkIntersectingObjects(pirate)||skull2.checkIntersectingObjects(pirate)||shark.checkIntersectingObjects(pirate))
        {
            pirate.removeLife();        
        }
        if(treasure.checkIntersectingObjects(pirate))
        {
            System.out.println("Wow...pirate has won the game");
            //Greenfoot.stop();
        } /*
        s.setLocation(250, 250);
        s.setLocation(350, 150);
        s.setLocation(450, 250);
        s.setLocation(350, 350);*/
    }    

    public void draw(){
        initialize(); 

        pirate.setLocation(100,(world.getHeight()-100));
        pirate.getImage().scale(100,100);
        setBackground(backgroundImgPath);
        world.addObject(treasure,100,230);
        world.addObject(skull1, (world.getWidth()/2),((world.getHeight()-200)/2));
        world.addObject(skull2, (world.getWidth()/2),((world.getHeight()-600)/2));
        world.addObject(shark,(world.getWidth()/2),((world.getHeight()+200)/2));
    }

    public  void doIncorrectAnswer(){}

    public  void doCorrectAnswer(){}

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){}

    public  IEnemy getEnemy(String type){

        return factory.getEnemy(type);
    }

    //private methods
    private void cleanPlace(){

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
