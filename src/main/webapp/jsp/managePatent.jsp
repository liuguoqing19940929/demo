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
	var patentStartTime = '';
	var patentEndTime = '';
	var teacherName = '';
	var url = '../manage/findPatent';
	
	if($("#patentEndTime").val() == ""){
		patentEndTime = "0";
	}else{
		patentEndTime = $("#patentEndTime").val();
	}
	if($("#patentStartTime").val() == ""){
		patentStartTime = "0";
	}else{
		patentStartTime = $("#patentStartTime").val();
	}
	if($("#patentName").val() == ""){
		patentName = "0";
	}else{
		patentName = $("#patentName").val();
	}
	url = url + '?patentName='+patentName+'&&patentBianMa='+patentBianMa+'&&patentStartTime='+patentStartTime+
			'&&patentEndTime='+patentEndTime+'&&teacherName='+teacherName; 
	$("#grid").datagrid("load",url);
}
</script>
</head>
<body>
<form id="select">
	生效时间：<input type="date" id="patentStartTime" name="patentStartTime">
	失效时间：<input type="date" id="patentEndTime" name="patentEndTime">
	专利申请人：<input type="text" id="teacherName" name="teacherName">
	<a href="#" onclick="javascript:loads()">按条件查询</a>
</form>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],
		url:'../manage/findPatent?patentStartTime=0&&patentEndTime=0&&teacherName=0'">
    <thead>
		<tr>
			<th data-options="field:'patentBianMa'" width="8%">专利号</th>
			<th data-options="field:'patentName'" width="8%">专利名</th>
			<th data-options="field:'patentType'" width="8%">专利类型</th>
			<th data-options="field:'patentStartTime'" width="8%">专利生效时间</th>
			<th data-options="field:'patentEndTime'" width="8%">专利失效时间</th>
			<th data-options="field:'teacherName'" width="8%">所属老师</th>
		</tr>
    </thead>
</table>
</body>
</html>