<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/welcome.css" rel="stylesheet">
<script src="js/into.js" type="text/javascript" charset="utf-8"></script>
<script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var companyType = ["政府部门","院校","科研所","国有企业","集体企业","股份合作企业","联营企业",
"有限责任公司","股份有限公司","私营企业","港澳台商投资企业","外商投资企业","其他"];
var number = ["1","2","3","4","5","6","7","8","9","10","11","12","13"];
function into(){
	var com = document.getElementById("companyType");
	com.length = companyType.length;
	com.options[0].text = '请选择'
	for(var i=1;i<com.length;i++){
		com.options[i].text = companyType[i-1];
		com.options[i].value = number[i-1];
	}
}
</script>
</head>
<body onload="into()">
<div id="container-fluid" class="container-fluid">
	<main id="main" style="padding:0;">
	<div class="row">
		<h3 class="col-md-12">单位信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">单位信息添加</li>
  				<li><a href="QueryUnitInfo.jsp">单位信息查询</a></li>
			</ol>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
				<h4 class="text-left">添加人员信息</h4>
			<form action="AddUnitInfo" method="post" class="form-horizontal">			
			<div class="form-group">
				<label for="companyCode" class="col-sm-2 control-label" >单位编号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="companyCode" id="companyCode" />
				</div>
			</div>			
			<div class="form-group">
				<label for="companyName" class="col-sm-2 control-label">单位名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="companyName" name="companyName" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="companyType" class="col-sm-2 control-label">单位类型</label>
				<div class="col-sm-10">
					<select class="form-control"  name="companyType" id="companyType">
						<option>请选择</option>
						<option value="01">政府部门</option>
						<option value="02">院校</option>
						<option value="03">科研所</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="companyAddress" class="col-sm-2 control-label">地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="companyAddress" id="companyAddress" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="companyPostcode" class="col-sm-2 control-label">邮编</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="companyPostcode" id="companyPostcode" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="companyContactNumber" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="companyContactNumber" id="companyContactNumber" />
				</div>
			</div>
			<!-- 提交 -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-block" onclick="add()">提交</button>
				</div>
			</div>		
		</form>
		</div>
		<div class="col-md-1"></div>
	</div>
	</main>
</div>
<div>
	<c:choose>
		<c:when test="${msg eq '添加成功' }">
			<script>
 					alert("添加成功！");
 			</script>
		</c:when>
		<c:when test="${msg eq '添加失败' }">
			<script>
 					alert("添加失败！");
 			</script>
		</c:when>
		<c:otherwise>
			<script></script>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
var vm = new Vue({
	el:"#container-fluid",
	data:{
		
	}
})
</script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function add(){
		confirm('你确定要提交吗?')
	}
</script>
</body>
</html>