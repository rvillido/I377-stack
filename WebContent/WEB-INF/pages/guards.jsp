<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pr" %>

<pr:layout>
	<h3>Guards</h3>
	
	<c:if test="${not empty allGuards}">
		
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<c:forEach items="${allGuards}" var="guard"> 
				<tr>
					<td>${guard.id}</td>
					<td>${guard.name}</td>
					<td>${guard.age}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</pr:layout>