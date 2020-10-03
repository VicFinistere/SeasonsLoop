package org.xylandia.game.ld47.hmi;

import org.xylandia.game.ld47.hmi.ImageCanvas;
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

        // Windows position
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        // Text
        JLabel lSeasonText = new JLabel(FileUtils.readFile("Intro"));
        lSeasonText.setBackground(Color.BLACK);
        lSeasonText.setForeground(Color.WHITE);
        lSeasonText.setHorizontalAlignment(JLabel.CENTER);
        lSeasonText.setPreferredSize(new Dimension(800, 300));

        // Input
        JTextField lInputZone = new JTextField(">");
        lInputZone.setPreferredSize(new Dimension(800, 100));

        // Container
        Container lContentPane = this.getContentPane();

        // Layout
        GridBagLayout lGridBagLayout = new GridBagLayout();
        lContentPane.setLayout(lGridBagLayout);

        // Layout constraints
        GridBagConstraints lConstraints = new GridBagConstraints();
        lConstraints.ipadx = 0;
        lConstraints.fill = GridBagConstraints.HORIZONTAL;

        // ++ Screen items
        ImageCanvas lImageCanvas = new ImageCanvas("hiver_test.jpg");
        lConstraints.gridx = 0;
        lContentPane.add(lImageCanvas, lConstraints);

        lConstraints.gridx = 0;
        lConstraints.weighty = 300;
        lContentPane.add(lSeasonText, lConstraints);

        lConstraints.weighty = 0;
        lContentPane.add(lInputZone, lConstraints);

        // Visible
        setVisible(true);
    }
}
