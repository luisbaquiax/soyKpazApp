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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    private String carne;
    private String nombre;
    private String fechaNacimiento;
    private String dpiEncargado;
    private String tipoPrograma;
    private String dpiTerapista;
    private String tipoArchivo;
    private int edad;
    private String enfermedadCronica;
    private String terapia;
    private byte[] fileBytes;
    private String horario;
    private String condicion;
    private boolean activo;
    private double monto;
}
