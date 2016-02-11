$(document).ready(function() {
	$("#myTable").tablesorter();  
	
	$('#ddlEstado').on('change', function() {
		limpaCidades();
		var uf = $('#ddlEstado option:selected').val();
		listaCidades(uf);
	});
});

function listaCidades(estado) {
	$.ajax({
		url : "/webjsp/ListaCidadesServlet",
		data : "uf=" + estado,
		dataType : "json",
		type : "GET",
		success : function(data) {
			
			$.each(data, function(index, row) {
				adicionaCidade(row.nome, row.id);
			});
			
		}
	});
}

function adicionaCidade(nome, id) {
	$('#ddlCidade').append($('<option>', {
		value : id,
		text : nome
	}));
}

function limpaCidades() {
	$('#ddlCidade').find('option').remove().end();
}