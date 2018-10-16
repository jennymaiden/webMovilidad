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
	<link rel="stylesheet" type="text/css" href="resources/style/main_styles.css">
	<link rel="stylesheet" type="text/css" href="resources/style/responsive.css">
	
	<!--  Eventos  jQuery -->
	<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<title>${title}</title>
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="templates/Header.jsp" />
	<!-- Home -->

	<div class="home">
		<div class="home_background_container prlx_parent">
			<div class="home_background prlx" style="background-image:url(resources/imagenes/portada/bogota1.jpg)"></div>
		</div>
	</div>
	
		<!-- Icon Boxes -->

	<div class="icon_boxes">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<img src="resources/imagenes/celMapa.png" width="360px"></img>
				</div>
				<div class="col-lg-8">
					<h1>Busca y localiza puntos de interés accesibles</h1>
					<br>
					<p class="text-justify">HealthMOV nos permite listar y localizar un establecimiento que cumpla con los 
						requisitos que buscamos. Una persona que va en silla de ruedas puede tener bebés 
						y una mascota. Por ello, en HealthMOV podemos hacer una búsqueda de establecimientos
						con varios requisitos de accesibilidad.</p>
				</div>
				
			</div>
		</div>
		<!--  Acordion img -->
		<div class="services">
			<div class="container">
				<div class="row">
					<div class="col text-center">
						<div class="section_title">
							<h1>Lugares adaptados para tus necesidades</h1>
							<br>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div id="demo" class="carousel slide" data-ride="carousel">

						  <!-- Indicators -->
						  <ul class="carousel-indicators">
						    <li data-target="#demo" data-slide-to="0" class="active"></li>
						    <li data-target="#demo" data-slide-to="1"></li>
						    <li data-target="#demo" data-slide-to="2"></li>
						  </ul>
			  
						  <!-- The slideshow -->
						  <div class="carousel-inner">
						    <div class="carousel-item active">
						       <img src="resources/imagenes/portada/ramplas.jpeg" alt="Las ramplas para los discapacitados" width="100%" height="400px">
						    </div>
						    <div class="carousel-item">
						       <img src="resources/imagenes/portada/banios.jpg" alt="LOs baños para los discapacitados" width="100%" height="400px">
						    </div>
						    <div class="carousel-item">
						      <img src="resources/imagenes/portada/aparcar-minusvalido.jpg" alt="parqueadero  para los discapacitados" width="100%" height="400px">
						    </div>
						  </div>
			  
						  <!-- Left and right controls -->
						  <a class="carousel-control-prev" href="#demo" data-slide="prev">
						    <span class="carousel-control-prev-icon"></span>
						  </a>
						  <a class="carousel-control-next" href="#demo" data-slide="next">
						    <span class="carousel-control-next-icon"></span>
						  </a>
			  
						</div>
					</div>
				</div>
			</div>
			
		</div>
		<!--  FIN Acordion img -->
		
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" />
</div>


</body>
</html>