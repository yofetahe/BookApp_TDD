<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Add Form</title>
<style type="text/css">	
*{
	margin: 0 auto;
	font-family: cursive;
	line-height: 30px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div id="container">
		<div id="content" class="form-container">
				
			<form:form action="/add_movie" method="POST" modelAttribute="movieForm">
				<div class="form-control">
					<label>Movie Title</label>
					<form:input path="title"/>
				</div>
				<div class="form-control">
					<label>Description</label>
					<form:input path="description"/>
				</div>
				<div class="form-control">
					<label>Poster URL</label>
					<form:input path="poster"/>
				</div>
				<div class="form-control">
					<label>Genres</label>
					<form:input path="genres"/>
				</div>
				<div class="form-control">
					<label>Release Year</label>
					<form:input path="release_year"/>
				</div>				
				<div class="form-control">
					<label>Produced By</label>
					<form:input path="produced_by"/>
				</div>
				<div class="form-control">
					<label>Cost</label>
					<form:input path="cost"/>
				</div>				
				<div class="form-control">
					<label>Actors and Actresses</label>
					<form:input path="participants" placeholder="Actors"/>
				</div>
				<input type="submit" value="SAVE">
			</form:form>
		
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>