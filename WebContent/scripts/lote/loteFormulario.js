$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/lote/lotePesquisa.jsp')
	});

	$('#btnSalvar').click(function() {
		salvarLote();
	});
	$('#btnExcluir').click(
			function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				$(window).attr(
						'location',
						'/webjsp/lote/loteFormulario.jsp?idLote='
								+ parametrosDaUrl);

				$('#hdnAcao').val('e');
				$('#hdnIdLoteExcluir').val('parametrosDaUrl');
				$('#frmLote').submit();
			});

});

function salvarLote() {
	/*
	 * $('#hdnAcao').val('e'); $('#frmLote').submit();
	 */
}