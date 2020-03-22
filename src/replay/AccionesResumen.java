package replay;

import Pollitos.Juego;
import Pollitos.ResumenTurno;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class AccionesResumen {
    
    public void verificarEstadoJugadores(Juego misDatos, ResumenTurno resumen){
        String nombreJugador = resumen.getNombreJugador();
        int nodoJugador = busquedaJugador(nombreJugador, misDatos);
        if(resumen.getEstadoJugador() == false){
            misDatos.getJugadores().get(nodoJugador).setEnJuego("false");
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
