<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function login1(){
	$.ajax({
		url:'../login/login1',
		type:'post',
		dataType:"json",
		data:{
			'loginName':$("#loginName").val(),
			'loginPassword':$("#loginPassword").val(),
			'role':$("input[name='role']:checked").val()
		},
		success : function(result){
			alert("success");
		},
		error : function(){
			alert("error");
		}
	})
}
</script>
</head>
<body>
${status}
<!-- <form action="../login/login" method="post">
登录名：<input type="text" id="loginName" name="loginName"><br>
密    码：<input type="password" id="loginPassword" name="loginPassword"><br>
权 限	<input type="radio" id="role" name="role" value="1">超级用户
	<input type="radio" id="role" name="role" value="2">普通教师<br>
<input type="submit" value="提交"><br>
<input type="reset" value="重置">
<a href="#" onclick="login1()">login</a>
</form> -->
<br><br><br><br><br><br><br><br><br><br>
<form action="../login/login" method="post">
<DIV class="top_div"></DIV>
<DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
	<DIV style="width: 165px; height: 96px; position: absolute;">
		<DIV class="tou"></DIV>
		<DIV class="initial_left_hand" id="left_hand"></DIV>
		<DIV class="initial_right_hand" id="right_hand"></DIV>
	</DIV>
	<P style="padding: 30px 0px 10px; position: relative;">
		<SPAN class="u_logo"></SPAN>         
		登录名：<INPUT class="ipt" id="loginName" name="loginName" type="text" placeholder="请输入登录名" value=""> 
    </P>
	<P style="position: relative;">
		<SPAN class="p_logo"></SPAN>         
		密   码：<INPUT class="ipt" id="loginPassword" name="loginPassword" type="password" placeholder="请输入密码" value="">   
  	</P>
  	<p >
  	<SPAN class="u_logo"></SPAN> 
	权 限:<input type="radio" id="role" name="role" value="1">超级用户
	<input type="radio" id="role" name="role" value="2">普通教师<br>
  	</p>
  	<p>
  	<input type="submit" value="提交">
	<input type="reset" value="重置">
  	</p>
	<!-- <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
		<P style="margin: 0px 35px 20px 45px;">
			<SPAN style="float: left;">
			 <A style="color: rgb(204, 204, 204);" href="#">忘记密码?</A>
			</SPAN> 
           <SPAN style="float: right;">
           	<A style="color: rgb(204, 204, 204); margin-right: 10px;" href="registeController">注册</A>  
            <A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152);
             border-image: none; color: rgb(255, 255, 255); font-weight: bold;" 
			href="javaScript:LoginJs()">登录</A> 
           </SPAN>         
        </P>
   </DIV> -->
</DIV>
</form>
<div style="text-align:center;">
</div>
</body>
</html>