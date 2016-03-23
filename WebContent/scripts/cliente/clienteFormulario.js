$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location', '/webjsp/cliente/clientePesquisa.jsp')
	});

	$('#btnExcluir').click(
			function() {
				var url = window.location.href;
				var parametrosDaUrl = url.split("=")[1];
				var valor = "e";
				$(window).attr(
						'location',
						'clienteFormulario.jsp?hdnIdClienteExcluir='
								+ parametrosDaUrl + '&hdnAcao=' + valor);
				// location.reload();

				$('#hdnAcao').val(valor);
				$('#hdnIdClienteExcluir').val(parametrosDaUrl);
				// $('#frmUsuario').submit();

			});

	$('#btnSalvar').click(function() {
		validaForm();
	});

	$("#txtCNPJ")
			.blur(
					function() {
						var cnpj = $("#txtCNPJ").val();
						$("#divCNPJ").removeClass("has-error");
						$("#helpCnpj").remove();
						if (cnpj == null || cnpj == ""
								|| cnpj == "__.___.___/____-__") {
							$("#divCNPJ")
									.append(
											"<span id='helpCnpj' class='help-block'>Campo obrigatório</span>");

							adicionaClass($('#divCNPJ'), 'has-error');
						} else {
							
							if (validarCNPJ(cnpj) == true) {
								$("#divCNPJ").removeClass("has-error");
								$("#helpCnpj").remove();
							} else {
								$("#divCNPJ")
										.append(
												"<span id='helpCnpj' class='help-block'>CNPJ inválido</span>");

								adicionaClass($('#divCNPJ'), 'has-error');
							}
							
						}
					});

});

jQuery(document).ready(function($) {

	$("#txtCNPJ").mask("99.999.999/9999-99");

});

function validaForm() {
	$("#divRazaoSocial").removeClass("has-error");
	$("#divEmail").removeClass("has-error");
	$("#divCNPJ").removeClass("has-error");
	$("#divLogo").removeClass("has-error");
	$("#divFundo").removeClass("has-error");
	$("#divQntCaixaBoxLote").removeClass("has-error");
	$("#divCaixaTriplex").removeClass("has-error");
	$("#divMinAprov").removeClass("has-error");
	$("#divPrazoEntrega").removeClass("has-error");
	$("#divQtdPagTotaisContrato").removeClass("has-error");
	$("#divMetaDiaria").removeClass("has-error");
	$("#divBarCode").removeClass("has-error");

	$("span").remove();

	var sucesso = true;

	// Valida os obrigatorios
	// Valida se Razao Social foi preenchido
	var RazaoSocial = $("#txtRazaoSocial").val();
	if (RazaoSocial == "" || RazaoSocial == null) {
		$("#divRazaoSocial")
				.append(
						"<span id='helpNome' class='help-block'>Campo Obrigatório</span>");

		adicionaClass($('#divRazaoSocial'), 'has-error');

		sucesso = false;
	} else {

	}

	// Valida email preenchido e email correto
	var email = $("#txtEmailCliente").val();
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

	// valida CNPJ preenchido e correto
	var cnpj = $("#txtCNPJ").val();
	if (cnpj === "" || cnpj === null) {
		$("#divCNPJ")
				.append(
						"<span id='helpCnpj' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divCNPJ'), 'has-error');

		sucesso = false;

	} else {

	}

	// valida se Quantidade Caixa Box Lote foi preenchido
	var QtdCaixaBoxLote = $("#txtQtdCaixaBoxLote").val();
	if (QtdCaixaBoxLote == null || QtdCaixaBoxLote == "") {
		$("#divQntCaixaBoxLote")
				.append(
						"<span id='helpQtdCaixaBoxLote' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divQntCaixaBoxLote'), 'has-error');

		sucesso = false;

	} else {

	}

	// validação % Mínimo para Aprovação
	var MinAprov = $("#txtMinAprov").val();
	if (MinAprov == null || MinAprov == "") {
		$("#divMinAprov")
				.append(
						"<span id='helpMinAprov' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divMinAprov'), 'has-error');

		sucesso = false;

	} else {

	}

	// validação Prazo Entrega
	var PrazoEntrega = $("#txtPrazoEntrega").val();
	if (PrazoEntrega == null || PrazoEntrega == "") {
		$("#divPrazoEntrega")
				.append(
						"<span id='helpPrazoEntrega' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divPrazoEntrega'), 'has-error');

		sucesso = false;

	} else {

	}

	// validação Qtd. páginas totais do contrato
	var QtdPagTotaisContrato = $("#txtQtdPagTotaisContrato").val();
	if (QtdPagTotaisContrato == null || QtdPagTotaisContrato == "") {
		$("#divQtdPagTotaisContrato")
				.append(
						"<span id='helpQtdPagTotaisContrato' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divQtdPagTotaisContrato'), 'has-error');

		sucesso = false;

	} else {

	}

	// validação Meta Diária
	var MetaDiaria = $("#txtMetaDiaria").val();
	if (MetaDiaria == null || MetaDiaria == "") {
		$("#divMetaDiaria")
				.append(
						"<span id='helpMetaDiaria' class='help-block'>Campo obrigatório</span>");

		adicionaClass($('#divMetaDiaria'), 'has-error');

		sucesso = false;

	} else {

	}

	// validação BarCode
	var barCode = $("#txtBarcode").val();
	if (barCode === "0") {
		$("#divBarCode")
				.append(
						"<span id='helpBarCode' class='help-block'>Selecione uma opção</span>");

		adicionaClass($('#divBarCode'), 'has-error');

		sucesso = false;
	} else {

	}

	if (sucesso == true) {
		document.getElementById("formCliente").submit();
	} else {
	}

};

function validarCNPJ(cnpj) {

	cnpj = cnpj.replace(/[^\d]+/g, '');

	if (cnpj == '')
		return false;

	if (cnpj.length != 14)
		return false;

	// Elimina CNPJs invalidos conhecidos
	if (cnpj == "00000000000000" || cnpj == "11111111111111"
			|| cnpj == "22222222222222" || cnpj == "33333333333333"
			|| cnpj == "44444444444444" || cnpj == "55555555555555"
			|| cnpj == "66666666666666" || cnpj == "77777777777777"
			|| cnpj == "88888888888888" || cnpj == "99999999999999")
		return false;

	// Valida DVs
	tamanho = cnpj.length - 2
	numeros = cnpj.substring(0, tamanho);
	digitos = cnpj.substring(tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(0))
		return false;

	tamanho = tamanho + 1;
	numeros = cnpj.substring(0, tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(1))
		return false;

	return true;

}
