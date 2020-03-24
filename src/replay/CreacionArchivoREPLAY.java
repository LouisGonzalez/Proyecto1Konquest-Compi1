/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package replay;

import Pollitos.Juego;
import Pollitos.Planetas;
import interfaz.VentanaPrincipal;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisGonzalez
 */
public class CreacionArchivoREPLAY {

    private int contador = 1;

    public String creacionJSON(String path) {
        File replay = new File(path + "/replay" + contador + ".JSON");
        BufferedWriter buffer;
        if (replay.exists()) {
            contador++;
            creacionJSON(path);
        } else {
            try {
                buffer = new BufferedWriter(new FileWriter(replay));
                buffer.write(VentanaPrincipal.textoReplay);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionArchivoREPLAY.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return replay.toString();
    }

    
    public void textoNavesImpactadas(Juego misDatos, int i, int jugadorAtaque, String planeta, int totalNaves, String estado, int jugadorAtacante, String planetaAtacante) {
        VentanaPrincipal.aux2 += "\t       " + misDatos.getJugadores().get(jugadorAtaque).getNombre() + " {\n";
        VentanaPrincipal.aux2 += "\t         " + planeta + " [\n";
        VentanaPrincipal.aux2 += "\t           navesRestantes: " + totalNaves + ",\n";
        VentanaPrincipal.aux2 += "\t           estado: "+estado+",\n";
        VentanaPrincipal.aux2 += "\t           mensaje: dd,\n";
        VentanaPrincipal.aux2 += "\t           noFlota:" + i + ",\n";
        VentanaPrincipal.aux2 += "\t           jugadorAtacante: "+jugadorAtacante+",\n";
        VentanaPrincipal.aux2 += "\t           planetaAtacante: "+planetaAtacante+"\n";
        VentanaPrincipal.aux2 += "\t         ]\n";
        VentanaPrincipal.aux2 += "\t       }\n";

    }
    
    public void textoNeutralAtacado(String planeta, String estado, int i, int totalNaves, int jugadorAtacante, String planetaAtacante){
        VentanaPrincipal.aux2 += "\t       NEUTRAL {\n";
        VentanaPrincipal.aux2 += "\t         " + planeta + " [\n";
        VentanaPrincipal.aux2 += "\t           navesRestantes: " + totalNaves + ",\n";
        VentanaPrincipal.aux2 += "\t           estado: "+estado+",\n";
        VentanaPrincipal.aux2 += "\t           mensaje: dd,\n";
        VentanaPrincipal.aux2 += "\t           noFlota:" + i + ",\n";
        VentanaPrincipal.aux2 += "\t           jugadorAtacante: "+jugadorAtacante+",\n";
        VentanaPrincipal.aux2 += "\t           planetaAtacante: "+planetaAtacante+"\n";
        VentanaPrincipal.aux2 += "\t         ]\n";
        VentanaPrincipal.aux2 += "\t       }\n";
        
    }
    
    public void textoNeutral(Juego misDatos){
        for (int i = 0; i < misDatos.getJugadores().size(); i++) {
            if(i  == misDatos.getJugadores().size() - 1){
                VentanaPrincipal.aux3 += "\t       estado "+misDatos.getJugadores().get(i).getNombre()+": "+misDatos.getJugadores().get(i).getEnJuego()+"\n";
            } else {
                VentanaPrincipal.aux3 += "\t       estado "+misDatos.getJugadores().get(i).getNombre()+": "+misDatos.getJugadores().get(i).getEnJuego()+",\n";
            }
        }
    }

}
