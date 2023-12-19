/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.controldata;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pacientessoykpaz.backend.entidad.Encargado;
import com.pacientessoykpaz.backend.entidad.Paciente;
import com.pacientessoykpaz.backend.entidad.PacienteInfo;
import com.pacientessoykpaz.backend.entidad.Reporte;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ReportePDF {

    // Fonts definitions (Definición de fuentes).
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Font.NORMAL);

    public ReportePDF() {
    }

    /**
     * @param pdfNewFile  <code>String</code>
     * @param listReports
     * @param pacienteInfo
     * @param paciente
     * @param encargado
     */
    public void writePDF(File pdfNewFile, List<Reporte> listReports, PacienteInfo pacienteInfo, Paciente paciente, Encargado encargado) {

        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // Añadimos los metadatos del PDF
            document.addTitle("REPORTE POR CADA BENEFICIARIO");
            document.addSubject("Generando pdf");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Luis Baquiax LBS");
            document.addCreator("Luis Baquiax LBS");

            Chapter chapter = new Chapter(new Paragraph(""), 1);
            chapter.setNumberDepth(0);
            String espacio = "              ";
            String content = espacio + "Carné: " + pacienteInfo.getCarne() + "\n";
            content += espacio + "Nombre: " + pacienteInfo.getNombre()+ "\n";
            content += espacio + "Fecha de nacimiento: " + pacienteInfo.getFecha()+ "\n";
            content += espacio + "Edad: " + pacienteInfo.getEdad() + "\n";
            content += espacio + "Encargado: " + pacienteInfo.getEcargado() + "\n";
            content += espacio + "Teléfono: " + pacienteInfo.getTelefono() + "\n";
            content += espacio + "Dirección: " + encargado.getDireccion() + "\n";
            content += espacio + "Terapista: " + pacienteInfo.getTerapista() + "\n";

            String auxiTerapia = pacienteInfo.getTerapia().replaceAll(" ", ", ");

            content += espacio + "Terapia: " + pacienteInfo.getTerapia() + "\n";
            content += espacio + "Horario: " + pacienteInfo.getHorario() + "\n";
            content += espacio + "Posee enfermedad crónica: " + paciente.getEnfermedadCronica()+ "\n";

            String saltos = "\n";
            content += saltos;
            Paragraph parrafo = new Paragraph(content, paragraphFont);
            chapter.add(parrafo);
            // agregamos el logo
            Image image;
            try {
                image = Image.getInstance(getClass().getResource("/img/ong.png"));
                image.setAbsolutePosition(480, 740);
                image.scaleAbsoluteHeight(80f);
                image.scaleAbsoluteWidth(80f);
                chapter.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" + ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " + ex);
            }
            document.add(chapter);
            // Utilización de PdfPTable
            // Usamos varios elementos para añadir título y subtítulo

            Integer numColumns = 3;
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
            table.setWidths(new float[]{0.55f, 0.55f, 2.25f});
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // agregamos filas               
            columnHeader = new PdfPCell(new Phrase("No. "));
            columnHeader.setBackgroundColor(BaseColor.DARK_GRAY);
            columnHeader.setPadding(3f);

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setColor(BaseColor.WHITE);

            columnHeader.setPhrase(new Phrase("NO", font));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader.setPhrase(new Phrase("FECHA", font));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader.setPhrase(new Phrase("REPORTE", font));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            table.setHeaderRows(1);
            //agregamos filas         
            for (int i = 0; i < listReports.size(); i++) {
                table.addCell((i + 1) + "");
                table.addCell(listReports.get(i).getFecha());
                 table.addCell(listReports.get(i).getContenido());
            }

            //agregamos la tabla al documento
            document.add(table);

            document.close();
            Desktop.getDesktop().open(pdfNewFile);
            System.out.println("Se ha generado el PDF correctamente.");
        } catch (DocumentException documentException) {
            System.out.println("No se pudo guardar el PDF " + documentException);
        } catch (IOException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
