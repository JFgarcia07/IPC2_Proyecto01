<%-- 
    Document   : EditarPerfil
    Created on : 15 sept 2025, 18:42:37
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="${pageContext.request.contextPath}/IrPerfilServlet" class="btn btn-secondary" style="background-color: #005cbf">
                    <- Regresar
                </a>
            </div>
            <form method="POST" action="${pageContext.request.contextPath}/EditarPerfilServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Editar Perfil</h3>
                        <input type="text" name="inputIdPersonal" value="${perfil.idPersonal}" class="form-control mt-2" readonly>
                        <input type="hidden" name="idPersonal" value="${perfil.idPersonal}">
                        <br>
                        <input type="text" name="inputEmail" value="${perfil.email}" class="form-control mt-2" placeholder="Correo Electrónico" required>
                        <br>
                        <input type="text" name="inputNombreUsuario" value="${perfil.nombreUsuario}" class="form-control mt-2" placeholder="Nombre de Usuario" required>
                        <br>
                        <input type="text" name="inputOrganizacion" value="${perfil.organizacionProcedencia}" class="form-control mt-2" placeholder="Organización Procedencia" required>
                        <br>
                        <input type="text" name="inputNumTelefono" value="${perfil.numTelefono}" class="form-control mt-2" placeholder="Número de Teléfono" required>
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

