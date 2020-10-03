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
        JLabel lSeasonText = new JLabel(FileUtils.readFile("Intro"));
        lSeasonText.setBackground(Color.BLACK);
        lSeasonText.setForeground(Color.WHITE);
        lSeasonText.setHorizontalAlignment(JLabel.CENTER);



        // Container
        Container lContentPane = this.getContentPane();
        lContentPane.setLayout(new GridLayout(3, 1));

        // ++ Screen items
        lContentPane.add(new ImageCanvas("hiver_test.jpg"));
        lContentPane.add(lSeasonText);

        // Options :
        // - Visible
        setVisible(true);
    }
}
