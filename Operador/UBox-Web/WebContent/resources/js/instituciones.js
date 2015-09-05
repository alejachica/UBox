$(document).ready(function(){
	$('#aBuscarUsuario').click(function (e) {
        e.preventDefault();
        $('#modalBuscarUsuario').modal('show');
    });
});

function elimUsuario(e){
	e.preventDefault();
    $('#modalElimUsuario').modal('show');
	$('.mypropover').popover('hide');
}