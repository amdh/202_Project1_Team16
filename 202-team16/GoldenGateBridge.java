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
    IEnemy skull3;
    PirateWorld world ;
    EnemyFactory factory;
    IObserver pirate;
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
        skull3 = getEnemy("skull");

        x=30;
        y=-30;
        id1=0;
        id2=0;
        backgroundImgPath = "images/GoldenGateBridge/world_7.jpg";
        treasure = new Treasure();
        treasure.getImage().scale(200,150);
    }

    public void act() 
    {
        checkLifeCount();
        Greenfoot.delay(5);
        if(skull3.isAtEdge()){
            id1++;
            System.out.println(id1);
        }
        if(skull1.isAtEdge()){
            id2++;
        }

        if(id2%2==0){
            //shark.move(x);
            skull3.move(x);
            skull1.move(x);
        }
        else{
            // shark.move(y);
            skull3.move(y);
            skull1.move(y);
        }

        if(id2%2==0){

            skull2.move(y);

        }
        else{

            skull2.move(x);

        }

    }    

    public void draw(){
        initialize(); 

        pirate.setLocation(100,(world.getHeight()-100));
        pirate.getImage().scale(100,100);
        setBackground(backgroundImgPath);
        world.addObject(treasure,100,230);
        world.addObject(skull1, (world.getWidth()/2),((world.getHeight()-200)/2));
        world.addObject(skull2, (world.getWidth()/2),((world.getHeight()-600)/2));
        world.addObject(skull3,(world.getWidth()/2),((world.getHeight()+200)/2));
    }

    public  void doIncorrectAnswer(){}

    public  void doCorrectAnswer(){}

    public  void showHurdle(){}

    public  void setNextPlace(String placeName){}

    public  IEnemy getEnemy(String type){
        IEnemy enemy =  factory.getEnemy(type);
        enemy.getImage().scale(100,100);
        return enemy;
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
