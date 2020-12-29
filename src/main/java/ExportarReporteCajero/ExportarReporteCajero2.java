package ExportarReporteCajero;

import BaseDatos.*;
import Objetos.Cajero;
import Objetos.Cliente;
import ReporteClass.Reporte2CajeroO;
import java.io.File;
import java.io.IOException;
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
@WebServlet("/exportCajero2")
public class ExportarReporteCajero2 extends HttpServlet {

    
    GestorReporteCajero gestorr = new GestorReporteCajero();

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

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte2 Cajero.pdf");

            
            List<Reporte2CajeroO> Histo = gestorr.Reporte2(USER,t, s);
            
            
            File file = new File(request.getServletContext().getRealPath("/Resources/ReporteCajero/Reporte2Cajero.jrxml"));
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
