package daniel.slobben.second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class secondA {

    public static void main(String[] args) {
        // write your code here
        int depth = 0;
        int horizontal = 0;

        try {
            File myObj = new File("secondInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                // Lees de volgende regel
                String data = myReader.nextLine();
                String[] dataSplit = data.split(" ");
                int amount = Integer.parseInt(dataSplit[1]);

                // Naar boven met die hap
                if (dataSplit[0].equals("forward")) {
                    horizontal += amount;
                }

                // Verlaag je diepte
                if (dataSplit[0].equals("up")) {
                    depth -= amount;
                }

                // Omhoog je diepte
                if (dataSplit[0].equals("down")) {
                    depth += amount;
                }
            }
            System.out.println("Result: " + (depth * horizontal));
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
