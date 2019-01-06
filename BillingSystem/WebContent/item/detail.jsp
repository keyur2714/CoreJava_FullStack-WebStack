<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">		
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-6">
			<div class="card text-white">
				<div class="card-header bg-danger">Item Detail of ${item.description}</div>
				<div class="card-body bg-warning">
					<table class="table">
						<tr>
							<td>
								<img src="${pageContext.request.contextPath}/images/${item.code}.jpg" width="100px" height="100px"/>
							</td>
						</tr>					
						<tr>
							<td>
								${requestScope.item.unitPrice} Rs
							</td>
						</tr>
						<tr>
							<td>
								<button class="btn btn-primary">Add To Cart</button>
							</td>
						</tr>
					</table>
				</div>
			</div>		
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>
</div>



