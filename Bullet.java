/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ibanez;

/**
 *
 * @author Denisse
 */
import java.awt.*;

public class Bullet {

    int x;
    int y;

    int width = 5;
    int height = 15;

    boolean active = false;

    public void shoot(int startX, int startY) {

        x = startX;
        y = startY;

        active = true;
    }

    public void move() {

        if (active) {
            y -= 10;

            if (y < 0) {
                active = false;
            }
        }
    }

    public void draw(Graphics g) {

        if (active) {

            g.setColor(Color.YELLOW);

            g.fillRect(x, y, width, height);
        }
    }
}
