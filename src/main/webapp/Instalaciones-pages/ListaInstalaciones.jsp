<%-- 
    Document   : ListadoInstalaciones
    Created on : 18 sept 2025, 18:31:01
    Author     : jgarcia07
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instalaciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Instalaciones</h1>
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Instalaciones</span>
                <a href="${pageContext.request.contextPath}/Instalaciones-pages/CrearInstalacion.jsp" class="btn btn-light btn-sm">
                    <i class="bi bi-plus-circle"> + Registrar Instalación</i> 
                </a>
            </div>
            <div class="card-body">
                <c:if test="${not empty instalaciones}">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id Instalación</th>
                                <th>Nombre</th>
                                <th>Ubicación</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="instalacion" items="${instalaciones}">
                                <tr>
                                    <td>${instalacion.idInstalacion}</td>
                                    <td>${instalacion.nombreInstalacion}</td>
                                    <td>${instalacion.ubicacion}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/EditarInstalacionServlet?idInstalacion=${instalacion.idInstalacion}" class="btn btn-sm btn-warning">Editar</a>
                                        <a href="${pageContext.servletContext.contextPath}/EliminarInstalacionServlet?idInstalacion=${instalacion.idInstalacion}" class="btn btn-sm btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <c:if test="${empty instalaciones}">
                    <p class="text-center text-muted">No hay instalaciones registradas.</p>
                </c:if>
            </div>
        </div>
    </div>
    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>
