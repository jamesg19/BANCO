<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 PM
    Author     : james
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Objetos.Transaccion"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Cajero</title>

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
   
    <body align="center" >
        <%@ include file = "../PagesCajero/NavegaG.jsp" %>
        <%            String USER = null;
            String t=null;
            t=(String) request.getAttribute("t");
            USER = (String) request.getAttribute("USER");
            ArrayList<Transaccion> transaccion = null;
            transaccion = (ArrayList<Transaccion>) request.getAttribute("Transaccion");
            double totalDepositos=0;
            double totalRetiros=0;
        %>       

        <form align="center" action="Reporte_Cajero1" >
            <br>
            <br>
            <br>
            <br>
            <br>
            <h5 align="center" >Lista de depositos y retiros realizados durante su turno</h5>

        </form>
        
        <br>
        <div align="center" class="container profile profile-view" id="profile" >
        <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead align="center" >
                <tr>
                    <th>Codigo</th>
                    <th>ID Cuenta</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Tipo</th>
                    <th>Monto</th>
                    <th>ID Cajero</th>
                </tr>
            </thead>
            <tbody align="center" >
                <%                  if (transaccion != null) {%> 

            <form action="Reporte_Cajero1" method="GET" >
                <div align="center" >
                    <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                    <input value="<%=t%>" class="form-control" type="hidden" name="t">
                    <button align="center" type="submit" class="btn btn-outline-success">Exportar PDF</button>
                </div>
            </form> 


                <%           for (Transaccion transaccionn : transaccion) {
                if(transaccionn.getTipo().equalsIgnoreCase("CREDITO")){
                totalDepositos+=transaccionn.getMonto();
                    } else{
                     totalRetiros+=transaccionn.getMonto();
                    }
                
                %>          
                <tr valign="rigth">  
                    <td><%=transaccionn.getCodigo() %></td>
                    <td><%=transaccionn.getCuentaID() %></td>             
                    <td><%=transaccionn.getFecha() %></td> 
                    <td><%=transaccionn.getHora() %></td> 
                    <td><%=transaccionn.getTipo() %></td> 
                    <td><%=transaccionn.getMonto() %></td>
                    <td><%=transaccionn.getCajeroID() %></td>

                </tr>          
                <% }
                } %>
        </tbody>
    </table>
        
        </div>
        
        <h5>Total de Depositos (+) realizados: Q. <%=totalDepositos%></h5>
        <h5>Total de Retiros   (-) realizados: Q. <%=totalRetiros%></h5>
</body>
</html>
