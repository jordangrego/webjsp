$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/cliente/clientePesquisa.jsp')
	});
	
	$('#btnExcluir').click(
			function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				var valor = "e";
				$(window).attr('location', 'usuarioCliente.jsp?hdnIdClienteExcluir=' + parametrosDaUrl + '&hdnAcao=' + valor );
				//location.reload(); 

				$('#hdnAcao').val(valor);
				$('#hdnIdClienteExcluir').val(parametrosDaUrl);
				//$('#frmUsuario').submit();
			
			});

	/*$('#btnSalvar').click(function() {
		validarForm()
	});*/

});
