/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.controldata;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ReportePDF {

    public void writePDF() {
        try {
            File arc = new File("C:\\Users\\Usuario\\Desktop\\Tabla de Tokens.pdf");
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(arc));
            String texto = "SOY KPAZ\n"
                    + "NOMBRE:\n"
                    + "FECHA DE NACIMIENTO:\n"
                    + "\n"
                    + "Path de archivo de salida: " + arc.getAbsolutePath() + "\n";
            
             Image image;
            try {
                image = Image.getInstance(getClass().getResource("/img/add.png"));
                image.setAlignment(Image.RIGHT);
                image.setAbsolutePosition(30, 750);
                image.scaleAbsoluteHeight(95f);
                image.scaleAbsoluteWidth(95);
                document.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" + ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " + ex);
            }
            document.add(new Paragraph(texto));
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
