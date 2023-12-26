/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteInfo {

    String carne;
    String nombre;
    String fecha;
    String edad;
    String tipoPrograma;
    String terapia;
    String terapista;
    String ecargado;
    String telefono;
    String horario;
}
