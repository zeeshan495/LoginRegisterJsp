<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
 <link rel="stylesheet" href="login.css">
<script type="text/javascript">
function validEmail()
{
  var mail=document.myForm.mailId.value;
  var mailFormat=/^[a-zA-Z]+[a-zA-Z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
  console.log(mail);
  if(!mailFormat.test(mail))
  {
  document.getElementById("email").innerHTML = "incorrect mail id";
  return false;
  }
  
  return true;
}
</script>
</head>
<body>
<div class="login">
<h2>Welcome to User Login</h2><br>
<form action="HomeUrl" name="myForm" method="get" onsubmit="return validEmail();">
<table>
<tr><td>mail Id </td><td><input type="text" name="mailId" id="mailId"></td></tr>
<tr><td colspan="2"><span id="email" ></span></td></tr>
<tr><td>Password </td><td><input type="password" name="pwd" id="pwd"></td></tr>
<tr id="submit"><td><input  type="submit" value="LOGIN"></td><td><a href="ResgisterUrl">Register</a></td></tr>
</table>
</form>
</div>
</body>
</html>
