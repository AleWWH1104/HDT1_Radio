import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    public Main() {
        Radio radio = new Radio(false, 0, 0, 0);
        boolean salir = false;
        while (!salir) {
            boolean encendido = radio.getEncendido();
            String nombre = radio.marca;
            System.out.println("Radio: "+ nombre);
            System.out.println("1.Encender Radio");
            System.out.println("2.Cambiar Banda (AM/FM)");
            System.out.println("3.Avanzar emisoras");
            System.out.println("4.Guardar emisoras");
            System.out.println("5.Seleccionar emisora de un boton");
            System.out.println("6.Ajustar Volumen");
            System.out.println("7.Apagar Radio");
            String opcion = in.nextLine();
            switch (opcion) {
                case "1":
                    radio.setEncendido(true);
                    System.out.println("Radio ENCENDIDO");
                    break;
                case "2":
                    if (encendido == true){
                        System.out.println("0 para AM\n1 para FM");
                        int banda = Integer.parseInt(in.nextLine());
                        double emisora = radio.getEstacion();
                        radio.setEstacionBanda(emisora, banda);
                    }else{
                        System.out.println("Radio esta apago; Encienda para sus funciones");
                    } break;
                case "3":
                    if (encendido == true){
                        int banda = radio.getBanda();
                        System.out.print("Eliga un numero de emisora: ");
                        double numEmisora = Double.parseDouble(in.nextLine());
                        double emisora = radio.aproximarNumero(numEmisora, banda);
                        System.out.println(emisora);
                        radio.setEstacionBanda(emisora, banda);
                    }else{System.out.println("Radio esta apago; Encienda para sus funciones");
                    } break;
                case "4":
                    if (encendido == true){
                        System.out.print("En que boton desea guardar? (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        //int posicion2 = posicion - 1;
                        radio.guardarEstacion(radio.getEstacion(), radio.getBanda(), posicion);
                    }else{System.out.println("Radio esta apago; Encienda para sus funciones");
                    } break;
                case "5":
                    if (encendido == true){
                        System.out.print("Seleccion boton? (1-12): ");
                        int posicion = Integer.parseInt(in.nextLine());
                        List<Double> resultado = radio.recuperarEstacion(posicion);
                        // Verificas si el resultado es null (posición no válida) o imprimes la lista
                        if (resultado != null) {
                            System.out.println("Estación recuperada para la posición " + posicion+ ":");
                            for (Double valor : resultado) {
                                System.out.println(valor);
                            }
                        }
                    }else{System.out.println("Radio esta apago; Encienda para sus funciones");
                    } break;
                case "6":
                    if (encendido == true){
                    System.out.println("Presiona w para subir volumen");
                    System.out.println("Presiona s para bajar volumen");
                    String opVol = in.nextLine();
                    if (opVol.equals("w")){
                        radio.volUp();
                        int vol = radio.getVolumen();
                        System.out.println("Volumen actual: " + vol);   
                    } else if (opVol.equals("s")){
                        radio.volDown();
                        int vol = radio.getVolumen();
                        System.out.println(vol);
                    }}else{System.out.println("Radio esta apago; Encienda para sus funciones");
                }break;
                case "7":
                    radio.setEncendido(false);
                    System.out.println("Radio APAGADO");
                    break;
                default:
                    System.out.println("Ingrese valor valido");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main inicio = new Main();
    }
}
