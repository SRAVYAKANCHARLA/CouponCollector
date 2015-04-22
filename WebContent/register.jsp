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

				<div id="registerdiv" >

					<form method="post" action="Register">
						<p>
							<label>First Name:</label> <input type="text" name="firstname"
								id="firstname">
						</p>
						<br>
						<p>
							<label>Last Name:</label> <input type="text" name="lastname"
								id="lastname">
						</p>
						<br>
						<p>
							<label>Email:</label> <input type="text" name="email" id="email">
						</p>
						<br>
						<p>
							<label>Password:</label> <input type="password" name="password"
								id="password">
						</p>
						<br>
						<p>
							<label>Mobile No:</label> <input type="text" name="mobileno"
								id="mobileno">
						</p>
						<br>
						<p>
							<label>Zipcode:</label> <input type="text" name="zipcode"
								id="zipcode">
						</p>
						<br>
						<p>
							<label>Category:</label> <select name="categories">
								<option value="0">---Category---</option>
								<option value="1">Restaurants</option>
								<option value="2">Entertainment</option>
								<option value="3">Beauty & Spa</option>
								<option value="4">Services</option>
								<option value="6">Shopping</option>
								<option value="7">Travel</option>
							</select>
						</p>
						<br>
						<div align="center">
							<p class="forgot-password" align="center">
								<button type="submit">Register</button>
								&nbsp;&nbsp;&nbsp;
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