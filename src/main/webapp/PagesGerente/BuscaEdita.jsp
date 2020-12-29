<%-- 
    Document   : BuscaEdita
    Created on : Nov 8, 2020, 8:49:22 PM
    Author     : james
--%>
<%@page import="Objetos.*"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Editar info</title>
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form.css">
        <link rel="stylesheet" href="Resources/INFO/css/styles.css">
    </head>
    <script src="../Resources/p1.js"></script>
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
    
    <body >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>

        <%@ page import="Controlador.*" %>
        <br>
        <br>
        <br>
        <br>
        <%            String r = null;
            String USER = null;
            USER = (String) request.getAttribute("USER");
            ArrayList<Cajero> cambioss = null;
            ArrayList<Cliente> cambiosss = null;

            try {

                r = (String) request.getAttribute("ESTADO");
                if (r.equals("AGREGADO")) {
        %>
        <br>
        <div class="alert alert-success" role="alert">
            <h4 align="center" >Datos actualizados</h4>
        </div>
        <% } else if (r.equals("ERROR")) {
        %>
        <br>      
        <div align="center" class="alert alert-danger" role="alert">
            <h4 align="center" >Error al actualizar datos</h4>
        </div>
        <%  }
            else if(r.equals("NOHAY")){%>
        <br>
        <div align="center" class="alert alert-danger" role="alert">
            <h4 align="center" >No se han encontrado resultados</h4>
        </div> 
        <% } 
        }  catch (Exception e) {
            }%>
        <form  action="BuscaInfo" method="GET" >
            <div align="center" >
                
                <br>
                <div align="center" class="col-md-8">
                    <h1 align="center" >Editar usuario</h1>
                    <h4 align="center" >Puedes buscar el tipo de usuario y editarlo</h4>
                    <hr>
                    <div align="center" >   
                            <div align="center">
                                <div align="center" class="card">
                                    <div align="center" >
                                        <div class="form-group"><label>Ingresa la busqueda *</label>
                                            <input class="form-control mr-sm-2" type="search" placeholder="Buscar..." aria-label="Search" required="" name="busqueda">
                                        </div>
                                        <div align="center" >
                                            
                                            <div class="form-check form-check-inline">
                                                <h6 align="left" >Buscar por: &nbsp;&nbsp;</h6>
                                                <input class="form-check-input" type="radio" name="parametro" required="" id="inlineRadio1" value="nombre">
                                                <label class="form-check-label" for="inlineRadio1">Nombre</label>
                                            
                                                <div class="form-check form-check-inline">
                                                    &nbsp;&nbsp;
                                                <input class="form-check-input" type="radio" name="parametro" required="" id="inlineRadio2" value="codigo">
                                                <label class="form-check-label" for="inlineRadio2">User</label>
                                            </div> 
                                                
                                            </div>
                                             
                                        </div>
                                    </div>
                                    <div align="center" >
                                        
                                        <div class="form-check form-check-inline">
                                            <h6 align="left" >Tipo usuario : &nbsp;&nbsp;</h6>
                                            <input class="form-check-input" type="radio" name="identidad" required="" id="inlineRadio1" value="cliente">
                                            <label class="form-check-label" for="inlineRadio1">Cliente</label>
                                        
                                        </div>
                                        <div class="form-check form-check-inline">
                                            &nbsp;&nbsp;
                                            <input class="form-check-input" type="radio" name="identidad" required="" id="inlineRadio2" value="cajero">
                                            <label class="form-check-label" for="inlineRadio2">Cajero</label>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        <div align="left">

                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar </button>
                        </div>
                        <br>
                        <div align="left" class="form-row">
                            <input value="BUSCAR" class="form-control" type="hidden" name="tipo">
                            <input value="<%=USER%>" class="form-control" type="hidden" name="USER">
                        </div>
                    </div>
                </div>       
            </div> 
        </form>


    </body>
    <%
        cambioss = (ArrayList<Cajero>) request.getAttribute("Cajero");
        cambiosss = (ArrayList<Cliente>) request.getAttribute("Cliente");
        if (cambioss != null) {
            
    %>

    <%@ include file = "../PagesGerente/ListaCajero_1.jsp" %>

    <%
        } 
        else if (cambiosss != null){%>
    
        <%@ include file = "../PagesGerente/ListaCliente_1.jsp" %>
        
        <% }%>


</html> 