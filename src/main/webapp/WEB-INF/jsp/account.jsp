<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Create/Edit Your Own Blog
</button>
      <form:form  commandName="model" class="form-horizontal" role="form" >
 
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
    <form:input path="name"/>
    <form:errors path="name"/>
    </div>
  </div>
  
 <div class="form-group">
    <label for="name" class="col-sm-2 control-label">url</label>
    <div class="col-sm-10">
    <form:input path="url"/>
    <form:errors path="url"/>
    </div>
  </div>
  

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="SaveChanges">
     
      </div>
    </div>
  </div>
</div>
</form:form>
<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show'); // Select first tab
	
});
</script>
 
  <ul class="nav nav-tabs">
   <c:forEach items="${msg.blog }" var="blogs">

  <li class=""><a href="#blog_${blogs.id}" data-toggle="tab"><c:out value="${blogs.name}"></c:out></a></li>
  
   </c:forEach>
 
</ul>

<div class="tab-content">

 <table class="table">
 
  
 
<c:forEach items="${msg.blog }" var="blogs">
  <tr class="tab-pane " id="blog_${blogs.id}" >
  
 <td>${blogs.name}</td>
  <td>${blogs.url}</td>
  <td><a href="<spring:url value="/${blogs.id}/editBlog.html" />">
				<input type="button" class="btn btn-warning" value="EDIT"></a></td>
				<td><a href="<spring:url value="/${blogs.id}/deleteBlog.html" />">
				<input type="button" class="btn btn-danger" value="DELETE"></a></td>
  </tr>
 
  

</c:forEach>

  </table>
  
</div>


  
  
  

 
 
