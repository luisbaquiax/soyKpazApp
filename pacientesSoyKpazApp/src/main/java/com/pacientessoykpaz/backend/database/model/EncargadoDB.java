/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Encargado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class EncargadoDB {

    private static final String SELECT_ENCARGADO = "SELECT * FROM encargado WHERE dpi = ?";
    private static final String INSERT = """
                                         INSERT INTO encargado(dpi,nombre,telefono,direccion,condicion_economica,ruta_documento) 
                                         VALUES(?,?,?,?,?,?)
                                         """;
    private ResultSet resultSet;
    private PreparedStatement statement;

    /**
     * Ingresa los datos del encargado en la base de datos
     *
     * @param encargado
     * @return
     */
    public boolean insert(Encargado encargado) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, encargado.getDpi());
            statement.setString(2, encargado.getNombre());
            statement.setString(3, encargado.getTelefono());
            statement.setString(4, encargado.getDireccion());
            statement.setString(5, encargado.getCondicionEconomica());
            statement.setString(6, encargado.getRutaDocumento());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EncargadoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Obtiene un ecargado por medio de su DPI
     *
     * @param dpi
     * @return
     */
    public Encargado getEncargado(String dpi) {
        try {
            Encargado e = new Encargado();
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_ENCARGADO);
            statement.setString(1, dpi);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                e.setDpi(dpi);
                e.setCondicionEconomica(resultSet.getString("condicion_economica"));
                e.setDireccion(resultSet.getString("direccion"));
                e.setTelefono(resultSet.getString("telefono"));
                e.setNombre(resultSet.getString("nombre"));
                e.setRutaDocumento(resultSet.getString("ruta_documento"));
            }
            resultSet.close();
            statement.close();
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EncargadoDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
