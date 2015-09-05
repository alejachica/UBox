$(document).ready(function(){
	$('.btn-idioma').click(function (e) {
        e.preventDefault();
        $('#modalCambioIdioma').modal('show');
    });
	
	$(".nav-stacked").show();
});

function liCambioContrasenia(){
	$("#divCambiarContrasenia").show();
	$("#liUbicacionCambioContrasenia").show();
	$("#liUbicacionConfDatos").hide();
	$("#divCofDatos").hide();
}

function liConfDatos(){
	$("#divCofDatos").show();
	$("#liUbicacionConfDatos").show();
	$("#divCambiarContrasenia").hide();
	$("#liUbicacionCambioContrasenia").hide();
}