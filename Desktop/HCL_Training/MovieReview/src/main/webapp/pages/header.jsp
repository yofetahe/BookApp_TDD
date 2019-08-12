<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<style type="text/css">	
#header{
	margin-bottom: 20px;
	background-color: maroon;
	width: 100%;
	padding: 50px 0px 5px 0px;
	text-align: center;
	color: #fff;	
	box-shadow: 0px 5px 5px gray;
	border-bottom: #fff 2px solid;
}
#header>.page_title{
	font-size: 50px;
}
#header>.links{
	padding-top: 20px;
}
a#sign_up, a#login, a#home{	
	padding: 5px 10px;
}
a#sign_up:hover, a#login:hover, a#home:hover{
	background-color: rgba(255,255,255,0.2);
	border-radius: 5px;
	padding: 5px 10px;
}
a{
	text-decoration: none;
	text-transform: uppercase;
	color: #fff;
}
</style>

<style type="text/css">
#container{
	text-align: center;
}
#content{
	margin: 0 auto;
}
.form-container{
	width: 24em;
}
.form-control{
	margin: 5px 0px;
	text-align: left;
}
form{
	direction: rtl;
} 
input{
	display: block;
  	direction: ltr;
}
</style>

</head>
<body>

	<div id="header">
		<div class="page_title"> --- &nbsp;&nbsp; Movie Review &nbsp;&nbsp; --- </div>
		<div class="links"> <a href="/" id="home"> home </a> | <a id="sign_up" href="/sign_up"> Sign up </a> | <a id="login" href="/login"> Log in </a> </div>
	</div>

</body>
</html>