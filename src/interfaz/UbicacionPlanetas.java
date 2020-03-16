package interfaz;

import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author luisGonzalez
 */
public class UbicacionPlanetas extends javax.swing.JDialog {

    private ArrayList<Planetas> listPlanetas;
    private ArrayList<PlanetasNeutrales> listNeutrales;
    private int posX, posY;
    private JLabel casilla;
    private JLabel[][] matrizPrevia;

    /**
     * Creates new form UbicacionPlanetas
     */
    public UbicacionPlanetas(java.awt.Frame parent, boolean modal, ArrayList<Planetas> listPlanetas, ArrayList<PlanetasNeutrales> listNeutrales, int posX, int posY, JLabel casilla, JLabel[][] matrizPrevia) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.listNeutrales = listNeutrales;
        this.listPlanetas = listPlanetas;
        this.posX = posX;
        this.posY = posY;
        this.casilla = casilla;
        this.matrizPrevia = matrizPrevia;
        for (int i = 0; i < listNeutrales.size(); i++) {
            if (listNeutrales.get(i).isInterruptor() == false) {
                comboPlanetas.addItem(listNeutrales.get(i).getNombre());
            }
        }
        for (int i = 0; i < listPlanetas.size(); i++) {
            if (listPlanetas.get(i).isInterruptor() == false) {
                comboPlanetas.addItem(listPlanetas.get(i).getNombre());
            }
        }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        comboPlanetas = new javax.swing.JComboBox<>();
        lblNaves = new javax.swing.JLabel();
        lblProduccion = new javax.swing.JLabel();
        lblPMuertes = new javax.swing.JLabel();
        txtNaves = new javax.swing.JTextField();
        txtProduccion = new javax.swing.JTextField();
        txtPMuertes = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaves.setText("Naves:");

        lblProduccion.setText("Produccion:");

        lblPMuertes.setText("Porcentaje Muertes:");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboPlanetas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFondoLayout.createSequentialGroup()
                            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblProduccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(lblNaves, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lblPMuertes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(57, 57, 57)
                            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPMuertes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNaves, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(txtProduccion)))))
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboPlanetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaves)
                    .addComponent(txtNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduccion)
                    .addComponent(txtProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPMuertes)
                    .addComponent(txtPMuertes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (txtNaves.getText().equals("") || txtProduccion.getText().equals("") || txtPMuertes.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan parametros por llenar");
        } else {
            boolean interruptor = false;
            boolean interruptor2 = false;
            int concordancia = 0;
            if (!listNeutrales.isEmpty()) {
                for (int i = 0; i < listNeutrales.size(); i++) {
                    if (listNeutrales.get(i).getNombre().equals(comboPlanetas.getSelectedItem()) && listNeutrales.get(i).isInterruptor() == false) {
                        concordancia = i;
                        interruptor = true;
                        break;
                    }
                }
            }
            if (!listPlanetas.isEmpty()) {
                if (interruptor == false) {
                    for (int i = 0; i < listPlanetas.size(); i++) {
                        if (listPlanetas.get(i).getNombre().equals(comboPlanetas.getSelectedItem()) && listPlanetas.get(i).isInterruptor() == false) {
                            concordancia = i;
                            interruptor2 = true;
                            break;
                        }
                    }
                }
            }
            if (interruptor == true) {
                PlanetasNeutrales neutral = new PlanetasNeutrales();
                neutral.setNombre(comboPlanetas.getSelectedItem().toString());
                neutral.setNaves(txtNaves.getText());
                neutral.setProduccion(txtProduccion.getText());
                neutral.setPorcentajeMuertes(txtPMuertes.getText());
                neutral.setInterruptor(true);
                neutral.setPosicionX(Integer.toString(posY));
                neutral.setPosicionY(Integer.toString(posX));
                listNeutrales.set(concordancia, neutral);
                pintarCasilla2();
           } else if (interruptor2 == true) {
                Planetas planeta = new Planetas();
                planeta.setNombre(comboPlanetas.getSelectedItem().toString());
                planeta.setNaves(txtNaves.getText());
                planeta.setColor(listPlanetas.get(concordancia).getColor());
                planeta.setProduccion(txtProduccion.getText());
                planeta.setPorcentajeMuertes(txtPMuertes.getText());
                planeta.setInterruptor(true);
                planeta.setPosicionX(Integer.toString(posY));
                planeta.setPosicionY(Integer.toString(posX));
                listPlanetas.set(concordancia, planeta);
                pintarCasilla(listPlanetas.get(concordancia).getColor());
        }
            this.dispose();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public void pintarCasilla(String color) {
            String[] valores = color.split(",");
            int[] convertidos = new int[valores.length];
            for (int i = 0; i < valores.length; i++) {
                convertidos[i] = Integer.parseInt(valores[i]);
            }
            matrizPrevia[posX][posY].setBackground(new Color(convertidos[0], convertidos[1], convertidos[2]));
            matrizPrevia[posX][posY].setBorder(new LineBorder(Color.black));
        
    }
    
    public void pintarCasilla2(){
        matrizPrevia[posX][posY].setBackground(new Color(128, 128, 128));
        matrizPrevia[posX][posY].setBorder(new LineBorder(Color.black));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> comboPlanetas;
    private javax.swing.JLabel lblNaves;
    private javax.swing.JLabel lblPMuertes;
    private javax.swing.JLabel lblProduccion;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtNaves;
    private javax.swing.JTextField txtPMuertes;
    private javax.swing.JTextField txtProduccion;
    // End of variables declaration//GEN-END:variables
}
