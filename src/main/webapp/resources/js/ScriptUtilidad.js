/**
 * 
 */

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
           console.log("Respuesta::....."+result);
           console.log("Respuesta::....."+result.lugar);
           var json = JSON.stringify(result.lugar);
           console.log("Respuesta json::....."+json.nombre);
           for(var x in result){
        	   console.log(":::::::::"+x+"     :::::::::::::::::"+result[x]);
           }
           $("#nombre_categoria").html(cName);
           $("#lista_lugares").html('<li><a href="#div_vistaCategoria" data-latitud="">nombre</a></li>');
        }
    });
	
	//alert("La categoria selecionada es:...."+id);
}

/**
 * Funcion para volver a ver los botones de la categoria**/
function volverCategorias(){
	
	$("#div_volverCategorias").css("display","none");
	$("#div_categorias").css("display","flex");
	$("#div_vistaCategoria").css("display","none");
	
	var search = {}
	search["categoria"] = "volverCategoria";
	search["funcion"] = "1";
	
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