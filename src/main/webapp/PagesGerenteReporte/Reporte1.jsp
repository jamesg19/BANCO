<%-- 
    Document   : Reporte1
    Created on : Nov 11, 2020, 2:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte 1</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Resourcescss/bootstrap.css">
        <link rel="stylesheet" href="Resources/Navbar/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Navbar/css/gradient-navbar.css">
        <link rel="stylesheet" href="Resources/Navbar/css/styles.css">
        <link rel="stylesheet" href="Resources/Table/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Table/css/Fixed-navbar-starting-with-transparency-1.css">
        <link rel="stylesheet" href="Resources/Table/css/Fixed-navbar-starting-with-transparency.css">
        <link rel="stylesheet" href=Resources/Table/css/Data-Table-1.css">
        <link rel="stylesheet" href="Resources/Table/css/Data-Table.css">
        <link rel="stylesheet" href="Resources/Table/css/gradient-navbar-1.css">
        <link rel="stylesheet" href="Resources/Table/css/gradient-navbar.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="Resources/Table/css/styles.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">

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
    <script src="../Resources/INFO/js/Profile-Edit-Form.js"></script>
    <script src="../Resources/Table/js/jquery.min.js"></script>
    <script src="../Resources/Table/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="../Resources/Table/js/Fixed-navbar-starting-with-transparency.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>

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
    <script src="../Resources/INFO/js/jquery.min.js"></script>
    <script src="../Resources/INFO/js/bootstrap.min.js"></script>
    <script src="../Resources/INFO/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="../Resources/INFO/js/Drag-and-Drop-File-Input.js"></script>
    <script src="../Resources/INFO/js/Profile-Edit-Form.js"></script>
    <script src="../Resources/INFO/js/Studious-selectbox.js"></script>
    <body align="center" >
        <%@ include file = "../PagesGerente/NavegaG.jsp" %>
        <%            String USER = null;
            String t = null;
            String alert = "";
            t = (String) request.getAttribute("t");
            USER = (String) request.getAttribute("USER");
            ArrayList<Historial_Cambios> cambios = null;
            cambios = (ArrayList<Historial_Cambios>) request.getAttribute("Historial");
        %>
        <% try {
                alert = (String) request.getAttribute("ERROR");
                if (alert.equals("NOHAY")) {
        %>
        <br>
        <br> 
        <br>
        <br>
        <div align="left" class="alert alert-danger" role="alert">
            <h4>NO HAY RESULTADOS</h4>
        </div>
        <% }
            } catch (Exception e) {
            }%>
        <form align="center" action="Reporte_Gerente" >
            <br>
            <br>
            <br>
            <br>
            <br>
            <h3 align="center" >Reporte 1</h3>
            <h5 align="center" >Ver historial de cambios segun tipo de identidad</h5>

            <table align="center" >
                <thead align="center" >
                    <tr>
                        <th>
                            <h5>Selecciona la Identidad</h5>
                        </th>
                        <th>
                            <select align="center" class="form-control" align="center" name="tipo">     
                                <option>GERENTE</option>
                                <option>CLIENTE</option><!-- comment -->
                                <option>CAJERO</option>
                            </select>
                        </th>
                        <th>
                            <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                            <button align="center" type="submit" class="btn btn-outline-success">Buscar</button> 
                        </th>
                        <th>

                        </th>
                        <th>
                            <br><!-- comment -->
                            <br>
                        </th>
                    </tr>
                <br>
                </thead>
            </table>
        </form>



        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead align="center" >
                    <tr>
                        <th>Fecha de modificacion</th>
                        <th>Usuario</th>
                        <th>Nombre</th>
                        <th>Turno</th>
                        <th>Nacimiento</th>
                        <th>DPI</th>
                        <th>Direccion</th>
                        <th>Sexo</th>
                        
                    </tr>
                </thead>
                <tbody align="center" >
                    <%                  if (cambios != null) {%> 
                <form action="reporteG1PDF" method="GET" >
                    <div align="center" >
                        <input value="<%=t%>" class="form-control" type="hidden" name="t">
                        <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                        <button align="center" type="submit" class="btn btn-outline-danger"> <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/>Exportar PDF</button>
                    </div>
                </form>


                <%           for (Historial_Cambios histo : cambios) {%>          
                <tr align="rigth">  
                    <td><%=histo.getFecha()%></td>
                    <td><%=histo.getUser()%></td> 
                    <td><%=histo.getNombre()%></td>
                    <td><%=histo.getTurno()%></td> 
                    <td><%=histo.getCumple()%></td> 
                    <td><%=histo.getDpi()%></td> 
                    <td><%=histo.getDireccion()%></td>
                    <td><%=histo.getSexo()%></td>
                </tr>          
                <% }
                    } else {%>
                <%}%>
                </tbody>
            </table>   
        </div>
    </body>
</html>