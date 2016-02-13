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

/*--------------*/
$(function() {

    $('.numero').keypress(function(event) {
        var tecla = (window.event) ? event.keyCode : event.which;
        if ((tecla > 47 && tecla < 58)) return true;
        else {
            if (tecla != 8) return false;
            else return true;
        }
    });

});