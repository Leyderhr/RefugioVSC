package reportes;

import conexion.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;


public class ConceptoAdopciones {

    JasperPrint jprint;

    public ConceptoAdopciones() throws JRException {

        Conexion conexion = new Conexion();
        JasperReport jr= (JasperReport) JRLoader.loadObject(Objects.requireNonNull(getClass().getResource("/utilesReportes/Concepto de adpociones/PlanIngresoAdopcion.jasper")));
        jprint = JasperFillManager.fillReport(jr, null, conexion.conectar());
    }

    public void mostrarVentanaReporte(){
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);

        view.getContentPane().setLayout(null);

        view.getContentPane().getComponent(0).getComponentAt(0,0).getComponentAt(0,0).getComponentAt(0,2).setEnabled(false);
        view.getContentPane().getComponent(0).getComponentAt(0,0).getComponentAt(0,0).getComponentAt(0,2).setVisible(false);
        view.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && view.getContentPane().contains(e.getPoint())) {
                    try {
                        if(JOptionPane.showConfirmDialog(null, "¿Desea guardar el reporte como pdf?", "Guardar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
                            JFileChooser fileChooser = new JFileChooser();
                            fileChooser.setDialogTitle("Guardar reporte");
                            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                            FileNameExtensionFilter filtroPdf = new FileNameExtensionFilter("Archivos pdf", "pdf");

                            // Agregar el filtro al JFileChooser
                            fileChooser.addChoosableFileFilter(filtroPdf);

                            if(fileChooser.showDialog(view, "Guardar") == JFileChooser.APPROVE_OPTION)
                                exportarPDF_DOC(fileChooser.getSelectedFile());

                        }

                    } catch (JRException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        JOptionPane.showMessageDialog(null, "Para guardar el reporte de doble click en la barra " +
                "de herramientas", "Advertencia", JOptionPane.WARNING_MESSAGE);

    }

    public void exportarPDF_DOC(File currentD) throws JRException {

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "ConceptoAdopciones.docx");
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, String.valueOf(currentD));
        exporter.exportReport();

        Document doc = new Document();

        doc.loadFromFile(String.valueOf(currentD));
        doc.saveToFile(String.valueOf(currentD));

        try {
            Desktop.getDesktop().open(currentD);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Dispose resources
        doc.dispose();
    }
}
