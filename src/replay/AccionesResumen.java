package replay;

import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.ResumenTurno;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mapa.Jugabilidad;

/**
 *
 * @author luisGonzalez
 */
public class AccionesResumen {
    
    private Jugabilidad jugabilidad = new Jugabilidad();
    
    public void verificarEstadoJugadores(Juego misDatos, ResumenTurno resumen, ArrayList<NavesCamino> listNaves){
        String nombreJugador = resumen.getNombreJugador();
        int nodoJugador = busquedaJugador(nombreJugador, misDatos);
        if(resumen.getEstadoJugador() == false){
            misDatos.getJugadores().get(nodoJugador).setEnJuego("false");
            jugabilidad.eliminarFlotasJugador(misDatos, listNaves, nodoJugador);
            JOptionPane.showMessageDialog(null, nombreJugador+" ha salido del juego");
        } 
    }
    
    public Integer busquedaJugador(String nombreJugador, Juego misDatos){
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
}
