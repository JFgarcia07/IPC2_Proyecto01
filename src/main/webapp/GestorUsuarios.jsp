<%-- 
    Document   : GestorUsuarios
    Created on : 6 sept 2025, 22:01:04
    Author     : jgarcia07
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Gestor de Usuarios</h1>

        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Usuarios</span>
                <a href="CrearUsuario.jsp" class="btn btn-light btn-sm">
                    <i class="bi bi-plus-circle"> + Crear Nuevo Usario</i> 
                </a>
            </div>
            <div class="card-body">
                <c:if test="${not empty usuarios}">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id Personal</th>
                                <th>Rol</th>
                                <th>Email</th>
                                <th>Nombre de Usuario</th>
                                <th>Organización de Procedencia</th>
                                <th>Teléfono</th>
                                <th>Saldo</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="usuario" items="${usuarios}">
                                <tr>
                                    <td>${usuario.idPersonal}</td>
                                    <td>${usuario.idRol}</td>
                                    <td>${usuario.email}</td>
                                    <td>${usuario.nombreUsuario}</td>
                                    <td>${usuario.organizacionProcedencia}</td>
                                    <td>${usuario.numTelefono}</td>
                                    <td>${usuario.cartera}</td>
                                    <td>${usuario.activo}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/EditarUsuarioServlet?id=${usuario.idPersonal}" class="btn btn-sm btn-warning">Editar</a>
                                        <a href="${pageContext.servletContext.contextPath}/DesactivarUsuarioServlet?id=${usuario.idPersonal}" class="btn btn-sm btn-danger">Desactivar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty usuarios}">
                    <p class="text-center text-muted">No hay usuarios registrados.</p>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>

