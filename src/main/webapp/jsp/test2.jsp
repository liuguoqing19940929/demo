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
function sub(){
	alert("111");
	var formData = new FormData($("#f1")[0]);
	  $.ajax({ 
	         async: true,//要求同步 不是不需看你的需求
	         url : "../teacher/test",  
	         type : 'POST',  
	         data : formData,  
	         processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
	         contentType : false,  //必须false才会自动加上正确的Content-Type 
	         success : function(result) {  
	        	 alert("success");
	                /* if(result==1){
	                    forward=true;
	                }else{
	             
	                }  */
	         },  
	         error : function(result) {  
	        	 alert("error");
	           
	         }  
	     });  
	    
}
</script>
</head>
<body>
<form action="" id="f1" enctype="multipart/form-data" method="post">
<input id="id1" name="id1"/>
<input type="file" id="file" name="file">
<a href="#" onclick="javascript:sub()">11</a>
</form>
</body>
</html>