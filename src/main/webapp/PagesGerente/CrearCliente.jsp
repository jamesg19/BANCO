<%-- 
    Document   : CrearGerente
    Created on : Nov 8, 2020, 8:49:22 PM
    Author     : james
--%>

<%@page import="ReporteClass.Libreta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>CrearCliente</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <body>
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>

        <%  String r = null;
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
            <h4>AGREGADO EXITOSAMENTE</h4>
        </div>
        <% } else if (r.equals("ERROR")) { %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">

            <h4>EL USUARIO QUE INGRESASTE YA EXISTE</h4>
        </div>
        <%  }
            } catch (Exception e) {
            }%>
        <div class="container profile profile-view" id="profile">
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
                <button align="center" class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">IMPRIMIR LIBRETA</button>
            <% }  %>
            <% }  %>
            </form>
            <form action="CrearUsuario" method="POST" enctype="multipart/form-data" >
                <br>
                <br>
                <div class="form-row profile-row">
                    <br>
                    <br>
                    <br>
                    <br><!-- comment -->
                    <br><!-- comment -->
                    <div class="col-md-4 relative">
                        <div class="avatar">
                            <div class="avatar-bg center"></div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <h1>Crear CLIENTE</h1>
                        <%
                            java.time.LocalDate today = java.time.LocalDate.now();
                            out.println("La fecha de hoy es: " + today); %>  
                        <hr>
                        <div class="form-row">
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group"><label>Codigo *</label><input required="" class="form-control" type="text" name="usuario"></div>
                                <div class="form-group"><label>Password *</label><input required="" class="form-control" type="text" name="password"></div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="selectbox">
                                    <div role="tablist" id="accordion-1" class="accordion accordion-select">
                                        <div class="card">
                                            <div class="card-header" role="tab">
                                            </div>
                                            <div class="collapse show item-1" role="tabpanel" data-parent="#accordion-1">
                                                <div class="form-group"><label>Sexo  *</label>
                                                    <select class="form-control" required="" name="sexo">
                                                        <option>MASCULINO</option>
                                                        <option>FEMENINO</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group"><label>Nombre *</label><input required="" class="form-control" type="text" name="nombre"></div>
                                <div class="form-group"><label>DPI *</label><input required="" class="form-control" type="number" step="1" min="1" name="dpi"></div>
                                <div class="form-group"><label>DIRECCION *</label><input required="" class="form-control" type="text"  name="direccion"></div>
                                <div class="form-group"><label>Credito a depositar *</label><input required="" class="form-control" type="number" step="0.01" min="1" name="credito"></div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="selectbox">
                                    <div role="tablist" id="accordion-2" class="accordion accordion-select">
                                        <div class="card">
                                            <div class="form-group"><label>Cumpleaños *</label>
                                                <div class="col-sm-12 col-md-6">
                                                    <input required="" class="form-control" type="date" name="cumple" 
                                                           min="1900-01-01" max="<%=today%>">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                    <div role="tablist" id="accordion-2" class="accordion accordion-select">
                                        <br>
                                        <div class="card">
                                            <div  class="form-group"><label>Subir DPI en PDF *</label><input required="Sube tu DPI en PDF" type="file" name="pdf" accept="application/pdf" /></div>
                                        </div>
                                    </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Crear</button></div>
                                <input value="CLIENTE" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER"> 
                            </div>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div>

                </div> 
            </form>                            
        </div>
    </body>


</html> 