<%-- 
    Document   : index
    Created on : 14/12/2020, 01:19:46 AM
    Author     : james
--%>

<%@page import="BaseDatos.GestorVerificar"%>
<%@page import="Base.GerenteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banco Billeton   </title>
    </head>
    
            <link rel="stylesheet" href="Resources/Navbar/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar.css">
        <link rel="stylesheet" href="Resources/Navbar/css/styles.css">
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form.css">
        <link rel="stylesheet" href="Resources/INFO/css/Studious-selectbox.css">
        <link rel="stylesheet" href="Resources/INFO/css/styles.css">
    <body background="Resources/images/p1.jpg" >
        <br>
        <br>
        <br>
        <br>
        <br>

        <div align="center" >
            <FONT size="16" align="center" COLOR="white">Banco Billeton </FONT>
            <br>
            <FONT size="6" align="center" COLOR="white">Bienvenido al portal </FONT>
        </div>
        
        <br>
        <br>
        <form action="init" >
            <div align="center" >

                <input  value="carga" class="form-control" type="hidden" name="tipo">
                <button align="center" class="btn btn-primary form-btn" data-bs-hover-animate="jello" name="carga" type="submit">Cargar Datos</button>

            </div>
        </form>
        <br>
        <form action="init" >
            <div align="center">

                <input value="iniciar" class="form-control" type="hidden" name="tipo">
                <button align="center" class="btn btn-primary form-btn" data-bs-hover-animate="jello" name="carga" type="submit">Iniciar Sesion</button>


            </div>
        </form>
    </body>
</html>