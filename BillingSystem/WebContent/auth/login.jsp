<div class=container-fluid>
	<jsp:include page="../header.jsp"/>
	<div class=row>
		<div class="col-md-8">
			${errorMsg}
		</div>
	</div>
	<div class="row">
	 	<div class="col-md-8">
	 		<div class="card">
	 			<div class="card-header">Login</div>
	 			<div class="card-body">
	 				<form method=post action="${pageContext.request.contextPath}/LoginController?action=auth">
		 				<table class="table table-bordered">
		 					<tr>
		 						<td>Username: </td>
		 						<td><input type=text name=username class="form-control" /></td>
		 					</tr>
		 					<tr>
		 						<td>Password: </td>
		 						<td><input type=password name=password class="form-control" /></td>
		 					</tr>
		 					<tr>
		 						<td colspan="2">
		 							<button type=submit class="btn btn-info">Sign In</button>
		 							<button type=reset class="btn btn-secondary">Reset</button>
		 						</td>		 						
		 					</tr>		 					
		 				</table>
	 				</form>
	 			</div>
	 		</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>	
</div>