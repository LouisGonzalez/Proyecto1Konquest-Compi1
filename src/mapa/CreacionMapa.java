package mapa;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import interfaz.InformacionPlaneta;
import interfaz.VentanaPrincipal;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.SystemColor.menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author luisGonzalez
 */
public class CreacionMapa {

    public JPanel panelFondo;
    private MensajesEmergentes mensaje = new MensajesEmergentes();
    private MedicionDistancias distancias = new MedicionDistancias();
    public static int contClicks = 0;
    public int nodoJalar = 0;
    InformacionPlaneta info = new InformacionPlaneta(null, true);
    private Jugabilidad jugabilidad;
    private Integer[] nodosJalar = new Integer[3];

    public CreacionMapa(JPanel panelFondo, Jugabilidad jugabilidad) {
        this.panelFondo = panelFondo;
        this.jugabilidad = jugabilidad;
    }

    public void creacionCuadricula(Juego misDatos, JTextField txtNaves, int contador, ArrayList<NavesCamino> navesCamino, JButton btnTurno, JButton btnDistancia, JButton btnFlotas) {
        int filas = Integer.parseInt(misDatos.getMapa().getSize_filas());
        int columnas = Integer.parseInt(misDatos.getMapa().getSize_columnas());
        VentanaPrincipal.tablero = new JLabel[filas][columnas];
        panelFondo.setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int posX = j;
                int posY = i;
                JLabel matriz = new JLabel();
                posicionPlanetas(misDatos.getJugadores(), i, j, matriz, filas, columnas, misDatos.getpNeutrales());
                VentanaPrincipal.tablero[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        contClicks++;
                        if (btnDistancia.isEnabled() == false) {
                            if ((VentanaPrincipal.clicksDistancia % 2 != 0)) {
                                nodosJalar = distancias.verificarExistenciaPlaneta(misDatos, posX, posY);
                            } else {
                                distancias.verificarExistenciaPlaneta2(misDatos, posX, posY, nodosJalar, btnDistancia, btnFlotas);
                            }
                        } else {
                            if (contClicks % 2 != 0) {
                                nodoJalar = jugabilidad.accionesPrimerClick(misDatos, posX, posY);
                            } else {
                                jugabilidad.accionesSegundoClick(misDatos, posX, posY, txtNaves, nodoJalar, navesCamino, btnTurno);
                            }
                        }
                        // jugabilidad.seleccionarPlanetaOrigen(posX, posY, misDatos, txtNaves);
                    }

                    @Override
                    public void mouseEntered(MouseEvent event) {
                        VentanaPrincipal.tablero[posY][posX].setToolTipText("            ");
                        mensaje.datosPlanetas(VentanaPrincipal.tablero, posX, posY, misDatos);

                    }
                }
                );
                panelFondo.add(VentanaPrincipal.tablero[i][j]);
                panelFondo.validate();
                panelFondo.repaint();
            }
        }
    }

    public void agregarPlanetasTablero(int filas, int columnas, ArrayList<Jugadores> jugador, ArrayList<Planetas> planetas) {
        boolean comprobador;
        for (int i = 0; i < jugador.size(); i++) {
            for (int k = 0; k < jugador.get(i).getPlanetas().size(); k++) {
                comprobador = true;
                for (int j = 0; j < planetas.size(); j++) {
                    if (jugador.get(i).getPlanetas().get(k).equals(planetas.get(j).getNombre())) {
                        comprobador = false;
                        Jugadores nodo = new Jugadores();
                        nodo.setNombre(jugador.get(i).getNombre());
                        nodo.setPlanetas(jugador.get(i).getPlanetas());
                        nodo.setColor(jugador.get(i).getColor());
                        nodo.setMisPlanetas(jugador.get(i).getMisPlanetas());
                        nodo.getMisPlanetas().add(planetas.get(j));
                        nodo.setTipo(jugador.get(i).getTipo());
                        nodo.setPlanetasConquistados(jugador.get(i).getPlanetasConquistados());
                        nodo.setEnJuego("true");
                        jugador.set(i, nodo);
                        planetas.remove(j);
                        j--;
                        break;
                    }
                }
                if (comprobador == false) {
                    jugador.get(i).getPlanetas().remove(k);
                    k--;
                }
            }
        }
    }

    public boolean comparacionFilasColumnasPosPlanetas(Mapa mapita, ArrayList<Jugadores> listJugadores, boolean interruptor) {
        int filas = Integer.parseInt(mapita.getSize_filas());
        int columnas = Integer.parseInt(mapita.getSize_columnas());
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionY());
                if (posX >= columnas || posY >= filas) {
                    interruptor = false;
                    break;
                }
            }
            if (interruptor == false) {
                break;
            }
        }
        return interruptor;
    }

    public boolean comparacionFilasColumnasPosNeutrales(Mapa mapita, ArrayList<PlanetasNeutrales> listNeutrales, boolean interruptor) {
        int filas = Integer.parseInt(mapita.getSize_filas());
        int columnas = Integer.parseInt(mapita.getSize_columnas());
        if (listNeutrales != null) {
            for (int i = 0; i < listNeutrales.size(); i++) {
                int posX = Integer.parseInt(listNeutrales.get(i).getPosicionX());
                int posY = Integer.parseInt(listNeutrales.get(i).getPosicionY());
                if (posX >= columnas || posY >= filas) {
                    interruptor = false;
                    break;
                }
            }
        }
        return interruptor;
    }

    public boolean comparacionPosPlanetas(ArrayList<Jugadores> listJugadores, boolean interruptor) {
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                for (int k = 0; k < listJugadores.size(); k++) {
                    for (int l = 0; l < listJugadores.get(k).getMisPlanetas().size(); l++) {
                        if (i != k && j != l) {
                            if (listJugadores.get(i).getMisPlanetas().get(j).getPosicionX().equals(listJugadores.get(k).getMisPlanetas().get(l).getPosicionX()) && listJugadores.get(i).getMisPlanetas().get(j).getPosicionY().equals(listJugadores.get(k).getMisPlanetas().get(l).getPosicionY())) {
                                interruptor = false;
                                break;
                            }
                        }
                    }
                    if (interruptor == false) {
                        break;
                    }
                }
                if (interruptor == false) {
                    break;
                }
            }
            if (interruptor == false) {
                break;
            }
        }
        return interruptor;
    }

    public boolean comparacionPlanetasyNeutrales(ArrayList<PlanetasNeutrales> neutrales, ArrayList<Jugadores> jugadores, boolean interruptor) {
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < jugadores.get(i).getMisPlanetas().size(); j++) {
                String posX = jugadores.get(i).getMisPlanetas().get(j).getPosicionX();
                String posY = jugadores.get(i).getMisPlanetas().get(j).getPosicionY();
                for (int k = 0; k < neutrales.size(); k++) {
                    String posX2 = neutrales.get(k).getPosicionX();
                    String posY2 = neutrales.get(k).getPosicionY();
                    if (posX.equals(posX2) && posY.equals(posY2)) {
                        interruptor = false;
                    }
                }
                if (interruptor == false) {
                    break;
                }
            }
            if (interruptor == false) {
                break;
            }
        }
        return interruptor;
    }

    public boolean comparacionNeutralaNeutral(ArrayList<PlanetasNeutrales> neutrales, boolean interruptor) {
        for (int i = 0; i < neutrales.size(); i++) {
            String posX = neutrales.get(i).getPosicionX();
            String posY = neutrales.get(i).getPosicionY();
            for (int j = 0; j < neutrales.size(); j++) {
                String posX2 = neutrales.get(j).getPosicionX();
                String posY2 = neutrales.get(j).getPosicionY();
                if (i != j) {
                    if (posX.equals(posX2) && posY.equals(posY2)) {
                        interruptor = false;
                    }
                }
            }
            if (interruptor == false) {
                break;
            }
        }
        return interruptor;
    }

    public void posicionPlanetas(ArrayList<Jugadores> listJugadores, int x, int y, JLabel matriz, int filas, int columnas, ArrayList<PlanetasNeutrales> listNeutrales) {
        boolean concordancia = false;
        boolean concordanciaNeutral = false;
        int concordanciaX = 0;
        int concordanciaY = 0;
        String color = "";
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionY());
                if (posX == y && posY == x) {
                    concordancia = true;
                    concordanciaX = posY;
                    concordanciaY = posX;
                    color = listJugadores.get(i).getColor();
                    break;
                }
                if (concordancia == true) {
                    break;
                }
            }
        }

        for (int i = 0; i < listNeutrales.size(); i++) {
            int posX = Integer.parseInt(listNeutrales.get(i).getPosicionX());
            int posY = Integer.parseInt(listNeutrales.get(i).getPosicionY());
            if (posX == y && posY == x) {
                concordanciaNeutral = true;
                concordanciaX = posY;
                concordanciaY = posX;
                break;
            }
        }

        if (concordancia == true) {
            matriz.setOpaque(true);
            String[] valores = color.split(",");
            System.out.println(valores.length);
            int[] convertidos = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                convertidos[i] = Integer.parseInt(valores[i]);
            }
            matriz.setBackground(new Color(convertidos[0], convertidos[1], convertidos[2], convertidos[3]));
            matriz.setBorder(new LineBorder(Color.black));
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/circle-cropped.png"));
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(panelFondo.getWidth() / columnas, panelFondo.getHeight() / filas, Image.SCALE_DEFAULT));
            matriz.setIcon(icono);
            VentanaPrincipal.tablero[concordanciaX][concordanciaY] = matriz;
        } else if (concordanciaNeutral == true) {
            matriz.setOpaque(true);
            matriz.setBorder(new LineBorder(Color.black));
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/circle.png"));
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(panelFondo.getWidth() / columnas, panelFondo.getHeight() / filas, Image.SCALE_DEFAULT));
            matriz.setIcon(icono);
            VentanaPrincipal.tablero[concordanciaX][concordanciaY] = matriz;
        } else {
            matriz.setOpaque(false);
            matriz.setBorder(new LineBorder(Color.black));
            VentanaPrincipal.tablero[x][y] = matriz;

        }

    }

    public void posicionPlanetasNeutrales() {

    }
}
