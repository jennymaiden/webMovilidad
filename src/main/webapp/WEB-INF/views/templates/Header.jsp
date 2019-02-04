<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="header d-flex flex-row justify-content-end align-items-center trans_200">
		
		<!-- Logo -->
		<div class="logo mr-auto">
			<a href="/movilidad">Health<span>Mov</span></a>
		</div>

		<!-- Navigation -->
		<nav class="main_nav justify-self-end text-right">
			<ul>
				<li class="active"><a href="acercaDeNosotros">Acerca de nosotros</a></li>
				<li><a href="servicios">Servicios</a></li>
				<li><a href="noticias">Noticias</a></li>
				<c:if test="${perfil !='true'}">
					<li><a href="unete">Unete</a></li>
				</c:if>
				<c:if test="${perfil =='true'}">
					<li><a href="sitiosInteres">Sitios Interes</a></li>
					<li><a href="administrarSitios">Administracion de sitios</a></li>
					<li><a href="#" id="perfilUsuario" data-toggle="modal" data-target="#myModal">Bienvenido <strong>${usr.nombre}</strong></a></li>
				</c:if>
			</ul>
			
		</nav>

		<!-- Hamburger -->
		<div class="hamburger_container bez_1">
			<i class="fas fa-bars trans_200"></i>
		</div>
		
	</header>
	
	<!-- Menu -->

	<div class="menu_container">
		<div class="menu menu_mm text-right">
			<div class="menu_close"><i class="far fa-times-circle trans_200"></i></div>
			<ul class="menu_mm">
				<li class="menu_mm active"><a href="acercaDeNosotros">Acerca de nosotros</a></li>
				<li class="menu_mm"><a href="servicios">Servicios</a></li>
				<li class="menu_mm"><a href="noticias">Noticias</a></li>
				<li class="menu_mm"><a href="unete 	">Registrate</a></li>
			</ul>
		</div>
	</div>
	
	<jsp:include page="../modals/PerfilUsuario.jsp" />
	