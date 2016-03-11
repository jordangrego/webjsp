$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/usuario/usuarioPesquisa.jsp')
	});
	$('#btnExcluir').click(function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				$(window).attr(
						'location',
						'/webjsp/usuario/usuarioFormulario.jsp?idUsuario='
								+ parametrosDaUrl);

				$('#hdnAcao').val('e');
				$('#hdnIdUsuarioExcluir').val(parametrosDaUrl);
				$('#frmUsuario').submit();
			});

	/*
	 * $('#btnSalvar').click(function() { salvarLote(); });
	 */

});

function salvarLote() {

}