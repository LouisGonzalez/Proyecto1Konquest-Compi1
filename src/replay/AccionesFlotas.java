/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replay;

import Pollitos.Juego;
import Pollitos.NavesCamino;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class AccionesFlotas {
    
    public void restarNavesPlaneta(Juego misDatos, int nodoJugador, String nombrePlaneta, int navesEnviadas){
        int noPlaneta = 0;
        for (int i = 0; i < misDatos.getJugadores().get(nodoJugador).getMisPlanetas().size(); i++) {
            String planetaAux = misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(i).getNombre();
            if(planetaAux.equals(nombrePlaneta)){
                 noPlaneta = i;
                 break;
            }
        }
        int navesActuales = Integer.parseInt(misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(noPlaneta).getNaves());
        int nuevoTotal = navesActuales - navesEnviadas;
        misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(noPlaneta).setNaves(Integer.toString(nuevoTotal));
    }
    
    public void agregarFlotas(ArrayList<NavesCamino> listNaves, NavesCamino aux){
        listNaves.add(aux);
    }
}
