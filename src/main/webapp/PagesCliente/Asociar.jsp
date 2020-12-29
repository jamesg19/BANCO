<%-- 
    Document   : EditMyInfo
    Created on : Nov 12, 2020, 10:00:36 AM
    Author     : james
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Objetos.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Asociar</title>
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form_Verde.css">
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
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script> 

    <body>
        <%@ include file = "../PagesCliente/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>

        <%            String r = null;
            String USER = null;
            String nombre = null;
            String turno = null;
            String dpi = null;
            String direccion = null;
            String sexo = null;
            String password = null;

            USER = (String) request.getAttribute("USER");
            nombre = (String) request.getAttribute("Nombre");
            turno = (String) request.getAttribute("Turno");
            dpi = (String) request.getAttribute("Dpi");
            direccion = (String) request.getAttribute("Direccion");
            sexo = (String) request.getAttribute("Sexo");
            password = (String) request.getAttribute("Password");

            Cliente cliente = null;
            cliente = (Cliente) request.getAttribute("CLIENTE");

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
            <h4>Se ha enviado la solicitud de asociacion</h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>Error la cuenta que ingresaste</h4>
            <h4>es de tu propiedad</h4>
        </div>
        <%  } else if (r.equals("MAXIMO")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>HAS ALCANZADO EL MAXIMO INTENTO DE ASOCIACIONES A LA CUENTA INGRESADA</h4>
        </div>
        <%  } else if (r.equals("PENDIENTE")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>HAY UNA SOLICITUD DE ASOCIACION PENDIENTE A LA CUENTA INGRESADA POR FAVOR ESPERA</h4>
            <h6>Comunicate con el propietario de la cuenta</h6>
        </div>
        <%  }else if (r.equals("NO")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>LA CUENTA INGRESADA NO EXISTE </h4>
        </div>
        <%  } else if (r.equals("ASOCIADA")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>LA CUENTA INGRESADA YA LA ASOCIASTE ANTERIORMENTE</h4>
        </div>
        <%  } %>
            <% } catch (Exception e) {
            }%>
        <div class="container profile profile-view" id="profile">

            <form action="VerificarCuenta" method="POST" >
                <br>
                <br>
                <div align="center" >
                    <br><!-- comment -->
                    <br>
                    <div class="col-md-8">
                        <h1 >Realizar solicitud de asociacion</h1>

                        <hr>
                        <h5 align="left" >Ingresa el codigo de la cuenta para asociar</h5>
                        <div class="form-row">

                            <div class="col-sm-12 col-md-6">

                                <div align="left" class="form-group"><label>Codigo de la Cuenta *</label><input required="" class="form-control" type="number" step="1" min="1" name="cuenta"></div>   
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="selectbox">

                                </div>
                            </div>
                            <br>
                            <div class="form-row"> 
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Validar Cuenta</button></div>
                                <input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                            </div>
                        </div>
                    </div>

                </div> 
            </form>


            <form action="VerificarCuenta" METHOD="GET">
                <div align="center" class="container profile profile-view" id="profile" >
                <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead align="center" >
                        <tr>
                            <th>Nombre</th>
                            <th>Direccion</th>
                            <th>Sexo</th>
                            <th>Dpi</th>
                            <th>Codigo de cuenta</th>
                        </tr>
                    </thead>
                    <tbody align="center" >
                        <%
                            if (cliente != null) {   %> 
                        <tr valign="rigth">  
                            <td><%=cliente.getNombre()%></td>               
                            <td><%=cliente.getDireccion()%></td>
                            <td><%=cliente.getSexo()%></td>
                            <td><%=cliente.getDpi()%></td>
                            <td><%=cliente.getCumple()%></td> 
                        </tr>
                        <input value="<%=cliente.getCumple()%>" class="form-control" type="hidden" name="cuenta">                        
                            <div class="col-sm-12 col-md-6">
                                <br>
                                <div class="col-md-12 content-right"><button class="btn btn-outline-success" data-bs-hover-animate="jello" type="submit">Enviar Solicitud de asociacion :)</button></div>
                            </div>  
                            
                    <input value="ASOCIA" class="form-control" type="hidden" name="tipo">
                    <input value="<%=cliente.getCumple()%>" class="form-control" type="hidden" name="cuenta">
                    <input value="<%=USER%>" class="form-control" type="hidden" name="USER"> 
                    <input value="<%=cliente.getCodigo()%>" class="form-control" type="hidden" name="clienteRe">
<% }%>              
                    
                    </tbody>
                </table>
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
