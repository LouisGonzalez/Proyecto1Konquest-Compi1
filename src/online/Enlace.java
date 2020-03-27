/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author luisGonzalez
 */
public class Enlace {
    
    private ServerSocket server;
    private Socket socket;
    private final int puerto = 9000;
    private DataOutputStream salida;
    private BufferedReader entrada;
    //------------------------------------------------
    
    
    public void servidor(JTextArea panelMensajes){
        
        try {
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            //System.out.println(mensaje);
            panelMensajes.setText(mensaje);
            JOptionPane.showMessageDialog(null, mensaje);
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Adios mundo");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Enlace.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
