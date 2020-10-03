package org.xylandia.game.ld47;

import org.xylandia.game.ld47.utils.FileUtils;

import java.awt.*;

public class ImageCanvas extends Canvas {
    public void paint(Graphics graphics){
        Image lImage = Toolkit.getDefaultToolkit().getImage(FileUtils.getUri("hiver_test.jpg"));
        graphics.drawImage(lImage,0, 0, 800 ,400, this);
    }
}
