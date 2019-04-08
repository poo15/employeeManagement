<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee </title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Login</title>
<link rel="stylesheet" href="datestyle.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
            $(function(){
                $("#datepicker").datepicker({
                        changeMonth: true,
                        changeYear: true,
                       dateFormat: 'dd/mm/yy'
                });
                           
            });
          </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		
		<div class="main-Div">
		<form:form action="editEmployee" class="border border-primary"  modelAttribute="employee" style="margin:10% 15% 0% 15%;padding:5%" method="get">
		  <div class="form-group form-inline row">
		  	<div class="col-lg-4 "  style="margin-left:5%">
		    	<label>Employee Code:- </label>
		    </div>
		    <div class="col-lg-6">
		    <form:input type="text" class="form-control" onkeydown="return false" id="employeeCode" path="employeeCode" required="true" value="${employee.getEmployeeCode()}"/>
			  
			 </div>
		   </div>
		  
		  <div class="form-group form-inline">
			  <div class="col-lg-4 " style="margin-left:5%">
			    	<label for="employeeName" >Employee Name:- </label>
			   </div>
			   
			   <div class="col-lg-6">
			    <form:input type="text" class="form-control" id="employeeName" path="employeeName" required="true" value="${employee.getEmployeeName()}"/>
			  </div>
		  </div>
		  
		   <div class="form-group form-inline">
			  <div class="col-lg-4 " style="margin-left:5%">
			    	<label for="location" >Location:- </label>
			   </div>
			   
			   <div class="col-lg-6">
			    <form:input type="text" class="form-control" id="location" path="location" required="true" value="${employee.getLocation()}"/>
			  </div>
		  </div>
		  
		   <div class="form-group form-inline">
			  <div class="col-lg-4 " style="margin-left:5%">
			    	<label for="employeeName" >Email:- </label>
			   </div>
			   
			   <div class="col-lg-6">
			    <form:input type="email" class="form-control" id="email" path="email" required="true" value="${employee.getEmail()}"/>
			  </div>
		  </div>
		  
		  <div class="form-group form-inline">
			  <div class="col-lg-4 " style="margin-left:5%">
			    	<label for="dob" >DOB:- </label>
			   </div>
			   
			   <div class="col-lg-6">
			     <form:input type="text" onkeydown="return false" path="dob" class="form-control" value="${employee.getDob()}" id="datepicker" />
                 </div>
		  </div>
		  <div class="row ">
		  	<div class="col-lg-12" >
		  	<div class="text-center">
		  		<button type="submit" class="btn btn-primary" >Submit</button>
		  	</div>
		  	</div>
		  </div>
		</form:form>
	</div>
		
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>