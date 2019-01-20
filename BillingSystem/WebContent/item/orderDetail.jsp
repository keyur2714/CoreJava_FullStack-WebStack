<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-md-12">
		<div class="card text-white">
			<div class="card-header bg-danger">Order Detail of
				${order.orderId}</div>
			<div class="card-body bg-warning">
				<div class="row">
					<div class=col>
						<table class="table table-striped bg-info">
							<thead>
								<tr>
									<th>Item</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="orderItem" items="${order.orderItemList}">
									<tr>
										<td>${orderItem.itemDesc}</td>
										<td>${orderItem.quantity}</td>
										<td>${orderItem.unitPrice}</td>
										<td>${orderItem.unitPrice * orderItem.quantity}</td>
									</tr>
								</c:forEach>				
								<tr>
									<td colspan="3">Sub Total</td>
									<td colspan="1">${order.totalPrice}</td>
								</tr>
							</tbody>													
						</table>
					</div>
				</div>				
			</div>
			<div class="card-footer bg-dark">
				<div class=row>
					<div class=col>
						<button class="btn btn-lg btn-info">Print</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
