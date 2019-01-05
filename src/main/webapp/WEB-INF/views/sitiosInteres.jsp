<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDdD2rLSbypejspt-U9Q6LF_WhE4xgOQXk&callback=initialise"
    async defer></script>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 300px;
        width: 300px;
        
        
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>

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
			<h2>Sitios</h2>
			<div class="next_section_scroll">
				<div class="next_section nav_links" data-scroll-to=".icon_boxes">
					<i class="fas fa-chevron-down trans_200"></i> <i
						class="fas fa-chevron-down trans_200"></i>
				</div>
			</div>
		</div>

	</div> 
	<!-- Contenido -->
	<div class="container">
	<br>
		<div class="row">
				<div class="col text-center">
					<div class="section_title">
						<h2>Elegir una categoria</h2>
						<br>
						<hr>
					</div>
				</div>
		</div>
		
		<div class="row" id="div_categorias">
		   	<c:forEach items="${categorias}" var="categoria">
		   		<div class="col-sm-4" align="center"><button type="button" class="btn btn-warning" onClick="mostrarCategoria('${categoria.nombre}', '${categoria.id}')">${categoria.nombre}</button></div>
			</c:forEach>	    		
		</div>
		<div class="row" id="div_volverCategorias" style="display:none">
			<div class="col-sm-8"></div>
			<div class="col-sm-4" align="left"><button type="button" class="btn btn-sm btn-info" onClick="volverCategorias()">Volver categorias</button></div>
		</div>
		<div id="div_vistaCategoria" style="display:none">
			<div class="row">
				<h2 id="nombre_categoria"></h2>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<ul id="lista_lugares" class="list-group list-group-flush">
						
					</ul>
				</div>
				<div class="col-sm-8">
					<h2>Mapa</h2>
					<div id="lugar_mapa">
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" /> 
</body>
</html>