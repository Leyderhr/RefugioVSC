package reportes;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import conexion.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRGenericPrintElementParameterFactory;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReporteActividadCuidadoAnimal {
    JasperPrint jprint;

    public ReporteActividadCuidadoAnimal(int id) throws JRException {

        Conexion conexion = new Conexion();
        JasperReport jr= (JasperReport) JRLoader.loadObject(Objects.requireNonNull(getClass().getResource("/utilesReportes/Programa de Actividades de Cuidado para un Animal/ActividadesCuidadoAnimal.jasper")));
        Map parametro;
        parametro = new HashMap();
        parametro.put("ID_ANIMAL", id);
        jprint = JasperFillManager.fillReport(jr, parametro, conexion.conectar());
    }

    public void mostrarVentanaReporte(){
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

    public void exportarPDF_DOC() throws JRException {

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "ReporteActividadCuidadoAnimal.docx");
        exporter.exportReport();

        Document doc = new Document();

        // Load a Word document
        doc.loadFromFile("ReporteActividadCuidadoAnimal.docx");

        // Save the document to PDF
        doc.saveToFile("ReporteActividadCuidadoAnimalPDF.pdf", FileFormat.PDF);

        // Dispose resources
        doc.dispose();



    }
}
