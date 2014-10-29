<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="tilex" uri="http://tiles.apache.org/tags-tiles-extras" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <head>
 
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">


 <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css">
<script  src= "//code.jquery.com/jquery-1.11.1.min.js"></script>
<script  src= "//cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>




<spring:url value="/resources/css/styles.css" var="sample"/>  
    <link href="${sample}" rel="stylesheet"/>  
    
    <title><tiles:getAsString name="title"/></title>
    

  </head>
  <body>
  <tilex:useAttribute name="current"/>
     <div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Java Blog</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            
          
              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/welcome.html" />'>Home</a></li>
            
            
            
             <security:authorize access="! isAuthenticated()">
	         <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html" />">Login</a></li>
             <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value="/register.html" />">Register</a></li>
             </security:authorize>
             
            <security:authorize access="isAuthenticated()">
               
              
              	<li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html" />">Admin</a></li>
                 
              <li class="${current == 'account' ? 'active' : ''}"><a href="<spring:url value="/account.html" />">My account</a></li>
              	<li><a href="<spring:url value="/logout" />">Logout</a></li>
              </security:authorize>
          
            </ul>
                <div class="col-sm-3 col-md-3 pull-right">
        <form class="navbar-form" role="search" action="/JavaBlog/search.html">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" id="search" id="srch-term">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
        </div>
           
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron" style ="background-color:transparent !important">
        <tiles:insertAttribute name="body" />
          
          <div class="footer">
          <tiles:insertAttribute name="footer" />
          </div>
      </div>

    </div> 
       
      </body>