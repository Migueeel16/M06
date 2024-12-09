package P0;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex7 {
    public static void main(String[] args) {

        String inputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model.png";
        String outputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model_copy.png";

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }


            bis.close();
            bos.close();

            System.out.println( "Se ha copiado el fichero correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
