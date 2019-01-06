<%@page import="java.util.ArrayList"%>
<%@page import="com.keyur.dto.ItemDTO"%>
<%@page import="java.util.List"%>
<%
	List<ItemDTO> itemList = (ArrayList<ItemDTO>)request.getAttribute("itemList");
%>
<div class="container-fluid">		
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-6">
			<div class="card text-white">
				<div class="card-header bg-info">Item List</div>
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
							<% for(ItemDTO item : itemList) {%>
								<tr>
									<td><%= item.getId() %></td>
									<td><%= item.getCode() %></td>
									<td><%= item.getDescription() %></td>
									<td><%= item.getUnitPrice() %></td>
								</tr>
							<% } %>	
						</tbody>
					</table>
				</div>
			</div>		
		</div>
	</div>
	<jsp:include page="../footer.jsp"/>
</div>
