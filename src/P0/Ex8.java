package P0;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


//Crea una aplicació en Java que llegeixi una imatge d'un fitxer, la modifiqui
// canviant els colors a escala de grisos, i després guardi la imatge
// modificada en un nou fitxer.
//Usar classes de manipulació d'imatges com BufferedImage i ImageIO.
public class Ex8 {
    public static void main(String[] args) {

        String inputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model.png";
        String outputFile = "/home/48095097g/IdeaProjects/M06_P0/media/porsche-model_blancoynegro.png";

        try {

            BufferedImage image = ImageIO.read(new File(inputFile));


            int width = image.getWidth();
            int height = image.getHeight();

            // Recórrer cada píxel i aplicar la fórmula de grisos
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    // Obtenir el color del píxel actual
                    int rgb = image.getRGB(x, y);
                    Color color = new Color(rgb);

                    // Descomposició en canals (vermell, verd, blau)
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    // Calcul del valor de gris
                    int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);

                    // Crear un nou color en escala de grisos
                    Color grayColor = new Color(gray, gray, gray);

                    // Assignar el nou color al píxel
                    image.setRGB(x, y, grayColor.getRGB());
                }
            }

            // Guardar la imatge en escala de grisos
            ImageIO.write(image, "png", new File(outputFile));
            System.out.println("La imatge s'ha convertit a escala de grisos i guardat correctament!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
