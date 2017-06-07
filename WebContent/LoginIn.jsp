<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="style.css">
  <script type="text/javascript"> 
function login(){ 
var userName=document.querySelector("[name=userName]").value; 
var pwd=document.querySelector("[name=pwd]").value; 
if(userName=="张三"&&pwd=="123456"){ 
matchResult=true; 
window.location.href = "index";
}else{
	alert("请确认用户名和密码是否正确！");
	document.querySelector("[name=userName]").value="";
	document.querySelector("[name=pwd]").value="";
	matchResult=false;
}
return matchResult; 
} 
</script> 
</head>
<body>

  
  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action="index.html">
        <p><input type="text" name="userName" value="" placeholder="用户名"></p>
        <p><input type="password" name="pwd" value="" placeholder="密码"></p>
        
        <p class="submit"><input type="button" name="commit" onclick="login()" value="登录"></p>
      </form>
    </div>

    
  </section>
</body>
</html>