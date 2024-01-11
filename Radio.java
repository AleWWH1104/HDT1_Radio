import java.util.ArrayList;
import java.util.List;

public class Radio implements InterfazRadio_30 {
    protected final String marca = "Sansun";
    public static final int AM = 0;
    public static final int FM = 1;
    private boolean encendido;
    private int banda;
    private float estacion;
    private int volumen;
    private int numFavoritos = 6;

    private List<List<Float>> favoritos;

    private static final double[] rangoAM = { 530, 1610, 10 };
    private static final double[] rangoFM = { 87.9, 107.9, 0.2 };

    public Radio(boolean encendido, int banda, float estacion, int volumen) {
        this.encendido = encendido;
        this.banda = banda;
        this.estacion = estacion;
        this.volumen = volumen;

        favoritos = new ArrayList<>(numFavoritos);
        for (int i = 0; i < numFavoritos; i++) {
            favoritos.add(new ArrayList<>());
        }
    }

    public boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getBanda() {
        return banda;
    }

    public float getEstacion() {
        return estacion;
    }

    public void setEstacionBanda(float frecuencia, int banda) {
        this.estacion = frecuencia;
        this.banda = banda;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void guardarEstacion(float frecuencia, int banda, int posicion) {
        if (posicion >= 0 && posicion < favoritos.size()) {
            List<Float> estacionList = favoritos.get(posicion);
            estacionList.clear();
            estacionList.add(frecuencia);
            estacionList.add((float) banda);
        } else {
            System.out.println("Invalid position. Station not added.");
        }
    }

    public List<Float> recuperarEstacion(int posicion) {
        if (posicion >= 0 && posicion < favoritos.size()) {
            return favoritos.get(posicion);
        } else {
            System.out.println("Invalid position. No station found.");
            return null;
        }
    }

    public static double aproximarNumero(double numero, int condicion) {
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
}
