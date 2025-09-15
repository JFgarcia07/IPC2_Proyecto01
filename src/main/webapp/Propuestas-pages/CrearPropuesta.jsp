<%-- 
    Document   : CrearConvocatoria
    Created on : 12 sept 2025, 20:19:09
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Crear Propuesta</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/Includes/NavBar.jsp" />

        <div class="container mt-5">
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/IrListadoConvocatorias" class="btn btn-secondary" style="background-color: #005cbf">
                    <- Regresar
                </a>
            </div>
            <c:if test="${error != null}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error:</strong> ${error}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <form method="POST" action="${pageContext.request.contextPath}/CrearPropuestaServlet">
                <div class="card" style="width: 1000px">
                    <div class="card-body">
                        <h3>Crear Propuesta</h3>
                        <label for="opciones">Id Convocatoria:</label>
                        <input type="text" name="inputIdConvocatoria" value="${idConvocatoria}" class="form-control mt-2" readonly>
                        <br>
                        <label for="opciones">Id Personal:</label>
                        <input type="text" name="inputIdPersonal" value="${idPersonal}" class="form-control mt-2" readonly>
                        <br>
                        <input type="text" name="inputTitulo" class="form-control mt-2" placeholder="Titulo de la Actividad" required>
                        <br>
                        <textarea id="descripcion" name="descripcion" placeholder="Descripción de la actividad:" rows="5" cols="105" required></textarea>
                        <br>
                        <label for="opciones">Tipo de Actividad:</label>
                        <select id="opcionesPropuesta" name="opcionesPropuesta">
                            <option value="1">Ponencia</option>
                            <option value="2">Taller</option>
                        </select>
                        <br>
                        <input type="text" name="inputEncargado" class="form-control mt-2" placeholder="Nombre del Encargado" required>
                        <br> 
                        <input type="text" name="inputEstado" value="EN REVISION" class="form-control mt-2" readonly>
                        <input type="submit" class="btn btn-primary btn-block mt-2" style="background-color: green" name="btnPropuesta" value="Subir Propuesta">
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/Includes/Footer.jsp" />
        <script src="${pageContext.request.contextPath}/js/bootstraép.bundle.min.js"></script>
    </body>
</html>

