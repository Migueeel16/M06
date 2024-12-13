package P1;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex4 {
    public static void main(String[] args) {


        // Ruta de ejemplo
        String rutaExemple = "C:\\Users\\usuario\\IdeaProjects\\M06\\media";




        // 1. Crear un objeto Path a partir de la clase Path directamente
        Path ruta1 = Path.of(rutaExemple);
        verificarRuta(ruta1, "Path.of");


        // 2. Crear un objeto Path a partir de la clase Paths
        Path ruta2 = Paths.get(rutaExemple);
        verificarRuta(ruta2, "Paths.get");


        // 3. Crear un objeto Path a partir de la clase URI
        try {
            URI uri = new URI("file:///" + rutaExemple.replace("\\", "/")); // URI estándar para archivos
            Path ruta3 = Paths.get(uri);
            verificarRuta(ruta3, "URI");
        } catch (Exception e) {
            System.out.println("Error al crear la ruta con URI: " + e.getMessage());
        }


        // 4. Crear un objeto Path a partir de la clase FileSystem
        Path ruta4 = FileSystems.getDefault().getPath(rutaExemple);
        verificarRuta(ruta4, "FileSystems.getPath");
    }


    // Método auxiliar para verificar si la ruta existe
    public static void verificarRuta(Path ruta, String metodoCreacion) {
        if (Files.exists(ruta)) {
            System.out.println("La ruta existe (" + metodoCreacion + "): " + ruta.toString());
        } else {
            System.out.println("La ruta NO existe (" + metodoCreacion + "): " + ruta.toString());
        }
    }

}
