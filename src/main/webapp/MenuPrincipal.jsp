<%-- 
    Document   : MenuPrincipal
    Created on : 6 sept 2025, 15:19:36
    Author     : jgarcia07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acerca de</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <jsp:include page="/Includes/NavBar.jsp"/>
        </div> 

        <div class="container mt-5">
            <h1 class="text-center mb-4">Bienvenido a la Web de Congresos de CodeNBugs</h1>
            <p class="lead text-center">
                Imagina una plataforma fácil de usar que te ayuda a organizar y participar en congresos de manera sencilla y moderna.
            </p>

            <p>
                Esta aplicación web es tu <strong>centro digital para la gestión de congresos</strong>. Su objetivo principal es ofrecer una herramienta avanzada que te facilite todas las tareas relacionadas con eventos académicos o profesionales.
            </p>

            <h3 class="mt-4">Si eres un participante:</h3>
            <ul>
                <li><strong>Crea tu cuenta:</strong> Registro con datos básicos, incluyendo foto.</li>
                <li><strong>Explora congresos:</strong> Consulta listado con fechas, ubicación, precio y actividades.</li>
                <li><strong>Inscríbete y paga:</strong> Usa la cartera digital para tu participación.</li>
                <li><strong>Propón tus trabajos:</strong> Postula ponencias o talleres, evaluados por un comité científico.</li>
                <li><strong>Reserva tu lugar en talleres:</strong> Asegura tu espacio si el cupo es limitado.</li>
                <li><strong>Recibe tu diploma:</strong> Disponible si participas en al menos 3 actividades o presentas ponencia/taller.</li>
            </ul>

            <h3 class="mt-4">Si eres un organizador de congresos:</h3>
            <ul>
                <li><strong>Planifica y crea eventos:</strong> Establece precios (mínimo Q35.00).</li>
                <li><strong>Gestiona todo tu congreso:</strong> Inscripciones, participantes y trabajos.</li>
                <li><strong>Define actividades y salones:</strong> Evita conflictos de horarios.</li>
                <li><strong>Controla el aforo:</strong> Maneja cupos máximos en talleres.</li>
                <li><strong>Registra ponentes invitados:</strong> Incluye a quienes no postularon trabajos.</li>
                <li><strong>Controla la asistencia:</strong> Registro por identificación en cada actividad.</li>
                <li><strong>Consulta reportes:</strong> Listados de participantes, reservas y ganancias.</li>
            </ul>

            <h3 class="mt-4">Si eres un administrador del sistema:</h3>
            <ul>
                <li><strong>Configura la plataforma:</strong> Define comisión por pagos.</li>
                <li><strong>Gestiona instituciones y usuarios:</strong> Controla administradores y organizadores.</li>
                <li><strong>Consulta reportes generales:</strong> Revisa ganancias y congresos por institución.</li>
            </ul>

            <p class="mt-4">
                En resumen, esta aplicación está diseñada para ser <strong>100% web</strong>, muy <strong>fácil de usar y cómoda</strong>, con una interfaz amigable que te ayudará a gestionar tus congresos o participar en ellos de la forma más eficiente posible.
            </p>
        </div>

        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        
        <div>
            <jsp:include page="/Includes/Footer.jsp"/>
        </div> 
    </body>
</html>

