package reportes;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import conexion.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.util.Objects;

public class ContratosVeterinariosActivos {

    JasperPrint jprint;

    public ContratosVeterinariosActivos() throws JRException {

        Conexion conexion = new Conexion();
        JasperReport jr= (JasperReport) JRLoader.loadObject(Objects.requireNonNull(getClass().getResource("/utilesReportes/Contratos veterinarios activos/ContratosVeterinariosActivos.jasper")));
        jprint = JasperFillManager.fillReport(jr, null, conexion.conectar());
    }

    public void mostrarVentanaReporte(){
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

    public void exportarPDF_DOC() throws JRException {

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "ContratosVeterinariosActivos.docx");
        exporter.exportReport();

        Document doc = new Document();

        // Load a Word document
        doc.loadFromFile("ContratosVeterinariosActivos.docx");

        // Save the document to PDF
        doc.saveToFile("ContratosVeterinariosActivosPDF.pdf", FileFormat.PDF);

        // Dispose resources
        doc.dispose();



    }
}
