<%-- 
    Document   : CrearInstalacion
    Created on : 18 sept 2025, 18:40:53
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registrar Instalacion</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <jsp:include page="/Includes/NavBar.jsp"/>
        </div> 
        <div class="container mt-5">
            <c:if test="${error != null}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                     ${error}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <form method="POST" action="${pageContext.request.contextPath}/RegistrarInstalacionServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Registrar Instalación</h3>
                        <br>
                        <input type="text" name="inputIdInstalacion" class="form-control mt-2" placeholder="Id Instalacion" required>
                        <br>
                        <input type="text" name="inputNombre" class="form-control mt-2" placeholder="Nombre de la Instalacion" required>
                        <br>
                        <input type="text" name="inputUbicacion" class="form-control mt-2" placeholder="Ubicacion" required>
                        <br>
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnRegistrar" value="Registrar Instalacion">
                        <br>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>