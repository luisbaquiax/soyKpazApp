/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pacientessoykpaz.frontend;

import com.pacientessoykpaz.backend.controldata.ControlDatos;
import com.pacientessoykpaz.backend.controldata.ReportePDF;
import com.pacientessoykpaz.backend.entidad.Encargado;
import com.pacientessoykpaz.backend.entidad.Paciente;
import com.pacientessoykpaz.backend.entidad.PacienteInfo;
import com.pacientessoykpaz.backend.entidad.Reporte;
import com.pacientessoykpaz.backend.entidad.Terapista;
import com.pacientessoykpaz.util.ManejoRutas;
import com.pacientessoykpaz.util.Utiles;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import lombok.Data;

/**
 *
 * @author Luis
 */
public class WindowSoyKpaz extends javax.swing.JFrame {

    private Utiles utiles;
    private ControlDatos controlDatos;
    private Encargado encargadoAuxi;
    private ButtonGroup group1;
    private ButtonGroup group2;
    private ButtonGroup group3;
    private List<PacienteInfo> listPacientes;
    private DefaultTableModel dfModel;
    private ManejoRutas rutas;
    private String rutadpiEncargado;
    private String rutadpiPaciente;
    public static final int TAM = 30;
    private PacienteInfo pacienteInfo;
    private List<Reporte> listReport;
    private Paciente pacienteCambio;

