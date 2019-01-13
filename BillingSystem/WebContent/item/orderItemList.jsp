<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped table-dark">
	<thead>
		<tr>
			<th>Item Desc</th>
			<th>Quantity</th>
			<th>Price</th>		
			<th>Total Price</th>	
		</tr>		
	</thead>
	<tbody>
		<c:forEach var="orderItem" items="${sessionScope.orderItemList}">
			<tr>
				<td>${orderItem.itemDesc}</td>
				<td>${orderItem.quantity}</td>
				<td>${orderItem.unitPrice}</td>
				<td>${orderItem.quantity * orderItem.unitPrice}</td>			
			</tr>
		</c:forEach>			
	</tbody>
	
</table>