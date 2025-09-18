<%-- 
    Document   : ListaCongresos
    Created on : 16 sept 2025, 21:40:59
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Congresos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Congresos</h1>
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Congresos Disponibles</span>
            </div>
            <div class="card-body">
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
                                        <a href="${pageContext.servletContext.contextPath}/CrearPropuestaServlet?idConvocatoria=${convocatoria.idConvocatoria}" class="btn btn-sm btn-warning">Realizar propuesta</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <c:if test="${empty congresos}">
                    <p class="text-center text-muted">No hay Congresos registrados.</p>
                </c:if>
            </div>
        </div>
    </div>
    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>