    /**
     * Creates new form WindowSoyKpaz
     */
    public WindowSoyKpaz() {
        initComponents();
        setSize(panelContenedor.getWidth() + 40, getHeight());
        System.out.println(panelContenedor.getWidth());
        this.dfModel = new DefaultTableModel();

        establecerFocus();
        setLocationRelativeTo(null);

        this.utiles = new Utiles();
        this.controlDatos = new ControlDatos();
        this.rutas = new ManejoRutas();

        group1 = new ButtonGroup();
        group1.add(radio100);
        group1.add(radio50);
        group1.add(radioNoBecado);

        group2 = new ButtonGroup();
        group2.add(radioIngresos1);
        group2.add(radioIngresos2);
        group2.add(radioIngresos3);

        group3 = new ButtonGroup();
        group3.add(radio100cambiar);
        group3.add(radio50cambiar);
        group3.add(radioNoBecadoCambiar);

        this.listPacientes = this.controlDatos.getPacienteInfoDB().getPacientes(true);

        this.listReport = new ArrayList<>();
        /**
         * Establecer iconos
         */
        utiles.ponerIconoLabel(label1, "/img/ong.png");
        utiles.setIconLabel(labelSearchporDpi, "/img/search.png", TAM);
        utiles.setIconLabel(labelSearchbycarne, "/img/search.png", TAM);
        utiles.setIconLabel(labelVerInformación, "/img/edit.png", TAM);
        utiles.setIconLabel(labelAddReport, "/img/add.png", TAM);
        utiles.setIconLabel(labelVerReporte, "/img/report.png", TAM);
        utiles.setIconLabel(labelDesactivar, "/img/desactivar.png", TAM);
        utiles.ponerIconoButton(btnSearchReportFecha, "/img/search.png", TAM);
        utiles.ponerIconoButton(btnPDF, "/img/pdf.png", TAM);
        int tam2 = 60;
        utiles.ponerIconoButton(btnlovePDF, "/img/lovepdf.png", tam2);
        utiles.ponerIconoButton(btnUrlJoinPDF, "/img/join.png", tam2);
        utiles.ponerIconoButton(btnUrlEditpdf, "/img/editpdf.png", tam2);
        utiles.ponerIconoButton(btnUrlConvertImgeToPDF, "/img/imagepdf.png", tam2);

        llenarCondiciones(listCondiciones);
        llenarComboTerapista(comboTerapistas);
        //otras variables
        this.rutadpiEncargado = "";
        this.rutadpiPaciente = "";
        /**
         * Llenar tablas
         */
        llenarTablaPacientes(this.listPacientes);
        llenarTablaTerapistas(this.controlDatos.getTerapistaDB().getTerapistas());
        //establecer el icon de la app cuando se está usando
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/ong.png")));
        try {
            //parace que se parezca a windows
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        panelNuevoPaciente = new javax.swing.JPanel();
        labelNuevoPaciente = new javax.swing.JLabel();
        panelPacientes = new javax.swing.JPanel();
        labelPacientes = new javax.swing.JLabel();
        panelTerapistas = new javax.swing.JPanel();
        labelTerapistas = new javax.swing.JLabel();
        panelAutor = new javax.swing.JPanel();
        labelAutor = new javax.swing.JLabel();
        panelHerramientas = new javax.swing.JPanel();
        labelHerramientas = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCarne = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        radio100 = new javax.swing.JRadioButton();
        radio50 = new javax.swing.JRadioButton();
        radioNoBecado = new javax.swing.JRadioButton();
        labelSelectFilePaciente = new javax.swing.JLabel();
        txtrutadpibeneficiario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCondiciones = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        txtOtraCondición = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEnfermedad = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtDpiEncargado = new javax.swing.JTextField();
        txtNameEncargado = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        radioIngresos1 = new javax.swing.JRadioButton();
        radioIngresos2 = new javax.swing.JRadioButton();
        radioIngresos3 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboTerapistas = new javax.swing.JComboBox<>();
        checkHabla = new javax.swing.JCheckBox();
        checkOcupacional = new javax.swing.JCheckBox();
        checkPsicologico = new javax.swing.JCheckBox();
        txtHorario = new javax.swing.JTextField();
        btnSaveData = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAllPacientes = new javax.swing.JButton();
        btnAtivesPacientes = new javax.swing.JButton();
        btnDesactivePacientes = new javax.swing.JButton();
        panelActions = new javax.swing.JPanel();
        labelVerReporte = new javax.swing.JLabel();
        labelVerInformación = new javax.swing.JLabel();
        labelAddReport = new javax.swing.JLabel();
        labelDesactivar = new javax.swing.JLabel();
        panelFiltro = new javax.swing.JPanel();
        labelSearchporDpi = new javax.swing.JLabel();
        txtSearchByEncargado = new javax.swing.JTextField();
        labelSearchbycarne = new javax.swing.JLabel();
        txtSearchCarne = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTerapistas = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtdpiTerapista = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNombreTerapista = new javax.swing.JTextField();
        btnSaveTerapista = new javax.swing.JButton();
        btnClearTerapista = new javax.swing.JButton();
        panel4 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txtCarne1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtFileChange = new javax.swing.JTextField();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        radio100cambiar = new javax.swing.JRadioButton();
        radio50cambiar = new javax.swing.JRadioButton();
        radioNoBecadoCambiar = new javax.swing.JRadioButton();
        labelChangeFile = new javax.swing.JLabel();
        txtAge2 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtOtraCondición1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEnfermedad1 = new javax.swing.JTextField();
        txtCambiarCondicion = new javax.swing.JTextField();
        btnCambiarCondicion = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        txtDpiEncargado1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtNameEncargado1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDireccion1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        radioIngresosMenor1000 = new javax.swing.JRadioButton();
        radioIngresosMayores1000 = new javax.swing.JRadioButton();
        radioIngresosNofijos = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        txtHorarioCambio = new javax.swing.JTextField();
        btnChangeTerapista = new javax.swing.JButton();
        txtTerapistaInfoCambio = new javax.swing.JTextField();
        checkHablaCambiar = new javax.swing.JCheckBox();
        checkCambiarOcupacional = new javax.swing.JCheckBox();
        checkPsicologicoCambiar = new javax.swing.JCheckBox();
        txtTerapiaCambio = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtFecha1 = new com.toedter.calendar.JDateChooser();
        labelSelectFilePaciente1 = new javax.swing.JLabel();
        txtFecha2 = new com.toedter.calendar.JDateChooser();
        btnSearchReportFecha = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnlovePDF = new javax.swing.JButton();
        btnUrlEditpdf = new javax.swing.JButton();
        btnUrlJoinPDF = new javax.swing.JButton();
        btnUrlConvertImgeToPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SoyKPazONG");

        panelContenedor.setBackground(new java.awt.Color(153, 153, 153));
        panelContenedor.setForeground(new java.awt.Color(255, 255, 255));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(277, 325));

        panelNuevoPaciente.setBackground(new java.awt.Color(51, 204, 0));
        panelNuevoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelNuevoPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelNuevoPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelNuevoPacienteMouseExited(evt);
            }
        });

        labelNuevoPaciente.setBackground(new java.awt.Color(255, 255, 255));
        labelNuevoPaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNuevoPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNuevoPaciente.setText("Nuevo paciente");
        labelNuevoPaciente.setToolTipText("");
        labelNuevoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelNuevoPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelNuevoPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelNuevoPacienteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelNuevoPacienteLayout = new javax.swing.GroupLayout(panelNuevoPaciente);
        panelNuevoPaciente.setLayout(panelNuevoPacienteLayout);
        panelNuevoPacienteLayout.setHorizontalGroup(
            panelNuevoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevoPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNuevoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelNuevoPacienteLayout.setVerticalGroup(
            panelNuevoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevoPacienteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelNuevoPaciente)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelPacientes.setBackground(new java.awt.Color(51, 204, 0));
        panelPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPacientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelPacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelPacientesMouseExited(evt);
            }
        });

        labelPacientes.setBackground(new java.awt.Color(255, 255, 255));
        labelPacientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPacientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPacientes.setText("Pacientes");
        labelPacientes.setToolTipText("");
        labelPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPacientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelPacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelPacientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelPacientesLayout = new javax.swing.GroupLayout(panelPacientes);
        panelPacientes.setLayout(panelPacientesLayout);
        panelPacientesLayout.setHorizontalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPacientesLayout.setVerticalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelPacientes)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelTerapistas.setBackground(new java.awt.Color(51, 204, 0));
        panelTerapistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTerapistasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelTerapistasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelTerapistasMouseExited(evt);
            }
        });

        labelTerapistas.setBackground(new java.awt.Color(255, 255, 255));
        labelTerapistas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTerapistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTerapistas.setText("Terapistas");
        labelTerapistas.setToolTipText("");
        labelTerapistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTerapistasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTerapistasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTerapistasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelTerapistasLayout = new javax.swing.GroupLayout(panelTerapistas);
        panelTerapistas.setLayout(panelTerapistasLayout);
        panelTerapistasLayout.setHorizontalGroup(
            panelTerapistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTerapistasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTerapistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTerapistasLayout.setVerticalGroup(
            panelTerapistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTerapistasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelTerapistas)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelAutor.setBackground(new java.awt.Color(51, 204, 0));
        panelAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAutorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelAutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelAutorMouseExited(evt);
            }
        });

        labelAutor.setBackground(new java.awt.Color(255, 255, 255));
        labelAutor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAutor.setText("Acerca de ...");
        labelAutor.setToolTipText("");
        labelAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAutorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAutorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAutorLayout = new javax.swing.GroupLayout(panelAutor);
        panelAutor.setLayout(panelAutorLayout);
        panelAutorLayout.setHorizontalGroup(
            panelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAutorLayout.setVerticalGroup(
            panelAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelHerramientas.setBackground(new java.awt.Color(51, 204, 0));
        panelHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHerramientasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelHerramientasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelHerramientasMouseExited(evt);
            }
        });

        labelHerramientas.setBackground(new java.awt.Color(255, 255, 255));
        labelHerramientas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHerramientas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHerramientas.setText("Herramientas");
        labelHerramientas.setToolTipText("");
        labelHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHerramientasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelHerramientasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelHerramientasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelHerramientasLayout = new javax.swing.GroupLayout(panelHerramientas);
        panelHerramientas.setLayout(panelHerramientasLayout);
        panelHerramientasLayout.setHorizontalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHerramientasLayout.setVerticalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelHerramientas)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelNuevoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTerapistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelNuevoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTerapistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar nuevo paciente");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales y tipo de programa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtCarne.setBorder(javax.swing.BorderFactory.createTitledBorder("*Carné:"));

        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder("*Nombre:"));

        txtAge.setBorder(javax.swing.BorderFactory.createTitledBorder("*Edad"));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgeKeyTyped(evt);
            }
        });

        dateChooser.setBorder(javax.swing.BorderFactory.createTitledBorder("*Fecha nacimiento"));
        dateChooser.setDateFormatString("y-M-d");

        jLabel15.setText("Tipo de programa:");

        radio100.setText("100 % becado");
        radio100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio100ActionPerformed(evt);
            }
        });

        radio50.setText("50 % becado");
        radio50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio50ActionPerformed(evt);
            }
        });

        radioNoBecado.setText("No becado");
        radioNoBecado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoBecadoActionPerformed(evt);
            }
        });

        labelSelectFilePaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelectFilePaciente.setText("Seleccionar documentos");
        labelSelectFilePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSelectFilePacienteMouseClicked(evt);
            }
        });

        txtrutadpibeneficiario.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivo seleccionado"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCarne)
                            .addComponent(txtName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAge)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelSelectFilePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtrutadpibeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radio100)
                        .addGap(18, 18, 18)
                        .addComponent(radio50, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioNoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(labelSelectFilePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtrutadpibeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radio50)
                        .addComponent(radioNoBecado))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(radio100)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condición y alguna enfermedad crónica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("* Condición:");

        listCondiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCondicionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listCondiciones);

        jLabel12.setText("Otra (especifíque):");

        jLabel16.setText("Enfermedad crónica:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOtraCondición)
                    .addComponent(txtEnfermedad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtOtraCondición, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtDpiEncargado.setBorder(javax.swing.BorderFactory.createTitledBorder("*DPI"));
        txtDpiEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDpiEncargadoKeyTyped(evt);
            }
        });

        txtNameEncargado.setBorder(javax.swing.BorderFactory.createTitledBorder("*Nombre:"));
        txtNameEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameEncargadoActionPerformed(evt);
            }
        });

        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder("*Direccion:"));

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("*Telefono"));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel14.setText("Condición socio-económica:");

        radioIngresos1.setText("Ingresos inferiores a Q 1,000");
        radioIngresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIngresos1ActionPerformed(evt);
            }
        });

        radioIngresos2.setText("Ingresos superiores a Q 1,000");

        radioIngresos3.setText("No tiene ingresos fijos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(radioIngresos3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioIngresos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioIngresos2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtDpiEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDpiEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioIngresos3)
                    .addComponent(radioIngresos1)
                    .addComponent(radioIngresos2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Terapista, tipo de terapia, día y horario de la terapia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setText("Terapista:");

        jLabel13.setText("Terapia a recibir:");

        checkHabla.setText("Habla");
        checkHabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHablaActionPerformed(evt);
            }
        });

        checkOcupacional.setText("Ocupacional");

        checkPsicologico.setText("Psicológico");

        txtHorario.setBorder(javax.swing.BorderFactory.createTitledBorder("*Hora y días de la terapia"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHorario)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboTerapistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkHabla)
                        .addGap(18, 18, 18)
                        .addComponent(checkOcupacional)
                        .addGap(18, 18, 18)
                        .addComponent(checkPsicologico)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboTerapistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(checkHabla)
                    .addComponent(checkOcupacional)
                    .addComponent(checkPsicologico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btnSaveData.setBackground(new java.awt.Color(0, 204, 51));
        btnSaveData.setText("Guardar cambios");
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 255, 0));
        btnClear.setText("Limpiar campos");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnSaveData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("1", panel1);

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carné", "Nombre", "Fecha de nacimiento", "Tipo de grograma", "Terapista", "Terapia", "Encargado", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePacientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablePacientes.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tablePacientes);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAllPacientes.setText("Ver todos");
        btnAllPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllPacientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnAllPacientes);

        btnAtivesPacientes.setText("Ver solo activos");
        btnAtivesPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivesPacientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtivesPacientes);

        btnDesactivePacientes.setText("Ver no activos");
        btnDesactivePacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivePacientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnDesactivePacientes);

        panelActions.setMinimumSize(new java.awt.Dimension(258, 28));
        panelActions.setPreferredSize(new java.awt.Dimension(622, 36));
        panelActions.setLayout(new java.awt.GridLayout(1, 0));

        labelVerReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVerReporte.setText("Ver reporte");
        labelVerReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVerReporteMouseClicked(evt);
            }
        });
        panelActions.add(labelVerReporte);

        labelVerInformación.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVerInformación.setText("Ver información");
        labelVerInformación.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelVerInformaciónMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelVerInformaciónMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelVerInformaciónMouseExited(evt);
            }
        });
        panelActions.add(labelVerInformación);

        labelAddReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAddReport.setText("Agregar reporte");
        labelAddReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddReportMouseClicked(evt);
            }
        });
        panelActions.add(labelAddReport);

        labelDesactivar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDesactivar.setText("Desactivar");
        labelDesactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDesactivarMouseClicked(evt);
            }
        });
        panelActions.add(labelDesactivar);

        panelFiltro.setBackground(new java.awt.Color(255, 255, 255));
        panelFiltro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSearchporDpi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelFiltro.add(labelSearchporDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        txtSearchByEncargado.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por encargado (DPI)"));
        txtSearchByEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchByEncargadoActionPerformed(evt);
            }
        });
        txtSearchByEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchByEncargadoKeyReleased(evt);
            }
        });
        panelFiltro.add(txtSearchByEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 210, -1));
        panelFiltro.add(labelSearchbycarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 40, 40));

        txtSearchCarne.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por carné:"));
        txtSearchCarne.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCarneKeyReleased(evt);
            }
        });
        panelFiltro.add(txtSearchCarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 180, -1));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("2", panel2);

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        tableTerapistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DPI", "TERAPISTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTerapistas.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tableTerapistas);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar nuevo terapista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel17.setText("DPI:");

        txtdpiTerapista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdpiTerapistaKeyTyped(evt);
            }
        });

        jLabel18.setText("Nombre:");

        btnSaveTerapista.setBackground(new java.awt.Color(51, 204, 0));
        btnSaveTerapista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSaveTerapista.setText("Guardar datos");
        btnSaveTerapista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTerapistaActionPerformed(evt);
            }
        });

        btnClearTerapista.setBackground(new java.awt.Color(255, 255, 102));
        btnClearTerapista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearTerapista.setText("Limpiar campos");
        btnClearTerapista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTerapistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveTerapista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearTerapista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreTerapista, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtdpiTerapista))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtdpiTerapista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNombreTerapista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveTerapista)
                .addGap(18, 18, 18)
                .addComponent(btnClearTerapista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("3", panel3);

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ver o editar información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales y tipo de programa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCarne1.setBackground(new java.awt.Color(242, 242, 242));
        txtCarne1.setEnabled(false);
        jPanel17.add(txtCarne1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 24, 150, -1));

        jLabel19.setText("* Carné:");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 27, 66, -1));

        jLabel20.setText("* Nombre:");
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 72, -1, -1));
        jPanel17.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 69, 150, -1));

        jLabel21.setText("* Fecha de nacimiento:");
        jPanel17.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 24, -1, -1));

        jLabel22.setText("* Edad:");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 72, 120, -1));

        txtFileChange.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivo seleccionado"));
        jPanel17.add(txtFileChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 52, 137, -1));

        dateChooser1.setDateFormatString("y-M-d");
        jPanel17.add(dateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 24, 100, -1));

        jLabel23.setText("Tipo de programa:");
        jPanel17.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 109, -1, -1));

        radio100cambiar.setText("100 % becado");
        jPanel17.add(radio100cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 107, -1, -1));

        radio50cambiar.setText("50 % becado");
        jPanel17.add(radio50cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 107, -1, -1));

        radioNoBecadoCambiar.setText("No becado");
        jPanel17.add(radioNoBecadoCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 107, -1, -1));

        labelChangeFile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChangeFile.setText("Seleccionar documentos");
        labelChangeFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelChangeFileMouseClicked(evt);
            }
        });
        jPanel17.add(labelChangeFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 24, 152, -1));

        txtAge2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAge2KeyTyped(evt);
            }
        });
        jPanel17.add(txtAge2, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 69, 100, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condición y alguna enfermedad crónica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel25.setText("Otra (especifíque):");

        jLabel26.setText("Enfermedad crónica:");

        txtCambiarCondicion.setBorder(javax.swing.BorderFactory.createTitledBorder("Condición"));

        btnCambiarCondicion.setText("Cambiar");
        btnCambiarCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCondicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCambiarCondicion, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(btnCambiarCondicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOtraCondición1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtEnfermedad1))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCambiarCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarCondicion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtOtraCondición1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEnfermedad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel27.setText("* DPI:");

        jLabel28.setText("* Nombre:");

        jLabel29.setText("* Dirección:");

        jLabel30.setText("* Teléfono:");

        txtTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono1KeyTyped(evt);
            }
        });

        jLabel31.setText("Condición socio-económica:");

        radioIngresosMenor1000.setText("Ingresos inferiores a Q 1,000");

        radioIngresosMayores1000.setText("Ingresos superiores a Q 1,000");

        radioIngresosNofijos.setText("No tiene ingresos fijos");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNameEncargado1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDpiEncargado1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion1))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(radioIngresosMenor1000)
                                .addGap(18, 18, 18)
                                .addComponent(radioIngresosMayores1000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioIngresosNofijos))
                            .addComponent(jLabel31))))
                .addGap(0, 79, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtDpiEncargado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtNameEncargado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioIngresosMenor1000)
                    .addComponent(radioIngresosMayores1000)
                    .addComponent(radioIngresosNofijos))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Terapista y tipo de terapia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtHorarioCambio.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario"));

        btnChangeTerapista.setText("Cambiar");
        btnChangeTerapista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeTerapistaActionPerformed(evt);
            }
        });

        txtTerapistaInfoCambio.setEditable(false);
        txtTerapistaInfoCambio.setBorder(javax.swing.BorderFactory.createTitledBorder("Terapista actual"));

        checkHablaCambiar.setText("Habla");

        checkCambiarOcupacional.setText("Ocupacional");

        checkPsicologicoCambiar.setText("Psicológico");

        txtTerapiaCambio.setEditable(false);
        txtTerapiaCambio.setBorder(javax.swing.BorderFactory.createTitledBorder("Terapia actual"));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTerapiaCambio)
                    .addComponent(txtTerapistaInfoCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangeTerapista)
                    .addComponent(checkHablaCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(checkCambiarOcupacional, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkPsicologicoCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtHorarioCambio))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeTerapista)
                    .addComponent(txtTerapistaInfoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorarioCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkHablaCambiar)
                    .addComponent(checkCambiarOcupacional)
                    .addComponent(checkPsicologicoCambiar)
                    .addComponent(txtTerapiaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        btnGuardarCambios.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        jPanel11.add(btnGuardarCambios);

        jButton3.setBackground(new java.awt.Color(255, 51, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("X Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton3);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        jTabbedPane1.addTab("4", panel4);

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtArea.setRows(5);
        jScrollPane5.setViewportView(txtArea);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtar reporte por fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel34.setText("Fecha 1:");

        txtFecha1.setDateFormatString("y-M-d");

        labelSelectFilePaciente1.setText("Fecha 2:");
        labelSelectFilePaciente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSelectFilePaciente1MouseClicked(evt);
            }
        });

        txtFecha2.setDateFormatString("y-M-d");

        btnSearchReportFecha.setText("Realizar consulta");
        btnSearchReportFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchReportFechaActionPerformed(evt);
            }
        });

        btnPDF.setText("Exportar en PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSelectFilePaciente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchReportFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchReportFecha)
                        .addComponent(btnPDF))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtFecha1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFecha2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSelectFilePaciente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("5", panel5);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas útiles para manipular PDFs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnlovePDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnlovePDF.setText("I love PDF");
        btnlovePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlovePDFActionPerformed(evt);
            }
        });

        btnUrlEditpdf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUrlEditpdf.setText("Editar PDF");
        btnUrlEditpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrlEditpdfActionPerformed(evt);
            }
        });

        btnUrlJoinPDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUrlJoinPDF.setText("Unir PDF");
        btnUrlJoinPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrlJoinPDFActionPerformed(evt);
            }
        });

        btnUrlConvertImgeToPDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUrlConvertImgeToPDF.setText("Convertir imgen a PDF");
        btnUrlConvertImgeToPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrlConvertImgeToPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlovePDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUrlEditpdf, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addComponent(btnUrlJoinPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addComponent(btnUrlConvertImgeToPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnlovePDF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUrlEditpdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUrlJoinPDF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUrlConvertImgeToPDF)
                .addGap(0, 488, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("6", jPanel1);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelNuevoPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNuevoPacienteMouseEntered
        // TODO add your handling code here:panelNuevoPaciente.setBackground(new Color(85, 255, 51));
        panelNuevoPaciente.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_panelNuevoPacienteMouseEntered

    private void labelNuevoPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoPacienteMouseExited
        // TODO add your handling code here:
        panelNuevoPaciente.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_labelNuevoPacienteMouseExited

    private void panelNuevoPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNuevoPacienteMouseExited
        // TODO add your handling code here:
        panelNuevoPaciente.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_panelNuevoPacienteMouseExited

    private void labelNuevoPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoPacienteMouseEntered
        // TODO add your handling code here:
        panelNuevoPaciente.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_labelNuevoPacienteMouseEntered

    private void labelPacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPacientesMouseEntered
        // TODO add your handling code here:
        panelPacientes.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_labelPacientesMouseEntered

    private void labelPacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPacientesMouseExited
        // TODO add your handling code here:
        panelPacientes.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_labelPacientesMouseExited

    private void panelPacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPacientesMouseEntered
        // TODO add your handling code here:
        panelPacientes.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_panelPacientesMouseEntered

    private void panelPacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPacientesMouseExited
        // TODO add your handling code here:
        panelPacientes.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_panelPacientesMouseExited

    private void labelTerapistasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerapistasMouseEntered
        // TODO add your handling code here:
        panelTerapistas.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_labelTerapistasMouseEntered

    private void labelTerapistasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerapistasMouseExited
        // TODO add your handling code here:
        panelTerapistas.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_labelTerapistasMouseExited

    private void panelTerapistasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTerapistasMouseEntered
        // TODO add your handling code here:
        panelTerapistas.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_panelTerapistasMouseEntered

    private void panelTerapistasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTerapistasMouseExited
        // TODO add your handling code here:
        panelTerapistas.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_panelTerapistasMouseExited

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtNameEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameEncargadoActionPerformed

    private void listCondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCondicionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listCondicionesMouseClicked

    private void radio100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio100ActionPerformed

    private void radio50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio50ActionPerformed

    private void radioNoBecadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoBecadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNoBecadoActionPerformed

    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
        // TODO add your handling code here:
        //validamos campos
        String condicion = "";

        if (!txtOtraCondición.getText().isBlank()) {
            condicion += txtOtraCondición.getText() + " ";
        }
        for (int i = 0; i < listCondiciones.getSelectedValuesList().size(); i++) {
            condicion += listCondiciones.getSelectedValuesList().get(i) + " ";
        }
        if (txtAge.getText().isBlank()
                || txtName.getText().isBlank()
                || txtCarne.getText().isBlank()
                || txtDireccion.getText().isBlank()
                || txtDpiEncargado.getText().isBlank()
                || txtNameEncargado.getText().isBlank()
                || txtHorario.getText().isBlank()
                || condicion.equals("")) {

            JOptionPane.showMessageDialog(null,
                    "Debe llenar los campos obligatorios.",
                    "CAMPOS OBLIGATORIOS",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            //preguntamos si se desea guardar los cambios
            int opcion = (int) JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea guardar los cambios?", "SELECCIONE UNA OPCIÓN",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == 0) {
                JTextField auxi = (JTextField) dateChooser.getDateEditor().getUiComponent();
                JRadioButton auxiBtn = new JRadioButton();
                JRadioButton auxiBtn2 = new JRadioButton();
                boolean ingresoSeleccionado = false;
                boolean isTerapistaSelected = false;

                //valiamos se selecciona el rango de ingresos
                if (group2.isSelected(radioIngresos1.getModel())) {
                    ingresoSeleccionado = true;
                    auxiBtn2 = radioIngresos1;
                } else if (group2.isSelected(radioIngresos2.getModel())) {
                    ingresoSeleccionado = true;
                    auxiBtn2 = radioIngresos2;
                } else if (group2.isSelected(radioIngresos3.getModel())) {
                    ingresoSeleccionado = true;
                    auxiBtn2 = radioIngresos3;
                }
                //validamos el tipo de programa
                boolean isBecario = false;
                if (group1.isSelected(radio100.getModel())) {
                    auxiBtn = radio100;
                    isBecario = true;
                } else if (group1.isSelected(radio50.getModel())) {
                    auxiBtn = radio50;
                    isBecario = true;
                } else if (group1.isSelected(radioNoBecado.getModel())) {
                    auxiBtn = radioNoBecado;
                    isBecario = true;
                }
                //Creamos al encargado
                Encargado encargado = Encargado.builder().
                        dpi(txtDpiEncargado.getText()).
                        nombre(txtNameEncargado.getText()).
                        telefono(txtTelefono.getText()).
                        direccion(txtDireccion.getText()).
                        condicionEconomica(auxiBtn2.getText()).
                        tipoDocumento("").build();
                //creamos al paciente
                String[] datosTerapista = comboTerapistas.getSelectedItem().toString().split(",");
                String dpiterapista = datosTerapista[0];
                String terapia = " ";
                if (checkHabla.isSelected()) {
                    terapia += Utiles.HABLA;
                    terapia += " ";
                    isTerapistaSelected = true;
                }
                if (checkOcupacional.isSelected()) {
                    terapia += Utiles.OCUPACIONAL;
                    terapia += " ";
                    isTerapistaSelected = true;
                }
                if (checkPsicologico.isSelected()) {
                    terapia += Utiles.PSICOLOGICA;
                    terapia += " ";
                    isTerapistaSelected = true;
                }
                Paciente nuevoPaciente = Paciente.builder().
                        carne(txtCarne.getText()).
                        nombre(txtName.getText()).
                        edad(Integer.parseInt(txtAge.getText())).
                        fechaNacimiento(auxi.getText()).
                        tipoPrograma(auxiBtn.getText()).
                        dpiTerapista(dpiterapista).
                        terapia(terapia).
                        dpiEncargado(txtDpiEncargado.getText()).
                        enfermedadCronica(txtEnfermedad.getText()).
                        build();
                //validamos si selecciono algún archivo
                boolean pacienteConArchivo = false;
                boolean encargadoConArchivo = false;
                if (!rutadpiEncargado.equals("")) {
                    try {
                        InputStream in = new FileInputStream(rutadpiEncargado);
                        byte[] arrayBytes = in.readAllBytes();
                        encargado.setFileBytes(arrayBytes);
                        encargadoConArchivo = true;
                    } catch (IOException ex) {
                        Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (!rutadpiPaciente.equals("")) {
                    try {
                        InputStream in = new FileInputStream(rutadpiPaciente);
                        byte[] bytesArray = in.readAllBytes();
                        nuevoPaciente.setFileBytes(bytesArray);
                        File file = new File(rutadpiPaciente);
                        String tipo = file.getName().substring(file.getName().lastIndexOf(".") + 1);
                        nuevoPaciente.setTipoArchivo(tipo);
                        pacienteConArchivo = true;
                    } catch (IOException ex) {
                        Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //

                //verificamos si se han seleccionado las opciones necesarias
                if (isBecario && ingresoSeleccionado && isTerapistaSelected) {
                    nuevoPaciente.setHorario(txtHorario.getText());
                    System.out.println(txtDpiEncargado.getText());
                    encargadoAuxi = controlDatos.getEncargadoDB().getEncargado(txtDpiEncargado.getText());

                    //agregamos la condicon física del paciente
                    nuevoPaciente.setCondicion(condicion);
                    //por lo general un paciente será activado cuando se guarda
                    nuevoPaciente.setActivo(true);
                    if (encargadoAuxi.getDpi() != null) {
                        //agregar paciente
                        agregarPaciente(pacienteConArchivo, nuevoPaciente);
                    } else {
                        if (encargadoConArchivo) {
                            controlDatos.getEncargadoDB().insertWithFile(encargado);
                        } else {
                            controlDatos.getEncargadoDB().insertWithoutFile(encargado);
                        }
                        agregarPaciente(pacienteConArchivo, nuevoPaciente);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Debe seleccionar el tipo de programa, la terapia y el rango de ingresos del encargado",
                            "SELECCIONAR PROGRAMA",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
                limpiarCamposNuevoPaciente();
            }
        }
        llenarCondiciones(listCondiciones);

    }//GEN-LAST:event_btnSaveDataActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        limpiarCamposNuevoPaciente();
    }//GEN-LAST:event_btnClearActionPerformed

    private void checkHablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkHablaActionPerformed

    private void txtDpiEncargadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDpiEncargadoKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDpiEncargadoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void radioIngresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIngresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioIngresos1ActionPerformed

    private void panelNuevoPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNuevoPacienteMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        llenarComboTerapista(comboTerapistas);
    }//GEN-LAST:event_panelNuevoPacienteMouseClicked

    private void labelNuevoPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNuevoPacienteMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        llenarComboTerapista(comboTerapistas);
    }//GEN-LAST:event_labelNuevoPacienteMouseClicked

    private void panelPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPacientesMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
        llenarTablaPacientes(listPacientes);
        tablePacientes.requestFocus();
    }//GEN-LAST:event_panelPacientesMouseClicked

    private void labelPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPacientesMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
        llenarTablaPacientes(listPacientes);
        tablePacientes.requestFocus();
    }//GEN-LAST:event_labelPacientesMouseClicked

    private void txtdpiTerapistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdpiTerapistaKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdpiTerapistaKeyTyped

    private void btnClearTerapistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTerapistaActionPerformed
        // TODO add your handling code here:
        txtNombreTerapista.setText("");
        txtdpiTerapista.setText("");
    }//GEN-LAST:event_btnClearTerapistaActionPerformed

    private void btnSaveTerapistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTerapistaActionPerformed
        // TODO add your handling code here:
        Terapista t = Terapista.builder().nombre(txtNombreTerapista.getText()).dpi(txtdpiTerapista.getText()).build();
        if (controlDatos.getTerapistaDB().insert(t)) {
            JOptionPane.showMessageDialog(null,
                    "Se guardó correctamente los datos.",
                    "DATOS GUARDADOS.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No pudimos guardar correctamente los datos.",
                    "DATOS NO GUARDADOS.", JOptionPane.INFORMATION_MESSAGE);
        }
        llenarTablaTerapistas(controlDatos.getTerapistaDB().getTerapistas());
    }//GEN-LAST:event_btnSaveTerapistaActionPerformed

    private void labelTerapistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTerapistasMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_labelTerapistasMouseClicked

    private void panelTerapistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTerapistasMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_panelTerapistasMouseClicked

    private void txtTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono1KeyTyped

    private void txtSearchByEncargadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchByEncargadoKeyReleased
        // TODO add your handling code here:
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(txtSearchByEncargado.getText(), true);
        llenarTablaPacientes(listPacientes);
    }//GEN-LAST:event_txtSearchByEncargadoKeyReleased

    private void txtSearchCarneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCarneKeyReleased
        // TODO add your handling code here:
        listPacientes = controlDatos.getPacienteInfoDB().getPacientesbyCarne(txtSearchCarne.getText(), true);
        llenarTablaPacientes(listPacientes);
    }//GEN-LAST:event_txtSearchCarneKeyReleased

    private void labelSelectFilePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectFilePacienteMouseClicked
        this.rutadpiPaciente = rutas.pathChoserOpen(null);
        if (!rutadpiPaciente.equals("")) {
            File f = new File(rutadpiPaciente);
            txtrutadpibeneficiario.setText(f.getName());
        }
    }//GEN-LAST:event_labelSelectFilePacienteMouseClicked

    private void labelAddReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddReportMouseClicked

        int fila = tablePacientes.getSelectedRow();
        if (fila >= 0) {
            WinReport winReport = new WinReport(controlDatos, listPacientes.get(fila), this);
            winReport.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar al paciene en la tabla.",
                    "SELECCIONAR AL PACIENTE",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_labelAddReportMouseClicked

    private void labelVerReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerReporteMouseClicked
        int fila = tablePacientes.getSelectedRow();
        if (fila >= 0) {
            pacienteInfo = listPacientes.get(fila);
            listReport = controlDatos.getReporteDB().getReportes(pacienteInfo.getCarne());
            txtArea.setText(getReportString(listReport, pacienteInfo));
            jTabbedPane1.setSelectedIndex(4);
        }
    }//GEN-LAST:event_labelVerReporteMouseClicked

    private void labelSelectFilePaciente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSelectFilePaciente1MouseClicked
    }//GEN-LAST:event_labelSelectFilePaciente1MouseClicked

    private void btnSearchReportFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchReportFechaActionPerformed
        // TODO add your handling code here:
        JTextField fecha1 = (JTextField) dateChooser.getDateEditor().getUiComponent();
        JTextField fecha2 = (JTextField) dateChooser.getDateEditor().getUiComponent();
        listReport = controlDatos.getReporteDB().getReportes(
                pacienteInfo.getCarne(),
                fecha1.getText(),
                fecha2.getText());
        txtArea.setText(getReportString(listReport, pacienteInfo));
        fecha1.setText("");
        fecha2.setText("");
    }//GEN-LAST:event_btnSearchReportFechaActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        try {
            ReportePDF reportePDF = new ReportePDF();
            Paciente paciente = null;
            List<Paciente> list = controlDatos.getPacienteDB().getPacientes();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCarne().equals(pacienteInfo.getCarne())) {
                    paciente = list.get(i);
                    break;
                }
            }
            Encargado encargado = controlDatos.getEncargadoDB().getEncargado(paciente.getDpiEncargado());
            String path = rutas.pathChoserSave(null);
            if (!path.equals("")) {
                reportePDF.writePDF(new File(path + ".pdf"), listReport, pacienteInfo, paciente, encargado);
            }
