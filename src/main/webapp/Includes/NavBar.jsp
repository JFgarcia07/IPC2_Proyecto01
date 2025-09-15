<%-- 
    Document   : NavBar
    Created on : 6 sept 2025, 20:57:54
    Author     : jgarcia07
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container"> 
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom"> 
        <ul class="nav nav-pills"> 
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/MenuPrincipal.jsp" class="nav-link active" aria-current="page">Menu Principal</a>
            </li> 
            <li class="nav-item"><a href="${pageContext.request.contextPath}/IrListadoConvocatorias" class="nav-link">Lista Convocatorias</a></li> 
            <c:if test="${sessionScope.idRole != '00003'}">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/IrPropuestasPorConvocatorias" class="nav-link">Revisar Propuestas</a>
                </li> 
            </c:if>
            <c:if test="${sessionScope.idRole == '00001' || sessionScope.idRole == '00002'}">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/IrGestorConvocatorias" class="nav-link">Gestionar Convocatorias</a>
                </li> 
            </c:if>
            <c:if test="${sessionScope.idRole == '00001'}">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/IrGestorUsuarios" class="nav-link">Gestor de Usuarios</a>
                </li>
            </c:if>
            <li class="nav-item"><a href="#" class="nav-link">Perfil</a></li>
            <li class="nav-item"><a href="#" class="nav-link">About</a></li>
        </ul> 
    </header>
</div>


