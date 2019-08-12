<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Review</title>

<!--<c:url value="../css/main.css" var="cssURL"/>
<link href="${cssURL}"  rel="stylesheet" type="text/css">-->

<style type="text/css">	
*{
	margin: 0 auto;
	font-family: cursive;
	line-height: 30px;
}

.movies {
	padding: 10px;
	border: 1px gray solid;
	border-radius: 5px;
	margin: 5px;
	display: inline-block;
	text-align: center;
	box-shadow: 5px 5px 2px 1px rgba(0, 0, 255, .1);
	min-height: 400px;
	width: 250px;
	font-size: 13px;
}
.link-btn{
	background-color: maroon;
	padding: 5px 10px;
	text-align: center;
	color: #fff;	
	border-radius: 5px;
	box-shadow: 5px 5px 2px 1px rgba(0, 0, 255, .1);
}
a.link-btn:hover{
	background-color: #fff;
	padding: 5px 10px;
	text-align: center;
	color: maroon;	
	border-radius: 5px;
	border: rgba(128,0,0,0.5) 1px solid;
	box-shadow: 5px 5px 2px 1px rgba(0, 0, 255, .1);
}
img {
	width: auto;
	height: 200px;
}
.addMovieBtn{
	border: 1px solid maroon;
	text-align: center;
	padding: 5px 20px;
	background-color: #fff;
	border-radius: 5px;
}
input.addMovieBtn:hover{
	border: 1px solid maroon;
	text-align: center;
	padding: 5px 20px;
	background-color: maroon;
	color: #fff;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div id="container">
		<div id="content">
			<form action="/movie_add_form">
				<input class="addMovieBtn" type="submit" value="Add Movie"/>
			</form>
			<c:forEach var="m" items="${movies}" varStatus="x">
				<div class="movies">
					<img alt="POSTER" src="${m.poster}"> <br/>
					Title: <c:out value="${m.title}"></c:out> <br/>
					Genre: <c:out value="${m.genres}"></c:out> <br/>
					<hr>
					<c:out value="${m.description}"></c:out> <br/>
					<hr>
					Release Year: <c:out value="${m.release_year}"></c:out> <br/>
					Produced By: <c:out value="${m.produced_by}"></c:out> <br/>
					Total Cost: <c:out value="${m.cost}"></c:out> <br/>
					Participants: <c:out value="${m.participants}"></c:out> <br/>
					<a class="link-btn" href="/comment/${m.movie_id}">View Comments</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>