<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Bienvenido <strong>${usr.nombre}</strong></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
       	<h3>Su informacion personal es</h3>
       	<p><strong>Nombre:</strong> ${usr.nombre} ${usr.apellido}</p>
       	<div class="row">
       		<div class="col-sm-12">
       			<p><strong>Correo:</strong> ${usr.email}</p>
       			<p><strong>Telefono:</strong> ${usr.telefono}</p>
       			<p><strong>Direccion:</strong> ${usr.direccion}</p>
       			<p><strong>Ciudad:</strong> ${usr.ciudad}</p>
       		</div>
       		
       	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</html>