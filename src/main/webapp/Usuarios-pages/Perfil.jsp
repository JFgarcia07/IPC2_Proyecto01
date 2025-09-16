<%-- 
    Document   : Perfil
    Created on : 15 sept 2025, 16:48:17
    Author     : jgarcia07
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Perfil</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <jsp:include page="/Includes/NavBar.jsp"/>
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <img src="${pageContext.request.contextPath}/img/default-user.png" 
                         class="card-img-top" alt="Foto de perfil">
                    <div class="card-body text-center">
                        <h3 class="card-title">${perfil.nombreUsuario}</h3>
                        <a href="${pageContext.request.contextPath}/EditarPerfilServlet" class="btn btn-sm btn-outline-primary">Editar Perfil</a>
                        <a href="${pageContext.request.contextPath}/RecargarCarteraServlet" class="btn btn-sm btn-outline-primary">Recargar Cartera Digital</a>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card shadow-sm mb-4">
                    <div class="card-body">
                        <h5 class="card-title">Información Personal</h5>
                        <p><strong>ID Personal:</strong> ${perfil.idPersonal}</p>
                        <p><strong>Email:</strong>${perfil.email}</p>
                        <p><strong>Nombre de Usuario:</strong>${perfil.nombreUsuario}</p>
                        <p><strong>Teléfono:</strong>${perfil.numTelefono}</p>
                        <p><strong>Organización:</strong>${perfil.organizacionProcedencia}</p>
                        <p><strong>Cartera Digital:</strong>${perfil.cartera}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/Includes/Footer.jsp" />
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>
