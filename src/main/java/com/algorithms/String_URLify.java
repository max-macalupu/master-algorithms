package com.algorithms;

public class String_URLify {
    public static void main(String[] args) {

        String input = "The Max Isv           ";
        int length = 13;
        String output = urlifyString(input, length);
        System.out.println(String.format("The result is: %s", output));
    }

    private static String urlifyString(String input, int length) {
        char[] charArray = input.toCharArray();
        int blankSpaces = 0;
        for (int i=0; i < length; i++) {
            if (charArray[i] == ' ')
               blankSpaces ++ ;
        }
        int trueSize = length + blankSpaces * 2 ;
        if (input.length() > length) charArray[length] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                charArray[--trueSize] = '%';
                charArray[--trueSize] = '2';
                charArray[--trueSize] = '0';
            } else {
                charArray[--trueSize] = charArray[i];
            }
        }
        return new String(charArray);
    }
}
