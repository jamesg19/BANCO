<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.Cajero"%>
<%@page import="Objetos.Gerente"%>
<%@page import="Objetos.Solicitud"%>
<%@page import="ReporteClass.Reporte2Gerente"%>
<%@page import="Objetos.Transaccion"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Cajero</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form_Verde.css">
        <link rel="stylesheet" href="Resources/INFO/css/styles.css">
        <link rel="stylesheet" href="js/dialogCSS.css">

    </head>
    <script src="../Resources/js/dialog.js"></script>
    <script src="../Resources/INFO/js/jquery.min.js"></script>
    <script src="../Resources/INFO/js/bootstrap.min.js"></script>
    <script src="../Resources/INFO/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="../Resources/INFO/js/Drag-and-Drop-File-Input.js"></script>
    <script src="../Resources/INFO/js/Profile-Edit-Form.js"></script>
    <script src="../Resources/INFO/js/Studious-selectbox.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>
    <script src="../Resources/js/dialogJS.js"></script>

    <body align="center" >

        <%  String USERRR = null;
        String busquedaa="";
            //String busqueda = null;
            USERRR = (String) request.getAttribute("USERr");
            //busqueda = (String) request.getAttribute("Busqueda");
            ArrayList<Reporte2Gerente> cambiosE = null;
            cambiosE = (ArrayList<Reporte2Gerente>) request.getAttribute("Cajero");
            String Mas="";
            String Fem="";
            String MA="";
            String VES="";
            int cont=0;
        %>       

        <%
        if(cambiosE !=null){
        busquedaa = (String) request.getAttribute("BUSQUEDA");
        %>
        <form action="reporteG6PDF" method="GET" >
            <div align="center" >

                <input value="<%=USERRR%>" class="form-control" type="hidden" name="USERR">
                
                <input align="center" value="<%=busquedaa%>" class="form-control" type="hidden" name="busqueda">
                <button  align="center" type="submit" class="btn btn-outline-danger"> <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/> Exportar PDF</button>
            </div>
        </form> 
           <% }
        
        %>
        
        
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <h3>Lista de Transacciones del cliente</h3> 
                <h4></h4>
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>No. </th>
                        <th>ID Transaccion</th>
                        <th>ID Cuenta</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>Monto Q. </th>
                    </tr>
                </thead>
                <tbody align="center" >
                    <%
                        if (cambiosE != null) {   %> 

                    <%           for (Reporte2Gerente solicitudd : cambiosE) {%>  
                    <% cont++; %>
                    <tr align="center">  
                        <td><%=cont%></td>
                        <td><%=solicitudd.getCodigo()%></td>
                        <td><%=solicitudd.getCuenta() %></td>
                        <td><%=solicitudd.getNombre()%></td> 
                        <td><%=solicitudd.getTipo()%></td>   
                        <td><%=solicitudd.getFecha()%></td> 
                        <td><%=solicitudd.getMonto()%></td>
                    </tr>          
                    <% }
                    } else {%>
                    <%}%>
                </tbody>
            </table>

            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->

        </div>
    </body>



</html>
