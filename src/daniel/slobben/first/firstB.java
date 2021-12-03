package daniel.slobben.first;

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
                // Lees de volgende regel
                String data = myReader.nextLine();

                // Duw het het in een Integer
                dataInt1 = Integer.parseInt(data);
                slidingWindow1 = dataInt1 + dataInt2 + dataInt3;

                // Je niet de eerste meting toch?
                if (trueCounter > 2) {
                    // Alleen voor mensen waarvan measurement 2 groter is dan measurement 1
                    if (slidingWindow1 > slidingWindow2) {
                        counter++;
                    }
                }
                trueCounter++;
                dataInt3 = dataInt2;
                dataInt2 = dataInt1;
                slidingWindow2 = slidingWindow1;
            }
            // Schreew het maar uit
            System.out.println("Amount of increases: " + counter);
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
