<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Login</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<div class="main-Div">
		<form action="login" class="border border-primary"  style="margin:10% 25% 0% 25%;padding:5%" method="post">
		  <div class="form-group form-inline row">
		  	<div class="col-lg-4 "  style="margin-left:5%">
		    	<label for="email">Email address:- </label>
		    </div>
		    <div class="col-lg-6">
		    	<input type="text" class="form-control" id="email" name="email" required="true" placeholder="Enter Email">
			 </div>
		   </div>
		  
		  <div class="form-group form-inline">
			  <div class="col-lg-4 " style="margin-left:5%">
			    	<label for="password" >Password:- </label>
			   </div>
			   
			   <div class="col-lg-6">
			    <input type="password" class="form-control" id="password" name="password" required="true" placeholder="Password">
			  </div>
		  </div>
		  
		  <div class="row ">
		  	<div class="col-lg-12" >
		  	<div class="text-center">
		  		<button type="submit" class="btn btn-primary" >Submit</button>
		  	</div>
		  	</div>
		  </div>
		  
		  
		<c:if test="${invalidUser == true}">
		
			<div class="alert alert-warning alert-dismissible fade show mt-3" role="alert">
			  <strong>Invalid User</strong> Check login Details.
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
	
		</c:if>
		  
		</form>
		
		
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>