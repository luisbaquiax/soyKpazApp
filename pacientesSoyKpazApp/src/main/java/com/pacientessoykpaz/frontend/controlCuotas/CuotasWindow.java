/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pacientessoykpaz.frontend.controlCuotas;

import com.pacientessoykpaz.backend.controldata.ControlDatos;
import com.pacientessoykpaz.backend.entidad.Cuota;
import com.pacientessoykpaz.backend.entidad.Encargado;
import com.pacientessoykpaz.backend.entidad.Paciente;
import com.pacientessoykpaz.backend.entidad.PacienteInfo;
import com.pacientessoykpaz.frontend.WindowSoyKpaz;
import com.pacientessoykpaz.frontend.table.TableActionCellEditor;
import com.pacientessoykpaz.frontend.table.TableActionCellRender;
import com.pacientessoykpaz.frontend.table.TableActionEvent;
import com.pacientessoykpaz.util.Utiles;
import java.awt.Component;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class CuotasWindow extends javax.swing.JFrame {

    Utiles utiles;
    private ControlDatos controlDatos;
    private List<Cuota> listcuotas;
    private DefaultTableModel dfm;
    private CuotasWindow cuotasWindow;

    /**
     * Creates new form CuotasWindow
     */
    public CuotasWindow() {
        initComponents();
        setLocationRelativeTo(null);
        personalizarTabla();

        this.utiles = new Utiles();
        this.controlDatos = new ControlDatos();
        this.cuotasWindow = this;
        /**
         * tabla personalizada
         */
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_PENDIENTE);
        llenarTablaCuotas(listcuotas);
        /**
         * *
         *
         */
        llenarComboPacientes();

        //establecer el icon de la app cuando se está usando
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/ong.png")));
        try {
            //para que se parezca al tema de sistema operativo
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

        panelContent = new javax.swing.JPanel();
        panelMenu1 = new javax.swing.JPanel();
        btnUpdate = new rojeru_san.RSButton();
        btnCuotasPendientes = new rojeru_san.RSButton();
        btnCuotasAtrasadas = new rojeru_san.RSButton();
        btnCanceladas = new rojeru_san.RSButton();
        rSButton5 = new rojeru_san.RSButton();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCuotas = new rojerusan.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        comboPacientes = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new rojeru_san.rsfield.RSTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContent.setBackground(new java.awt.Color(255, 255, 255));

        panelMenu1.setLayout(new java.awt.GridLayout(1, 0));

        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnUpdate.setText("Actualizar registros");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelMenu1.add(btnUpdate);

        btnCuotasPendientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnCuotasPendientes.setText("Cuotas pendientes");
        btnCuotasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuotasPendientesActionPerformed(evt);
            }
        });
        panelMenu1.add(btnCuotasPendientes);

        btnCuotasAtrasadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnCuotasAtrasadas.setText("Cuotas atrasadas");
        btnCuotasAtrasadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuotasAtrasadasActionPerformed(evt);
            }
        });
        panelMenu1.add(btnCuotasAtrasadas);

        btnCanceladas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnCanceladas.setText("Cuotas canceladas");
        btnCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceladasActionPerformed(evt);
            }
        });
        panelMenu1.add(btnCanceladas);

        rSButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSButton5.setText("...");
        panelMenu1.add(rSButton5);

        tableCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año y mes", "Carné", "Nombre", "DPI encargado", "Encargado", "Tipo de pago", "Estado", "Monto", "Acción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCuotas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCuotas.setRowHeight(35);
        jScrollPane1.setViewportView(tableCuotas);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        comboPacientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por paciente"));
        comboPacientes.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        comboPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPacientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Filtar por paciente");

        txtTotal.setEnabled(false);
        txtTotal.setPlaceholder("Total a pagar...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addComponent(panelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtTotal.setText("");
        List<Paciente> pacientes = controlDatos.getPacienteDB().getPacientes(true);
        String añoActual = LocalDate.now().getYear() + "";
        String mesActual = LocalDate.now().getMonth().toString();
        int mes = LocalDate.now().getMonthValue();
        for (int i = 0; i < pacientes.size(); i++) {
            Cuota cuota = new Cuota();
            cuota.setAño(añoActual);
            cuota.setMes(mesActual);
            cuota.setFechaLimite(añoActual + "-" + mes + "-05");
            cuota.setCarne(pacientes.get(i).getCarne());
            cuota.setDpiEncargado(pacientes.get(i).getDpiEncargado());
            cuota.setEstado(Utiles.CUOTA_PENDIENTE);
            cuota.setMonto(pacientes.get(i).getMonto());
            cuota.setTipoPago(Utiles.CUOTA_PENDIENTE);
            System.out.println("cuota ingresada " + cuota.toString());
            controlDatos.getCuotaDB().insert(cuota);

        }
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_PENDIENTE);
        //actualizamos las cuotas de acuerdo a las fechas
        for (int i = 0; i < listcuotas.size(); i++) {
            try {
                Cuota cuota = listcuotas.get(i);
                String fechaLimite = cuota.getFechaLimite();
                String fechaActual = LocalDate.now().toString();

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                Date limite = formato.parse(fechaLimite);
                Date actual = formato.parse(fechaActual);
                System.out.println(actual.getMonth());
                if (limite.equals(actual) || limite.after(actual)) {
                    cuota.setEstado(Utiles.CUOTA_PENDIENTE);
                } else if (limite.before(actual)) {
                    cuota.setEstado(Utiles.CUOTA_ATRASADA);
                }
                controlDatos.getCuotaDB().updateWhitoutFile(cuota);
            } catch (ParseException ex) {
                Logger.getLogger(CuotasWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        llenarTablaCuotas(listcuotas);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCuotasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuotasPendientesActionPerformed
        // TODO add your handling code here:
        txtTotal.setText("");
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_PENDIENTE);
        llenarTablaCuotas(listcuotas);
    }//GEN-LAST:event_btnCuotasPendientesActionPerformed

    private void btnCuotasAtrasadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuotasAtrasadasActionPerformed
        // TODO add your handling code here:
        txtTotal.setText("");
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_ATRASADA);
        llenarTablaCuotas(listcuotas);
    }//GEN-LAST:event_btnCuotasAtrasadasActionPerformed

    private void btnCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceladasActionPerformed
        // TODO add your handling code here:
        txtTotal.setText("");
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_CANCELADA);
        llenarTablaCuotas(listcuotas);
    }//GEN-LAST:event_btnCanceladasActionPerformed

    private void comboPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPacientesActionPerformed
        // TODO add your handling code here:
        System.out.println(comboPacientes.getSelectedItem());
        String selecteItem = comboPacientes.getSelectedItem() + "";
        String[] data = selecteItem.split(",");
        listcuotas = controlDatos.getCuotaDB().getList(Utiles.CUOTA_ATRASADA, data[0]);
        double total = 0;
        for (Cuota listcuota : listcuotas) {
            total += listcuota.getMonto();
        }
        txtTotal.setText("Total a cancelar: " + total);
        llenarTablaCuotas(listcuotas);
    }//GEN-LAST:event_comboPacientesActionPerformed

    public void llenarTablaCuotas(List<Cuota> list) {
        System.out.println("hola");
        dfm = (DefaultTableModel) tableCuotas.getModel();
        dfm.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            PacienteInfo pi = new PacienteInfo();
            pi.setCarne(list.get(i).getCarne());
            Paciente p = controlDatos.getPacientePorCarne(controlDatos.getPacienteDB().getPacientes(), pi);
            Encargado e = controlDatos.getEncargadoDB().getEncargado(list.get(i).getDpiEncargado());
            String[] data = new String[]{
                list.get(i).getAño() + "-" + list.get(i).getMes(),
                list.get(i).getCarne(),
                p.getNombre(),
                list.get(i).getDpiEncargado(),
                e.getNombre(),
                list.get(i).getTipoPago(),
                list.get(i).getEstado(),
                list.get(i).getMonto() + ""
            };
            dfm.addRow(data);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCanceladas;
    private rojeru_san.RSButton btnCuotasAtrasadas;
    private rojeru_san.RSButton btnCuotasPendientes;
    private rojeru_san.RSButton btnUpdate;
    private RSMaterialComponent.RSComboBoxMaterial comboPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelMenu1;
    private javax.swing.JPanel panelTable;
    private rojeru_san.RSButton rSButton5;
    private rojerusan.RSTableMetro tableCuotas;
    private rojeru_san.rsfield.RSTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void personalizarTabla() {

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onPay(int row) {
                System.out.println("Edit row : " + row);
                Cuota cuota = listcuotas.get(row);
                EditCuotaWindow edit = new EditCuotaWindow(controlDatos, cuota, cuotasWindow);
                edit.setVisible(true);
            }

            @Override
            public void onOtherAction(int row) {
                if (tableCuotas.isEditing()) {
                    tableCuotas.getCellEditor().stopCellEditing();
                }

                System.out.println("eliminar");
            }

            @Override
            public void onDelete(int row) {
                Cuota cuota = listcuotas.get(row);
                int opcion2 = (int) JOptionPane.showInternalConfirmDialog(
                        null,
                        "¿Desea eliminar el registro permanentemente?",
                        "ELIMINAR REGISTRO",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (opcion2 == 0) {
                    if (controlDatos.getCuotaDB().delete(cuota)) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Se ha eliminado el registro.",
                                "REGISTRO ELIMINADO",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "No se pudo eliminar el registro, lo sentimos.",
                                "REGISTRO NO ELIMINADO",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                System.out.println("on Delete : " + row);
            }
        };

        tableCuotas.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        tableCuotas.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
//        tableCuotas.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//                setHorizontalAlignment(SwingConstants.RIGHT);
//                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
//            }
//        });
    }

    public List<Cuota> getListcuotas() {
        return listcuotas;
    }

    public void setListcuotas(List<Cuota> list) {
        this.listcuotas = list;
    }

    private void llenarComboPacientes() {
        comboPacientes.removeAllItems();
        for (Paciente paciente : controlDatos.getPacienteDB().getPacientes()) {
            comboPacientes.addItem(paciente.comboFilter());
        }
    }

}
