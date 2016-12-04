import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HurdleShark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HurdleShark extends IPlace
{
    PirateWorld world;
    Pirates pirate;
    int hurdlecnt, i= 11000 , maxhurdle = 11;
    EnemyFactory factory;
    GreenfootSound backgoundSound;
    public HurdleShark(){
        backgoundSound = new GreenfootSound("sounds/evil.mp3");
    }

    public void act() 
    {
        // Add your action code here.
        checkLifeCount();
        backgoundSound.play();
        if(hurdlecnt < maxhurdle){
           if (i%100==0){
                world.addObject(getEnemy("shark"), 1500,800);
                hurdlecnt++;
                System.out.println(hurdlecnt);
            }
        }
        backgoundSound.play();
        if(checkHurdleCrossed()){
            cleanPlace();
            setNextPlace(PirateWorld.fifthPlace);
        }
        i--;
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
        world.setBackground("images/hurdleShark.jpg");
        backgoundSound.play();
        world.showHint3("Kill all sharks to reach next place..");
        factory = new EnemyFactory();    
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
         world.removeObjects(world.getObjects(Shark.class));
         PirateWorld.isHurdle= false;
    }
}
