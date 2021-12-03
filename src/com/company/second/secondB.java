package com.company.second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class secondB {

    public static void main(String[] args) {
        // write your code here
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        try {
            File myObj = new File("secondInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Read the next line
                String data = myReader.nextLine();
                String[] dataSplit = data.split(" ");
                //
                int amount = Integer.parseInt(dataSplit[1]);

                if (dataSplit[0].equals("forward")) {
                    horizontal += amount;
                    depth += (aim * amount);
                }
                if (dataSplit[0].equals("up")) {
                    aim -= amount;
                }
                if (dataSplit[0].equals("down")) {
                    aim += amount;
                }
            }
            System.out.println("Result: " + (depth * horizontal));
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
