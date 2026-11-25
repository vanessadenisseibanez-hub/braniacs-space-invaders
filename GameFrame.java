/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ibanez;

/**
 *
 * @author Denisse
 */
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    CardLayout cardLayout;

    JPanel mainPanel;

    JPanel menuPanel;

    GamePanel gamePanel;

    public GameFrame() {

        setTitle("Braniac Space Invaders");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);

        createMenu();

        gamePanel = new GamePanel();

        mainPanel.add(menuPanel, "Menu");

        mainPanel.add(gamePanel, "Game");

        add(mainPanel);

        cardLayout.show(mainPanel, "Menu");

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    void createMenu() {

        menuPanel = new JPanel();

        menuPanel.setPreferredSize(new Dimension(800, 600));

        menuPanel.setBackground(Color.BLACK);

        menuPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 1, 15, 15));

        buttonPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel(
                "🧠 BRANIAC SPACE INVADERS 🚀",
                SwingConstants.CENTER
        );

        title.setForeground(Color.GREEN);

        title.setFont(new Font("Arial", Font.BOLD, 32));

        JButton playButton = new JButton("PLAY");

        JButton howToPlayButton = new JButton("HOW TO PLAY");

        JButton exitButton = new JButton("EXIT");

        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        playButton.setFont(buttonFont);

        howToPlayButton.setFont(buttonFont);

        exitButton.setFont(buttonFont);

        // =========================
        // PLAY BUTTON
        // =========================

        playButton.addActionListener(e -> {

            cardLayout.show(mainPanel, "Game");

            gamePanel.setFocusable(true);

            gamePanel.requestFocusInWindow();
        });

        // =========================
        // HOW TO PLAY
        // =========================

        howToPlayButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    """
                    HOW TO PLAY

                    🧠 Press Q to answer questions.

                    ✅ Correct answers unlock bullets.

                    🚀 Press SPACE to shoot.

                    👾 Destroy the enemy to win.

                    ❤️ Wrong answers reduce HP.

                    ====================

                    CONTROLS

                    ⬅ LEFT ARROW  = Move Left
                    ➡ RIGHT ARROW = Move Right
                    ❓ Q KEY       = Question
                    🚀 SPACEBAR    = Shoot

                    ====================

                    Good luck, pilot.
                    """
            );
        });

        // =========================
        // EXIT BUTTON
        // =========================

        exitButton.addActionListener(e -> {

            System.exit(0);
        });

        buttonPanel.add(title);

        buttonPanel.add(playButton);

        buttonPanel.add(howToPlayButton);

        buttonPanel.add(exitButton);

        menuPanel.add(buttonPanel, gbc);
    }
}
