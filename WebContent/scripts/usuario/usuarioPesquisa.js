$(function() {

	$("#tblUsuario").hide();

	$('#btnPesquisar').click(function() {
		$("#tblUsuario").hide();
		pesquisarClientes();
	});
	
	$('#btnCadastrar').click(function() {
		$(window).attr('location','/webjsp/usuario/usuarioFormulario.jsp');
	});
	
	// Elementos criado por meio de AJAX devem utilizar essa forma abaixo pra diparar ações no jquery
	// Amarra o evento na TABELA e o click na classe css
	$("#tblUsuario").on('click','.editar',function() {
		// $(this) nesse contexto é o span do icone, devemos chegar até o ID do usuário da linha onde o botao foi clicado. 
		// parent() recupera a tag logo acima ... 2 parent pra chegar na <TR> e depois recuperamos o primeiro td com .find('td:eq(0)') e recuperamos o HTML de dentro dele.
		var idUsuario = $(this).parent().parent().find('td:eq(0)').html()
		$(window).attr('location','/webjsp/usuario/usuarioFormulario.jsp?idUsuario=' + idUsuario);
	});
});

function pesquisarClientes() {
	removeRows();

	$.ajax({
				url : "/webjsp/ManterUsuarioServlet",
				data : "nome_usuario=" + $('#txtNomeUsuario').val() + "&login=" + $('#txtLogin').val(),
				dataType : "json",
				type : "GET",
				success : function(data) {

					$
							.each(
									data,
									function(index, row) {
										var newRowContent = "<tr>";
										newRowContent += "<td>" + row.idUsuario + "</td>";
										newRowContent += "<td>" + row.login + "</td>";
										newRowContent += "<td>" + row.nome + "</td>";
										newRowContent += "<td>" + row.email + "</td>";
										newRowContent += "<td class='tdCenter'><button type='button' class='btn btn-default btn-sm editar'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button></td>";
										newRowContent += "</tr>";

										$("#tblUsuario tbody").append(newRowContent);
									});

					$("#tblUsuario").trigger("update");
					controlaApresentacao();
				}
			});

}

function controlaApresentacao() {
	console.log($("#tblUsuario > tbody > tr").length);
	if ($("#tblUsuario > tbody > tr").length > 0) {
		$("#divRetornoClientes").hide();
		$("#tblUsuario").show();
	} else {
		$("#divRetornoClientes").show();
		$("#tblUsuario").hide();
	}
}

function removeRows() {
	$("#tblUsuario > tbody > tr").remove();
}