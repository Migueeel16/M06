package P1;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("Unitats de disc disponibles al sistema:");


        // Obtener todas las unidades de disco utilizando FileSystems
        Iterable<FileStore> unitatsDisc = FileSystems.getDefault().getFileStores();


        // Recorre cada unidad y muestra la informacion
        for (FileStore unitat : unitatsDisc) {
            try {
                // Mostrar el nom i tipus de cada unitat
                System.out.println("Unidad: " + unitat.toString());
                System.out.println("Tipo de fichero: " + unitat.type());
                System.out.println("Espacio total: " + unitat.getTotalSpace() / (1024 * 1024) + " MB");
                System.out.println("Espacio disponible: " + unitat.getUsableSpace() / (1024 * 1024) + " MB");
                System.out.println("-----------------------------------");
            } catch (Exception e) {
                // Gestió d'errors en cas de problemes d'accés
                System.out.println("No se ha podido obtener informacion de la unidad " + unitat);
            }
        }

    }
}
