/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfBorderArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdi.UI.EventosVentana;
import com.pdi.UI.VentanaMaestra;
import com.pdi.negocio.entidades.finales.Aliado;
import com.pdi.negocio.entidades.finales.Cliente;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public abstract class PdfGenerator {
    
    //Fuentes
    public static final Font NEGRITA_12 = new Font(Font.FontFamily.TIMES_ROMAN,
            12, Font.BOLD);
    public static final Font NORMAL_12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    public static final Font NORMAL_CUR_12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,
    Font.ITALIC);
    public static final Font NORMAL_SUB_12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,
    Font.UNDERLINE);
    public static final Font NEGRITA_SUB_12 = new Font(Font.FontFamily.TIMES_ROMAN, 12
    , Font.BOLD | Font.UNDERLINE);
    public static final Font NEGRITA_SUB_14 = new Font(Font.FontFamily.TIMES_ROMAN, 14
    , Font.BOLD | Font.UNDERLINE);
    
    public static final Font NEGRITA_14 = new Font(Font.FontFamily.TIMES_ROMAN,
            14, Font.BOLD);
    
    public static final Font NEGRITA_CUR_14 = new Font(Font.FontFamily.TIMES_ROMAN,
            14, Font.BOLDITALIC);
    
    public static final Font NEGRITA_12_VERDE = new Font(Font.FontFamily.TIMES_ROMAN,
            12, Font.BOLD);
    
    
    
    
    public static void generarPresupuesto(String lugar, Date fecha, float cantidad,
        String tipo, Cliente cliente, float precio, Aliado aliado, String path){
        
        try {
                       
            NEGRITA_12_VERDE.setColor(145, 189, 57);
            
            long miliSemana = System.currentTimeMillis() + (86400 * 7 * 1000);
            Date vtoPresup = new Date(miliSemana);
            float precioPers = precio / cantidad;
            int precioTotalInt = Math.round(precio);
            int precioPersInt = Math.round(precioPers);
            int cantPersonasInt= Math.round(cantidad);

            //Referencia al objeto Doc
            Document document = new Document(
                PageSize.A4, //Dimensiones
                36, //margIzq
                36, //margDer
                36, //margenSup
                36); // margenInf

            //Creamos el archivo fisico
            FileOutputStream salida = new FileOutputStream(path);
            
            //Referencia e inicializacion del objeto que "escribe" el PDF
            PdfWriter writer = PdfWriter.getInstance(document, salida);
            writer.setInitialLeading(0);
           
            
            //Imagen Logo
            Image logoPDI = Image.getInstance("Logo PDI.png");
            logoPDI.scaleToFit(215,205);
            logoPDI.setAlignment(Chunk.ALIGN_LEFT);
            //image.setAbsolutePosition(200, 200);
            
            //Imagen QR
            Image qr = Image.getInstance("QR PDI.png");
            qr.scaleToFit(211, 165);
            qr.setAbsolutePosition(295, PageSize.A4.getHeight() - 390);

            //Parrafo info evento
            Paragraph infoEvento = new Paragraph();
            infoEvento.add(new Chunk("Información del Evento", NEGRITA_SUB_12));
            infoEvento.add(Chunk.NEWLINE);
            infoEvento.add(negritaNormal("Solicitante: ", cliente.toString()));
            infoEvento.add(negritaNormal("Evento: ", tipo));
            infoEvento.add(negritaNormal("Cantidad de personas: ", Integer.toString(cantPersonasInt)));
            infoEvento.add(negritaNormal("Fecha: ", General.formatoFecha.format(fecha)));
            infoEvento.add(negritaNormal("Lugar:  ", lugar));
            infoEvento.add(Chunk.NEWLINE);
            infoEvento.setAlignment(Paragraph.ALIGN_LEFT);
            
            //Parrafo Modalidad del Servicio
            Paragraph modalidadServicio = new Paragraph();
            modalidadServicio.add(new Chunk("Modalidad Servicio Integral", NEGRITA_SUB_12 ));
            modalidadServicio.add(Chunk.NEWLINE);
            modalidadServicio.add(new Chunk("Nuestro servicio incluye la totalidad de lo referido a"
                    + " los elementos necesarios para el despacho de bebidas: Barras, Bartenders,"
                    + " Artículos de Coctelería, Insumos de calidad para los tragos y Mucha Buena Onda."
                    + " Con esta modalidad aseguramos la expedición de "
                    + "los tragos desde las 00hs hasta las 05hs, para que se desentiendan del asunto "
                    + "y disfruten al máximo.", NORMAL_12));
            modalidadServicio.setAlignment(Paragraph.ALIGN_LEFT);
           
            //Parrafo Ver Carta
            Paragraph verCarta = new Paragraph();
            verCarta.add(negritaNormal("\u2022 Carta de Tragos: ", "Ver archivo adjunto."));
            verCarta.setIndentationLeft(20);
            verCarta.add(Chunk.NEWLINE);
            verCarta.setAlignment(Paragraph.ALIGN_LEFT);
            
            
            //Parrafo Titulo Info Contratacion
            Paragraph infoContratacionTitulo = new Paragraph();
            infoContratacionTitulo.add(new Chunk("Información de Contratación", NEGRITA_SUB_12 ));
            infoContratacionTitulo.setAlignment(Paragraph.ALIGN_LEFT);
            
            //Parrafo Inf de Contratacion
            Paragraph infoContratacion = new Paragraph();
            infoContratacion.add(negritaNormal(
                    "\u2022 Método de contratación y reserva de la fecha: ",
                    "A través de contrato firmado por ambas partes. "));
            Phrase lineaCosto = new Phrase();
            lineaCosto.add(new Chunk("\u2022 Costo: ", NEGRITA_12));
            lineaCosto.add(new Chunk("$"+Integer.toString(precioPersInt) +" ", NEGRITA_14));
            lineaCosto.add(new Chunk("por persona ", NEGRITA_12));
            lineaCosto.add(new Chunk("(Total: $" + Integer.toString(precioTotalInt)+ ")", NEGRITA_14));
            infoContratacion.add(lineaCosto);
            infoContratacion.add(Chunk.NEWLINE);
            infoContratacion.add(negritaNormal(
                    "\u2022 Forma de Pago : ",
                    "50% al momento de la firma del contrato y 50% como máximo una semana antes del evento. "));
            infoContratacion.add(Chunk.NEWLINE);
            infoContratacion.setIndentationLeft(20);
            infoContratacion.setFirstLineIndent(0);
            infoContratacion.setAlignment(Paragraph.ALIGN_LEFT);
            
            //Parrafo Despedida
            Paragraph despedida = new Paragraph();
            despedida.add(new Phrase("Quedamos al aguardo de tus comentarios,", NEGRITA_14));
            despedida.add(Chunk.NEWLINE);
            despedida.add(new Phrase("Muchas Gracias.", NEGRITA_14));
            despedida.add(Chunk.NEWLINE);
            despedida.add(Chunk.NEWLINE);
            despedida.setAlignment(Paragraph.ALIGN_LEFT);
            
            //Parrafo Firma
            Paragraph firma = new Paragraph();
            firma.add(new Phrase("Piel de Iguana Tragos.-", NEGRITA_CUR_14));
            firma.add(Chunk.NEWLINE);
            firma.add(new Phrase("Cel.: 3462-15337860", NEGRITA_12_VERDE));
            firma.setAlignment(Paragraph.ALIGN_RIGHT);
            
            float llxLink = 279;
            float llyLink = PageSize.A4.getHeight() - 145;
            float anchoLink = 199;
            float altoLink = 16;
            
            //Link al facebook
            URL urlPDI = new URL("https://www.facebook.com/pieldeiguanatragos.vt");
            PdfAction irAlFace = new PdfAction(urlPDI);
            Rectangle linkLocation = new Rectangle(llxLink,
                        llyLink,
                    llxLink + anchoLink,
                    llyLink + altoLink);
            PdfAnnotation link = PdfAnnotation.createLink(writer,
                    linkLocation,
                    PdfAnnotation.HIGHLIGHT_NONE, irAlFace);
            link.setBorder(new PdfBorderArray(0, 0, 0));
            writer.addAnnotation(link);
            
            //Espacios Vacios
            Paragraph dosEspacios = new Paragraph();
            dosEspacios.add(Chunk.NEWLINE);
            dosEspacios.add(Chunk.NEWLINE);
            

            //Hay que abrir el Documento, llenarlo con los elemntos creados
            //en el orden que queremos y cerrarlo
            document.open();
            
            PdfContentByte cb = writer.getDirectContent();

            ColumnText ct = new ColumnText(cb);
            Phrase recuadro = new Phrase();
            recuadro.add(new Chunk("Piel de Iguana Tragos", NEGRITA_SUB_14));
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(new Chunk("Servicio de tragos para eventos", NEGRITA_12));
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(new Chunk("\"Piel de Iguana, para que tu noche única sea inigualable.\"",
                NORMAL_CUR_12));
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(Chunk.NEWLINE);
            Image logoFB = Image.getInstance("Icono FB.png");
            logoFB.scaleToFit(13, 13);
            recuadro.add(new Chunk(logoFB, 0, -3));
            recuadro.add(new Chunk("/pieldeiguanatragos.vt  -> Click Aquí!", NORMAL_12));
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(Chunk.NEWLINE);
            recuadro.add(new Chunk("Vencimiento del Prepuesto " + General.formatoFecha.format(vtoPresup), NORMAL_SUB_12));
 
            float llx = 279;
            float lly = PageSize.A4.getHeight() - 185;
            float ancho = 228;
            float alto = 150;
            
            ct.setSimpleColumn(recuadro, //Texto
                    llx, //punta inf izquierda (x)
                    lly,//punta inf izquierda (y) PageSize.A4.getHeight() - 185
                    llx + ancho, //ancho del cuadro
                    lly + alto, // alto del cuadro
                    15, //espaciado
                    Element.ALIGN_LEFT // Alineacion
            );
            
            ct.go();

            document.add(logoPDI);
            document.add(qr);
            document.add(dosEspacios);
            document.add(infoEvento);
            document.add(modalidadServicio);
            document.add(verCarta);
            document.add(infoContratacionTitulo);
            document.add(infoContratacion);
            document.add(despedida);
            document.add(firma);
            document.close();
            System.out.println("Archivo creado");
             int rta = JOptionPane.showConfirmDialog(VentanaMaestra.eventosCurrent,
                    "Se guardó el presupesto en:\n"+ path+"\nDesea abrirlo?",
                    "Presupuesto guardado", JOptionPane.YES_NO_OPTION);
            
            if(rta == JOptionPane.YES_OPTION){
                if (Desktop.isDesktopSupported()){
                  try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(VentanaMaestra.eventosCurrent,
                    "No se puede abrir el archivo. Ubiquelo en su equipo"
                            + "y abralo manualmente.",
                    "Error al abrir el archivo", JOptionPane.ERROR_MESSAGE);
                }  
                }else{
                    JOptionPane.showMessageDialog(VentanaMaestra.eventosCurrent,
                    "No se puede abrir el archivo. Ubiquelo en su equipo"
                            + "y abralo manualmente.",
                    "Error al abrir el archivo", JOptionPane.ERROR_MESSAGE);
                }
                
            } 
             
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.toString());
        } catch (DocumentException ex) {
            System.out.println("Error: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.toString());
        }
       
        
        
    }

       public static Phrase negritaNormal(String negrita, String normal){
       Phrase frase = new Phrase();
       frase.add(new Chunk(negrita, NEGRITA_12));
       frase.add(new Chunk(normal, NORMAL_12));
       frase.add(Chunk.NEWLINE);
       return frase;   
        
        
    }
    
}
