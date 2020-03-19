package mapa;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import gramaticas.AnalizadorLexico;
import gramaticas.SintaxCreacionMapa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luisGonzalez
 */
public class CreacionJSON {

    private JTextArea panelMensajes;
    private CreacionMapa mapa;
    private int contador;
    private JTextField txtNaves;

    public CreacionJSON(JTextArea panelMensajes, CreacionMapa mapa, int contador, JTextField txtNaves) {
        this.panelMensajes = panelMensajes;
        this.mapa = mapa;
        this.contador = contador;
        this.txtNaves = txtNaves;
    }

    public void caracteristicasAlAzar(ArrayList<Planetas> listPlanetas, int filas, int columnas, ArrayList<PlanetasNeutrales> listNeutrales, String produccion) {
        int parametro = 0;
        //Random rand = new Random();
        int totalPlanetas, totalNaves, posicionX, posicionY;
        double porcentajeMuerte;
        if (filas >= columnas) {
            parametro = filas;
            totalPlanetas = (int) (Math.random() * parametro + 1);
            for (int i = 0; i < totalPlanetas; i++) {
                posicionX = (int) (Math.random() * columnas);
                posicionY = (int) (Math.random() * filas);
                porcentajeMuerte = Math.random();
                totalNaves = (int) (Math.random() * 10 + 1);
                PlanetasNeutrales neutral = new PlanetasNeutrales();
                neutral.setNombre("N" + Integer.toString(i));
                neutral.setNaves(Integer.toString(totalNaves));
                neutral.setInterruptor(false);
                neutral.setPorcentajeMuertes(Double.toString(porcentajeMuerte));
                neutral.setProduccion(produccion);
                neutral.setPosicionX(Integer.toString(posicionX));
                neutral.setPosicionY(Integer.toString(posicionY));
                verificadorPosiciones(listPlanetas, listNeutrales, neutral, filas, columnas, produccion);
            }

        } else {
            parametro = columnas;
            totalPlanetas = (int) (Math.random() * parametro + 1);
            for (int i = 0; i < totalPlanetas; i++) {
                posicionX = (int) (Math.random() * columnas);
                posicionY = (int) (Math.random() * filas);
                porcentajeMuerte = Math.random();
                totalNaves = (int) (Math.random() * 10 + 1);
                PlanetasNeutrales neutral = new PlanetasNeutrales();
                neutral.setNombre("N" + Integer.toString(i));
                neutral.setNaves(Integer.toString(totalNaves));
                neutral.setInterruptor(false);
                neutral.setPorcentajeMuertes(Double.toString(porcentajeMuerte));
                neutral.setProduccion(produccion);
                neutral.setPosicionX(Integer.toString(posicionX));
                neutral.setPosicionY(Integer.toString(posicionY));
                verificadorPosiciones(listPlanetas, listNeutrales, neutral, filas, columnas, produccion);
            }
        }
    }

    public void verificadorPosiciones(ArrayList<Planetas> listPlanetas, ArrayList<PlanetasNeutrales> listNeutrales, PlanetasNeutrales neutral, int filas, int columnas, String produccion) {
        boolean verificador = true;
        boolean verificador2 = true;
        if (!listNeutrales.isEmpty()) {
            for (int i = 0; i < listNeutrales.size(); i++) {
                int posX = Integer.parseInt(listNeutrales.get(i).getPosicionX());
                int posY = Integer.parseInt(listNeutrales.get(i).getPosicionY());
                if (posX == Integer.parseInt(neutral.getPosicionX()) && posY == Integer.parseInt(neutral.getPosicionY())) {
                    listNeutrales.clear();
                    verificador = false;
                    break;
                }
            }

        }
        if (verificador == true) {
            if (!listPlanetas.isEmpty()) {
                for (int i = 0; i < listPlanetas.size(); i++) {
                    int posX = Integer.parseInt(listPlanetas.get(i).getPosicionX());
                    int posY = Integer.parseInt(listPlanetas.get(i).getPosicionY());
                    if (posX == Integer.parseInt(neutral.getPosicionX()) && posY == Integer.parseInt(neutral.getPosicionY())) {
                        listNeutrales.clear();
                        verificador2 = false;
                        break;
                    }
                }
            }
        }
        if (verificador == false || verificador2 == false) {
            caracteristicasAlAzar(listPlanetas, filas, columnas, listNeutrales, produccion);
        } else if (verificador == true && verificador2 == true) {
            listNeutrales.add(neutral);
        }

    }

