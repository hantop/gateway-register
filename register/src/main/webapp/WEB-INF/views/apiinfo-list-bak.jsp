<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>api服务注册</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link href="${ctx}/static/css/bootstrap.min.css" media="all"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${ctx}/static/css/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${ctx}/static/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${ctx}/static/css/_all-skins.min.css">


<link href="${ctx}/static/css/fileinput.min.css" media="all"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/jquery-confirm.min.css"
	rel="stylesheet" type="text/css" />

</head>
<body style="background-color: #ecf0f5">
	<div class="content">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				api服务注册 <small></small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/ops/main"><i class="fa fa-dashboard"></i>
						Home</a></li>
				<li class="active">app</li>
			</ol>
		</section>

		<!-- Main content -->

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<div class="row">
					<div class="col-md-8">
						<!--                     <div class="col-md-4">
                        <div class="btn-group" role="group" aria-label="...">
                            <button onclick="javascript:window.location.reload()" type="button" class="btn btn-default">
                                刷新
                            </button>
                            <button onclick="javascript:history.back(-1);" type="button" class="btn btn-default">
                                后退
                            </button>
                            <button onclick="javascript:history.back(1)" type="button" class="btn btn-default">
                                前进
                            </button>

                        </div>
                    </div> -->
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-search"></i></span>
								<input type="text" class="form-control" id="loanAppName"
									name="loanAppName" maxlength="" value="${appName }"
									placeholder="根据app名称搜索...">
							</div>
						</div>
						<div class="col-md-4">
							<button type="button" onclick="loanAppfoReload();"
								class="btn btn-primary">搜索</button>
						</div>
					</div>
					<div class="col-md-4">
						<!-- 按钮触发模态框 -->
						<button class="btn btn-primary" onClick="add();">新增</button>
					</div>
				</div>
			</div>

			<!-- 如果用户列表非空 -->
			<table id="loanApp_tab" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>序号</th>
						<th>服务的名字</th>
						<th>服务唯一标识</th>
						<th>服务版本</th>
						<th>请求参数</th>
						<th>请求方法</th>
						<th>请求路径</th>
						<th>所属系统</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

	<script src="${ctxStatic}/js/jquery.min.js"
		type="text/javascript"></script>
	<script src="${ctxStatic}/js/bootstrap.min.js"
		type="text/javascript"></script>


	<script src="${ctxStatic}/js/fileinput.min.js"
		type="text/javascript"></script>
	<script src="${ctxStatic}/js/fileinput_locale_zh.js"
		type="text/javascript"></script>
	<script src="${ctxStatic}/js/jquery-confirm.min.js"></script>

	<script src="${ctxStatic}/js/clipboard.min.js"></script>
	<script
		src="${ctxStatic}/js/jquery.dataTables.js"></script>




	<script>
		var list_ajax;
		//当你需要多条件查询，你可以调用此方法，动态修改参数传给服务器
		window.reloadTable = function(oTable, premise) {
			var date = $(premise).val();
			var param = {
				"loanAppName" : date
			};
			oTable.settings()[0].ajax.data = param;
			oTable.ajax.reload();
		}

		var loanApp_tab;
		$(function() {

			//初始化表格
			var No = 0;
			loanApp_tab = $('#loanApp_tab')
					.DataTable(
							{
								"dom" : 'itflp',
								"processing" : true,
								"searching" : false,
								"serverSide" : true, //启用服务器端分页
								"bInfo" : false,
								"language" : {
									"url" : "${ctxStatic}/AdminLTE/plugins/datatables/language.json"
								},
								"ajax" : {
									"url" : "${ctx}/apiInfo/list",
									"type" : "post"
								},
								"columns" : [ {
									"data" : null
								}, {
									"data" : "apiName"
								}, {
									"data" : "apiId"
								}, {
									"data" : "apiVersion"
								}, {
									"data" : "apiParasName"
								}, {
									"data" : "apiReqMethod"
								}, {
									"data" : "apiUrl"
								}, {
									"data" : "apiSysInfoId"
								},

								{
									"data" : "createdAt"
								}, {
									"data" : null
								}

								],
								"columnDefs" : [
										{
											targets : 0,
											data : null,
											render : function(data) {
												No = No + 1;
												return No;
											}
										},
										/* 		{
												    targets: 5,
												    data: null,
												    render: function (data) {
												    	var btn;
												    	if(data.state == 0){
												    		btn = '<span class="badge bg-yellow">无效</span>';
												    	}else if (data.state == 1){
												    		btn = '<span class="badge bg-green">有效</span>';
												    	}else if (data.state == 2){
												    		btn = '<span class="badge bg-red">下架</span>';
												    	}
												    	return btn;
												    }
												},
												{
												    targets: 6,
												    data: null,
												    render: function (data) {
												    	var btn;
												    	if(data.hotState == 0){
												    		btn = '<span class="badge bg-yellow">无效</span>';
												    	}else if (data.hotState == 1){
												    		btn = '<span class="badge bg-green">有效</span>';
												    	}
												    	return btn;
												    }
												},
												{
												    targets: 7,
												    data: null,
												    render: function (data) {
												    	var btn;
												    	if(data.promoteState == 0){
												    		btn = '<span class="badge bg-yellow">无效</span>';
												    	}else if (data.promoteState  == 1){
												    		btn = '<span class="badge bg-green">有效</span>';
												    	}
												    	return btn;
												    }
												}, */
										{
											"targets" : 9,
											"data" : null,
											"render" : function(data) {
												var btn = '<input type="button" class="btn btn-primary" value="查看" onClick="show('+ data.id + ');" /> &nbsp;'
														+ '<a class="btn  btn-warning" target="_self" modal="lg" href="${ctx}/ops/loanApp/toUpdate?appId='
														+ data.id
														+ '">更新</a> &nbsp;'
														+ '<a class="btn  btn-danger" data-body="确认要下架吗？" callback="infoReload();" target="ajaxTodo" href="javascript:void(0)" onclick="dele('
														+ data.id + ')">删除</a>';
												return btn;
											}
										} ]
							}).on('preXhr.dt', function(e, settings, data) {
						No = 0;
					});
		});
		function loanAppfoReload() {
			reloadTable(loanApp_tab, "#loanAppName");
		}
		function add(){
			
			$('#myModal').modal('show');
		}
		function show(id) {
			
			$.post("${ctx}/apiInfo/view", { appId: id},
				function(data){
				if(data){
					$("#apiName").attr('value',data.apiName);
					$("#apiId").attr('value',data.apiId);
					$("#apiVersion").attr('value',data.apiVersion);
					$("#apiParasName").attr('value',data.apiParasName);
					$("#apiReqMethod").attr('value',data.apiReqMethod);
					$("#apiUrl").attr('value',data.apiUrl);
					$("#apiProtocol").attr('value',data.apiProtocol);
					$("#apiSysInfoId").attr('value',data.apiSysInfoId);
				}
			}		
			);
			$('#myModal').modal('show');
		
		}
		
		function modalHidden(){
		
			$("#apiName").attr('value',"");
			$("#apiId").attr('value',"");
			$("#apiVersion").attr('value',"");
			$("#apiParasName").attr('value',"");
			$("#apiReqMethod").attr('value',"");
			$("#apiUrl").attr('value',"");
			$("#apiProtocol").attr('value',"");
			$("#apiSysInfoId").attr('value',"");
			$('#myModal').modal('hide');
		}
		 
		function toUpdate(id) {
			//$.post("${ctx}/loanApp/toUpdate", { appId: id});
			window.location.href = "${ctx}/ops/loanApp/toUpdate?appId=" + id;
		}

		function dele(id) {
			if (!window.confirm('你确定要下架吗？')) {
				return;
			}
			var url = "${ctx}/ops/loanApp/delete";
			var params = {
				"appId" : id
			};

			//异步保存数据到库中
			$.post(url, params, function(data) {
				if (data == 1) {
					alert("下架成功");
					window.location.reload();
				} else if (data == 0) {
					alert("操作失败，稍后再试！");
				} else {
					alert("出现错误，稍后再试！");
				}

			}, "json");
		}

		$("#goLoanAppAdd").on('click', function() {
			window.location.href = "${ctx}/ops/loanApp/toAdd";
		});
	</script>


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
					<table>
						<tr>
								<td style="margin: 5px;">服务名字</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiName" id="apiName"></td>
								<td style="margin: 5px;">&nbsp;&nbsp;&nbsp;服务唯一标识</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiId" id="apiId"></td>
						</tr>
						<tr>
							    <td style="margin: 5px;">api版本</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiVersion" id="apiVersion"></td>
								<td style="margin: 5px;">&nbsp;&nbsp;&nbsp;请求参数</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiParasName" id="apiParasName"></td>
						</tr>
						
						<tr>
							    <td style="margin: 5px;">请求方法</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiReqMethod" id="apiReqMethod"></td>
								<td style="margin: 5px;">&nbsp;&nbsp;&nbsp;请求路径</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiUrl" id="apiUrl"></td>
						</tr>
						
						
						<tr>
							    <td style="margin: 5px;">所用协议</td><td><input class="form-control" style="margin: 5px;" type="text" name="apiProtocol" id="apiProtocol"></td>
								<td style="margin: 5px;">&nbsp;&nbsp;&nbsp;是否在线</td><td><input class="form-control" style="margin: 5px;" type="text" name="online" id="online"></td>
						</tr>
						
						
					</table>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" onClick="modalHidden();">关闭
					</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

</body>
</html>
