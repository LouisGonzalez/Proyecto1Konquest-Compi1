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
    private ArrayList<ResumenTurno> listResumen;
    private Boolean todoCorrecto;

    public Boolean getTodoCorrecto() {
        return todoCorrecto;
    }

    public void setTodoCorrecto(Boolean todoCorrecto) {
        this.todoCorrecto = todoCorrecto;
    }

    public ArrayList<ResumenTurno> getListResumen() {
        return listResumen;
    }

    public void setListResumen(ArrayList<ResumenTurno> listResumen) {
        this.listResumen = listResumen;
    }
    
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
