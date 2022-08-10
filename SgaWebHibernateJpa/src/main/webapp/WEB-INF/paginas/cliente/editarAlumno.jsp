<div class="modal fade" id="editarAlumnoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Editar Alumno</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar" 
                  method="POST" class="was-validated">
                
                <input type="hidden" name="idAlumno" value="${alumno.idAlumno}"/>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" value="${alumno.nombre}" >
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" class="form-control" name="apellido" value="${alumno.apellido}">
                    </div>
                    <div>
                        <h6>Datos de Domicilio</h6>
                    </div>
                    <div class="form-group">
                        <label for="calle">Calle:</label>
                        <input type="text" class="form-control" name="calle" value="${alumno.domicilio.calle}">
                    </div>
                    <div class="form-group">
                        <label for="noCalle">noCalle:</label>
                        <input type="text" class="form-control" name="noCalle" value="${alumno.domicilio.noCalle}" >
                    </div>
                    <div class="form-group">
                        <label for="pais">Pais:</label>
                        <input type="text" class="form-control" name="pais" value="${alumno.domicilio.pais}" >
                    </div>
                    <div>
                        <h6>Datos de Contacto</h6>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" name="email"  value="${alumno.contacto.email}">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono:</label>
                        <input type="tel" class="form-control" name="telefono"  value="${alumno.contacto.telefono}">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit" name="Modificar">Modificar</button>
                    <button class="btn btn-danger" type="submit" name="Eliminar">Eliminar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
