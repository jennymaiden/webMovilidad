/**
 * 
 */

/**
 * Funcion para pintar el googlemaps
 * var map;
     
      
      function initMap() {
    	 
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 8
        });
      }
      
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
           
           //console.log("Respuesta**::....."+result.lugar);
           
           var json = JSON.parse(result.lugar);
           var rHtml ='';
           var latitud, longitud;
           
           for(var x in json){
        	   //console.log(":::::::::"+x+"     :::::::::::::::::"+json[x].nombre);
        	   latitud = json[x].Latitud;
        	   longitud = json[x].longitud;
        	   var activo = '';
        	   console.log("Valos de x::::::"+x);
        	   if(x == '0'){
        		   activo = 'active';
        	   }
        	   rHtml +='<li class="list-group-item list-group-item-action '+activo+'" onClick="">'+json[x].nombre+'</li>'
           }
           
           map = new google.maps.Map(document.getElementById('lugar_mapa'), {
               center: {lat: latitud, lng: longitud},
               zoom: 8
             });
           
           new google.maps.event.addDomListener(window, 'load', map);
           $("#nombre_categoria").html(cName);
           $("#lista_lugares").html(rHtml);
        }
    });
	
}

/**
 * Funcion para volver a ver los botones de la categoria**/
function volverCategorias(){
	
	$("#div_volverCategorias").css("display","none");
	$("#div_categorias").css("display","flex");
	$("#div_vistaCategoria").css("display","none");
	
	var search = {}
	search["funcion"] = "2";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "ajaxMovilidad",
		data : JSON.stringify(search),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			//display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
		},
		done : function(e) {
			console.log("DONE");
			//enableSearchButton(true);
		}
	});
}