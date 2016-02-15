$(function() {

	$("#tblLotes").hide();

	$('#btnPesquisar').click(function() {
		$("#tblLotes").hide();
		pesquisarLotes();
	});
	
	$(function() {

		$('#btnCadastrar').click(function() {
			$(window).attr('location','/webjsp/lote/loteFormulario.jsp')
		});

	});

});

function pesquisarLotes() {
	removeRows();

	$.ajax({
				url : "/webjsp/PesquisarLotesServlet",
				data : "numero_lote=" + $('#txtNumeroLote').val(),
				dataType : "json",
				type : "GET",
				success : function(data) {

					$
							.each(
									data,
									function(index, row) {
										var newRowContent = "<tr>";
										newRowContent += "<td>" + row.idLote
												+ "</td>";
										newRowContent += "<td>"
												+ row.numerolote + "</td>";
										newRowContent += "<td>" + row.qtdCaixas
												+ "</td>";
										newRowContent += "<td>"
												+ row.dataRecebimento + "</td>";
										newRowContent += "<td>"
												+ row.observacao + "</td>";
										newRowContent += "<td class='tdCenter'><button type='button' class='btn btn-default btn-sm'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button></td>";
										newRowContent += "</tr>";

										$("#tblLotes tbody").append(
												newRowContent);
									});

					$("#tblLotes").trigger("update");
					controlaApresentacao();
				}
			});

}

function controlaApresentacao() {
	console.log($("#tblLotes > tbody > tr").length);
	if ($("#tblLotes > tbody > tr").length > 0) {
		$("#divRetornoLotes").hide();
		$("#tblLotes").show();
	} else {
		$("#divRetornoLotes").show();
		$("#tblLotes").hide();
	}
}

function removeRows() {
	$("#tblLotes > tbody > tr").remove();
}