package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class DatosGuardados {
    
    private Integer contador;
    private ArrayList<NavesCamino> listNaves;
    private Integer turnoJugador;
    private Boolean todoCorrecto;

    public Boolean getTodoCorrecto() {
        return todoCorrecto;
    }

    public void setTodoCorrecto(Boolean todoCorrecto) {
        this.todoCorrecto = todoCorrecto;
    }
    
    public Integer getTurnoJugador() {
        return turnoJugador;
    }

    public void setTurnoJugador(Integer turnoJugador) {
        this.turnoJugador = turnoJugador;
    }
    
    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public ArrayList<NavesCamino> getListNaves() {
        return listNaves;
    }

    public void setListNaves(ArrayList<NavesCamino> listNaves) {
        this.listNaves = listNaves;
    }
    
}
