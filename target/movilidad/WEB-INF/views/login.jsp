<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Estilos -->
	
	<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/style/page_style.css">
	<link rel="stylesheet" type="text/css" href="resources/style/responsive_page_style.css">
	
	<!--  Eventos  jQuery -->
	<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>	
	
	<title>${title}</title>
</head>
<body>
<jsp:include page="templates/Header.jsp" />
	<!-- Home -->

	<div class="home">
		<div class="home_background_container prlx_parent">
			<div class="home_background prlx" style="background-image:url(resources/imagenes/home_background.jpg)"></div>
		</div>
		
		<div class="home_title">
			<h2>Unete a nosotros</h2>
			<div class="next_section_scroll">
				<div class="next_section nav_links" data-scroll-to=".icon_boxes">
					<i class="fas fa-chevron-down trans_200"></i>
					<i class="fas fa-chevron-down trans_200"></i>
				</div>
			</div>
		</div>
	
	</div>
	<!-- Contenido -->
	<div class="container">
		<br>
		
		<c:if test="${validar != ''}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>${validar}</strong> 
			  <p>El usuario es:...<strong>${usr.nombre}</strong></p>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			
		</c:if>
		<br>
		<ul class="nav nav-tabs">
			<li class="nav-item "><a href="#registro" data-toggle="tab" class="nav-link active show">Registrate</a></li>
			<li class="nav-item "><a href="#login" data-toggle="tab" class="nav-link">Ingresa</a></li>
		</ul>
		<div class="tab-content clearfix">
			<div class="tab-pane active" id="registro">
				<div class="row" style="margin-top:30px;">
			
					<div class="col-lg-2"></div>
					<div class="col-lg-8">
						<h2>Ingrese su informacion personal</h2><hr>
						<form action="formularioInicio" method="POST">
		    				<div class="row">
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="nombre"><span class="text-danger">*</span>Nombre:</label>
								      <input type="text" class="form-control"  id="nombre" placeholder="Ingrese su nombre" name="nombre" required>
								    </div>
								    <div class="form-group">
								      <label for="email"><span class="text-danger">*</span>Email:</label>
								      <input type="text" class="form-control" id="email" placeholder="Ingrese su correo" name="email" required>
								    </div>
								    <div class="form-group">
								      <label for="direccion">Direccion:</label>
								      <input type="text" class="form-control" id="direccion" placeholder="Ingrese su direccion" name="direccion">
								    </div>
								    <div class="form-group">
								      <label for="email"><span class="text-danger">*</span>Discapacidad:</label>
								      <select class="form-control" id="discapacidad" name="discapacidad" required>
										<option value="0"> Seleccione</option >
										<c:forEach items="${discapacidades}" var="dicapacidad">
											<option value="${dicapacidad.id}" > ${dicapacidad.nombre} </option>	
										</c:forEach>
									  </select>
								      
								    </div>
		    					</div>
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="apellido"><span class="text-danger">*</span>Apellido:</label>
								      <input type="text" class="form-control" id="apellido" placeholder="Ingrese su apellido" name="apellido" required>
								    </div>
								    <div class="form-group">
								      <label for="telefono">Telefono:</label>
								      <input type="text" class="form-control" id="telefono" placeholder="Ingrese su nombre" name="telefono">
								    </div>
								    <div class="form-group">
								      <label for="ciudad">Ciudad:</label>
								      <input type="text" class="form-control" id="ciudad" placeholder="Ingrese su ciudad" name="ciudad">
								    </div>
		    					</div>
		    				</div>
		    				<h2>Informacion de plataforma</h2><hr>
		    				<div class="row">
		    					
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="nameUsuario"><span class="text-danger">*</span>Nombre Usuario:</label>
								      <input type="text" class="form-control" id="nameUsuario" placeholder="Ingrese su usuario" name="nameUsuario" required>
								    </div>
		    					</div>
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="contrasenia"><span class="text-danger">*</span>Contraseña:</label>
								      <input type="password" class="form-control" id="contrasenia" placeholder="Ingrese su contraseña" name="contrasenia" required>
								    </div>
		    					</div>
		    				</div>
		    				<div class="row">
		    					<div class="col-sm-12" align="center">
		    						<button type="submit" class="btn btn-success">Registrarse</button>
		    					</div>
		    				</div>
		    				
		    
		    				
		  				</form>
					</div>
					<div class="col-lg-2"></div>
					
				</div>
			</div>
			<div class="tab-pane" id="login">
				<div class="row" style="margin-top:30px;">
			
					<div class="col-lg-2"></div>
					<div class="col-lg-8">
						<h2>Ingrese a la aplicacion</h2><hr>
						<form action="formularioLogin" method="POST">
		    				<div class="row">
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="usuario">Usuario:</label>
								      <input type="text" class="form-control" id="usuario" placeholder="Ingrese su usuario" name="usuario">
								    </div>
								    
								    
								    
		    					</div>
		    					<div class="col-sm-6">
		    						<div class="form-group">
								      <label for="password">Contraseña:</label>
								      <input type="password" class="form-control" id="password" placeholder="Ingrese su contraseña" name="password">
								    </div>
								    
							
		    					</div>
		    				</div>
		    				
		    				
		    				<div class="row">
		    					<div class="col-sm-12" align="center">
		    						<button type="submit" class="btn btn-success">Entrar</button>
		    					</div>
		    				</div>
		    				
		    
		    				
		  				</form>
					</div>
					<div class="col-lg-2"></div>
					
				</div>
			</div>
		</div>
		<br>
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" />	
</body>
</html>