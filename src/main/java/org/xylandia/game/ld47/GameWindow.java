package org.xylandia.game.ld47;

import org.xylandia.game.ld47.utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {

    public GameWindow(String title) {
        super(title);

        // Listener
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        // Windows
        addWindowListener(l);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setSize(800, 600);
        setPreferredSize(new Dimension(800, 600));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        // Text
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBackground(Color.BLACK);
        jTextArea.setForeground(Color.WHITE);
        jTextArea.append("Hello World.");

        // Container
        Container lContentPane = this.getContentPane();
        lContentPane.setLayout(new GridLayout(2, 1));

        // ++ Screen items
        lContentPane.add(new ImageCanvas());
        lContentPane.add(jTextArea);

        // Options :
        // - Visible
        setVisible(true);
    }
}
