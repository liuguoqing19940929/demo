<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师信息</title>
<script type="text/javascript" src="../jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function updatePassword(){
	$.ajax({
		type : 'post',
		url : '../teacher/updatePassword',
		dataType : "json",
		data: {
			oldPassword : $("#oldPassword").val(),
			newPassword : $("#newPassword").val(),
			confirmPassword : $("#confirmPassword").val()
		}/* $("form").serialize() */,
		success : function(result){
			alert("success");
			alert(result.teacherId);
		},
		error : function(){
			alert("error");
		}
		
	})
}
</script>
</head>
<body>
欢迎${nowTeacher.teacherName}登录教师管理系统 
<form action="../teacher/updatePassword">
			<input id="" name="" type="hidden" value="${nowTeacher.teacherPassword} ">
	旧密码：<input id="oldPassword" name ="oldPassword" type="password"><br>
	新密码：<input id="newPassword" name ="newPassword" type="password"><br>
	确认新密码：<input id="confirmPassword" name ="confirmPassword" type="password"><br>
	<a href="#" onclick="updatePassword()">更新密码</a><br>
	<input type="submit" value="提交"><br>
</form>
</body>
</html>