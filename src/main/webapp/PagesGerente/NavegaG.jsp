<%-- 
    Document   : NavegaG
    Created on : Nov 5, 2020, 11:24:22 PM
    Author     : james
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Banco Billeton</title>
        
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
        <nav class="navbar navbar-light navbar-expand-md fixed-top navbar-transparency"  style="background-color: #e3f2fd;" >
            <div class="container">
                <div>
                    <form action="Inicio_Gerente" >
                        <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">

                        <button class="btn btn-outline-primary" type="submit">BANCO BILLETON</button>
                    </form> 
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">

                        <li class="nav-item dropdown">
                            <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Cuentas y Mas </a>
                            <div class="dropdown-menu">
                                <form action="NuevaCuenta" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Crear Cuenta</button>
                                </form>

                                <form action="Limit" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Limites</button>
                                </form>

                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Nuevo Usuario </a>
                            <div class="dropdown-menu">
                                <form action="Crear_Cliente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Crear Cliente</button>
                                </form>
                                <form action="Crear_Cajero" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Crear Cajero</button>
                                </form>
                                <form action="Crear_Gerente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Crear Gerente</button>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Ver usuarios </a>
                            <div class="dropdown-menu">
                                <form action="Ver_Cliente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Clientes</button>
                                </form>

                                <form action="Ver_Cajero" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Cajeros</button>
                                </form>

                                <form action="Ver_Gerente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Gerentes</button>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Actualizar Informacion</a>
                            <div class="dropdown-menu">
                                <form action="Editar_Mi_Info" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">  

                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Mi info</button>
                                </form>

                                <form action="BuscarEditar" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Info Cliente/Cajero</button>
                                </form>
                        </li>
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Reportes </a>
                            <div class="dropdown-menu">
                                <form action="Reporte1" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 1</button>

                                </form>
                                <form action="Reporte_Gerente2" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 2</button>
                                </form>

                                <form action="Reporte_Gerente3" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 3</button>
                                </form>

                                <form action="Reporte_Gerente4" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 4</button>
                                </form>

                                <form action="Reporte5" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 5</button>
                                </form>

                                <form action="Report6Gerente" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 6</button>
                                </form>

                                <form action="Reporte7" method="POST">
                                    <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                    <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 7</button>
                                </form>

                            </div>
                        </li>
                        <li class="nav-item"><a class="btn btn-outline-danger" href="login.jsp">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>        

    </body>

</html>
