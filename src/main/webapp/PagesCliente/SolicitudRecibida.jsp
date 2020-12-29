<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.Solicitud"%>
<%@page import="ReporteClass.Reporte2Gerente"%>
<%@page import="Objetos.Transaccion"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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

    <body align="center" >
        <%@ include file = "../PagesCliente/NavegaG.jsp" %>
        <%            String USER = null;
            USER = (String) request.getAttribute("USER");
            ArrayList<Solicitud> cambios = null;
            cambios = (ArrayList<Solicitud>) request.getAttribute("Solicitud");
        %>       

        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <br><!-- comment -->
                <h3>Solicitudes de asociacion pendientes</h3>                
                <br><!-- comment -->
                <h5>Datos de las personas que solicitaron asociarse a tu cuenta</h5>
                <br><!-- comment -->
                <form action="reporteSolicitud" method="GET" >
                    <div align="center" >
                        <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                        <button align="center" type="submit" class="btn btn-outline-success">Exportar PDF</button>
                    </div>
                </form>  
                <thead align="center" >
                    <tr>
                        <th>Nombre</th>
                        <th>DPI</th>
                        <th>Sexo</th>
                        <th>Direccion</th>
                        <th>Tu cuenta a asociar</th>
                        <th>Estado</th>
                        <th>Aceptar</th>
                        <th>Rechazar</th>
                    </tr>
                </thead>
                <tbody align="center" >
                    <%                  if (cambios != null) {   %> 


                    <%           for (Solicitud solicitudd : cambios) {%>          
                    <tr valign="rigth">  
                        <td><%=solicitudd.getNombre()%></td>
                        <td><%=solicitudd.getDpi()%></td>             
                        <td><%=solicitudd.getSexo()%></td> 
                        <td><%=solicitudd.getDireccion()%></td> 
                        <td><%=solicitudd.getCodigo()%></td>
                        <td><%=solicitudd.getEstado()%></td>
                        <td>
                            <form action="Aceptar" method="post" >
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                                <input value="<%=solicitudd.getId()%>" class="dropdown-item" type="hidden" name="ID">
                                <button type="submit" class="btn btn-outline-success">Aceptar</button>
                            </form>


                        </td>
                        <td>
                            <form action="Rechazar" method="post" >
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                                <input value="<%=solicitudd.getId()%>" class="dropdown-item" type="hidden" name="ID">
                                <button type="submit" class="btn btn-outline-danger">Rechazar</button>
                            </form>

                        </td>
                    </tr>          
                    <% }
                    } else {%>
                <script>

                </script>
                <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
