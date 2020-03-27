/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;

import Pollitos.AccionesOnline;
import Pollitos.Juego;
import Pollitos.NavesCamino;
import gramaticas.AnalizadorLexico;
import gramaticas.SintaxCreacionMapa;
import gramaticas2.AnalizadorLexico2;
import interfaz.AdderOnline;
import interfaz.HostOnline;
import interfaz.VentanaPrincipal;
import static interfaz.VentanaPrincipal.contador;
import static interfaz.VentanaPrincipal.contadorTurnos;
import static interfaz.VentanaPrincipal.textoReplay;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author luisGonzalez
 */
public class Validaciones {

    public boolean verificarMapa(Juego misDatos, JPanel panelJuego, ArrayList<NavesCamino> listNaves, AccionesOnline accionesOnline, HostOnline host) {
        boolean online = false;
        if (misDatos.getJugadores().size() == 2) {
            if (misDatos.getJugadores().get(0).getTipo().equals("HUMANO") && misDatos.getJugadores().get(1).getTipo().equals("HUMANO")) {
                host.setVisible(true);
                online = true;
            } else {
                removerDatos(misDatos, listNaves, panelJuego, "Este mapa contiene jugadores de tipo computadora por lo cual no es apto para jugar online", accionesOnline);
            }
        } else {
            removerDatos(misDatos, listNaves, panelJuego, "Este mapa no es apto para jugar online", accionesOnline);
        }
        return online;
    }
    
    public boolean verificarMapa2(Juego misDatos, JPanel panelJuego, ArrayList<NavesCamino> listNaves, AccionesOnline accionesOnline, AdderOnline adder) {
        boolean online = false;
        if (misDatos.getJugadores().size() == 2) {
            if (misDatos.getJugadores().get(0).getTipo().equals("HUMANO") && misDatos.getJugadores().get(1).getTipo().equals("HUMANO")) {
                adder.setVisible(true);
                online = true;
            } else {
                removerDatos(misDatos, listNaves, panelJuego, "Este mapa contiene jugadores de tipo computadora por lo cual no es apto para jugar online", accionesOnline);
            }
        } else {
            removerDatos(misDatos, listNaves, panelJuego, "Este mapa no es apto para jugar online", accionesOnline);
        }
        return online;
    }
    
    public void removerDatos(Juego misDatos, ArrayList<NavesCamino> listNaves, JPanel panelJuego, String mensaje, AccionesOnline online) {
        JOptionPane.showMessageDialog(null, mensaje);
        misDatos = null;
        listNaves.clear();
        panelJuego.removeAll();
        panelJuego.setVisible(false);
        online = new AccionesOnline();
        
    }

    public JFileChooser abrirArchivo(Juego juego, ArrayList<Juego> datosJuego, JTextArea panelMensajes) {
        juego = new Juego();
        datosJuego.clear();
        JFileChooser chooser = new JFileChooser();
        panelMensajes.setText("");
        SintaxCreacionMapa.totalErrores = "";
        String seleccion = "Seleccione el JSON para abrir el juego";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        return chooser;
    }

    public String validarArchivo(String archivo, File proyecto) {
        FileReader fr;
        BufferedReader entrada;
        String texto = "";
        try {
            fr = new FileReader(proyecto);
            entrada = new BufferedReader(fr);
            while (entrada.ready()) {
                texto += entrada.readLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
}