    public void atributosPlanetasJugadorAzar(Jugadores jugador, ArrayList<PlanetasNeutrales> listNeutrales, ArrayList<Planetas> listPlanetas, int filas, int columnas) {
        int totalNaves = (int) (Math.random() * 20 + 1);
        int produccion = (int) (Math.random() * 10 + 1);
        int posX = (int) (Math.random() * columnas);
        int posY = (int) (Math.random() * filas);
        double porcentajeMuerte = Math.random();
        Planetas planeta = new Planetas();
        planeta.setNombre(jugador.getPlanetas().get(0));
        planeta.setColor(jugador.getColor());
        planeta.setNaves(Integer.toString(totalNaves));
        planeta.setProduccion(Integer.toString(produccion));
        planeta.setPorcentajeMuertes(Double.toString(porcentajeMuerte));
        planeta.setInterruptor(false);
        planeta.setPosicionX(Integer.toString(posX));
        planeta.setPosicionY(Integer.toString(posY));
        verificadorPosicionesPJugador(jugador, listNeutrales, listPlanetas, posX, posY, planeta, filas, columnas);

    }

    public void verificadorPosicionesPJugador(Jugadores jugador, ArrayList<PlanetasNeutrales> listNeutrales, ArrayList<Planetas> listPlanetas, int posX, int posY, Planetas planeta, int filas, int columnas) {
        boolean verificador = true;
        boolean verificador2 = true;
        if (!listNeutrales.isEmpty()) {
            for (int i = 0; i < listNeutrales.size(); i++) {
                if (posX == Integer.parseInt(listNeutrales.get(i).getPosicionX()) && posY == Integer.parseInt(listNeutrales.get(i).getPosicionY())) {
                    verificador = false;
                    break;
                }
            }
        }
        if (verificador == true) {
            if (!listPlanetas.isEmpty()) {
                for (int i = 0; i < listPlanetas.size(); i++) {
                    if (posX == Integer.parseInt(listPlanetas.get(i).getPosicionX()) && posY == Integer.parseInt(listPlanetas.get(i).getPosicionY())) {
                        verificador2 = false;
                        break;
                    }
                }
            }
        }
        if (verificador == false || verificador2 == false) {
            atributosPlanetasJugadorAzar(jugador, listNeutrales, listPlanetas, filas, columnas);
        } else {
            JOptionPane.showMessageDialog(null, "Jugador creado con exito");
            listPlanetas.add(planeta);
        }
    }

    public Mapa seteoDatosMapa(ArrayList<PlanetasNeutrales> neutrales, ArrayList<Planetas> listPlanetas, ArrayList<Jugadores> listJugadores, Mapa mapita, String id, String filas, String columnas, JCheckBox checkAzar, JCheckBox checkMapaCiego, JCheckBox checkAcumular, JCheckBox checkNaves, JCheckBox checkStats, JSpinner spinProduccion, JSpinner spinFinalizacion) {
        mapita.setId(id);
        mapita.setSize_filas(filas);
        mapita.setSize_columnas(columnas);
        if (!checkAzar.isSelected()) {
            mapita.setAlAzar("false");
        } else {
            mapita.setAlAzar("true");
        }
        mapita.setPlanetasNeutrales(Integer.toString(neutrales.size()));
        if (!checkMapaCiego.isSelected()) {
            mapita.setMapaCiego("false");
        } else {
            mapita.setMapaCiego("true");
        }
        if (!checkAcumular.isSelected()) {
            mapita.setAcumular("false");
        } else {
            mapita.setAcumular("true");
        }
        if (!checkNaves.isSelected()) {
            mapita.getMapaPNeutral().setMostrarNaves("false");
        } else {
            mapita.getMapaPNeutral().setMostrarNaves("true");
        }
        if (!checkStats.isSelected()) {
            mapita.getMapaPNeutral().setMostrarEstadisticas("false");
        } else {
            mapita.getMapaPNeutral().setMostrarEstadisticas("true");
        }
        mapita.getMapaPNeutral().setProduccion(spinProduccion.getValue().toString());
        mapita.setFinalizacion(spinFinalizacion.getValue().toString());
        return mapita;
    }

