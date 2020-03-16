package interfaz;

import Pollitos.ArchivoConfiguracion;
import Pollitos.Juego;
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
import mapa.Jugabilidad;

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private File proyecto;
    String archivo; 
    public CreacionMapa mapa;
    public JLabel[][] tablero;
    private Juego juego = null;
    public static int contador = 0;
    private ArrayList<Juego> datosJuego = new ArrayList<>();
    private Jugabilidad jugabilidad;
    
    public VentanaPrincipal() {
        initComponents();
        txtNaves.setEditable(false);
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
        lblTurno = new javax.swing.JLabel();
        panelFondo = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btnTurno = new javax.swing.JButton();
        lblJugador = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtNaves = new javax.swing.JTextField();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 800, 100));

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

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 770, 460));

        lblTurno.setBackground(new java.awt.Color(255, 255, 255));
        lblTurno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(255, 255, 255));
        lblTurno.setText("Turno:");
        getContentPane().add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 130, -1));

        panelFondo.setIcon(new javax.swing.ImageIcon("/home/luisitopapurey/Escritorio/Compiladores 1/Proyecto1.Konquest/fondo.jpg")); // NOI18N
        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 840, 650));

        btnTurno.setText("Terminar turno");
        btnTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnoActionPerformed(evt);
            }
        });

        lblJugador.setText("Jugador");

        txtNaves.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNavesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtNaves, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 60));

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
        juego = new Juego();
        VentanaNuevoJuego nuevo = new VentanaNuevoJuego(this, true, mapa, panelMensajes, contador, txtNaves, datosJuego);
        nuevo.setVisible(true);
        juego = datosJuego.get(0);
        datosJuego.clear();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLecturaActionPerformed
        juego = new Juego();
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
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego).parse();
                    juego = datosJuego.get(0);
                    datosJuego.clear();
                    
                    
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

    private void txtNavesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNavesKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a)){
            evt.consume();
        }
    }//GEN-LAST:event_txtNavesKeyTyped

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed
        if(txtNaves.isEditable() == false){
            
        } else {
            contador++;
            
        }
        System.out.println(contador);
        txtNaves.setText("");
        txtNaves.setEditable(false);
        
    }//GEN-LAST:event_btnTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTurno;
    private javax.swing.JMenuItem itemLectura;
    private javax.swing.JMenu itemNuevo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel panelFondo;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JTextArea panelMensajes;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField txtNaves;
    // End of variables declaration//GEN-END:variables
}
