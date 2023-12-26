/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacientessoykpaz.backend.controldata;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.TabStop;
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
import java.util.ArrayList;
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
            addMetadata(document);

            //document.setNumberDepth(0);
            Font fontdata = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontdata.setColor(BaseColor.BLACK);

            // agregamos el logo
            Image image;
            try {
                image = Image.getInstance(getClass().getResource("/img/header.jpeg"));
                image.setAbsolutePosition(95, 720);
                image.scaleAbsoluteHeight(95f);
                image.scaleAbsoluteWidth(400f);
                document.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" + ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " + ex);
            }
            Paragraph paragraph = new Paragraph("\n\n\n\n\n");
            document.add(paragraph);
            // Utilización de PdfPTable
            // Usamos varios elementos para añadir título y subtítulo
//            Paragraph pa = new Paragraph("Nombre: " + paciente.getNombre(), fontdata);
////            pa.setTabSettings(new TabSettings(56f));
//           
//            pa.add(Chunk.TABBING);
//            pa.add(new Chunk("Fecha de nacimiento: " + paciente.getFechaNacimiento()));
//
//            pa.setTabSettings(new TabSettings(56f));
//            pa.add(Chunk.TABBING);
//            pa.add(new Chunk("Edad: " + paciente.getEdad()));
//
//            document.add(pa);
//            //agregando
//            Paragraph pa2 = new Paragraph("Encargado: " + encargado.getNombre(), fontdata);
//            pa2.setTabSettings(new TabSettings(56f));
//            pa2.add(Chunk.TABBING);
//            pa2.add(new Chunk("Dirección: " + encargado.getDireccion()));
//
//            pa2.setTabSettings(new TabSettings(56f));
//            pa2.add(Chunk.TABBING);
//            pa2.add(new Chunk("Teléfono: " + encargado.getTelefono()));
//
//            document.add(pa2);
//            //
//            Paragraph pa3 = new Paragraph("Terapista: " + pacienteInfo.getTerapista(), fontdata);
//            pa3.setTabSettings(new TabSettings(56f));
//            pa3.add(Chunk.TABBING);
//            pa3.add(new Chunk("Horario: " + paciente.getHorario()));
//            document.add(pa3);
//
//            Paragraph pa4 = new Paragraph("Terapia: " + paciente.getTerapia(), fontdata);
//            pa4.setTabSettings(new TabSettings(56f));
//            pa4.add(Chunk.TABBING);
//            pa4.add(new Chunk("Enfermedad crónica: " + paciente.getEnfermedadCronica()));
//            document.add(pa4);
            // We create the table (Creamos la tabla).
            PdfPTable tableInfo = new PdfPTable(2);
            tableInfo.setWidths(new float[]{3f, 3f});
            // Ahora llenamos la tabla del PDF
            PdfPCell cel;
            // agregamos filas               
            cel = new PdfPCell();
            cel.setBackgroundColor(BaseColor.WHITE);
            cel.setBorderColor(BaseColor.WHITE);
            cel.setPadding(3f);

            cel.setPhrase(new Phrase("Nombre: " + paciente.getNombre(), fontdata));
            tableInfo.addCell(cel);

            cel.setPhrase(new Phrase("Fecha de nacimiento: " + paciente.getFechaNacimiento(), fontdata));
            tableInfo.addCell(cel);

            tableInfo.setHeaderRows(1);

            cel.setPhrase(new Phrase("Dirección: " + encargado.getDireccion(), fontdata));
            tableInfo.addCell(cel);
            cel.setPhrase(new Phrase("Edad: " + paciente.getEdad(), fontdata));
            tableInfo.addCell(cel);

            cel.setPhrase(new Phrase("Encargado: " + encargado.getNombre(), fontdata));
            tableInfo.addCell(cel);
            cel.setPhrase(new Phrase("Teléfono: " + encargado.getTelefono(), fontdata));
            tableInfo.addCell(cel);

            cel.setPhrase(new Phrase("Terapista: " + pacienteInfo.getTerapista(), fontdata));
            tableInfo.addCell(cel);
            cel.setPhrase(new Phrase("Terapia: " + paciente.getTerapia(), fontdata));
            tableInfo.addCell(cel);

            cel.setPhrase(new Phrase("Enfermedad crónica: " + paciente.getEnfermedadCronica(), fontdata));
            tableInfo.addCell(cel);
            cel.setPhrase(new Phrase("Horario: " + paciente.getHorario(), fontdata));
            tableInfo.addCell(cel);

            document.add(tableInfo);

            //salto de linea
            document.add(new Paragraph("\n"));
            //
            Integer numColumns = 3;
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
            table.setWidths(new float[]{0.55f, 0.55f, 2.25f});
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // agregamos filas               
            columnHeader = new PdfPCell();
//            columnHeader.setBackgroundColor(BaseColor.DARK_GRAY);
            columnHeader.setBackgroundColor(new BaseColor(70, 84, 89));
            columnHeader.setPadding(3f);

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setColor(BaseColor.WHITE);

            columnHeader.setPhrase(new Phrase("#", font));
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

    private void addMetadata(Document document) {
        document.addTitle("REPORTE POR CADA BENEFICIARIO");
        document.addSubject("Generando pdf");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Luis Baquiax LBS");
        document.addCreator("Luis Baquiax LBS");
    }

}
