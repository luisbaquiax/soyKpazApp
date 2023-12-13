/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Condicion;
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
public class CondicionDB {

    private static final String INSERT = "INSERT INTO condicion(nombre) VALUES(?)";

    private static final String SELECT = "SELECT * FROM condicion";
    private ResultSet resultSet;
    private PreparedStatement statement;

    public boolean insert(Condicion condicion) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, condicion.getNombre());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CondicionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Condicion> getCondiciones() {
        List<Condicion> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Condicion.builder().nombre(resultSet.getString("nombre")).build());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CondicionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
