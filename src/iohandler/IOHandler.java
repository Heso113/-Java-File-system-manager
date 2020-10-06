package iohandler;

import java.util.Scanner;

public class IOHandler {

    private static Scanner myScanner = new Scanner(System.in);

    static public int getIntFromUser() {
        int input = -1;
        try {
            input = myScanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

    static public String getStringFromUser() {
        String input = "";
        try {
            input = myScanner.next();
            input += myScanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

    static public String getOneWordFromUser() {
        String input = getStringFromUser();
        String word = "";
        if (input.length() > 0) {
            for (int i = 0; i < input.length(); i++) {
                if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') ||
                    input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    word += input.charAt(i);
                }
                else {
                    break;
                }
            }
        }
        return word;
    }

    static public void printToConsole(String message) {
        System.out.print(message);
    }
}
