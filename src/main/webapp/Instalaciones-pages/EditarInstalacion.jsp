<%-- 
    Document   : EditarInstalacion
    Created on : 18 sept 2025, 21:08:58
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Instalacion</title>
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
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/IrListadoInstalaciones" class="btn btn-secondary" style="background-color: #005cbf">
                    <- Regresar
                </a>
            </div>
            <form method="POST" action="${pageContext.request.contextPath}/EditarInstalacionServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Editar Instalación</h3>
                        <br>
                        <input type="text" value="${idInstalacion}" class="form-control mt-2" readonly>
                        <input type="hidden" name="inputIdInstalacion" value="${idInstalacion}">
                        <br>
                        <input type="text" name="inputNombre" class="form-control mt-2" value="${instalacion.nombreInstalacion}" required>
                        <br>
                        <input type="text" name="inputUbicacion" class="form-control mt-2" placeholder="${instalacion.ubicacion}" required>
                        <br>
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnRegistrar" value="Realizar Cambios">
                        <br>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>