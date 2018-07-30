<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理界面</title>
</head>
<%request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");%>
<frameset rows="20%,*">
       		<frame src="../jsp/manageHeader.jsp" name="head" bordercolor="blue" frameborder="1">
       		<frameset cols="24%,*">
       			<frame src="../jsp/manageLeft.jsp" name="left" noresize="noresize">
       			<frame src="" name="right" noresize="noresize"  >
       		</frameset>
      </frameset>

</html>