<%-- 
    Document   : EditarUsuario
    Created on : 10 sept 2025, 20:08:14
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Usuario</title>
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
            <form method="POST" action="${pageContext.request.contextPath}/EditarUsuarioServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Editar Usuario</h3>

                        <input type="text" name="inputIdPersonal" value="${usuario.idPersonal}" class="form-control mt-2" readonly>
                        <input type="hidden" name="idPersonal" value="${usuario.idPersonal}">
                        <br>
                        <label for="opcionesRol">Rol del Usuario:</label>
                        <select id="opcionesRol" name="opcionesRol">
                            <option value="1" ${usuario.idRol == '00001' ? 'selected' : ''}>Administrador de Sistema</option>
                            <option value="2" ${usuario.idRol == '00002' ? 'selected' : ''}>Administrador de Congreso</option>
                            <option value="3" ${usuario.idRol == '00003' ? 'selected' : ''}>Usuario Básico</option>
                        </select>
                        <br>
                        <input type="text" name="inputEmail" value="${usuario.email}" class="form-control mt-2" placeholder="Correo Electrónico" required>
                        <br>
                        <input type="text" name="inputNombreUsuario" value="${usuario.nombreUsuario}" class="form-control mt-2" placeholder="Nombre de Usuario" required>
                        <br>
                        <input type="text" name="inputPassword" value="${usuario.password}" class="form-control mt-2" placeholder="Contraseña" required>
                        <br>
                        <input type="text" name="inputOrganizacion" value="${usuario.organizacionProcedencia}" class="form-control mt-2" placeholder="Organización Procedencia" required>
                        <br>
                        <input type="text" name="inputNumTelefono" value="${usuario.numTelefono}" class="form-control mt-2" placeholder="Número de Teléfono" required>
                        <br>
                        <label for="opcionesActivo">Estado:</label>
                        <select id="opcionesActivo" name="opcionesActivo">
                            <option value="1" ${usuario.activo ? 'selected' : ''}>Activo</option>
                            <option value="0" ${!usuario.activo ? 'selected' : ''}>Inactivo</option>
                        </select>

                        <br>
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" value="Realizar Cambios">
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
