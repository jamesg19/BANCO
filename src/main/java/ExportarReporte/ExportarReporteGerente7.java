package ExportarReporte;

import BaseDatos.GestorReporteGerente;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import Objetos.Transaccion;
import ReporteClass.Reporte2Gerente;
import ReporteClass.Reporte4Gerente;
import ReporteClass.Reporte7Gerente;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/reporteG7PDF")
public class ExportarReporteGerente7 extends HttpServlet {

    
    GestorReporteGerente gestor = new GestorReporteGerente();
    Reporte7Gerente histo = new Reporte7Gerente();
    Reporte4Gerente repo4;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            String t = request.getParameter("t");
            request.setAttribute("t", t);
            String s = request.getParameter("s");
            request.setAttribute("s", s);
            
                ArrayList<Reporte7Gerente> repo7 = new ArrayList<Reporte7Gerente>();
                
                GestorReporteGerente gestor = new GestorReporteGerente();

                repo7 = gestor.reporte7(t, s);
            
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte7 Gerente.pdf");

            
            
            
            
            File file = new File(request.getServletContext().getRealPath("/Resources/ReportesGerente/Reporte7Gerente7.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(repo7);

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
