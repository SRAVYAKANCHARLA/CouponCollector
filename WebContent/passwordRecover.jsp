<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet" href="login.css">
<title>Coupons Collector | IDBMS Project</title>
</head>

<script type="text/javascript">

</script>

<%  String s=(String)request.getAttribute("error"); 
	%>				
		

<body>
	<div id="container">
		<div id="header">
			<h1>
				Coupons<span class="off">Collector</span>
			</h1>
			<h2>Project by IDBMS Team 6</h2>
		</div>
		<div id="menu">
			<ul>
				<li class="menuitem"><a href="login.jsp">Login</a></li>
				<li class="menuitem"><a href="register.jsp">Register</a></li>
				<li class="menuitem"><a href="#">Contact</a></li>
			</ul>
		</div>

		<div id="content">
			<div id="content_top"></div>
			<div id="content_main">
				<div id="logindiv">
					<form action="SendMail">	
					<p><font color="red">${error}</font></p><br>
					<p><font color="blue">${message}</font></p><br>
						<p>
							<label for="login">Enter Email:</label> <input type="text" name="email"
								id="email">
						</p>
						<br>						
						<div align="center">
							<p class="forgot-password" align="center">
								<button type="submit">Send</button>
							</p>
						</div>
						<p class="forgot-password"></p>
					</form>
				</div>
				<div id="aboutus" style="display: none;"></div>
			</div>
			<div id="content_bottom"></div>

		</div>



	</div>
</body>
</html>