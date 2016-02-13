$.ajaxSetup({
	beforeSend : function() {
		lockBack();
		$('#divLoading').fadeIn();
	},
	complete : function() {
		$('#divLoading').fadeOut();
		freeBack();
	},
	success : function() {
	}
});

function lockBack() {
    $('#fundoModal').fadeIn();
}

function freeBack() {
    $('#fundoModal').fadeOut();
}