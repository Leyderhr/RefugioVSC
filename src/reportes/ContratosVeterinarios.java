package reportes;

import conexion.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;

public class ContratosVeterinarios {
    JasperPrint jprint;

    public ContratosVeterinarios() throws JRException {

        Conexion conexion = new Conexion();
        JasperReport jr= (JasperReport) JRLoader.loadObject(getClass().getResource("/utilesReportes/ActividadesCuidadoAnimal.jasper"));
        jprint = JasperFillManager.fillReport(jr, null, conexion.conectar());
    }

    public void mostrarVentanaReporte(){
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

    public void exportarPDF() throws JRException {

        JasperExportManager.exportReportToPdfFile(jprint, "C:\\informes JAsper\\PDF's\\InformePaisesMySQL.pdf");
    }
}
