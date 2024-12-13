package P1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex5_extends {
    public static void main(String[] args) {
        // Ruta de ejemplo
        Path ruta = Paths.get("C:\\Users\\usuario\\IdeaProjects\\M06\\media");


        try {
            // Verificar si la ruta existe
            if (Files.exists(ruta)) {
                System.out.println("La ruta existe: " + ruta);


                // Mostrar ruta absoluta
                System.out.println("Ruta absoluta: " + ruta.toAbsolutePath());


                // Mostrar nombre del archivo/directorio
                System.out.println("Nombre del archivo/directorio: " + ruta.getFileName());


                // Mostrar directorio padre
                System.out.println("Directorio padre: " + ruta.getParent());


                // Mostrar componentes de la ruta
                System.out.println("Componentes de la ruta:");
                for (Path componente : ruta) {
                    System.out.println("  - " + componente);
                }


                // Mostrar unidad de disco (raíz)
                System.out.println("Unidad de disco: " + ruta.getRoot());


                // Verificar si es absoluta o relativa
                if (ruta.isAbsolute()) {
                    System.out.println("La ruta es absoluta.");
                } else {
                    System.out.println("La ruta es relativa. Ruta absoluta: " + ruta.toAbsolutePath());
                }


                // Si la ruta es un directorio, listar sus contenidos
                if (Files.isDirectory(ruta)) {
                    System.out.println("Contenido del directorio: " + ruta);


                    try (DirectoryStream<Path> directorioStream = Files.newDirectoryStream(ruta)) {
                        for (Path entrada : directorioStream) {
                            System.out.println("  - " + entrada.getFileName() + (Files.isDirectory(entrada) ? " [Directorio]" : " [Archivo]"));
                        }
                    }
                }


            } else {
                System.out.println("La ruta no existe.");
            }


        } catch (IOException e) {
            System.out.println("Error al acceder a la ruta: " + e.getMessage());
        }
    }

}
