/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.entidad;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Luis
 */
@Data
@Builder
public class Terapista {

    private String dpi;
    private String nombre;

    @Override
    public String toString() {
        return dpi + ", " + nombre;
    }
}
