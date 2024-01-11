import java.util.List;

public interface InterfazRadio_30 {

    public static final int AM = 0;
    public static final int FM = 1;

    public void setEncendido(boolean encendido);

    public void setVolumen(int volumen);

    public void setEstacionBanda(float frecuencia, int banda);

    public boolean getEncendido();

    public float getEstacion();

    public int getBanda();

    public int getVolumen();

    public void guardarEstacion(float frecuencia, int banda, int posicion);

    public List<Float> recuperarEstacion(int posicion);
}