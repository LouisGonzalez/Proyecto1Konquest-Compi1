package interfaz;

import Pollitos.ArchivoConfiguracion;
import gramaticas.AnalizadorLexico;
import gramaticas.SintaxCreacionMapa;
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

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private File proyecto;
    String archivo;

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("preuba");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton1)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        String path = "";
        String seleccion = "Seleccione el JSON para abrir el juego";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            // archivoPrincipal = chooser.getSelectedFile().toString();
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            path = chooser.getSelectedFile().toString();
            archivo = proyecto.toString();
            if(archivo.endsWith(".JSON")){
                FileReader fr;
                BufferedReader entrada;
                String texto = "";
                try {
                    fr = new FileReader(proyecto);
                    entrada = new BufferedReader(fr);
                    while(entrada.ready()){
                        texto += entrada.readLine() + "\n";
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
               // System.out.println(texto);
                  ArrayList<ArchivoConfiguracion> listArchivos = new ArrayList<>();
                  
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    new SintaxCreacionMapa(lexico, listArchivos).parse();
                    boolean v = SintaxCreacionMapa.interruptor;
                    if(v == true){
                        System.out.println("COMPILACION REALIZADA EXITOSAMENTE");
                        SintaxCreacionMapa.interruptor = true;
                    } else {
                        System.out.println("ERROR DE COMPILACION");
                        SintaxCreacionMapa.interruptor = true;
                    }
                   // boolean v = SintaxCreacionMapa.getInterruptor();
                    //System.out.println(v);
                    
                 } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
            } else {
                System.out.println("no es un archivo compatible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
