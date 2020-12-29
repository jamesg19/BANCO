<%-- 
    Document   : Reporte1
    Created on : Nov 13, 2020, 6:45:43 AM
    Author     : james
--%>

<%@page import="Objetos.Cajero"%>
<%@page import="Objetos.Gerente"%>
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
        <title>Lista Cajero</title>

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
        <link rel="stylesheet" href="js/dialogCSS.css">

    </head>
    <script src="../Resources/js/dialog.js"></script>
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
    <script src="../Resources/js/dialogJS.js"></script>

    <body align="center" >

        <%  String USERRR = null;
            String busqueda = null;
            USERRR = (String) request.getAttribute("USERr");
            busqueda = (String) request.getAttribute("Busqueda");
            ArrayList<Cajero> cambiosE = null;
            cambiosE = (ArrayList<Cajero>) request.getAttribute("Cajero1");
            String Mas="";
            String Fem="";
            String MA="";
            String VES="";
            int cont=0;
        %>       

        <div align="center" class="container profile profile-view" id="profile" >
            <table align="center" id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <h3>Lista de Cajeros encontrados</h3> 
                <h4><%=busqueda%></h4>
                <br><!-- comment -->
                <thead align="center" >
                    <tr>
                        <th>No. </th>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Turno</th>
                        <th>Dpi</th>
                        <th>Direccion</th>
                        <th>Sexo</th>
                    </tr>
                </thead>
                <tbody align="center" >
                    <%
                        if (cambiosE != null) {   %> 

                    <%           for (Cajero solicitudd : cambiosE) {%>  
                    <% cont++; %>
                    <tr align="left">  
                        <td><%=cont%></td>
                        <td><%=solicitudd.getCodigo()%></td>
                        <td><%=solicitudd.getNombre()%></td>
                        <td><%=solicitudd.getTurno()%></td> 
                        <td><%=solicitudd.getDpi()%></td>   
                        <td><%=solicitudd.getDireccion()%></td> 
                        <td><%=solicitudd.getSexo()%></td>
                        <td>
                            <form method="POST">
                            <%
                            String nom="";
                            String cod="";
                            nom=solicitudd.getNombre();
                            cod=solicitudd.getCodigo();
                            %>
                    <div class="modal fade" id="exampleModal<%=cont%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" >
                            <div class="modal-content">
                                <form method="POST">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar Informacion</h5>
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
                                                if(solicitudd.getSexo().equalsIgnoreCase("MASCULINO")){
                                                Mas="selected";
                                                Fem="";
                                                }
                                                else if (solicitudd.getSexo().equalsIgnoreCase("FEMENINO")){
                                                Fem="selected";
                                                Mas="";
                                                }
                                                %>
                                                
                                                <%  
                                                if(solicitudd.getTurno().equalsIgnoreCase("MATUTINO")){
                                                MA="selected";
                                                VES="";
                                                }
                                                else if (solicitudd.getTurno().equalsIgnoreCase("VESPERTINO")){
                                                VES="selected";
                                                MA="";
                                                }
                                                %>
                                                <div class="form-group"><label>Sexo  *</label>
                                                    <select class="form-control" required="" name="sexo">
                                                        <option <%=Mas%> >MASCULINO</option>
                                                        <option <%=Fem%> >FEMENINO</option>
                                                    </select>
                                                </div>
                                                <div class="form-group"><label>Turno *</label>
                                                <select class="form-control" required="" name="turno">
                                                    <option <%=MA%> >MATUTINO</option>
                                                    <option <%=VES%> >VESPERTINO</option>
                                                </select>
                                            </div>
                                                <div class="form-group">
                                                    <label>DIRECCION *</label>
                                                    <input required="" class="form-control" type="text" value="<%=solicitudd.getDireccion()%>" name="direccion">
                                                </div>
                                                <input value="CAJERO" class="form-control" type="hidden" name="tipoI">
                                            </div>

                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                                    </div>
                                
                            </div>
                        </div>
                    </div>
                                                </form>
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
