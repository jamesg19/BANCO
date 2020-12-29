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
        <title>Cajero</title>
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
            String USERR=null;
            USERR = (String) request.getAttribute("USER");

        %>
      
            
        <nav class="navbar navbar-light navbar-expand-md fixed-top navbar-transparency  " style="background-color: #e3f2fd;" >
            <div class="container">
                <div><a class="navbar-brand" >BANCO BILLETON</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button></div>
                <div class="collapse navbar-collapse"
                     id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">


                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Transferencias </a>
                            <div class="dropdown-menu">
                                <form action="Depositar" method="POST">
                                <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Depositar</button>
                                </form>
                                
                                <form action="Retirar" method="POST">
                                <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Retirar</button>
                                </form>
                                
                            </div>
                        </li>
                        
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Ver Informacion</a>
                            <div class="dropdown-menu">
                                <form action="Editar_Mi_InfoCaj" method="POST">
                                <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR">   
                                <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">Mi info</button>
                                </form>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">Reportes </a>
                            <div class="dropdown-menu">
                                <form action="ReporteCajero" method="POST">
                                <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR"> 
                                <input value="1" class="dropdown-item" type="hidden" name="reporte"> 
                                <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 1</button>                             
                                </form>
                                <form action="Reporte2Cajero" method="POST">
                                <input value="<%=USERR%>" class="dropdown-item" type="hidden" name="USERR"> 
                                <input value="1" class="dropdown-item" type="hidden" name="reporte"> 
                                <button class="dropdown-item" data-bs-hover-animate="jello" type="submit">REPORTE 2</button>                             
                                </form>
                            </div>
                        </li>
                        <li class="nav-item" ><a  class="btn btn-outline-danger" href="login.jsp" >Logout</a> </li>
                    </ul>
                </div>
            </div>
        </nav>        
    
    </body>

</html>
