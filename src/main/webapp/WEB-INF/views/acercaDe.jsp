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
			<h2>Acerca de nosotros</h2>
			<div class="next_section_scroll">
				<div class="next_section nav_links" data-scroll-to=".icon_boxes">
					<i class="fas fa-chevron-down trans_200"></i>
					<i class="fas fa-chevron-down trans_200"></i>
				</div>
			</div>
		</div>
	
	</div>
	<!-- Contenido -->
	<!-- Icon Boxes -->

	<div class="icon_boxes">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="icon_box_title">
						<h1>Nuestro objetivo</h1>
					</div>
				</div>

				<div class="col-lg-8 icon_box_col">

					<!-- Icon Box Item -->
					<div class="icon_box_paragraph">
						<p>Brindar una plataforma de información de lugares de interés   para las personas que sufran de algun tipo de  discapacidad 
						, en donde dichos lugares tendrán en común su facilidad de acceso para estas personas.</p>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="icon_boxes">
		<div class="container" style="margin-bottom: 30px">
			<div class="row">
				<div class="col text-center">
					<div class="section_title">
						<h1>Objetivos Especificos</h1>
						<br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					
					<ol>
					  <li>Brindar una  plataforma dinámica en donde los mismos usuarios la puedan actualizar, agregando los lugares que cumplan las 
						condiciones de movilidad para discapacitados así mismo como reportar sitios que se encuentran en condiciones no aptas y 
						que se encuentren es esta plataforma.</li>
					  <li>Junto con la  colaboración de una API de  google maps brindar la ubicacion de dichos lugares.</li>
					  <li>El sistema contará un boton de "megusta" que te indicara la cantidad de personas a las que les ha gustado este sitio
					  y asi mismo tú podras dar click si te ha gustado el lugar</li>
					</ol>
				</div>
				
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" />	
</body>
</html>