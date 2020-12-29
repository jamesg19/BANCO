<%-- 
    Document   : BuscaEdita
    Created on : Nov 8, 2020, 8:49:22 PM
    Author     : james
--%>
<%@page import="Objetos.Cliente"%>
<%@page import="Objetos.Cajero"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Editar info</title>
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form.css">
        <link rel="stylesheet" href="Resources/INFO/css/styles.css">
    </head>
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
    
    <body >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>

        <%@ page import="Controlador.*" %>
        <br>
        <br>
        <br>
        <br>
        <%            String r = null;
        String busqueda = null;
            String USER = null;
            USER = (String) request.getAttribute("USER");
            ArrayList<Reporte2Gerente> cambioss = null;
           
            try {
                
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <div class="alert alert-success" role="alert">
            <h4 align="center" >Datos actualizados</h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>      
        <div align="center" class="alert alert-danger" role="alert">
            <h4 align="center" >No se han encontrado clientes con ese nombre</h4>
        </div>
        <%  }
            else if(r.equals("NOHAY")){%>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4 align="center" >No se han encontrado resultados</h4>
        </div> 
        <% } 
        }  catch (Exception e) {
            }%>
        <form  action="Reporte_Gerente6" method="GET" >
            <div align="center" >
                
                <br>
                <div align="center" class="col-md-8">
                    <h1 align="center" >Reporte 6</h1>
                    <h4 align="center" >Historial de transacciones de un cliente</h4>
                    <h4 align="center" >filtrado por nombre</h4>
                    <br><!-- comment -->
                    <h5 align="left" >Ingresa el nombre completo del cliente</h5>
                    <hr>
                    <div align="center" >   
                            <div align="center">
                                <div align="center" class="card">
                                    <div align="center" >
                                        <div class="form-group"><label>Ingresa la busqueda *</label>
                                            <input class="form-control mr-sm-2" type="search" placeholder="Buscar..." aria-label="Search" required="" name="busqueda">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <div align="left">

                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar </button>
                        </div>
                        <br>
                        <div align="left" class="form-row">
                            <input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                            <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                        </div>
                    </div>
                </div>       
            </div> 
        </form>


    </body>
    <%
        cambioss = (ArrayList<Reporte2Gerente>) request.getAttribute("Cajero");
        
        if (cambioss != null) {
            
    %>

    <%@ include file = "../PagesGerenteReporte/Transacciones6.jsp" %>

    <%
        } 
        %>
        


</html> 