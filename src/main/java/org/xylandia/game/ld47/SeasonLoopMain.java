package org.xylandia.game.ld47;

import org.xylandia.game.ld47.utils.FileUtils;


public class SeasonLoopMain {
    public static void main(String[] args){

        // Read the introduction file
        FileUtils.readFile("Intro");
        FileUtils.readFile("Autumn");

    }
}
