<%-- 
    Document   : crearUsuario
    Created on : 8 sept 2025, 20:19:26
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Usuario</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/Includes/NavBar.jsp" />

        <div class="container mt-5">
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/IrGestorUsuarios" class="btn btn-secondary" style="background-color: #005cbf">
                    <- Regresar
                </a>
            </div>
            <form method="GET" action="${pageContext.request.contextPath}/nuevoUsuario">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Crear Usuario</h3>
                        <input type="text" name="inputIdPersonal" class="form-control mt-2" placeholder="ID Personal" required>
                        <br>
                        <label for="opciones">Rol del Usuario:</label>
                        <select id="opcionesRol" name="opcionesRol">
                            <option value="1">Administrador de Sistema</option>
                            <option value="2">Administrador de Congreso</option>
                            <option value="3">Usuario Basico</option>
                        </select>
                        <br>
                        <input type="text" name="inputEmail" class="form-control mt-2" placeholder="Correo Electronico" required>
                        <br>
                        <input type="text" name="inputNombreUsuario" class="form-control mt-2" placeholder="Nombre de Usuario" required>
                        <br>
                        <input type="text" name="inputPassword" class="form-control mt-2" placeholder="Contraseña" required>
                        <br>
                        <input type="text" name="inputOrganizacion" class="form-control mt-2" placeholder="Organización Procedencia" required>
                        <br>
                        <input type="text" name="inputNumTelefono" class="form-control mt-2" placeholder="Número de Telefono" required>
                        <br>
                        <input type="text" value="Activo" class="form-control mt-2" disabled>
                        <input type="hidden" name="inputActivo" value="Activo">
                        
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnLogIn" value="Crear Usuario">
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
