<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="ReporteClass.Reporte2Gerente"%>
<%@page import="Objetos.Transaccion"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte 2</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Resourcescss/bootstrap.css">
        <link rel="stylesheet" href="Resources/Navbar/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar.css">
        <link rel="stylesheet" href="Resources/Navbar/css/styles.css">
        <link rel="stylesheet" href="Resources/Table/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Table/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Table/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href=Resources/Table/css/Data-Table-1.css">
        <link rel="stylesheet" href="Resources/Table/css/Data-Table.css">
        <link rel="stylesheet" href="Resources/Table/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Table/css/gradient-navbar.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Table/css/styles.css">


    </head>
    <script src="../Resources/Table/js/jquery.min.js"></script>
    <script src="../Resources/Table/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="../Resources/Table/js/Fixed-navbar-starting-with-transparency.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>  
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>
    <script src="../Resources/INFO/js/jquery.min.js"></script>
    <script src="../Resources/INFO/js/bootstrap.min.js"></script>
    <script src="../Resources/INFO/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="../Resources/INFO/js/Drag-and-Drop-File-Input.js"></script>
    <script src="../Resources/INFO/js/Profile-Edit-Form.js"></script>
    <script src="../Resources/INFO/js/Studious-selectbox.js"></script>
    <body align="center" >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%            
            String USER = null;
            Double limite = null;
            limite = (Double) request.getAttribute("LIMITE");
            USER = (String) request.getAttribute("USER");
            ArrayList<Reporte2Gerente> cambios = null;
            cambios = (ArrayList<Reporte2Gerente>) request.getAttribute("Reporte2");
        %>       
        <% if (limite == null) {%>
        <div class="alert alert-danger" role="alert">
            No hay un limite establecido.
            Ve a la seccion de cuentas y Mas para establecer el limite
        </div>   


        <%}%>


        %>

        <form action="reporteG2PDF" method="GET" >
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->

            <div align="center" >

                <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                <h4>Transacciones mayores al limite establecido ></h4>
                <h4>Limite Establecido Q. <%=limite%></h4>
                <input align="center" value="<%=limite%>" class="form-control" type="hidden" name="t">
                <button  align="center" type="submit" class="btn btn-outline-danger"> <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/> Exportar PDF</button>
            </div>
        </form>                    


        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <br><!-- comment -->
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>Codigo</th>
                        <th>Cuenta ID</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>Monto</th>
                    </tr>
                </thead>
                <tbody align="center" >
                    <%                  if (cambios != null) {   %> 

                    <%           for (Reporte2Gerente histo : cambios) {%>          
                    <tr valign="rigth">  
                        <td><%=histo.getCodigo()%></td>
                        <td><%=histo.getCuenta()%></td>             
                        <td><%=histo.getNombre()%></td> 
                        <td><%=histo.getTipo()%></td> 
                        <td><%=histo.getFecha()%></td>
                        <td>Q. <%=histo.getMonto()%></td>
                    </tr>          
                    <% }
                } else {%>
                <script>

                </script>
                <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
