<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Estilos -->

<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/style/page_style.css">
<link rel="stylesheet" type="text/css"
	href="resources/style/responsive_page_style.css">

<!--  Eventos  jQuery -->
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="resources/js/ScriptUtilidad.js"></script>

<title>${title}</title>
</head>
<body>
	<jsp:include page="templates/Header.jsp" />
	<!-- Home -->
	<div class="home">
		<div class="home_background_container prlx_parent">
			<div class="home_background prlx"
				style="background-image: url(resources/imagenes/home_background.jpg)"></div>
		</div>

		<div class="home_title">
			<h2>Administracion de sitios</h2>
			<div class="next_section_scroll">
				<div class="next_section nav_links" data-scroll-to=".icon_boxes">
					<i class="fas fa-chevron-down trans_200"></i> <i
						class="fas fa-chevron-down trans_200"></i>
				</div>
			</div>
		</div>

	</div>
	<!-- Contenido -->
	<div class="container" style="margin-bottom: 40px">
		<div class="row" style="margin-top: 30px">
				<div class="col text-center">
					<div class="section_title">
						<h3>Modulo para la administracion de los lugares. Veras el listado de las categorias que se tienen y dentro de cada item esta el listado
						de los lugares que se tienen.</h3>
						<hr>
					</div>
				</div>
		</div>
		<div class="row">
			<div class="col-sm-12" align="right">
				<button class=" btn  btn-danger" onClick="verFormCrearLugar('null','null');" id="btnVerFormLugar">Crear Lugar</button>
				<button class=" btn  btn-info" onClick="volverVerLista();" id="btnreturnList" style="display:none">Volver a Lista</button>
			</div>
			
		</div>
		<br>
		<div class="row" id="div_listaCatLugar">
			<div class="col-sm-12">
				<div class="list-group" id="accordion">
				  	<c:forEach items="${categoriaLugar}" var="itemCatLugar">
				   			<div class="list-group-item list-group-item-primary">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							        <a data-toggle="collapse" data-parent="#accordion" href="#_${itemCatLugar.html}">
							        	${itemCatLugar.nombre}</a>
							      </h4>
							      	
							    </div>
							    <div id="_${itemCatLugar.html}" class="panel-collapse collapse in">
							      <div class="panel-body">
							      	<ul class="list-group">
							      		<c:forEach items="${itemCatLugar.listLugar}" var="itemLugar">
									   		<li class="list-group-item">
									   			<div class="row">
									   				<div class="col-sm-6">${itemLugar.nombre}</div>
									   				<div class="col-sm-4"></div>
									   				<div class="col-sm-2 btn-group" align="right">
												  		<button type="button" class="btn btn-group-sm btn-sm btn-warning" onClick="verFormCrearLugar(${itemLugar.id}, ${itemCatLugar.id});">Editar</button>
												  		<button type="button" class="btn btn-group-sm btn-sm btn-success" onClick="verFormCargarArchivo(${itemLugar.id},'${itemLugar.nombre}');">Subir Img</button>
												  	</div>
									   			</div>
									   		
									   			
									   		</li>
										</c:forEach>
									  
									</ul>
							      </div>
							    </div>
						  	</div>
					</c:forEach>
				  
				  
				</div>
			</div>
		</div>
		
		<div class="row" id="div_fromLugar" style="display:none">
			<div class="row">
				<div class="col-sm-6">
					<h2>Formulario de registro Lugar</h2>
				</div>
			</div>
			<form:form method="post" action="formEditLugar" commandName="formLugarVO">
				<form:hidden path="id" id="idLugar"/>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
						    <label  for="categoria">Seleccione la categoria:</label>
						    <form:select class="form-control" id="selCategoria" path="idCategoria">
							    <c:forEach items="${listCategoria}" var="itemCategoria">
							    	<option value="${itemCategoria.id}">${itemCategoria.nombre}</option>
							    </c:forEach>
							    
							  </form:select>
						    
						 </div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
						    <label  for="nombre">Nombre:</label>
						    <form:input path="nombre"  class="form-control" id="nombreLugar"/>
						 </div>
					</div>
					
					
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
						    <label  for="longitud">Longitud:</label>
						    <form:input path="longitud"  class="form-control" id="longLugar"/>
						 </div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
						    <label for="Latitud">Latitud:</label>
						    <form:input path="Latitud"  class="form-control" id="latLugar"/>
						 </div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-sm-8">
						<div class="form-group">
						    <label for="Latitud">Mensaje:</label>
						    <form:textarea path="mensaje"  class="form-control" id="msgLugar"/>
						    
						 </div>
					</div>
					<div class="col-sm-4">
						<div class="form-group">
						    <label for="meGusta">Cantidad de personas que les gusta este lugar:</label>
						    <form:input path="contador"  class="form-control" readonly="true" id="contadorLugar"/>
						    
						 </div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12" align="center">
						<input type="submit" value="Editar Lugar" class="btn btn-success">
					</div>
				</div>
			</form:form>
		
		</div>
		
		<div class="row" id="div_formArchivo" style="display:none">
			
			<c:out value="${message}" />
			<form:form method="post" action="formCargarArchivo" enctype="multipart/form-data" commandName="imagenLugarVO">
				<form:hidden path="idLugar" id="idLugarA"/>
				<div class="row">
					<div class="col-sm-12">
						<h1 id="sp_nameLugar"></h1>
						<h3>Cargar las imagenes para el lugar </h3>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
						    <label for=fichero>Buscar Archivo:</label>
						    <form:input path="fichero" class="form-control" type="file" />
						    
						 </div>
					  
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12" align="center">
						<input type="submit" value="Guardar Imagen" class="btn btn-success">
					</div>
				</div>
				
			</form:form> 
			
			
			
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" /> 

</body>
</html>