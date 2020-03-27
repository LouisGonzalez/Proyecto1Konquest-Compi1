/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;
import Pollitos.Online;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luisGonzalez
 */
public class Cliente implements Runnable {
    
    private Socket cliente;
    private final String HOST = "localhost";
    private int puerto;
    private String mensaje;
    private DataOutputStream mensajeSalida;
    
    public Cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    
    @Override
    public void run() {
        try {
            Socket socket = new Socket(HOST, puerto);
            mensajeSalida = new DataOutputStream(socket.getOutputStream());
            mensajeSalida.writeUTF(mensaje);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
