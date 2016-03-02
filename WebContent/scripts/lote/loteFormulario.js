$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/lote/lotePesquisa.jsp')
	});

	$('#btnSalvar').click(function() {
		salvarLote();
	});
	$('#btnExcluir').click(function() {
		$('#hdnAcao').val('e');
		$('#frmLote').submit();
	});
	
});

function salvarLote() {
	/*
	 * $('#hdnAcao').val('e'); $('#frmLote').submit();
	 */
}