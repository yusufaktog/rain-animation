package com.aktog.yusuf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Panel extends JPanel {

    ArrayList<RainDrop> rainDrops;

    public Panel() {
        super();
        rainDrops = new ArrayList<>();
        loadPreferences();

        for (int i = 0; i < 750; i++) {
            generateRandomParticle();
            repaint();
        }

        new Thread(() -> {
            for (RainDrop rainDrop : rainDrops) {
                AnimationHandler.applyGravity(rainDrop, this);
            }
        }).start();

    }

    final void loadPreferences() {

        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);
    }

    void generateRandomParticle() {


        final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        final int width = Toolkit.getDefaultToolkit().getScreenSize().width;

        int x = generateRandomNumber(width);
        int y = generateRandomNumber(height);

        int particleHeight = generateRandomNumber(50);

        rainDrops.add(new RainDrop(x, y, particleHeight));


    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        g2.setColor(Color.white);

        for (RainDrop rainDrop : rainDrops) {
            // randomize colors, have some fun xD
/*            g2.setColor(new Color(
                    generateRandomNumber(255),
                    generateRandomNumber(255),
                    generateRandomNumber(255)));*/

            g2.setStroke(new BasicStroke(2));
            g2.drawLine(rainDrop.getX(), rainDrop.getY(), rainDrop.getX(), (rainDrop.getY() + rainDrop.getHeight()));
        }


    }
    private int generateRandomNumber(int bound){
        return ThreadLocalRandom.current().nextInt(bound);
    }
}