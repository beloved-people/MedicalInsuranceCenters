<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>医疗服务设施信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
    <main id="main" style="padding:0;">
		<div class="row">
			<h3 class="col-md-12">医疗服务设施信息添加</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">医疗服务设施信息添加</li>
  				<li><a href="ShowServiceFacilityServlet">医疗服务设施展示</a></li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
  			<div class="col-md-10">
  				<h4 class="text-left">添加诊疗项目信息</h4>
  				<form class="form-horizontal" action="AddServiceFacility" method="post">
				  <div class="form-group">
				    <label for="inputMedicalServiceFacilityCode" class="col-sm-2 control-label">医疗服务设施编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="medicalServiceFacilityCode" class="form-control" id="inputMedicalServiceFacilityCode" placeholder="医疗服务设施编码" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputServiceFacilitiesName" class="col-sm-2 control-label">医疗服务设施名称</label>
				    <div class="col-sm-10">
				      <input type="text" name="serviceFacilitiesName" class="form-control" id="inputServiceFacilitiesName" placeholder="医疗服务设施名称" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputChargeCategory" class="col-sm-2 control-label">收费类别</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="chargeCategory" required="required" disabled="disabled">
				      	<option>请选择</option>
				      	<option value="1" selected="selected">甲</option>
				      	<option value="2">乙</option>
				      	<option value="3">丙</option>
				      </select>
				    </div>
				  </div>
				<div class="form-group">
				    <label for="inputRemarks" class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				      <input type="text" name="remarks" class="form-control" id="inputRemarks" placeholder="备注">
				    </div>
				  </div>	
				  <div class="form-group">
				    <label for="inputRestrictedProjectUsingScope" class="col-sm-2 control-label">限制使用范围</label>
				    <div class="col-sm-10">
				      <input type="text" name="restrictedUsingScope" class="form-control" id="inputRestrictedUsingScope" placeholder="限制使用范围" required="required">
				    </div>
				  </div>		  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-primary btn-block" onclick="add()" >提交</button>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function add(){
		confirm('你确定要提交吗?')
	}
</script>
</body>
</html>