//            reportePDF.writePDF(new File("reporte.pdf"), listReport, pacienteInfo, paciente, encargado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnPDFActionPerformed

    private void labelVerInformaciónMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerInformaciónMouseClicked
        // TODO add your handling code here:
        int fila = tablePacientes.getSelectedRow();
        if (fila >= 0) {
            this.pacienteInfo = listPacientes.get(fila);
            txtCarne1.setText(pacienteInfo.getCarne());
            txtName1.setText(pacienteInfo.getNombre());
            txtAge2.setText(pacienteInfo.getEdad());
            txtHorarioCambio.setText(pacienteInfo.getHorario());

            JTextField fecha = (JTextField) dateChooser1.getDateEditor().getUiComponent();
            fecha.setText(pacienteInfo.getFecha());

            txtTelefono1.setText(pacienteInfo.getTelefono());

            txtTerapiaCambio.setText(pacienteInfo.getTerapia());
            txtTerapistaInfoCambio.setText(pacienteInfo.getTerapista());

            pacienteCambio = controlDatos.getPacientePorCarne(controlDatos.getPacienteDB().getPacientes(), pacienteInfo);

            System.out.println("paciente " + pacienteCambio.toString());
            this.encargadoAuxi = controlDatos.getEncargadoDB().getEncargado(pacienteCambio.getDpiEncargado());

            txtDpiEncargado1.setText(encargadoAuxi.getDpi());
            txtDireccion1.setText(encargadoAuxi.getDireccion());
            txtNameEncargado1.setText(encargadoAuxi.getNombre());
            txtCambiarCondicion.setText(pacienteCambio.getCondicion());

            switch (encargadoAuxi.getCondicionEconomica()) {
                case Utiles.INGRESOS_MAYOR_1000 ->
                    radioIngresosMayores1000.setSelected(true);
                case Utiles.INGRESOS_MENOR_1000 ->
                    radioIngresosMenor1000.setSelected(true);
                case Utiles.NO_TIENE_INGRESOS_FIJOS ->
                    radioIngresosNofijos.setSelected(true);
                default -> {
                }
            }
            switch (pacienteCambio.getTipoPrograma()) {
                case Utiles.BECARIO_100 ->
                    radio100cambiar.setSelected(true);
                case Utiles.BECARIO_50 ->
                    radio50cambiar.setSelected(true);
                case Utiles.NO_BECADO ->
                    radioNoBecadoCambiar.setSelected(true);
                default -> {
                }
            }
            String terapias = pacienteCambio.getTerapia();
            String[] lisTera = terapias.split(" ");
            //establecemos la terapia que tiene antes
            for (int i = 0; i < lisTera.length; i++) {
                if (lisTera[i].equals(Utiles.OCUPACIONAL)) {
                    checkCambiarOcupacional.setSelected(true);
                } else if (lisTera[i].equals(Utiles.HABLA)) {
                    checkHablaCambiar.setSelected(true);
                } else if (lisTera[i].equals(Utiles.PSICOLOGICA)) {
                    checkPsicologicoCambiar.setSelected(true);
                }
            }
            jTabbedPane1.setSelectedIndex(3);
        }
    }//GEN-LAST:event_labelVerInformaciónMouseClicked

    private void btnChangeTerapistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeTerapistaActionPerformed
        // TODO add your handling code here:

        Terapista n = (Terapista) JOptionPane.showInputDialog(
                null,
                "¿Deseas cambiar al terapista?",
                "SELECCIONAR TERAPISTA",
                JOptionPane.QUESTION_MESSAGE,
                null,
                controlDatos.getTerapistaDB().getTerapistas().toArray(),
                controlDatos.getTerapistaDB().getTerapistas().get(0));
        if (n != null) {
            txtTerapistaInfoCambio.setText(n.getNombre());
        }
    }//GEN-LAST:event_btnChangeTerapistaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void labelVerInformaciónMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerInformaciónMouseEntered
        // TODO add your handling code here:
        labelVerInformación.setBackground(new Color(37, 150, 190));
    }//GEN-LAST:event_labelVerInformaciónMouseEntered

    private void labelVerInformaciónMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelVerInformaciónMouseExited
        // TODO add your handling code here:
        labelVerInformación.setBackground(Color.WHITE);
    }//GEN-LAST:event_labelVerInformaciónMouseExited

    private void btnCambiarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCondicionActionPerformed
        // TODO add your handling code here:
        new CambioCondicion(controlDatos, pacienteCambio, this).setVisible(true);
    }//GEN-LAST:event_btnCambiarCondicionActionPerformed

    private void labelAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAutorMouseClicked
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_labelAutorMouseClicked

    private void labelAutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAutorMouseEntered
        // TODO add your handling code here:
        panelAutor.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_labelAutorMouseEntered

    private void labelAutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAutorMouseExited
        // TODO add your handling code here:
        panelAutor.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_labelAutorMouseExited

    private void panelAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAutorMouseClicked
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_panelAutorMouseClicked

    private void panelAutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAutorMouseEntered
        // TODO add your handling code here:
        panelAutor.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_panelAutorMouseEntered

    private void panelAutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAutorMouseExited
        // TODO add your handling code here:
        panelAutor.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_panelAutorMouseExited

    private void labelChangeFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChangeFileMouseClicked
        // TODO add your handling code here:
        this.rutadpiPaciente = rutas.pathChoserOpen(null);
        if (!rutadpiPaciente.equals("")) {
            File file = new File(rutadpiPaciente);
            txtFileChange.setText(file.getName());
        }
    }//GEN-LAST:event_labelChangeFileMouseClicked

    private void labelHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHerramientasMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_labelHerramientasMouseClicked

    private void labelHerramientasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHerramientasMouseEntered
        // TODO add your handling code here:
        panelHerramientas.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_labelHerramientasMouseEntered

    private void labelHerramientasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHerramientasMouseExited
        // TODO add your handling code here:
        panelHerramientas.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_labelHerramientasMouseExited

    private void panelHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHerramientasMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_panelHerramientasMouseClicked

    private void panelHerramientasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHerramientasMouseEntered
        // TODO add your handling code here:
        panelHerramientas.setBackground(new Color(85, 255, 51));
    }//GEN-LAST:event_panelHerramientasMouseEntered

    private void panelHerramientasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHerramientasMouseExited
        // TODO add your handling code here:
        panelHerramientas.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_panelHerramientasMouseExited

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        int opcion = (int) JOptionPane.showInternalConfirmDialog(
                null,
                "¿Desea guardar los cambios?",
                "GUARDAR CAMBIOS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (opcion == 0) {
            String condiconEconomica = "";
            if (radioIngresosMayores1000.isSelected()) {
                condiconEconomica = radioIngresosMayores1000.getText();
            } else if (radioIngresosMenor1000.isSelected()) {
                condiconEconomica = radioIngresosMenor1000.getText();
            } else if (radioIngresosNofijos.isSelected()) {
                condiconEconomica = radioIngresosNofijos.getText();
            }
            String tipoPrograma = "";
            if (radio100cambiar.isSelected()) {
                tipoPrograma = Utiles.BECARIO_100;
            } else if (radio50cambiar.isSelected()) {
                tipoPrograma = Utiles.BECARIO_50;
            } else if (radioNoBecadoCambiar.isSelected()) {
                tipoPrograma = Utiles.NO_BECADO;
            }
            String terapia = "";
            if (checkCambiarOcupacional.isSelected()) {
                terapia += Utiles.OCUPACIONAL + " ";
            } else if (checkHablaCambiar.isSelected()) {
                terapia += Utiles.HABLA + " ";
            } else if (checkPsicologicoCambiar.isSelected()) {
                terapia += Utiles.PSICOLOGICA + " ";
            }
            if (!this.rutadpiPaciente.equals("")) {
                InputStream in;
                try {
                    in = new FileInputStream(rutadpiPaciente);
                    byte[] bytesArray = in.readAllBytes();
                    pacienteCambio.setFileBytes(bytesArray);
                    File file = new File(rutadpiPaciente);
                    pacienteCambio.setTipoArchivo(file.getName().substring(file.getName().lastIndexOf(".") + 1));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //obteniendo la fecha
            JTextField txt = (JTextField) dateChooser1.getDateEditor().getUiComponent();

            //se realiza los cambios
            //primero se realiza algunas validaciones
            if (txtDpiEncargado1.getText().isBlank()
                    || txtName1.getText().isBlank()
                    || txtDireccion1.getText().isBlank()
                    || txtTelefono1.getText().isBlank()
                    || txtAge2.getText().isBlank()
                    || condiconEconomica.equals("")
                    || tipoPrograma.equals("")
                    || terapia.equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Debe llenar los campos obligatorios.",
                        "CAMPOS OBLIGATORIOS",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                encargadoAuxi.setDpi(txtDpiEncargado1.getText());
                encargadoAuxi.setNombre(txtNameEncargado1.getText());
                encargadoAuxi.setDireccion(txtDireccion1.getText());
                encargadoAuxi.setTelefono(txtTelefono1.getText());
                encargadoAuxi.setCondicionEconomica(condiconEconomica);
                if (!txtEnfermedad1.getText().isBlank()) {
                    pacienteCambio.setEnfermedadCronica(txtEnfermedad1.getText());
                }
                pacienteCambio.setNombre(txtName1.getText());
                pacienteCambio.setFechaNacimiento(txt.getText());
                pacienteCambio.setTipoPrograma(tipoPrograma);
                pacienteCambio.setHorario(txtHorarioCambio.getText());
                pacienteCambio.setTerapia(terapia);
                pacienteCambio.setEdad(Integer.parseInt(txtAge2.getText()));
                //se actualiza en la base de datos
                System.out.println(encargadoAuxi.toString());
                System.out.println(pacienteCambio.toString());
                if (controlDatos.actualizarEncargado(encargadoAuxi)
                        && controlDatos.actualizarPaciente(pacienteCambio)) {
                    controlDatos.mensajeOk();
                } else {
                    controlDatos.mensajeNoOk();
                }
            }
        }
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
        llenarTablaPacientes(listPacientes);
        //reiniciar valores
        this.rutadpiPaciente = "";
        this.encargadoAuxi = null;
        this.pacienteCambio = null;
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgeKeyTyped

    private void txtAge2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge2KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAge2KeyTyped

    private void txtSearchByEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchByEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchByEncargadoActionPerformed

    private void labelDesactivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDesactivarMouseClicked
        // TODO add your handling code here:
        if (tablePacientes.getSelectedRow() >= 0) {
            this.pacienteInfo = listPacientes.get(tablePacientes.getSelectedRow());
            Paciente paciente = controlDatos.getPacientePorCarne(
                    controlDatos.getPacienteDB().getPacientes(),
                    pacienteInfo);
            paciente.setActivo(false);
            controlDatos.actualizarPaciente(paciente);
            listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
            llenarTablaPacientes(listPacientes);
        }
    }//GEN-LAST:event_labelDesactivarMouseClicked

    private void btnAllPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllPacientesActionPerformed
        // TODO add your handling code here:
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes();
        llenarTablaPacientes(listPacientes);
    }//GEN-LAST:event_btnAllPacientesActionPerformed

    private void btnAtivesPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivesPacientesActionPerformed
        // TODO add your handling code here:
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(true);
        llenarTablaPacientes(listPacientes);
    }//GEN-LAST:event_btnAtivesPacientesActionPerformed

    private void btnDesactivePacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivePacientesActionPerformed
        // TODO add your handling code here:
        listPacientes = controlDatos.getPacienteInfoDB().getPacientes(false);
        llenarTablaPacientes(listPacientes);
    }//GEN-LAST:event_btnDesactivePacientesActionPerformed

    private void btnlovePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlovePDFActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URI("https://www.ilovepdf.com/es"));
        } catch (IOException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnlovePDFActionPerformed

    private void btnUrlEditpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrlEditpdfActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URI("https://www.ilovepdf.com/es/editar-pdf"));
        } catch (IOException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUrlEditpdfActionPerformed

    private void btnUrlJoinPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrlJoinPDFActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URI("https://www.ilovepdf.com/es/unir_pdf"));
        } catch (IOException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUrlJoinPDFActionPerformed

    private void btnUrlConvertImgeToPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrlConvertImgeToPDFActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URI("https://www.ilovepdf.com/es/jpg_a_pdf"));
        } catch (IOException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(WindowSoyKpaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUrlConvertImgeToPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllPacientes;
    private javax.swing.JButton btnAtivesPacientes;
    private javax.swing.JButton btnCambiarCondicion;
    private javax.swing.JButton btnChangeTerapista;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearTerapista;
    private javax.swing.JButton btnDesactivePacientes;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JButton btnSaveTerapista;
    private javax.swing.JButton btnSearchReportFecha;
    private javax.swing.JButton btnUrlConvertImgeToPDF;
    private javax.swing.JButton btnUrlEditpdf;
    private javax.swing.JButton btnUrlJoinPDF;
    private javax.swing.JButton btnlovePDF;
    private javax.swing.JCheckBox checkCambiarOcupacional;
    private javax.swing.JCheckBox checkHabla;
    private javax.swing.JCheckBox checkHablaCambiar;
    private javax.swing.JCheckBox checkOcupacional;
    private javax.swing.JCheckBox checkPsicologico;
    private javax.swing.JCheckBox checkPsicologicoCambiar;
    private javax.swing.JComboBox<String> comboTerapistas;
    private com.toedter.calendar.JDateChooser dateChooser;
    private com.toedter.calendar.JDateChooser dateChooser1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelAddReport;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelChangeFile;
    private javax.swing.JLabel labelDesactivar;
    private javax.swing.JLabel labelHerramientas;
    private javax.swing.JLabel labelNuevoPaciente;
    private javax.swing.JLabel labelPacientes;
    private javax.swing.JLabel labelSearchbycarne;
    private javax.swing.JLabel labelSearchporDpi;
    private javax.swing.JLabel labelSelectFilePaciente;
    private javax.swing.JLabel labelSelectFilePaciente1;
    private javax.swing.JLabel labelTerapistas;
    private javax.swing.JLabel labelVerInformación;
    private javax.swing.JLabel labelVerReporte;
    private javax.swing.JList<String> listCondiciones;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelAutor;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelHerramientas;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelNuevoPaciente;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelTerapistas;
    private javax.swing.JRadioButton radio100;
    private javax.swing.JRadioButton radio100cambiar;
    private javax.swing.JRadioButton radio50;
    private javax.swing.JRadioButton radio50cambiar;
    private javax.swing.JRadioButton radioIngresos1;
    private javax.swing.JRadioButton radioIngresos2;
    private javax.swing.JRadioButton radioIngresos3;
    private javax.swing.JRadioButton radioIngresosMayores1000;
    private javax.swing.JRadioButton radioIngresosMenor1000;
    private javax.swing.JRadioButton radioIngresosNofijos;
    private javax.swing.JRadioButton radioNoBecado;
    private javax.swing.JRadioButton radioNoBecadoCambiar;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JTable tableTerapistas;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAge2;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCambiarCondicion;
    private javax.swing.JTextField txtCarne;
    private javax.swing.JTextField txtCarne1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtDpiEncargado;
    private javax.swing.JTextField txtDpiEncargado1;
    private javax.swing.JTextField txtEnfermedad;
    private javax.swing.JTextField txtEnfermedad1;
    private com.toedter.calendar.JDateChooser txtFecha1;
    private com.toedter.calendar.JDateChooser txtFecha2;
    private javax.swing.JTextField txtFileChange;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtHorarioCambio;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtNameEncargado;
    private javax.swing.JTextField txtNameEncargado1;
    private javax.swing.JTextField txtNombreTerapista;
    private javax.swing.JTextField txtOtraCondición;
    private javax.swing.JTextField txtOtraCondición1;
    private javax.swing.JTextField txtSearchByEncargado;
    private javax.swing.JTextField txtSearchCarne;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTerapiaCambio;
    private javax.swing.JTextField txtTerapistaInfoCambio;
    private javax.swing.JTextField txtdpiTerapista;
    private javax.swing.JTextField txtrutadpibeneficiario;
    // End of variables declaration//GEN-END:variables

    private void establecerFocus() {
        JTextField auxiText = (JTextField) dateChooser.getDateEditor().getUiComponent();
        KeyListener focus;
        focus = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    if (e.getComponent().equals(txtCarne)) {
                        if (listPacientes.isEmpty()) {
                            txtCarne.setText("1");
                        } else {
                            int id = Integer.parseInt(listPacientes.get(listPacientes.size() - 1).getCarne()) + 1;
                            txtCarne.setText(id + "");
                        }
                        txtName.requestFocus();
                    } else if (e.getComponent().equals(txtName)) {
                        dateChooser.requestFocus();
                    } else if (e.getComponent().equals(dateChooser.getDateEditor().getUiComponent())) {
                        txtAge.setText(controlDatos.getFechaDB().getAñosTranscurridos(auxiText.getText()));
                        txtAge.requestFocus();
                    } else if (e.getComponent().equals(txtAge)) {
                        radio100.requestFocus();
                    } else if (e.getComponent().equals(txtDpiEncargado)) {
                        //en caso de que ya existe los datos del encargado
                        encargadoAuxi = controlDatos.getEncargadoDB().getEncargado(txtDpiEncargado.getText());
                        if (encargadoAuxi != null) {
                            txtNameEncargado.setText(encargadoAuxi.getNombre());
                            txtDireccion.setText(encargadoAuxi.getDireccion());
                            txtTelefono.setText(encargadoAuxi.getTelefono());
                            try {
                                switch (encargadoAuxi.getCondicionEconomica()) {
                                    case "Ingresos inferiores a Q 1,000":
                                        radioIngresos1.setSelected(true);
                                        break;
                                    case "Ingresos superiores a Q 1,000":
                                        radioIngresos2.setSelected(true);
                                        break;
                                    case "No tiene ingresos fijos":
                                        radioIngresos3.setSelected(true);
                                        break;
                                    default:
                                        break;
                                }
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage() + " ocurrió algo");
                            }
                        } else {
                            System.out.println("hola txts");
                            txtNameEncargado.setText("");
                            txtDireccion.setText("");
                            txtTelefono.setText("");
                        }
                        txtNameEncargado.requestFocus();
                    } else if (e.getComponent().equals(txtNameEncargado)) {
                        txtTelefono.requestFocus();
                    } else if (e.getComponent().equals(txtTelefono)) {
                        txtDireccion.requestFocus();
                    } else if (e.getComponent().equals(txtdpiTerapista)) {
                        txtNombreTerapista.requestFocus();
                    }
                }
            }
        };
        auxiText.addKeyListener(focus);
        txtName.addKeyListener(focus);
        txtCarne.addKeyListener(focus);
        txtAge.addKeyListener(focus);
        txtDireccion.addKeyListener(focus);
        txtDpiEncargado.addKeyListener(focus);
        txtTelefono.addKeyListener(focus);
        txtNameEncargado.addKeyListener(focus);
        dateChooser.addKeyListener(focus);
        txtdpiTerapista.addKeyListener(focus);
        txtNombreTerapista.addKeyListener(focus);
    }

    private void llenarCondiciones(JList<String> listCondiciones) {
        listCondiciones.setListData(controlDatos.getCondiciones());
    }

    private void llenarComboTerapista(JComboBox comboTerapistas) {
        for (Terapista t : controlDatos.getTerapistaDB().getTerapistas()) {
            comboTerapistas.addItem(t.toString());
        }
    }

    private void agregarPaciente(boolean pacienteConArchivo, Paciente nuevoPaciente) {
        if (pacienteConArchivo) {
            if (controlDatos.getPacienteDB().insertWithFile(nuevoPaciente)) {
                //todo bien
                JOptionPane.showMessageDialog(null,
                        "Se ha guardado los datos correctamente.",
                        "GUARDANDO DATOS",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                //algo paso
                JOptionPane.showMessageDialog(null,
                        "No pudimos guardar los datos.",
                        "ERROR AL GUARDAR DATOS",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (controlDatos.getPacienteDB().insertWithoutFile(nuevoPaciente)) {
                //todo bien
                JOptionPane.showMessageDialog(null,
                        "Se ha guardado los datos correctamente.",
                        "GUARDANDO DATOS",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                //algo paso
                JOptionPane.showMessageDialog(null,
                        "No pudimos guardar los datos.",
                        "ERROR AL GUARDAR DATOS",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void llenarTablaPacientes(List<PacienteInfo> listPacientes) {
        dfModel = (DefaultTableModel) tablePacientes.getModel();
        dfModel.setRowCount(0);
        for (int i = 0; i < listPacientes.size(); i++) {
            String[] data = new String[]{
                listPacientes.get(i).getCarne(),
                listPacientes.get(i).getNombre(),
                listPacientes.get(i).getFecha(),
                listPacientes.get(i).getTipoPrograma(),
                listPacientes.get(i).getTerapista(),
                listPacientes.get(i).getTerapia(),
                listPacientes.get(i).getEcargado(),
                listPacientes.get(i).getTelefono()
            };
            dfModel.addRow(data);
        }
    }

    private void llenarTablaTerapistas(List<Terapista> terapistas) {
        dfModel = (DefaultTableModel) tableTerapistas.getModel();
        dfModel.setRowCount(0);
        for (Terapista terapista : terapistas) {
            String[] data = new String[]{terapista.getDpi(), terapista.getNombre()};
            dfModel.addRow(data);
        }
    }

    private String getReportString(List<Reporte> listReport, PacienteInfo pacienteInfo) {
        String r = "";
        r += "Carné: " + pacienteInfo.getCarne() + "  Nombre: " + pacienteInfo.getNombre();
        r += "\n\n";
        for (int i = 0; i < listReport.size(); i++) {
            r += listReport.get(i).getFecha();
            r += "\n";
            r += listReport.get(i).getContenido();
            r += "\n\n";
        }
        return r;
    }

    private void limpiarCamposNuevoPaciente() {
        txtCarne.setText("");
        txtAge.setText("");
        txtDireccion.setText("");
        txtDpiEncargado.setText("");
        txtEnfermedad.setText("");
        txtName.setText("");
        txtNameEncargado.setText("");
        txtOtraCondición.setText("");
        txtTelefono.setText("");
        radio100.setSelected(false);
        radio50.setSelected(false);
        radioNoBecado.setSelected(false);
        checkHabla.setSelected(false);
        checkOcupacional.setSelected(false);
        checkPsicologico.setSelected(false);
        txtHorario.setText("");
        radioIngresos1.setSelected(false);
        radioIngresos2.setSelected(false);
        radioIngresos3.setSelected(false);
        this.encargadoAuxi = null;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

}
