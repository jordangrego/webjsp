$(function() {
	$("#btnCancelar").click(function(){
		$(window).attr('location', '/webjsp/classificacao/classificacaoPesquisa.jsp');	
	});
	$("#btnSalvar").click(function(){
		document.getElementById("formClassificacao").submit();
	});	
	
})