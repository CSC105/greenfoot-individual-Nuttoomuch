import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author Prapatsorn Ouisakul
 * @version 1
 */
public class Start extends World
{
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,600, 1);
        GreenfootImage st = new GreenfootImage("Home.jpg");
        st.scale(1000,600);
        addObject(new Play(),500,300);
        addObject(new Fla(),134,458);
        
        
    }
}
