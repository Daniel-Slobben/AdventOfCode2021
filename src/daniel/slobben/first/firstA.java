package daniel.slobben.first;

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
                // Lees de volgende regel
                String data = myReader.nextLine();

                // Duw het het in een Integer
                dataInt1 = Integer.parseInt(data);

                // Je niet de eerste meting toch?
                if (dataInt2 != 0) {
                    // Alleen voor mensen waarvan measurement 2 groter is dan measurement 1
                    if (dataInt1 > dataInt2) {
                        counter++;
                    }
                }
                dataInt2 = dataInt1;
            }
            // Schreew het maar uit
            System.out.println("Amount of increases: " + counter);
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
