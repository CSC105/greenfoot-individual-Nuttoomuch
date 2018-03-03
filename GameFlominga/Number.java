    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Number here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Number extends Actor
    {
        private int num;
        private MyWorld world;
        public Number(int i){
          //setImage( MyWorld.getNumber(i));
          num = i;
        }
        
        protected void addedToWorld(World n){
            this.world = (MyWorld) n;
            setImage( world.getNumber( num ));
        }
        
        
        public void setNumber(int i){
          setImage( world.getNumber(i) );
        }
    }
