import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HurdleSkeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HurdleSkeleton extends IPlace
{

    PirateWorld world;
    Pirates pirate;
    int hurdlecnt, i= 1000 , maxhurdle = 7;
    EnemyFactory factory;
    GreenfootSound backgoundSound;

    public HurdleSkeleton(){
        backgoundSound = new GreenfootSound("sounds/theme.mp3");
        factory = new EnemyFactory();
    }

    public void act() 
    {
        // Add your action code here.
        checkLifeCount();
        if(hurdlecnt < maxhurdle){
            if (Greenfoot.getRandomNumber(300)<3){
                world.addObject(getEnemy("skeleton"), 1500,800);
                hurdlecnt++;
                System.out.println(hurdlecnt);
            }
        }
        if(checkHurdleCrossed()){
            cleanPlace();
            setNextPlace(PirateWorld.firstPlace);
        }


    }  

    public boolean checkHurdleCrossed(){
        if( maxhurdle == pirate.getSharkKilledCount())
            return true;
        else
            return false;
    }

    public IEnemy getEnemy(String type){

        IEnemy s1 = factory.getEnemy(type);
        s1.getImage().scale(250,300);
        return s1;
    }

    public void draw(){

        world =  getWorldOfType(PirateWorld.class);        
        pirate =  world.getPirate();
        world.setBackground("images/hurdleSkeleton.jpg");
        backgoundSound.play();
        world.showHint3("Kill all to reach next place..");

    }
    public  void doIncorrectAnswer(){}
    public  void doCorrectAnswer(){}
    public  void showHurdle(){
    }
    public void setNextPlace(String placeName){
        world.setPlace(placeName);
    }

    private void checkLifeCount(){
        pirate.checkLifeCount(backgoundSound);
    }

    private void cleanPlace(){
        backgoundSound.stop();
        world.removeObjects(world.getObjects(HintHolder.class));
    }
}