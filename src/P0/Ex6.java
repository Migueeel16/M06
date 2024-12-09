package P0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex6 {
    public static void main(String[] args) {

        String inputFile = "/home/48095097g/IdeaProjects/M06_P0/media/P0.Ex6.txt";
        String outputFile = "/home/48095097g/IdeaProjects/M06_P0/media/Ex6_Mayusculas.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            String linia;

            while ((linia = br.readLine()) != null) {
                bw.write(linia.toUpperCase());
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Fichero modificado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
