package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class DatosAcciones {
    
    private String nombreJugador;
    private ArrayList<NavesCamino> listNaves;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ArrayList<NavesCamino> getListNaves() {
        return listNaves;
    }

    public void setListNaves(ArrayList<NavesCamino> listNaves) {
        this.listNaves = listNaves;
    }
    
}
