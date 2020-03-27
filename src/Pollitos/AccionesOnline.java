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
   // private ArrayList<DatosImpacto> listImpactos;
    private ArrayList<ResumenTurno> listResumen;
    private Turnos turnos;

    public ArrayList<DatosAcciones> getDatosAcciones() {
        return datosAcciones;
    }

    public void setDatosAcciones(ArrayList<DatosAcciones> datosAcciones) {
        this.datosAcciones = datosAcciones;
    }

    /*    public ArrayList<DatosImpacto> getListImpactos() {
        return listImpactos;
    }

    public void setListImpactos(ArrayList<DatosImpacto> listImpactos) {
        this.listImpactos = listImpactos;
    }*/

    public ArrayList<ResumenTurno> getListResumen() {
        return listResumen;
    }

    public void setListResumen(ArrayList<ResumenTurno> listResumen) {
        this.listResumen = listResumen;
    }

    public Turnos getTurnos() {
        return turnos;
    }

    public void setTurnos(Turnos turnos) {
        this.turnos = turnos;
    }
    
}
