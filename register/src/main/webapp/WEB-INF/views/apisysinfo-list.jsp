<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统信息</title>

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
					<h4 class="modal-title" id="myModalLabel">系统注册</h4>
				</div>
				<div class="modal-body" id="modalBody">
					<form class="form-inline" role="form" id="sysForm">
						<input type="hidden" id="id" name="id">
						<div class="form-group">
							<label for="sysName">系统名称</label> <input type="text"
								class="form-control" id="sysName" name="sysName">
						</div>
						<div class="form-group">
							<label for="sysRemark">系统简介</label> <input type="text"
								class="form-control" id="sysRemark" name="sysRemark">
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

		});

		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#tradeList').bootstrapTable({
					url : '${ctx}/apiSysInfo/list', //请求后台的URL（*）
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
					height : 560, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId : "id", //每一行的唯一标识，一般为主键列
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						radio : true
					}, {
						field : 'id',
						visible : false
					}, {
						field : 'sysName',
						title : '系统名称'
					}, {
						field : 'sysRemark',
						title : '系统简介'
					}, {
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
					}

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
					for ( var item in row) {
						//$("input[name="+item+"]").attr('value',row[item]);
						$("#sysForm input[name=" + item + "]").val(row[item]);
					}
				});

				$('#myModal').modal('show');

			} else {
				alert("请选中一行");
			}

		});

		$("#viewBtn").click(function() {
			$('#myModal').modal('show');
		});

		$("#formCommitBtn").click(function() {
			//向后台提交数据
			var jsonuserinfo = $('#sysForm').serializeObject();
			
			$.post("${ctx}/apiSysInfo/edit", jsonuserinfo, function(data) {
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
				$.get("${ctx}/apiSysInfo/del?id="+delId,function(data){
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
		//得到查询的参数
		/* oTableInit.queryParams = function (params) {
		      var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		          limit: params.limit,   //页面大小
		          offset: params.offset,  //页码
		          sdate: $("#stratTime").val(),
		          edate: $("#endTime").val(),
		          sellerid: $("#sellerid").val(),
		          orderid: $("#orderid").val(),
		          CardNumber: $("#CardNumber").val(),
		          maxrows: params.limit,
		          pageindex:params.pageNumber,
		          portid: $("#portid").val(),
		          CardNumber: $("#CardNumber").val(),
		          tradetype:$('input:radio[name="tradetype"]:checked').val(),
		          success:$('input:radio[name="success"]:checked').val(),
		      };
		      return temp;
		  };
		 */
		/*   oTableInit.queryParams = function (params) {
		      var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		          limit: params.limit,   //第几条记录
		          offset: params.offset,  //显示一页多少记录
		          sdate: $("#stratTime").val(),

		      };
		      return temp;
		  }; */
	</script>
</body>
</html>