/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Pollitos.Juego;
import Pollitos.NavesCamino;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mapa.GuardarPartida;

/**
 *
 * @author luisGonzalez
 */
public class InterfazGuardar extends javax.swing.JDialog {

    private final GuardarPartida guardar = new GuardarPartida();
    private Juego misDatos;
    private ArrayList<NavesCamino> listNaves;
    private String path;
    private JPanel panelJuego;
    
    /**
     * Creates new form InterfazGuardar
     * @param parent
     * @param modal
     * @param misDatos
     * @param listNaves
     * @param panelJuego
     */
    public InterfazGuardar(java.awt.Frame parent, boolean modal, Juego misDatos, ArrayList<NavesCamino> listNaves, JPanel panelJuego) {
        super(parent, modal);
        initComponents();
        this.listNaves = listNaves;
        this.misDatos = misDatos;
        this.panelJuego = panelJuego;
        setLocationRelativeTo(null);
        txtDirectorio.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnDirectorio = new javax.swing.JButton();
        txtDirectorio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setText("Nombre:");

        btnDirectorio.setText("Directorio");
        btnDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectorioActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFondoLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelFondoLayout.createSequentialGroup()
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelFondoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDirectorio)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.getText().equals("") || txtDirectorio.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Te hace falta llenar alguno de los parametros");
        } else {
            guardar.guardarComo(path, txtNombre.getText(), misDatos, listNaves);
            JOptionPane.showMessageDialog(null, "El juego ha sido guardado con exito");
            misDatos = null;
            panelJuego.removeAll();
            panelJuego.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectorioActionPerformed
            JFileChooser chooser = new JFileChooser();
            String path = "";
            String seleccion = "Seleccione el JSON para abrir el juego";
            chooser.setCurrentDirectory(new File("."));
            chooser.setDialogTitle(seleccion);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
                path = chooser.getSelectedFile().toString();
            }
        
    }//GEN-LAST:event_btnDirectorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDirectorio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtDirectorio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
