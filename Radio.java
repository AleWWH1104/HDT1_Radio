import java.util.ArrayList;
import java.util.List;

public class Radio implements InterfazRadio_30 {
    protected final String marca = "Sansun";
    public static final int AM = 0;
    public static final int FM = 1;
    private boolean encendido;
    private int banda;
    private double estacion;
    private int volumen;
    private int numFavoritos = 12;

    public List<List<Double>> favoritos;

    private static final double[] rangoAM = { 530, 1610, 10 };
    private static final double[] rangoFM = { 87.9, 107.9, 0.2 };

    public Radio(boolean encendido, int banda, double estacion, int volumen) {
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

    public double getEstacion() {
        return estacion;
    }

    public void setEstacionBanda(double frecuencia, int banda) {
        this.estacion = frecuencia;
        this.banda = banda;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        if (volumen < 0) {
            this.volumen = 0;
        } else if (volumen > 100) {
            this.volumen = 100;
        } else {
            this.volumen = volumen;
        }
    }

    public void volUp(){
        if (volumen < 100) {
            this.volumen = volumen + 1;
            if (volumen > 100) {
                this.volumen = 100;
            }
        }
    }

    public void volDown(){
        if (volumen > 0) {
            this.volumen = volumen - 1;
            if (volumen < 0) {
                this.volumen = 0;
            }
        }
    }

    public void guardarEstacion(double frecuencia, int banda, int posicion) {
        if (posicion >= 0 && posicion < favoritos.size()) {
            List<Double> estacionList = favoritos.get(posicion);
            estacionList.clear();
            estacionList.add(frecuencia);
            estacionList.add((double) banda);
        } else {
            System.out.println("Posicion no válida. Estacion no agregada.");
        }
    }

    public List<Double> recuperarEstacion(int posicion) {
        if (posicion >= 0 && posicion < favoritos.size()) {
            return favoritos.get(posicion);
        } else {
            System.out.println("Posicion no válida. Estacion no agregada.");
            return null;
        }
    }

    public double aproximarNumero(double numero, int condicion) {
        double[] rango;
        if (condicion == AM) {
            rango = rangoAM;
        } else if (condicion == FM) {
            rango = rangoFM;
        } else {
            throw new IllegalArgumentException("Condición no valida. Debe ser AM o FM.");
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
