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

	$('.numero').keypress(
			function(event) {
				var tecla = (window.event) ? event.keyCode : event.which;
				if ((tecla > 47 && tecla < 58) || (tecla == 46)
						|| (tecla > 36 && tecla < 41))
					return true;
				else {
					if (tecla != 8)
						return false;
					else
						return true;
				}
			});

	// validação de campo obrigatório
	$(".obrigatorio")
			.blur(
					function() {
						var valor = $(this).val();
						$(this).next().remove();
						if (valor === null || valor === "") {

							if ($(this).next().html === "Campo obrigatório") {

							} else {
								$(this)
										.after(
												"<span class='help-block'>Campo obrigatório</span>");

								adicionaClass($(this).parent(), 'has-error');
							}

						} else {
							$(this).next().remove();
							$(this).parent().removeClass("has-error");

						}

					});
	// validação email
	$(".email")
			.blur(
					function() {
						var email = $(this).val();
						var re = /\S+@\S+\.\S+/;
						$(this).next().remove();
						if (re.test(email) === false && email !== ""
								&& email !== null) {

							if ($(this).next().html === "E-mail inválido") {

							} else {
								$(this)
										.after(
												"<span class='help-block'>E-mail inválido</span>");

								adicionaClass($(this).parent().parent(),
										'has-error');
							}

						} else {
							$(this).next().remove();
							$(this).parent().removeClass("has-error");

						}

					});

	// validação checkbox
	$(".lista")
			.blur(
					function() {
						var ddlCliente = $(this).val();
						$(this).next().remove();
						if (ddlCliente === "0") {
							$(this)
									.after(
											"<span class='help-block'>Selecione uma opção</span>");

							adicionaClass($(this).parent(), 'has-error');
						} else {
							$(this).next().next().remove();
							$(this).next().remove();
							$(this).parent().removeClass("has-error");
						}
					});

	executaGrid();

});

function executaGrid() {
	$('.grid').each(function(i, obj) {
		$(this).tablesorter({
			theme : "bootstrap",
			widthFixed : true,
			headerTemplate : '{content} {icon}', // new in v2.7. Needed to
			// add
			widgets : [ "uitheme", "filter", "zebra" ],
			widgetOptions : {
				zebra : [ "even", "odd" ],
				filter_reset : ".reset",
				filter_cssFilter : "form-control",
			}
		}).tablesorterPager({
			container : $(".ts-pager"),
			headers : {
				0 : {
					filter : false
				}
			},
			cssGoto : ".pagenum",
			removeRows : false,
			output : '{startRow}' // '{startRow} - {endRow} / {filteredRows}
		// ({totalRows})'
		});
	});
}

function adicionaClass(campo, novoClass) {
	var classAtual = campo.prop('class');
	classAtual = classAtual + ' ' + novoClass;
	campo.prop('class', classAtual);
}
/*
 * TABLE SORTER
 * -----------------------------------------------------------------------------------------
 */
// NOTE: $.tablesorter.theme.bootstrap is ALREADY INCLUDED in the
// jquery.tablesorter.widgets.js
// file; it is included here to show how you can modify the default classes
$.tablesorter.themes.bootstrap = {
	// these classes are added to the table. To see other table classes
	// available,
	// look here: http://getbootstrap.com/css/#tables
	table : 'table table-bordered table-striped',
	caption : 'caption',
	// header class names
	header : 'bootstrap-header', // give the header a gradient background
	// (theme.bootstrap_2.css)
	sortNone : '',
	sortAsc : '',
	sortDesc : '',
	active : '', // applied when column is sorted
	hover : '', // custom css required - a defined bootstrap style may not
	// override other classes
	// icon class names
	icons : '', // add "icon-white" to make them white; this icon class is added
	// to the <i> in the header
	iconSortNone : 'bootstrap-icon-unsorted', // class name added to icon when
	// column is not sorted
	iconSortAsc : 'glyphicon glyphicon-chevron-up', // class name added to icon
	// when column has ascending
	// sort
	iconSortDesc : 'glyphicon glyphicon-chevron-down', // class name added to
	// icon when column has
	// descending sort
	filterRow : '', // filter row class; use widgetOptions.filter_cssFilter for
	// the input/select element
	footerRow : '',
	footerCells : '',
	even : '', // even row zebra striping
	odd : '' // odd row zebra striping
};