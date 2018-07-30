<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师信息</title>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function initDataGrid(){
	$('#grid').datagrid({  
		frozenColumns:[[//冻结列
		    {field:'ck',checkbox:true}
		]],
		toolbar:[/* {//工具栏
			text:'查看',//显示文字
			iconCls:'icon-search',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractViewLayout();
			}
		},'-', */{//工具栏
			text:'新增',//显示文字
			iconCls:'icon-add',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractAddTeacher();
			}
		}/* ,'-',{
			text:'编辑',//显示文字
			iconCls:'icon-edit',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractEditLayout();
			}
		} */,'-',{
			text:'删除',//显示文字
			iconCls:'icon-remove',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				deleteContract();
			}
		}],
		striped:true,//是否显示斑马线效果
		nowrap:true,//如果为true，则在同一行中显示数据。设置为true可以提高加载性能
		pagination:true,//是否分页
		pageNumber:1,//分页初始页
		rownumbers:true,//如果为true，则显示一个行号列
		singleSelect:false,//如果为true，则只允许选择一行
		pageSize:5,//设置分页属性的时候初始化页面大小
		pageList:[5,10,15,20,30],//在设置分页属性的时候 初始化页面大小选择列表
		//height:600
	}); 
	//loadData();
}
//添加教师
function openContractAddTeacher(){
	$('#dlg').dialog({
		title:'新增教师信息',
		modal:true
	});
	$('#fm').form('clear');
	$('#teacherBianHao').attr("readonly", false);//可编辑
	$('#dlg').dialog('open');
	
}
function saveTeacher(){
	$.ajax({
		url:'../manage/saveTeacher',
		type:'POST',
		dataType:"json",
		data:$('#fm').serialize(),
		async: true,//要求同步 不是不需看你的需求
	    success:function(result){
	    	alert("添加成功！");
	    	alert(result.key);
	    	initDataGrid();
	    },
	    error:function(){
	    	
	    }
	})
}

//删除教师
function deleteContract(){
	var rows = $('#grid').datagrid('getSelections');
	if (null != rows && rows.length>0){
		var resultCount=0;
    	for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			$.ajax({
				url:'../manage/deleteTeacher',
				type:'post',
				dataType:"json",
				data:row,
				success : function(result){
					alert("删除成功");
					initDataGrid();
				},
				error : function(){
					alert("error");
				}
			})
    	}
	} 
}

/**
 * 页面加载调用
 */
$(document).ready( function() {
	initDataGrid();
});
</script>
</head>
<body>
${addTeacher}
<!-- <form action="../manage/addTeacher" method="post" id="addTeacher">
	教师姓名：<input type="text" id="teacherName" name="teacherName"><br>
	教师编号：<input type="text" id="teacherBianHao" name="teacherBianHao"><br>
	教师登录密码：<input type="text" id="teacherPassword" name="teacherPassword"><br>
	教师性别：<input type="radio" id="gender1" name="gender" value="1">男
	<input type="radio" id="gender2" name="gender" value="0">女<br>
	教师出生日期：<input type="date" id="birthday" name="birthday"><br>
	教师手机号：<input type="number" id="phone" name="phone"><br>
	教师家庭住址：<input type="text" id="address" name="address"><br>
	<input type="submit" value="提交">
	<a href="#" onclick="javascript:addTeacher()">提交</a>
	<input type="reset" value="重置">
</form> -->
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],url:'../manage/findTeacher'">
    <thead>
		<tr>
			<th data-options="field:'teacherName'" width="20%">教师姓名</th>
			<th data-options="field:'teacherBianHao'" width="10%">教师编号</th>
			<th data-options="field:'gender'" width="8%">教师性别</th>
			<th data-options="field:'birthday'" width="10%">教师生日</th>
			<th data-options="field:'address'" width="20%">教师住址</th>			
			<!-- <th data-options="field:'portaitProjectMoney'" width="5%">支持经费</th>
			<th data-options="field:'portaitProjectAchieveTime'" width="8%">完成时间</th>
			<th data-options="field:'portaitProjectEmcee'" width="8%">主持人</th>
			<th data-options="field:'portaitProjectPartake'" width="20%">主要参与人</th>
			<th data-options="field:'portaitProjectPrize'" width="7%">是否获奖</th>
			<th data-options="field:'portaitProjectPrizeLevel'" width="10%">获奖级别</th>
			<th data-options="field:'portaitProjectFuJian',formatter:linkFile" width="10%">附件</th> -->
			<!-- <th data-options="field:'portaitProjectPrizeTime'" width="10%">获奖时间</th> -->
		</tr>
    </thead>
</table>
<div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" enctype="multipart/form-data">
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师姓名:</label>
			<input id="teacherName" name="teacherName" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目编号为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师编号:</label>
			<input id="teacherBianHao" name="teacherBianHao" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目编号为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师生日:</label>
			<input id="birthday" name="birthday" type="date" class="easyui-validatebox" data-options="required:true" missingMessage="项目编号为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师性别:</label>
			<select id="gender" class="easyui-combobox" name="gender" style="width:200px;" data-options="required:true" missingMessage="项目类型为必选项">   
			    <option value="MALE">男</option>   
			    <option value="FEMALE">女</option>   
			</select> 		
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师住址:</label>
			<input id="address" name="address" type="text" class="easyui-validatebox"  maxlength="30" />
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">教师电话:</label>
			<input id="phone" name="phone" type="text" class="easyui-validatebox" " maxlength="30" />
		</div>
		</form>
		</div>
		<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTeacher()">确认</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>
</html>