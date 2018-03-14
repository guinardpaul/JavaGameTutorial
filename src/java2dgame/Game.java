/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame;

import java2dgame.event.Handler;
import java2dgame.gameobject.ID;
import java2dgame.event.KeyInput;
import java2dgame.hud.HUD;
import java2dgame.gameobject.BasicEnemy;
import java2dgame.gameobject.Player;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Class to handle the Game
 *
 * @author Paul
 */
public class Game extends Canvas implements Runnable {

    /**
     * Largeur de la fenetre
     */
    public static final int WIDTH = 640;
    /**
     * Hauteur de la fenetre
     */
    public static final int HEIGHT = WIDTH / 12 * 9;

    /**
     * Thread
     */
    private Thread thread;
    /**
     * running boolean
     */
    private boolean running = false;

    /**
     * Instance du Handler des GameObject
     */
    private Handler handler;

    private HUD hud;
    /**
     * Constructeur de la classe Game
     */
    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's build a game", this);

        hud = new HUD();
        
        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
        handler.addObject(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.BasicEnemy));
    }

    /**
     * Start game
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Stop game
     */
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Game Loop
     */
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS :" + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    public static int clamp(int var, int min, int max){
        if(var >= max){
            return var = max;
        }else if(var <= min){
            return var = min;
        }else {
            return var;
        }
    }

    /**
     * tick method
     */
    private void tick() {
        handler.tick();
        hud.tick();
    }

    /**
     * render method
     */
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        
        hud.render(g);

        g.dispose();
        bs.show();

    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }

}
