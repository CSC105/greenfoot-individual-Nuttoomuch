import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    private boolean isActive = false;
    GreenfootSound startsong;
    public Play(){
        GreenfootImage p = new GreenfootImage("Play.png");
        p.scale(350,250);
        setImage(p);
        Greenfoot.start();
        startsong = new GreenfootSound("BBB.mp3");
        startsong.playLoop();
    }
    
    public void act() 
    {
        checkKeys();
        if(isActive){
            startsong.stop();
            Greenfoot.setWorld(new MyWorld());
        }
    }    
    
    public void checkKeys() {
        if (Greenfoot.isKeyDown("Space")) {
            isActive = true;
        }
    } 
}
