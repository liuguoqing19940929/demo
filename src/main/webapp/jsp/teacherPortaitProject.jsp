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
/**
 * 创建DataGrid控件，初始化表格
 */
function initDataGrid(){
	$('#grid').datagrid({  
		frozenColumns:[[//冻结列
		    {field:'ck',checkbox:true}
		]],
		toolbar:[{//工具栏
			text:'查看',//显示文字
			iconCls:'icon-search',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractViewLayout();
			}
		},'-',{//工具栏
			text:'新增',//显示文字
			iconCls:'icon-add',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractAddLayout();
			}
		},'-',{
			text:'编辑',//显示文字
			iconCls:'icon-edit',//显示图标
			plain:true,//是否为简洁效果
			handler: function(){//调用方法
				openContractEditLayout();
			}
		},'-',{
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
		height:600
	}); 
	//loadData();
}
/**
 * 打开合同信息查看的界面
 */
function openContractViewLayout(){
	var row = $('#grid').datagrid('getSelected');
	if (row){
		$('#dlg').dialog({
			title:'查看项目信息',
			modal:true
		});
		$('#fm').form('clear');
		$("#fm").form("load",row);//加载表单值
		$('#portaitProjectBianMa').attr("readonly", "readonly");//不可编辑
		$('#dlg-buttons').css("display","none");
		$('#dlg').dialog('open');
	}else{
		alert("请选择需要操作的数据");
	}	
}
/**
 * 打开合同信息添加的界面
 */
function openContractAddLayout(){
	$('#dlg').dialog({
		title:'新增项目信息',
		modal:true
	});
	$('#fm').form('clear');
	$('#portaitProjectBianMa').attr("readonly", false);//可编辑
	$('#dlg').dialog('open');
}
/**
 * 打开合同信息编辑界面 编辑时合同编码不可更改
 */
function openContractEditLayout(){
	var row = $('#grid').datagrid('getSelected');
	if (row){
		$('#dlg').dialog({
			title:'编辑项目信息',
			modal:true
		});
		$('#fm').form('clear');
		$("#fm").form("load",row);//加载表单值
		$('#portaitProjectBianMa').attr("readonly", "readonly");//不可编辑
		$('#dlg').dialog('open');
	}else{
		alert("请选择需要操作的数据");
	}	
}
/**
 *保存或更新合同信息数据
 */
function saveOrUpdateContract(){
	var formData = new FormData($("#fm2")[0]);
	var id = $("#portaitProjectId").val();
	var url = "";
	$.ajax({
		url:'../teacher/upFile',
		type:'POST',
		dataType:"json",
		data:formData,
		async: true,//要求同步 不是不需看你的需求
		processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
	    contentType : false,  //必须false才会自动加上正确的Content-Type
	    success:function(result){
	    	//alert(result.key);
	    	//alert("2success");
	    	$("#portaitProjectFuJian").val(result.key);
	    	var message = "";
			if(id==""){
				url = '../teacher/savePortaitProject';
				message = "保存"
			}else{
				url = '../teacher/updatePortaitProject';
				message = "更新";
			}
			alert(url);
			$.ajax({
				url:url,
				type:'POST',
				dataType:"json",
				data:$('#fm').serialize(),
				success:function(result){
					alert("success");
					initDataGrid();
				},
				error:function(){
					alert("请求服务器失败！");
				}
			});
	    },
	    error:function(){
	    	alert("2error");
	    }
	})
	//var formData = new FormData($("#fm")[0]);
	/* var message = "";
		if(id==""){
			url = '../teacher/savePortaitProject';
			message = "保存"
		}else{
			url = '../teacher/updatePortaitProject';
			message = "更新";
		}
		
		$.ajax({
			url:url,
			type:'POST',
			dataType:"json",
			data:$('#fm').serialize(),
			async: true,//要求同步 不是不需看你的需求
			//processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
	       // contentType : false,  //必须false才会自动加上正确的Content-Type 
			success : function(result){
				alert("success");
				$.ajax({
					url:'../teacher/upFile',
					type:'POST',
					dataType:"json",
					data:formData,
					async: true,//要求同步 不是不需看你的需求
					processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
				    contentType : false,  //必须false才会自动加上正确的Content-Type
				    success:function(){
				    	alert("2success");
						initDataGrid();
				    	
				    },
				    error:function(){
				    	alert("2error");
				    }
				});
			},
			error : function(){
				alert("error");
			}
		}) */
}
/**
 * 删除合同信息数据
 */
