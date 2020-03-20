package interfaz;

import Pollitos.Juego;
import Pollitos.Jugadores;
import Pollitos.Mapa;
import Pollitos.NavesCamino;
import Pollitos.Planetas;
import Pollitos.PlanetasNeutrales;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import mapa.CreacionJSON;
import mapa.CreacionMapa;
import mapa.MiniMapa;

/**
 *
 * @author luisGonzalez
 */
public class VentanaNuevoJuego extends javax.swing.JDialog {

    private ArrayList<Jugadores> misJugadores = new ArrayList<>();
    private CreacionJSON creacion;
    private ArrayList<Planetas> planetas = new ArrayList<>();
    private ArrayList<PlanetasNeutrales> neutrales = new ArrayList<>();
    private final DefaultTableModel dtmModelNeutral;
    private DefaultTableModel dtmModelJugadores;
    private int i, j;
    private CreacionMapa mapa;
    private JTextArea panelMensajes;
    private MiniMapa mapita;
    private int contador;
    private JTextField txtNaves;
    private ArrayList<Juego> datosJuego;
    private JButton btnTurno;
    private ArrayList<NavesCamino> listNaves;
    private JButton btnDistancia;
    private JPanel panelJuego2;
    private JButton btnFlotas;
    //private JLabel[][] matrizPrevia;

    /**
     * Creates new form VentanaNuevoJuego
     *
     * @param parent
     * @param modal
     * @param mapa
     * @param panelMensajes
     */
    public VentanaNuevoJuego(java.awt.Frame parent, boolean modal, CreacionMapa mapa, JTextArea panelMensajes, int contador, JTextField txtNaves, ArrayList<Juego> datosJuego, JButton btnTurno, ArrayList<NavesCamino> listNaves, JPanel panelJuego2, JButton btnDistancia, JButton btnFlotas) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.mapa = mapa;
        this.contador = contador;
        this.btnDistancia = btnDistancia;
        this.btnFlotas = btnFlotas;
        this.btnTurno = btnTurno;
        this.listNaves = listNaves;
        this.panelMensajes = panelMensajes;
        this.txtNaves = txtNaves;
        this.datosJuego = datosJuego;
        this.panelJuego2 = panelJuego2;
        dtmModelNeutral = (DefaultTableModel) tablaNeutrales.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        btnAgregarJugador = new javax.swing.JButton();
        btnEliminarJugador = new javax.swing.JButton();
        panelMapa = new javax.swing.JPanel();
        titulo2 = new javax.swing.JLabel();
        lblFilas = new javax.swing.JLabel();
        lblColumnas = new javax.swing.JLabel();
        txtFilas = new javax.swing.JTextField();
        txtColumnas = new javax.swing.JTextField();
        lblMapa = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNeutrales = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNeutrales = new javax.swing.JTable();
        btnANeutral = new javax.swing.JButton();
        btnENeutral = new javax.swing.JButton();
        checkAzar = new javax.swing.JCheckBox();
        btnNuevoNeutral = new javax.swing.JButton();
        checkNaves = new javax.swing.JCheckBox();
        checkStats = new javax.swing.JCheckBox();
        spinProduccion = new javax.swing.JSpinner();
        lblProduccion = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkMapaCiego = new javax.swing.JCheckBox();
        checkAcumular = new javax.swing.JCheckBox();
        spinFinalizacion = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        panelPrevio = new javax.swing.JPanel();
        btnPrevio = new javax.swing.JButton();
        lblDato1 = new javax.swing.JLabel();
        lblDato2 = new javax.swing.JLabel();
        lblDato3 = new javax.swing.JLabel();
        txtDato1 = new javax.swing.JTextField();
        txtDato2 = new javax.swing.JTextField();
        txtDato3 = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        lblDato4 = new javax.swing.JLabel();
        txtDato4 = new javax.swing.JTextField();
        lblPosX = new javax.swing.JLabel();
        lblPosY = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        txtY = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDirectorio = new javax.swing.JButton();
        txtDirectorio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJuego.setBackground(new java.awt.Color(255, 255, 255));

