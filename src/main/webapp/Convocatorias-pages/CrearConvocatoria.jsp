<%-- 
    Document   : CrearConvocatoria
    Created on : 11 sept 2025, 22:32:56
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Convocatoria</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <jsp:include page="/Includes/NavBar.jsp"/>
        </div> 
        <div class="container mt-5">
            <c:if test="${error != null}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error:</strong> ${error}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <form method="POST" action="${pageContext.request.contextPath}/CrearConvocatoriaServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Crear Convocatoria</h3>
                        <label for="fecha">Creador de la convocatoria:</label>
                        <input type="text" name="inputIdPersonal" class="form-control mt-2" value="${idPersonal}" placeholder="Id Personal" required readonly>
                        <br>
                        <input type="text" name="inputIdCongreso" class="form-control mt-2" placeholder="Id del Congreso" required>
                        <br>
                        <label for="fecha">Fecha de lanzamiento de la convocatoria:</label>
                        <input type="date" id="fechaInicio" name="fechaInicio" value="2025-01-01">
                        <br>
                        <label for="fecha">Fecha de finalizacion de la convocatoria:</label>
                        <input type="date" id="fechaFinal" name="fechaFinal" value="2025-12-31">
                        <br>
                        <input type="text" name="inputTitulo" class="form-control mt-2" placeholder="Titulo de la Convocatoria" required>
                        <br>
                        <textarea id="descripcion" name="descripcion" placeholder="Descripción:" rows="5" cols="105"></textarea>
                        <input type="text" class="form-control mt-2" placeholder="ACTIVA" requiered readonly>
                        <input type="hidden" name="inputEstado" value = "ACTIVA">
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnLogIn" value="Crear Convocatoria">
                        <br>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>