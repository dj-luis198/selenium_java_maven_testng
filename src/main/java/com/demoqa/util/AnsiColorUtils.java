package com.demoqa.util;

public class AnsiColorUtils {
public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static String applyColor(String message, String color) {
        return color + message + ANSI_RESET;
    }

    public static String applyBlack(String message) {
        return applyColor(message, ANSI_BLACK);
    }

    public static String applyRed(String message) {
        return applyColor(message, ANSI_RED);
    }

    public static String applyGreen(String message) {
        return applyColor(message, ANSI_GREEN);
    }

    public static String applyYellow(String message) {
        return applyColor(message, ANSI_YELLOW);
    }

    public static String applyBlue(String message) {
        return applyColor(message, ANSI_BLUE);
    }

    public static String applyPurple(String message) {
        return applyColor(message, ANSI_PURPLE);
    }

    public static String applyCyan(String message) {
        return applyColor(message, ANSI_CYAN);
    }

    public static String applyWhite(String message) {
        return applyColor(message, ANSI_WHITE);
    }
}