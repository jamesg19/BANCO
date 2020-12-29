<%-- 
    Document   : NavegaG
    Created on : Nov 5, 2020, 11:22:22 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title></title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Resources/Navbar/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar.css">
        <link rel="stylesheet" href="Resources/Navbar/css/styles.css">
    </head>
    <script src="Resources/Navbar/js/jquery.min.js"></script>
    <script src="Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>  

    <body>
        <%@ page import="Controlador.*" %>
        <%@ page import="WDir.*" %>
        <%
            String USERR = null;
            USERR = (String) request.getAttribute("USER");
            
        %>
        <nav class="navbar navbar-light navbar-expand-md fixed-top navbar-transparency" style="background-color: #C0F5A2;" >
            <div class="container">
                <div>
                    <form action="Inicio_Cliente" >
                        <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">
                    <button class="btn btn-outline-success" type="submit">BANCO BILLETON</button>
                    </form> 
                </div>
                <div class="collapse navbar-collapse"
                     id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Asociaciones</a>
                            <div class="dropdown-menu">
                                <form action="Asociar" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Asociar cuenta tercero</button>
                                </form>

                                <form action="SolicitudesRecibidas" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Solicitudes Recibidas</button>
                                </form>

                                <form action="CuentaAsociada" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Cuentas Asociadas</button>
                                </form>


                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="true" href="#">Transferencias</a>
                            <div class="dropdown-menu">
                                <form action="Transferencia" method="GET">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Transferir dinero</button>
                                </form>

                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Mis Cuentas </a>
                            <div class="dropdown-menu">
                                <form action="Ver_Cuentas" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Ver mis cuentas</button>
                                </form>

                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Mis Datos</a>
                            <div class="dropdown-menu">
                                <form action="Editar_Mi_InfoClien" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Mi info</button>
                                </form>

                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Reportes </a>
                            <div class="dropdown-menu">
                                <form action="Reporte_Cliente11" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 1</button>

                                </form>
                                <form action="Reporte_Cliente2" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 2</button>
                                </form>
                                <form action="Reporte3Cliente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 3</button>
                                </form><!-- comment -->
                                <form action="Reporte_Cliente4" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 4</button>
                                </form>
                                <form action="Reporte_Cliente5" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 5</button>
                                </form>

                            </div>
                        </li>
                        <li class="nav-item"><a class="btn btn-outline-danger" href="login.jsp">CERRAR SESION</a></li>
                    </ul>
                </div>
            </div>
        </nav>        

    </body>

</html>
