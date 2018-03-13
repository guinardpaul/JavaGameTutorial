/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Paul
 */
public class Game extends Canvas implements Runnable{
    
    private static final int WIDTH = 640;
    private static final int HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    
    public Game(){
        new Window(WIDTH, HEIGHT, "Let's build a game", this);
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }
    
    public synchronized void stop(){
         try {
            thread.join();
            running=false;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
       long lastTime = System.nanoTime();
       double amountOfTicks = 60.0;
       double ns = 1000000000 / amountOfTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;
       
       while(running){
           long now = System.nanoTime();
           delta += (now - lastTime) / ns;
           lastTime = now;
           while(delta >= 1){
               tick();
               delta--;
           }
           if(running)
               render();
           frames++;
           
           if(System.currentTimeMillis() - timer > 1000) {
               timer += 1000;
               System.out.println("FPS :" + frames);
               frames=0;
           }
       }
       stop();
    }
    
    private void tick(){
        
    }
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
           this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.dispose();
        bs.show();
               
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }
    
}
