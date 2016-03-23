$(function() {

	$("#tblClientes").hide();

	$('#btnPesquisar').click(function() {
		$("#tblClientes").hide();
		pesquisarClientes();
	});

	$('#btnCadastrar').click(function() {
		$(window).attr('location', '/webjsp/cliente/clienteFormulario.jsp')
	});

	$("#tblClientes").on(
			'click',
			'.editar',
			function() {
				// $(this) nesse contexto é o span do icone, devemos chegar até
				// o ID do usuário da linha onde o botao foi clicado.
				// parent() recupera a tag logo acima ... 2 parent pra chegar na
				// <TR> e depois recuperamos o primeiro td com .find('td:eq(0)')
				// e recuperamos o HTML de dentro dele.
				var idCliente = $(this).parent().parent().find('td:eq(0)')
						.html()
				$(window).attr(
						'location',
						'/webjsp/cliente/clienteFormulario.jsp?idCliente='
								+ idCliente);
			});

});

function pesquisarClientes() {
	removeRows();

	$
			.ajax({
				url : "/webjsp/ManterClientesServlet",
				data : "nome_cliente=" + $('#txtNomeCliente').val(),
				dataType : "json",
				type : "GET",
				success : function(data) {

					$
							.each(
									data,
									function(index, row) {
										var newRowContent = "<tr>";
										newRowContent += "<td>" + row.idCliente
												+ "</td>";
										newRowContent += "<td>"
												+ row.razaoSocial + "</td>";
										newRowContent += "<td>" + row.email
												+ "</td>";
										newRowContent += "<td class='tdCenter'><button type='button' class='btn btn-default btn-sm editar'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button></td>";
										newRowContent += "</tr>";

										$("#tblClientes tbody").append(
												newRowContent);
									});

					$("#tblClientes").trigger("update");
					controlaApresentacao();
				}
			});

}

function controlaApresentacao() {
	console.log($("#tblClientes > tbody > tr").length);
	if ($("#tblClientes > tbody > tr").length > 0) {
		$("#divRetornoClientes").hide();
		$("#tblClientes").show();
	} else {
		$("#divRetornoClientes").show();
		$("#tblClientes").hide();
	}
}

function removeRows() {
	$("#tblClientes > tbody > tr").remove();
}