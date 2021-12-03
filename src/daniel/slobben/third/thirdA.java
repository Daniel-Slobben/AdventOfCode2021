package com.company.third;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class thirdA {

    public static void main(String[] args) {
        // write your code here
        boolean [] mostCommonBit;
        int[] bitCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int counter = 0;

        try {
            File myObj = new File("thirdInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Read the next line
                String data = myReader.nextLine();
                String[] split = data.split("(?!^)");

                int counter2 = 0;
                for (String bit: split) {
                    if (Objects.equals(bit, "0")) {
                        bitCounter[counter2]--;
                    }
                    if (Objects.equals(bit, "1")) {
                        bitCounter[counter2]++;
                    }
                    counter2++;
                }

                counter++;
            }
            myReader.close();

            StringBuilder gamma = new StringBuilder();
            StringBuilder epsilon = new StringBuilder();


            for (int b: bitCounter) {
                if (b > 0) {
                    gamma.append("1");
                    epsilon.append("0");
                } else {
                    gamma.append("0");
                    epsilon.append("1");
                }
            }

            String gammaString = gamma.toString();
            String epsilonString = epsilon.toString();

            int gammaInt = Integer.parseInt(gammaString,2);
            int epsilonInt = Integer.parseInt(epsilonString, 2);

            System.out.println("result: " + (gammaInt * epsilonInt));




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
