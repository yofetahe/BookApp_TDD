<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<style type="text/css">	
*{
	margin: 0 auto;
	font-family: cursive;
	line-height: 30px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	<div id="container">
		<div id="content" class="form-container">
			
			<form:form action="/add_user" method="POST" modelAttribute="user">
				<div class="form-control">
					<label>Full Name</label>
					<form:input path="full_name"/>
				</div>
				<div class="form-control">
					<label>Email</label>
					<form:input path="email"/>
				</div>
				<div class="form-control">
					<label>Password</label>
					<form:password path="password"/>
				</div>
				<div class="form-control">
					<label>Confirm Password</label>
					<form:password path="confirm_password"/>
				</div>
				<input type="submit" value="SAVE">
			</form:form>
			
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>

</body>
</html>