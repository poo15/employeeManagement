<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Login</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<div class="row" style="margin:1% 1% 1% 1%">
	
	<div class="col-lg-6">
		<form action="insert" method="post" enctype="multipart/form-data">
			<div class="row">
			<div class="col-lg-6 custom-file">
			    <input type="file" class="custom-file-input" required="true" name="file" id="inputFile" aria-describedby="inputGroupFileAddon04">
			    <label class="custom-file-label" for="inputFile">Choose file</label>
			</div>
			<div class="col-lg-6">
				<button type="submit" class="btn btn-primary " >Upload Employee Details</button>
			</div>
			</div>
		</form>
	</div>
	
	<div class="col-lg-6">
			<button type="button" onclick="window.location.href='downloadCSV';return false;" class="btn btn-primary " >Download Employee Details</button>
	</div>

</div>


<table class="table" style="margin-top: 2%">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Employee Code</th>
						<th scope="col">Employee Name</th>
						<th scope="col">Location</th>
						<th scope="col">Email</th>
						<th scope="col">DOB</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="employee" items="${employees}">
						<tr>
							<th>${employee.getEmployeeCode()}</th>
							<td>${employee.getEmployeeName()}</td>
							<td>${employee.getLocation()}</td>
							<td>${employee.getEmail()}</td>
							<td>${employee.getDob()}</td>
							<td><button type="button" class="btn btn-primary " ><a href="edit?employeeCode=${employee.getEmployeeCode()}" style="color: white" >Edit</a></button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
 <script type="application/javascript">
    $('input[type="file"]').change(function(e){
        var fileName = e.target.files[0].name;
        console.log(fileName);
        var size = e.target.files[0].size;
        console.log(size);
        $('.custom-file-label').html(fileName);
    });

    function clearInput() {
    	$('.custom-file-label').html("Choose file");
    };
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>