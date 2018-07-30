<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

function updatePassword(){
	$.ajax({
		url:'../teacher/updatePassword',
		type:'POST',
		dataType:"json",
		data:{
			'oldPassword':$("oldPassword").val(),
			'newPassword':$("newPassword").val(),
			'confirmPassword':$("confirmPassword").val()
		},
		success:function(result){
			alert("success");
		},
		error:function(){
			alert("请求服务器失败！");
		},
	})
}
</script>
</head>
<body>
${status}
<form action="../teacher/updatePassword" method="post">
		<div class="fitem">
			<label>旧密码:</label>
			<input id="oldPassword" name="oldPassword" type="password" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>新密码:</label>
			<input id="newPassword" name="newPassword" type="password" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>确认密码:</label>
			<input id="confirmPassword" name="confirmPassword" type="password" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<input type="submit" value="提交">
<!-- <a href="#" onclick="javascript:updatePassword()">提交</a> -->
<input type="reset" value="重置">
</form>
</body>
</html>