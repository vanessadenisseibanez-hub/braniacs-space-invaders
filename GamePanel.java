    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ibanez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    final int WIDTH = 800;
    final int HEIGHT = 600;

    Timer timer;

    Player player = new Player();
    Bullet bullet = new Bullet();
    NPC npc = new NPC();

    Enemy enemy = new Enemy(300, 100);

    Random random = new Random();

    ArrayList<Question> questions = new ArrayList<>();

    Question currentQuestion;

    int enemyHealth = 5;
    int playerHealth = 3;

    boolean canShoot = false;

    public GamePanel() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.BLACK);

        setFocusable(true);

        addKeyListener(this);

        loadQuestions();

        timer = new Timer(16, this);

        timer.start();
    }

    // =========================
    // LOAD QUESTIONS
    // =========================

    void loadQuestions() {

        questions.add(new Question("Capital of Japan?", "tokyo"));
        questions.add(new Question("2 + 2?", "4"));
        questions.add(new Question("Largest ocean?", "pacific"));
        questions.add(new Question("Red Planet?", "mars"));
        questions.add(new Question("Square root of 144?", "12"));
        questions.add(new Question("Who painted Mona Lisa?", "da vinci"));
        questions.add(new Question("Fastest land animal?", "cheetah"));
        questions.add(new Question("What gas do humans breathe?", "oxygen"));
        questions.add(new Question("How many continents?", "7"));
        questions.add(new Question("Hardest natural substance?", "diamond"));
    }

    // =========================
    // QUESTION SYSTEM
    // =========================

    void nextQuestion() {

    // NO MORE QUESTIONS

    if (questions.isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "🎉 You answered all questions!"
        );

        System.exit(0);

        return;
    }

    // RANDOM QUESTION

    int randomIndex =
            random.nextInt(questions.size());

    currentQuestion =
            questions.get(randomIndex);

    // REMOVE QUESTION SO IT NEVER REPEATS

    questions.remove(randomIndex);

    // ASK QUESTION

    String answer = JOptionPane.showInputDialog(
            null,
            "🤖 Professor Byte asks:\n\n"
                    + currentQuestion.question
    );

    if (answer == null) {
        return;
    }

    // CORRECT ANSWER

    if (answer.toLowerCase().trim()
            .equals(currentQuestion.answer)) {

        JOptionPane.showMessageDialog(
                null,
                "✅ Correct!\nPress SPACE to shoot."
        );

        canShoot = true;

    } else {

        playerHealth--;

        JOptionPane.showMessageDialog(
                null,
                "❌ Wrong!\nCorrect Answer: "
                        + currentQuestion.answer
                        + "\n\nPlayer HP -1"
        );

        if (playerHealth <= 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "💀 GAME OVER"
            );

            System.exit(0);
        }
    }
}
    

    // =========================
    // GAME LOOP
    // =========================

    @Override
    public void actionPerformed(ActionEvent e) {

        enemy.move();

        bullet.move();

        // COLLISION

        if (bullet.active &&
                bullet.x < enemy.x + enemy.width &&
                bullet.x + bullet.width > enemy.x &&
                bullet.y < enemy.y + enemy.height &&
                bullet.y + bullet.height > enemy.y) {

            bullet.active = false;

            enemyHealth--;

            if (enemyHealth <= 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "🎉 ENEMY DEFEATED!"
                );

                System.exit(0);
            }
        }

        repaint();
    }

    // =========================
    // DRAWING
    // =========================

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        enemy.draw(g);

        bullet.draw(g);

        npc.draw(g);

        g.setColor(Color.WHITE);

        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("Enemy HP: " + enemyHealth, 620, 30);

        g.drawString("Player HP: " + playerHealth, 620, 60);

        g.drawString("Q = Question", 20, 30);

        g.drawString("SPACE = Shoot", 20, 60);

        g.drawString("← → = Move", 20, 90);
    }

    // =========================
    // CONTROLS
    // =========================

    @Override
    public void keyPressed(KeyEvent e) {

        // MOVE LEFT

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            player.x -= player.speed;

            if (player.x < 0) {
                player.x = 0;
            }
        }

        // MOVE RIGHT

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            player.x += player.speed;

            if (player.x > WIDTH - player.width) {
                player.x = WIDTH - player.width;
            }
        }

        // ASK QUESTION

        if (e.getKeyCode() == KeyEvent.VK_Q) {

            nextQuestion();
        }

        // SHOOT

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            if (canShoot && !bullet.active) {

                bullet.shoot(
                        player.x + 25,
                        player.y
                );

                canShoot = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
