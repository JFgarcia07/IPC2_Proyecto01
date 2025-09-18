<%-- 
    Document   : CrearCongreso
    Created on : 17 sept 2025, 11:58:49
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Congreso</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/Includes/NavBar.jsp"/>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <div class="container mt-5">
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/IrGestorCongresos" class="btn btn-secondary" style="background-color: #005cbf">
                    <- Regresar
                </a>
            </div>
            <form method="POST" action="${pageContext.request.contextPath}/CrearCongresoServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Crear Congreso</h3>
                        <label>ID personal del Creador del Congreso</label>
                        <input type="text" value="${idPersonal}" class="form-control mt-2" placeholder="ID Personal" readonly>
                        <input type="hidden" name="inputIdPersonal" value="${idPersonal}">
                        <br>
                        <input type="text" name="inputIdCongreso" class="form-control mt-2" placeholder="ID Congreso" required>
                        <br>
                        <input type="text" name="inputTitulo" class="form-control mt-2" placeholder="Titulo del Congreso" required>
                        <br>
                        <textarea id="descripcion" name="descripcion" placeholder="Descripción del Congreso:" rows="5" cols="105"></textarea>
                        <br>
                        <label for="fecha">Fecha de Inicio del Congreso:</label>
                        <input type="date" id="fechaInicio" name="fechaInicio" value="2025-01-01">
                        <br>
                        <input type="text" name="inputCosto" class="form-control mt-2" placeholder="Costo del Congreso" required>
                        <br>
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnCrearCongreso" value="Crear Congreso">
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
