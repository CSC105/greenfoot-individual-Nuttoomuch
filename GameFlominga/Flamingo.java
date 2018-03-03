    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Flamingo here.
     * 
     * @author Prapatsorn Ouisakul 
     * @version 2
     */
    public class Flamingo extends Actor
    {
        private GreenfootImage[] up;
        private GreenfootImage[] down;
        GreenfootSound startsong;
        private boolean isDown;
        private int currentUp;
        private int currentDown;
        private long lastTime;
        
        private final int GROUND_UP = 120;
        private final int GROUND_DOWN = 480;
        
        private double x;
        private double y;
        
        private double a = 0; // a - accelerate
        
        private MyWorld world;
        
        public Flamingo(){
          up = new GreenfootImage[36];
          for(int i = 0; i < 36; ++i){
            up[i] = new GreenfootImage("Flamingo" + (i+1) + ".png");
            up[i].scale( 130, 243 );
            up[i].mirrorVertically();
          }
          
          down = new GreenfootImage[36];
          for(int i = 0; i < 36; ++i){
            down[i] = new GreenfootImage("Flamingo" + (i+1) + ".png");
            down[i].scale( 130, 243);
          }
          
          setImage(down[0]);
          isDown = true;
          
          startsong = new GreenfootSound("Momo.mp3");
          startsong.playLoop();
        }
        
        protected void addedToWorld(World world){
          this.world = (MyWorld) world;
          x = getX();
          y = getY();
        }
        
        public void act(){
          if( world.isPlaying() ){
              if( Greenfoot.isKeyDown("space") ){
                 if(System.nanoTime() - lastTime > 100000000){
                     isDown = !isDown;
                     a = 0;
                 }
                 lastTime = System.nanoTime();
              }
              if( isDown ){
                currentUp = 0;
                if( onGround() )currentDown++;
                if( currentDown == 36 ) currentDown = 0;
                
                setImage( down[currentDown] );
              }
              if( !isDown ){
                if( onGround() )currentUp++;
                currentDown = 0;
                if( currentUp == 36 ) currentUp = 0;
                
                setImage( up[currentUp] );
              }
              gravity();
          }
          checkDead(((MyWorld)getWorld()).getDead());
        }
    
        public void gravity(){
          a += 1;
          if(isDown){
            if( y + a < GROUND_DOWN ){
              y += a;
              setLocation( getPx(), getPy() );
            }else{
              y = GROUND_DOWN;
              setLocation( getPx(), getPy() );
            }
          }
          else{
            if( y - a > GROUND_UP ){
              y -= a;
              setLocation( getPx(), getPy() );
            }else{
              y = GROUND_UP;
              setLocation( getPx(), getPy() );
            }
          }
        }
        public void checkDead(boolean dead) {
            if(dead) {
                startsong.stop();
                Greenfoot.playSound("WhaWha.mp3");
                getWorld().removeObject(this);
            }
        }
        public boolean onGround(){
          return getPy() == GROUND_UP || getPy() == GROUND_DOWN;
        }
        
        public int getPx(){
          return (int) x;
        }
        
        public int getPy(){
          return (int) y;
        }
    }
