<%-- 
    Document   : index
    Created on : Nov 3, 2020, 1:46:01 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en"><head>
        <title>Login BILLETON</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="Resources/images/icons/favicon.ico">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="Resources/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="Resources/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Resources/css/util.css">
        <link rel="stylesheet" type="text/css" href="Resources/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body background="Resources/images/p1.jpg" >
        <%@ page import="Controlador.*" %>
        <%
            String r = null;
            try {
                r = (String) request.getAttribute("ERROR");
                if (r.equals("error")) {
        %>
        <div align="center" class="alert alert-danger" role="alert">
            <h4>Usuario y/o constrasena son incorrectos.</h4>
        </div>
        <% }
            } catch (Exception e) {
            }%>
        <div class="limiter">
            <div class="container-login100" >
                <div class="wrap-login100 p-t-30 p-b-50">
                    <span class="login100-form-title p-b-41">
                        Inicia sesion al Banco Billeton 
                    </span>
                    <form action="Login" class="login100-form validate-form p-b-33 p-t-5" method="POST">

                        <div class="wrap-input100 validate-input" data-validate="Enter username">
                            <input class="input100" required type="text" name="username" id="username" placeholder="Usuario">
                            <span class="focus-input100" data-placeholder=""></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" required type="password" name="pass" placeholder="Password">
                            <span class="focus-input100" data-placeholder=""></span>
                        </div>

                        <div class="container-login100-form-btn m-t-32">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <div id="dropDownSelect1"></div>
    </body></html>
