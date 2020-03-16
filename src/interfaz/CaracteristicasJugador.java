package interfaz;

import Pollitos.Jugadores;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mapa.CreacionJSON;
import mapa.CreacionMapa;

/**
 *
 * @author luisGonzalez
 */
public class CaracteristicasJugador extends javax.swing.JDialog {

    private ArrayList<Jugadores> misJugadores;
    private ArrayList<Planetas> planetas;
    private ArrayList<PlanetasNeutrales> listNeutrales; 
    private Integer primero = null;
    private Integer segundo = null;
    private Integer tercero = null;
    private JCheckBox alAzar;
    private JTextField filas, columnas;
    private CreacionJSON creacion;
    private JTextArea panelMensajes;
    private CreacionMapa mapa;
    private int contador;
    private JTextField txtNaves;
        
    /**
     * Creates new form CaracteristicasJugador
     *
     * @param parent
     * @param modal
     * @param misJugadores
     */
    public CaracteristicasJugador(java.awt.Frame parent, boolean modal, ArrayList<Jugadores> misJugadores, ArrayList<Planetas> planetas, JCheckBox alAzar, JTextField filas, JTextField columnas, JTextArea panelMensajes, CreacionMapa mapa, ArrayList<PlanetasNeutrales> listNeutrales, int contador, JTextField txtNaves) {
        super(parent, modal);
        initComponents();
        this.misJugadores = misJugadores;
        this.planetas = planetas;
        this.alAzar = alAzar;
        this.filas = filas;
        this.columnas = columnas;
        this.mapa = mapa;
        this.contador = contador;
        this.panelMensajes = panelMensajes;
        this.listNeutrales = listNeutrales;
        this.txtNaves = txtNaves;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnColor = new javax.swing.JButton();
        panelColor = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt1.setText("Nombre:");

        txt2.setText("Tipo:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnColor.setText("Elige un color");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColorLayout = new javax.swing.GroupLayout(panelColor);
        panelColor.setLayout(panelColorLayout);
        panelColorLayout.setHorizontalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        panelColorLayout.setVerticalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        btnAceptar.setText("Confirmar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACIL", "DIFICIL", "HUMANO" }));

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(panelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnColor)
                        .addGap(18, 18, 18)
                        .addComponent(panelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAceptar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        creacion = new CreacionJSON(panelMensajes, mapa, contador, txtNaves);
        if (txtNombre.getText().equals("") || primero == null || segundo == null || tercero == null) {
            JOptionPane.showMessageDialog(null, "Falta llenar un parametro");
        } else {
            if(!alAzar.isSelected()){
                Jugadores jugador = new Jugadores();
                Planetas planeta = new Planetas();
                seteoJugadores(jugador);
                seteoPrimerPlaneta(planeta, jugador);
                misJugadores.add(jugador);
                planetas.add(planeta);
                this.dispose();
            } else {
                if(filas.getText().equals("") || columnas.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Azar activado: debess llenar los parametros de fila y columna para continuar");
                } else {
                    int filaConver = Integer.parseInt(filas.getText());
                    int columnaConver = Integer.parseInt(columnas.getText());
                    Jugadores jugador = new Jugadores();
                    seteoJugadores(jugador);
                    misJugadores.add(jugador);
                    creacion.atributosPlanetasJugadorAzar(jugador, listNeutrales, planetas, filaConver, columnaConver);
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private Jugadores seteoJugadores(Jugadores jugador) {
        jugador.setNombre(txtNombre.getText());
        jugador.setTipo(comboTipo.getSelectedItem().toString());
        jugador.setColor(primero + "," + segundo + "," + tercero + ",75");
        jugador.setPlanetas(new ArrayList<>());
        int nombrePlaneta = planetas.size()+1;
        jugador.getPlanetas().add("P" + Integer.toString(nombrePlaneta));
        return jugador;
    }
    
    private Planetas seteoPrimerPlaneta(Planetas planeta, Jugadores jugador){
        planeta.setNombre(jugador.getPlanetas().get(0));
        planeta.setColor(jugador.getColor());
        planeta.setInterruptor(false);
        return planeta;
    }


    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        Color color = JColorChooser.showDialog(rootPane, "Elige un color", this.getBackground());
        tercero = color.getBlue();
        segundo = color.getGreen();
        primero = color.getRed();
        panelColor.setBackground(color);

    }//GEN-LAST:event_btnColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnColor;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
