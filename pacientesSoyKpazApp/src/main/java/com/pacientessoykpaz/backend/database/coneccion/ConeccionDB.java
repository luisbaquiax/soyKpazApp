/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.database.coneccion;

import java.sql.*;

/**
 *
 * @author Luis
 */
public class ConeccionDB {

    private static final String USER = "soykpazong";
    private static final String PASSWORD = "soykpaz124@";
    private static final String URL = "jdbc:mysql://localhost:3306/pacientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static ConeccionDB conexionSingleton = null;

    private static Connection CONECCION = null;

    /**
     * Realizamos la conección a mysql
     *
     * @throws SQLException
     */
    private ConeccionDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONECCION = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retornamos la coneción
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConeccion() throws SQLException {
        if (conexionSingleton == null) {
            conexionSingleton = new ConeccionDB();
        }
        return CONECCION;
    }
}
