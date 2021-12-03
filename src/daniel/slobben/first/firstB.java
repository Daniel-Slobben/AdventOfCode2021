package com.company.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class firstB {
    public static void main(String[] args) {
        // write your code here

        int dataInt1 = 0;
        int dataInt2 = 0;
        int dataInt3 = 0;

        int slidingWindow1 = 0;
        int slidingWindow2 = 0;

        int counter = 0;
        int trueCounter = 0;

        try {
            File myObj = new File("firstInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Read the next line
                String data = myReader.nextLine();

                // Push it into an Integer
                dataInt1 = Integer.parseInt(data);
                slidingWindow1 = dataInt1 + dataInt2 + dataInt3;

                // Check if its not the first measurement
                if (trueCounter > 2) {
                    // If the second measurement is greater than the first measuremnt
                    if (slidingWindow1 > slidingWindow2) {
                        counter++;
                    }
                }
                trueCounter++;
                dataInt3 = dataInt2;
                dataInt2 = dataInt1;
                slidingWindow2 = slidingWindow1;
            }
            System.out.println("Amount of increases: " + counter);
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
