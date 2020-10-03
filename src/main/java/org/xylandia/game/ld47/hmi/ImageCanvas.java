package org.xylandia.game.ld47.hmi;

import org.xylandia.game.ld47.utils.FileUtils;

import java.awt.*;

public class ImageCanvas extends Canvas {
    private String image;

    public ImageCanvas(String pImage){
        super();
        setSize(new Dimension(800, 300));
        image = "/" + pImage;
    }

    public void paint(Graphics graphics){
        final Image lImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(image));
        graphics.drawImage(lImage,0, 0, 800 ,400, this);
    }
}
