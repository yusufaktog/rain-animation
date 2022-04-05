package com.aktog.yusuf;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class AnimationHandler {
    final static Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

    public static void applyGravity(RainDrop rainDrop, JPanel panel) {
        new Thread(() -> {
            while (true) {

                if (rainDrop.getY() + rainDrop.getHeight() >= SCREEN.height) {
                    reGenerateParticle(rainDrop);
                   panel.repaint();
                }

                rainDrop.setY(rainDrop.getY() + 10);
                panel.repaint();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void applyTouchdownEffect(JPanel panel, Graphics2D g2) {
        /*

         */
    }

    private static void reGenerateParticle(RainDrop rainDrop){
        rainDrop.setX(ThreadLocalRandom.current().nextInt(SCREEN.width));
        rainDrop.setY(ThreadLocalRandom.current().nextInt(SCREEN.height));
        rainDrop.setHeight(ThreadLocalRandom.current().nextInt(50));
    }
}