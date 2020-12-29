<%-- 
    Document   : CrearGerente
    Created on : Nov 8, 2020, 8:49:22 PM
    Author     : james
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Limites</title>
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form.css">
        <link rel="stylesheet" href="Resources/INFO/css/Studious-selectbox.css">
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
        <%            String r = null;
            String USER = null;
            Double limite = null;
            
            USER = (String) request.getAttribute("USER");
            try {
            limite = (Double) request.getAttribute("LIMITE");
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <br>
        <br>
        <div class="alert alert-success" role="alert">
            <h4 align="center" >Limite establecido Exitosamente </h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">

            <h4 align="center" >Error al Agregar el limite</h4>
        </div>
        <%  }
            } catch (Exception e) {
            }%>
        <div align="center" class="container profile profile-view" id="profile">
            <form  action="CrearLimite" method="GET" >
                
                    <div align="center" class="col-md-8">
                        <br>    
                        <br>
                        <br>
                        <h1 align="center" >LIMITES FINANCIEROS</h1>
                        <h4 align="center" >Puedes establecer limites para las</h4>
                        <h4 align="center" >transacciones y reportes</h4>
                        <% if(limite !=null){%>
                        
                            
                        <h5 align="center" >Limite establecido Q. <%=limite%></h5>
                        <%}%>
                        <hr>
                        <div align="center" class="form-row">
                            <div align="center" class="col-sm-12 col-md-6">
                                <div align="center" class="selectbox">
                                    <div align="center" role="tablist" id="accordion-1" class="accordion accordion-select">
                                        <div align="center" class="card">
                                            <div align="center" class="collapse show item-1" role="tabpanel" data-parent="#accordion-1">

                                                <div class="form-group"><label>Maximo *</label><input required="" class="form-control" type="number" step="0.01" min="1" name="maximo"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div  align="center"class="col-sm-12 col-md-6">
                                <div class="form-group"><label> </label><input type="hidden" required="" class="form-control" type="number" step="any" min="1" value="1" name="minimo"></div>
                            <div align="left" class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Actualizar </button></div>
                            </div>
                            <br>
                            <div align="left" class="form-row">
                                <input value="LIMITE" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                            </div>
                        </div>
                    </div>
                 
            </form>
        </div>
    </body>
</html> 