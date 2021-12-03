package daniel.slobben.third;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class thirdB {

    public static void main(String[] args) {
        // write your code here
        boolean [] mostCommonBit;

        // Kan ik ook wat makkelijker een int array initializeren?
        int[] bitCounter = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        try {
            File myObj = new File("thirdInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Lees de volgende regel
                String data = myReader.nextLine();
                String[] split = data.split("(?!^)");

                // Hele mooie teller
                int teller = 0;
                for (String bit: split) {
                    if (Objects.equals(bit, "0")) {
                        bitCounter[teller]--;
                    }
                    if (Objects.equals(bit, "1")) {
                        bitCounter[teller]++;
                    }
                    teller++;
                }
            }
            myReader.close();

            // Knal er maar wat in
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

            // Alle string builder mogen hun builder uitdoen.
            String gammaString = gamma.toString();
            String epsilonString = epsilon.toString();

            // Alle strings mogen kleur bekennen van binary naar decimal
            int gammaInt = Integer.parseInt(gammaString,2);
            int epsilonInt = Integer.parseInt(epsilonString, 2);

            System.out.println("result: " + (gammaInt * epsilonInt));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
