package P1;

import java.io.File;
import java.nio.file.Path;

public class Ex8 {
    public static void main(String[] args) {
        // Creem un objecte File
        File file = new File("C:\\Users\\usuario\\IdeaProjects\\M06\\media\\porsche-model.jpg ");

        // Convertim el File a Path
        Path path = file.toPath();
        System.out.println("Path: " + path);


        // Convertim el Path de tornada a File
        File backToFile = path.toFile();
        System.out.println("File: " + backToFile);
    }

}
