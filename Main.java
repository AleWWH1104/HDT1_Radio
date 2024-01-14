import java.util.Scanner;
import java.util.List;


public class Main {
    Scanner in = new Scanner(System.in);

    public Main() {
        Radio radio = new Radio(false, Radio.AM, 0, 0);
        boolean salir = false;

        while (!salir) {
            boolean encendido = radio.getEncendido();
            String nombre = radio.marca;
            System.out.println("Radio: " + nombre);
            System.out.println("1. Encender Radio");
            System.out.println("2. Cambiar Banda (AM/FM)");
            System.out.println("3. Avanzar emisoras");
            System.out.println("4. Guardar emisoras");
            System.out.println("5. Seleccionar emisora de un botón");
            System.out.println("6. Ajustar Volumen");
            System.out.println("7. Apagar Radio");

            String opcion = in.nextLine();

            switch (opcion) {
                case "1":
                    radio.setEncendido(true);
                    System.out.println("Radio ENCENDIDO");
                    break;
                case "2":
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
                    if (encendido) {
                        int banda = radio.getBanda();
                        System.out.print("Elija un número de emisora: ");
                        double numEmisora = Double.parseDouble(in.nextLine());
                        double emisora = radio.aproximarNumero(numEmisora, banda);
                        System.out.println(emisora);
                        radio.setEstacionBanda(emisora, banda);
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "4":
                    if (encendido) {
                        System.out.print("En qué botón desea guardar? (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        radio.guardarEstacion(radio.getEstacion(), radio.getBanda(), posicion - 1);
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "5":
                    if (encendido) {
                        System.out.print("Seleccione botón (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        List<Double> resultado = radio.recuperarEstacion(posicion - 1);
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
                    if (encendido) {
                        System.out.println("Presione w para subir volumen, s para bajar volumen");
                        String opVol = in.nextLine();
                        if (opVol.equals("w")) {
                            radio.volUp();
                            System.out.println("Volumen actual: " + radio.getVolumen());
                        } else if (opVol.equals("s")) {
                            radio.volDown();
                            System.out.println("Volumen actual: " + radio.getVolumen());
                        }
                    } else {
                        System.out.println("Radio está apagado; Enciéndalo para sus funciones");
                    }
                    break;
                case "7":
                    radio.setEncendido(false);
                    System.out.println("Radio APAGADO");
                    break;
                default:
                    System.out.println("Ingrese valor válido");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main inicio = new Main();
    }
}
