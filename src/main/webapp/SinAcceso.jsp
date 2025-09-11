<%-- 
    Document   : SinAcceso
    Created on : 7 sept 2025, 17:51:20
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No tiene acceso</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <jsp:include page="/Includes/NavBar.jsp"/>
        </div> 
    <center>
        <h1>El usuario no tiene acceso a esta opcion!</h1>
        <h2>Para mayor información puedes comunicarte a tu distribuidor</h2>
    </center>
        
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <div>
            <jsp:include page="/Includes/Footer.jsp"/>
        </div> 
    </body>
</html>
