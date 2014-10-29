<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<img src="resources/images/rss.jpg" width="50" height="50">
<div class="wrapper">
	<h1>RSS Feed</h1>
</div>


<table id="sample" class="table">
<thead>
<tr class="success">
<th>Date</th>
<th>Title</th>
<th>Link</th>

</tr >

</thead>
	<c:forEach items="${msg}" var="items">

		<tr>

			<td>${items.date}</td>
			
			<td>${items.name}</td>
			<td>${items.link}</td>

		</tr>

	</c:forEach>
</table>

<script type="text/javascript">
$(document).ready(function() {
	oTable = $('#sample').dataTable();
	$('#search').keyup(function(){
	      oTable.fnFilter( $(this).val() );
	}) 
    
  
} );
</script>