    public boolean crearArchivoJSON(Mapa mapita, ArrayList<Jugadores> listJugadores, ArrayList<Planetas> listPlanetas, ArrayList<PlanetasNeutrales> listNeutrales, String path, ArrayList<Juego> datosJuego, JButton btnTurno, ArrayList<NavesCamino> listNaves, JPanel panelJuego)  {
        boolean comprobante = true;
        File json = new File(path + "/" + mapita.getId() + ".JSON");
        BufferedWriter buffer;
        if (json.exists()) {
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con este nombre dentro de este directorio porfavor cambia el nombre");
        } else {
            try {
                buffer = new BufferedWriter(new FileWriter(json));
                buffer.write("{\n");
                buffer.write("   MAPA: {\n");
                buffer.write("\tid: \"" + mapita.getId() + "\",\n");
                buffer.write("\tsize: {\n");
                buffer.write("\t   filas: " + mapita.getSize_filas() + ",\n");
                buffer.write("\t   columnas: " + mapita.getSize_columnas() + "\n");
                buffer.write("\t},\n");
                buffer.write("\talAzar: " + mapita.getAlAzar() + ",\n");
                buffer.write("\tplanetasNeutrales: " + mapita.getPlanetasNeutrales() + ",\n");
                buffer.write("\tmapaCiego: " + mapita.getMapaCiego() + ",\n");
                buffer.write("\tacumular: " + mapita.getAcumular() + ",\n");
                buffer.write("\tNEUTRALES: {\n");
                buffer.write("\t   mostrarNaves: " + mapita.getMapaPNeutral().getMostrarNaves() + ",\n");
                buffer.write("\t   mostrarEstadisticas: " + mapita.getMapaPNeutral().getMostrarEstadisticas() + ",\n");
                buffer.write("\t   produccion: " + mapita.getMapaPNeutral().getProduccion() + "\n");
                buffer.write("\t},\n");
                buffer.write("\tfinalizacion: " + mapita.getFinalizacion() + "\n");
                buffer.write("},\n");
                buffer.write("   PLANETAS: [\n");
                for (int i = 0; i < listPlanetas.size(); i++) {
                    if (listPlanetas.get(i).getPorcentajeMuertes() == null || listPlanetas.get(i).getNombre() == null || listPlanetas.get(i).getNaves() == null || listPlanetas.get(i).getProduccion() == null) {
                        comprobante = false;
                        JOptionPane.showMessageDialog(null, "Planeta sin asignarse atributos");
                        json.delete();
                        break;
                    } else {
                        buffer.write("\t{\n");
                        buffer.write("\t  nombre: \"" + listPlanetas.get(i).getNombre() + "\",\n");
                        buffer.write("\t  naves: " + listPlanetas.get(i).getNaves() + ",\n");
                        buffer.write("\t  produccion: " + listPlanetas.get(i).getProduccion() + ",\n");
                        buffer.write("\t  porcentajeMuertes: " + listPlanetas.get(i).getPorcentajeMuertes() + ",\n");
                        buffer.write("\t  posicionX: " + listPlanetas.get(i).getPosicionX() + ",\n");
                        buffer.write("\t  posicionY: " + listPlanetas.get(i).getPosicionY() + "\n");
                        if (i == listPlanetas.size() - 1) {
                            buffer.write("\t}\n");
                        } else {
                            buffer.write("\t},\n");
                        }
                    }
                }
                if (comprobante == true) {
                    buffer.write("   ],\n");
                    buffer.write("   PLANETAS_NEUTRALES: [\n");
                    for (int i = 0; i < listNeutrales.size(); i++) {
                        if (listNeutrales.get(i).getPorcentajeMuertes() == null || listNeutrales.get(i).getNombre() == null || listNeutrales.get(i).getNaves() == null) {
                            comprobante = false;
                            JOptionPane.showMessageDialog(null, "Planeta neutral sin asignarse atributos");
                            json.delete();
                            break;
                        } else {
                            buffer.write("\t{\n");
                            buffer.write("\t  nombre: \"" + listNeutrales.get(i).getNombre() + "\",\n");
                            buffer.write("\t  naves: " + listNeutrales.get(i).getNaves() + ",\n");
                            if (listNeutrales.get(i).getProduccion() == null) {
                                buffer.write("\t  produccion: " + mapita.getMapaPNeutral().getProduccion() + ",\n");
                            } else {
                                buffer.write("\t  produccion: " + listNeutrales.get(i).getProduccion() + ",\n");
                            }
                            buffer.write("\t  porcentajeMuertes: " + listNeutrales.get(i).getPorcentajeMuertes() + ",\n");
                            buffer.write("\t  posicionX: " + listNeutrales.get(i).getPosicionX() + ",\n");
                            buffer.write("\t  posicionY: " + listNeutrales.get(i).getPosicionY() + "\n");
                            if (i == listNeutrales.size() - 1) {
                                buffer.write("\t}\n");
                            } else {
                                buffer.write("\t},\n");
                            }
                        }
                    }
                }
                if (comprobante == true) {
                    buffer.write("   ],\n");
                    buffer.write("   JUGADORES: [\n");
                    for (int i = 0; i < listJugadores.size(); i++) {
                        if (listJugadores.get(i).getNombre() == null || listJugadores.get(i).getColor() == null || listJugadores.get(i).getTipo() == null) {
                            comprobante = false;
                            JOptionPane.showMessageDialog(null, "Jugador sin terminar de asignar sus atributos");
                            json.delete();
                            break;
                        } else {
                            buffer.write("\t{\n");
                            buffer.write("\t  nombre: \"" + listJugadores.get(i).getNombre() + "\",\n");
                            buffer.write("\t  color:  \"" + listJugadores.get(i).getColor() + "\",\n");
                            buffer.write("\t  planetas: [\n");
                            for (int j = 0; j < listJugadores.get(i).getPlanetas().size(); j++) {
                                if (j == listJugadores.get(i).getPlanetas().size() - 1) {
                                    buffer.write("\t     \"" + listJugadores.get(i).getPlanetas().get(j) + "\"\n");
                                } else {
                                    buffer.write("\t     \"" + listJugadores.get(i).getPlanetas().get(j) + "\",\n");
                                }
                            }
                            buffer.write("\t  ],\n");
                            buffer.write("\t  tipo: " + listJugadores.get(i).getTipo() + "\n");
                            if (i == listJugadores.size() - 1) {
                                buffer.write("\t}\n");
                            } else {
                                buffer.write("\t},\n");
                            }
                        }
                    }
                    buffer.write("   ]\n");
                    buffer.write("}");

                }
                buffer.close();
                if (comprobante == true) {
                    String texto = "";
                    JOptionPane.showMessageDialog(null, "Disfruta del juego!    ");
                    FileReader fr = new FileReader(json);
                    BufferedReader entrada = new BufferedReader(fr);
                    while (entrada.ready()) {
                        texto += entrada.readLine() + "\n";
                    }
                    AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                    try {
                        new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego).parse();
                    } catch (Exception ex) {
                        Logger.getLogger(CreacionJSON.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } catch (IOException ex) {
                Logger.getLogger(CreacionJSON.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return comprobante;
    }

}
