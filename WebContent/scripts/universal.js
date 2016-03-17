function validarForm() {
	 $("#divNome").removeClass("has-error");
	 $("#divEmail").removeClass("has-error");
	 $("#divSenha").removeClass("has-error");
	 
	 $("span").remove();
	
	var sucesso = true;

	// valida se o nome foi Preenchido
	var nome = $("#nome").val();
	if (nome == "" || nome == null) {
		$("#divNome")
				.append(
						"<span id='helpBlock1' class='help-block'>Campo Obrigat�rio</span>");

		adicionaClass($('#divNome'), 'has-error');

		sucesso = false;
	} else {

	}

	// valida Email
	var email = $("#email").val();
	if ((/(.+)@(.+){2,}\.(.+){2,}/.test(email)) || email == "" || email == null) {

	} else {
		$("#divEmail")
				.append(
						"<span id='helpBlock2' class='help-block'>Email inv�lido</span>");

		adicionaClass($('#divEmail'), 'has-error');

		sucesso = false;
	}

	// Valida se senha preenchida e se coincidem
	var senha = $("#senha").val();
	var senhaConfirmacao = $("#confirmarSenha").val();
	if (senha == senhaConfirmacao && senha != "" && senha != null) {
		
	} else {
		alert("vai se foder");
		$("#divSenha")
				.append(
						"<span id='helpBlock3' class='help-block'>As senhas n�o coincidem</span>");

		adicionaClass($('#divSenha'), 'has-error');

		sucesso = false;
	}

	// valida checkbox
	if (!document.getElementById('perfis').checked) {
		$("#divCheckbox")
				.append(
						"<span id='helpBlock4' class='help-block'>� necess�rio informar ao menos uma op��o</span>");

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