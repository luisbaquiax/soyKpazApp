/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Encargado;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
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
                                         INSERT INTO encargado(
                                         dpi,
                                         nombre,
                                         telefono,
                                         direccion,
                                         condicion_economica,
                                         tipo_archivo,
                                         archivo) 
                                         VALUES(?,?,?,?,?,?,?)
                                         """;

    private static final String UPDATE_WHIT_FILE
            = """
                    UPDATE encargado SET
                    nombre=?,
                    telefono=?, 
                    direccion=?, 
                    condicion_economica=?, 
                    tipo_documento=?, 
                    archivo=? 
                    WHERE dpi=?
              """;
    private static final String INSERT_WITHOUT_FILE
            = """
              INSERT INTO encargado(
                dpi,
                nombre,
                telefono,
                direccion,
                condicion_economica)
              VALUES(?,?,?,?,?)
              """;
    private static final String UPDATE_WITHOUT_FILE
            = """
               UPDATE encargado SET 
                nombre=?, 
                telefono=?, 
                direccion=?, 
                condicion_economica=? 
               WHERE dpi=?
              """;
    private ResultSet resultSet;
    private PreparedStatement statement;

    /**
     * Ingresa los datos del encargado en la base de datos
     *
     * @param encargado
     * @return
     */
    public boolean insertWithFile(Encargado encargado) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, encargado.getDpi());
            statement.setString(2, encargado.getNombre());
            statement.setString(3, encargado.getTelefono());
            statement.setString(4, encargado.getDireccion());
            statement.setString(5, encargado.getCondicionEconomica());
            statement.setString(6, encargado.getTipoDocumento());

            InputStream in = new ByteArrayInputStream(encargado.getFileBytes());
            statement.setBlob(7, in);

            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EncargadoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param encargado
     * @return
     */
    public boolean updateWithFile(Encargado encargado) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WHIT_FILE);
            statement.setString(1, encargado.getNombre());
            statement.setString(2, encargado.getTelefono());
            statement.setString(3, encargado.getDireccion());
            statement.setString(4, encargado.getCondicionEconomica());
            statement.setString(5, encargado.getTipoDocumento());

            InputStream in = new ByteArrayInputStream(encargado.getFileBytes());
            statement.setBlob(6, in);

            statement.setString(7, encargado.getDpi());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EncargadoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Ingresa los datos del encargado en la base de datos
     *
     * @param encargado
     * @return
     */
    public boolean insertWithoutFile(Encargado encargado) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT_WITHOUT_FILE);
            statement.setString(1, encargado.getDpi());
            statement.setString(2, encargado.getNombre());
            statement.setString(3, encargado.getTelefono());
            statement.setString(4, encargado.getDireccion());
            statement.setString(5, encargado.getCondicionEconomica());

            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EncargadoDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param encargado
     * @return
     */
    public boolean updateWithoutFile(Encargado encargado) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WITHOUT_FILE);
            statement.setString(1, encargado.getNombre());
            statement.setString(2, encargado.getTelefono());
            statement.setString(3, encargado.getDireccion());
            statement.setString(4, encargado.getCondicionEconomica());

            statement.setString(5, encargado.getDpi());

            statement.executeUpdate();
            statement.close();
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
        Encargado e = null;
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_ENCARGADO);
            statement.setString(1, dpi);
            resultSet = statement.executeQuery();
            e = new Encargado();
            while (resultSet.next()) {
                e.setDpi(dpi);
                e.setCondicionEconomica(resultSet.getString("condicion_economica"));
                e.setDireccion(resultSet.getString("direccion"));
                e.setTelefono(resultSet.getString("telefono"));
                e.setNombre(resultSet.getString("nombre"));
                e.setTipoDocumento(resultSet.getString("tipo_archivo"));
                Blob blob = resultSet.getBlob("archivo");
                if (blob != null) {
                    byte[] aray = blob.getBytes(1, (int) blob.length());
                    e.setFileBytes(aray);
                }
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
