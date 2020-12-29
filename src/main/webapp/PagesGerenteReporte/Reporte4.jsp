<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 3:45:43 AM
    Author     : james
--%>

<%@page import="ReporteClass.Reporte4Gerente"%>
<%@page import="Objetos.Transaccion"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte 4</title>

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
    <body align="center" >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%            
            String USER = null;
            USER = (String) request.getAttribute("USER");
            ArrayList<Reporte4Gerente> cambios = null;
            cambios = (ArrayList<Reporte4Gerente>) request.getAttribute("Reporte4");
        %>       
       


        %>

        <form action="reporteG4PDF" method="GET" >
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->

            <div align="center" >

                <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                <h4 >TOP 10 CLIENTES CON MAS DINERO Q. EN CUENTAS ></h4>

                <button  align="center" type="submit" class="btn btn-outline-danger"> <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/>Exportar PDF</button>
            </div>
        </form>                    
        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>Codigo Cliente</th>
                        <th>Nombre</th>
                        <th>Dpi</th>
                        <th>Codigo Cuenta</th>
                        <th>Credito disponible</th>

                    </tr>
                </thead>
                <tbody align="center" >
                    <%                  if (cambios != null) {   %> 

                    <%           for (Reporte4Gerente histo : cambios) {%>          
                    <tr valign="rigth">  
                        <td><%=histo.getCodigo()%></td>
                        <td><%=histo.getNombre() %></td>             
                        <td><%=histo.getDpi()%></td> 
                        <td><%=histo.getCodigoCuenta()%></td> 
                        <td>Q. <%=histo.getMonto()%></td>
                    </tr>          
                    <% }
                } else {%>
                <script>

                </script>
                <%}%>
                </tbody>
            </table>
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
        </div>
    </body>
</html>
