/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replay;

import Pollitos.Impactos;
import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.Replay;
import Pollitos.ResumenTurno;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class AccionesTurno {

    private final AccionesImpacto impacto = new AccionesImpacto();
    private final AccionesFlotas flotas = new AccionesFlotas();
    private final AccionesResumen resumen = new AccionesResumen();

    public void lanzamientoFlotas(JLabel lblTurno, ArrayList<Replay> listReplay, Juego misDatos, ArrayList<NavesCamino> listNaves) {
        for (int i = listReplay.size() - 1; i >= 0; i--) {
            VentanaPrincipal.contadorTurnos = listReplay.get(i).getNoTurno();
            lblTurno.setText("Turno: " + VentanaPrincipal.contadorTurnos);
            aumentoProduccion(misDatos);
            for (int j = listReplay.get(i).getListAcciones().size() - 1; j >=0 ; j--) {
                String nombreJugador = listReplay.get(i).getListAcciones().get(j).getNombreJugador();
                Integer nodoJugador = impacto.busquedaJugador(misDatos, nombreJugador);
                for (int k = listReplay.get(i).getListAcciones().get(j).getListNaves().size() - 1; k >= 0; k--) {
                    NavesCamino navesAux = listReplay.get(i).getListAcciones().get(j).getListNaves().get(k);
                    flotas.restarNavesPlaneta(misDatos, nodoJugador, navesAux.getPlanetaOrigen(), navesAux.getNoNaves());
                    flotas.agregarFlotas(listNaves, navesAux);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccionesImpacto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            
            
            
            
            
            
            for (int j = 0; j < listReplay.get(i).getListImpactos().size(); j++) {

                String nombreJugador = listReplay.get(i).getListImpactos().get(j).getNombreJugador();

                Integer nodoJugador;
                if (!nombreJugador.equals("NEUTRAL")) {
                    nodoJugador = impacto.busquedaJugador(misDatos, nombreJugador);
                } else {
                    nodoJugador = null;
                }

                for (int k = 0; k < listReplay.get(i).getListImpactos().get(j).getListImpactos().size(); k++) {
                    Impactos impactoAux = listReplay.get(i).getListImpactos().get(j).getListImpactos().get(k);
                    String planetaAux = impactoAux.getNombrePlaneta();
                    System.out.println(planetaAux);
                    Integer nodoPlaneta;
                    if (nodoJugador == null) {
                        nodoPlaneta = impacto.busquedaPlanetaNeutral(misDatos, planetaAux);
                        impacto.restarNavesNeutral(misDatos, nodoPlaneta, impactoAux.getNavesRestantes());
                    } else {
                        nodoPlaneta = impacto.busquedaPlaneta(misDatos, planetaAux, nodoJugador);
                        impacto.restarNavesPlaneta(misDatos, nodoJugador, nodoPlaneta, impactoAux.getNavesRestantes());
                    }
                    if (impactoAux.getEstado().equals("VIVO")) {
                        JOptionPane.showMessageDialog(null, "Planeta " + planetaAux + " ha sido atacado por " + impactoAux.getPlanetaAtacante());
                    } else {
                        if (nodoJugador == null) {
                            impacto.destruirNeutral(misDatos, impactoAux.getJugadorAtacante(), impactoAux.getPlanetaAtacante(), planetaAux);

                        } else {
                            impacto.destruirPlaneta(misDatos, impactoAux.getJugadorAtacante(), nodoJugador, impactoAux.getPlanetaAtacante(), planetaAux);
                        }
                    }
                    impacto.eliminarFlotaAtacante(listNaves, impactoAux.getNoFlota());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccionesImpacto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            for (int j = listReplay.get(i).getListResumen().size() - 1; j >= 0; j--) {
                ResumenTurno aux = listReplay.get(i).getListResumen().get(j);
                resumen.verificarEstadoJugadores(misDatos, aux);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AccionesImpacto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public void aumentoProduccion(Juego misDatos) {
        if (misDatos.getMapa().getAcumular().equals("false")) {
            for (int i = 0; i < misDatos.getJugadores().size(); i++) {
                if (misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                    for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                        int produccion = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getProduccion());
                        int noNaves = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNaves());
                        int nuevasNaves = noNaves + produccion;
                        misDatos.getJugadores().get(i).getMisPlanetas().get(j).setNaves(Integer.toString(nuevasNaves));
                    }
                }
            }
        } else {
            for (int i = 0; i < misDatos.getJugadores().size(); i++) {
                if (misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                    for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                        int noNaves = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNaves());
                        int nuevasNaves = noNaves + 1;
                        misDatos.getJugadores().get(i).getMisPlanetas().get(j).setNaves(Integer.toString(nuevasNaves));
                    }
                }
            }

        }
    }

}
