<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="tilex" uri="http://tiles.apache.org/tags-tiles-extras" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
 
<form:form class="form-horizontal registerForm" role="form"  commandName="comm">

<c:if test="${param.success eq true }">
<div class="alert alert-success">Registration Successfull</div>

</c:if>

  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
    <form:input path="name"/>
    <form:errors path="name" />
       </div>
  </div>
   <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <form:input path="email"/>
    <form:errors path="email"/>
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <form:password path="password"/>
    <form:errors path="password"/>
    </div>
  </div>
   <div class="form-group">
    <label for="confirmPassword" class="col-sm-2 control-label">ConfirmPassword</label>
    <div class="col-sm-10">
    <input type="password" name="confirmPassword" >
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
</form:form>
<script type="text/javascript">

$(document).ready(function() {
    $('.registerForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    },stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    }
                   
                }
            },
           confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    },stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    identical:{
                    	field: 'password',
                    	message: 'password doesnot match'
                    }
                   
                }
            },
            
           
        }
    });
});
</script>
    