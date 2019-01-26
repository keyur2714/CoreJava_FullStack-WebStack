<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function addToItem(itemId){
		var qty = document.getElementById("qty").value;
		if(qty == -1){
			alert("Please Select Quantiry!");
			return false;
		}else{		
			var url = "${pageContext.request.contextPath}/OrderController?action=addItemToOrder&itemId="+itemId+"&qty="+qty;
			document.location.href = url;
		}		
	}
</script>
<div class="row">
	<div class="col-md-12">
		<div class="card text-white">
			<div class="card-header bg-danger">Item Detail of
				${item.description}</div>
			<div class="card-body bg-secondary">
				<div class="row">
					<div class="col-sm-6">
							<img
							src="${pageContext.request.contextPath}/images/${item.code}.jpg"
							width="100px" height="100px" />
					</div> 				
					<div class=col-sm-6>
						<select name="qty" class="form-control" id="qty">
							<option value="-1">Qty</option>
							<c:forEach var="i" begin="1" end="20">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
					</div>	
				</div>
				<div class="row">
					<div class="col-sm-6">
						${requestScope.item.unitPrice} Rs
					</div>
				</div>
				<div class="col-sm-6">
					<div class="col-sm-6">
						<button class="btn btn-primary" onclick="addToItem(${item.id})">Add To Cart</button>
					</div>
				</div>				
			</div>
		</div>
	</div>
</div>




