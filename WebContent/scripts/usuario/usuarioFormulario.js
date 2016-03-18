$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/usuario/usuarioPesquisa.jsp')
	});
	
	$('#btnExcluir').click(
			function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				var valor = "e";
				$(window).attr('location', 'usuarioFormulario.jsp?hdnIdUsuarioExcluir=' + parametrosDaUrl + '&hdnAcao=' + valor );
				//location.reload(); 

				$('#hdnAcao').val(valor);
				$('#hdnIdUsuarioExcluir').val(parametrosDaUrl);
				//$('#frmUsuario').submit();
			
			});

	$('#btnSalvar').click(function() {
		validarForm()
	});

	// valida se as senhas coincidem
	$(".senha")
			.blur(
					function() {
						var senha = $("#txtSenha").val();
						var senhaConfirmacao = $("#txtConfirmacaoSenha").val();

						if (senha == senhaConfirmacao) {
							$("#divSenha").removeClass("has-error");
							$("#divConfirmacaoSenha").removeClass("has-error");
							$("#helpSenha").remove();

						} else {
							$("#divSenha")
									.append(
											"<span name='helpSenha' id='helpSenha' class='help-block'>As senhas não coincidem</span>");

							adicionaClass($('#divSenha'), 'has-error');
						}

					});

});

function salvarLote() {
	/*
	 * if (!document.getElementById('perfis').checked) { $('#divCheck').html( "<a
	 * style='color:#a94442;'>Selecione ao menos um perfil</a>"); } else { }
	 */
	perfisMarcados();
}

// Validação de formulário
function validarForm() {
	$("#divNome").removeClass("has-error");
	$("#divEmail").removeClass("has-error");
	$("#divSenha").removeClass("has-error");
	$("#divConfirmacaoSenha").removeClass("has-error");
	$("#divLogin").removeClass("has-error");
	$("#divCliente").removeClass("has-error");

	$("span").remove();

	var sucesso = true;

	// valida se o login foi preenchido
	var login = $("#txtLogin").val();
	if (login == "" || login == null) {
		$("#divLogin")
				.append(
						"<span id='helpLogin' class='help-block'>Campo Obrigatório</span>");

		adicionaClass($('#divLogin'), 'has-error');

		sucesso = false;
	}

	// valida se o nome foi Preenchido
	var nome = $("#txtNomeUsuario").val();
	if (nome == "" || nome == null) {
		$("#divNome")
				.append(
						"<span id='helpNome' class='help-block'>Campo Obrigatório</span>");

		adicionaClass($('#divNome'), 'has-error');

		sucesso = false;
	} else {

	}

	// valida Email
	var email = $("#txtEmail").val();
	if (email === "" || email === null) {
		$("#divEmail")
				.append(
						"<span id='helpEmail1' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divEmail'), 'has-error');

		sucesso = false;

	} else {
		if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) == true) {

		} else {
			$("#divEmail")
					.append(
							"<span id='helpEmail2' class='help-block'>E-mail inválido</span>");

			adicionaClass($('#divEmail'), 'has-error');

			sucesso = false;
		}
	}

	// Valida se senha preenchida e se coincidem
	var senha = $("#txtSenha").val();
	var senhaConfirmacao = $("#txtConfirmacaoSenha").val();
	if (senha === "" || senha === null) {
		$("#divSenha")
				.append(
						"<span name='helpSenha' id='helpSenha' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divSenha'), 'has-error');

		sucesso = false;
	} else {
		if (senha == senhaConfirmacao) {

		} else {
			$("#divSenha")
					.append(
							"<span name='helpSenha' id='helpSenha' class='help-block'>As senhas não coincidem</span>");

			adicionaClass($('#divSenha'), 'has-error');

			sucesso = false;
		}
	}

	// valida a lista de cliente
	var ddlCliente = $("#ddlCliente").val();
	if (ddlCliente === "0") {
		$("#divCliente")
				.append(
						"<span id='helpCliente' class='help-block'>Selecione uma opção</span>");

		adicionaClass($('#divCliente'), 'has-error');

		sucesso = false;
	} else {

	}

	// valida checkbox
	var checkboxes = document.getElementsByName("perfis");
	var is_checked = false;
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			is_checked = true;
		}
	}

	if (is_checked) {
		// at least one is checked;
	} else {
		$("#divCheckbox")
				.append(
						"<span id='helpPerfis' class='help-block'>Selecione ao menos uma opção</span>");

		adicionaClass($('#divCheckbox'), 'has-error');

		sucesso = false;
	}

	/*
	 * if ($("#perfis").checked == false) { $("#divCheckbox") .append( "<span
	 * id='helpPerfis' class='help-block'>Selecione ao menos uma opção</span>");
	 * 
	 * adicionaClass($('#divCheckbox'), 'has-error');
	 * 
	 * sucesso = false; } else { }
	 */

	if (sucesso == true) {
		document.getElementById("formUsuario").submit();
	} else {

	}

	return sucesso;
}

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