/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame.gameobject;

import java2dgame.gameobject.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java2dgame.Game;

/**
 *
 * @author Paul
 */
public class BasicEnemy extends GameObject {

    public BasicEnemy (int x, int y, ID id) {
        super(x, y, id);
        velocityX=5;
        velocityY=5;
    }

    @Override
    public void tick () {
        x+=velocityX;
        y+=velocityY;
        
        if(y <= 0 || y >= Game.HEIGHT - 32){
            velocityY *=-1;
        }
        
        if(x <= 0 || x >= Game.WIDTH - 32){
            velocityX *=-1;
        }
    }

    @Override
    public void render (Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
    
}
