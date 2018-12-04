/**
 * 
 */

/**
 * Funcion para mostrar la lista de los lugares por categoria**/
function mostrarCategoria(html, id){
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
        async: false,
        success: function(result){
           console.log("Respuesta::....."+result);
        	$("#lista_lugares").html(result);
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