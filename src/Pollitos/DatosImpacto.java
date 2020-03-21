package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class DatosImpacto {
    
    private String nombreJugador;
    private ArrayList<Impactos> listImpactos;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ArrayList<Impactos> getListImpactos() {
        return listImpactos;
    }

    public void setListImpactos(ArrayList<Impactos> listImpactos) {
        this.listImpactos = listImpactos;
    }
    
}
