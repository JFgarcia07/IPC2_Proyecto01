<%-- 
    Document   : ListaConvocatorias
    Created on : 12 sept 2025, 16:21:04
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Convocatorias</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Convocatorias</h1>
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Convocatorias</span>
            </div>
            <div class="card-body">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id Convocatoria</th>
                                <th>Fecha Inicio</th>
                                <th>Fecha Limite</th>
                                <th>Titulo</th>
                                <th>Descripcion</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="convocatoria" items="${convocatorias}">
                                <tr>
                                    <td>${convocatoria.idConvocatoria}</td>
                                    <td>${convocatoria.fechaInicio}</td>
                                    <td>${convocatoria.fechaFin}</td>
                                    <td>${convocatoria.titulo}</td>
                                    <td>${convocatoria.descripcion}</td>
                                    <td>${convocatoria.estado}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/CrearPropuestaServlet?idConvocatoria=${convocatoria.idConvocatoria}" class="btn btn-sm btn-warning">Realizar propuesta</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <c:if test="${empty convocatorias}">
                    <p class="text-center text-muted">No hay convocatorias registrados.</p>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>