    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
    
    /**
     * Write a description of class Score here.
     * 
     * @author Prapatsorn Ouisakul
     * @version 2
     */
    public class Score extends Actor
    {
        private List<Number> number;
        private int score;
        private MyWorld world;
        
        private int delay;
        private int size;
        public Score(){
            number = new ArrayList<Number>();
            //number.add(new Number(0));
        }
        
        protected void addedToWorld(World world){
          this.world = (MyWorld) world;
          addNumber( 0 );
        }
        
        public void addNumber(int x){
          number.add( new Number(x) );
          if( size == 0 ) world.addObject( number.get(number.size()-1) , 950, 300);
          else 
            world.addObject(number.get(number.size()-1) , number.get(number.size()-2).getX() - 40, 300);
          size = number.size();
        }
        
        public void setScore( int score ){
          int count = 0;
          while( score > 0 ){
            int last = score%10;
            number.get(count++).setNumber( last );
            score /= 10;
          }
        }
        
        public void act(){
          if( world.isPlaying() && delay++ >= 20 ){
              score+=1;
              while( score >= Math.pow( 10, size )){
                addNumber(1);  
              }
              setScore( score );
              delay = 0;
          }
          number.get(0).setNumber( score%10);
        }
    }
    
    
