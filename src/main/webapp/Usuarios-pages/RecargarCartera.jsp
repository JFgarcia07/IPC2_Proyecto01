<%-- 
    Document   : RecargarCartera
    Created on : 16 sept 2025, 10:34:22
    Author     : jgarcia07
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Recarga Cartera Digital</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="/Includes/NavBar.jsp"/>

    <div class="container mt-5">
        <!-- Botón regresar -->
        <div class="mb-3">
            <a href="${pageContext.request.contextPath}/IrPerfilServlet" 
               class="btn btn-primary">
                ← Regresar
            </a>
        </div>

        <div class="card shadow-lg border-0 mx-auto" style="max-width: 700px;">
            <div class="card-header bg-success text-white text-center">
                <h3 class="mb-0">💳 Recargar Cartera Digital</h3>
            </div>
            <div class="card-body p-4">
                <form method="POST" action="${pageContext.request.contextPath}/RecargarCarteraServlet">
                    
                    <div class="mb-3">
                        <label class="form-label fw-bold">ID Personal</label>
                        <input type="text" name="inputIdPersonal" value="${perfil.idPersonal}" class="form-control" readonly>
                        <input type="hidden" name="idPersonal" value="${perfil.idPersonal}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Monto a recargar</label>
                        <input type="text" name="inputCartera" class="form-control" placeholder="Ingrese el monto" required>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-success btn-lg" >
                            Realizar Recarga
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="/Includes/Footer.jsp"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>

