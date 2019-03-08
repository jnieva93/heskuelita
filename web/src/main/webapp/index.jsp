<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="US-ASCII">
	<title>Login</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
	<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<!-- div del modal (?) y clase texto centrada -->
	<div class="modal-dialog text-center">
		<!-- Columna de bootstrap. main-section para referenciarla despues -->
		<div class="col-sm-8 main-section">
			<!-- Otro modal pero para el contenido -->
			<div class="modal-content">
				<!-- Imagen de usuario del login. user-img para styling adicional -->
				<div class="col-12 user-img">
					<img src="img/face.png">
				</div>

				<!-- Input section -->
				<form action="login" method="post" class="col-12">
					<div class="form-group">
						<input type="text" name="user" class="form-control" placeholder="Username *">
					</div>
					<div class="form-group">
						<input type="password" name="pwd" class="form-control" placeholder="Password *">
					</div>
					<!-- Boton de login. <i es para el icono del boton. Ver font awesome -->
					<button type="submit" class="btn" value="Login"><i class="fas fa-sign-in-alt"></i>Login</button>
				</form>

				<!-- Olvidaste el password? forgot es solo un alias? Cambiar a no tienes cuenta -->
				<div class="col-12 forgot">
					<a href="Registration.jsp">Don't have an account? Click here</a>
				</div>
			</div>  <!-- Fin del contenido modal -->
		</div>
	</div>
</body>
</html>