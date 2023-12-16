/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.util;

import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Luis
 */
public class ManejoRutas {

    private JFileChooser choser;

    public ManejoRutas() {
    }

    public String pathChoserSave(JFrame frame) {
        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        choser = new JFileChooser();
        choser.setDialogTitle("Guardar como");
        int seleccionado = choser.showSaveDialog(frame);
        if (seleccionado == APPROVE_OPTION) {
            return (choser.getSelectedFile().getAbsolutePath());
        }
        return "";
    }

    public String pathChoserOpen(JFrame frame) {
        UIManager.put("FileChooser.saveButtonText", "Seleccionar");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        choser = new JFileChooser();
        choser.setDialogTitle("Guardar como");
        int seleccionado = choser.showSaveDialog(frame);
        if (seleccionado == APPROVE_OPTION) {
            return (choser.getSelectedFile().getAbsolutePath());
        }
        return "";
    }
}
