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

public class Enemy {

    int x;
    int y;

    int width = 50;
    int height = 30;

    int direction = 1;

    public Enemy(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public void move() {

        x += 3 * direction;

        if (x <= 0 || x >= 740) {
            direction *= -1;
            y += 20;
        }
    }

    public void draw(Graphics g) {

        g.setColor(Color.RED);

        g.fillRect(x, y, width, height);
    }
}
