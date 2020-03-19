package mapa;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import interfaz.VentanaPrincipal;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luisGonzalez
 */
public class Jugabilidad {

    private int turnos = 0;
    private boolean evento = false;
    private int interruptor = 0;
    private int jugadorPlaneta = 0;
    private int noPlaneta = 0;

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

    public void accionesSegundoClick(Juego juego, int x, int y, JTextField txtNaves, int nodoJalar, ArrayList<NavesCamino> navesCamino, JButton btnTurno) {
        interruptor = 0;
        jugadorPlaneta = 0;
        noPlaneta = 0;
        Planetas aux2 = new Planetas();
        int contador = VentanaPrincipal.contador;
        System.out.println(nodoJalar + " soy el nodo a jalar   " + contador + "   y yo soy el numero de jugador donde esta");
        for (int i = 0; i < juego.getJugadores().size(); i++) {
            for (int j = 0; j < juego.getJugadores().get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(juego.getJugadores().get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(juego.getJugadores().get(i).getMisPlanetas().get(j).getPosicionY());
                if (posX == x && posY == y && i != contador) {
                    aux2 = juego.getJugadores().get(i).getMisPlanetas().get(j);
                    interruptor = 1;
                    jugadorPlaneta = i;
                    noPlaneta = j;
                    break;
                }
            }
        }
        if (interruptor == 0) {
            for (int i = 0; i < juego.getpNeutrales().size(); i++) {
                int posX = Integer.parseInt(juego.getpNeutrales().get(i).getPosicionX());
                int posY = Integer.parseInt(juego.getpNeutrales().get(i).getPosicionY());
                if (posX == x && posY == y) {
                    interruptor = 2;
                    noPlaneta = i;
                    break;
                }
            }
        }
        if (interruptor > 0) {
            txtNaves.setEditable(true);
            txtNaves.setEnabled(true);
            txtNaves.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        boolean funciona = false;
                        if (!txtNaves.getText().equals("")) {
                            funciona = envioNaves(txtNaves, nodoJalar, juego, navesCamino, interruptor, jugadorPlaneta, noPlaneta, btnTurno);
                            CreacionMapa.contClicks = 0;
                        } else {
                            JOptionPane.showMessageDialog(null, "Te falta enviar naves al destino");
                        }
                        if (funciona == true) {
                            txtNaves.removeKeyListener(this);
                        }
                    }
                }

            });
        } else {
            CreacionMapa.contClicks--;
        }
    }

    public boolean envioNaves(JTextField txtNaves, int nodoJalar, Juego misDatos, ArrayList<NavesCamino> navesCamino, int interruptor, int jugador, int noPlaneta, JButton btnTurno) {
        boolean funciona = false;
        int navesEnvio = Integer.parseInt(txtNaves.getText());
        int contador = VentanaPrincipal.contador;
        int navesTotales = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getNaves());
        if (navesEnvio > navesTotales) {
            funciona = false;
        } else {
            int nuevasNaves = navesTotales - navesEnvio;
            misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).setNaves(Integer.toString(nuevasNaves));
            int pitagoras = 0;
            if (interruptor == 1) {
                pitagoras = distanciaPlanetaPlaneta(nodoJalar, jugador, noPlaneta, misDatos, pitagoras);
                int turno = VentanaPrincipal.contadorTurnos + pitagoras;
                System.out.println("El turno en que llegaria seria en el numero: " + turno);
                NavesCamino camino = new NavesCamino();
                String planeta1 = misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(nodoJalar).getNombre();
                String planeta2 = misDatos.getJugadores().get(jugador).getMisPlanetas().get(noPlaneta).getNombre();
                float porcentajeMuertes = Float.parseFloat(misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(nodoJalar).getPorcentajeMuertes());
                camino = seteoNavesCamino(nodoJalar, misDatos, camino, navesCamino, navesEnvio, jugador, planeta1, planeta2, porcentajeMuertes, turno);
                navesCamino.add(camino);
            } else if (interruptor == 2) {
                pitagoras = distanciaPlanetaANeutral(nodoJalar, noPlaneta, misDatos, pitagoras);
                int turno = VentanaPrincipal.contadorTurnos + pitagoras;
                float porcentajeMuertes = Float.parseFloat(misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(nodoJalar).getPorcentajeMuertes());
                System.out.println("NEUTRAL: El turno en que llegaria seria en el numero: " + turno);
                String planeta1 = misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(nodoJalar).getNombre();
                String planeta2 = misDatos.getpNeutrales().get(noPlaneta).getNombre();
                NavesCamino camino = new NavesCamino();
                camino = seteoNavesCamino(nodoJalar, misDatos, camino, navesCamino, navesEnvio, null, planeta1, planeta2, porcentajeMuertes, turno);
                navesCamino.add(camino);
            }
            funciona = true;
            txtNaves.setEnabled(false);
            txtNaves.setText("");
            btnTurno.setEnabled(true);
        }
        return funciona;
    }

    public int distanciaPlanetaPlaneta(int nodoJalar, int jugador, int nodoPlaneta, Juego misDatos, int pitagoras) {
        int contador = VentanaPrincipal.contador;
        int posX1 = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getPosicionX());
        int posY1 = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getPosicionY());
        int posX2 = Integer.parseInt(misDatos.getJugadores().get(jugador).getMisPlanetas().get(nodoPlaneta).getPosicionX());
        int posY2 = Integer.parseInt(misDatos.getJugadores().get(jugador).getMisPlanetas().get(nodoPlaneta).getPosicionY());
        int posX3 = 0;
        int posY3 = 0;
        if (posX2 >= posX1) {
            posX3 = posX2 - posX1;
        } else {
            posX3 = posX1 - posX2;
        }
        if (posY2 >= posY1) {
            posY3 = posY2 - posY1;
        } else {
            posY3 = posY1 - posY2;
        }
        int pitagoras2 = (int) Math.pow(posX3, 2) + (int) Math.pow(posY3, 2);
        pitagoras = (int) Math.sqrt(pitagoras2);
        return pitagoras;
    }

    public int distanciaPlanetaANeutral(int nodoJalar, int nodoPlaneta, Juego misDatos, int pitagoras) {
        int contador = VentanaPrincipal.contador;
        int posX1 = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getPosicionX());
        int posY1 = Integer.parseInt(misDatos.getJugadores().get(contador).getMisPlanetas().get(nodoJalar).getPosicionY());
        int posX2 = Integer.parseInt(misDatos.getpNeutrales().get(nodoPlaneta).getPosicionX());
        int posY2 = Integer.parseInt(misDatos.getpNeutrales().get(nodoPlaneta).getPosicionY());
        int posX3 = 0;
        int posY3 = 0;
        if (posX2 >= posX1) {
            posX3 = posX2 - posX1;
        } else {
            posX3 = posX1 - posX2;
        }
        if (posY2 >= posY1) {
            posY3 = posY2 - posY1;
        } else {
            posY3 = posY1 - posY2;
        }
        int pitagoras2 = (int) Math.pow(posX3, 2) + (int) Math.pow(posY3, 2);
        pitagoras = (int) Math.sqrt(pitagoras2);
        return pitagoras;
    }

    public NavesCamino seteoNavesCamino(int nodoJalar, Juego misDatos, NavesCamino navesCamino, ArrayList<NavesCamino> listNaves, int navesEnvio, Integer jugadorAtaque, String planeta1, String planeta2, float porcentajeMuertes, int turno) {
        int contador = 0;
        if (!listNaves.isEmpty()) {
            String planeta = misDatos.getJugadores().get(VentanaPrincipal.contador).getMisPlanetas().get(nodoJalar).getNombre();
            for (int j = 0; j < listNaves.size(); j++) {
                if (listNaves.get(j).getPlanetaOrigen().equals(planeta)) {
                    System.out.println(planeta + " soy el planeta");
                    System.out.println(listNaves.get(j).getPlanetaOrigen() + "  planeta 2");
                    contador++;
                }
            }

        }
        navesCamino.setNoFlota(contador + 1);
        navesCamino.setNoJugadorEnvio(VentanaPrincipal.contador);
        navesCamino.setNoNaves(navesEnvio);
        navesCamino.setNoJugadorAtaque(jugadorAtaque);
        navesCamino.setPlanetaDestino(planeta2);
        navesCamino.setPlanetaOrigen(planeta1);
        navesCamino.setPorcentajeMuertes(porcentajeMuertes);
        navesCamino.setTurnoLlegada(turno);
        navesCamino.setVerificador(false);
        return navesCamino;
    }

    public void verificacionNavesLlegada(ArrayList<NavesCamino> listNaves, Juego misDatos, JTextArea panelMensajes) {
        int cont = 0;
        for (int i = 0; i < listNaves.size(); i++) {
            cont++;
            if (listNaves.get(i).getNoJugadorAtaque() != null && listNaves.get(i).getVerificador() == false) {
                if (listNaves.get(i).getTurnoLlegada() == VentanaPrincipal.contadorTurnos) {
                    System.out.println("ENCONTRADO");
                    //nuevo
                    int totalNavesAtacante = listNaves.get(i).getNoNaves();
                    float porcMuerteAtacante = listNaves.get(i).getPorcentajeMuertes();

                    int jugadorAtaque = listNaves.get(i).getNoJugadorAtaque();
                    int jugadorEnvio = listNaves.get(i).getNoJugadorEnvio();
                    String planetaAtaque = listNaves.get(i).getPlanetaDestino();
                    int noPlaneta = 0;
                    float porMuerteAtacado = 0;
                    int navesPlanetaAtacado = 0;
                    for (int j = 0; j < misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().size(); j++) {
                        String nombreAux = misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(j).getNombre();
                        if (planetaAtaque.equals(nombreAux)) {
                            noPlaneta = j;
                            porMuerteAtacado = Float.parseFloat(misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(j).getPorcentajeMuertes());
                            navesPlanetaAtacado = Integer.parseInt(misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(j).getNaves());
                            break;
                        }
                    }

                    int navesAtacanteDestruidas = (int) (totalNavesAtacante * porMuerteAtacado);
                    int navesAtacanteLlegada = totalNavesAtacante - navesAtacanteDestruidas;
                    int navesDefensaDestruidas = (int) (navesPlanetaAtacado * porcMuerteAtacante);
                    int totalNavesDefensa = navesPlanetaAtacado - navesDefensaDestruidas;
                    
                    if (totalNavesDefensa <= navesAtacanteLlegada) {
                        Planetas aux = misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(noPlaneta);

                        aux.setColor(misDatos.getJugadores().get(jugadorEnvio).getColor());
                        String[] color = aux.getColor().split(",");
                        int[] colores = new int[color.length];
                        for (int j = 0; j < colores.length; j++) {
                            colores[j] = Integer.parseInt(color[j]);
                        }
                        VentanaPrincipal.tablero[Integer.parseInt(aux.getPosicionY())][Integer.parseInt(aux.getPosicionX())].setBackground(new Color(255, 255, 255, 100));
                        VentanaPrincipal.tablero[Integer.parseInt(aux.getPosicionY())][Integer.parseInt(aux.getPosicionX())].setBackground(new Color(colores[0], colores[1], colores[2], colores[3]));
                        removerPlaneta(misDatos, jugadorAtaque, planetaAtaque);
                        misDatos.getJugadores().get(jugadorEnvio).getMisPlanetas().add(aux);

                        if (misDatos.getJugadores().get(jugadorEnvio).getPlanetasConquistados() == 0) {
                            misDatos.getJugadores().get(jugadorEnvio).setPlanetasConquistados(1);
                        } else {
                            int planetasConquistados = misDatos.getJugadores().get(jugadorEnvio).getPlanetasConquistados();
                            int nuevoValor = planetasConquistados + 1;
                            misDatos.getJugadores().get(jugadorEnvio).setPlanetasConquistados(nuevoValor);
                        }

                        JOptionPane.showMessageDialog(null, "Planeta: " + planetaAtaque + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorEnvio).getNombre());

                        String texto = panelMensajes.getText();
                        String mensaje = texto + "    Planeta: " + planetaAtaque + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorEnvio).getNombre() + "\n";
                        panelMensajes.setText(mensaje);
                        //Verifica si existen planetas aun dentro del jugador que fue atacado    
                        verificadorExistenciaPlanetas(misDatos, jugadorAtaque);

                    } else {
                        misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(noPlaneta).setNaves(Integer.toString(totalNavesDefensa));
                        JOptionPane.showMessageDialog(null, "Planeta: " + planetaAtaque + " ha bloqueado un ataque proveniente del planeta: " + listNaves.get(i).getPlanetaOrigen());
                        String texto = panelMensajes.getText();
                        String mensaje = texto + "    Planeta: " + planetaAtaque + " ha bloqueado un ataque proveniente del planeta: " + listNaves.get(i).getPlanetaOrigen() + "\n";
                        panelMensajes.setText(mensaje);
                    }
                    listNaves.get(i).setVerificador(true);
                }
            } else {
                verificacionesAtaqueNeutral(i, listNaves, misDatos, panelMensajes);
            }
        }
        for (int i = 0; i < listNaves.size(); i++) {
            if (listNaves.get(i).getVerificador()) {
                listNaves.remove(i);
                i--;
            }
        }
    }

    public void removerPlaneta(Juego misDatos, int jugadorAtaque, String planetaAtacado) {
        int nodo = 0;
        for (int i = 0; i < misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().size(); i++) {
            String planetaAux = misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(i).getNombre();
            if (planetaAux.equals(planetaAtacado)) {
                nodo = i;
                break;
            }
        }
        misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().remove(misDatos.getJugadores().get(jugadorAtaque).getMisPlanetas().get(nodo));
    }

    public void verificacionesAtaqueNeutral(int i, ArrayList<NavesCamino> listNaves, Juego misDatos, JTextArea panelMensajes) {
        if (listNaves.get(i).getTurnoLlegada() == VentanaPrincipal.contadorTurnos) {
            int jugadorEnvio = listNaves.get(i).getNoJugadorEnvio();
            
            
            int navesAtacante = listNaves.get(i).getNoNaves();
            float porcMuerteAtacante = listNaves.get(i).getPorcentajeMuertes();
            
            
            
            
            String planetaAtaque = listNaves.get(i).getPlanetaDestino();
            int planetaNeutral = 0;
            float porcMuertesNeutral = 0;
            int navesNeutral = 0;
            for (int j = 0; j < misDatos.getpNeutrales().size(); j++) {
                String planetaAux = misDatos.getpNeutrales().get(j).getNombre();
                if (planetaAux.equals(planetaAtaque)) {
                    planetaNeutral = j;
                    porcMuertesNeutral = Float.parseFloat(misDatos.getpNeutrales().get(j).getPorcentajeMuertes());
                    navesNeutral = Integer.parseInt(misDatos.getpNeutrales().get(j).getNaves());
                    break;
                }
            }
            
            
            
            int navesAtacanteDestruidas = (int) (navesAtacante * porcMuertesNeutral);
            int totalNavesLlegada = navesAtacante - navesAtacanteDestruidas;
            int navesDefensaDestruidas = (int) (navesNeutral * porcMuerteAtacante);
            int navesDefensa = navesNeutral - navesDefensaDestruidas;
            
            
            
                if (navesDefensa <= totalNavesLlegada) {
                    Planetas planetas = new Planetas();
                    planetas.setNombre(misDatos.getpNeutrales().get(planetaNeutral).getNombre());
                    planetas.setNaves(misDatos.getpNeutrales().get(planetaNeutral).getNaves());
                    planetas.setColor(misDatos.getJugadores().get(jugadorEnvio).getColor());
                    planetas.setInterruptor(misDatos.getpNeutrales().get(planetaNeutral).isInterruptor());
                    planetas.setPorcentajeMuertes(misDatos.getpNeutrales().get(planetaNeutral).getPorcentajeMuertes());
                    planetas.setPosicionX(misDatos.getpNeutrales().get(planetaNeutral).getPosicionX());
                    planetas.setPosicionY(misDatos.getpNeutrales().get(planetaNeutral).getPosicionY());
                    planetas.setProduccion(misDatos.getpNeutrales().get(planetaNeutral).getProduccion());
                    misDatos.getJugadores().get(jugadorEnvio).getMisPlanetas().add(planetas);
                    misDatos.getpNeutrales().remove(planetaNeutral);
                    String[] color = planetas.getColor().split(",");
                    int[] colores = new int[color.length];
                    for (int j = 0; j < colores.length; j++) {
                        colores[i] = Integer.parseInt(color[i]);
                    }
                    if (misDatos.getJugadores().get(jugadorEnvio).getPlanetasConquistados() == 0) {
                        misDatos.getJugadores().get(jugadorEnvio).setPlanetasConquistados(1);
                    } else {
                        int planetasConquistados = misDatos.getJugadores().get(jugadorEnvio).getPlanetasConquistados();
                        int nuevoValor = planetasConquistados + 1;
                        misDatos.getJugadores().get(jugadorEnvio).setPlanetasConquistados(nuevoValor);
                    }
                    VentanaPrincipal.tablero[Integer.parseInt(planetas.getPosicionY())][Integer.parseInt(planetas.getPosicionX())].setBackground(new Color(255, 255, 255, 100));
                    VentanaPrincipal.tablero[Integer.parseInt(planetas.getPosicionY())][Integer.parseInt(planetas.getPosicionX())].setBackground(new Color(colores[0], colores[1], colores[2], colores[3]));
                    JOptionPane.showMessageDialog(null, "Planeta Neutral: " + planetaAtaque + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorEnvio).getNombre());
                    String texto = panelMensajes.getText();
                    String mensaje = texto + "    Planeta Neutral: " + planetaAtaque + " ha sido conquistado por " + misDatos.getJugadores().get(jugadorEnvio).getNombre() + "\n";
                    panelMensajes.setText(mensaje);
                } else {
                    misDatos.getpNeutrales().get(planetaNeutral).setNaves(Integer.toString(navesDefensa));
                    JOptionPane.showMessageDialog(null, "Planeta Neutral: " + planetaAtaque + " ha bloqueado un ataque proveniente del planeta: " + listNaves.get(i).getPlanetaOrigen());
                    String texto = panelMensajes.getText();
                    String mensaje = texto + "    Planeta Neutral: " + planetaAtaque + " ha bloqueado un ataque proveniente del planeta: " + listNaves.get(i).getPlanetaOrigen() + "\n";
                    panelMensajes.setText(mensaje);
                }
            listNaves.get(i).setVerificador(true);

        }

    }

    public void verificadorExistenciaPlanetas(Juego misDatos, int noJugador) {
        int totalPlanetas = misDatos.getJugadores().get(noJugador).getMisPlanetas().size();
        
        if(misDatos.getJugadores().get(noJugador).getMisPlanetas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Este planeta ha sido eliminado");
            misDatos.getJugadores().get(noJugador).setEnJuego("false");
            
        }
        
        
    }

}
