/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.CondicionPaciente;
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
public class CondicionPacienteDB {

    private static final String INSERT = "INSERT INTO condicion_paciente(carne_paciente,nombre_condicion) VALUES(?,?)";
    private static final String SELECT_BY_PACIENTE = "SELECT * FROM condicion_paciente WHERE carne_paciente = ?";
    private ResultSet resultSet;
    private PreparedStatement statement;

    /**
     *
     * Ingresa una condicionPaciente a la DB
     *
     * @param c
     * @return
     */
    public boolean insert(CondicionPaciente c) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, c.getCarnePaciente());
            statement.setString(2, c.getNombreCondicion());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CondicionPacienteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Obtiene la lista de condiciones de un paciente
     *
     * @param carnePaciente
     * @return
     */
    public List<CondicionPaciente> getCondicionesByPaciente(String carnePaciente) {
        List<CondicionPaciente> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareCall(SELECT_BY_PACIENTE);
            statement.setString(1, carnePaciente);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(
                        CondicionPaciente.builder().
                                carnePaciente(resultSet.getString("carne_paciente")).
                                nombreCondicion(resultSet.getString("nombre_condicion")).
                                build());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CondicionPacienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
