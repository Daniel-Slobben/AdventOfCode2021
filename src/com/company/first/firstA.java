package com.company.first;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class firstA {
    public static void main(String[] args) {
        // write your code here

        int dataInt1 = 0;
        int dataInt2 = 0;
        int counter = 0;

        try {
            File myObj = new File("firstInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Read the next line
                String data = myReader.nextLine();

                // Push it into an Integer
                dataInt1 = Integer.parseInt(data);

                // Check if its not the first measurement
                if (dataInt2 != 0) {
                    // If the second measurement is greater than the first measuremnt
                    if (dataInt1 > dataInt2) {
                        counter++;
                    }
                }
                dataInt2 = dataInt1;
            }
            System.out.println("Amount of increases: " + counter);
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
