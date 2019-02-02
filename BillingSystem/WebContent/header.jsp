<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing System</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<div class="row">
	<div class="col">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<c:forEach var="menuItem" items="${menuItemList}">
					<c:choose>
						<c:when test="${user != null}">
							<c:if test="${ menuItem.desc == 'Sign In' }">
								<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/LogoutAction">Logout</a>
							</c:if>
							<c:if test="${ menuItem.desc != 'Sign In' && user.roleCode == 'ADMIN'}">														
								<li class="nav-item active"><a class="nav-link" href="${menuItem.url}">${menuItem.desc}</a>
								</li>
							</c:if>
							<c:if test="${ menuItem.desc != 'Sign In' && user.roleCode == 'SELLER'}">
								<c:if test="${ menuItem.desc != 'Manage Orders' }">								
									<li class="nav-item active"><a class="nav-link" href="${menuItem.url}">${menuItem.desc}</a>
									</li>
								</c:if>
							</c:if>
						</c:when>
						<c:when test="${user == null}">
							<li class="nav-item active"><a class="nav-link" href="${menuItem.url}">${menuItem.desc}</a>
						</li>
						</c:when>
					</c:choose>									
				</c:forEach>				
			</ul>
		</nav>
	</div>
</div>
</head>