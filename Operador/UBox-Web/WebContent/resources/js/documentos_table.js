
$(document).ready(function(){
	cargaInicial();
	cargaInicial2();
	cargaInicial3();
	//evento que se dispara al hacer clic en el boton para agregar una nueva fila
	$(document).on('click','.clsAgregarFila',function(){
		//almacenamos en una variable todo el contenido de la nueva fila que deseamos
		//agregar. pueden incluirse id's, nombres y cualquier tag... sigue siendo html
		var strNueva_Fila='<tr>'+
			'<td>'+
			'      <i class="glyphicon glyphicon-file "></i> '+
			' Diploma DB2</td>'+
			'<td class="center">2015/07/23 18:25</td>'+
			'<td class="center"> </td>'+
			'<td class="center">'+
			'<span class="label-success label label-default">Activo</span>'+
			'</td>'+
			'<td class="center">'+
			'<a class="btn btn-success" target="_blank" href="docSample\\Diploma DB2.JPG">'+
			'<i class=" glyphicon glyphicon-download-alt icon-white"></i> '+
			' Ver'+
			'</a>'+
			
			'    </a>                                                                                 '+
			
			'<a onclick= abrirCompartir(event) class="btn btn-info">'+
			'        <i class="glyphicon glyphicon-user icon-white"></i>'+
			'        Compartir'+
			'    </a>'+
			'    <a onclick= abrirFirmar(event) class="btn btn-info">'+
			'        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
			'        Firmar'+
			'    </a>'+
		
			'        <a class="btn btn-danger clsEliminarFila" href="#">                                  '+
			'            <i class="glyphicon glyphicon-trash icon-white"></i>                             '+
			'            Borrar                                                                           '+
			'        </a>                                                                                 '+
			
			'        <a onclick= abrirMover(event) class="btn btn-info clsRecuperarTotal" href="#">                                  '+
			'            <i class="glyphicon glyphicon-share icon-white"></i>                          '+
			'            Mover                                                                           '+
			'        </a>                                                                                 '+
			 
			'</td>'
			
		'</tr>'
		;
				
		/*obtenemos el padre del boton presionado (en este caso queremos la tabla, por eso
		utilizamos get(3)
			table -> padre 3
				tfoot -> padre 2
					tr -> padre 1
						td -> padre 0
		nosotros queremos utilizar el padre 3 para agregarle en la etiqueta
		tbody una nueva fila*/
		var objTabla=$(this).parents().get(3);
				
		//agregamos la nueva fila a la tabla
		$(objTabla).find('tbody').append(strNueva_Fila);
				
		//si el cuerpo la tabla esta oculto (al agregar una nueva fila) lo mostramos
		if(!$(objTabla).find('tbody').is(':visible')){
			//le hacemos clic al titulo de la tabla, para mostrar el contenido
			$(objTabla).find('caption').click();
		}
	});
	
	$(document).on('click','.clsAgregarFilaCarpeta',function(){
		//almacenamos en una variable todo el contenido de la nueva fila que deseamos
		//agregar. pueden incluirse id's, nombres y cualquier tag... sigue siendo html
		var strNueva_Fila='<tr>'+
			'<td>'+
			'      <i class="glyphicon glyphicon-folder-open"></i>                                             '+
			' Otra Carpeta</td>'+
			'<td class="center">2015/07/23 18:25</td>'+
			'<td class="center"> </td>'+
			'<td class="center">'+
			'<span class="label-success label label-default">Activo</span>'+
			'</td>'+
			'<td class="center">'+
			'<a class="btn btn-success" target="_blank" href="docSample\\registroCivil.JPG">'+
			'<i class=" glyphicon glyphicon-download-alt icon-white"></i>'+
			' Ver'+
			'</a>'+
			 '        <a class="btn btn-danger clsEliminarFila" href="#">	 '+
			'            <i class="glyphicon glyphicon-trash icon-white"></i>'+
			' Borrar'+
			'</a>'+
			'</td>'
			
		'</tr>'
		;
				
		/*obtenemos el padre del boton presionado (en este caso queremos la tabla, por eso
		utilizamos get(3)
			table -> padre 3
				tfoot -> padre 2
					tr -> padre 1
						td -> padre 0
		nosotros queremos utilizar el padre 3 para agregarle en la etiqueta
		tbody una nueva fila*/
		var objTabla=$(this).parents().get(3);
				
		//agregamos la nueva fila a la tabla
		$(objTabla).find('tbody').append(strNueva_Fila);
				
		//si el cuerpo la tabla esta oculto (al agregar una nueva fila) lo mostramos
		if(!$(objTabla).find('tbody').is(':visible')){
			//le hacemos clic al titulo de la tabla, para mostrar el contenido
			$(objTabla).find('caption').click();
		}
	});
	
	//cuando se haga clic en cualquier clase .clsEliminarFila se dispara el evento
	$(document).on('click','.clsEliminarFila',function(){
		/*obtener el cuerpo de la tabla; contamos cuantas filas (tr) tiene
		si queda solamente una fila le preguntamos al usuario si desea eliminarla*/
		var objCuerpo=$(this).parents().get(2);
			//if($(objCuerpo).find('tr').length==1){
				if(!confirm('Desea eliminar el documento?')){
					return;
				}
			//}
					
		/*obtenemos el padre (tr) del td que contiene a nuestro boton de eliminar
		que quede claro: estamos obteniendo dos padres
					
		el asunto de los padres e hijos funciona exactamente como en la vida real
		es una jergarquia. imagine un arbol genealogico y tendra todo claro ;)
				
			tr	--> padre del td que contiene el boton
				td	--> hijo de tr y padre del boton
					boton --> hijo directo de td (y nieto de tr? si!)
		*/
		var objFila=$(this).parents().get(1);
			/*eliminamos el tr que contiene los datos del contacto (se elimina todo el
			contenido (en este caso los td, los text y logicamente, el boton */
			$(objFila).remove();
	});
	
	//cuando se haga clic en cualquier clase .clsEliminarFila se dispara el evento
	$(document).on('click','.clsEliminarFilaTotal',function(){
		/*obtener el cuerpo de la tabla; contamos cuantas filas (tr) tiene
		si queda solamente una fila le preguntamos al usuario si desea eliminarla*/
		var objCuerpo=$(this).parents().get(2);
			//if($(objCuerpo).find('tr').length==1){
				if(!confirm('Desea eliminar el documento permanentemente?')){
					return;
				}
			//}
					
		/*obtenemos el padre (tr) del td que contiene a nuestro boton de eliminar
		que quede claro: estamos obteniendo dos padres
					
		el asunto de los padres e hijos funciona exactamente como en la vida real
		es una jergarquia. imagine un arbol genealogico y tendra todo claro ;)
				
			tr	--> padre del td que contiene el boton
				td	--> hijo de tr y padre del boton
					boton --> hijo directo de td (y nieto de tr? si!)
		*/
		var objFila=$(this).parents().get(1);
			/*eliminamos el tr que contiene los datos del contacto (se elimina todo el
			contenido (en este caso los td, los text y logicamente, el boton */
			$(objFila).remove();
	});
	
	//cuando se haga clic en cualquier clase .clsEliminarFila se dispara el evento
	$(document).on('click','.clsRecuperarTotal',function(){
		/*obtener el cuerpo de la tabla; contamos cuantas filas (tr) tiene
		si queda solamente una fila le preguntamos al usuario si desea eliminarla*/
		var objCuerpo=$(this).parents().get(2);
					
		/*obtenemos el padre (tr) del td que contiene a nuestro boton de eliminar
		que quede claro: estamos obteniendo dos padres
					
		el asunto de los padres e hijos funciona exactamente como en la vida real
		es una jergarquia. imagine un arbol genealogico y tendra todo claro ;)
				
			tr	--> padre del td que contiene el boton
				td	--> hijo de tr y padre del boton
					boton --> hijo directo de td (y nieto de tr? si!)
		*/
		var objFila=$(this).parents().get(1);
			/*eliminamos el tr que contiene los datos del contacto (se elimina todo el
			contenido (en este caso los td, los text y logicamente, el boton */
			$(objFila).remove();
	});
	
});
	function cargaInicial() {
		
		$('#cargarTablaEstado').html(
		'<table id = "tablaejemplo" class="table table-striped table-bordered bootstrap-datatable datatable responsive">'+
    '<thead>'+
    '<tr>'+
        '<th>Archivo</th>'+
        '<th>Creaci\u00f3n</th>'+
        '<th>Modificaci\u00f3n</th>'+
        '<th>Estado</th>'+
        '<th>Acci\u00f3n</th>'+
    '</tr>'+
    '</thead>'+
    '<tbody>'+
    
    '<tr>'+
     '   <td>'+
	 '      <i class="glyphicon glyphicon-file"></i>                                             '+
	 ' Registro Civil</td>'+
      '  <td class="center">1986/01/05 12:01</td>'+
       ' <td class="center"> </td>'+
        '<td class="center">'+
         '   <span class="label-success label label-default">Activo</span>'+
        '</td>'+
        '<td class="center">'+
        '    <a class="btn btn-success" target="_blank" href="docSample\\registroCivil.JPG">'+
        '        <i class=" glyphicon glyphicon-download-alt icon-white"></i>'+
        '        Ver'+
        '    </a>'+
        '    <a onclick= abrirCompartir(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-user icon-white"></i>'+
        '        Compartir'+
        '    </a>'+
        '    <a onclick= abrirFirmar(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
        '        Firmar'+
        '    </a>'+
            
        '</td>'+
    '</tr>'+

    '<tr>'+
    '    <td>'+
	'      <i class="glyphicon glyphicon-file"></i>                                             '+
	' Declaraci\u00f3n Renta</td>'+
    '    <td class="center">2014/12/17 18:13</td>'+
    '    <td class="center">2015/08/25 07:06</td>'+
    '    <td class="center">'+
    '        <span class="label-warning label label-default">Pendiente</span>'+
    '    </td>'+
    '    <td class="center">'+
    '        <a class="btn btn-success" target="_blank" href="#">'+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>'+
    '            Ver'+
    '        </a>'+
    '        <a onclick= abrirCompartir(event) class="btn btn-info abrirCompartir">'+
    '            <i class="glyphicon glyphicon-user icon-white"></i>'+
    '            Compartir'+
    '        </a>'+
    '        <a  onclick= abrirFirmar(event) class="btn btn-info" >'+
    '            <i class="glyphicon glyphicon-barcode icon-white"></i>'+
    '            Firmar'+
    '        </a>'+
            
    '    </td>'+
    '</tr>'+
    
    '<tr>'+
    '    <td>'+
	'      <i class="glyphicon glyphicon-file"></i>                                             '+
	' RUT</td>'+
    '    <td class="center">2013/01/05 12:01</td>'+
    '    <td class="center">2014/02/01 09:01</td>'+
    '    <td class="center">'+
    '        <span class="label-default label">Inactivo</span>'+
    '    </td>'+
    '    <td class="center">'+
    '        <a class="btn btn-success" target="_blank" href="#">'+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>'+
    '            Ver'+
    '        </a>'+
    '        <a onclick= abrirCompartir(event) class="btn btn-info abrirCompartir">'+
    '            <i class="glyphicon glyphicon-user icon-white"></i>'+
    '            Compartir'+
    '        </a>'+
    '        <a onclick= abrirFirmar(event) class="btn btn-info" >'+
    '            <i class="glyphicon glyphicon-barcode icon-white"></i>'+
    '            Firmar'+
    '        </a>'+
            
    '    </td>'+
    '</tr>'+
    
    '<tr>'+
    '    <td>'+
	'      <i class="glyphicon glyphicon-file"></i>                                             '+
	' Pasado Judicial</td>'+
    '    <td class="center">1986/01/05 12:01</td>'+
    '    <td class="center"></td>'+
    '    <td class="center">'+
    '        <span class="label-default label label-danger">Prohibido</span>'+
    '    </td>'+
    '    <td class="center">'+
    '        <a class="btn btn-success" target="_blank" href="http://antecedentes.policia.gov.co:7003/WebJudicial/formAntecedentes.xhtml">'+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>'+
    '            Ver'+
    '        </a>'+
    '        <a onclick= abrirCompartir(event) class="btn btn-info abrirCompartir">'+
    '            <i class="glyphicon glyphicon-user icon-white"></i>'+
    '            Compartir'+
    '        </a>'+
    '        <a onclick= abrirFirmar(event) class="btn btn-info abrirFirmar">'+
    '            <i class="glyphicon glyphicon-barcode icon-white"></i>'+
    '            Firmar'+
    '        </a>'+
            
     '   </td>'+
    '</tr>'+
    
    '</tbody>'+
	
	
	
    '</table>'
    );
		
		$('#tablaejemplo').dataTable({
        "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_ records per page"
        }
		});
	}
	
	function cargaInicial2() {
		
		$('#cargarTablaPersonales').html(
		'<table id = "tablaPersonales" class="table table-striped table-bordered bootstrap-datatable datatable responsive">'+
    '<thead>'+
    '<tr>'+
        '<th>Archivo</th>'+
        '<th>Creaci\u00f3n</th>'+
        '<th>Modificaci\u00f3n</th>'+
        '<th>Estado</th>'+
        '<th>Acci\u00f3n</th>'+
    '</tr>'+
    '</thead>'+
    
	//aca el tbody
	
	'<tbody>                                                                                      '+
    '<tr>                                                                                         '+
     '   <td>                                                                                     '+
      '      <i class="glyphicon glyphicon-file"></i>                                             '+
       '     BPM Process Designer.pdf</td>                                                        '+
        '<td class="center">2013/06/05 22:08</td>                                                 '+
        '<td class="center"> </td>                                                                '+
        '<td class="center">                                                                      '+
        '    <span class="label-success label label-default">Activo</span>                        '+
        '</td>                                                                                    '+
        '<td class="center">                                                                      '+
        '    <a class="btn btn-success" target="_blank" href="docSample\\processDesigner.JPG">     '+
        '        <i class=" glyphicon glyphicon-download-alt icon-white"></i>                     '+
        '        Ver                                                                              '+
        '    </a>                                                                                 '+
		
		'<a onclick= abrirCompartir(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-user icon-white"></i>'+
        '        Compartir'+
        '    </a>'+
        '    <a onclick= abrirFirmar(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
        '        Firmar'+
        '    </a>'+
	
    '        <a class="btn btn-danger clsEliminarFila" href="#">                                                  '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                             '+
    '            Borrar                                                                           '+
    '        </a>                                                                                 '+
    '    </td>                                                                                    '+
    '</tr>                                                                                        '+
    '                                                                                             '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        Foto de la abuela.jpg</td>                                                           '+
    '    <td class="center">2014/12/17 18:13</td>                                                 '+
    '    <td class="center">2015/08/25 07:06</td>                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-warning label label-default">Pendiente</span>                     '+
    '    </td>                                                                                    '+
    '    <td class="center">                                                                      '+
    '        <a class="btn btn-success" target="_blank" href="docSample\abuela.jpg">              '+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>                     '+
    '            Ver                                                                              '+
    '        </a>                                                                                 '+
    
	'<a onclick= abrirCompartir(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-user icon-white"></i>'+
        '        Compartir'+
        '    </a>'+
        '    <a onclick= abrirFirmar(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
        '        Firmar'+
        '    </a>'+
	
    '        <a class="btn btn-danger clsEliminarFila" href="#">                                                  '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                             '+
    '            Borrar                                                                           '+
    '        </a>                                                                                 '+
    '    </td>                                                                                    '+
    '</tr>                                                                                        '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        SAD ARQSW UniAndes.doc</td>                                                          '+
    '    <td class="center">2013/01/05 12:01</td>                                                 '+
    '    <td class="center">2014/02/01 09:01</td>                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-default label">Inactivo</span>                                    '+
    '    </td>                                                                                    '+
    '    <td class="center">                                                                      '+
    '        <a class="btn btn-success" target="_blank" href="docSample\SAD_EXP2.doc">            '+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>                     '+
    '            Ver                                                                              '+
    '        </a>                                                                                 '+
   
   '<a onclick= abrirCompartir(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-user icon-white"></i>'+
        '        Compartir'+
        '    </a>'+
        '    <a onclick= abrirFirmar(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
        '        Firmar'+
        '    </a>'+
   
    '        <a class="btn btn-danger clsEliminarFila" href="#">                                                  '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                             '+
    '            Borrar                                                                           '+
    '        </a>                                                                                 '+
    '    </td>                                                                                    '+
    '</tr>                                                                                        '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        Proyecto 1 MinTIC.pdf</td>                                                           '+
    '    <td class="center">1986/01/05 12:01</td>                                                 '+
    '    <td class="center"></td>                                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-default label label-danger">Prohibido</span>                      '+
    '    </td>                                                                                    '+
    '    <td class="center">                                                                      '+
    '        <a class="btn btn-success" target="_blank" href="docSample\ProyectoECOS.pdf">        '+
    '            <i class=" glyphicon glyphicon-download-alt icon-white"></i>                     '+
    '            Ver                                                                              '+
    '        </a>                                                                                 '+
    
	'<a onclick= abrirCompartir(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-user icon-white"></i>'+
        '        Compartir'+
        '    </a>'+
        '    <a onclick= abrirFirmar(event) class="btn btn-info">'+
        '        <i class="glyphicon glyphicon-barcode icon-white"></i>'+
        '        Firmar'+
        '    </a>'+
	
    '        </a>                                                                                 '+
    '        <a class="btn btn-danger clsEliminarFila" href="#">                                                  '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                             '+
    '            Borrar                                                                           '+
    '        </a>                                                                                '+
    '    </td>                                                                                   '+
    '</tr>                                                                                       '+
    '</tbody>'+
	
	
	//finaliza tbody
	
	
	'<tfoot>'+
	'				<tr>'+
	'					<td colspan="4" align="right">'+
	'						<input value="Cargar Documento" class=" btn btn-success clsAgregarFila">'+
	'						<input value="Crear Carpeta" class=" btn btn-success clsAgregarFilaCarpeta">'+
	//'						<input type="button" value="Clonar la tabla" class="clsClonarTabla">'+
	//'						<input type="button" value="Eliminar la tabla" class="clsEliminarTabla">'+
	'					</td>'+
	'				</tr>'+
	'			</tfoot>'+
    '</table>'
    );
		
		$('#tablaPersonales').dataTable({
        "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_ records per page"
        }
		});
	}
	//Papelera
	function cargaInicial3() {
		
		$('#cargarTablaPapelera').html(
		'<table id = "tablaPapelera" class="table table-striped table-bordered bootstrap-datatable datatable responsive">'+
    '<thead>'+
    '<tr>'+
        '<th>Archivo</th>'+
        '<th>Creaci\u00f3n</th>'+
        '<th>Modificaci\u00f3n</th>'+
        '<th>Estado</th>'+
        '<th>Acci\u00f3n</th>'+
    '</tr>'+
    '</thead>'+
    
	//aca el tbody
	
	'<tbody>                                                                                      '+
    '<tr>                                                                                         '+
     '   <td>                                                                                     '+
      '      <i class="glyphicon glyphicon-file"></i>                                             '+
       '     Notas2008.pdf</td>                                                        '+
        '<td class="center">2013/06/05 22:08</td>                                                 '+
        '<td class="center"> </td>                                                                '+
        '<td class="center">                                                                      '+
        '    <span class="label-success label label-default">Activo</span>                        '+
        '</td>                                                                                    '+
        
	'	<td class="center">                                                                        '+
    '        <a class="btn btn-success clsRecuperarTotal" href="#">          '+
    '            <i class=" glyphicon glyphicon-magnet icon-white"></i>                            '+
    ' Recuperar                                                                                    '+
    '        </a>                                                                                  '+
    '        <a class="btn btn-danger clsEliminarFilaTotal" href="#">                              '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                              '+
    '            Eliminar                                                                          '+
    '        </a>                                                                                  '+
    '    </td>                                                                                     '+
	
		
    '    </td>                                                                                    '+
    '</tr>                                                                                        '+
    '                                                                                             '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        Foto Juego.jpg</td>                                                           '+
    '    <td class="center">2014/12/17 18:13</td>                                                 '+
    '    <td class="center">2015/08/25 07:06</td>                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-warning label label-default">Pendiente</span>                     '+
    '    </td>                                                                                    '+
    
	'	<td class="center">                                                                        '+
    '        <a class="btn btn-success clsRecuperarTotal" href="#">          '+
    '            <i class=" glyphicon glyphicon-magnet icon-white"></i>                            '+
    ' Recuperar                                                                                    '+
    '        </a>                                                                                  '+
    '        <a class="btn btn-danger clsEliminarFilaTotal" href="#">                              '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                              '+
    '            Eliminar                                                                          '+
    '        </a>                                                                                  '+
    '    </td>                                                                                     '+
	
    '    </td>                                                                                    '+
    '</tr>                                                                                        '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        basura.doc</td>                                                          '+
    '    <td class="center">2013/01/05 12:01</td>                                                 '+
    '    <td class="center">2014/02/01 09:01</td>                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-default label">Inactivo</span>                                    '+
    '    </td>                                                                                    '+
    
	'	<td class="center">                                                                        '+
    '        <a class="btn btn-success clsRecuperarTotal" href="#">          '+
    '            <i class=" glyphicon glyphicon-magnet icon-white"></i>                            '+
    ' Recuperar                                                                                    '+
    '        </a>                                                                                  '+
    '        <a class="btn btn-danger clsEliminarFilaTotal" href="#">                              '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                              '+
    '            Eliminar                                                                          '+
    '        </a>                                                                                  '+
    '    </td>                                                                                     '+
	
    '</tr>                                                                                        '+
    '                                                                                             '+
    '<tr>                                                                                         '+
    '    <td>                                                                                     '+
    '        <i class="glyphicon glyphicon-file"></i>                                             '+
    '        notebook.pdf</td>                                                           '+
    '    <td class="center">1986/01/05 12:01</td>                                                 '+
    '    <td class="center"></td>                                                                 '+
    '    <td class="center">                                                                      '+
    '        <span class="label-default label label-danger">Prohibido</span>                      '+
    
	'	<td class="center">                                                                        '+
    '        <a class="btn btn-success clsRecuperarTotal" href="#">          '+
    '            <i class=" glyphicon glyphicon-magnet icon-white"></i>                            '+
    ' Recuperar                                                                                    '+
    '        </a>                                                                                  '+
    '        <a class="btn btn-danger clsEliminarFilaTotal" href="#">                              '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                              '+
    '            Eliminar                                                                          '+
    '        </a>                                                                                  '+
    '    </td>                                                                                     '+
	
    '</tr>                                                                                         '+
	'<tr>'+
			'<td>'+
			'      <i class="glyphicon glyphicon-folder-open"></i>                                 '+
			' Otra Carpeta</td>'+
			'<td class="center">2015/07/23 18:25</td>'+
			'<td class="center"> </td>'+
			'<td class="center">'+
			'<span class="label-success label label-default">Activo</span>'+
			'</td>'+
			
			'	<td class="center">                                                                '+
    '        <a class="btn btn-success clsRecuperarTotal" href="#">          '+
    '            <i class=" glyphicon glyphicon-magnet icon-white"></i>                            '+
    ' Recuperar                                                                                    '+
    '        </a>                                                                                  '+
    '        <a class="btn btn-danger clsEliminarFilaTotal" href="#">                              '+
    '            <i class="glyphicon glyphicon-trash icon-white"></i>                              '+
    '            Eliminar                                                                          '+
    '        </a>                                                                                  '+
    '    </td>                                                                                     '+
			
			
		'</tr>'+
    '</tbody>'+
	
    '</table>'
    );
		
		$('#tablaPapelera').dataTable({
        "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_ records per page"
        }
		});
	}

    
    