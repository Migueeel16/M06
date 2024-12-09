package P1;


import java.io.File;

//Crea un programa Java que donat un directori, llisti per pantalla
// els fitxers i directoris que conté, idealment,
// també per a cada subdirectori. Usa la classe File
public class Ex1 {
    public static void main(String[] args) {
        String directoryPath = "/home/48095097g/IdeaProjects/M06_P0/media";

        File directory = new File(directoryPath);

        if (directory.isDirectory() && directory.exists()) {
            System.out.println("Contenido del directorio: " + directoryPath);
            listarFitxeros(directory);
        } else {
            System.out.println("El directorio no existeix o la ruta no es de un directori");
        }

    }

    public static void listarFitxeros(File directori) {
        // Obtenir els fitxers i subdirectoris dins del directori
        File[] contenido = directori.listFiles();

        // Comprovar si hi ha fitxers i subdirectoris dins
        if (contenido != null) {
            for (File fitxer : contenido) {
                if (fitxer.isDirectory()) {
                    // Si és un subdirectori, llistar-lo i cridar recursivament a la funció per explorar-lo
                    System.out.println("[Directori] " + fitxer.getAbsolutePath());
                    listarFitxeros(fitxer);  // Cridar recursivament per llistar els continguts del subdirectori
                } else {
                    // Si és un fitxer, simplement llistar el nom
                    System.out.println("[Fitxer] " + fitxer.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No es poden llegir els fitxers del directori.");
        }
    }
}
