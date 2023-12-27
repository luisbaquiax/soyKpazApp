/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.pacientessoykpaz.backend.entidad.Cuota;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class CuotaDB {

    private static final String INSERT
            = """
              INSERT INTO cuota(
                carne,
                año,
                mes,
                dpi_encargado,
                fecha_limite,
                tipo_pago,
                estado,
                monto
              )
              VALUES(?,?,?,?,?,?,?,?)
              """;
    private static final String UPDATE_WHIT_FILE = """
                                         UPDATE cuota SET
                                            tipo_pago=?,
                                            estado=?,
                                            monto=?,
                                            archivo=?,
                                            tipo_archivo=?
                                         WHERE id = ?
                                         """;

    private static final String UPDATE_WITHOUT_FILE = """
                                         UPDATE cuota SET
                                            tipo_pago=?,
                                            estado=?,
                                            monto=?
                                         WHERE id = ?
                                         """;
    private static final String SELECT_BY_ESTADO = "SELECT * FROM cuota WHERE estado = ?";
    private static final String DELETE = "DELETE FROM cuota WHERE id=?";
    private static final String SELECT = """
                                         SELECT * FROM cuota 
                                         WHERE 
                                         estado = ? AND año=? AND mes=? AND carne=?
                                         """;
    private PreparedStatement statement;
    private ResultSet resultSet;

    /**
     * Query:<br>
     * INSERT INTO cuota( carne, año, mes, dpi_encargado, fecha_limite,
     * tipo_pago, estado, monto ) VALUES(?,?,?,?,?,?,?,?)
     *
     * @param cuota
     * @return
     */
    public boolean insert(Cuota cuota) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, cuota.getCarne());
            statement.setString(2, cuota.getAño());
            statement.setString(3, cuota.getMes());
            statement.setString(4, cuota.getDpiEncargado());
            statement.setString(5, cuota.getFechaLimite());
            statement.setString(6, cuota.getTipoPago());

            statement.setString(7, cuota.getEstado());
            statement.setDouble(8, cuota.getMonto());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Query:<br>
     * UPDATE cuota SET tipo_pago=?, estado=?, monto=?, archivo=?,
     * tipo_archivo=? WHERE id = ?
     *
     * @param cuota
     * @return
     */
    public boolean update(Cuota cuota) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WHIT_FILE);
            statement.setString(1, cuota.getTipoPago());
            statement.setString(2, cuota.getEstado());
            statement.setDouble(3, cuota.getMonto());
            InputStream in = new ByteArrayInputStream(cuota.getFileBytes());
            statement.setBlob(4, in);
            statement.setString(5, cuota.getTipoArchivo());

            statement.setInt(6, cuota.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Query:<br>
     * UPDATE cuota SET tipo_pago=?, estado=?, monto=? WHERE id = ?
     *
     * @param cuota
     * @return
     */
    public boolean updateWhitoutFile(Cuota cuota) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WITHOUT_FILE);
            statement.setString(1, cuota.getTipoPago());
            statement.setString(2, cuota.getEstado());
            statement.setDouble(3, cuota.getMonto());

            statement.setInt(4, cuota.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Query:<br>
     * DELET FROM cuota WHERE id=?
     *
     * @param cuota
     * @return
     */
    public boolean delete(Cuota cuota) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(DELETE);
            statement.setInt(1, cuota.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Get lis of CUOTA
     *
     * @param estado
     * @return
     */
    public List<Cuota> getList(String estado) {
        List<Cuota> list = new ArrayList<>();
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT_BY_ESTADO);
            statement.setString(1, estado);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(get(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    private Cuota get(ResultSet resultSet) throws SQLException {
        Cuota cuota = new Cuota();
        if (resultSet.getBlob("archivo") != null) {
            Blob blob = resultSet.getBlob("archivo");
            byte[] arryasbites = blob.getBytes(1, (int) blob.length());
            cuota.setFileBytes(arryasbites);
            cuota.setTipoPago(resultSet.getString("tipo_archivo"));
        }
        cuota.setId(resultSet.getInt("id"));
        cuota.setAño(resultSet.getString("año"));
        cuota.setMes(resultSet.getString("mes"));
        cuota.setCarne(resultSet.getString("carne"));
        cuota.setDpiEncargado(resultSet.getString("dpi_encargado"));
        cuota.setFechaLimite(resultSet.getString("fecha_limite"));
        cuota.setEstado(resultSet.getString("estado"));
        cuota.setTipoPago(resultSet.getString("tipo_pago"));
        cuota.setMonto(resultSet.getDouble("monto"));
        return cuota;
    }
}
