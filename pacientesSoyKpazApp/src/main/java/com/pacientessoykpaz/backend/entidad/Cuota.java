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
public class Cuota {

    int id;
    String carne;
    String año;
    String mes;
    String dpiEncargado;
    String fechaLimite;
    String tipoPago;
    byte[] fileBytes;
    String tipoArchivo;
    String estado;
    double monto;
}
