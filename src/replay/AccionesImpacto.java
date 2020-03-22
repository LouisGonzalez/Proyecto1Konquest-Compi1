/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replay;
import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import java.awt.Color;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class AccionesImpacto {


    public Integer busquedaJugador(Juego misDatos, String nombreJugador) {
        Integer nodoJugador = null;
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            String nombreAux = misDatos.getJugadores().get(i).getNombre();
            if (nombreAux.equals(nombreJugador)) {
                nodoJugador = i;
                break;
            }
        }
        return nodoJugador;
    }

    public Integer busquedaPlaneta(Juego misDatos, String nombrePlaneta, int nodoJugador) {
        Integer nodoPlaneta = null;
        for (int i = 0; i < misDatos.getJugadores().get(nodoJugador).getMisPlanetas().size(); i++) {
            String planetaAux = misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(i).getNombre();
            if (planetaAux.equals(nombrePlaneta)) {
                nodoPlaneta = i;
                break;
            }
        }
        return nodoPlaneta;
    }

    public void restarNavesPlaneta(Juego misDatos, int nodoJugador, int nodoPlaneta, int noNaves) {
        misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(nodoPlaneta).setNaves(Integer.toString(noNaves));
    }

    public void destruirPlaneta(Juego misDatos, int jugadorAtacante, String planetaAtacante, String planetaAtacado) {
        int posX = 0;
        int posY = 0;
        String color = "";
        for (int i = 0; i < misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().size(); i++) {
            Planetas planetaAux = misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().get(i);
            if (planetaAux.getNombre().equals(planetaAtacante)) {
                posX = Integer.parseInt(planetaAux.getPosicionX());
                posY = Integer.parseInt(planetaAux.getPosicionY());
                color = misDatos.getJugadores().get(jugadorAtacante).getColor();
                break;
            }
        }
        String[] colores = color.split(",");
        int[] convertidos = new int[colores.length];
        for (int i = 0; i < colores.length; i++) {
            convertidos[i] = Integer.parseInt(colores[i]);
        }
        VentanaPrincipal.tablero[posY][posX].setBackground(new Color(convertidos[0], convertidos[1], convertidos[2], convertidos[3]));
        JOptionPane.showMessageDialog(null, "Planeta: " + planetaAtacado + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorAtacante).getNombre());

    }

    public void eliminarFlotaAtacante(ArrayList<NavesCamino> listNaves, int nodoFlota) {
        listNaves.remove(nodoFlota);
    }

}
