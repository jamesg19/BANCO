<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.*"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Cliente</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Resources/INFO/css/bootstrap.min.css">
        <link rel="stylesheet" href="Resources/INFO/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="Resources/INFO/css/Drag-and-Drop-File-Input.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form-1.css">
        <link rel="stylesheet" href="Resources/INFO/css/Profile-Edit-Form_Verde.css">
        <link rel="stylesheet" href="Resources/INFO/css/styles.css">

    </head>
    <script src="Resources/p1.js"></script>
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

    <body align="center" >

        <%
            String USERRR = null;
            String busqueda = null;
            busqueda = (String) request.getAttribute("Busqueda");
            USERRR = (String) request.getAttribute("USERr");
            ArrayList<Cliente> cambiosE = null;
            cambiosE = (ArrayList<Cliente>) request.getAttribute("Cliente1");
            String Mas = "";
            String Fem = "";
            int cont = 0;
            java.time.LocalDate today = java.time.LocalDate.now();
        %>       

        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <h3>Lista de Clientes encontrados</h3>    
                <h4><%=busqueda%></h4>
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>No.</th>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>DPI</th>
                        <th>Cumpleaños</th>
                        <th>Direccion</th>
                        <th>Sexo</th>

                    </tr>
                </thead>
                <tbody align="center" >
                    <%
                        if (cambiosE != null) {   %> 

                    <%           for (Cliente solicitudd : cambiosE) {%>   
                    <% cont++;%>
                    <tr align="left">  
                        <td><%=cont%></td>
                        <td><%=solicitudd.getCodigo()%></td>
                        <td><%=solicitudd.getNombre()%></td>
                        <td><%=solicitudd.getDpi()%></td> 
                        <td><%=solicitudd.getCumple()%></td>   
                        <td><%=solicitudd.getDireccion()%></td> 
                        <td><%=solicitudd.getSexo()%></td>
                        <td>

                            <%
                                String nom = "";
                                String cod = "";
                                nom = solicitudd.getNombre();
                                cod = solicitudd.getCodigo();
                            %>
                            <div class="modal fade" id="exampleModal<%=cont%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" >
                                    <div class="modal-content">

                                        <form method="POST" enctype="multipart/form-data" >
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Editar Informacion Cliente</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="CERRAR">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">



                                                <div class="form-row">
                                                    <div class="col-sm-12 col-md-6">
                                                        <div class="form-group"><label>Codigo *</label><input required="" class="form-control" type="text" value="<%=cod%>" name="usuario" readonly ></div>
                                                        <div class="form-group"><label>Password *</label><input required="" class="form-control" type="text" value="<%=solicitudd.getPassword()%>" name="password"></div>
                                                        <div class="form-group"><label>Nombre *</label>
                                                            <input required="" class="form-control" type="text" value="<%=nom%>" name="nombre">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>DPI *</label>
                                                            <input required="" class="form-control" type="number" min="1" value="<%=solicitudd.getDpi()%>" step="1" name="dpi">
                                                        </div>

                                                    </div>

                                                    <div class="col-sm-12 col-md-6">
                                                        <%
                                                            if (solicitudd.getSexo().equalsIgnoreCase("MASCULINO")) {
                                                                Mas = "selected";
                                                                Fem = "";
                                                            } else if (solicitudd.getSexo().equalsIgnoreCase("FEMENINO")) {
                                                                Fem = "selected";
                                                                Mas = "";
                                                            }
                                                        %>
                                                        <div class="form-group"><label>Sexo  *</label>
                                                            <select class="form-control" required="" name="sexo">
                                                                <option <%=Mas%> >MASCULINO</option>
                                                                <option <%=Fem%> >FEMENINO</option>
                                                            </select>
                                                        </div>
                                                            
                                                        <div class="form-group">
                                                            <label>Cumpleaños *</label>

                                                            <input required="" class="form-control" type="date" name="cumple" value="<%=solicitudd.getCumple()%>"
                                                                   min="1900-01-01" max="<%=today%>">

                                                        </div>
                                                        <div class="form-group">
                                                            <label>DIRECCION *</label>
                                                            <input required="" class="form-control" type="text" value="<%=solicitudd.getDireccion()%>" name="direccion">
                                                        </div>
                                                        
                                                        
                                                        <div align="center" >
                                                            <h6 align="left" >Deseas agregar un nuevo DPI en PDF?&nbsp;&nbsp;</h6>
                                                            <div class="form-check form-check-inline">

                                                                <input class="form-check-input" type="radio" onclick="mostarR(<%=cont%>)" name="aaa" required="" id="inlineRadio1" value="si">
                                                                <label class="form-check-label"  for="inlineRadio1">SI</label>
                                                                <div class="form-check form-check-inline">
                                                                    &nbsp;&nbsp;
                                                                    <input class="form-check-input"  type="radio" onclick="ocultarR(<%=cont%>)" name="aaa" required="" id="inlineRadio2" value="no">
                                                                    <label class="form-check-label"  for="inlineRadio2">NO</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div id="actualizaPDF<%=cont%>" style="display:none" >
                                                            <input  id="pdf<%=cont%>" type="file" name="pdf<%=cont%>" accept="application/pdf" />
                                                            <input value="<%=cont%>" class="form-control" type="hidden" name="num">
                                                        </div>
                                                           
                                                        <input value="CLIENTE" class="form-control" type="hidden" name="tipoI">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit"  class="btn btn-primary">Guardar Cambios</button>
                                            </div>
                                        </form>
                                        <form align="center" action="PDF" method="GET" enctype="multipart/form-data" target="_blank" >
                                            <input value="<%=cod%>" class="form-control" type="hidden" name="codigoC">
                                            <button type="submit" class="btn btn-outline-danger">
                                                <img src="Imagen/iconPDF.ico" title="DPI" style="width : 30px; heigth : 60px"/>
                                                Ver DPI
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal<%=cont%>" data-whatever="@getbootstrap">Editar</button>

                        </td>
                    </tr>          
                    <% }
                    } else {%>
                    <%}%>
                </tbody>
            </table>
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->
            <br><!-- comment -->

        </div>
    </body>
</html>

