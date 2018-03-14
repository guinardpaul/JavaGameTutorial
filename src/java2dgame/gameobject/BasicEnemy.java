/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java2dgame.Game;
import java2dgame.event.Handler;

/**
 *
 * @author Paul
 */
public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velocityX = 5;
        velocityY = 5;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;

        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velocityY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 32) {
            velocityX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.01f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

}
