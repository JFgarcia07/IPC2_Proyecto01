<%-- 
    Document   : GestorUsuarios
    Created on : 6 sept 2025, 22:01:04
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de Usuarios</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <jsp:include page="/Includes/NavBar.jsp"/>
        </div> 
    <center>
        <h1>Gestor de Usuarios</h1>
    </center>
        <div>
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                    <span>Lista de Usuarios</span>
                    <button class="btn btn-light btn-sm">
                        <i class="bi bi-plus-circle"></i> Nuevo
                    </button>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>Id Personal</th>
                                <th>Rol</th>
                                <th>Email</th>
                                <th>Nombre de Usuario</th>
                                <th>Organizacion Procedencia</th>
                                <th>Numero Telefonico</th>
                                <th>Estado</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%--LLENAR CON INFO--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <div>
            <jsp:include page="/Includes/Footer.jsp"/>
        </div> 
    </body>
</html>
