/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class FechaDB {

    private static final String YEARS_TRANSCURRIDOS = "SELECT TIMESTAMPDIFF(YEAR, ?, now()) AS años_transcurridos";

    /**
     * Calcula la cantidad de años que hay entre dos fechas
     *
     * @param fecha
     * @return
     */
    public String getAñosTranscurridos(String fecha) {
        String años = "";
        try {
            PreparedStatement statement = ConeccionDB.getConeccion().prepareStatement(YEARS_TRANSCURRIDOS);
            statement.setString(1, fecha);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                años = resultSet.getString("años_transcurridos");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(FechaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return años;
    }
}
