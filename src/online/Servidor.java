/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;

import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisGonzalez
 */
public class Servidor extends Observable implements Runnable {
    
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream dataIn = null;
    private DataOutputStream dataOut = null;
    private int puerto;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(puerto);
            while(true){
                socket = serverSocket.accept();
                dataIn = new DataInputStream(socket.getInputStream());
                String mensaje = dataIn.readUTF();
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void cerrarConexion(){
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
