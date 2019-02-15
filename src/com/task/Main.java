package com.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Max number in array: " + findMax());
        } catch (IOException e) {
            System.out.println("Something goes wrong...\n" +
                    "Check file name and location\n" +
                    "Must be numbers.txt in project directory");
            e.printStackTrace();
        }
    }

    private static int findMax() throws IOException {
        FileInputStream inputStreams = new FileInputStream("numbers.txt");
        int length = inputStreams.available();
        byte[] data = new byte[length];
        inputStreams.read(data);
        String byteToString = new String(data);
        String[] stringNum = byteToString.split(",");
        int[] nums = Arrays.asList(stringNum).stream().mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(nums).max().getAsInt();
    }
}