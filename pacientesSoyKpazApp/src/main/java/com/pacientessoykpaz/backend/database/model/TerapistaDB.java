/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Terapista;
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
public class TerapistaDB {

    private static final String INSERT
            = """
              INSERT INTO terapista(nombre,dpi) VALUES(?,?)                          
             """;
    private static final String SELECT = "SELECT * FROM terapista";

    private ResultSet resultSet;
    private PreparedStatement statement;

    public boolean insert(Terapista terapista) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, terapista.getNombre());
            statement.setString(2, terapista.getDpi());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TerapistaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Terapista> getTerapistas() {
        List<Terapista> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(Terapista.builder().
                        dpi(resultSet.getString("dpi")).
                        nombre(resultSet.getString("nombre")).
                        build());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TerapistaDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
