$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/lote/lotePesquisa.jsp')
	});

	$('#btnSalvar').click(function() {
		salvarLote();
	});

});

function salvarLote() {
	/*
	$('#hdnAcao').val('e');
	$('#frmLote').submit();
	*/
}