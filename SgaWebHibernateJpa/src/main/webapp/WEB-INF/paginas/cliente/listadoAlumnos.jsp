<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section  id="alumnos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Alumnos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Domicilio</th>
                                <th>Email</th>
                                <th>Telefono</th>
                            </tr>
                        </thead>
                        <tr>
                            <c:forEach var="alumno" items="${alumnos}">
                            <tr>
                                <td>
                                    <div > 
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idAlumno=${alumno.idAlumno}">
                                            ${alumno.idAlumno}</a>
                                    </div>

                                </td>
                                <td>${alumno.nombre} ${alumno.apellido}</td>
                                <td>${alumno.domicilio.calle} ${alumno.domicilio.noCalle} ${alumno.domicilio.pais}</td>
                                <td>${alumno.contacto.email}</td>
                                <td>${alumno.contacto.telefono}</td>
                            </tr>
                        </c:forEach>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarAlumno.jsp"/>

<!-- Editar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/editarAlumno.jsp"/>