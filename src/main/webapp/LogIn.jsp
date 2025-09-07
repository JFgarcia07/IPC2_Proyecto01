<%-- 
    Document   : logIn
    Created on : 6 sept 2025, 11:41:56
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <title>LogIn</title>
    </head>
    <body>
    <center>
        <div class="container mt-5">
            <form method="POST" action="/IPC2_Proyecto01/logInRequest">
                <div class="card" style="width: 550px">
                    <div class="card-body">
                        <h3>Iniciar Sesion</h3>
                        <input type="text" name="inputEmail" class="form-control mt-2" placeholder="Ingresar correo electronico" required>
                        <br>
                        <input type="password" name="inputPassword" class="form-control mt-2" placeholder="Ingresar contraseña" required>
                        <br>
                        <input type="submit" class="btn btn-primary btn-block mt-2" name="btnLogIn" value="Iniciar Sesion">
                    </div>
                </div>
            </form>
        </div>
    </center>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>
</html>
