/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java2dgame.Game;
import java2dgame.event.Handler;
import java2dgame.hud.HUD;

/**
 *
 * @author Paul
 */
public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);

            if (tempGameObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempGameObject.getBounds())) {
                    // Collision code
                    HUD.currentHealth -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.white);
        }

        g.fillRect(x, y, 32, 32);
    }

}
