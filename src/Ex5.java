import java.io.FileReader;
import java.io.FileWriter;

//Crea una aplicació en Java que llegeixi el contingut d'un fitxer de text, el modifiqui
// convertint tot el text a majúscules, i el guardi en un nou fitxer de sortida.
//Usa les classes FileReader i FileWriter.
public class Ex5 {
    public static void main(String[] args) {

        String inputFile = "/home/48095097g/IdeaProjects/M06_P0/media/Ex5.txt";
        String outputFile = "/home/48095097g/IdeaProjects/M06_P0/media/Ex5_Mayusculas.txt";

        try {
            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(outputFile);

            int character;

            while ((character = fr.read()) != -1) {
                fw.write(Character.toUpperCase(character));
            }

            fr.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
