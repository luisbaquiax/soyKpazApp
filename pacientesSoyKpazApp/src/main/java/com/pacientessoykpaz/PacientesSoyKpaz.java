/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pacientessoykpaz;

import com.pacientessoykpaz.backend.controldata.ReportePDF;
import com.pacientessoykpaz.frontend.WindowSoyKpaz;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class PacientesSoyKpaz {

    public static void main(String[] args) {
        WindowSoyKpaz k = new WindowSoyKpaz();
        System.out.println(k.getWidth());
        k.setVisible(true);
    }
}
