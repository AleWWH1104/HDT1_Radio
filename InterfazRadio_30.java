import java.util.List;

public interface InterfazRadio_30 {

    public static final int AM = 0;
    public static final int FM = 1;

    public void setEncendido(boolean encendido);

    public void setVolumen(int volumen);

    public void setEstacionBanda(double frecuencia, int banda);

    public boolean getEncendido();

    public double getEstacion();

    public int getBanda();

    public int getVolumen();

    public void guardarEstacion(double frecuencia, int banda, int posicion);

    public List<Double> recuperarEstacion(int posicion);
}