package mapa;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.Planetas;
import interfaz.VentanaPrincipal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luisGonzalez
 */
public class Jugabilidad {

    public int turnos = 0;

    public void circulacionTurnos(ArrayList<Jugadores> jugadores, Mapa mapita) {
        if (Integer.parseInt(mapita.getFinalizacion()) > 0) {
            while (turnos <= Integer.parseInt(mapita.getFinalizacion())) {
                for (int i = 0; i < jugadores.size(); i++) {
                    boolean acaboTurno;
                    if (!jugadores.get(i).getMisPlanetas().isEmpty()) {

                    }
                }
            }
        } else {

        }
    }

    public int accionesPrimerClick(Juego juego, int x, int y) {
        boolean encontrado = false;
        Planetas aux = new Planetas();
        int nodo = 0;
        int contador = VentanaPrincipal.contador;
        for (int i = 0; i < juego.getJugadores().get(contador).getMisPlanetas().size(); i++) {
            int posX = Integer.parseInt(juego.getJugadores().get(contador).getMisPlanetas().get(i).getPosicionX());
            int posY = Integer.parseInt(juego.getJugadores().get(contador).getMisPlanetas().get(i).getPosicionY());
            if (posX == x && posY == y) {
                encontrado = true;
                nodo = i;
                aux = juego.getJugadores().get(contador).getMisPlanetas().get(i);
                break;
            }
        }
        if (encontrado == false) {
            CreacionMapa.contClicks--;
            System.out.println(CreacionMapa.contClicks + "contador");
        } else {
            System.out.println("elegido");
        }
        return nodo;
    }

    public void accionesSegundoClick(Juego juego, int x, int y, JTextField txtNaves, int nodoJalar) {
        Planetas aux2 = new Planetas();
        int contador = VentanaPrincipal.contador;
        System.out.println(nodoJalar+" soy el nodo a jalar   "+contador+"   y yo soy el numero de jugador donde esta");
        boolean encontrado = false;
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            for (int j = 0; j < juego.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(juego.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(juego.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if (posX == x && posY == y && i != contador) {
                    aux2 = juego.getJugadores().get(i).getMisPlanetas().get(j);
                    encontrado = true;
                    break;
                }
            }
        }
        for (int i = 0; i < juego.getpNeutrales().size(); i++) {
            int posX = Integer.parseInt(juego.getpNeutrales().get(i).getPosicionX());
            int posY = Integer.parseInt(juego.getpNeutrales().get(i).getPosicionY());
            if (posX == x && posY == y) {
                encontrado = true;
                break;
            }
        }
        if (encontrado == true) {
            txtNaves.setEditable(true);
            txtNaves.setEnabled(true);
            txtNaves.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (!txtNaves.getText().equals("")) {
                            envioNaves(txtNaves, nodoJalar, juego);
                        
                        } else {
                            JOptionPane.showMessageDialog(null, "Te falta enviar naves al destino");
                        }
                    }
                }
            });
        } else {
            CreacionMapa.contClicks--;
        }
    }

    public void envioNaves(JTextField txtNaves, int nodoJalar, Juego misDatos) {
        int navesEnvio = Integer.parseInt(txtNaves.getText());
        int contador = VentanaPrincipal.contador;
        int navesTotales = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getNaves());
        System.out.println(navesTotales+" estes es el que sigue viniendo");
        if(navesEnvio > navesTotales){
        } else {
            int nuevasNaves = navesTotales - navesEnvio;
            System.out.println(nuevasNaves+" este deberia ser el nuevo valor");
            misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).setNaves(Integer.toString(nuevasNaves));
            txtNaves.setEnabled(false);
   
        }
    }

}
