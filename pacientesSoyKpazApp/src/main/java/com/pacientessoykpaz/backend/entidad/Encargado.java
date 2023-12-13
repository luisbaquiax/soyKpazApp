/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.entidad;

import lombok.*;

/**
 *
 * @author Luis
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Encargado {

    private String dpi;
    private String telefono;
    private String direccion;
    private String condicionEconomica;
    private String rutaDocumento;
    private String nombre;

}
