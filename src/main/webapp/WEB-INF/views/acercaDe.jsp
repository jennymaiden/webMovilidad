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
						<h1>A strong team with a strong background</h1>
					</div>
					<div class="button icon_box_button trans_200">
						<a href="#" class="trans_200">discover more</a>
					</div>
				</div>

				<div class="col-lg-4 icon_box_col">

					<!-- Icon Box Item -->
					<div class="icon_box_paragraph">
						<p>Etiam nec odio vestibulum est mattis effic iturut magna. Pellentesque sit am et tellus blandit. Etiam nec odio vestibul. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae enim enim. Sed nec dignissim purus. Praesent bibendum tristique nulla, quis fringilla mauris sagittis ut. Maecenas sit amet varius nulla. Praesent faucibus ipsum.</p>
					</div>

				</div>

				<div class="col-lg-4 icon_box_col">

					<!-- Icon Box Item -->
					<div class="icon_box_paragraph">
						<p>Si non ligula sodales vestibulum. Nam nec augue a leo ullamcorper sollicitudin. Suspendisse mattis malesuada tortor sit amet accumsan. Mauris eu elit quis enim pretium finibus. Integer tempor, augue et lacinia cursus, nisl elit elementum magna, non blandit nisi ipsum vitae nulla. </p>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="templates/Footer.jsp" />	
</body>
</html>