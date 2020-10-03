package org.xylandia.game.ld47;

import org.xylandia.game.ld47.hmi.GameWindow;
import org.xylandia.game.ld47.utils.FileUtils;
import org.xylandia.game.ld47.utils.InputUtils;

import javax.swing.*;
import java.util.Objects;



public class SeasonLoopMain {
    public static void main(String[] args) {

        JFrame gameWindow = new GameWindow("Seasons Loop");

        // Read the introduction file
        FileUtils.readFile("Intro");
        if (Objects.equals(InputUtils.askForInput("Please enter exactly 'Autumn' "), "Autumn")) {
            FileUtils.readFile("Autumn");
        } else {
            System.out.println("This is not spelled correctly ...");
        }
    }
}

