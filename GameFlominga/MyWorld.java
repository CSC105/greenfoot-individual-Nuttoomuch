    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class MyWorld here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class MyWorld extends World
    {
        private Flamingo flamingo;
        boolean chkDead = false ;
        private GreenfootImage[] numbers;
        private boolean playing;
        
        
        /**
         * Constructor for objects of class MyWorld.
         * 
         */
        public MyWorld()
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            super(1000, 600, 1, false); 
            
            flamingo = new Flamingo();
            addObject( flamingo, 107, 479 );
            
            Cactus cactus1 = new Cactus();
            addObject( cactus1, -200, 100 );
            
            Cactus cactus2 = new Cactus();
            addObject( cactus2, 266, 100 );
            
            Cactus cactus3 = new Cactus();
            addObject( cactus3, 732, 100 );
            
            for(int i = 0; i < 4; ++i){
              Mountain mountain = new Mountain(true);
              addObject( mountain, 240 + i*480, 500 );
            }
            
            for(int i = 0; i < 4; ++i){
              Mountain mountain = new Mountain(false);
              addObject( mountain, 100 + i*480, 100 );
            }
            
            addObject( new Sky(), 500, 300 );
            
            numbers = new GreenfootImage[10];
            for(int i = 0; i < 10; ++i){
              numbers[i] = new GreenfootImage( "Number/" + i + ".png" );
              numbers[i].scale(40,65);
            }
            
            setPaintOrder( PlayAgain.class, Number.class, Flamingo.class, 
                            Cactus.class, Mountain.class, Sky.class );
            
            addObject( new Score(), -100, -100);
            
            Greenfoot.setSpeed( 58 );
            playing = true;
        }
        /**
         * Get The actor player as Flamingo
         * @return return the flamingo object to you
         */
        
        public void setDead(boolean x) {
            chkDead = x;
        }
        
        public boolean getDead() {
            return chkDead;
        }
        
        public Flamingo getPlayer(){
          return flamingo;
        }
        
        public GreenfootImage getNumber(int num){
          return numbers[num];
        }
        
        public void setPlaying(boolean b){
          this.playing = b;
        }
        
        public boolean isPlaying(){
           return playing;
        }
    }
