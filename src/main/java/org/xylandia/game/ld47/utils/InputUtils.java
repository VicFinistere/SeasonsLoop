package org.xylandia.game.ld47.utils;

import java.util.Scanner;

public class InputUtils {

    public static String askForInput(String query){
        System.out.println(query);
        return getInput();
    }

    public static String getInput(){
        return new Scanner(System.in).nextLine();
    }
}
