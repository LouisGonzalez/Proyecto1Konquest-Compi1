package mapa;

import Pollitos.Juego;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import javax.swing.JLabel;

/**
 *
 * @author luisGonzalez
 */
public class MensajesEmergentes {

    public void datosPlanetas(JLabel[][] matrizJuego, int posX, int posY, Juego misDatos) {
        int noJugador = 0;
        int noPlaneta = 0;
        boolean encontrado = false;
        boolean encontrado2 = false;
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX2 = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY2 = Integer.parseInt(misDatos.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if (posX == posX2 && posY == posY2) {
                    noJugador = i;
                    noPlaneta = j;
                    encontrado = true;
                    break;
                }
            }
        }
        if (encontrado == false) {
            for (int i = 0; i < misDatos.getpNeutrales().size(); i++) {
                int posX2 = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionX());
                int posY2 = Integer.parseInt(misDatos.getpNeutrales().get(i).getPosicionY());
                if (posX == posX2 && posY == posY2) {
                    encontrado2 = true;
                    noPlaneta = i;
                    break;
                }
            }
        }
        if (encontrado == true) {
            Planetas aux = misDatos.getJugadores().get(noJugador).getMisPlanetas().get(noPlaneta);
            String texto = "<html>"
                    + "<head>"
                    + ""
                    + "</head>"
                    + "<body>"
                    + "<div id='contenido'>"
                    + "Planeta: " + aux.getNombre() + "<br>"
                    + "No Naves: " + aux.getNaves() + "<br>"
                    + "Produccion: " + aux.getProduccion() + "<br>"
                    + "Porc. Muertes: " + aux.getPorcentajeMuertes() + "<br>"
                    + "Posicion X: " + aux.getPosicionX() + "<br>"
                    + "Posicion Y: " + aux.getPosicionY() + "<br>"
                    + "Poseedor: " + misDatos.getJugadores().get(noJugador).getNombre() + "<br>"
                    + "Tipo: " + misDatos.getJugadores().get(noJugador).getTipo() + ""
                    + "</div>"
                    + "</body>"
                    + "</html>";
            matrizJuego[posY][posX].setToolTipText(texto);
        } else if (encontrado2 == true) {
            PlanetasNeutrales neutral = misDatos.getpNeutrales().get(noPlaneta);
            matrizJuego[posY][posX].setToolTipText("Planeta: " + neutral.getNombre());
            String texto = "<html>"
                    + "<head>"
                    + ""
                    + "</head>"
                    + "<body>"
                    + "<div id='contenido'>"
                    + "Planeta: "+neutral.getNombre() + "<br>";
                 
            if(misDatos.getMapa().getMapaPNeutral().getMostrarNaves().equals("true")){
                texto += "Naves: " +neutral.getNaves() + "<br>";
            }
            if(misDatos.getMapa().getMapaPNeutral().getMostrarEstadisticas().equals("true")){
                texto += "Produccion: " + neutral.getProduccion() + "<br>"
                        + "Por. Muertes: " + neutral.getPorcentajeMuertes() + "<br>"
                        + "Posicion X: " + neutral.getPosicionX() + "<br>"
                        + "Posicion Y: " + neutral.getPosicionY() + "<br>";
            }
            texto += "</div>"
                    + "</body>"
                    + "</html>";
            matrizJuego[posY][posX].setToolTipText(texto);
        }
    }

}
