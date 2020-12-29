package ExportarReporteCliente;

import BaseDatos.GestorReporteCliente;
import ExportarReporte.*;
import BaseDatos.GestorReporteGerente;
import Objetos.Cajero;
import Objetos.Cliente;
import Objetos.Historial_Cambios;
import Objetos.Transaccion;

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
@WebServlet("/reporteCCC3PDF")
public class ExportarReporteCliente3 extends HttpServlet {

    
    
    GestorReporteCliente gestor = new GestorReporteCliente();
    
    Cajero histo = new Cajero();
    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            String t = request.getParameter("t");
            request.setAttribute("t", t);
            String s = request.getParameter("s");
            request.setAttribute("s", s);
            String cuenta = request.getParameter("cuentaID");
            

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte3 Cliente.pdf");

            
            List<Transaccion> Histo = gestor.reporte3B(cuenta,t,s);
            
            
            File file = new File(request.getServletContext().getRealPath("/Resources/ReporteCliente/Reporte3Cliente.jrxml"));
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
