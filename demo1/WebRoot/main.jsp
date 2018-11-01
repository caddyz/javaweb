<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<style type="text/css">
	table {
	width: 285px;border: 1px solid gray;border-collapse: collapse;
	}
	th,td{
		line-height: 55px;text-align: center;border: 1px solid gray;
	}
</style>
</head>
<body>
	
	<table>
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>电话</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr id="tr${user.uid}">
				<td>${user.uid}</td>
				<td>${user.uname}</td>
				<td>${user.pwd}</td>
				<td>${user.historyTotal}</td>
				<td>${user.historyCorrect}</td>
				<td><button onclick="deleted(${user.uid})">删除</button></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<c:if test="${pageNow>1}">
			<a href="main?num=1">首页</a><a href="main?num=${pageNow-1}">上一页</a>
		</c:if>
		
		<c:forEach items="${li}" var="inde">
			<a href="main?num=${inde}">第${inde}页</a>
		</c:forEach>
		
		<c:if test="${pageNow < page}">
			<a href="main?num=${pageNow+1}">下一页</a><a href="main?num=${page}">尾页</a>
		</c:if>
		跳转到<input type="number" id="skip"/>页 <button type="button" onclick="skip()">跳转</button>
	</p>
	<script type="text/javascript">
		function skip(){
			var nu = document.getElementById("skip").value;
			if(nu>0){
				self.location="main?num="+nu;
			}
		}
		function deleted(uid){
			$.ajax({
				url:"DeletedServlet",
				type:"post",
				dataType:"json",
				data:{
					uid:uid
				},
				success:function(data){
					if(data.deleted){
						$("#tr"+uid).remove();
					}
				}
			});
		}
	</script>
</body>
</html>