<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP - Postgre</title>
<%@ include file="scripts.jsp"%>

<style type="text/css">
* {
	border: 0;
	margin: 0
}

.ui-widget-overlay {
	background: repeat-x scroll 50% 50% #AAA;
	opacity: 0.3;
}

.ui-widget-overlay {
	height: 100%;
	left: 0;
	position: absolute;
	top: 0;
	width: 100%;
}
</style>

</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div id="fundoModal" class="ui-widget-overlay ui-front"
			style="display: none"></div>
		<div id="divLoading"
			style="display: none; position: fixed; /* or absolute */ top: 50%; left: 50%;">
			<div class="panel panel-default">
				<div class="panel-body">
					<img src="/webjsp/images/ajax-loader.gif" />
				</div>
			</div>
		</div>