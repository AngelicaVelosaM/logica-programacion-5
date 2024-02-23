import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("rojo", "red");
        dictionary.put("azul", "blue");
        dictionary.put("blanco", "white");
        dictionary.put("cafe", "brown");
        dictionary.put("negro", "black");

        String[] palabrasEspanol = dictionary.keySet().toArray(new String[0]);
        String[] palabrasElegidas= eligePalabrasAlAzar(palabrasEspanol, 5);

        int respuestasAcertadas = 0;
        int respuestasIncorrectas = 0;

        Scanner scanner = new Scanner(System.in);
        for (String palabra : palabrasElegidas) {
            System.out.print("Traduce '" + palabra + "' en inglés: ");
            String traduccionPersona = scanner.nextLine().toLowerCase();

            if (traduccionPersona.equals(dictionary.get(palabra))) {
                System.out.println("¡Acertaste, muy bien!");
                respuestasAcertadas++;
            } else {
                System.out.println("Nooo. La respuesta correcta es: " + dictionary.get(palabra));
                respuestasIncorrectas++;
            }
        }

        System.out.println("\nResultados:");
        System.out.println("Respuestas correctas: " + respuestasAcertadas);
        System.out.println("Respuestas incorrectas: " + respuestasIncorrectas);
    }

    private static String[] eligePalabrasAlAzar(String[] palabras, int cantidad) {
        Random random = new Random();
        String[] palabrasSeleccionadas = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int indice = random.nextInt(palabras.length);
            palabrasSeleccionadas[i] = palabras[indice];
        }
        return palabrasSeleccionadas;
    }
}

