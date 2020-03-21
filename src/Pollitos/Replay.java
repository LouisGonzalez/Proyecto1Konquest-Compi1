package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Replay {
    
    private Integer noTurno;
    private ArrayList<DatosAcciones> listAcciones;
    private ArrayList<DatosImpacto> listImpactos;

    public Integer getNoTurno() {
        return noTurno;
    }

    public void setNoTurno(Integer noTurno) {
        this.noTurno = noTurno;
    }

    public ArrayList<DatosAcciones> getListAcciones() {
        return listAcciones;
    }

    public void setListAcciones(ArrayList<DatosAcciones> listAcciones) {
        this.listAcciones = listAcciones;
    }

    public ArrayList<DatosImpacto> getListImpactos() {
        return listImpactos;
    }

    public void setListImpactos(ArrayList<DatosImpacto> listImpactos) {
        this.listImpactos = listImpactos;
    }
       
}
