<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
	var teacherName = '';
	var time = '';
	var url = '../manage/findPortaitProject';
	if($("#teacherName").val() == ""){
		//0代表没输
		teacherName = "0";
	}else{
		teacherName = $("#teacherName").val();
	}
	if($("#time").val() == ""){
		time = "0";
	}else{
		time = $("#time").val();
	}
	url = url + '?teacherName='+teacherName+'&&time='+time; 
	$("#grid").datagrid("load",url);
}
</script>
</head>
<body>
<form id="select">
	查询教师名：<input type="text" id="teacherName" name="teacherName">
	完成时间在此之前：<input type="date" id="time" name="time">
	<a href="#" onclick="javascript:loads()">按条件查询</a>
</form>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],url:'../manage/findPortaitProject?teacherName=0&&time=0'">
    <thead>
		<tr>
			<th data-options="field:'portaitProjectBianMa'" width="8%">项目编号</th>
			<th data-options="field:'portaitProjectName'" width="8%">项目名称</th>
			<th data-options="field:'portaitProjectSource'" width="8%">项目来源</th>
			<th data-options="field:'portaitProjectType'" width="8%">项目类型</th>
			<th data-options="field:'portaitProjectMoney'" width="5%">支持经费</th>
			<th data-options="field:'portaitProjectAchieveTime'" width="8%">完成时间</th>
			<th data-options="field:'portaitProjectEmcee'" width="8%">主持人</th>
			<th data-options="field:'portaitProjectPartake'" width="20%">主要参与人</th>
			<th data-options="field:'portaitProjectPrize'" width="7%">是否获奖</th>
			<th data-options="field:'portaitProjectPrizeLevel'" width="10%">获奖级别</th>
			<th data-options="field:'portaitProjectPrizeTime'" width="10%">获奖时间</th>
		</tr>
    </thead>
</table>
</body>
</html>