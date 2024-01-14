import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Implementación de la interfaz InterfazRadio_30
public class Radio implements InterfazRadio_30 {
    // Variables de instancia
    protected final String marca = "Sansun";
    public static final int AM = 0;
    public static final int FM = 1;
    private boolean encendido;
    private int banda;
    private double estacion;
    private int volumen;
    private int numFavoritos = 12;

    // Lista para almacenar emisoras guardadas en botones
    public List<List<Double>> favoritos;

    // Rangos para las bandas AM y FM
    private static final double[] rangoAM = { 530, 1610, 10 };
    private static final double[] rangoFM = { 87.9, 107.9, 0.2 };

    // Constructor
    public Radio(boolean encendido, int banda, double estacion, int volumen) {
        this.encendido = encendido;
        this.banda = banda;
        this.estacion = estacion;
        this.volumen = volumen;

        // Inicializar la lista de favoritos
        favoritos = new ArrayList<>(numFavoritos);
        for (int i = 0; i < numFavoritos; i++) {
            favoritos.add(new ArrayList<>());
        }
    }

    // Obtener el estado de encendido de la radio
    public boolean getEncendido() {
        return encendido;
    }

    // Establecer el estado de encendido de la radio
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    // Obtener la banda actual de la radio
    public int getBanda() {
        return banda;
    }

    // Obtener la estación actual de la radio
    public double getEstacion() {
        return estacion;
    }

    // Establecer la estación y la banda de la radio
    public void setEstacionBanda(double frecuencia, int banda) {
        this.estacion = frecuencia;
        this.banda = banda;
    }

    // Obtener el volumen actual de la radio
    public int getVolumen() {
        return volumen;
    }

    // Establecer el volumen de la radio con límites de 0 a 100
    public void setVolumen(int volumen) {
        if (volumen < 0) {
            this.volumen = 0;
        } else if (volumen > 100) {
            this.volumen = 100;
        } else {
            this.volumen = volumen;
        }
    }

    // Incrementar el volumen si es posible (hasta 100)
    public void volUp() {
        if (volumen < 100) {
            volumen++;
        }
    }

    // Decrementar el volumen si es posible (hasta 0)
    public void volDown() {
        if (volumen > 0) {
            volumen--;
        }
    }

    // Guardar una estación en el botón especificado
    public void guardarEstacion(double estacion, int banda, int boton) {
        List<Double> emisoras = favoritos.get(boton);
        if (emisoras == null) {
            emisoras = new ArrayList<>();
        }
        emisoras.add(estacion);
        favoritos.set(boton, emisoras);
        System.out.println("Emisora guardada en el botón " + boton);
    }

    // Recuperar emisoras guardadas en el botón especificado
    public List<Double> recuperarEstacion(int posicion) {
        if (posicion >= 0 && posicion < favoritos.size()) {
            return favoritos.get(posicion);
        } else {
            System.out.println("Posición no válida. Estación no agregada.");
            return null;
        }
    }

    // Aproximar una frecuencia a la más cercana según la banda
    public double aproximarNumero(double numero, int condicion) {
        double[] rango;
        if (condicion == AM) {
            rango = rangoAM;
        } else if (condicion == FM) {
            rango = rangoFM;
        } else {
            throw new IllegalArgumentException("Condición no válida. Debe ser AM o FM.");
        }

        double rangoMin = rango[0];
        double rangoMax = rango[1];
        double paso = rango[2];

        double cociente = Math.round((numero - rangoMin) / paso);
        double aproximado = cociente * paso + rangoMin;

        if (aproximado < rangoMin) {
            aproximado = rangoMin;
        } else if (aproximado > rangoMax) {
            aproximado = rangoMax;
        }
        return Math.round(aproximado * 10.0) / 10.0;
    }

    // Mostrar emisoras guardadas en cada botón
    public void mostrarEmisorasGuardadas() {
        for (int i = 0; i < favoritos.size(); i++) {
            List<Double> emisoras = favoritos.get(i);
            System.out.println("Botón " + (i + 1) + ":");
            for (double emisora : emisoras) {
                System.out.println(emisora);
            }
        }
    }
}
