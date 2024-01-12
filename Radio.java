/**
 * Radio
 * @author David Dominguez
 * @version 1.0
 * @since 2024-01-11
 */
public class Radio {

    private int volumen;

    public int getVol() {
        return volumen;
    }

    public void setVol(int volumen) {

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
}
