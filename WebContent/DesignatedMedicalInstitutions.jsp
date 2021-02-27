<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>定点医疗机构信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
    <main id="main" style="padding:0;">
		<div class="row">
			<h3 class="col-md-12">定点医疗机构信息添加</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">定点医疗机构信息添加</li>
  				<li><a href="ShowDesignatedMedicalInstitutionsServlet" target="_self">定点医疗机构信息展示</a></li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
  			<div class="col-md-10">
  				<h4 class="text-left">添加定点医疗机构信息</h4>
  				<form class="form-horizontal" action="AddDesignatedMedicalInstitutionsServlet" method="post">
				  <div class="form-group">
				    <label for="inputDesignatedMedicalInstitutionCode" class="col-sm-2 control-label">定点医疗机构编号</label>
				    <div class="col-sm-10">
				      <input type="text" name="designatedMedicalInstitutionCode" class="form-control" id="inputDesignatedMedicalInstitutionCode" placeholder="定点医疗机构编号" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputServiceOrganizationName" class="col-sm-2 control-label">服务机构名称</label>
				    <div class="col-sm-10">
				      <input type="text" name="serviceOrganizationName" class="form-control" id="inputServiceOrganizationName" placeholder="服务机构名称" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputHospitalLevel" class="col-sm-2 control-label">医院等级</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="hospitalLevel" required="required">
				      	<option>请选择</option>
				      	<option value="1">一级医院</option>
				      	<option value="2">二级医院</option>
				      	<option value="3">三级医院</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputMedicalInstitutionTypeID" class="col-sm-2 control-label">医疗机构类别</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="medicalInstitutionTypeID" required="required" id="medicalInstitutionTypeID"> 
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPostcode" class="col-sm-2 control-label">邮政编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="postcode" class="form-control" id="inputPostcode" placeholder="邮政编码" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputIegalRepresentativeName" class="col-sm-2 control-label">法定代表人姓名</label>
				    <div class="col-sm-10">
				      <input type="text" name="legalRepresentativeName" class="form-control" id="inputIegalRepresentativeName" placeholder="法定代表人姓名" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputIegalRepresentativeCellphoneNumber" class="col-sm-2 control-label">法人代表移动电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="legalRepresentativeCellphoneNumber" class="form-control" id="inputIegalRepresentativeCellphoneNumber" placeholder="法人代表移动电话" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputConcatName" class="col-sm-2 control-label">联系人姓名</label>
				    <div class="col-sm-10">
				      <input type="text" name="concatName" class="form-control" id="inputConcatName" placeholder="联系人姓名" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputContactNumber" class="col-sm-2 control-label">联系电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="contactNumber" class="form-control" id="inputContactNumber" placeholder="联系电话" required="required">
				    </div>
				  </div>
				 <div class="form-group">
				    <label for="inputConcatCellphoneNumber" class="col-sm-2 control-label">联系人移动电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="concatCellphoneNumber" class="form-control" id="inputConcatCellphoneNumber" placeholder="联系人移动电话" required="required">
				    </div>
				  </div>
				<div class="form-group">
				    <label for="inputAddress" class="col-sm-2 control-label">地址</label>
				    <div class="col-sm-10">
				      <input type="text" name="address" class="form-control" id="inputAddress" placeholder="地址" required="required">
				    </div>
				  </div> 
				<div class="form-group">
				    <label for="inputRemarks" class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				      <input type="text" name="remarks" class="form-control" id="inputRemarks" placeholder="备注" required="required">
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
<script type="text/javascript">
	var medicalInstitutionType = ['综合医院、中医医院、中西医结合医院、民族医医院、专科医院、康复医院','妇幼保健院','中心卫生院、乡(镇)卫生院、街道卫生院','疗养院','综合门诊部、专科门诊部、中医门诊部、中西医结合门诊部、民族医门诊部',
		'诊所、中医诊所、民族医诊所、卫生所、医务室、卫生保健所、卫生站','村卫生室(所)','急救中心、急救站','临床检验中心',
		'专科疾病防治院、专科疾病防治所、专科疾病防治站','护理院、护理站','其他诊疗机构']
	var num = [
		"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
		"22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42",
		"43","45","46","47","48","49","50","51","52","53","54","55","56","57"
	]
	var id = document.getElementById('medicalInstitutionTypeID')
	id.length = medicalInstitutionType.length
	id.options[0].text='请选择'
	for(var i=1;i<id.length;i++){
		id.options[i].text = medicalInstitutionType[i-1];
		id.options[i].value = num[i-1];
	}
</script>
</body>
</html>