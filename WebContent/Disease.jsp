<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>病种信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <main id="main" style="padding:0;">
		<div class="row">
			<h3 class="col-md-12">病种信息添加</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">病种信息添加</li>
  				<li><a href="ShowDisease">病种信息展示</a></li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
  			<div class="col-md-10">
  				<h4 class="text-left">添加病种信息</h4>
  				<form class="form-horizontal" action="AddDisease" method="post">
				  <div class="form-group">
				    <label for="inputDiseaseCode" class="col-sm-2 control-label">病种编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="diseaseCode" class="form-control" id="inputDiseaseCode" placeholder="病种编码" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputDiseaseName" class="col-sm-2 control-label">病种名称</label>
				    <div class="col-sm-10">
				      <input type="text" name="diseaseName" class="form-control" id="inputDiseaseName" placeholder="病种名称" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="diseaseType" class="col-sm-2 control-label">疾病种类</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="diseaseTypeId" required="required" id="diseaseType">
				      	<option>请选择</option>
				      	<option value="01">神经系统类</option>
				      	<option value="02">消化系统类</option>
				      	<option value="03">泌尿系统类</option>
				      	<option value="04">生殖系统类</option>
				      	<option value="05">循环系统类</option>
				      	<option value="06">内分泌系统类</option>
				      	<option value="07">运动系统类</option>
				      	<option value="08">呼吸系统类</option>
				      	<option value="09">其他</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="diseaseReimbursementSign" class="col-sm-2 control-label">病种报销标志</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="diseaseReimbursementSign" required="required" id="diseaseReimbursementSign">
				      	<option>请选择</option>
				      	<option value="1">可报销病种</option>
				      	<option value="2">不可报销病重</option>
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