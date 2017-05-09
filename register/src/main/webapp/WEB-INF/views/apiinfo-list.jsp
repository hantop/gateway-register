<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>服务注册</title>

<link rel="stylesheet"
	href="${ctx}/static/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/static/css/bootstrap-table.min.css" />
	

	
	
<script type="text/javascript"
	src="${ctx}/static/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/js/bootstrap-table-zh-CN.js"></script>



	
<script type="text/javascript"
	src="${ctx}/static/js/form-serialize.js"></script>

<style type="text/css">
	.kong{
		margin-top:1em;
	}
	.juyou{
		float:right;
		margin-bottom:1em;
	}
</style>
</head>
<body>
<div class="kong"></div>
<div class="btn-group juyou">
	<button class="btn btn-primary" id="viewBtn">新增</button>
	<button class="btn btn-primary" id="editBtn">编辑</button>
	<button class="btn btn-primary" id="delBtn">删除</button>
</div>


	<table id="tradeList" class="mychar1-table"></table>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">服务注册</h4>
				</div>
				<div class="modal-body" id="modalBody">
					<form class="form-inline" role="form" id="sysForm">
						<input type="hidden" id="id" name="id">
						<div class="form-group">
							<label for="apiName">服务名称</label> <input type="text"
								class="form-control" id="apiName" name="apiName">
						</div>
						<div class="form-group">
							<label for="apiId">服务标识</label> <input type="text"
								class="form-control" id="apiId" name="apiId">
						</div>

						<div class="form-group">
							<label for="apiVersion">服务版本号</label> <input type="text"
								class="form-control" id="apiVersion" name="apiVersion">
						</div>

						<div class="form-group">
							<label for="apiParasName">服务入参</label> <input type="text"
								class="form-control" id="apiParasName" name="apiParasName">
						</div>												
						<div class="form-group">
							<label for="apiReqMethod">服务请求方法</label> <input type="text"
								class="form-control" id="apiReqMethod" name="apiReqMethod">
						</div>						
						<div class="form-group">
							<label for="fSysInfoId">服务所属系统</label> 
							<!--这里使用下拉框 -->
							<select  style="width:10em;" id="fSysInfoId" name="fSysInfoId">
							</select>
						</div>							
						<div class="form-group">
							<label for="apiUrl">服务调用路径</label> <input type="text"
								class="form-control" id="apiUrl" name="apiUrl">
						</div>	
						<div class="form-group">
							<label for="isOnline">是否在线</label> <input type="text"
								class="form-control" id="isOnline" name="isOnline">
						</div>	
						<div class="form-group">
							<label for="apiProtocol">调用协议</label> <input type="text"
								class="form-control" id="apiProtocol" name="apiProtocol">
						</div>							
						<div class="form-group">
							<label for="respParams">服务响应参数</label> <input type="text"
								class="form-control" id="respParams" name="respParams">
						</div>	
						<div class="form-group">
							<label for="respFormat">响应demo</label> <input type="text"
								class="form-control" id="respFormat" name="respFormat">
						</div>							
						<div class="form-group">
							<label for="host">服务器地址</label> <input type="text"
								class="form-control" id="host" name="host">
						</div>
						<input id="res" name="res" type="reset" style="display: none;" />
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="formCloseBtn">关闭
					</button>
					<button type="button" class="btn btn-primary" id="formCommitBtn">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<script type="text/javascript">
		$(function() {

			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();

			//2.初始化Button的点击事件
			/* var oButtonInit = new ButtonInit();
			oButtonInit.Init(); */

			$.get("${ctx}/apiSysInfo/queryAllSys",function(data){
				$("#fSysInfoId").append("<option value='' class='form-control'>请选择</option>");
				for(var i=0;i<data.length;i++){
					$("#fSysInfoId").append("<option class='form-control' value="+data[i].id+">"+data[i].sysName+"</option>");
				}
			
			}); 
		});

		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#tradeList').bootstrapTable({
					url : '${ctx}/apiInfo/list', //请求后台的URL（*）
					method : 'post', //请求方式（*）
					toolbar : '#toolbar', //工具按钮用哪个容器
					striped : true, //是否显示行间隔色
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, //是否显示分页（*）
					sortable : false, //是否启用排序
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*）
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber : 1, //初始化加载第一页，默认第一页
					pageSize : 10, //每页的记录行数（*）
					pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
					strictSearch : true,
					clickToSelect : true, //是否启用点击选中行
					height : 860, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId : "id", //每一行的唯一标识，一般为主键列
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						radio : true
					}, {
						field : 'id',
						visible : false
					}, {
						field : 'apiName',
						title : '服务名称'
					}, 
					 {
						field : 'apiParasName',
						title : '服务入参'
					}, 
					 {
						field : 'respParams',
						title : '服务响应参数'
					}, 
					
					{
						field : 'apiUrl',
						title : '服务请求路径'
					},
					
					 {
						field : 'apiReqMethod',
						title : '服务请求方法'
					}, 
					{
						field : 'apiId',
						title : '服务标识'
					}, 
					 {
						field : 'apiVersion',
						title : '服务版本号'
					}, 
					
					
					 
					 {
						field : 'respFormat',
						title : '服务响应demo'
					}, 
					{
						field : 'apiProtocol',
						title : '使用协议'
					}, 
					{
						field : 'host',
						title : '服务器地址'
					}, 
					
					{
						field : 'fSysInfoId',
						title : '服务所属系统'
					}	, {
						field : 'isOnline',
						title : '是否在线'
					}
				/* 	,
					
					
					{
						field : 'createdBy',
						title : '创建人'
					}, {
						field : 'createdAt',
						title : '创建时间'
					}, {
						field : 'updatedBy',
						title : '修改人'
					}, {
						field : 'updatedAt',
						title : '修改时间'
					} */

					]
				});
			};

			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //显示一页多少记录
					offset : params.offset, //第几条记录
				// sdate: $("#stratTime").val(),

				};
				return temp;
			};

			return oTableInit;
		};

		$("#editBtn").click(function() {
		 
			var a = $("#tradeList").bootstrapTable('getSelections');
			if (a.length == 1) {
				$.map(a, function(row) {
					for (var item in row) {
						 if ($("#sysForm select[id=" + item + "]").length>0){
							if(row[item]!=null)
							$("#sysForm select[id=" + item + "] option[value="+row[item].toString()+"]").attr("selected", true); 

						}
						else if($("#sysForm input[id=" + item + "]").length>0){
							$("#sysForm input[id=" + item + "]").val(row[item]);
						}
					}
				});

				$('#myModal').modal('show');

			} else {
				alert("请选中一行");
			}

		});

		$("#viewBtn").click(function() {

			//请求后端初始化下拉框
			$('#myModal').modal('show');
		});

		$("#formCommitBtn").click(function() {
			//向后台提交数据
			var jsonuserinfo = $('#sysForm').serializeObject();
			
			$.post("${ctx}/apiInfo/edit", jsonuserinfo, function(data) {
				//alert(data);
				if (data == 'ok') {

					$('#myModal').modal('hide');

					return true;
				}

			});
			cleanForm($("#sysForm"));
			//alert('测试一下，看是否自动刷新表格');
			$('#tradeList').bootstrapTable('refresh');
			return true;
		});

		$("#formCloseBtn").click(function() {
			// $("input[name='res']").click();
			cleanForm($("#sysForm"));
			$('#myModal').modal('hide');
			return true;
		});
		
		$("#delBtn").click(function(){
				
			var a = $("#tradeList").bootstrapTable('getSelections');
			if (a.length == 1) {
				var delId=$.map(a, function(row) {return row.id;});
					
				//alert('delId='+delId);
				$.get("${ctx}/apiInfo/del?id="+delId,function(data){
						if(data=='ok'){
							alert('删除成功');
							//alert('测试一下，看是否自动刷新表格');
							$('#tradeList').bootstrapTable('refresh');
						}else {
							alert(data);	
						}
						
					
				});
				
			} else {
				alert("请选中一行");
			}

		});
	
	</script>
</body>
</html>