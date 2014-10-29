<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${msg }" var="users">
			<tr>
				<td>${users.name}</td>
				<td>${users.email}</td>
				
				<c:forEach items="${users.roles }" var="rol">
				<td><a href="<spring:url value="/${users.id}/user_blog.html"/>">
				${rol.name}</a></td>
				</c:forEach>
				<td><a href="<spring:url value="/${users.id}/user_delete.html"/>">
				<button class="btn btn-danger">DELETE</button>
				</a></td>
				
			</tr>
		</c:forEach>

	</tbody>

</table>