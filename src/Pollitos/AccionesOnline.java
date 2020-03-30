/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class AccionesOnline {

    private ArrayList<DatosAcciones> datosAcciones;
    private ArrayList<ResumenTurno> listResumen;
    private Boolean todoCorrecto;

    public Boolean getTodoCorrecto() {
        return todoCorrecto;
    }

    public void setTodoCorrecto(Boolean todoCorrecto) {
        this.todoCorrecto = todoCorrecto;
    }
  
    public ArrayList<DatosAcciones> getDatosAcciones() {
        return datosAcciones;
    }

    public void setDatosAcciones(ArrayList<DatosAcciones> datosAcciones) {
        this.datosAcciones = datosAcciones;
    }

    
    public ArrayList<ResumenTurno> getListResumen() {
        return listResumen;
    }

    public void setListResumen(ArrayList<ResumenTurno> listResumen) {
        this.listResumen = listResumen;
    }

    
    
}
