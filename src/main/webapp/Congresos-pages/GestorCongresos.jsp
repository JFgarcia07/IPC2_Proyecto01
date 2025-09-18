<%-- 
    Document   : GestorCongresos
    Created on : 17 sept 2025, 15:47:41
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
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error:</strong> ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <h1 class="text-center mb-4">Gestor de Congresos</h1>

        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Congresos</span>
                <a href="${pageContext.servletContext.contextPath}/CrearCongresoServlet" class="btn btn-light btn-sm">
                    <i class="bi bi-plus-circle"> + Crear Nuevo Congreso</i> 
                </a>
            </div>
            <div class="card-body">
                <c:if test="${not empty congresos}">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                           <tr>
                                <th>Id Congreso</th>
                                <th>Titulo</th>
                                <th>Descripcion</th>
                                <th>Fecha</th>
                                <th>Costo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="congreso" items="${congresos}">
                                <tr>
                                    <td>${congreso.idCongreso}</td>
                                    <td>${congreso.tituloCongreso}</td>
                                    <td>${congreso.descripcionCongreso}</td>
                                    <td>${congreso.fechaInicio}</td>
                                    <td>${congreso.costo}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/ class="btn btn-sm btn-warning">Editar Congreso</a>
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

