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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Depositar dinero</title>
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
        <%@ include file = "../PagesCajero/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>
        <br>
        <br>
        <br>
        <br>
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

            ArrayList<Cliente> cliente = null;
            cliente = (ArrayList<Cliente>) request.getAttribute("CLIENTE");

            try {
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <div align="center" class="alert alert-success" role="alert">
            <h4>Se ha realizado el deposito exitosamente!!</h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>

        <div align="center" class="alert alert-danger" role="alert">

            <h4>Error al depositar en mi compu si funciona</h4>
        </div>
        <%  }
            } catch (Exception e) {
            }%>
        <div class="container profile profile-view" id="profile">

            <form action="Deposit" method="GET" >
                <br>
                <div class="form-row profile-row">
                    <div class="col-md-4 relative">
                        <div class="avatar">
                            <div class="avatar-bg center"></div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <h1 >Realizar deposito bancario</h1>

                        <hr>
                        <h5>Ingresa el codigo de la cuenta a depositar</h5>
                        <div class="form-row">

                            <div class="col-sm-12 col-md-6">

                                <div class="form-group"><label>Codigo de la Cuenta *</label><input required="" class="form-control" type="number" step="1" min="1" name="cuenta"></div>   
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="selectbox">
                                    <div role="tablist" id="accordion-1" class="accordion accordion-select">
                                        <div class="card">
                                            <div class="card-header" role="tab">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="form-row"> 
                                <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Validar Cuenta destino</button></div>
                                <input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                            </div>
                        </div>
                    </div>

                </div> 
            </form>


            <form action="Deposit" METHOD="POST">

                <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead align="center" >
                        <tr>
                            <th>Codigo Cta.</th>
                            <th>Nombre</th>
                            <th>DPI</th>
                            <th>Sexo</th>
                            <th>Direccion</th>
                            <th>cumple</th>
                        </tr>
                    </thead>
                    <tbody align="center" >
                        <%
                            if (cliente != null) {   %> 

                        <%
                            for (Cliente client : cliente) {

                        %>          
                        <tr valign="rigth">  
                            <td><%=client.getCodCuenta()%></td>
                            <td><%=client.getNombre()%></td>
                            <td><%=client.getDpi()%></td>             
                            <td><%=client.getSexo()%></td> 
                            <td><%=client.getDireccion()%></td> 
                            <td><%=client.getCumple()%></td> 
                        </tr>
                    <input value="<%=client.getCodCuenta()%>" class="form-control" type="hidden" name="cuenta"> 
                    <% }%>
                    <div class="col-sm-12 col-md-6">

                    </div>
                    <div class="col-sm-12 col-md-6">

                        <div class="form-group" align="center" >
                            <label>Monto a Depositar *</label>
                            <input  required="" class="form-control" type="number" step="0.01" min="1" name="monto">
                        </div>   
                        <div class="col-md-12 content-center">
                            <button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Despositar</button>
                            <h4>Datos del propietario de la cuenta ingresada</h4>
                        </div>
                    </div>  

                    <input value="DEPOSITO" class="form-control" type="hidden" name="tipo">
                    <input value="<%=USER%>" class="form-control" type="hidden" name="USER">                        
                    <% }%>

                    </tbody>
                </table>

            </form> 

        </div>
    </body>
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->


</html> 
