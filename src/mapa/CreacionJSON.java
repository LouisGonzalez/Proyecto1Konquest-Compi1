package mapa;

import Pollitos.Jugadores;
import Pollitos.Mapa;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author luisGonzalez
 */
public class CreacionJSON {

    private JTextArea panelMensajes;
    private CreacionMapa mapa;
    
    public CreacionJSON(JTextArea panelMensajes, CreacionMapa mapa){
        this.panelMensajes = panelMensajes;
        this.mapa = mapa;
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
            mapita.setMostrarNaves("false");
        } else {
            mapita.setMostrarNaves("true");
        }
        if (!checkStats.isSelected()) {
            mapita.setMostrarEstadisticas("false");
        } else {
            mapita.setMostrarEstadisticas("true");
        }
        mapita.setProduccion(spinProduccion.getValue().toString());
        mapita.setFinalizacion(spinFinalizacion.getValue().toString());
        return mapita;
    }

    public boolean crearArchivoJSON(Mapa mapita, ArrayList<Jugadores> listJugadores, ArrayList<Planetas> listPlanetas, ArrayList<PlanetasNeutrales> listNeutrales, String path) {
        boolean comprobante = true;
        File json = new File(path+"/"+mapita.getId()+".JSON");
        BufferedWriter buffer;
        if(json.exists()){
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con este nombre dentro de este directorio porfavor cambia el nombre");
        } else {
            try {
                buffer = new BufferedWriter(new FileWriter(json));
                buffer.write("{\n");
                buffer.write("   MAPA: {\n");
                buffer.write("\tid: \""+mapita.getId()+"\",\n");
                buffer.write("\tsize: {\n");
                buffer.write("\t   filas: "+mapita.getSize_filas()+",\n");
                buffer.write("\t   columnas: "+mapita.getSize_columnas()+"\n");
                buffer.write("\t},\n");
                buffer.write("\talAzar: "+mapita.getAlAzar()+",\n");
                buffer.write("\tplanetasNeutrales: "+mapita.getPlanetasNeutrales()+",\n");
                buffer.write("\tmapaCiego: "+mapita.getMapaCiego()+",\n");
                buffer.write("\tacumular: "+mapita.getAcumular()+",\n");
                buffer.write("\tNEUTRALES: {\n");
                buffer.write("\t   mostrarNaves: "+mapita.getMostrarNaves()+",\n");
                buffer.write("\t   mostrarEstadisticas: "+mapita.getMostrarEstadisticas()+",\n");
                buffer.write("\t   produccion: "+mapita.getProduccion()+"\n");
                buffer.write("\t},\n");
                buffer.write("\tfinalizacion: "+mapita.getFinalizacion()+"\n");
                buffer.write("},\n");
                buffer.write("   PLANETAS: [\n");
                for (int i = 0; i < listPlanetas.size(); i++) {
                    if(listPlanetas.get(i).getPorcentajeMuertes()==null || listPlanetas.get(i).getNombre()==null || listPlanetas.get(i).getNaves()==null || listPlanetas.get(i).getProduccion()==null){
                        comprobante = false;
                        JOptionPane.showMessageDialog(null, "Planeta sin asignarse atributos");
                        json.delete();
                        break;
                    } else {
                        buffer.write("\t{\n");
                        buffer.write("\t  nombre: \""+listPlanetas.get(i).getNombre()+"\",\n");
                        buffer.write("\t  naves: "+listPlanetas.get(i).getNaves()+",\n");
                        buffer.write("\t  produccion: "+listPlanetas.get(i).getProduccion()+",\n");
                        buffer.write("\t  porcentajeMuertes: "+listPlanetas.get(i).getPorcentajeMuertes()+",\n");
                        buffer.write("\t  posicionX: "+listPlanetas.get(i).getPosicionX()+",\n");
                        buffer.write("\t  posicionY: "+listPlanetas.get(i).getPosicionY()+"\n");
                        if(i == listPlanetas.size()-1){
                            buffer.write("\t}\n");                            
                        } else {
                            buffer.write("\t},\n");
                        }
                    }
                }
                if(comprobante == true){
                    buffer.write("   ],\n");
                    buffer.write("   PLANETAS_NEUTRALES: [\n");
                    for (int i = 0; i < listNeutrales.size(); i++) {
                        if(listNeutrales.get(i).getPorcentajeMuertes()==null || listNeutrales.get(i).getNombre()==null || listNeutrales.get(i).getNaves()==null){
                            comprobante = false;
                            JOptionPane.showMessageDialog(null, "Planeta neutral sin asignarse atributos");
                            json.delete();
                            break;
                        } else {
                            buffer.write("\t{\n");
                            buffer.write("\t  nombre: \""+listNeutrales.get(i).getNombre()+"\",\n");
                            buffer.write("\t  naves: "+listNeutrales.get(i).getNaves()+",\n");
                            if(listNeutrales.get(i).getProduccion() == null){
                                buffer.write("\t  produccion: "+mapita.getProduccion()+",\n");
                            } else {
                                buffer.write("\t  produccion: "+listNeutrales.get(i).getProduccion()+",\n");
                            }
                            buffer.write("\t  porcentajeMuertes: "+listNeutrales.get(i).getPorcentajeMuertes()+",\n");
                            buffer.write("\t  posicionX: "+listNeutrales.get(i).getPosicionX()+",\n");
                            buffer.write("\t  posicionY: "+listNeutrales.get(i).getPosicionY()+"\n");
                            if(i == listNeutrales.size()-1){
                                buffer.write("\t}\n");
                            } else {
                                buffer.write("\t},\n");
                            }
                        }
                    }
                }
                if(comprobante == true){
                    buffer.write("   ],\n");
                    buffer.write("   JUGADORES: [\n");
                    for (int i = 0; i < listJugadores.size(); i++) {
                        if(listJugadores.get(i).getNombre()==null || listJugadores.get(i).getColor()==null || listJugadores.get(i).getTipo() == null){
                            comprobante = false;
                            JOptionPane.showMessageDialog(null, "Jugador sin terminar de asignar sus atributos");
                            json.delete();
                            break;
                        } else {
                            buffer.write("\t{\n");
                            buffer.write("\t  nombre: \""+listJugadores.get(i).getNombre()+"\",\n");
                            buffer.write("\t  color:  \""+listJugadores.get(i).getColor()+"\",\n");
                            buffer.write("\t  planetas: [\n");
                            for (int j = 0; j < listJugadores.get(i).getPlanetas().size(); j++) {
                                if(j == listJugadores.get(i).getPlanetas().size()-1){
                                    buffer.write("\t     \""+listJugadores.get(i).getPlanetas().get(j)+"\"\n");
                                } else {
                                    buffer.write("\t     \""+listJugadores.get(i).getPlanetas().get(j)+"\",\n");
                                }
                            }
                            buffer.write("\t  ],\n");
                            buffer.write("\t  tipo: "+listJugadores.get(i).getTipo()+"\n");
                            if(i == listJugadores.size() - 1){
                                buffer.write("\t}\n");
                            } else {
                                buffer.write("\t},\n");
                            }
                        }
                    }
                        buffer.write("   ]");
                        buffer.write("}");
                    
                }
                buffer.close();
                if(comprobante == true){
                    String texto = "";
                    JOptionPane.showMessageDialog(null, "Disfruta del juego!    ");
                    FileReader fr = new FileReader(json);
                    BufferedReader entrada = new BufferedReader(fr);
                    while(entrada.ready()){
                        texto += entrada.readLine() + "\n";
                    }
                    AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                    try {
                        new SintaxCreacionMapa(lexico, mapa, panelMensajes).parse();
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
