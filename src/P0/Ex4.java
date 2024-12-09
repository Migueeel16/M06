package P0;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Crea una aplicació en Java que llegeixi una imatge com un flux de bytes
// utilitzant FileInputStream i escrigui una còpia de la imatge utilitzant FileOutputStream.
public class Ex4 {
    public static void main(String[] args) {

        String inputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model.png";
        String outputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model_copy.png";

        try {
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println( "Se ha copiado el fichero correctamente");
            fis.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}