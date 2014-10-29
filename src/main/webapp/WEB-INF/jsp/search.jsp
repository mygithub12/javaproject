<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
 <c:choose>
 <c:when test="${msg eq true }">
<table class="table">
<thead>
<tr class="success">
<th>Date</th>
<th>Title</th>
<th>Link</th>

</tr >

</thead>
<tbody>

<tr>
           <td>${search.date}</td>
			<td>${search.name}</td>
			<td>${search.link}</td>

		</tr>

</tbody>
</table>
</c:when>

<c:otherwise>


<div class="alert alert-danger">No items match your search</div>
</c:otherwise>
</c:choose>