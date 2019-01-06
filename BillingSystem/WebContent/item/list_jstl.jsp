<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">		
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-6">
			<div class="card text-white">
				<div class="card-header bg-danger">Item List</div>
				<div class="card-body bg-warning">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Code</th>
								<th>Description</th>
								<th>Price</th>
							</tr>
						</thead>	
						<tbody>							
							<c:forEach var="item" items="${requestScope.itemList}">
								<c:if test="${item.code != 'CCOFFEE' }">
									<tr>
										<td><a href="${pageContext.request.contextPath}/ManageItemController?action=detail&id=${item.id}">${item.id}</a></td>
										<td><img src="${pageContext.request.contextPath}/images/${item.code}.jpg" width=30px height=30px /></td>
										<td>${item.description}</td>
										<td>${item.unitPrice}</td>
									</tr>
								</c:if>								
							</c:forEach>														
						</tbody>
					</table>
				</div>
			</div>		
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>
</div>



