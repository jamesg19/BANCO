<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="ReporteClass.Reporte4Cliente"%>
<%@page import="ReporteClass.Reporte1Cliente"%>
<%@page import="ReporteClass.Reporte2Gerente"%>
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
    <script src="../Resources/INFO/js/jquery.min.js"></script>
    <script src="../Resources/INFO/js/bootstrap.min.js"></script>
    <script src="../Resources/INFO/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="../Resources/INFO/js/Drag-and-Drop-File-Input.js"></script>
    <script src="../Resources/INFO/js/Profile-Edit-Form.js"></script>
    <script src="../Resources/INFO/js/Studious-selectbox.js"></script>
    <body align="center" >
        <%@ include file = "../PagesCliente/NavegaG.jsp" %>
        <%            
            String USER = null;
            
            USER = (String) request.getAttribute("USER");
            ArrayList<Reporte4Cliente> cambios = null;
            cambios = (ArrayList<Reporte4Cliente>) request.getAttribute("Reporte4");
        %>       

        %>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <h3 align="center" >Historial con el listado de solicitud de asociacion de cuenta recibidas con su estado</h3>
        
                   


        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <br><!-- comment -->
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>ID </th>
                        <th>Nombre</th>
                        <th>DPI</th>
                        <th>No. Cuenta</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody align="center" >
                    <%                  if (cambios != null) {   %> 
                <form action="reporteCC4PDF" method="GET" >
                    <br><!-- comment -->
                    <br><!-- comment -->


                    <div align="center" >

                        <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                        
                        <button  align="center" type="submit" class="btn btn-outline-success">Exportar PDF</button>
                    </div>
                </form> 
                    
                    <%           for (Reporte4Cliente histo : cambios) {%>          
                    <tr align="right">  
                        <td><%=histo.getCodigo()%></td>
                        <td><%=histo.getNombre()%></td>             
                        <td><%=histo.getDpi()%></td> 
                        <td><%=histo.getCuenta()%></td> 
                        <td><%=histo.getEstado()%></td>
                    </tr>          
                    <% }
                } else {%>
                <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
