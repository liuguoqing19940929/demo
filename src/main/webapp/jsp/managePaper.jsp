<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论文</title>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function loads(){
	var teacherName = '';
	var time = '';
	var paperName = '';
	var url = '../manage/findPaper';
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
	if($("#paperName").val() == ""){
		paperName = "0";
	}else{
		paperName = $("#paperName").val();
	}
	url = url + '?paperAuthor='+teacherName+'&&time='+time+'&&paperName='+paperName; 
	$("#grid").datagrid("load",url);
}

</script>
</head>
<body>
<form id="select">
	论文名：<input type="text" id="paperName" name="paperName">
	论文作者：<input type="text" id="teacherName" name="teacherName">
	发表时间在此之前：<input type="date" id="time" name="time">
	<a href="#" onclick="javascript:loads()">按条件查询</a>
</form>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],
		url:'../manage/findPaper?paperName=0&&time=0&&paperAuthor=0'">
    <thead>
		<tr>
			<th data-options="field:'paperName'" width="8%">论文名称</th>
			<th data-options="field:'paperBianMa'" width="8%">论文编码</th>
			<th data-options="field:'paperLevel'" width="8%">论文级别</th>
			<th data-options="field:'paperTime'" width="8%">论文发表时间</th>
			<th data-options="field:'paperAuthor'" width="8%">作者</th>
			<th data-options="field:'paperPrize'" width="8%">是否获奖</th>
			<th data-options="field:'paperPrizeLevel'" width="8%">获奖级别</th>
			<th data-options="field:'paperPrizeTime'" width="8%">获奖时间</th>
		</tr>
    </thead>
</table>
</body>
</html>