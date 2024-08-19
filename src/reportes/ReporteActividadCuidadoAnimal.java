package reportes;

import conexion.Conexion;
import net.sf.jasperreports.engine.*;
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

    public void exportarPDF() throws JRException {

        JasperExportManager.exportReportToPdfFile(jprint, "utilesReportes/Contratos Veteriarios/ContratosVeterinarios.jasper");
    }
}
