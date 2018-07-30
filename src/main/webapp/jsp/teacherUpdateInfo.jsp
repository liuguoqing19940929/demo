<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="">
<input type="text" id="teacherName" name="teacherName" readonly="readonly">
<input type="text" id="teacherBianHao" name="teacherBianHao" readonly="readonly">
<input type="" id="gender" name="gender">
<input type="date" id="birthday" name="birthday">
<input type="text" id="address" name="address">
<input type="text" id="phone" name="phone">
</form> -->
<form action="../teacher/updatePassword" method="post">
		<div class="fitem">
			<label>教师姓名:</label>
			<input id="teacherName" name="teacherName" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" readonly="readonly"/>
		</div>
		<div class="fitem">
			<label>教师编号:</label>
			<input id="teacherBianHao" name="teacherBianHao" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" readonly="readonly"/>
		</div>
		<div class="fitem">
			<label>教师性别:</label>
			<input id="gender" name="gender" type="radio" value="FEMALE" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />女
			<input id="gender" name="gender" type="radio" value="MALE" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />男
		</div>
		<div class="fitem">
			<label>出生日期:</label>
			<input id="birthday" name="birthday" type="date" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>教师住址:</label>
			<input id="address" name="address" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>联系方式:</label>
			<input id="phone" name="phone" type="number" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<input type="submit" value="提交">
<!-- <a href="#" onclick="javascript:updatePassword()">提交</a> -->
<input type="reset" value="重置">
</form>
</body>
</html>