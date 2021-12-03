package daniel.slobben.second;

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
                // Lees de volgende regel
                String data = myReader.nextLine();
                String[] dataSplit = data.split(" ");

                int amount = Integer.parseInt(dataSplit[1]);

                // ga naar voren
                if (dataSplit[0].equals("forward")) {
                    horizontal += amount;
                    depth += (aim * amount);
                }

                // verlaag je aim
                if (dataSplit[0].equals("up")) {
                    aim -= amount;
                }

                // verhoog je aim
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
