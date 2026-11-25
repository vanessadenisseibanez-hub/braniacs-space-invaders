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

public class NPC {

    public void draw(Graphics g) {

        g.setColor(Color.CYAN);

        g.fillOval(20, 520, 60, 60);

        g.setColor(Color.WHITE);

        g.drawString("Professor Byte", 10, 510);
    }
}
