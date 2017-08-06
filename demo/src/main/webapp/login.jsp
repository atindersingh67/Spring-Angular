<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

	<link rel="stylesheet" href="css/style.css">
	
</head>
<body class="loginbody">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
								<a href="#" class="active" id="login-form-link">Login</a>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							<c:url var="loginUrl" value="/login" />
								<form id="login-form" action="${loginUrl}" method="post" 
									style="display: block;">
									<div class="form-group">
										<input type="text" class="form-control" id="username"
											tabindex="1" name="username" placeholder="Username" required>
									</div>
									<div class="form-group">
										<input type="password" class="form-control" id="password"
											name="password" placeholder="Password" required tabindex="2">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
									<c:if test="${param.error != null}">
										<div class="alert alert-danger">
											<p>Invalid username and password.</p>
										</div>
									</c:if>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>