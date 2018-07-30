<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成报表</title>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function submit1(){
	$.ajax({
		url:'../manage/export',
		data:{
			'project':$("#project").val(),
			'startTime':$("#startTime").val(),
			'endTime':$("#endTime").val()
		},
		success:function(){
		alert("success");	
		},
		error:function(){
			alert("error");
		}
	})
}
</script>
</head>
<body>
<form>
请选择科研项目：<select id="project" >
<option value="portaitProject">纵向项目申报</option>
<option value="crosswiseProject">横向项目申报</option>
<option value="paper">发表论文</option>
<option value="patent">申请专利</option>
<option value="print">出版物</option>
<option value="studentCreate">指导学生创新</option>
<option value="studentMatch">指导学生大赛</option>
</select><br>
科研项目时间段：开始时间<input type="date" id="startTime" >
		        结束时间<input type="date" id="endTime" >
<a href="#" onclick="javascript:submit1()">提交</a>
</form>
</body>
</html>