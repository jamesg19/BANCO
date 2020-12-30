<%-- 
    Document   : carga
    Created on : 26/10/2020, 01:40:38 AM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>El Billeton</title>
       
        
        <link rel="shortcut icon" type="image/x-icon" href="../resources/img/bank.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="../Resourrcess/css/cargar.css" type="text/css">
        <link rel="stylesheet" href="../Resourrcess/css/ocultoGeneral.css" type="text/css">
        <link rel="stylesheet" href="../Resourrcess/css/fondo.css" type="text/css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../Resourrcess/js/circulos.js"></script>
        <script type="text/javascript" src="../Resourrcess/js/cargar.js"></script>
        <script type="text/javascript" src="../Resourrcess/js/modificarEstadoBotonn.js"></script>
    </head>
    <body>

        <div id="carga">
            <center>
                <h2>Banco El Billeton</h2>
                
                <label for="archivo" id="selectorArchivo" tabindex="0" class="input-file-trigger">Seleccionar archivo XML
                    con datos a cargar...</label>
                <p id="ruta" class="file-return"></p>
                <form action="../archivo" method="POST" enctype="multipart/form-data" id="prueba1">
                    <input type="file" id="archivo" name="archivo" onchange="verificar()" webkitdirectory directory multiple>
                </form>
                <br>
                <div id="opciones" style="display: none;">
                    <button class="btn btn-info" onclick="loadDoc(this)" id="verificarDatos">VERIFICAR DATOS
                        
                    </button>
                    <button class="btn btn-info"
                            onclick="verMensaje('Ingresando datos a base')"
                            style="display: none;" id="ingresarDatos">INGRESAR DATOS 
                    </button>
                            <form action="../Loginn" METHOD="POST" >
                               
                          <button class="btn btn-info" style="display: none;" id="iniciarSesion">Iniciar Sesion
                              <img  width="10%" style="display: inline-block;vertical-align: middle;">
                            </button>      
                                
                                
                            </form>
                            <form action="../Resumen" METHOD="POST" >
                            <button class="btn btn-info" style="display: none;" id="resumenCarga">Resumen de Carga de Archivo
                              <img  width="10%" style="display: inline-block;vertical-align: middle;">
                            </button> 
                            </form>
                            
                </div>
            </center>
        </div>
        <div id="visualizar" style="display: none;">
            <div id='controladores'>
                <button class='btn btn-info' id="btn-con-iz" onclick="moverIzquierdaD()">
                    <img width="15%" style="display: inline-block;vertical-align: middle;">
                    ANTERIOR
                </button>
                <h1 id="h-controlador">GERENTES</h1>
                <button class="btn btn-info" id="btn-con-de" onclick="moverDerechaD()">
                    SIGUIENTE
                    
                    <img width="15%" style="display: inline-block;vertical-align: middle;">
                </button>
            </div>
            <div id="tablas">
                <center>
                    <table class="table table-striped table-bordered tablas" id="gerentes" style="width: 95%;">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Turno</th>
                                <th>DPI</th>
                                <th>Direccion</th>
                                <th>Sexo</th>
                                <th>Password</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <table class="table table-striped table-bordered tablas" id="cajeros" style="display: none; width: 95%;">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Turno</th>
                                <th>DPI</th>
                                <th>Direccion</th>
                                <th>Sexo</th>
                                <th>Password</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <table class="table table-striped table-bordered tablas" id="clientes" style="display: none; width: 95%;">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>DPI</th>
                                <th>DPI PDF</th>
                                <th>Nacimiento</th>
                                <th>Direccion</th>
                                <th>Sexo</th>
                                <th>Password</th>
                                <th>Cuenta</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <table class="table table-striped table-bordered tablas" id="transacciones" style="display: none; width: 95%;">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Cuenta</th>
                                <th>Fecha</th>
                                <th>Hora</th>
                                <th>Tipo</th>
                                <th>Monto</th>
                                <th>Cajero</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </center>
            </div>
        </div>
    <center>
        <div id="contenedorMensaje" class="oculto" style="display:none;">
            <div id="contenedorInterior" class="mensaje2" style="background-color:#001a28">
                <div style="padding: 0.5em;">
                    
                    <h3 id="tituloMensaje" style="font-weight: bold;font-size: 1.5em; margin: 0;color:white;">por defecto</h3>
                </div>
                <center>
                    <div id="cargando">
                        <div class="progress" id="pro"></div>
                        <label for="pro" id="actualSubiendo" style="color: grey;">ingresando...</label>
                    </div>
                    <div style="width:100%;overflow-y: scroll;display: none;" id="resumenContenedor">
                        <label for="resumen" style="color: grey;">RESUMEN</label>
                        <table id="resumen" style="text-align: center;" class="tablaDatos">
                            <thead>
                                <tr>
                                    <th>Ingresados</th>
                                    <th>Tabla</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div style="height:130px;width:100%;overflow-y: scroll;display:none;" id="historialContenedor">
                        <label for="historial" style="color:grey;">ERRORES</label>
                        <table id="historial" style="text-align: center;" class="tablaDatos">
                            <thead>
                                <tr>
                                    <th>Registro</th>
                                    <th>Estado</th>
                                    <th>Usuario</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </center>
                <p id="informar1" style="color:grey"></p>
                <div id="botonesIngresado" style="display:none;">
                    <button class="learn-more buttonEspecial" onclick="cerrandoFrame()">Revisar registros</button>
                    <button class="learn-more buttonEspecial" onclick="mandarLogin()">Inicio de sesión</button>
                </div>
            </div>
        </div>
    </center>
    <center>
        <div id="mostradorDPI" class="oculto" style="display:none;">
            <div id="contenedorEmbed" class="mensaje2">
                <div style="padding: 0.5em;">
                    <img id="imagen" src="../resources/img/document.svg" width="10%" style="display: none;vertical-align: middle;">
                    <h3 id="tituloMensaje2" style="font-weight: bold;font-size: 1.5em; margin: 0;">DPI de cliente </h3>
                    <embed src="" title="DPI" width="70%" height="400px" id="embeberDPI">
                </div>
                <br>
                <button class="btn btn-info" onclick="cerrandoFrame1()">Cerrar</button>
            </div>
        </div>
        
    </center>
    <script>
        function cerrandoFrame1() {
            $("#mostradorDPI").hide();
        }
        function mandarLogin(){
            window.location = 'login.jsp';
        }
        let timeout;
        var veces = 0;
        function repetir() {
            clearTimeout(timeout);
            timeout = setTimeout(() => {
                clearTimeout(timeout);
                if (veces < 15) {
                    veces++;
                    var parrafo = document.createElement("p");
                    parrafo.innerText = "error " + veces;
                    var contenido = document.getElementById("articulo");
                    contenido.appendChild(parrafo);
                    repetir();
                }
            }, 1000);
        }
    </script>
    <script>
   function verCuentas() {
    //var center = boton.parentNode;
    var td = center.parentNode;
    var tabla = td.querySelectorAll("table")[0];
    if (tabla.style.display === "none") {
        tabla.style.display = "";
        //boton.innerHTML = "CUENTAS<img src='../resources/img/collapse.svg' width='15%' style='display: inline-block;vertical-align: middle;'>";
    } else {
        tabla.style.display = "none";
        //boton.innerHTML = "CUENTAS<img src='../resources/img/expand.svg' width='15%' style='display: inline-block;vertical-align: middle;'>";
    }
}
        
    </script>
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    
</body>

</html>
