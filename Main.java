import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);

    public Main() {
        // Crear una instancia de la clase Radio
        Radio radio = new Radio(false, Radio.AM, 0, 0);
        boolean salir = false;

        while (!salir) {
            // Obtener el estado actual de la radio
            boolean encendido = radio.getEncendido();
            String nombre = radio.marca;

            // Mostrar el menú de opciones
            System.out.println("Radio: " + nombre);
            System.out.println("1. Encender Radio");
            System.out.println("2. Cambiar Banda (AM/FM)");
            System.out.println("3. Avanzar emisoras");
            System.out.println("4. Guardar emisoras");
            System.out.println("5. Seleccionar emisora de un botón");
            System.out.println("6. Ajustar Volumen");
            System.out.println("7. Apagar Radio");

            // Leer la opción del usuario
            String opcion = in.nextLine();

            // Procesar la opción seleccionada
            switch (opcion) {
                case "1":
                    // Encender la radio
                    radio.setEncendido(true);
                    System.out.println("Radio ENCENDIDO");
                    break;
                case "2":
                    // Cambiar la banda si la radio está encendida
                    if (encendido) {
                        System.out.println("0 para AM\n1 para FM");
                        int banda = Integer.parseInt(in.nextLine());
                        double emisora = radio.getEstacion();
                        radio.setEstacionBanda(emisora, banda);
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "3":
                    // Avanzar emisoras si la radio está encendida
                    if (encendido) {
                        int banda = radio.getBanda();
                        System.out.print("Eliga un numero de emisora: ");
                        double numEmisora = Double.parseDouble(in.nextLine());
                        double emisora = radio.aproximarNumero(numEmisora, banda);
                        System.out.println(emisora);
                        radio.setEstacionBanda(emisora, banda);
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "4":
                    // Guardar emisoras si la radio está encendida
                    if (encendido) {
                        System.out.print("En qué botón desea guardar? (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        radio.guardarEstacion(radio.getEstacion(), radio.getBanda(), posicion);
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "5":
                    // Seleccionar emisora de un botón si la radio está encendida
                    if (encendido) {
                        System.out.print("Seleccionar botón? (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        List<Double> resultado = radio.recuperarEstacion(posicion);
                        // Verificar si el resultado es null (posición no válida) o imprimir la lista
                        if (resultado != null) {
                            System.out.println("Estación recuperada para la posición " + posicion + ":");
                            for (Double valor : resultado) {
                                System.out.println(valor);
                            }
                        }
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "6":
                    // Ajustar volumen si la radio está encendida
                    if (encendido) {
                        System.out.println("Presiona w para subir volumen");
                        System.out.println("Presiona s para bajar volumen");
                        String opVol = in.nextLine();
                        if (opVol.equals("w")) {
                            radio.volUp();
                            int vol = radio.getVolumen();
                            System.out.println("Volumen actual: " + vol);
                        } else if (opVol.equals("s")) {
                            radio.volDown();
                            int vol = radio.getVolumen();
                            System.out.println(vol);
                        }
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "7":
                    // Apagar la radio
                    radio.setEncendido(false);
                    System.out.println("Radio APAGADO");
                    salir = true; // Salir del bucle
                    break;
                default:
                    System.out.println("Ingrese valor válido");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Iniciar la aplicación creando una instancia de Main
        Main inicio = new Main();
    }
}
