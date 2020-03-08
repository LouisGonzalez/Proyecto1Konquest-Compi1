package mapa;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.Planetas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author luisGonzalez
 */
public class CreacionMapa {

    public JPanel panelFondo;
    public JLabel[][] matrizJuego;

    public CreacionMapa(JPanel panelFondo, JLabel[][] matrizJuego) {
        this.panelFondo = panelFondo;
        this.matrizJuego = matrizJuego;
    }

    public void creacionCuadricula(int filas, int columnas, ArrayList<Jugadores> listJugadores) {
        matrizJuego = new JLabel[filas][columnas];
        panelFondo.setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JLabel matriz = new JLabel();
                posicionPlanetas(listJugadores, i, j, matriz, filas, columnas);
                matrizJuego[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        //  JOptionPane.showMessageDialog(null, "hostia me has pulsao");
                    }
                }
                );
                panelFondo.add(matrizJuego[i][j]);
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
                        jugador.set(i, nodo);
                        planetas.remove(j);
                        j--;
                        break;
                    }
                }
                if(comprobador == false){
                    jugador.get(i).getPlanetas().remove(k);
                    k--;
                }
            }
        }
    }
    
    public boolean comparacionFilasColumnasPosPlanetas(Mapa mapita, ArrayList<Jugadores> listJugadores, boolean interruptor){
        int filas = Integer.parseInt(mapita.getSize_filas());
        int columnas = Integer.parseInt(mapita.getSize_columnas());
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionY());
                if(posX >= filas || posY >= columnas){
                   interruptor = false;
                   break;
                }
            }
            if(interruptor == false){
                break;
            }
        }
        return interruptor;
    }
    
    public boolean comparacionPosPlanetas(ArrayList<Jugadores> listJugadores, boolean interruptor){
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                for (int k = 0; k < listJugadores.size(); k++) {
                    for (int l = 0; l < listJugadores.get(k).getMisPlanetas().size(); l++) {
                        if(i != k && j != l){
                            if(listJugadores.get(i).getMisPlanetas().get(j).getPosicionX().equals(listJugadores.get(k).getMisPlanetas().get(l).getPosicionX()) && listJugadores.get(i).getMisPlanetas().get(j).getPosicionY().equals(listJugadores.get(k).getMisPlanetas().get(l).getPosicionY())){
                                interruptor = false;
                                break;
                            }
                        }
                    }
                    if(interruptor == false){
                        break;
                    }
                }
                if(interruptor == false){
                    break;
                }
            }
            if(interruptor == false){
                break;
            }
        }
        return interruptor;
    }
    
    public void posicionPlanetas(ArrayList<Jugadores> listJugadores, int x, int y, JLabel matriz, int filas, int columnas){
        boolean concordancia = false;
        int concordanciaX = 0;
        int concordanciaY = 0;
        String color = "";
        for (int i = 0; i < listJugadores.size(); i++) {
            for (int j = 0; j < listJugadores.get(i).getMisPlanetas().size(); j++) {
                int posX = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionX());
                int posY = Integer.parseInt(listJugadores.get(i).getMisPlanetas().get(j).getPosicionY());
                if(posX == x && posY == y){
                    concordancia = true;
                    concordanciaX = posX;
                    concordanciaY = posY;
                    color = listJugadores.get(i).getColor();
                    break;
                }
                if(concordancia == true){
                    break;
                }
            }
        }
        if(concordancia == true){
            matriz.setOpaque(true);
            String[] valores = color.split(",");
            System.out.println(valores.length);
            int[] convertidos = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                convertidos[i] = Integer.parseInt(valores[i]);
            }
            matriz.setBackground(new Color(convertidos[0], convertidos[1], convertidos[2], convertidos[3]));
            matriz.setBorder(new LineBorder(Color.black));
            ImageIcon imagen = new ImageIcon("/home/luisitopapurey/Escritorio/Compiladores 1/Proyecto1.Konquest/circle-cropped.png");
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(panelFondo.getWidth()/columnas, panelFondo.getHeight()/filas, Image.SCALE_DEFAULT));
            matriz.setIcon(icono);
            matrizJuego[concordanciaX][concordanciaY] = matriz;
        } else {
            matriz.setOpaque(false);
            matriz.setBorder(new LineBorder(Color.black));
            matrizJuego[x][y] = matriz; 
        }
        
    }
}