        titulo1.setFont(new java.awt.Font("Manjari Thin", 0, 14)); // NOI18N
        titulo1.setText("Jugadores:");

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador:", "Tipo:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaJugadores);

        btnAgregarJugador.setText("Agregar");
        btnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugadorActionPerformed(evt);
            }
        });

        btnEliminarJugador.setText("Eliminar");

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                                .addComponent(btnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(btnEliminarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarJugador)
                    .addComponent(btnEliminarJugador))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 270, 570));

        panelMapa.setBackground(new java.awt.Color(255, 255, 255));

        titulo2.setFont(new java.awt.Font("Manjari Thin", 0, 14)); // NOI18N
        titulo2.setText("Mapa:");

        lblFilas.setText("Filas");

        lblColumnas.setText("Columnas");

        txtFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilasActionPerformed(evt);
            }
        });

        lblMapa.setFont(new java.awt.Font("Manjari Thin", 0, 14)); // NOI18N
        lblMapa.setText("Mapa:");

        lblNombre.setText("Nombre:");

        lblNeutrales.setFont(new java.awt.Font("Manjari Thin", 0, 14)); // NOI18N
        lblNeutrales.setText("Planetas Neutrales:");

        tablaNeutrales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tablaNeutrales);

        btnANeutral.setText("Agregar");
        btnANeutral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANeutralActionPerformed(evt);
            }
        });

        btnENeutral.setText("Eliminar");
        btnENeutral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnENeutralActionPerformed(evt);
            }
        });

        checkAzar.setText("Al azar");
        checkAzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAzarActionPerformed(evt);
            }
        });

        btnNuevoNeutral.setText("Confirmar");
        btnNuevoNeutral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoNeutralActionPerformed(evt);
            }
        });

        checkNaves.setText("Mostrar naves");

        checkStats.setText("Mostrar Estadisticas");

        lblProduccion.setText("Produccion");

        javax.swing.GroupLayout panelMapaLayout = new javax.swing.GroupLayout(panelMapa);
        panelMapa.setLayout(panelMapaLayout);
        panelMapaLayout.setHorizontalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMapaLayout.createSequentialGroup()
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMapaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMapaLayout.createSequentialGroup()
                                .addComponent(lblMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(243, 243, 243)
                                .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMapaLayout.createSequentialGroup()
                                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFilas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblColumnas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFilas)
                                    .addComponent(txtColumnas)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                            .addComponent(lblNeutrales, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkAzar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMapaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMapaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevoNeutral, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMapaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMapaLayout.createSequentialGroup()
                                .addComponent(btnANeutral, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnENeutral, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(checkNaves, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkStats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                    .addGroup(panelMapaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMapaLayout.setVerticalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMapaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilas)
                    .addComponent(txtFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColumnas)
                    .addComponent(txtColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkAzar)
                .addGap(20, 20, 20)
                .addComponent(lblNeutrales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkNaves)
                .addGap(14, 14, 14)
                .addComponent(checkStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnANeutral)
                    .addComponent(btnENeutral))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnNuevoNeutral)
                .addGap(20, 20, 20))
        );

        getContentPane().add(panelMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 320, 570));

        panelOpciones.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Manjari Thin", 0, 14)); // NOI18N
        jLabel1.setText("Opciones:");

        checkMapaCiego.setText("Mapa ciego");

        checkAcumular.setText("Acumular");

        jLabel2.setText("Finalizacion");

        javax.swing.GroupLayout panelPrevioLayout = new javax.swing.GroupLayout(panelPrevio);
        panelPrevio.setLayout(panelPrevioLayout);
        panelPrevioLayout.setHorizontalGroup(
            panelPrevioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
        panelPrevioLayout.setVerticalGroup(
            panelPrevioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        btnPrevio.setText("VIsta Previa");
        btnPrevio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevioActionPerformed(evt);
            }
        });

        lblDato1.setText("Produccion:");

        lblDato2.setText("Naves:");

        lblDato3.setText("Porcentaje Muertes:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblDato4.setText("Nombre:");

        lblPosX.setText("X:");

        lblPosY.setText("Y:");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPrevio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                            .addComponent(spinFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addComponent(checkAcumular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkMapaCiego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPrevio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblDato1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDato2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDato3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDato4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                                        .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtY)
                            .addComponent(txtDato4)
                            .addComponent(txtDato3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDato2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDato1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkMapaCiego)
                .addGap(18, 18, 18)
                .addComponent(checkAcumular)
                .addGap(18, 18, 18)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnPrevio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDato1)
                    .addComponent(txtDato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDato2)
                    .addComponent(txtDato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDato3)
                    .addComponent(txtDato3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDato4)
                    .addComponent(txtDato4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addGap(27, 27, 27))
        );

        getContentPane().add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 270, 570));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 140, -1));

        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 140, -1));

        btnDirectorio.setText("Directorio:");
        btnDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectorioActionPerformed(evt);
            }
        });
        getContentPane().add(btnDirectorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 120, -1));

        txtDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirectorioActionPerformed(evt);
            }
        });
        getContentPane().add(txtDirectorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 460, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugadorActionPerformed
        creacion = new CreacionJSON(panelMensajes, mapa, contador, txtNaves);
        CaracteristicasJugador jugador = new CaracteristicasJugador(null, true, misJugadores, planetas, checkAzar, txtFilas, txtColumnas, panelMensajes, mapa, neutrales, contador, txtNaves);
        jugador.setVisible(true);
        dtmModelJugadores = (DefaultTableModel) tablaJugadores.getModel();
        Object[] filas = new Object[dtmModelJugadores.getColumnCount()];
        int nuevo = misJugadores.size();
        if (!misJugadores.isEmpty()) {
            filas[0] = misJugadores.get(nuevo - 1).getNombre();
            filas[1] = misJugadores.get(nuevo - 1).getTipo();
            dtmModelJugadores.addRow(filas);
        }
    }//GEN-LAST:event_btnAgregarJugadorActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean verificador;
        Mapa mapita = new Mapa();
        if (txtNombre.getText().equals("") || txtFilas.getText().equals("") || txtColumnas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan parametros por llenar");
        } else {
            mapita = creacion.seteoDatosMapa(neutrales, planetas, misJugadores, mapita, txtNombre.getText(), txtFilas.getText(), txtColumnas.getText(), checkAzar, checkMapaCiego, checkAcumular, checkNaves, checkStats, spinProduccion, spinFinalizacion);
            if (txtDirectorio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Aun no decides donde guardar tu partida");
            } else {
                verificador = creacion.crearArchivoJSON(mapita, misJugadores, planetas, neutrales, txtDirectorio.getText(), datosJuego, btnTurno, listNaves, panelJuego2, btnDistancia, btnFlotas);
                if (verificador == true) {
                    this.dispose();
                }
            }
        }


    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnENeutralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnENeutralActionPerformed
        if (dtmModelNeutral.getRowCount() > 0) {
            int filas = dtmModelNeutral.getRowCount();
            dtmModelNeutral.removeRow(filas - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Ya no hay filas para borrar");
        }
    }//GEN-LAST:event_btnENeutralActionPerformed

    private void btnANeutralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANeutralActionPerformed
        if (!checkAzar.isSelected()) {
            dtmModelNeutral.addRow(new Object[]{});

        } else {
            JOptionPane.showMessageDialog(null, "La opcion azar esta seleccionada");
        }
    }//GEN-LAST:event_btnANeutralActionPerformed

    private void checkAzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAzarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAzarActionPerformed

    private void btnPrevioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevioActionPerformed
        panelPrevio.removeAll();
        if (txtFilas.getText().equals("") || txtColumnas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan parametros por llenar");
        } else {
            int filas = Integer.parseInt(txtFilas.getText());
            int columnas = Integer.parseInt(txtColumnas.getText());
            JLabel[][] matrizPrevia = new JLabel[filas][columnas];
            panelPrevio.setLayout(new GridLayout(filas, columnas));
            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    JLabel previo = new JLabel();
                    previo.setOpaque(true);
                    if (!checkAzar.isSelected()) {
                        previo.setBackground(Color.white);
                        previo.setBorder(new LineBorder(Color.black));
                        mapita = new MiniMapa();
                        mapita.seteoFalsoInterruptores(planetas, neutrales);
                        matrizPrevia[i][j] = previo;
                        matrizPrevia[i][j].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent event) {
                                for (int k = 0; k < i; k++) {
                                    for (int l = 0; l < j; l++) {
                                        if (previo == matrizPrevia[k][l]) {
                                            if (Color.white.equals(previo.getBackground())) {
                                                UbicacionPlanetas ubicacion = new UbicacionPlanetas(null, true, planetas, neutrales, k, l, previo, matrizPrevia);
                                                ubicacion.setVisible(true);
                                            } else {
                                                datosPlanetas(k, l);
                                            }
                                        }
                                    }
                                }

                            }
                        });

                    } else {
                        previo.setBackground(Color.white);
                        mapita = new MiniMapa();
                        mapita.seteoFalsoInterruptores(planetas, neutrales);
                        for (int k = 0; k < neutrales.size(); k++) {
                            if (j == Integer.parseInt(neutrales.get(k).getPosicionX()) && i == Integer.parseInt(neutrales.get(k).getPosicionY())) {
                                if (neutrales.get(k).isInterruptor() == false) {
                                    previo.setBackground(new Color(128, 128, 128));
                                    neutrales.get(k).setInterruptor(true);
                                }
                            }
                        }
                        for (int k = 0; k < planetas.size(); k++) {
                            if (j == Integer.parseInt(planetas.get(k).getPosicionX()) && i == Integer.parseInt(planetas.get(k).getPosicionY())) {
                                if (planetas.get(k).isInterruptor() == false) {
                                    String[] valores = planetas.get(k).getColor().split(",");
                                    int[] convertido = new int[valores.length];
                                    for (int i = 0; i < valores.length; i++) {
                                        convertido[i] = Integer.parseInt(valores[i]);
                                    }
                                    previo.setBackground(new Color(convertido[0], convertido[1], convertido[2]));
                                    planetas.get(k).setInterruptor(true);
                                }
                            }
                        }

                        previo.setBorder(new LineBorder(Color.black));
                        matrizPrevia[i][j] = previo;
                        matrizPrevia[i][j].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent event) {
                                for (int k = 0; k < i; k++) {
                                    for (int l = 0; l < j; l++) {
                                        if (previo == matrizPrevia[k][l]) {
                                            if (!Color.white.equals(previo.getBackground())) {
                                                datosPlanetas(k, l);
                                            }
                                        }
                                    }
                                }

                            }
                        });

                    }

                    panelPrevio.add(matrizPrevia[i][j]);
                    panelPrevio.validate();
                    panelPrevio.repaint();
                }
            }
        }
    }//GEN-LAST:event_btnPrevioActionPerformed

    public void datosPlanetas(int posX, int posY) {
        boolean interruptor = false;
        boolean interruptor2 = false;
        int nodo = 0;
        for (int k = 0; k < planetas.size(); k++) {
            int x = Integer.parseInt(planetas.get(k).getPosicionX());
            int y = Integer.parseInt(planetas.get(k).getPosicionY());
            if (posY == x && posX == y) {
                nodo = k;
                interruptor = true;
                break;
            }
        }
        if (interruptor == false) {
            for (int k = 0; k < neutrales.size(); k++) {
                int x = Integer.parseInt(neutrales.get(k).getPosicionX());
                int y = Integer.parseInt(neutrales.get(k).getPosicionY());
                if (posY == x && posX == y) {
                    nodo = k;
                    interruptor2 = true;
                    break;
                }
            }
        }
        if (interruptor == true) {
            txtDato1.setText(planetas.get(nodo).getProduccion());
            txtDato2.setText(planetas.get(nodo).getNaves());
            txtDato3.setText(planetas.get(nodo).getPorcentajeMuertes());
            txtDato4.setText(planetas.get(nodo).getNombre());
            txtX.setText(planetas.get(nodo).getPosicionX());
            txtY.setText(planetas.get(nodo).getPosicionY());
        } else if (interruptor2 == true) {
            txtDato1.setText(neutrales.get(nodo).getProduccion());
            txtDato2.setText(neutrales.get(nodo).getNaves());
            txtDato3.setText(neutrales.get(nodo).getPorcentajeMuertes());
            txtDato4.setText(neutrales.get(nodo).getNombre());
            txtX.setText(neutrales.get(nodo).getPosicionX());
            txtY.setText(neutrales.get(nodo).getPosicionY());
        }
    }


    private void txtFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilasActionPerformed
    }//GEN-LAST:event_txtFilasActionPerformed

    private void btnNuevoNeutralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoNeutralActionPerformed
        neutrales.clear();
        creacion = new CreacionJSON(panelMensajes, mapa, contador, txtNaves);
        if (!checkAzar.isSelected()) {
            int filasTabla2 = dtmModelNeutral.getRowCount();
            for (int a = 0; a < filasTabla2; a++) {
                PlanetasNeutrales planeta = new PlanetasNeutrales();
                planeta.setNombre(dtmModelNeutral.getValueAt(a, 0).toString());
                planeta.setInterruptor(false);
                neutrales.add(planeta);
            }
        } else {
            int filasTabla = dtmModelNeutral.getRowCount() - 1;
            for (int k = filasTabla; k >= 0; k--) {
                dtmModelNeutral.removeRow(k);
            }
            if (txtFilas.getText().equals("") || txtColumnas.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes llenar los parametros filas y columnas");
            } else {
                int filasTotales = Integer.parseInt(txtFilas.getText());
                int columnasTotales = Integer.parseInt(txtColumnas.getText());
                creacion.caracteristicasAlAzar(planetas, filasTotales, columnasTotales, neutrales, spinProduccion.getValue().toString());
                Object[] filas = new Object[dtmModelNeutral.getColumnCount()];
                for (int k = 0; k < neutrales.size(); k++) {
                    filas[0] = neutrales.get(k).getNombre();
                    dtmModelNeutral.addRow(filas);
                }
                for (int k = 0; k < neutrales.size(); k++) {
                    System.out.println(neutrales.get(k).getNombre());
                }
            }
        }
    }//GEN-LAST:event_btnNuevoNeutralActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectorioActionPerformed
        JFileChooser chooser = new JFileChooser();
        String path = "";
        String seleccion = "Seleccione la carpeta donde desea guardar su archivo de juego";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().toString();
            txtDirectorio.setText(path);
        }
    }//GEN-LAST:event_btnDirectorioActionPerformed

    private void txtDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirectorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirectorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnANeutral;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarJugador;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDirectorio;
    private javax.swing.JButton btnENeutral;
    private javax.swing.JButton btnEliminarJugador;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoNeutral;
    private javax.swing.JButton btnPrevio;
    private javax.swing.JCheckBox checkAcumular;
    private javax.swing.JCheckBox checkAzar;
    private javax.swing.JCheckBox checkMapaCiego;
    private javax.swing.JCheckBox checkNaves;
    private javax.swing.JCheckBox checkStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblColumnas;
    private javax.swing.JLabel lblDato1;
    private javax.swing.JLabel lblDato2;
    private javax.swing.JLabel lblDato3;
    private javax.swing.JLabel lblDato4;
    private javax.swing.JLabel lblFilas;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblNeutrales;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPosX;
    private javax.swing.JLabel lblPosY;
    private javax.swing.JLabel lblProduccion;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPrevio;
    private javax.swing.JSpinner spinFinalizacion;
    private javax.swing.JSpinner spinProduccion;
    private javax.swing.JTable tablaJugadores;
    private javax.swing.JTable tablaNeutrales;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JTextField txtColumnas;
    private javax.swing.JTextField txtDato1;
    private javax.swing.JTextField txtDato2;
    private javax.swing.JTextField txtDato3;
    private javax.swing.JTextField txtDato4;
    private javax.swing.JTextField txtDirectorio;
    private javax.swing.JTextField txtFilas;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
}
