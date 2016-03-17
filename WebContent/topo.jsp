<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<title>JSP - Postgre</title>
<%@ include file="scripts.jsp"%>
<script src="/webjsp/scripts/universal.js"></script>
</head>
<body>
	<%@ include file="seguranca.jsp"%>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div id="fundoModal" class="ui-widget-overlay ui-front"></div>
		<div id="divLoading">
			<div class="panel panel-default">
				<div class="panel-body">
					<img src="/webjsp/images/ajax-loader.gif" />
				</div>
			</div>
		</div>