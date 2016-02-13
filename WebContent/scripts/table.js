$(function() {

	$("#tblEstudante").hide();

	$('#btnPesquisar').click(function() {
		pesquisarLotes();
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

										$("#tblEstudante tbody").append(
												newRowContent);
									});

					$("#tblEstudante").trigger("update");
					controlaApresentacao();
				}
			});

}

function controlaApresentacao() {
	console.log($("#tblEstudante > tbody > tr").length);
	if ($("#tblEstudante > tbody > tr").length > 0) {
		$("#divRetornoLotes").hide();
		$("#tblEstudante").show();
	} else {
		$("#divRetornoLotes").show();
		$("#tblEstudante").hide();
	}
}

function removeRows() {
	$("#tblEstudante > tbody > tr").remove();
}