/**
 * 
 */
 var map;
 var markers = [];

/**
 * Funcion para mostrar la lista de los lugares por categoria**/
function mostrarCategoria(cName, id){
	$("#div_volverCategorias").css("display","block");
	$("#div_categorias").css("display","none");
	$("#div_vistaCategoria").css("display","block");
	var search = {}
	search["categoria"] = id;
	search["funcion"] = "1";
	//AJax para mostrar la lista de lugares
	$.ajax({
        url: 'ajaxMovilidad',
        type: 'POST',
        data: 'funcion='+JSON.stringify(search),
        dataType : 'json',
        async: false,
        success: function(result){
           
           var json = JSON.parse(result.lugar);
           var rHtml ='';
           var latitud, longitud, titulo, msg;
           
           for(var x in json){
        	   //console.log(":::::::::"+x+"     :::::::::::::::::"+json[x].nombre);
        	   latitud = json[x].latitud;
        	   longitud = json[x].longitud;
        	   var activo = '';
        	   //console.log("Valor de x:::::: "+x);
        	   if(x == 0){
        		   activo = 'active';
        		   titulo = json[x].nombre;
        		   msg = json[x].mensaje;
        		   $("#sp_contado").html("("+json[x].contador+")");
        	   }
        	   rHtml +='<li class="list-group-item list-group-item-action '+activo+'" onClick="cargarLugar('+json[x].id+')">'+json[x].nombre+'</li>'
        	   //rHtml +='<a href="#" class="list-group-item list-group-item-info list-group-item-action">'+json[x].nombre+'</a>';
           }
           
           //Cargar un marcador al mapa 
           miMapa(latitud,longitud,titulo);	
           
           $("#nombre_categoria").html(cName);
           $("#lista_lugares").html(rHtml);
           $("#descripcion_lugar").html(msg);
        }
    });
	
}

/**
 * Funcion para llamar el mapa de google
 **/
function loadMap(){
	//Centrado en bogota
	map = new google.maps.Map(document.getElementById('lugar_mapa'), {
        center: {lat: 4.6483228507399925, lng: -74.10780699999998},
        zoom: 13
      });
}

/***longitud
 *Funcion que muestra el mapa con las cordenadas**/
function miMapa(latitud, longitud, titulo){
	//Formatear los valores a numeros
	latitud =parseFloat(latitud);
	longitud =parseFloat(longitud);
	//console.log('Latitud:::..'+latitud+'  :: longitud:::.. '+longitud);
	var myLatLng = {lat: latitud, lng: longitud};
	
	//console.log('Parametros es ::: '+myLatLng);
	
	  var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    title: titulo
	  });
	  //INicializar el mapa
	  marker.setMap(null);
	  //console.log('la posicion del marcador es::::::::::::::..'+marker.getPosition());
	  map.setZoom(12);
	  map.setCenter(marker.getPosition());
	  
	  for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(null);
        }
	  
	  markers.push(marker);
	  marker.setMap(map);
	/*var pos = map.getZoom();
	  map.setZoom(12);
	  map.setCenter(marker.getPosition());
	  
	  window.setTimeout(function() {map.setZoom(pos);},3000);*/


}

/**
 * Funcion para cargar la vista del lugar seleccionado*/
function cargarLugar(idLugar){
	
	console.log('El id del lugar es::::...'+idLugar);
	var search = {}
	search["idLugar"] = idLugar;
	search["funcion"] = "3";
	
	$.ajax({
		url: 'ajaxMovilidad',
        type: 'POST',
        data: 'funcion='+JSON.stringify(search),
        dataType : 'json',
        async: false,
        success: function(result){
        	console.log('el resultado es::...'+result);
        	var json = JSON.parse(result.lugar);
        	console.log('el json es:::::::::..'+json);
        	
        	$("#descripcion_lugar").html(json.mensaje);
        	$("#sp_contado").html("("+json.contador+")");
        	$("#btnContador").data("lugar",json.id);
        	$("#btnContador").data("megusta",json.contador);
        	//console.log('***Latitud*****');
        	//Cargar un marcador al mapa 
            miMapa(json.latitud,json.longitud,json.nombre);	
        	
        },error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
		}
	});
}
/**
 * Funcion para volver a ver los botones de la categoria**/
function volverCategorias(){
	
	$("#div_volverCategorias").css("display","none");
	$("#div_categorias").css("display","flex");
	$("#div_vistaCategoria").css("display","none");
}

/**
 * FUncion para ocultar el listado de las categorias y mostrar el
 * formulario de creacion de lugar/*/
function verFormCrearLugar(idLugar,idCategoria){
	console.log("El lugar es:............"+idLugar);
	if(idLugar !='null'&& idCategoria!='null' ){
		$("#selCategoria option:selected").removeAttr("selected");
		var search = {}
		search["idLugar"] = idLugar;
		search["funcion"] = "3";
		
		$.ajax({
			url: 'ajaxMovilidad',
	        type: 'POST',
	        data: 'funcion='+JSON.stringify(search),
	        dataType : 'json',
	        async: false,
	        success: function(result){
	        	
	        	var json = JSON.parse(result.lugar);
	        	//console.log('el json es:::::::::..'+json);
	        	$("#idLugar").val(json.id);
	        	$("#nombreLugar").val(json.nombre);
	        	$("#longLugar").val(json.longitud);
	        	$("#latLugar").val(json.latitud);
	        	$("#msgLugar").val(json.mensaje);
	        	$("#contadorLugar").val(json.contador);
	        	$("#selCategoria option[value="+ idCategoria +"]").attr("selected",true);
	        	
	        	
	        
	        	
	        },error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			}
		});
	}else{
		$("#idLugar").val("");
    	$("#nombreLugar").val("");
    	$("#longLugar").val("");
    	$("#latLugar").val("");
    	$("#msgLugar").val("");
    	$("#contadorLugar").val("");
	}
		//MOstrar el formulario vacio de creacion de lugar
		$("#div_listaCatLugar").css("display","none");
		$("#div_fromLugar").css("display","block");
		$("#btnVerFormLugar").css("display","none");
    	$("#btnreturnList").css("display","block");
		
	
	
}


/*
 * Funcion para volver a ver la vista de loslugares**/
function volverVerLista(){
	$("#div_listaCatLugar").css("display","block");
	$("#div_fromLugar").css("display","none");
	$("#btnVerFormLugar").css("display","block");
	$("#btnreturnList").css("display","none");
}

/**
 * Funcion para ver el formulario de cargar imagenes de los lugares**/
function verFormCargarArchivo(idLugar, nombreLugar){
	$("#div_listaCatLugar").css("display","none");
	$("#div_fromLugar").css("display","none");
	$("#div_formArchivo").css("display","block");
	$("#btnVerFormLugar").css("display","none");
	$("#btnreturnList").css("display","block");
	
	$("#sp_nameLugar").html(nombreLugar);
	$("#idLugarA").val(idLugar);
	
}


/**
 * Funcion para contar los megusta de l aplicacion*/
function contarMegusta(valor){
	var id = $(valor).data("lugar");
	
	var search = {}
	search["idLugar"] = id;
	search["contador"] = $(valor).data("megusta");
	search["funcion"] = "4";
	
	$.ajax({
		url: 'ajaxMovilidad',
        type: 'POST',
        data: 'funcion='+JSON.stringify(search),
        dataType : 'json',
        async: false,
        success: function(result){
        	
        	var json = JSON.parse(result.contador);
        	//console.log('el json es:::::::::..'+json);
        	$("#sp_contado").html("("+json+")");
        	
        },error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
		}
	});
	
}








