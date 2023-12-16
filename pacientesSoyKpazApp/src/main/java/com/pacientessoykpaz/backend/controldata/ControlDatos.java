/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.controldata;

import com.pacientessoykpaz.backend.database.model.*;
import com.pacientessoykpaz.backend.entidad.Condicion;
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
    private CondicionPacienteDB condicionPacienteDB;
    private PacienteInfoDB pacienteInfoDB;
    private ReporteDB reporteDB;

    public ControlDatos() {
        this.condicionDB = new CondicionDB();
        this.pacienteDB = new PacienteDB();
        this.encargadoDB = new EncargadoDB();
        this.terapistaDB = new TerapistaDB();
        this.fechaDB = new FechaDB();
        this.condicionPacienteDB = new CondicionPacienteDB();
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
}
