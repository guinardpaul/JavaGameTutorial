/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame.gameobject;

import java2dgame.gameobject.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java2dgame.Game;

/**
 *
 * @author Paul
 */
public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
        
        x = Game.clamp(x,0,Game.WIDTH - 37);
        y = Game.clamp(y,0,Game.HEIGHT - 60);
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.white);
        }

        g.fillRect(x, y, 32, 32);
    }
}
