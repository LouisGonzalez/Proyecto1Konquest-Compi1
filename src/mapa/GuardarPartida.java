package mapa;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import gramaticas2.AnalizadorLexico2;
import gramaticas2.SintaxGuardarPartida;
import interfaz.VentanaPrincipal;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class GuardarPartida {

    public void repartirPlanetas(Juego misDatos) {
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            for (int j = 0; j < misDatos.getJugadores().get(i).getMisPlanetas().size(); j++) {
                String nombrePlaneta = misDatos.getJugadores().get(i).getMisPlanetas().get(j).getNombre();
                misDatos.getJugadores().get(i).getPlanetas().add(nombrePlaneta);
            }
        }
    }

    public void crearJSON(Juego misDatos, ArrayList<NavesCamino> listNaves, String file) {
        File json = new File(file);
        BufferedWriter buffer;
        try {
            buffer = new BufferedWriter(new FileWriter(json));
            buffer.write("{\n");
            buffer.write("   MAPA: {\n");
            buffer.write("\tid: \"" + misDatos.getMapa().getId() + "\",\n");
            buffer.write("\tsize: {\n");
            buffer.write("\t   filas: " + misDatos.getMapa().getSize_filas() + ",\n");
            buffer.write("\t   columnas: " + misDatos.getMapa().getSize_columnas() + "\n");
            buffer.write("\t},\n");
            buffer.write("\talAzar: " + misDatos.getMapa().getAlAzar() + ",\n");
            buffer.write("\tplanetasNeutrales: " + misDatos.getMapa().getPlanetasNeutrales() + ",\n");
            buffer.write("\tmapaCiego: " + misDatos.getMapa().getMapaCiego() + ",\n");
            buffer.write("\tacumular: " + misDatos.getMapa().getAcumular() + ",\n");
            buffer.write("\tNEUTRALES: {\n");
            buffer.write("\t   mostrarNaves: " + misDatos.getMapa().getMapaPNeutral().getMostrarNaves() + ",\n");
            buffer.write("\t   mostrarEstadisticas: " + misDatos.getMapa().getMapaPNeutral().getMostrarEstadisticas() + ",\n");
            buffer.write("\t   produccion: " + misDatos.getMapa().getMapaPNeutral().getProduccion() + "\n");
            buffer.write("\t},\n");
            buffer.write("\tfinalizacion: " + misDatos.getMapa().getFinalizacion() + "\n");
            buffer.write("},\n");
            buffer.write("   PLANETAS: [\n");
            for (int i = misDatos.getJugadores().size()-1; i >= 0; i--) {
                for (int j = misDatos.getJugadores().get(i).getMisPlanetas().size()-1; j >= 0; j--) {
                    buffer.write("\t{\n");
                    Planetas aux = misDatos.getJugadores().get(i).getMisPlanetas().get(j);
                    buffer.write("\t  nombre: \"" + aux.getNombre() + "\",\n");
                    buffer.write("\t  naves: " + aux.getNaves() + ",\n");
                    buffer.write("\t  produccion: " + aux.getProduccion() + ",\n");
                    buffer.write("\t  porcentajeMuertes: " + aux.getPorcentajeMuertes() + ",\n");
                    buffer.write("\t  posicionX: " + aux.getPosicionX() + ",\n");
                    buffer.write("\t  posicionY: " + aux.getPosicionY() + "\n");
                    if (i == 0 && j == 0) {
                        buffer.write("\t}\n");
                    } else {
                        buffer.write("\t},\n");
                    }
                }
            }
            buffer.write("   ],\n");
            buffer.write("   PLANETAS_NEUTRALES: [\n");
            for (int i = misDatos.getpNeutrales().size()-1; i >= 0; i--) {
                buffer.write("\t{\n");
                buffer.write("\t  nombre: \"" + misDatos.getpNeutrales().get(i).getNombre() + "\",\n");
                buffer.write("\t  naves: " + misDatos.getpNeutrales().get(i).getNaves() + ",\n");
                buffer.write("\t  produccion: " + misDatos.getpNeutrales().get(i).getProduccion() + ",\n");
                buffer.write("\t  porcentajeMuertes: " + misDatos.getpNeutrales().get(i).getPorcentajeMuertes() + ",\n");
                buffer.write("\t  posicionX: " + misDatos.getpNeutrales().get(i).getPosicionX() + ",\n");
                buffer.write("\t  posicionY: " + misDatos.getpNeutrales().get(i).getPosicionY() + "\n");
                if (i == 0) {
                    buffer.write("\t}\n");
                } else {
                    buffer.write("\t},\n");
                }

            }
            buffer.write("   ],\n");
            buffer.write("   JUGADORES: [\n");
            for (int i = misDatos.getJugadores().size()-1; i >=0; i--) {
                Jugadores aux = misDatos.getJugadores().get(i);
                buffer.write("\t{\n");
                buffer.write("\t  nombre: \"" + aux.getNombre() + "\",\n");
                buffer.write("\t  color: \"" + aux.getColor() + "\",\n");
                buffer.write("\t planetas: [\n");
                for (int j = 0; j < misDatos.getJugadores().get(i).getPlanetas().size(); j++) {
                    if (j == 0) {
                        buffer.write("\t     \"" + aux.getPlanetas().get(j) + "\"\n");
                    } else {
                        buffer.write("\t     \"" + aux.getPlanetas().get(j) + "\",\n");
                    }
                }
                buffer.write("\t  ],\n");
                buffer.write("\t  tipo: " + aux.getTipo() + ",\n");
                buffer.write("\t  enJuego: " + aux.getEnJuego() + ",\n");
                buffer.write("\t  planetasConquistados: " + aux.getPlanetasConquistados() + "\n");
                if (i == 0) {
                    buffer.write("\t}\n");
                } else {
                    buffer.write("\t},\n");
                }

            }
            buffer.write("   ]\n");
            buffer.write("}\n");

            buffer.write("CAMBIOS: [\n");
            buffer.write("\tturno: " + VentanaPrincipal.contadorTurnos + ",\n");
            buffer.write("\tturnoJugador: " + VentanaPrincipal.contador + ",\n");
            buffer.write("\tNAVES_CAMINO [\t");
            for (int i = 0; i < listNaves.size(); i++) {
                buffer.write("\t{\n");
                buffer.write("\t  noFlota: " + listNaves.get(i).getNoFlota() + ",\n");
                buffer.write("\t  planetaOrigen: " + listNaves.get(i).getPlanetaOrigen() + ",\n");
                buffer.write("\t  planetaDestino: " + listNaves.get(i).getPlanetaDestino() + ",\n");
                buffer.write("\t  noNaves: " + listNaves.get(i).getNoNaves() + ",\n");
                buffer.write("\t  porcentajeMuertes: " + listNaves.get(i).getPorcentajeMuertes() + ",\n");
                buffer.write("\t  llegada: " + listNaves.get(i).getTurnoLlegada() + ",\n");
                buffer.write("\t  jugadorEnvio: " + listNaves.get(i).getNoJugadorEnvio() + ",\n");
                buffer.write("\t  jugadorAtaque: " + listNaves.get(i).getNoJugadorAtaque() + ",\n");
                buffer.write("\t  verificador: " + listNaves.get(i).getVerificador() + "\n");
                if (i == listNaves.size() - 1) {
                    buffer.write("\t}\n");
                } else {
                    buffer.write("\t},\n");
                }
            }
            buffer.write("\t]\n");
            buffer.write("]");

            buffer.close();
            /*String texto = "";
                    JOptionPane.showMessageDialog(null, "Partida guardada con exito ");
                    FileReader fr = new FileReader(json);
                    BufferedReader entrada = new BufferedReader(fr);
                    while (entrada.ready()) {
                        texto += entrada.readLine() + "\n";
                    }
                    AnalizadorLexico2 lexico = new AnalizadorLexico2(new StringReader(texto));
                    try {
                        new SintaxGuardarPartida(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego).parse();
                    } catch (Exception ex) {
                        Logger.getLogger(CreacionJSON.class.getName()).log(Level.SEVERE, null, ex);
                    }*/

        } catch (IOException ex) {
            Logger.getLogger(CreacionJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
