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
			<h2>Servicios</h2>
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
		<div class="row">
			<div class="col text-center">
				<div class="section_title">
					<h1>Encuentra lugares adaptados a tus necesidades</h1>
					<br>
					<hr>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<p>En Healdth Mov encontrarás cualquier establecimiento adaptado a tus necesidades.<br>
				¿Cuáles pueden ser estas necesidades? Todas.<br>
				Las personas con discapacidad (motora, auditiva, visual) tienen unas necesidades especiales, que en esta aplicacion podran
				listar los lugares que se acoplen a estas necesidades.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col text-center">
				<div class="section_title">
					<h1>Entérate de lo que sucede a tu alrededor en materia de accesibilidad</h1>
					<br>
					<hr>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<p>Es interactiva, cualquier usuario registrado de forma gratuita puede dar de alta un establecimiento o ingresar uno nuevo en 
				cualquier parte de la ciudad e Bogotá. Además, puede comentar y valorar esa accesibilidad.
				<br>Ya que no es igual la accesibilidad de una persona joven en silla de ruedas que una persona mayor en silla de reudas electrica,
				paraesto las personas tendran la opcion de opinar sobre sus necesidades y lo mas importante dar un rainting de los mejores lugares
				para que asi ayudar a los otros usuarios a conocer estos lugares.</p>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" />	
</body>
</html>