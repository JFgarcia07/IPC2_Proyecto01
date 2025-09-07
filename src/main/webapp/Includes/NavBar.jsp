<%-- 
    Document   : NavBar
    Created on : 6 sept 2025, 20:57:54
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container"> 
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom"> 
        <ul class="nav nav-pills"> 
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/MenuPrincipal.jsp" class="nav-link active" aria-current="page">Menu Principal</a>
            </li> 
            <li class="nav-item"><a href="#" class="nav-link">Usuarios</a></li> 
            <li class="nav-item"><a href="#" class="nav-link">Eventos</a></li> 
            <li class="nav-item"><a href="${pageContext.request.contextPath}/GestorUsuarios.jsp" class="nav-link">Gestor de Usuarios</a></li> 
            <li class="nav-item"><a href="#" class="nav-link">Perfil</a></li>
            <li class="nav-item"><a href="#" class="nav-link">About</a></li>
        </ul> 
    </header>
</div>


