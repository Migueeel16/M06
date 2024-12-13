package P1;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex5 {
    public static void main(String[] args) {
        // Ruta de ejemplo (modifica según tu sistema)
        String rutaEjemplo = "C:\\Users\\usuario\\IdeaProjects\\M06\\media";


        // Crear objetos Path usando diferentes métodos
        Path rutaDirecta = crearConPath(rutaEjemplo);
        mostrarDetallesRuta(rutaDirecta, "Directamente con Path.of()");


        Path rutaConPaths = crearConPaths(rutaEjemplo);
        mostrarDetallesRuta(rutaConPaths, "Con Paths.get()");


        Path rutaConURI = crearConURI("file://" + rutaEjemplo.replace("\\", "/"));
        mostrarDetallesRuta(rutaConURI, "Con URI");


        Path rutaConFileSystem = crearConFileSystem(rutaEjemplo);
        mostrarDetallesRuta(rutaConFileSystem, "Con FileSystems.getPath()");
    }


    // Crear Path directamente con Path.of()
    private static Path crearConPath(String ruta) {
        return Path.of(ruta);
    }


    // Crear Path con Paths.get()
    private static Path crearConPaths(String ruta) {
        return Paths.get(ruta);
    }


    // Crear Path con URI
    private static Path crearConURI(String uriString) {
        try {
            URI uri = new URI(uriString);
            return Paths.get(uri);
        } catch (Exception e) {
            System.out.println("Error al crear la ruta con URI: " + e.getMessage());
            return null;
        }
    }


    // Crear Path con FileSystems
    private static Path crearConFileSystem(String ruta) {
        return FileSystems.getDefault().getPath(ruta);
    }


    // Mostrar detalles de la ruta
    private static void mostrarDetallesRuta(Path ruta, String metodo) {
        if (ruta == null) {
            System.out.println("La ruta no se pudo crear con " + metodo);
            return;
        }


        System.out.println("\nDetalles de la ruta creada con " + metodo + ":");


        // 1. Comprobar si la ruta existe
        if (Files.exists(ruta)) {
            System.out.println("  La ruta existe: " + ruta);
        } else {
            System.out.println("  La ruta NO existe: " + ruta);
        }


        // 2. Mostrar ruta absoluta
        System.out.println("  Ruta absoluta: " + ruta.toAbsolutePath());


        // 3. Mostrar nombre del archivo/directorio
        System.out.println("  Nombre del archivo/directorio: " + ruta.getFileName());


        // 4. Mostrar directorio padre
        System.out.println("  Directorio padre: " + (ruta.getParent() != null ? ruta.getParent() : "No tiene directorio padre"));


        // 5. Mostrar cada componente de la ruta
        System.out.println("  Componentes de la ruta:");
        for (Path componente : ruta) {
            System.out.println("    - " + componente);
        }


        // 6. Mostrar unidad de disco (solo en sistemas con drives como Windows)
        Path root = ruta.getRoot();
        System.out.println("  Unidad de disco: " + (root != null ? root : "No aplica"));


        // 7. Mostrar si es absoluta o relativa
        if (ruta.isAbsolute()) {
            System.out.println("  La ruta es absoluta.");
        } else {
            System.out.println("  La ruta es relativa. Ruta absoluta: " + ruta.toAbsolutePath());
        }
    }

}
