package ExportarReporteCliente;

import BaseDatos.GestorReporteCliente;
import ExportarReporte.*;
import BaseDatos.GestorReporteGerente;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import Objetos.Transaccion;
import ReporteClass.Reporte1Cliente;
import ReporteClass.Reporte2Cliente;
import ReporteClass.Reporte2Gerente;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.ws.rs.core.HttpHeaders;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author James
 */
@WebServlet("/reporteCC2PDF")
public class ExportarReporteCliente2 extends HttpServlet {

    
    GestorReporteCliente gestor = new GestorReporteCliente();
    GestorReporteCliente gestor2 = new GestorReporteCliente();
    Reporte1Cliente histo = new Reporte1Cliente();
    Limite limit;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            String fecha1 = request.getParameter("t");
            String fecha2 = request.getParameter("s");
            request.setAttribute("t", fecha1);
            request.setAttribute("s", fecha2);

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte2 Cliente.pdf");

            
            List<Reporte2Cliente> Histo = gestor.reporte2(USER,fecha1,fecha2);
            
              
            File file = new File(request.getServletContext().getRealPath("/Resources/ReporteCliente/Reporte2Cliente.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Histo);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("F1", "F1");
            parameters.put("F2", "F2");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
            
        } catch (IOException | NumberFormatException  e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }
}
