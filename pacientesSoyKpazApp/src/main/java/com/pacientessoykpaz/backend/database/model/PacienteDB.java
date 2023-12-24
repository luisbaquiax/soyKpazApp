/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.model;

import com.pacientessoykpaz.backend.database.coneccion.ConeccionDB;
import com.pacientessoykpaz.backend.entidad.Paciente;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
public class PacienteDB {

    private static final String INSERT
            = """
              insert into paciente(
                carne,
                nombre,
                fecha_nacimiento,
                edad,
                dpi_encargado,
                tipo_programa,
                enfermedad_cronica,
                dpi_terapista,
                tipo_archivo,
                terapia,
                archivo,
                horario,
                condicion,
                activo) 
              values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)
              """;

    private static final String UPDATE_WHIT_FILE
            = """
              UPDATE paciente SET 
                nombre=?, 
                fecha_nacimiento=?, 
                edad=?, 
                dpi_encargado=?, 
                tipo_programa=?, 
                enfermedad_cronica=?, 
                dpi_terapista=?, 
                tipo_archivo=?, 
                terapia=?, 
                horario=?, 
                condicion=?, 
                activo=?, 
                archivo=?
              WHERE carne=?
              """;

    private static final String INSERT_WHITOUT_FILE
            = """
              insert into paciente(
                carne,
                nombre,
                fecha_nacimiento,
                edad,
                dpi_encargado,
                tipo_programa,
                enfermedad_cronica,
                dpi_terapista,
                terapia,
                horario,
                condicion,
                activo) 
              values(?,?,?,?,?,?,?,?,?,?,?,?)
              """;
    private static final String SELECT = "SELECT * FROM paciente";

    private static final String UPDATE_WHIT_OUT_FILE
            = """
              UPDATE paciente SET
                nombre = ?,
                fecha_nacimiento = ?,
                edad = ?,
                dpi_encargado = ?,
                tipo_programa = ?,
                enfermedad_cronica = ?,
                dpi_terapista = ?,
                terapia = ?,
                horario = ?,
                condicion = ?,
                activo = ?
              WHERE carne = ?
              """;

    private PreparedStatement statement;
    private ResultSet resutSet;

    /**
     *
     * @param paciente
     * @return
     */
    public boolean insertWithFile(Paciente paciente) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT);
            statement.setString(1, paciente.getCarne());
            statement.setString(2, paciente.getNombre());
            statement.setString(3, paciente.getFechaNacimiento());
            statement.setInt(4, paciente.getEdad());
            statement.setString(5, paciente.getDpiEncargado());
            statement.setString(6, paciente.getTipoPrograma());
            statement.setString(7, paciente.getEnfermedadCronica());
            statement.setString(8, paciente.getDpiTerapista());
            statement.setString(9, paciente.getTipoArchivo());
            statement.setString(10, paciente.getTerapia());
            statement.setString(11, paciente.getHorario());
            statement.setString(12, paciente.getCondicion());
            statement.setBoolean(13, paciente.isActivo());

            InputStream in = new ByteArrayInputStream(paciente.getFileBytes());
            statement.setBlob(11, in);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateWithFile(Paciente paciente) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WHIT_FILE);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getFechaNacimiento());
            statement.setInt(3, paciente.getEdad());
            statement.setString(4, paciente.getDpiEncargado());
            statement.setString(5, paciente.getTipoPrograma());
            statement.setString(6, paciente.getEnfermedadCronica());
            statement.setString(7, paciente.getDpiTerapista());
            statement.setString(8, paciente.getTipoArchivo());
            statement.setString(9, paciente.getTerapia());
            statement.setString(10, paciente.getHorario());
            statement.setString(11, paciente.getCondicion());
            statement.setBoolean(12, paciente.isActivo());

            InputStream in = new ByteArrayInputStream(paciente.getFileBytes());
            statement.setBlob(13, in);

            statement.setString(14, paciente.getCarne());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param paciente
     * @return
     */
    public boolean insertWithoutFile(Paciente paciente) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(INSERT_WHITOUT_FILE);
            statement.setString(1, paciente.getCarne());
            statement.setString(2, paciente.getNombre());
            statement.setString(3, paciente.getFechaNacimiento());
            statement.setInt(4, paciente.getEdad());
            statement.setString(5, paciente.getDpiEncargado());
            statement.setString(6, paciente.getTipoPrograma());
            statement.setString(7, paciente.getEnfermedadCronica());
            statement.setString(8, paciente.getDpiTerapista());
            statement.setString(9, paciente.getTerapia());
            statement.setString(10, paciente.getHorario());
            statement.setString(11, paciente.getCondicion());
            statement.setBoolean(12, paciente.isActivo());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param paciente
     * @return
     */
    public boolean updateWithoutFile(Paciente paciente) {
        try {
            statement = ConeccionDB.getConeccion().prepareStatement(UPDATE_WHIT_OUT_FILE);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getFechaNacimiento());
            statement.setInt(3, paciente.getEdad());
            statement.setString(4, paciente.getDpiEncargado());
            statement.setString(5, paciente.getTipoPrograma());
            statement.setString(6, paciente.getEnfermedadCronica());
            statement.setString(7, paciente.getDpiTerapista());
            statement.setString(8, paciente.getTerapia());
            statement.setString(9, paciente.getHorario());
            statement.setString(10, paciente.getCondicion());
            statement.setBoolean(11, paciente.isActivo());
            statement.setString(12, paciente.getCarne());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Paciente paciente) {
        return false;
    }

    public List<Paciente> getPacientes() {
        List<Paciente> list = new ArrayList<>();

        try {
            statement = ConeccionDB.getConeccion().prepareStatement(SELECT);
            resutSet = statement.executeQuery();
            while (resutSet.next()) {
                list.add(get(resutSet));
            }
            resutSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private Paciente get(ResultSet resultSet) throws SQLException {

        Blob blob = resultSet.getBlob("archivo");
        Paciente paciente = Paciente.builder().
                carne(resutSet.getString("carne")).
                nombre(resutSet.getString("nombre")).
                fechaNacimiento(resutSet.getString("fecha_nacimiento")).
                edad(resutSet.getInt("edad")).
                dpiEncargado(resutSet.getString("dpi_encargado")).
                tipoPrograma(resutSet.getString("tipo_programa")).
                enfermedadCronica(resutSet.getString("enfermedad_cronica")).
                dpiTerapista(resutSet.getString("dpi_terapista")).
                tipoArchivo(resutSet.getString("tipo_archivo")).
                terapia(resultSet.getString("terapia")).
                horario(resultSet.getString("horario")).
                condicion(resultSet.getString("condicion")).
                activo(resultSet.getBoolean("activo")).
                build();
        if (blob != null) {
            byte[] byteArray = blob.getBytes(1, (int) blob.length());
            paciente.setFileBytes(byteArray);
        }

        return paciente;
    }
}
