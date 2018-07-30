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
</head>
<script type="text/javascript">
function load(){
	$.ajax({
		url:'../login/update',
		type:'post',
		dataType:"json",
		data:{},
		success : function(result){
			alert("success");
		},
		error : function(){
			alert("error");
		}
	});
}
</script>
<body>
<form action="../login/add" method="post">
<input type="submit" value="11">
</form>
<form action="../login/update" method="post">
<input type="submit" value="11">
</form>
<a href="#" onclick="javascript:load()">11</a>
<form action="../teacher/upFile" enctype="multipart/form-data" method="post">
<input type="file" id="file" name="file">
<input type="submit" value="提交">
</form>

</body>
</html>