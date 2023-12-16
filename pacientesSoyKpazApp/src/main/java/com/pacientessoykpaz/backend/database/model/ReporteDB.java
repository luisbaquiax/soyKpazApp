/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Reporte;
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
public class ReporteDB {

    private static final String INSERT = "INSERT INTO reporte(fecha,carne_paciente,reporte) VALUES(?,?,?)";
    private static final String SELECT = "SELECT * FROM reporte WHERE carne_paciente = ?";
    private static final String SELECT_BETWEEN_DATE
            = """
              SELECT * FROM reporte 
              WHERE carne_paciente = ?
              AND fecha BETWEEN ? AND ?
             """;
    private PreparedStatement statement;
    private ResultSet resultSet;

    /**
     * Insert a new Reporte of paciente in the DDBB
     *
     * @param reporte
     * @return
     */
    public boolean insert(Reporte reporte) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, reporte.getFecha());
            statement.setString(2, reporte.getCarnePaciente());
            statement.setString(3, reporte.getContenido());

            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReporteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param carnePaciente
     * @return
     */
    public List<Reporte> getReportes(String carnePaciente) {
        List<Reporte> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT);
            statement.setString(1, carnePaciente);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReporteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param carnePaciente
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<Reporte> getReportes(String carnePaciente, String fecha1, String fecha2) {
        List<Reporte> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_BETWEEN_DATE);
            statement.setString(1, carnePaciente);
            statement.setString(2, fecha1);
            statement.setString(3, fecha2);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReporteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Reporte get(ResultSet resultSet) throws SQLException {
        return Reporte.builder().
                id(resultSet.getInt("id")).
                fecha(resultSet.getString("fecha")).
                carnePaciente(resultSet.getString("carne_paciente")).
                contenido(resultSet.getString("reporte")).
                build();
    }

}
