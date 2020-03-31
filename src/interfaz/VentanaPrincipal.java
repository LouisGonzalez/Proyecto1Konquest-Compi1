package interfaz;

import AccionesComputadora.InteligenciaArtificial;
import Pollitos.AccionesOnline;
import Pollitos.Auxiliar;
import Pollitos.Juego;
import Pollitos.NavesCamino;
import Pollitos.Replay;
import Pollitos.Resultados;
import gramaticas.AnalizadorLexico;
import gramaticas.SintaxCreacionMapa;
import gramaticas2.AnalizadorLexico2;
import gramaticas2.SintaxGuardarPartida;
import gramaticas3.AnalizadorLexico3;
import gramaticas3.SintaxReplay;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mapa.CondicionesIniciales;
import mapa.CreacionMapa;
import mapa.GuardarPartida;
import mapa.Jugabilidad;
import replay.AccionesTurno;
import replay.CreacionArchivoREPLAY;
import online.*;

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private File proyecto;
    private boolean soyAdder = false;
    private boolean soyHost = false;
    private String archivo;
    public CreacionMapa mapa;
    public static JLabel[][] tablero;
    public String path = "";
    private static Juego juego = null;
    private AccionesOnline datosOnline = null;
    public static int contador = 0;
    public static int contadorTurnos = 0;
    public static int clicksDistancia = 0;
    public static String textoOnline = "";
    public static String textoReplay = "";
    public static String aux = "";
    public static String aux2 = "";
    public static String aux3 = "";
    public String pathReplay = "";
    public boolean partidaOnline = false;
    public static boolean errorLexico = false;
    private ArrayList<Juego> datosJuego = new ArrayList<>();
    private ArrayList<NavesCamino> listNaves = new ArrayList<>();
    private ArrayList<Resultados> finales = new ArrayList<>();
    private ArrayList<Replay> listReplay = new ArrayList<>();
    private Jugabilidad jugabilidad;
    private CondicionesIniciales cambioDatos;
    private InteligenciaArtificial computadora;
    private GuardarPartida guardar;
    private CreacionArchivoREPLAY archivoReplay;
    private Validaciones validacionesOnline;
    private AccionesTurno acciones;

    public VentanaPrincipal() {
        initComponents();
        txtNaves.setEditable(false);
        panelJuego.setBackground(new Color(255, 255, 255, 100));
        panelJuego.setVisible(false);
        panelFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")));
        jugabilidad = new Jugabilidad();
        validacionesOnline = new Validaciones();
        computadora = new InteligenciaArtificial();
        acciones = new AccionesTurno();
        cambioDatos = new CondicionesIniciales();
        guardar = new GuardarPartida();
        archivoReplay = new CreacionArchivoREPLAY();
        mapa = new CreacionMapa(this.panelJuego, jugabilidad);
        setLocationRelativeTo(null);
        lblTurno.setText("Turno: " + contadorTurnos);
        btnTurno.setEnabled(false);
        btnDistancia.setToolTipText("Clickea de un planeta a otro para saber la distancia que tienen en años luz");
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
        btnFlotas = new javax.swing.JButton();
        btnDistancia = new javax.swing.JButton();
        lblDistancia = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemNuevo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemLectura = new javax.swing.JMenuItem();
        opcionesGuardar = new javax.swing.JMenu();
        guardar1 = new javax.swing.JMenuItem();
        guardar2 = new javax.swing.JMenuItem();
        guardarReplay = new javax.swing.JMenuItem();
        replay = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        online = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        opcionHost = new javax.swing.JMenuItem();
        opcionAdder = new javax.swing.JMenuItem();

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
        getContentPane().add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 160, 20));
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

        btnFlotas.setText("Vista flotas");
        btnFlotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlotasActionPerformed(evt);
            }
        });

        btnDistancia.setText("Calcular distancia");
        btnDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistanciaActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar partida");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lblDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFlotas, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(btnDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNaves, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador)
                    .addComponent(btnFlotas)
                    .addComponent(btnFinalizar))
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTurno)
                            .addComponent(txtNaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDistancia))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        opcionesGuardar.setText("Guardar juego");

        guardar1.setText("Guardar como...");
        guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar1ActionPerformed(evt);
            }
        });
        opcionesGuardar.add(guardar1);

        guardar2.setText("Guardar");
        guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar2ActionPerformed(evt);
            }
        });
        opcionesGuardar.add(guardar2);

        itemNuevo.add(opcionesGuardar);

        guardarReplay.setText("Guardar replay");
        guardarReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarReplayActionPerformed(evt);
            }
        });
        itemNuevo.add(guardarReplay);

        replay.setText("Replay de una partida");
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });
        itemNuevo.add(replay);

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("Crear conexion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Esperar conexion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        itemNuevo.add(jMenu1);

        online.setText("Online");
        online.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlineActionPerformed(evt);
            }
        });
        itemNuevo.add(online);

        jMenuBar1.add(itemNuevo);

        jMenu2.setText("Online");

        opcionHost.setText("Host");
        opcionHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionHostActionPerformed(evt);
            }
        });
        jMenu2.add(opcionHost);

        opcionAdder.setText("adder");
        opcionAdder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAdderActionPerformed(evt);
            }
        });
        jMenu2.add(opcionAdder);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        juego = new Juego();
        VentanaNuevoJuego nuevo = new VentanaNuevoJuego(this, true, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas);
        nuevo.setVisible(true);
        if (!datosJuego.isEmpty()) {
            juego = datosJuego.get(0);
            datosJuego.clear();
            computadora.verificadorTipoInteligencia(juego, listNaves);

        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLecturaActionPerformed
        if (juego == null) {
            juego = new Juego();
            datosJuego.clear();
            JFileChooser chooser = new JFileChooser();
            panelMensajes.setText("");
            SintaxCreacionMapa.totalErrores = "";
            String seleccion = "Seleccione el JSON para abrir el juego";
            chooser.setCurrentDirectory(new File("."));
            chooser.setDialogTitle(seleccion);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                path = chooser.getCurrentDirectory().toString();
                System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
                // archivoPrincipal = chooser.getSelectedFile().toString();
                proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
                archivo = proyecto.toString();
                if (archivo.endsWith(".JSON")) {
                    FileReader fr;
                    BufferedReader entrada;
                    String texto = "";
                    try {
                        fr = new FileReader(proyecto);
                        entrada = new BufferedReader(fr);
                        while (entrada.ready()) {
                            texto += entrada.readLine() + "\n";
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                    AnalizadorLexico2 lexico2 = new AnalizadorLexico2(new StringReader(texto));
                    try {
                        /* new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas).parse();
                    System.out.println(textoReplay);
                    if (!datosJuego.isEmpty()) {
                        juego = datosJuego.get(0);
                        computadora.verificadorTipoInteligencia(juego, listNaves);
                    }*/

                        errorLexico = false;
                        new SintaxGuardarPartida(lexico2, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas).parse();
                        System.out.println(textoReplay);
                        if (!datosJuego.isEmpty()) {
                            juego = datosJuego.get(0);
                            computadora.verificadorTipoInteligencia(juego, listNaves);
                        }
                        if (errorLexico == false) {
                            lblTurno.setText("Turno: " + contadorTurnos);
                        } else {
                            panelJuego.removeAll();
                            panelJuego.setVisible(false);
                            juego = null;
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "ERROR");
                        panelMensajes.setText(SintaxGuardarPartida.totalErrores);
                    }
                } else {
                    System.out.println("no es un archivo compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay una partida pendiente por favor finalizala para continuar.");
        }
    }//GEN-LAST:event_itemLecturaActionPerformed

    private void txtNavesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNavesKeyTyped
        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNavesKeyTyped

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed
        if (partidaOnline) {
            contador++;
            if (txtNaves.isEditable()) {
                verificadorPlanetasJugador();
                if (contador == juego.getJugadores().size()) {
                    contadorTurnos++;
                    contador = 0;
                    String texto = panelMensajes.getText();
                    String mensaje = texto + "Turno: " + contadorTurnos + "\n";
                    panelMensajes.setText(mensaje);
                    jugabilidad.verificacionNavesLlegada(listNaves, juego, panelMensajes);
                    if (juego.getMapa().getAcumular().equals("false")) {
                        cambioDatos.aumentoProduccion(juego);
                    } else {
                        cambioDatos.aumentoProduccionEn1(juego);
                    }
                    cambioDatos.verificarGanador(juego, panelJuego, finales);
                    verificadorPlanetasJugador();
                }
                lblTurno.setText("Turno: " + contadorTurnos);
                txtNaves.setText("");
                txtNaves.setEditable(false);
                btnTurno.setEnabled(false);

            }

            textoOnline += "SECUENCIAS {\n";
            textoOnline += "\tACCIONES {\n";
            textoOnline += aux;
            textoOnline += "\t}\n";
            aux = "";
            textoOnline += "\tRESUMEN {\n";
            archivoReplay.textoNeutral(juego);
            textoOnline += aux3;
            aux3 = "";
            textoOnline += "\t}\n";
            textoOnline += "\tGENERAL {\n";
            textoOnline += "\t   turnoJugador: " + contador + ",\n";
            textoOnline += "\t   turno: " + contadorTurnos + "\n";
            textoOnline += "\t}\n";
            textoOnline += "}";
            if (soyHost) {
                Cliente cliente = new Cliente(7000, textoOnline);
                Thread miHilo = new Thread(cliente);
                miHilo.start();

            } else if (soyAdder) {
                Cliente cliente = new Cliente(5000, textoOnline);
                Thread miHilo = new Thread(cliente);
                miHilo.start();

            }
            textoOnline = "";
        } else {
            if (txtNaves.isEditable() == false) {
            } else {
                if (contador == 0) {
                    if (juego.getJugadores().get(contador).getTipo().equals("HUMANO") && juego.getJugadores().get(contador).getEnJuego().equals("true")) {
                        if (contador == juego.getJugadores().size() - 1) {
                            //      textoReplay += "\t     ]\n";
                        } else {
                            //    textoReplay += "\t     ],\n";
                            //     textoReplay += "\t     " + juego.getJugadores().get(contador).getNombre() + "\n";
                        }
                        contador++;
                        verificadorPlanetasJugador();
                        recursividadComputadora();
                    }
                } else if (contador > 0) {
                    if (juego.getJugadores().get(contador).getTipo().equals("HUMANO") && juego.getJugadores().get(contador).getEnJuego().equals("true")) {
                        if (contador == juego.getJugadores().size() - 1) {
                            //        textoReplay += "\t     ]\n";
                        } else {
                            //      textoReplay += "\t     ],\n";
                            //      textoReplay += "\t     " + juego.getJugadores().get(contador).getNombre() + "\n";
                        }
                        contador++;
                        recursividadComputadora();
                        verificadorPlanetasJugador();
                    }
                }
            }
            if (contador == juego.getJugadores().size()) {
                archivoReplay.textoNeutral(juego);
                if (contadorTurnos > 0) {
                    textoReplay += "\t},\n";
                }
                textoReplay += "\tTURNO " + contadorTurnos + ": {\n";
                textoReplay += "\t   ACCIONES: {\n";
                textoReplay += aux;
                aux = "";
                textoReplay += "\t   }\n";
                textoReplay += "\t   IMPACTOS {\n";
                textoReplay += aux2;
                aux2 = "";
                textoReplay += "\t   }\n";
                textoReplay += "\t   RESUMEN {\n";
                textoReplay += aux3;
                aux3 = "";
                textoReplay += "\t   }\n";
                contadorTurnos++;

                contador = 0;
                String texto = panelMensajes.getText();
                String mensaje = texto + "Turno: " + contadorTurnos + "\n";
                panelMensajes.setText(mensaje);
                jugabilidad.verificacionNavesLlegada(listNaves, juego, panelMensajes);
                if (juego.getMapa().getAcumular().equals("false")) {
                    cambioDatos.aumentoProduccion(juego);
                } else {
                    cambioDatos.aumentoProduccionEn1(juego);
                }
                cambioDatos.verificarGanador(juego, panelJuego, finales);
                verificadorPlanetasJugador();
                recursividadComputadora();
            }
            lblTurno.setText("Turno: " + contadorTurnos);
            txtNaves.setText("");
            txtNaves.setEditable(false);
            btnTurno.setEnabled(false);
            System.out.println(textoReplay);
        }
    }//GEN-LAST:event_btnTurnoActionPerformed

    public static void notificarError(String mensaje) {
        panelMensajes.setText(mensaje);
        juego = null;
        panelJuego.removeAll();
        panelJuego.setVisible(false);
        errorLexico = true;
    }

    public void recursividadComputadora() {
        if (contador < juego.getJugadores().size()) {
            if (!juego.getJugadores().get(contador).getTipo().equals("HUMANO")) {
                computadora.verificadorTipoInteligencia(juego, listNaves);
                recursividadComputadora();
            }
        }
    }

    public void verificadorPlanetasJugador() {
        if (contador < juego.getJugadores().size()) {
            if (juego.getJugadores().get(contador).getEnJuego().equals("false") && juego.getJugadores().get(contador).getTipo().equals("HUMANO")) {
                contador++;
                verificadorPlanetasJugador();
            }
        }
    }

    private void btnFlotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlotasActionPerformed
        FlotasEnviadas flotas = new FlotasEnviadas(null, true, listNaves);
        flotas.setVisible(true);
    }//GEN-LAST:event_btnFlotasActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        if (partidaOnline == false) {
            InterfazGuardar guardar = new InterfazGuardar(null, true, juego, listNaves, panelJuego);
            guardar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No es posible guardar una partida en modo online");
        }
    }//GEN-LAST:event_guardar1ActionPerformed

    private void guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar2ActionPerformed
        if (partidaOnline == false) {
            if (juego == null) {
                JOptionPane.showMessageDialog(null, "No hay una partida en proceso para ser guardada");
            } else {
                guardar.repartirPlanetas(juego);
                guardar.crearJSON(juego, listNaves, archivo);
                JOptionPane.showMessageDialog(null, "El archivo de entrada ha sido modificado con exito");
                panelJuego.removeAll();
                panelJuego.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las partidas online no pueden ser guardadas.");
        }
    }//GEN-LAST:event_guardar2ActionPerformed

    private void btnDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistanciaActionPerformed
        clicksDistancia++;
        btnDistancia.setEnabled(false);
        btnTurno.setEnabled(false);
        btnFlotas.setEnabled(false);
    }//GEN-LAST:event_btnDistanciaActionPerformed

    private void replayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayActionPerformed
        if (partidaOnline == false) {
            JFileChooser chooser = new JFileChooser();
            panelMensajes.setText("");
            String path = "";
            SintaxCreacionMapa.totalErrores = "";
            String seleccion = "Seleccione el JSON para abrir el juego";
            chooser.setCurrentDirectory(new File("."));
            chooser.setDialogTitle(seleccion);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
                proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
                path = chooser.getSelectedFile().toString();
                archivo = proyecto.toString();
                if (archivo.endsWith(".JSON")) {
                    FileReader fr;
                    BufferedReader entrada;
                    String texto = "";
                    try {
                        fr = new FileReader(proyecto);
                        entrada = new BufferedReader(fr);
                        while (entrada.ready()) {
                            texto += entrada.readLine() + "\n";
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    AnalizadorLexico3 lexico = new AnalizadorLexico3(new StringReader(texto));
                    try {

                        listNaves.clear();
                        new SintaxReplay(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas, listReplay).parse();
                        JOptionPane.showMessageDialog(null, "listo");
                        if (!listReplay.isEmpty()) {
                            acciones.lanzamientoFlotas(lblTurno, listReplay, juego, listNaves);
                        }

                        System.out.println(listNaves.size() + "sdss");

                    } catch (Exception ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "ERROR");
                        panelMensajes.setText(SintaxCreacionMapa.totalErrores);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No es posible buscar el replay de una partida online.");
        }
    }//GEN-LAST:event_replayActionPerformed

    private void guardarReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarReplayActionPerformed
        if (partidaOnline == false) {
            if (!path.equals("")) {
                /* textoReplay += "\t},\n";
                textoReplay += "\tTURNO " + contadorTurnos + ": {\n";
                textoReplay += "\t   ACCIONES: {\n";
                textoReplay += aux;
                aux = "";
                textoReplay += "\t   }\n";
                textoReplay += "\t   IMPACTOS {\n";
                textoReplay += aux2;
                aux2 = "";
                textoReplay += "\t   }\n";
                textoReplay += "\t   RESUMEN {\n";
                archivoReplay.textoNeutral(juego);
                textoReplay += aux3;
                aux3 = "";
                textoReplay += "\t   }\n";
                textoReplay += "\t}\n";*/
                System.out.println(textoReplay);
                archivoReplay.creacionJSON(path, juego);
            } else {
                textoReplay = "";
                JOptionPane.showMessageDialog(null, "No has abierto ningun juego para poder hacer replay.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No es posible guardar un replay en una partida online");
        }
    }//GEN-LAST:event_guardarReplayActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Enlace servidor = new Enlace();
        servidor.servidor(panelMensajes);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void onlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineActionPerformed
        datosJuego.clear();
        if (juego != null) {
            JOptionPane.showMessageDialog(null, "Hay un juego en proceso, finaliza partida para continuar");
        }
        JFileChooser chooser = validacionesOnline.abrirArchivo(juego, datosJuego, panelMensajes);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            path = chooser.getCurrentDirectory().toString();
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            archivo = proyecto.toString();
            if (archivo.endsWith(".JSON")) {
                String texto = validacionesOnline.validarArchivo(archivo, proyecto);
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    //      new SintaxOnline(lexico, panelMensajes, datosOnline).parse();
                    new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas).parse();
                    if (!datosJuego.isEmpty()) {
                        juego = datosJuego.get(0);
                    }
                    lblTurno.setText("Turno: " + contadorTurnos);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR");
                    //     panelMensajes.setText(SintaxCreacionMapa.totalErrores);
                }
            } else {
                System.out.println("no es un archivo compatible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }
    }//GEN-LAST:event_onlineActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (partidaOnline) {
            partidaOnline = false;
            soyAdder = false;
            soyHost = false;
        }
        listReplay = new ArrayList<>();
        panelJuego.removeAll();
        panelJuego.setVisible(false);
        textoReplay = "";
        JOptionPane.showMessageDialog(null, "Partida finalizada con exito.");
        panelMensajes.setText("");
        cambioDatos.verificacionPartidaFin(juego, panelJuego, finales);
        juego = null;        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void opcionHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionHostActionPerformed
        datosJuego.clear();
        if (juego != null) {
            JOptionPane.showMessageDialog(null, "Hay un juego en proceso, finaliza partida para continuar");
        }
        JFileChooser chooser = validacionesOnline.abrirArchivo(juego, datosJuego, panelMensajes);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            path = chooser.getCurrentDirectory().toString();
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            archivo = proyecto.toString();
            if (archivo.endsWith(".JSON")) {
                String texto = validacionesOnline.validarArchivo(archivo, proyecto);
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas).parse();
                    if (!datosJuego.isEmpty()) {
                        juego = datosJuego.get(0);
                        HostOnline host = new HostOnline(new JFrame(), false, juego, listNaves, panelMensajes, datosOnline, finales, panelJuego, lblTurno, txtNaves, btnTurno);
                        partidaOnline = validacionesOnline.verificarMapa(juego, panelJuego, listNaves, datosOnline, host);
                        if (host.isVisible()) {
                            soyHost = true;
                        }
                    }
                    lblTurno.setText("Turno: " + contadorTurnos);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            } else {
                System.out.println("no es un archivo compatible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }

    }//GEN-LAST:event_opcionHostActionPerformed

    private void opcionAdderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAdderActionPerformed
        datosJuego.clear();
        if (juego != null) {
            JOptionPane.showMessageDialog(null, "Hay un juego en proceso, finaliza partida para continuar");
        }
        JFileChooser chooser = validacionesOnline.abrirArchivo(juego, datosJuego, panelMensajes);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            path = chooser.getCurrentDirectory().toString();
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            archivo = proyecto.toString();
            if (archivo.endsWith(".JSON")) {
                String texto = validacionesOnline.validarArchivo(archivo, proyecto);
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
                try {
                    new SintaxCreacionMapa(lexico, mapa, panelMensajes, contador, txtNaves, datosJuego, btnTurno, listNaves, panelJuego, btnDistancia, btnFlotas).parse();
                    if (!datosJuego.isEmpty()) {
                        juego = datosJuego.get(0);
                        AdderOnline adder = new AdderOnline(new JFrame(), false, juego, listNaves, panelMensajes, datosOnline, finales, panelJuego, lblTurno, txtNaves, btnTurno);

                        partidaOnline = validacionesOnline.verificarMapa2(juego, panelJuego, listNaves, datosOnline, adder);
                        if (adder.isVisible()) {
                            soyAdder = true;
                        }

                    }
                    lblTurno.setText("Turno: " + contadorTurnos);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este no es un archivo compatible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }

    }//GEN-LAST:event_opcionAdderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistancia;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnFlotas;
    private javax.swing.JButton btnTurno;
    private javax.swing.JMenuItem guardar1;
    private javax.swing.JMenuItem guardar2;
    private javax.swing.JMenuItem guardarReplay;
    private javax.swing.JMenuItem itemLectura;
    private javax.swing.JMenu itemNuevo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDistancia;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JMenuItem online;
    private javax.swing.JMenuItem opcionAdder;
    private javax.swing.JMenuItem opcionHost;
    private javax.swing.JMenu opcionesGuardar;
    private javax.swing.JLabel panelFondo;
    public static javax.swing.JPanel panelJuego;
    public static javax.swing.JTextArea panelMensajes;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JMenuItem replay;
    private javax.swing.JTextField txtNaves;
    // End of variables declaration//GEN-END:variables
}
