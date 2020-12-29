<%-- 
    Document   : CrearGerente
    Created on : Nov 8, 2020, 8:49:22 PM
    Author     : james
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ReporteClass.Libreta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Crear Cuenta</title>
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

    <body align="center" >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>
        <br>
        <%  
            String r = null;
            String USER = null;
            USER = (String) request.getAttribute("USER");
            ArrayList<Libreta> libreta = null;
            try {
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
                libreta=(ArrayList<Libreta>) request.getAttribute("CUENTA");
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-success" role="alert">
            <h4>CUENTA AGREGADA EXITOSAMENTE!  </h4>
        </div>
        <div>
            
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>EL USUARIO QUE INGRESASTE NO EXISTE</h4>
        </div>
        <%  }
            } catch (Exception e) {
            }%>
        <div align="center" class="container profile profile-view" id="profile">
            
            <form action="libreta" method="GET">
                <%                  
                    if (libreta != null) {   %> 
                    <%           
                for (Libreta libretaa : libreta) {%> 
                <input value="<%=libretaa.getCodigo()%>" class="form-control" type="hidden" name="codigo">
                <input value="<%=libretaa.getFecha()%>" class="form-control" type="hidden" name="fecha">
                <input value="<%=libretaa.getSaldo()%>" class="form-control" type="hidden" name="saldo">
                <input value="<%=libretaa.getNombre()%>" class="form-control" type="hidden" name="nombre">
                <input value="<%=libretaa.getCodCliente()%>" class="form-control" type="hidden" name="codCliente">
                <button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">IMPRIMIR LIBRETA</button>
            <% }  %>
            <% }  %>
            </form>
            
            
            <form  action="CrearCuenta" method="POST" >
                <div align="center" >
                    <br>
                    <br>
                    <div align="center" class="col-md-8">
                        <br><!-- comment -->
                        <br><!-- comment -->
                        <br><!-- comment -->
                        <h1 align="center" >CREAR CUENTA A CLIENTE</h1>
                        <hr>
                        <br>
                        <div align="center" class="form-row">
                            <div align="center"class="col-sm-12 col-md-6">
                                <div class="form-group"><label>Usuario del Cliente *</label><input required="" class="form-control" type="text" name="usuario"></div>
                                <div class="form-group"><label>Credito a depositar: *</label><input required="" class="form-control" type="number" step="any" min="1" name="credito"></div>
                            </div>
                            <div align="center" class="col-sm-12 col-md-6">
                                <div align="center" class="selectbox">
                                    <div align="center" role="tablist" id="accordion-1" class="accordion accordion-select">
                                        <div align="center" class="card">
                                            <div align="center" class="collapse show item-1" role="tabpanel" data-parent="#accordion-1">

                                                <div align="center" class="form-group"><label>Fecha de creacion: *</label>
                                                    <br>
                                                    <%  java.time.LocalDate today = java.time.LocalDate.now();
                                            out.println("Fecha: " + today);%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Crear</button></div>
                                <input value="CUENTA" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                            </div>
                        </div>
                    </div>
                </div>
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
            </form>
        </div>
    </body>


</html> 