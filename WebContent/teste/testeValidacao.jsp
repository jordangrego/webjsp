<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/topo.jsp"%>
<form data-toggle="validator" role="form">



	<div class="form-group">
		<label for="inputPassword" class="control-label">Password</label>
		<div class="form-group col-sm-6">
			<input type="password" data-minlength="6" class="form-control"
				id="inputPassword" placeholder="Password" required>
			<div class="help-block">Minimum of 6 characters</div>
		</div>
		<div class="form-group col-sm-6">
			<input type="password" class="form-control" id="inputPasswordConfirm"
				data-match="#inputPassword"
				data-match-error="Whoops, these don't match" placeholder="Confirm"
				required>
			<div class="help-block with-errors"></div>
		</div>
	</div>



	<div class="form-group">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>


<%@ include file="/fundo.jsp"%>