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

public class Player {

    int x = 350;
    int y = 500;

    int width = 60;
    int height = 30;

    int speed = 8;

    public void draw(Graphics g) {

        g.setColor(Color.GREEN);

        g.fillRect(x, y, width, height);
    }
}
