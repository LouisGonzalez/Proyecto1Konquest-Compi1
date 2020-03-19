package mapa;

import Pollitos.Auxiliar;
import Pollitos.Juego;
import Pollitos.Resultados;
import interfaz.EstadisticasFinales;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author luisGonzalez
 */
public class CondicionesIniciales {

    public void aumentoProduccion(Juego misDatos) {
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            if (misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                    int produccion = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getProduccion());
                    int naves = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNaves());
                    int nuevaProduccion = naves + produccion;
                    misDatos.getJugadores().get(i).getMisPlanetas().get(j).setNaves(Integer.toString(nuevaProduccion));
                }
            }
        }
        for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
            int produccion = Integer.parseInt(misDatos.getpNeutrales().get(i).getProduccion());
            int naves = Integer.parseInt(misDatos.getpNeutrales().get(i).getNaves());
            int nuevaProduccion = naves + produccion;
            misDatos.getpNeutrales().get(i).setNaves(Integer.toString(nuevaProduccion));
        }
    }

    public void aumentoProduccionEn1(Juego misDatos) {
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            if (misDatos.getJugadores().get(i).getEnJuego().equals("true")) {
                for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                    int naves = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNaves());
                    int nuevaProduccion = naves + 1;
                    misDatos.getJugadores().get(i).getMisPlanetas().get(j).setNaves(Integer.toString(nuevaProduccion));
                }
            }
        }
        for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
            int naves = Integer.parseInt(misDatos.getpNeutrales().get(i).getNaves());
            int nuevaProduccion = naves + 1;
            misDatos.getpNeutrales().get(i).setNaves(Integer.toString(nuevaProduccion));
        }
    }

    public void verificarGanador(Juego misDatos, JPanel panelJuego, ArrayList<Resultados> finales) {
        int finalizacion = Integer.parseInt(misDatos.getMapa().getFinalizacion());
        if (finalizacion > 0) {

            ArrayList<Auxiliar> aux = new ArrayList<>();

            if (VentanaPrincipal.contadorTurnos == finalizacion) {
                for (int i = 0; i < misDatos.getJugadores().size(); i++) {
                    Auxiliar nodo = new Auxiliar();
                    nodo.setNoJugador(i);
                    nodo.setNoPlanetas(misDatos.getJugadores().get(i).getMisPlanetas().size());
                    aux.add(nodo);

                }
                ordenamientoArray(aux);

                agregarResultadosFinales(finales, aux, misDatos);
                panelJuego.removeAll();
                panelJuego.setVisible(false);
                EstadisticasFinales resultados = new EstadisticasFinales(null, true, finales);
                resultados.setVisible(true);
            }

        } else {
            verificacionSinFinalizacion(misDatos, panelJuego, finales);
        }
    }

    public void verificacionSinFinalizacion(Juego misDatos, JPanel panelJuego, ArrayList<Resultados> finales) {
        ArrayList<Auxiliar> aux = new ArrayList<>();
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            Auxiliar nodo = new Auxiliar();
            int totalPlanetas = misDatos.getJugadores().get(i).getMisPlanetas().size();
            nodo.setNoJugador(i);
            nodo.setNoPlanetas(totalPlanetas);
            aux.add(nodo);
        }
        ordenamientoArray(aux);

        boolean vencido = true;

        for (int i = 0; i < aux.size() - 1; i++) {
            if (aux.get(i).getNoPlanetas() > 0) {
                vencido = false;
                break;
            }
        }
        if (vencido == true && aux.get(aux.size() - 1).getNoPlanetas() > 0) {
            JOptionPane.showMessageDialog(null, "Has ganado :D");
            agregarResultadosFinales(finales, aux, misDatos);
            panelJuego.removeAll();
            panelJuego.setVisible(false);

            EstadisticasFinales resultados = new EstadisticasFinales(null, true, finales);
            resultados.setVisible(true);
        }

    }

    public void ordenamientoArray(ArrayList<Auxiliar> aux) {
        int minimo = 0;
        for (int i = 0; i < aux.size() - 1; i++) {
            minimo = i;
            for (int j = i + 1; j < aux.size(); j++) {
                if (aux.get(j).getNoPlanetas() < aux.get(minimo).getNoPlanetas()) {
                    minimo = j;
                }
            }
            if (i != minimo) {
                Auxiliar nodo = aux.get(i);
                aux.set(i, aux.get(minimo));
                aux.set(minimo, nodo);
            }
        }
        for (int i = 0; i < aux.size(); i++) {
            System.out.println(aux.get(i).getNoPlanetas() + "sfdsfsd");
        }
    }

    public void agregarResultadosFinales(ArrayList<Resultados> finales, ArrayList<Auxiliar> aux, Juego misDatos) {
        for (int i = 0; i < aux.size(); i++) {
            Resultados resultado = new Resultados();
            resultado.setJugador(misDatos.getJugadores().get(aux.get(i).getNoJugador()).getNombre());
            resultado.setTotalPlanetas(aux.get(i).getNoPlanetas());
            resultado.setPlanetasConquistados(misDatos.getJugadores().get(aux.get(i).getNoJugador()).getPlanetasConquistados());
            finales.add(resultado);
        }

    }

}
