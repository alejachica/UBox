$(document).ready(function(){
	$('.abrirTras').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Solicitud de Traslado a Ubox");
		tabla = "<table>"+
		"<tr><td colspan='4'>Para solicitar traslado a nuestro operador es necesario que tenga disponible su tel\xe9fono celular para recibir un c\xf3digo con el cual confirmar\xe1 la solicitud de traslado.</td></tr>"+
		"<tr><td colspan='4'>Ingrese los siguientes datos:</td></tr>"+
		"<tr><td><b>Tipo de Documento:</b></td><td><SELECT NAME='selCombo'>"+
		"<OPTION>C\xe9dula Ciudadan\xeda</OPTION>"+
		"<OPTION>C\xe9dula Extranjer\xeda</OPTION>"+
		"<OPTION>Tarjeta Identidad</OPTION>"+
		"<OPTION>Registro Civil</OPTION> "+
		"</SELECT></td><td><b>N\xfamero de Documento:</b></td><td><input type='text' size='15px'></td></tr>"+
		"<tr><td><b>Fecha Expedici\xf3n:</b></td><td><input type='text' size='15px'></td><td></td><td></td></tr>"+
		"<tr><td><b>Primer Nombre:</b></td><td><input type='text' size='15px'></td>"+
		"<td><b>Segundo Nombre:</b></td><td><input type='text' size='15px'></td></tr>"+
		"<tr><td><b>Primer Apellido:</b></td><td><input type='text' size='15px'></td>"+
		"<td><b>Segundo Apellido:</b></td><td><input type='text' size='15px'></td></tr>"+
		"<tr><td colspan='2'><button type='button' style='background-color:green; color:white'>Enviar C\xf3digo</button></td><td></td>"+
		"<td></td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
});

