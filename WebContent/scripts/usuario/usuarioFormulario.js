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
				// $('#frmUsuario').submit();
				// console.log("vai se foder");
			});

	$('#btnSalvar').click(function() {
		validarForm()
	});

	/*
	 * if ($('#hdnIdUsuario').val() != "") { perfisMarcados(); }
	 */

});

function salvarLote() {
	/*
	 * if (!document.getElementById('perfis').checked) { $('#divCheck').html( "<a
	 * style='color:#a94442;'>Selecione ao menos um perfil</a>"); } else { }
	 */
	perfisMarcados();
}

function validarForm() {
	$("#divNome").removeClass("has-error");
	$("#divEmail").removeClass("has-error");
	$("#divSenha").removeClass("has-error");
	$("#divLogin").removeClass("has-error");

	$("span").remove();

	var sucesso = true;

	// valida se o login foi preenchido
	var login = $("#txtLogin").val();
	if (login == "" || login == null) {
		$("#divLogin")
				.append(
						"<span id='helpBlock1' class='help-block'>Campo Obrigatório</span>");

		adicionaClass($('#divLogin'), 'has-error');

		sucesso = false;
	}

	// valida se o nome foi Preenchido
	var nome = $("#txtNomeUsuario").val();
	if (nome == "" || nome == null) {
		$("#divNome")
				.append(
						"<span id='helpBlock1' class='help-block'>Campo Obrigatório</span>");

		adicionaClass($('#divNome'), 'has-error');

		sucesso = false;
	} else {

	}

	// valida Email
	var email = $("#txtEmail").val();
	if (email === "" || email === null) {
		$("#divEmail")
				.append(
						"<span id='helpBlock2' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divEmail'), 'has-error');

		sucesso = false;

	} else {
		if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) == true) {

		} else {
			$("#divEmail")
					.append(
							"<span id='helpBlock2' class='help-block'>E-mail inválido</span>");

			adicionaClass($('#divEmail'), 'has-error');

			sucesso = false;
		}
	}

	// Valida se senha preenchida e se coincidem
	var senha = $("#txtSenha").val();
	var senhaConfirmacao = $("#txtConfirmacaoSenha").val();
	if (senha == senhaConfirmacao && senha != "" && senha != null) {

	} else {
		$("#divSenha")
				.append(
						"<span id='helpBlock3' class='help-block'>As senhas não coincidem</span>");

		adicionaClass($('#divSenha'), 'has-error');

		sucesso = false;
	}

	// valida a lista de cliente
	var ddlCliente = $("#ddlCliente").val();
	if (ddlCliente === "0") {
		$("#divCliente")
				.append(
						"<span id='helpBlock3' class='help-block'>Selecione ao menos uma opção</span>");

		adicionaClass($('#divCliente'), 'has-error');

		sucesso = false;
	} else {

	}

	// valida checkbox
	if (!document.getElementById('perfis').checked) {
		$("#divCheckbox")
				.append(
						"<span id='helpBlock3' class='help-block'>Selecione ao menos uma opção</span>");

		adicionaClass($('#divCheckbox'), 'has-error');

		sucesso = false;
	} else {

	}

	if (sucesso == true) {
		document.getElementById("validaForm").submit();
	} else {

	}

	return sucesso;
};

function adicionaClass(campo, novoClass) {
	var classAtual = campo.prop('class');
	classAtual = classAtual + ' ' + novoClass;
	campo.prop('class', classAtual);
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