function deleteContract(){
	var rows = $('#grid').datagrid('getSelections');
	if (null != rows && rows.length>0){
		if(confirm("你确定要删除选中信息吗？")){
			var resultCount=0;
        	for (var i = 0; i < rows.length; i++) {
				var row = rows[i];
				$.ajax({
					url:'../teacher/deletePortaitProject',
					type:'post',
					dataType:"json",
					data:row,
					success : function(result){
						alert("success");
						initDataGrid();
					},
					error : function(){
						alert("error");
					}
				})
			}
		}
	}else {
    	alert("请先选择要操作的对象");
    }
}
/**
 * 页面加载调用
 */
$(document).ready( function() {
	initDataGrid();
});
function  linkFile(val,row){
	if(val == null || val == ""){
		return '';
	}
	return '<a href="'+val+'" target="_blank">附件</a>';

	}
</script>
</head>
<body>
<table class="easyui-datagrid" id="grid" data-options="pagination:'true',pageSize:5,pageNumber:1,pageList:[5,10,20],url:'../teacher/findPortaitProject'">
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
			<th data-options="field:'portaitProjectFuJian',formatter:linkFile" width="10%">附件</th>
			<!-- <th data-options="field:'portaitProjectPrizeTime'" width="10%">获奖时间</th> -->
		</tr>
    </thead>
</table>
<div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post" enctype="multipart/form-data">
		<div class="fitem">
			<input id="portaitProjectId" name="portaitProjectId" type="hidden"/>
		</div>
		<div class="fitem">
			<label style="width: 100px;text-align:right;">项目编号:</label>
			<input id="portaitProjectBianMa" name="portaitProjectBianMa" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目编号为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>项目名称:</label>
			<input id="portaitProjectName" name="portaitProjectName" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目名称为必输项" maxlength="30" />
		</div>
		<div class="fitem">
			<label>项目来源:</label>
			<input id="portaitProjectSource" name="portaitProjectSource" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="项目来源为必输项" maxlength="50" />
		</div>
		<div class="fitem">
			<label>项目类型:</label>
			<select id="portaitProjectType" class="easyui-combobox" name="portaitProjectType" style="width:200px;" data-options="required:true" missingMessage="项目类型为必选项">   
			    <option value="1">国防科研试验</option>   
			    <option value="2">863计划</option>   
			    <option value="3">国家自然科学基金</option>   
			    <option value="4">国家重点基础研究专项（973）经费</option>   
			    <option value="5">博士点专项科研基金</option>   
			</select> 
		</div>		
		<div class="fitem">
			<label>支持经费:</label>
			<input id="portaitProjectMoney" name="portaitProjectMoney" type="text" class="easyui-validatebox" data-options="required:true,validType:'numberDouble(2)'" missingMessage="支持经费为必输项" maxlength="50" />
		</div>
		<div class="fitem">
			<label>完成时间:</label>
			<input id="portaitProjectAchieveTime" name="portaitProjectAchieveTime" class="easyui-datetimebox" data-options="required:true,showSeconds:true" missingMessage="完成时间为必输项" maxlength="50" />
		</div>
		<div class="fitem">
			<label>主要参与人:</label>
			<input id="portaitProjectPartake" name="portaitProjectPartake" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="主要参与人为必输项" maxlength="50" />
		</div>
		<div class="fitem">
			<label>是否获奖:</label>
			<select id="portaitProjectPrize" class="easyui-combobox" name="portaitProjectPrize" style="width:200px;" data-options="required:true" missingMessage="是否获奖为必选项">   
			    <option value="1">是</option>   
			    <option value="0">否</option> 
			</select>
		</div>
		<div class="fitem">
			<label>获奖级别:</label>
			<select id="portaitProjectPrizeLevel" class="easyui-combobox" name="portaitProjectPrizeLevel" style="width:200px;">   
			    <option value="1">国家级</option>   
			    <option value="2">山东省级</option>   
			    <option value="3">泰安市级</option>   
			</select>
		</div>
		<div class="fitem">
			<label>获奖时间:</label>
			<input id="portaitProjectPrizeTime" name="portaitProjectPrizeTime" data-options="showSeconds:true" missingMessage="获奖时间为必输项" maxlength="50" />
		</div>
		<div class="fitem" style="display: none">
			<label>是否获奖:</label>
			<input id="portaitProjectFuJian" name="portaitProjectFuJian" >
		</div>
		<!-- <div class="fitem" >
			<label>上传文件:</label>
			<input id="upFile" name="upFile" type="file"  />
			<a href="upFile.jsp">上传文件</a>
		</div> -->
	</form>
	<form id="fm2" method="post" enctype="multipart/form-data">
		<div class="fitem">
			<label>上传附件:</label>
			<input id="file" name="file" type="file"  />
		</div>
	</form>
		<!-- <div class="fitem">
			<label>上传文件:</label>
			<input id="file" name="upFile" type="file"  />
		</div> -->
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveOrUpdateContract()">确认</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>
</html>