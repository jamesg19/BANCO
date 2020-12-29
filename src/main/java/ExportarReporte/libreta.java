package ExportarReporte;

import BaseDatos.GestorReporteGerente;
import BaseDatos.GestorVerificar;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import ReporteClass.Libreta;
import ReporteClass.Reporte2Gerente;
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
@WebServlet("/libreta")
public class libreta extends HttpServlet {

    
    GestorVerificar gestor = new GestorVerificar();
    GestorReporteGerente gestor2 = new GestorReporteGerente();
    Reporte2Gerente histo = new Reporte2Gerente();
    Limite limit;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            String codCliente = request.getParameter("codCliente");
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Libreta.pdf");

            
            ArrayList<Libreta> Histo = gestor.libreta(codCliente, fecha, saldo);
            
            
            File file = new File(request.getServletContext().getRealPath("/Resources/ReportesGerente/Libreta.jrxml"));
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
