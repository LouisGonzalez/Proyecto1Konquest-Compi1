/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;

import Pollitos.AccionesOnline;
import Pollitos.Juego;
import Pollitos.NavesCamino;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class AccionesMovimiento {
    
    public void actualizarTurno(Juego misDatos, AccionesOnline online){
    //    VentanaPrincipal.contadorTurnos = online.getTurnos().getTurno();
        VentanaPrincipal.contador = VentanaPrincipal.contador + 1;
    }         
    
    public void agregarNaves(Juego misDatos, AccionesOnline online, ArrayList<NavesCamino> listNaves){
        String nombreJugador = online.getDatosAcciones().get(0).getNombreJugador();
        Integer nodoJugador = busquedaJugador(misDatos, nombreJugador);
        if(nodoJugador == null){
            JOptionPane.showMessageDialog(null, "Este jugador no exite dentro de la base de datos del mapa.");
        } else {
             agregarFlotas(misDatos, listNaves, online, nodoJugador);
        }
    }
    
    public Integer busquedaJugador(Juego misDatos, String nombreJugador){
        Integer nodoJugador = null;
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            String nombreAux = misDatos.getJugadores().get(i).getNombre();
            if(nombreAux.equals(nombreJugador)){
                nodoJugador = i;
                break;
            }
        }
        return nodoJugador;
    }
    
    public void agregarFlotas(Juego misDatos, ArrayList<NavesCamino> listNaves, AccionesOnline online, int nodoJugador){
        for (int i = online.getDatosAcciones().size()-1; i >= 0; i--) {
            for (int j = online.getDatosAcciones().get(i).getListNaves().size()-1; j >= 0; j--) {
                String nombrePlaneta = online.getDatosAcciones().get(i).getListNaves().get(j).getPlanetaOrigen();
                int noNaves = online.getDatosAcciones().get(i).getListNaves().get(j).getNoNaves();
                Integer nodoPlaneta = busquedaPlaneta(nombrePlaneta, misDatos, nodoJugador);
                if(nodoPlaneta == null){
                    JOptionPane.showMessageDialog(null, "Este planeta no existe");
                } else {
                    restarNavesJugador(misDatos, noNaves, nodoJugador, nodoPlaneta);
                    
                    listNaves.add(online.getDatosAcciones().get(i).getListNaves().get(j));
            }
            }
        }
    }
    
    public void restarNavesJugador(Juego misDatos, int noNavesEnviadas, int nodoJugador, int nodoPlaneta){
        int totalNaves = Integer.parseInt(misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(nodoPlaneta).getNaves());
        int nuevoTotal = totalNaves - noNavesEnviadas;
        misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(nodoPlaneta).setNaves(Integer.toString(nuevoTotal));
    }
    
    public Integer busquedaPlaneta(String nombrePlaneta, Juego misDatos, int nodoJugador){
        Integer nodoPlaneta = null;
        for (int i = 0; i < misDatos.getJugadores().get(nodoJugador).getMisPlanetas().size(); i++) {
            String planetaAux = misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(i).getNombre();
            if(planetaAux.equals(nombrePlaneta)){
                nodoPlaneta = i;
                break;
            }
        }
        return nodoPlaneta;
    }
    
}
