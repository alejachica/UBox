$(document).ready(function(){
	
	$('.abrirDes1').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Servicio B\xe1sico");
		tabla = "<table>"+
		"<tr><td>Gratis</td></tr>"+
		"<tr><td>1 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
	
	$('.abrirDes2').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Premium Bronce");
		tabla = "<table>"+
		"<tr><td>$18.000</td></tr>"+
		"<tr><td>20 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronizaci\xf3n con PC</td></tr>"+
		"<tr><td>2 Tr\xe1mites con notarias</td></tr>"+
		"<tr><td>Prioridad en tr\xe1mites</td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
	
	$('.abrirDes3').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Premium Plata");
		tabla = "<table>"+
		"<tr><td>$50.000</td></tr>"+
		"<tr><td>80 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronizaci\xf3n con PC</td></tr>"+
		"<tr><td>3 tr\xe1mites con notarias</td></tr>"+
		"<tr><td>Prioridad en tr\xe1mites</td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
	
	$('.abrirDes4').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Premium Oro");
		tabla = "<table>"+
		"<tr><td>$120.000</td></tr>"+
		"<tr><td>500 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronizaci\xf3n con PC</td></tr>"+
		"<tr><td>10 tr\xe1mites con notarias</td></tr>"+
		"<tr><td>Prioridad en tr\xe1mites</td></tr>"+
		"</table>"
		$("#divInfo").html(tabla);
    });
	
	//CANCELAR SERVICIO
	
	$('#botonCanServ1').click(function (e) {
        e.preventDefault();
        $('#modalCancelarServicio').modal('show');
		$('#botonSiCanServicio1').show();
		$('#botonSiCanServicio2').hide();
		$('#botonSiCanServicio3').hide();
		$('#pCancelarServivio').text("Esta seguro que quiere cancelar su servicio Bronce?");
    });
	
	$('#botonCanServ2').click(function (e) {
        e.preventDefault();
        $('#modalCancelarServicio').modal('show');
		$('#botonSiCanServicio1').hide();
		$('#botonSiCanServicio2').show();
		$('#botonSiCanServicio3').hide();
		$('#pCancelarServivio').text("Esta seguro que quiere cancelar su servicio Plata?");
    });
	
	$('#botonCanServ3').click(function (e) {
        e.preventDefault();
        $('#modalCancelarServicio').modal('show');
		$('#botonSiCanServicio1').hide();
		$('#botonSiCanServicio2').hide();
		$('#botonSiCanServicio3').show();
		$('#pCancelarServivio').text("Esta seguro que quiere cancelar su servicio Oro?");
    });
	
	$('#botonSiCanServicio1').click(function (e) {
		$('#spanActiCan1').hide();
		$('#botonCanServ1').hide();
		$('#spanInacCan1').show();
		$('#btnAdqServ1').show();
    });
	
	$('#botonSiCanServicio2').click(function (e) {
		$('#spanActiCan2').hide();
		$('#botonCanServ2').hide();
		$('#spanInacCan2').show();
		$('#btnAdqServ2').show();
    });
	
	$('#botonSiCanServicio3').click(function (e) {
		$('#spanActiCan3').hide();
		$('#botonCanServ3').hide();
		$('#spanInacCan3').show();
		$('#btnAdqServ3').show();
    });
	
	//ADQUIRIR SERVICIO
	
	$('#btnAdqServ1').click(function (e) {
        e.preventDefault();
        $('#modalAdquirirServicio').modal('show');
		$('#divModalAdquServicio').modal('show');
		$('#botonSiAdquiServicio1').show();
		$('#botonSiAdquiServicio2').hide();
		$('#botonSiAdquiServicio3').hide();
		$('#pAdquirirServicio').text("Esta seguro que quiere adquirir el servicio Premium Bronce?");
    });
	
	$('#btnAdqServ2').click(function (e) {
        e.preventDefault();
        $('#modalAdquirirServicio').modal('show');
		$('#divModalAdquServicio').modal('show');
		$('#botonSiAdquiServicio1').hide();
		$('#botonSiAdquiServicio2').show();
		$('#botonSiAdquiServicio3').hide();
		$('#pAdquirirServicio').text("Esta seguro que quiere adquirir el servicio Premium Plata?");
    });
	
	$('#btnAdqServ3').click(function (e) {
        e.preventDefault();
        $('#modalAdquirirServicio').modal('show');
		$('#divModalAdquServicio').modal('show');
		$('#botonSiAdquiServicio1').hide();
		$('#botonSiAdquiServicio2').hide();
		$('#botonSiAdquiServicio3').show();
		$('#pAdquirirServicio').text("Esta seguro que quiere adquirir el servicio Premium Oro?");
    });
	
	$('#botonSiAdquiServicio1').click(function (e) {
		$('#spanActiCan1').show();
		$('#botonCanServ1').show();
		$('#spanInacCan1').hide();
		$('#btnAdqServ1').hide();
    });
	
	$('#botonSiAdquiServicio2').click(function (e) {
		$('#spanActiCan2').show();
		$('#botonCanServ2').show();
		$('#spanInacCan2').hide();
		$('#btnAdqServ2').hide();
    });
	
	$('#botonSiAdquiServicio3').click(function (e) {
		$('#spanActiCan3').show();
		$('#botonCanServ3').show();
		$('#spanInacCan3').hide();
		$('#btnAdqServ3').hide();
    });
	
});