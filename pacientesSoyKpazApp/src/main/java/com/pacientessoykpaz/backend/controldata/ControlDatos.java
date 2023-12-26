/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.controldata;

import com.pacientessoykpaz.backend.database.model.*;
import com.pacientessoykpaz.backend.entidad.Condicion;
import com.pacientessoykpaz.backend.entidad.Encargado;
import com.pacientessoykpaz.backend.entidad.Paciente;
import com.pacientessoykpaz.backend.entidad.PacienteInfo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.Data;

/**
 *
 * @author Luis
 */
@Data
public class ControlDatos {

    private CondicionDB condicionDB;
    private PacienteDB pacienteDB;
    private EncargadoDB encargadoDB;
    private TerapistaDB terapistaDB;
    private FechaDB fechaDB;
    private PacienteInfoDB pacienteInfoDB;
    private ReporteDB reporteDB;

    public ControlDatos() {
        this.condicionDB = new CondicionDB();
        this.pacienteDB = new PacienteDB();
        this.encargadoDB = new EncargadoDB();
        this.terapistaDB = new TerapistaDB();
        this.fechaDB = new FechaDB();
        this.pacienteInfoDB = new PacienteInfoDB();
        this.reporteDB = new ReporteDB();
    }

    public String[] getCondiciones() {
        String[] list = new String[condicionDB.getCondiciones().size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = condicionDB.getCondiciones().get(i).getNombre();
        }
        return list;
    }

    public boolean actualizarPaciente(Paciente paciente) {
        if (paciente.getFileBytes() == null) {
            return pacienteDB.updateWithoutFile(paciente);
        } else {
            return pacienteDB.updateWithFile(paciente);
        }
    }

    public boolean actualizarEncargado(Encargado encargado) {
        if (encargado.getFileBytes() == null) {
            return encargadoDB.updateWithoutFile(encargado);
        } else {
            return encargadoDB.updateWithFile(encargado);
        }
    }

    public void mensajeOk() {
        JOptionPane.showMessageDialog(null,
                "Se ha guardado los datos correctamente.",
                "GUARDANDO DATOS",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeNoOk() {
        JOptionPane.showMessageDialog(null,
                "No pudimos guardar los datos.",
                "ERROR AL GUARDAR DATOS",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public Paciente getPacientePorCarne(List<Paciente> list, PacienteInfo pacienteInfo) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCarne().equals(pacienteInfo.getCarne())) {
                return list.get(i);
            }
        }
        return null;
    }

    public void descargarDocumentos(byte[] arraysBytes, String path, String tipoArchivo) {
        FileOutputStream outPutStream = null;
        try {
            outPutStream = new FileOutputStream(path + "." + tipoArchivo);
            outPutStream.write(arraysBytes);
            Desktop.getDesktop().open(new File(path + "." + tipoArchivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outPutStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ControlDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
