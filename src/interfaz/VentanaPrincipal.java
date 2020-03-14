package interfaz;

import Pollitos.ArchivoConfiguracion;
import gramaticas.AnalizadorLexico;
import gramaticas.SintaxCreacionMapa;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mapa.CreacionMapa;

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private File proyecto;
    String archivo; 
    public CreacionMapa mapa;
    public JLabel[][] tablero;
    
    public VentanaPrincipal() {
        initComponents();
        panelJuego.setBackground(new Color(255,255,255,100));
        mapa = new CreacionMapa(this.panelJuego, tablero);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelMensajes = new javax.swing.JTextArea();
        panelJuego = new javax.swing.JPanel();
        labelFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemNuevo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemLectura = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMensajes.setBackground(new java.awt.Color(6, 6, 39));
        panelMensajes.setColumns(20);
        panelMensajes.setForeground(new java.awt.Color(255, 255, 255));
        panelMensajes.setRows(5);
        jScrollPane1.setViewportView(panelMensajes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 800, 110));

        panelJuego.setBackground(new java.awt.Color(255, 255, 255));
        panelJuego.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 770, 460));

        labelFondo.setIcon(new javax.swing.ImageIcon("/home/luisitopapurey/Escritorio/Compiladores 1/Proyecto1.Konquest/fondo.jpg")); // NOI18N
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 640));

        itemNuevo.setText("Juego");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        itemNuevo.add(jMenuItem1);

        itemLectura.setText("Leer archivo JSON");
        itemLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLecturaActionPerformed(evt);
            }
        });
        itemNuevo.add(itemLectura);

        jMenuBar1.add(itemNuevo);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VentanaNuevoJuego nuevo = new VentanaNuevoJuego(this, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLecturaActionPerformed
        JFileChooser chooser = new JFileChooser();
        panelMensajes.setText("");
        SintaxCreacionMapa.totalErrores = "";
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
                ArrayList<ArchivoConfiguracion> listArchivos = new ArrayList<>();
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    new SintaxCreacionMapa(lexico, listArchivos, mapa, panelMensajes).parse();
                   
                 } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR");
                    panelMensajes.setText(SintaxCreacionMapa.totalErrores);
                }
                
                
                
                
            } else {
                System.out.println("no es un archivo compatible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }
    }//GEN-LAST:event_itemLecturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemLectura;
    private javax.swing.JMenu itemNuevo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JTextArea panelMensajes;
    // End of variables declaration//GEN-END:variables
}
