<!-- /******************************************************************************
 *  Purpose:	Login Registeration Form
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   12-07-2018
 *
 ******************************************************************************/ -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<link rel="stylesheet" href="login.css">
<script type="text/javascript">
	function validEmail() {
		var mail = document.myForm.mailId.value;
		var mailFormat = /^[a-zA-Z]+[a-zA-Z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
		console.log(mail);
		if (!mailFormat.test(mail)) {
			document.getElementById("email").innerHTML = "incorrect mail id";
			return false;
		} else {
			document.getElementById("email").innerHTML = "";
			return true;
		}
	}
</script>

</head>

<body>
	<div class="login">
		<h2>Welcome to User Login</h2>
		<br>
		<form action="HomeUrl" name="myForm" method="post">
			<table>
				<tr>
					<td>mail Id</td>
					<td><input type="text" onchange="validEmail()" name="mailId"
						id="mailId"></td>
				</tr>
				<tr>
					<td colspan="2"><span id="email" onchange="validEmail()"></span></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd" id="pwd"></td>
				</tr>
				<tr id="submit">
					<td><input type="submit" value="LOGIN"></td>
					<td><a href="RegisterUrl">Register here</a></td>
				</tr>
			</table>
		</form>

		<%
			String user = (String) session.getAttribute("mail");
			if (user != null) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}

			String msg = (String) request.getAttribute("loginError");
			if (msg != null) {
				out.println(msg);
			}
			
			String succesMsg = (String) request.getAttribute("succesMsg");
			if (succesMsg != null) {
				out.println(succesMsg);
			}
		%>
	</div>
</body>
</html>
