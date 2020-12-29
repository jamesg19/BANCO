package ExportarReporte;

import BaseDatos.GestorReporteGerente;
import Objetos.Limite;
import ReporteClass.Reporte2Gerente;
import ReporteClass.Reporte3Gerente;
import ReporteClass.Reporte4Gerente;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet("/reporteG3PDF")
public class ExportarReporteGerente3 extends HttpServlet {
GestorReporteGerente gestor2 = new GestorReporteGerente();
    
    GestorReporteGerente gestor = new GestorReporteGerente();
    Reporte2Gerente histo = new Reporte2Gerente();
    Reporte4Gerente repo4;
    Limite limit;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            limit = gestor2.consultarLimite(USER);       
            Double limiteSuperior=limit.getLimite2();
            
                ArrayList<Reporte3Gerente> repo3 = new ArrayList<Reporte3Gerente>();
                
                GestorReporteGerente gestor = new GestorReporteGerente();

                repo3 = gestor.reporte3(limiteSuperior);
            
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte3 Gerente.pdf");

            
            List<Reporte3Gerente> Histo = gestor.reporte3(limiteSuperior);
            
            
            File file = new File(request.getServletContext().getRealPath("/Resources/ReportesGerente/Reporte3Gerentee.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Histo);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombre", "James");
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
