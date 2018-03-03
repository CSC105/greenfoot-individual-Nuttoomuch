import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountain extends Actor
{   
    private MyWorld world;
    public Mountain(boolean isDown){
      GreenfootImage image = new GreenfootImage("background/2.png");
      if( !isDown ) image.mirrorVertically();
      
      image.scale( 480, 270 );
      setImage(image);
    }
     
    protected void addedToWorld(World m){
        this.world = (MyWorld) m;
    }
    
    public void act(){
      if( world.isPlaying() ) moveBg();
    }
    
    public void moveBg(){
      setLocation( getX() - 1, getY());
      if( getX() <= -240 ){
        setLocation( 240+3*480, getY() );  
      }
    }
    
}



