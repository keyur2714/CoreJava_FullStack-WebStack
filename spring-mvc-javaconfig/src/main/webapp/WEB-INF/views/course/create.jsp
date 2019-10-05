<%@ page isELIgnored="false" %>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet">
<title>Manage Course</title>
<div class="container">
	<form action="courseSave" method="post" name="frmCorseEntry">
		<div class="row form-group">
			<div class="col-sm-4">Course Name: </div>
			<div class="col-sm-4"><input type=text name=courseName class="form-control"/></div>
		</div>
		<div class="row form-group">
			<div class="col-sm-4">Fees: </div>
			<div class="col-sm-4"><input type=text name=fees class="form-control"/></div>			
		</div>
		<div class="row form-group">
			<div class="col-sm-4">Trainer Name: </div>
			<div class="col-sm-4"><input type=text name=trainerName class="form-control"/></div>			
		</div>
		<div class="row form-group">
			<div class="col-sm-4"><button class="btn btn-info">Save</button></div>					
		</div>
	</form>
</div>