<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
function loads(){
	var studentMatchName = '';
	var teacherName = '';
	var url = '../manage/findStudentMatch';
	if($("#studentMatchName").val() == ""){
		studentMatchName = "0";
	}else{
		studentMatchName = $("#studentMatchName").val();
	}
	if($("#teacherName").val() == ""){
		teacherName = "0";
	}else{
		teacherName = $("#teacherName").val();
	}
	url = url + '?studentMatchName='+studentMatchName+'&&teacherName='+teacherName; 
	$("#grid").datagrid("load",url);
}
</script>
</head>
<body>
<form id="select">
	指导学生大赛名称：<input type="text" id="studentMatchName" name="studentMatchName">
	指导老师名：<input type="text" id="teacherName" name="teacherName">
	<a href="#" onclick="javascript:loads()">按条件查询</a>
</form>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],
		url:'../manage/findStudentMatch?studentMatchName=0&&teacherName=0'">
    <thead>
		<tr>
			<th data-options="field:'studentMatchName'" width="10%">学生大赛名称</th>
			<th data-options="field:'studentMatchLevel'" width="10%">学生大赛级别</th>
			<th data-options="field:'studentMatchStudentName'" width="10%">参加学生名</th>
			<th data-options="field:'studentMatchPrize'" width="10%">是否获奖</th>
			<th data-options="field:'studentMatchPrizeTime'" width="10%">获奖时间</th>
			<th data-options="field:'studentMatchPrizeLevel'" width="10%">获奖级别</th>
			<th data-options="field:'teacherName'" width="10%">指导老师</th>
		</tr>
    </thead>
</table>
</body>
</html>