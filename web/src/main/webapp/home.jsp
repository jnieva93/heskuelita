<%@ page import="com.capgemini.heskuelita.data.entity.UserAnnotation" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Home</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
	<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				<h2>Welcome Home</h2>
				<%UserAnnotation us = (UserAnnotation)session.getAttribute ("user");%>
				<!--<img class="img2" src="img/alert.png">-->
				<p>Your username is <%=us.getUserName() + " and your password is " + us.getPassword()%></p>
				<a href="index.jsp"><button class="btn"><i class="fas fa-sign-out-alt"></i>Log out</button></a>
			</div>
		</div>
	</div>
</body>
</html>