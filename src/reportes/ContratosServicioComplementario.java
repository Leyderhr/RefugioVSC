package reportes;

import conexion.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.util.Objects;

public class ContratosServicioComplementario {

    JasperPrint jprint;

    public ContratosServicioComplementario() throws JRException {

        Conexion conexion = new Conexion();
        JasperReport jr= (JasperReport) JRLoader.loadObject(Objects.requireNonNull(getClass().getResource("/utilesReportes/Reporte contratos de servicios complementarios/ContratosServiciosComplementarios.jasper")));
        jprint = JasperFillManager.fillReport(jr, null, conexion.conectar());
    }

    public void mostrarVentanaReporte(){
        JasperViewer view = new JasperViewer(jprint, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

    public void exportarPDF() throws JRException {

        JasperExportManager.exportReportToPdfFile(jprint, "utilesReportes/Contratos Veteriarios/ContratosVeterinarios.jasper");
    }
}
