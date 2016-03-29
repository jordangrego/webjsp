$(function() {
	$("#tblClassificacao").hide();
	
	$('#btnPesquisar').click(function() {
		$("#tblClassificacao").hide();
		pesquisarClassificacao();
	});
	
	$('#btnCadastrar').click(function() {
		$(window).attr('location', '/webjsp/classificacao/classificacaoFormulario.jsp')
	});
	
});
function pesquisarClassificacao() {
	removeRows();

	$.ajax({
				url : "/webjsp/ManterClassificacaoServlet",
				data : "nome_cliente=" + $('#ddlCliente').val() + "&codigo=" + $('#txtCodigo').val() + "&descricao=" + $('#txtDescricao').val(),
				dataType : "json",
				type : "GET",
				success : function(data) {
					console.log('teste');
					$.each(
									data,
									function(index, row) {
										var newRowContent = "<tr>";
										newRowContent += "<td>"	+ row.idClassificacao + "</td>";
										newRowContent += "<td>"	+ row.cliente + "</td>";
										newRowContent += "<td>" + row.codigo + "</td>";
										newRowContent += "<td>" + row.descricao + "</td>";
										newRowContent += "<td>" + row.prazo + "</td>";
										newRowContent += "<td class='tdCenter'><button type='button' class='btn btn-default btn-sm editar'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button></td>";
										newRowContent += "</tr>";

										$("#tblClassificacao tbody").append(
												newRowContent);
									});

					$("#tblClassificacao").trigger("update");
					controlaApresentacao();
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
			        console.log("Erro!" + XMLHttpRequest + " | " + textStatus + " | " + errorThrown);
			    }
			});

}

function controlaApresentacao() {
	console.log($("#tblClassificacao > tbody > tr").length);
	if ($("#tblClassificacao > tbody > tr").length > 0) {
		$("#divRetornoClassificacao").hide();
		$("#tblClassificacao").show();
	} else {
		$("#divRetornoClassificacao").show();
		$("#tblClassificacao").hide();
	}
}

function removeRows() {
	$("#tblClassificacao > tbody > tr").remove();
}