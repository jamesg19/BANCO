<%-- 
    Document   : Reporte1
    Created on : Nov 11, 2020, 2:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.Cliente"%>
<%@page import="Objetos.Historial_Cambios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte 5</title>

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
    </head>

    <script src="../Resources/Table/js/jquery.min.js"></script>
    <script src="../Resources/Table/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="../Resources/Table/js/Fixed-navbar-starting-with-transparency.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/jquery.min.js"></script>
    <script src="../Resources/Navbar/js/bootstrap.min.js"></script>
    <script src="../Resources/Navbar/js/Fixed-navbar-starting-with-transparency.js"></script>  
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
            String s = null;
            int c = 0;
            s = (String) request.getAttribute("s");
            t = (String) request.getAttribute("t");
            USER = (String) request.getAttribute("USER");
            ArrayList<Cliente> cambios = null;
            cambios = (ArrayList<Cliente>) request.getAttribute("Cliente");
        %>       
        <form align="center" action="Reporte_Gerente5" >
            <br>
            <br>
            <br>
            <br>
            <br>
            <h3 align="center" >Reporte 5</h3>
            <h5 align="center" >Clientes que no han realizado una transaccion</h5>
            <h5 align="center" >en un intervalo de tiempo</h5>
            <div align="center"  >
                <table align="center" >
                    <thead align="center" >
                        <tr>

                            <th>
                                <div class="card">
                                    <div class="form-group"><label>Fecha Inicial&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                        <div >
                                            <input required="" class="form-control" type="date" name="fecha1" 
                                                   min="1998-01-01" max="2098-10-10">
                                        </div>
                                    </div>
                                </div>
                            </th>
                            <th>
                                <div class="card">
                                    <div class="form-group"><label>Fecha Final&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                        <div >
                                            <input required="" class="form-control" type="date" name="fecha2" 
                                                   min="1998-01-01" max="2098-10-10">
                                        </div>
                                    </div>
                                </div>
                            </th>


                            <th>
                                <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                                <button align="center" type="submit" class="btn btn-outline-success">Buscar</button> 
                            </th>
                        </tr>
                    <br>
                    </thead>
                </table>
            </div>
            
            <br>
        </form>

        <br>
        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <%   if (cambios != null) {%>
                <font color="black"> Fecha Inicial:</font><font color="green"> <%=t%></font><font color="black"> Fecha Final: </font><font color="green"> <%=s%></font>
                <thead align="center" >
                    <tr>
                        <th>No.</th>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Sexo</th>
                        <th>DPI</th>
                        <th>Cumpleaños</th>
                        <th>Direccion</th>
                    </tr>
                </thead>
                <tbody align="center" >
                <form action="reporteG5PDF" method="GET" >
                    <input value="<%=USER%>" class="form-control" type="hidden" name="USERR">
                    <div align="center" >
                        <input value="<%=t%>" class="form-control" type="hidden" name="t">
                        <input value="<%=s%>" class="form-control" type="hidden" name="s">
                        <button align="center" type="submit" class="btn btn-outline-danger"> <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/> Exportar PDF</button>
                    </div>
                </form> 
                <%

                    for (Cliente histo : cambios) {
                        c++;
                %>          
                <tr align="right">  
                    <td><%=c%></td>
                    <td><%=histo.getCodigo()%></td>
                    <td><%=histo.getNombre()%></td>             
                    <td><%=histo.getSexo()%></td> 
                    <td><%=histo.getDpi()%></td> 
                    <td><%=histo.getCumple()%></td> 
                    <td><%=histo.getDireccion()%></td>
                </tr>          
                <% }
            } else {%>
                <script>

                </script>
                <%}%>
                </tbody>
            </table>  
        </div>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->


    </body>
</html>