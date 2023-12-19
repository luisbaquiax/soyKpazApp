/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.PacienteInfo;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class PacienteInfoDB {

    private static final String SELECT
            = """
             SELECT p.carne, p.nombre, p.fecha_nacimiento, p.edad, p.tipo_programa, p.terapia, p.horario,
             t.nombre AS terapista, e.nombre AS encargado, e.telefono
             FROM paciente p
             INNER JOIN terapista t
             ON t.dpi = p.dpi_terapista
             INNER JOIN encargado e
             ON e.dpi= p.dpi_encargado
             ORDER BY p.carne
              """;
    private static final String SELECT_BY_ENCARGADO
            = """
             SELECT p.carne, p.nombre, p.fecha_nacimiento, p.edad, p.tipo_programa, p.terapia, p.horario,
             t.nombre AS terapista, e.nombre AS encargado, e.telefono
             FROM paciente p
             INNER JOIN terapista t
             ON t.dpi = p.dpi_terapista
             INNER JOIN encargado e
             ON e.dpi= p.dpi_encargado
             WHERE e.dpi = ?
             ORDER BY p.carne
              """;

    private static final String SELECT_BY_CARNE
            = """
             SELECT p.carne, p.nombre, p.fecha_nacimiento, p.edad, p.tipo_programa, p.terapia, p.horario,
             t.nombre AS terapista, e.nombre AS encargado, e.telefono
             FROM paciente p
             INNER JOIN terapista t
             ON t.dpi = p.dpi_terapista
             INNER JOIN encargado e
             ON e.dpi= p.dpi_encargado
             WHERE p.carne = ?
              """;
    private PreparedStatement statement;
    private ResultSet resultSet;

    /**
     * Lista de pacientes con la información importante
     *
     * @return
     */
    public List<PacienteInfo> getPacientes() {
        List<PacienteInfo> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteInfoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    /**
     * Lista de pacientes con la información importante por encargados
     *
     * @param dpiEncargado
     * @return
     */
    public List<PacienteInfo> getPacientes(String dpiEncargado) {
        List<PacienteInfo> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_BY_ENCARGADO);
            statement.setString(1, dpiEncargado);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteInfoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<PacienteInfo> getPacientesbyCarne(String carne) {
        List<PacienteInfo> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_BY_CARNE);
            statement.setString(1, carne);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteInfoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private PacienteInfo get(ResultSet resultSet) throws SQLException {
        return new PacienteInfo(
                resultSet.getString("carne"),
                resultSet.getString("nombre"),
                resultSet.getString("fecha_nacimiento"),
                resultSet.getString("edad"),
                resultSet.getString("tipo_programa"),
                resultSet.getString("terapia"),
                resultSet.getString("terapista"),
                resultSet.getString("encargado"),
                resultSet.getString("telefono"),
                resultSet.getString("horario"));
    }
}
