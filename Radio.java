import java.util.ArrayList;

public class Radio implements InterfazRadio_30 {
    protected final String marca = "Sansun";
    public static final int AM = 0;
    public static final int FM = 1;
    private boolean encendido;
    private int banda;
    private float estacion;
    private int volumen;

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

    }

    public <E> ArrayList<E> recuperarEstacion(int posicion) {
        return null;

    }
}