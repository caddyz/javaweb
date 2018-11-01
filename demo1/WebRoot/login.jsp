<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<!-- <form action="control" method="get"> -->
		用户名：<input type="text" name="name"/><br>
		密码：<input type="password" name="password"/><br>
		<input type="checkbox" name="remember" value="yes"/>记住密码<br>
		<input type="button" value="登录">
		<!-- <p><a href="register.jsp">注册</a><a href="retrieve.jsp">找回密码</a><p>   -->     
	<!-- </form> -->
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(":button").click(function(){
				$.ajax({
					url:'MainServlet',
					type:'post',
					dataType:'json',
					data:{
						name:$(":text").val(),
						password:$(":password").val()
					},
					success:function(data){
						if(data.exist==true){
							self.location = "admin.jsp";
						}else{
							alert("用户名或密码错误");
						}
					}
				});
			});
		});
	</script>
</body>
</html>