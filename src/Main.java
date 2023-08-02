import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filename = "diploma.csv";

        int index = 0;

        ArrayList<String> diplomaNames = new ArrayList<>();
        ArrayList<String> courseNames = new ArrayList<>();

        File file = new File(filename);
        if(file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        if(file.canRead()) {
            System.out.println("File is readable.");
        } else {
            System.out.println("File is not readable.");
        }

        ArrayList<DiplomaData> diplomaList = new ArrayList<>();

        try(Scanner input = new Scanner(file)) {
            input.nextLine();

            while(input.hasNextLine()) {
                String line = input.nextLine();
                if (index >= 0) {
                    String[] values = line.split(",");

                    DiplomaData diploma = new DiplomaData(values[1], values[2],
                            Integer.parseInt(values[3]) + Integer.parseInt(values[4]) +
                                    Integer.parseInt(values[5]) + Integer.parseInt(values[6]) +
                                    Integer.parseInt(values[7]) + Integer.parseInt(values[8]),
                            Integer.parseInt(values[3]),
                            Integer.parseInt(values[3]));

                    diplomaList.add(diploma);

                    //System.out.print(index + " ");
                    //System.out.println(diploma);
                }
                index++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (PrintWriter diplomaOut = new PrintWriter("diploma_lanjutan.txt");
             PrintWriter courseOut = new PrintWriter("kursus_pengkhususan.txt")) {

            for(DiplomaData d : diplomaList) {
                if(d.category.equals(" Diploma Lanjutan")) {
                    diplomaNames.add(d.name);
                    diplomaOut.println(d);
                } else if(d.category.equals("Kursus Pengkhususan")) {
                    courseNames.add(d.name);
                    courseOut.println(d);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

}