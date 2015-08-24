function abrirFirmar(e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Firmar Documento");
		tabla =
		"<p>Desea Firmar el Documento?</p>";
		$("#divInfo").html(tabla);
		
		footer = "<a href="+"#"+"class="+"btn btn-default"+" data-dismiss="+"modal"+">Cerrar</a>"+
        "<a href="+"#"+" class="+"btn btn-primary"+" data-dismiss="+"modal"+">Firmar</a>";
		$("#footerfirmar").html(footer);
    }

function changeColor(x)
{
    if(x.style.background=="rgb(247, 211, 88)")
    {
        x.style.background="#fff";
    }else{
        x.style.background="#F7D358";
    }
    return false;
}

function abrirMover(e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Mover a");
		tabla =
		'<table>'+
		'<tr><td>    </td></tr>'+
		
        '<tr><td>'+
        '        <a onclick = changeColor() class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Trabajo                                                                  '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
		'<tr><td>'+
        '        <a class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 1                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
        '<tr><td>'+
        '        <a class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 2                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
        '<tr><td>'+
        '        <a class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 3                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
        '<tr><td>'+
        '        <a class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 4                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
        '<tr><td>'+
        '        <a class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 5                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
        '<tr><td>'+
        '        <a onclick="setColor('+'button'+','+ '#101010'+')" class="button" href="#">                                                  '+
        '            <i class="glyphicon glyphicon-folder-open icon-white"></i>               '+
        '            Carpeta 6                                                                '+
        '        </a>                                                                         '+
        '</td></tr>'+
        
		"</table>";
		$("#divInfo").html(tabla);
		
		footer = "<a href="+"#"+"class="+"btn btn-default"+" data-dismiss="+"modal"+">Cerrar</a>"+
        "<a href="+"#"+" class="+"btn btn-primary"+" data-dismiss="+"modal"+">Mover</a>";
		$("#footerfirmar").html(footer);
    }
	
function abrirCompartir(e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Compartir Documento");
		tabla =
		"<p>Ingrese el usuario al cual desea compartir el documento...</p>"+
        "<input type="+"text"+" id="+"return_value"+" placeholder="+"e-Mail"+">";
		
		$("#divInfo").html(tabla);
		
		footer = "<a href="+"#"+"class="+"btn btn-default"+" data-dismiss="+"modal"+">Cerrar</a>"+
        "<a href="+"#"+" class="+"btn btn-primary"+" data-dismiss="+"modal"+">Compartir</a>";
		$("#footerfirmar").html(footer);
    }

 function addRow(tableID) {
               var table = document.getElementById(tableID);
               var rowCount = table.rows.length;
               var row = table.insertRow(rowCount);
               var cell1 = row.insertCell(0);
               var element1 = document.createElement("input");
               element1.type = "checkbox";
               cell1.appendChild(element1);
               var cell2 = row.insertCell(1);
               var element2 = document.createElement("input");
               element2.type = "text";
               cell2.appendChild(element2);
}


$(document).ready(function(){
	
	
	
	$('.abrirDes2').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Descripción");
		tabla = "<table>"+
		"<tr><td>$18.000</td></tr>"+
		"<tr><td>20 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronización con PC</td></tr>"+
		"<tr><td>2 Trámites con notarias</td></tr>"+
		"<tr><td>Prioridad en trámites</td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
	
	$('.abrirDes3').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Descripción");
		tabla = "<table>"+
		"<tr><td>$50.000</td></tr>"+
		"<tr><td>80 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronización con PC</td></tr>"+
		"<tr><td>3 trámites con notarias</td></tr>"+
		"<tr><td>Prioridad en trámites</td></tr>"+
		"</table>";
		$("#divInfo").html(tabla);
    });
	
	$('.abrirDes4').click(function (e) {
        e.preventDefault();
        $('#modalServicio').modal('show');
		$("#h3Info").text("Descripción");
		tabla = "<table>"+
		"<tr><td>$120.000</td></tr>"+
		"<tr><td>500 GB</td></tr>"+
		"<tr><td>Cargar documentos</td></tr>"+
		"<tr><td>Compartir documentos</td></tr>"+
		"<tr><td>Realizar pagos</td></tr>"+
		"<tr><td>Notificaciones</td></tr>"+
		"<tr><td>Sincronización con PC</td></tr>"+
		"<tr><td>10 trámites con notarias</td></tr>"+
		"<tr><td>Prioridad en trámites</td></tr>"+
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