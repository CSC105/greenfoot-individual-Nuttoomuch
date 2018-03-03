    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class PlayAgain here.
     * 
     * @author Prapatsorn Ouisakul 
     * @version 2
     */
    public class PlayAgain extends Actor
    {
        public PlayAgain(){
          GreenfootImage image = new GreenfootImage("PlayAgain.png");
          setImage(image);
        }   
        
        public void act(){
          if( Greenfoot.mouseClicked(this) ){
            Greenfoot.setWorld(new MyWorld()); 
          }
        }
    }
