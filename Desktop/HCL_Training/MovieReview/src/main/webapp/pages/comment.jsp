<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Comment</title>
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
a{
	text-decoration: none;
	text-transform: uppercase;
	color: #fff;
}
</style>
<style type="text/css">
	#comment_content{
		font-size: 13px;
	}
	#movie_info{
		display: inline-block;
		width: 25%;
		height: 100%;
		padding: 0px 15px;
		vertical-align: top;
		text-align: left;
	}
	#comment_list{
		display: inline-block;
		width: 70%;
		height: 100%;
		vertical-align: top;
		padding: 0px 15px;
		text-align: left;
	}
	
	.title{
		border-bottom: 1px solid gray;
		font-size: 16px;
		font-style: italic;
	}
	.form-control{
		margin-bottom: 5px;
	}
	#abutton{
		color: blue;
		text-decoration: none;
	}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<div id="container">
		<div id="content">
	
			<div id="comment_content">
				<div id="movie_info">
					<div>
					<img alt="POSTER" src="${movie.poster}"> <br/>
					Title: <c:out value="${movie.title}"></c:out> <br/>
					Genre: <c:out value="${movie.genres}"></c:out> <br/>
					Release Year: <c:out value="${movie.release_year}"></c:out> <br/>
					Produced By: <c:out value="${movie.produced_by}"></c:out> <br/>
					Total Cost: <c:out value="${movie.cost}"></c:out> <br/>
					Participants: <c:out value="${movie.participants}"></c:out>
					<hr>
					<c:out value="${movie.description}"></c:out> <br/>
					</div>
				</div>
				<div id="comment_list">
					<div class="title"> Comment </div>
					
					<div>
						<c:forEach var="comments" items="${comments}">
							<div>
								<c:out value="${comments.content}"/> <br>
								Given by: <c:out value="${comments.given_by}"/> &nbsp;&nbsp;
								Like: <c:out value="${comments.like_count}"/> &nbsp;&nbsp;
								Dislike: <c:out value="${comments.dislike_count}"/>
							</div> 
						</c:forEach>
					</div>
					
					<form:form action="/add_comment/${movie.movie_id}" method="post" modelAttribute="commentForm">
						<div class="form-control">
							<form:textarea rows="3" cols="30" placeholder="Your Comment" style="width: 100%" path="content"></form:textarea>
						</div>
						<div class="form-control">
							<label>Your Name</label>
							<form:input path="given_by"/><br>
						</div>
						<input type="submit" value="Add Comment">
					</form:form>
				</div>
			</div>
		
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>