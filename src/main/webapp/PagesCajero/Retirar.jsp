<%-- 
    Document   : EditMyInfo
    Created on : Nov 12, 2020, 10:00:36 AM
    Author     : james
--%>

<%@page import="ReporteClass.Boleta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Objetos.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Retirar dinero</title>
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
            String clienteee = null;

            USER = (String) request.getAttribute("USER");
            nombre = (String) request.getAttribute("Nombre");
            turno = (String) request.getAttribute("Turno");
            dpi = (String) request.getAttribute("Dpi");
            direccion = (String) request.getAttribute("Direccion");
            sexo = (String) request.getAttribute("Sexo");
            password = (String) request.getAttribute("Password");

            ArrayList<Cliente> cliente = null;
            ArrayList<Boleta> boleta = null;
            cliente = (ArrayList<Cliente>) request.getAttribute("CLIENTE");

            try {
            
            boleta=(ArrayList<Boleta>) request.getAttribute("BOLETA");
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <br>
        <div align="center" class="alert alert-success" role="alert">
            <h4>El retiro de dinero ah sido autorizado...</h4>
            <h6>cuenta bien el dinero a entregar</h6>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">

            <h4>No tiene la cantidad ingresada de dinero para retirar</h4>
        </div>
        <%  } else if (r.equals("NOEXISTE")) {
        %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>La cuenta no existe </h4>
        </div>
        <%  } %>

        <% } catch (Exception e) {
                }%>
        <div class="container profile profile-view" id="profile">

            <form action="boleta" method="GET">
                <%                  
                    if (boleta != null) {   %> 
                    <%           
                for (Boleta libretaa : boleta) {%> 
                <input value="<%=libretaa.getCuenta()%>" class="form-control" type="hidden" name="cta">
                <input value="<%=libretaa.getPropietario()%>" class="form-control" type="hidden" name="prop">
                <input value="<%=libretaa.getMonto()%>" class="form-control" type="hidden" name="mont">
                <input value="<%=libretaa.getTipo()%>" class="form-control" type="hidden" name="tip">
                <button align="center" class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">IMPRIMIR BOLETA</button>
            <% }  %>
            <% }  %>
            </form>
            
            
            
            <form action="Retiroo" method="GET" >
                
                <br>
                <div align="left" class="col-md-8">
                    <div role="tablist" id="accordion-1" class="accordion accordion-select">
                        <div class="card">
                            <h1 >&nbsp;&nbsp;Retiro Monetario</h1>

                            <h5>&nbsp;&nbsp;Ingresa el codigo de la cuenta a retirar</h5>
                            <div align="center" class="form-row">

                                <div align="left" class="col-sm-12 col-md-6">

                                    <div align="left" class="form-group">
                                        <label>&nbsp;&nbsp;Codigo de la Cuenta *</label>
                                        &nbsp;&nbsp;<input required="" class="form-control" type="number" step="1" min="1" name="cuenta">
                                    </div>   
                                </div>
                                <div align="left" class="col-sm-12 col-md-6">
                                </div>
                                <br>
                                <div align="center" class="form-row"> 
                                    <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Validar Cuenta Origen</button></div>
                                    &nbsp;&nbsp;<input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                                    <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                                    <input value="<%=nombre%>" class="form-control" type="hidden" name="name">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <br>
            <div role="tablist" id="accordion-1" class="accordion accordion-select">
            <div class="card">
                <%
                            if (cliente != null) {   %> 
            <% if (cliente != null) {%>
            <%for (Cliente client : cliente) { 
            clienteee = client.getCodigo();
                }%>
            <form align="center" action="PDF" method="GET" enctype="multipart/form-data" target="_blank" >
                <input value="<%=clienteee%>" class="form-control" type="hidden" name="codigoC">
                <button type="submit" class="btn btn-outline-danger">
                    <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/>
                    Ver DPI
                </button>
            </form>
            <% }%>
            <form align="left" action="Retiroo" METHOD="POST">
                <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead align="center" >
                        <tr>
                            <th>Codigo Cta.</th>
                            <th>Nombre</th>
                            <th>DPI</th>
                            <th>Sexo</th>
                            <th>Direccion</th>
                            <th>cumple</th>
                            <th>Saldo (Q)</th>
                        </tr>
                    </thead> 
                    <tbody align="center" >
                    <%
                            for (Cliente client : cliente) {%>          
                    <tr valign="rigth">  
                        <td><%=client.getCodCuenta()%></td>
                        <td><%=client.getNombre()%></td>
                        <td><%=client.getDpi()%></td>             
                        <td><%=client.getSexo()%></td> 
                        <td><%=client.getDireccion()%></td> 
                        <td><%=client.getCumple()%></td>
                        <td><%=client.getSaldo()%></td>
                        <% clienteee = client.getCodigo();%>
                    <% nombre=client.getNombre();%>
                    </tr>
                    <input value="<%=client.getCodCuenta()%>" class="form-control" type="hidden" name="cuenta"> 
                    <% }%>
                    <input value="RETIRO" class="form-control" type="hidden" name="tipo">
                    <input value="<%=USER%>" class="form-control" type="hidden" name="USER">                        
                    <h5>Verifica si su DPI coincide con la informacion descrita en la tabla</h5>
                    <div class="col-sm-12 col-md-6">
                        <div class="form-group"><label>Monto a Retirar (DEBITAR) *</label><input required="" class="form-control" type="number" step="any" min="1" name="monto"></div>   
                    </div>    
                    <div class="col-sm-12 col-md-6">
                        <button class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">RETIRAR</button>
                    </div> 
                    <% }%>
                    </tbody>
                </table>
                    <input value="<%=nombre%>" class="form-control" type="hidden" name="name">
            </form>
            </div>
            </div>
        </div>
    </body>
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
</html> 
