/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pacientessoykpaz;

import com.pacientessoykpaz.frontend.WindowSoyKpaz;
import com.pacientessoykpaz.frontend.controlCuotas.CuotasWindow;

/**
 *
 * @author Luis
 */
public class PacientesSoyKpaz {

    public static void main(String[] args) {
        WindowSoyKpaz k = new WindowSoyKpaz();
        System.out.println(k.getWidth());
//        k.setVisible(true);
        new CuotasWindow().setVisible(true);
    }
}
