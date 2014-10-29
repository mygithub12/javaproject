<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
	<tr>
	<td><a href="<spring:url value="/account.html" />">
				<input type="button" class="btn btn-success" value="ADD"></a></td>
		<tr>
			<th>Name</th>
			<th>URL</th>
		
			<th>Edit</th>
			<th>Delete</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${msg.blog }" var="users">
			<tr>
				<td>${users.name}</td>
				<td>${users.url}</td>
				
				<td><a href="<spring:url value="/${users.id}/editBlog.html" />">
				<input type="button" class="btn btn-warning" value="EDIT"></a></td>
				<td><a href="<spring:url value="/${users.id}/deleteBlog.html" />">
				<input type="button" class="btn btn-danger" value="DELETE"></a></td>
				
			</tr>
		</c:forEach>

	</tbody>

</table>