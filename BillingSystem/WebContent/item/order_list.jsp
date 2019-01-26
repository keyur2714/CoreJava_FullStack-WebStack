<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-12">
			<div class="card text-white">
				<div class="card-body bg-warning">
					<div class="row">
						<div class=col>
							<table class="table table-striped bg-dark text-white">
								<thead>
									<tr>
										<th>Order #</th>
										<th>Date</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="order" items="${orderList}">
										<tr>
											<td><a href="${pageContext.request.contextPath}/OrderController?action=orderDetail&orderId=${order.orderId}&from=orderList">${order.orderId}</a></td>
											<td>${order.orderDate}</td>
											<td>${order.totalPrice}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>