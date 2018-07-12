<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="register.css">
<script type="text/javascript">
function validEmail()
{
  var mail=document.myForm.mail.value;
  var userName=document.myForm.uName.value;
  var fullName=document.myForm.fName.value;
  var password=document.myForm.Password.value;
  var repassword=document.myForm.Repassword.value;
  var mailFormat=/^[a-zA-Z]+[a-zA-Z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
  console.log(mail);
  if (userName.length>3 && fullName.length>3 && password.length>3 
    && password==repassword && mailFormat.test(mail)) {
    return true;
  }
  
  if(userName.length<3)
  {
    document.getElementById("uname").innerHTML="atleast 3 characters";
  }
  if(fullName.length<3)
  {
    document.getElementById("fname").innerHTML="atleast 3 characters";
  }
  if(password.length<3)
  {
    document.getElementById("pwd").innerHTML="atleast 3 characters";
  }
  if(password!=repassword)
  {
    document.getElementById("repwd").innerHTML="password does not match";
  }
  if(!mailFormat.test(mail))
    {
    document.getElementById("email").innerHTML = "incorrect mail id";
    }
    
    return false;
}
</script>
<title>Register</title>
</head>
<body>
<div class="register">
<h2>Welcome to User Registration</h2>
<form action="SaveUrl" name="myForm" method="post" onsubmit="return validEmail();">
<table>
<tr><td>UserName</td><td><input type="text" id="userName" name="uName" ></td></tr>
<tr><td colspan="2"><span id="uname" ></span></td></tr>
<tr><td>FullName</td><td><input type="text" id="fullName"name="fName"></td></tr>
<tr><td colspan="2"><span id="fname" ></span></td></tr>
<tr><td>Mail</td><td><input type="email" id="mailId" name="mail"></td></tr>
<tr><td colspan="2"><span id="email" ></span></td></tr>
<tr><td>Password</td><td><input type="password" name="Password"></td></tr>
<tr><td colspan="2"><span id="pwd" ></span></td></tr>
<tr><td>Retype_Password</td><td><input type="password" name="Repassword"></td></tr>
<tr><td colspan="2"><span id="repwd" ></span></td></tr>
 <tr><td><input type="submit" value="Register"></td></tr> 
</table>
</form>
</div>
</body>
</html>