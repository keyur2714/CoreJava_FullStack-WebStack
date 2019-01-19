<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function placeOrder(){
		var url = "${pageContext.request.contextPath}/OrderController?action=placeOrder";
		document.location.href = url;
	}
</script>
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
							<c:forEach var="item" items="${sessionScope.itemList}">
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
		<c:if test="${item != null}">
			<div class="col-md-6">
				<jsp:include page="detail.jsp"></jsp:include>
			</div>
		</c:if>		
	</div>
	<c:if test="${sessionScope.orderItemList.size() > 0}">
		<div class="row">
			<div class=col alert alert-success>
				${msg}
			</div>
		</div>		
		<div class="row">
			<div class="col-md-6">
					<jsp:include page="orderItemList.jsp"></jsp:include>
			</div>
			<div class="col-md-6">				
				<button class="btn btn-primary" onclick="placeOrder()">Place Order</button>
			</div>
		</div>
	</c:if>	
	<jsp:include page="../footer.jsp"/>
</div>



