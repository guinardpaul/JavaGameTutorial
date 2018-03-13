/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyInput Handler
 *
 * @author Paul
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
                // Key event for player 1
                if (key == KeyEvent.VK_UP) {
                    tempGameObject.setVelocityY(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempGameObject.setVelocityY(5);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempGameObject.setVelocityX(-5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempGameObject.setVelocityX(5);
                }
            }
            if (tempGameObject.getId() == ID.Player2) {
                // Key event for player 2
                if (key == KeyEvent.VK_UP) {
                    tempGameObject.setVelocityY(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempGameObject.setVelocityY(5);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempGameObject.setVelocityX(-5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempGameObject.setVelocityX(5);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempGameObject = handler.objects.get(i);
            if (tempGameObject.getId() == ID.Player) {
                // Key event for player 1
                if (key == KeyEvent.VK_UP) {
                    tempGameObject.setVelocityY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempGameObject.setVelocityY(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempGameObject.setVelocityX(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempGameObject.setVelocityX(0);
                }
            }
            if (tempGameObject.getId() == ID.Player2) {
                // Key event for player 2
                if (key == KeyEvent.VK_UP) {
                    tempGameObject.setVelocityY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempGameObject.setVelocityY(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempGameObject.setVelocityX(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempGameObject.setVelocityX(0);
                }
            }
        }
    }

}
