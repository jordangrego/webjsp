$(function() {

	$('#btnCancelar').click(function() {
		$(window).attr('location','/webjsp/usuario/usuarioPesquisa.jsp')
	});
	
	$('#btnSalvar').click(function() {
		salvarLote();
	});

});

function salvarLote() {
	
}