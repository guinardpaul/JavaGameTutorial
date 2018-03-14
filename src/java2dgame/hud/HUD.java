/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame.hud;

import java.awt.Color;
import java.awt.Graphics;
import java2dgame.Game;

/**
 *
 * @author Paul
 */
public class HUD {

    public static final int HEALTH = 100;
    public static int currentHealth = HEALTH;

    public void tick() {
        currentHealth = Game.clamp(currentHealth, 0, HEALTH);
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, currentHealth * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
    }

}
