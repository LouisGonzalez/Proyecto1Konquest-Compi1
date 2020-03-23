/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replay;

import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
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

    public Integer busquedaPlanetaNeutral(Juego misDatos, String nombrePlaneta) {
        Integer nodoNeutral = null;
        for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
            String neutralAux = misDatos.getpNeutrales().get(i).getNombre();
            if (neutralAux.equals(nombrePlaneta)) {
                nodoNeutral = i;
                break;
            }
        }
        return nodoNeutral;
    }

    public void restarNavesPlaneta(Juego misDatos, int nodoJugador, int nodoPlaneta, int noNaves) {
        misDatos.getJugadores().get(nodoJugador).getMisPlanetas().get(nodoPlaneta).setNaves(Integer.toString(noNaves));
    }

    public void restarNavesNeutral(Juego misDatos, int nodoPlaneta, int noNaves) {
        misDatos.getpNeutrales().get(nodoPlaneta).setNaves(Integer.toString(noNaves));
    }

    public void destruirPlaneta(Juego misDatos, int jugadorAtacante, int jugadorAtacado, String planetaAtacante, String planetaAtacado) {
        int posX = 0;
        int posY = 0;
        String color = "";
        int nodoPlaneta = 0;
        Planetas nuevoPlaneta = null;
        for (int i = 0; i < misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().size(); i++) {
            Planetas planetaAux = misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().get(i);
            if (planetaAux.getNombre().equals(planetaAtacante)) {
                color = misDatos.getJugadores().get(jugadorAtacante).getColor();
                break;
            }
        }

        for (int i = 0; i < misDatos.getJugadores().get(jugadorAtacado).getMisPlanetas().size(); i++) {
            Planetas planetaAux = misDatos.getJugadores().get(jugadorAtacado).getMisPlanetas().get(i);
            if (planetaAux.getNombre().equals(planetaAtacado)) {
                nodoPlaneta = i;
                nuevoPlaneta = planetaAux;
                posX = Integer.parseInt(planetaAux.getPosicionX());
                posY = Integer.parseInt(planetaAux.getPosicionY());
                break;
            }
        }

        String[] colores = color.split(",");
        int[] convertidos = new int[colores.length];
        for (int i = 0; i < colores.length; i++) {
            convertidos[i] = Integer.parseInt(colores[i]);
        }
        VentanaPrincipal.tablero[posY][posX].setBackground(new Color(convertidos[0], convertidos[1], convertidos[2], convertidos[3]));
        misDatos.getJugadores().get(jugadorAtacado).getMisPlanetas().remove(nodoPlaneta);
        misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().add(nuevoPlaneta);
        JOptionPane.showMessageDialog(null, "Planeta: " + planetaAtacado + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorAtacante).getNombre());

    }

    public void destruirNeutral(Juego misDatos, int jugadorAtacante, String planetaAtacante, String planetaAtacado) {
        int posX = 0;
        int posY = 0;
        String color = "";
        int nodoNeutral = 0;
        for (int i = 0; i < misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().size(); i++) {
            Planetas planetaAux = misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().get(i);
            if (planetaAux.getNombre().equals(planetaAtacante)) {
                color = misDatos.getJugadores().get(jugadorAtacante).getColor();
                break;
            }
        }
        for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
            PlanetasNeutrales neutralAux = misDatos.getpNeutrales().get(i);
            if (neutralAux.getNombre().equals(planetaAtacado)) {
                nodoNeutral = i;
                posX = Integer.parseInt(neutralAux.getPosicionX());
                posY = Integer.parseInt(neutralAux.getPosicionY());
                break;
            }
        }

        String[] colores = color.split(",");
        int[] convertidos = new int[colores.length];
        for (int i = 0; i < colores.length; i++) {
            convertidos[i] = Integer.parseInt(colores[i]);
        }
        VentanaPrincipal.tablero[posY][posX].setBackground(new Color(convertidos[0], convertidos[1], convertidos[2], convertidos[3]));
        Planetas nuevo = new Planetas();
        traspasarDatosNeutral(misDatos.getpNeutrales().get(nodoNeutral), nuevo);
        misDatos.getJugadores().get(jugadorAtacante).getMisPlanetas().add(nuevo);
        misDatos.getpNeutrales().remove(nodoNeutral);
        JOptionPane.showMessageDialog(null, "Planeta Neutral: " + planetaAtacado + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorAtacante).getNombre());
}

    public Planetas traspasarDatosNeutral(PlanetasNeutrales encontrado, Planetas nuevo){
        nuevo.setNombre(encontrado.getNombre());
        nuevo.setInterruptor(encontrado.isInterruptor());
        nuevo.setNaves(encontrado.getNaves());
        nuevo.setPorcentajeMuertes(encontrado.getPorcentajeMuertes());
        nuevo.setPosicionX(encontrado.getPosicionX());
        nuevo.setPosicionY(encontrado.getPosicionY());
        nuevo.setProduccion(encontrado.getProduccion());
        return nuevo;
    }
    
    public void eliminarFlotaAtacante(ArrayList<NavesCamino> listNaves, int nodoFlota) {
        System.out.println("-----------------------------------------------------");
        System.out.println(nodoFlota+"supuesto nodo a ser eliminado");
        listNaves.remove(nodoFlota);
        System.out.println(listNaves.size()+"aqui se ELIMINA");
    }

}
