<%-- 
    Document   : EditMyInfo
    Created on : Nov 12, 2020, 10:00:36 AM
    Author     : james
--%>

<%@page import="Objetos.Cuenta"%>
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
        <%@ include file = "../PagesCliente/NavegaG.jsp" %>
        <%@ page import="Controlador.*" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%  
            String r = null;
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

            ArrayList<Cuenta> cambios = null;
            ArrayList<Cuenta> cambios1 = null;
            cambios = (ArrayList<Cuenta>) request.getAttribute("Cuenta");

            ArrayList<Cliente> cliente = null;
            cliente = (ArrayList<Cliente>) request.getAttribute("CLIENTE");
            try{
            cambios1 = (ArrayList<Cuenta>) request.getAttribute("Cuenta1");
            } catch(Exception e){
            
            }
            try {
                
                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        
        <div align="center" class="alert alert-success" role="alert">
            <h4>LA TRANSFERENCIA FUE REALIZADA EXITOSAMENTE</h4>
            
        </div>
        <% } else if (r.equalsIgnoreCase("ERROR")) {
        %>
        <div align="center" class="alert alert-danger" role="alert">

            <h4>No puedes transferir dinero a la misma cuenta</h4>
        </div>
        <%  } else if (r.equals("SINDINERO")) {
        %>
        
        <div align="center" class="alert alert-danger" role="alert">
            <h4>NO TIENES SUFICIENTES FONDOS EN LA CUENTA ORIGEN PARA LA TRANSACCION</h4>
        </div>
        <%  } %>

        <% } catch (Exception e) {
            }%>
        <div align="center" class="container profile profile-view" id="profile">

            <form action="Transferenciaa" method="POST" >

                <div align="left" class="col-md-8">
                    <div role="tablist" id="accordion-1" class="accordion accordion-select">
                        <div class="card">
                            <h1 align="center" >&nbsp;&nbsp;Transferencia Banca Virtual</h1>

                            <h5>&nbsp;&nbsp;Selecciona las cuentas para transferir dinero</h5>
                            <div align="center" class="form-row">

                                <div align="left" class="col-sm-12 col-md-6">

                                    <div align="left" class="form-group">
                                        <div class="form-group">
                                            <h3>Origen: </h3>
                                            <label for="exampleFormControlSelect1"></label>

                                            <%                  if (cambios != null) {   %> 
                                            <select class="form-control" id="exampleFormControlSelect1" required="" name="origen" >

                                                <%           for (Cuenta solicitudd : cambios) {%>          

                                                <option><%=solicitudd.getCodigo()%></option>

                                                <% }%>
                                            </select>
                                            <%}%>

                                        </div>   
                                    </div>   
                                </div>
                                <div align="left" class="col-sm-12 col-md-6">
                                    <div class="form-group">
                                        <h3>Destino: </h3>
                                        <label for="exampleFormControlSelect1"></label>

                                        <%                  if (cambios != null) {   %> 
                                        <select class="form-control" id="exampleFormControlSelect1" required="" name="destino" >
                                            <option></option>
                                            <%           for (Cuenta solicitudd : cambios) {%>          

                                            <option><%=solicitudd.getCodigo()%></option>

                                            <% }%>
                                            <%                  if (cambios1 != null) {   %>
                                            <%           for (Cuenta solicitudd : cambios1) {%>          

                                            <option><%=solicitudd.getCodigo()%></option>

                                            <% }%>
                                            
                                            
                                            <%}%>
                                        </select>
                                        <%}%>

                                    </div>
                                </div>
                                <br>
                                <div align="right" class="form-row">
                                    <h5>&nbsp;&nbsp;Ingresa la cantidad a transferir Q.</h5>
                                    <div align="right" class="col-md-12 content-right">
                                        <input required="" value="" class="form-control" type="number" step="0.01" min="1" name="cantidad">
                                        <button align="center" class="btn btn-primary form-btn" data-bs-hover-animate="jello" type="submit">Realizar</button>
                                    
                                    </div>
                                    
                                    <input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                                    <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                                </div>
                                
                            </div>
                        </div>
                        <div class="card" >
                            <div align="center" class="form-row">
                            
                            <div align="left" class="col-sm-12 col-md-6">
                                <h5 align="center" >Mis cuentas</h5>
                                <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead align="center" >
                                        <tr>
                                            <th>Codigo Cta.</th>
                                            <th>Saldo Q.</th>      
                                        </tr>
                                    </thead> 
                                    <tbody align="center" >

                                        <%                  if (cambios != null) {   %> 
                                        <%           for (Cuenta solicitudd : cambios) {%>
                                        <tr>
                                            <td><%=solicitudd.getCodigo()%> </td>
                                            <td>Q. <%=solicitudd.getCredito()%> </td>
                                        </tr>
                                        <% }%>
                                        <% }%>

                                    </tbody><!-- comment -->
                                </table>
                            </div>
                            <div align="left" class="col-sm-12 col-md-6">
                                <h5 align="center" >Cuentas Asociadas</h5>
                                <%                  if (cambios1 != null) {   %>
                                <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead align="center" >
                                        <tr>
                                            <th>Codigo Cta.</th>
                                            <th>Porpietario</th>   
                                                
                                        </tr>
                                    </thead> 
                                    <tbody align="center" >


                                        <%           for (Cuenta solicitudd : cambios1) {%>
                                        <tr>
                                            <td><%=solicitudd.getCodigo()%> </td>
                                            <td><%=solicitudd.getCreada()%> </td>
                                        </tr>
                                        <% }%>


                                    </tbody><!-- comment -->
                                </table>
                                <% }%>
                            </div>







                            </div>
                        </div><!-- comment -->
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
