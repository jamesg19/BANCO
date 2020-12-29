<%-- 
    Document   : EditMyInfo
    Created on : Nov 12, 2020, 10:00:36 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Editar Info</title>
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

    <body>
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>

        <%            String r = null;
            String USER = null;
            String nombre= null;
            String turno= null;
            String dpi= null;
            String direccion= null;
            String sexo= null;
            String password= null;
            String M="";
            String F="";
            String Mat="";
            String Ves="";

            USER = (String) request.getAttribute("USER");
            nombre = (String) request.getAttribute("Nombre");
            turno = (String) request.getAttribute("Turno");
            dpi = (String) request.getAttribute("Dpi");
            direccion = (String) request.getAttribute("Direccion");
            sexo = (String) request.getAttribute("Sexo");
            password = (String) request.getAttribute("Password");

            
            try {
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-success" role="alert">
            <h4>Se ha actualizado exitosamente!!</h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">

            <h4>Error al actualizar</h4>
        </div>
        <%  }
            } catch (Exception e) {
            }%>
        
            
            <%
            if(sexo.equalsIgnoreCase("MASCULINO")){
                M="selected";
                F="";
            } else if (sexo.equalsIgnoreCase("FEMENINO")){
                M="";
                F="selected";
            }
            if(turno.equalsIgnoreCase("MATUTINO")){
                Mat="selected";
                Ves="";
            } else if(turno.equalsIgnoreCase("VESPERTINO")){
                Mat="";
                Ves="selected";
            }    


            %>
            
            
            <div class="container profile profile-view" id="profile">
                <br>
                            <br>
            <form action="Actualizar_Usuario" method="POST" >
                <div class="form-row profile-row">
                    <div class="col-md-4 relative">
                        <div class="avatar">
                            <div class="avatar-bg center"></div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <h1>EDITAR MI INFORMACION</h1>
                        <hr>
                        <div class="form-row">
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group"><label>Codigo </label><input required="" class="form-control" type="text" value="<%=USER%>" readonly="" name="usuario"></div>
                                <div class="form-group"><label>Password *</label><input required="" class="form-control" type="text" value="<%=password%>" name="password"></div>
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
                                                        <option <%=M%> >MASCULINO</option>
                                                        <option <%=F%> >FEMENINO</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="selectbox-results">
                                        <div class="selectbox-result">
                                            <p>Scriptie resultaat</p>
                                        </div>
                                        <div class="selectbox-result">
                                            <p>Reflectieverslag resultaat</p>
                                        </div>
                                        <div class="selectbox-result">
                                            <p>Screenshot resultaat</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group"><label>Nombre *</label><input required="" value="<%=nombre%>" class="form-control" type="text" name="nombre"></div>
                                <div class="form-group"><label>DPI *</label><input required="" value="<%=dpi%>" class="form-control" type="number" min="1" step="1" name="dpi"></div>
                                <div class="form-group"><label>DIRECCION *</label><input required="" value="<%=direccion%>" class="form-control" type="text"  name="direccion"></div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="selectbox">
                                    <div role="tablist" id="accordion-2" class="accordion accordion-select">
                                        <div class="card">
                                            <div class="form-group"><label>Turno *</label>
                                                <select class="form-control" required="" name="turno">
                                                    <option <%=Mat%> >MATUTINO</option>
                                                    <option <%=Ves%> >VESPERTINO</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="selectbox-results">
                                            <div class="selectbox-result">
                                                <p>Scriptie resultaat</p>
                                            </div>
                                            <div class="selectbox-result">
                                                <p>Reflectieverslag resultaat</p>
                                            </div>
                                            <div class="selectbox-result">
                                                <p>Screenshot resultaat</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="form-row">
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Actualizar</button></div>
                                <input value="GERENTE" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                            </div>
                        </div>
                    </div>

                </div> 
            </form>
        </div>
                                    <br>
        <br>
        <br>
        <br>
        <br>
    </body>


</html> 
