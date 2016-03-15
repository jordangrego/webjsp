$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/usuario/usuarioPesquisa.jsp')
	});
	$('#btnExcluir').click(
			function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				var valor = "e";
				$(window).attr(
						'location',
						'/webjsp/usuario/usuarioFormulario.jsp?idUsuario='
								+ parametrosDaUrl);

				$('#hdnAcao').val(valor);
				$('#hdnIdUsuarioExcluir').val('parametrosDaUrl');
				//$('#frmUsuario').submit();
				//console.log("vai se foder");
			});

	$('#btnSalvar').click(function() {
		salvarLote();
	});

	/*
	 * if ($('#hdnIdUsuario').val() != "") { perfisMarcados(); }
	 */

	$('.ckPerfil').change(function() {
		perfisMarcados();
	});

});

function salvarLote() {
	/*
	 * if (!document.getElementById('perfis').checked) { $('#divCheck').html( "<a
	 * style='color:#a94442;'>Selecione ao menos um perfil</a>"); } else {
	 *  }
	 */
	perfisMarcados();
}

function perfisMarcados() {

	var qtdCheckBoxMarcado = 0;
	$("input:checked").each(function() {
		qtdCheckBoxMarcado++;
	});

	if (qtdCheckBoxMarcado == 0) {
		$('#divCheck').html(
				"<a style='color:#a94442;'>Selecione ao menos um perfil</a>");
	} else {
		$('#divCheck').html("");
	}

}