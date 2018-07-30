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
	var printName = '';
	var printFirstAuthor = '';
	var url = '../manage/findPrint';
	if($("#printName").val() == ""){
		printName = "0";
	}else{
		printName = $("#printName").val();
	}
	if($("#printFirstAuthor").val() == ""){
		printFirstAuthor = "0";
	}else{
		printFirstAuthor = $("#printFirstAuthor").val();
	}
	url = url + '?printName='+printName+'&&printFirstAuthor='+printFirstAuthor; 
	$("#grid").datagrid("load",url);
}
</script>
</head>
<body>
<form id="select">
	出版物名称：<input type="text" id="printName" name="printName">
	出版作者：<input type="text" id="printFirstAuthor" name="printFirstAuthor">
	<a href="#" onclick="javascript:loads()">按条件查询</a>
</form>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],
		url:'../manage/findPrint?printName=0&&printFirstAuthor=0'">
    <thead>
		<tr>
			<th data-options="field:'printName'" width="10%">出版物名称</th>
			<th data-options="field:'printBianMa'" width="10%">出版物编码</th>
			<th data-options="field:'printType'" width="10%">出版物级别</th>
			<th data-options="field:'printTime'" width="10%">出版时间</th>
			<th data-options="field:'printPress'" width="10%">出版社</th>
			<th data-options="field:'printFirstAuthor'" width="10%">第一作者</th>
		</tr>
    </thead>
</table>
</body>
</html>