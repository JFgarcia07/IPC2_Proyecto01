<%-- 
    Document   : ListaPropuestas
    Created on : 14 sept 2025, 17:17:54
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Propuestas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Propuestas</h1>
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                <span>Lista de Propuestas</span>
            </div>
            <div class="card-body">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id Propuesta</th>
                                <th>Id Personal quien propuso</th>
                                <th>Titulo</th>
                                <th>Tipo de Actividad</th>
                                <th>Descripcion</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="propuesta" items="${propuestas}">
                                <tr>
                                    <td>${propuesta.idPropuesta}</td>
                                    <td>${propuesta.idPersonal}</td>
                                    <td>${propuesta.titulo}</td>
                                    <td>${propuesta.tipoPropuesta}</td>
                                    <td>${propuesta.descripcion}</td>
                                    <td>${propuesta.estado}</td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/RevisionPropuestaServlet?idPropuesta=${propuesta.idPropuesta}&valor=ACEPTADO" class="btn btn-sm btn-success">Aceptar</a>
                                        <a href="${pageContext.servletContext.contextPath}/RevisionPropuestaServlet?idPropuesta=${propuesta.idPropuesta}&valor=RECHAZADO" class="btn btn-sm btn-danger">Rechazar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <c:if test="${empty propuestas}">
                    <p class="text-center text-muted">No hay convocatorias registrados.</p>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>
