package com.aktog.yusuf;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Panel panel;

    public Main() {
        panel = new Panel();
        this.add(panel);
        loadPreferences();

    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }


    final void loadPreferences() {

        this.setTitle("Rain Animation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
