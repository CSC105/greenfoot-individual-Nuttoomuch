    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Cactus here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Cactus extends Actor
    {
        private boolean isDown;
        private GreenfootImage image;
        
        private final int GROUND_UP = 70;
        private final int GROUND_DOWN = 530;
        private final int SPEED = 5;
        
        private MyWorld world;
        
        public Cactus(){
          image = new GreenfootImage("cactus.png");
          image.scale( 80, 145 );
          setImage( image );
          isDown = true;
        }
        
        protected void addedToWorld(World world){
          this.world = (MyWorld) world;
          reset();
        }
        
        public void act(){
          if( world.isPlaying() ){
              setLocation( getX() - SPEED, getY() );
              if( getX() < -100 ) reset();
              if( isDead() ){
                 gameOver();
              }
          }
        }
        
        public void gameOver(){
          world.addObject( new PlayAgain(), 500, 300);
          
          world.setPlaying(false);
          //Greenfoot.stop();
        }
        
        public boolean isDead(){
          //return intersects(world.getPlayer());
          boolean chkX = Math.abs(world.getPlayer().getX() - getX() ) < 75;
          boolean chkY = Math.abs(world.getPlayer().getY() - getY() ) < 110;
          if(chkX && chkY) {
              ((MyWorld)getWorld()).setDead(true);
          }
          return chkX && chkY;
        }
        
        public void reset(){
          boolean newDown = (Greenfoot.getRandomNumber(10) < 5 )? true: false; // 0 1  
          if( newDown != isDown ){
            image.mirrorVertically();  
          }
          isDown = newDown;
          
          if( isDown )
            setLocation( getX() + 1400, GROUND_DOWN );
          else
            setLocation( getX() + 1400, GROUND_UP );
        }
    }
