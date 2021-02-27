<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%> 
<%@page import="com.neuedu.entity.DrugInfo"  %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>药品信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js" charset="utf-8"></script>
</head>
<body>
<div class="container-fluid">
<main id="main" style="padding:0;">
        <div class="row">
           <h3 class="col-md-12">药品信息维护</h3>
           <ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">药品信息添加</li>
  				<li><a href="DrugInfo1Servlet">药品信息展示</a></li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-left">添加药品信息</h4>
				<form action="DrugInfoServlet" method="post" class="form-horizontal">
			        <div class="form-group">
			             <label for="inputProjectdc" class="col-sm-1 control-label">药品编码</label>
			               <div class="col-sm-5">
				              <input type="text" name="dc" class="form-control" id="dc" placeholder="药品编码，以1结尾" required="required">
				           </div>
				           <label for="inputProjectName" class="col-sm-1 control-label">药品名称</label>
			               <div class="col-sm-5">
				              <input type="text" name="medicineName" class="form-control" id="medicineName" placeholder="药品名称" required="required">
				           </div>
			         </div>
			             <div class="form-group">
			               <label for="inputProjectEnglishName" class="col-sm-1 control-label">英文名称</label>
			               <div class="col-sm-5">
				              <input type="text" name="medicineEnglishName" class="form-control" id="medicineEnglishName" placeholder="英文名称" required="required">
				           </div>
				             <label for="inputProjectCategory" class="col-sm-1 control-label">收费类别</label>
			               <div class="col-sm-5">
				               <select class="form-control" name="chargeCategory" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">甲类</option>
				      	            <option value="2">乙类</option>
				      	            <option value="3">丙类</option>
				                </select>
				           </div>
			             </div>
			              <div class="form-group">
			                 <label for="inputProjectEnglishDrugMark" class="col-sm-1 control-label">处方药标志</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="prescriptionDrugMark" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">处方药(RX)</option>
				      	            <option value="2">非处方药(OTC)</option>
				             </select>
				           </div>
				             <label for="inputProjectItemLevel" class="col-sm-1 control-label">收费项目等级</label>
			               <div class="col-sm-5">
				               <select class="form-control" name="chargingItemLevel" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">甲类(全额报销)</option>
				      	            <option value="2">乙类(50%报销)</option>
				      	            <option value="3">丙类(全额自费)</option>
				                </select>
				           </div>
			             </div>
			             <div class="form-group">
				                <label for="inputProjectUnit" class="col-sm-1 control-label">药品剂量单位</label>
				               <div class="col-sm-5">
					              <select class="form-control" name="drugDosageUnit" required="required">
					      	            <option>请选择</option>
					      	            <option value="1">kg</option>
									    <option value="2">g</option>
									    <option value="3">mg</option>
									    <option value="4">μg</option>
									    <option value="5">l</option>
									    <option Value="6">ml</option>
					             </select>
					           </div>
					              <label for="inputProjectPrice" class="col-sm-1 control-label">最高限价</label>
					           <div class="col-sm-5">
					              <input type="text" name="maximumPrice" class="form-control" id="inputProjectCode" placeholder="最高限价" required="required">
					            </div>				           
			             </div>
			             <div class="form-group">
				                 <label for="inputProjectPreparationMark" class="col-sm-1 control-label">院内制剂标志</label>
				               <div class="col-sm-5">
					              <select class="form-control" name="inHospitalPreparationMark" required="required">
					      	            <option>请选择</option>
					      	            <option value="1">是</option>
									    <option value="2">否</option>
					              </select>
					           </div>
					             <label for="inputProjectRequired" class="col-sm-1 control-label">是否需要审批标志</label>
				               <div class="col-sm-5">
					               <input type="text" name="approvalMarkRequired" class="form-control" id="approvalMarkRequired" value="是" required="required">
					           </div>
				         </div>
				         <div class="form-group">
			                 <label for="inputProjectLevel" class="col-sm-1 control-label">医院等级</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="hospitalLevel" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">一级医院</option>
								    <option value="2">二级医院</option>
								    <option value="3">三级医院</option>
								    <option value="4">社区医院(全部医院)</option>
				              </select>
				           </div>
				             <label for="inputProjectId" class="col-sm-1 control-label">剂型</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="dosageFormId" required="required">
				      	            <option>请选择</option>
				      	            <option value="01">注射剂</option>
							        <option value="02">溶液剂</option>
							        <option value="03">散剂 </option>
							        <option value="04">片剂 </option>
							        <option value="05">丸剂 </option>
							        <option value="06"> 气雾剂</option>
							        <option value="07">软膏剂 </option>
							        <option value="08">乳化剂 </option>
							        <option value="09">泼淋剂</option>
							        <option value="10">胶囊剂 </option>
							        <option value="11">中药汤剂 </option>
							        <option value="12">酊剂 </option>
				              </select>
				           </div>
				         </div>
				         <div class="form-group">
				             <label for="inputProjectFrequencyId" class="col-sm-1 control-label">使用频次</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="usageFrequencyId" required="required">
				      	            <option>请选择</option>
				      	            <option value="01">qd</option>
							        <option value="02">bid</option>
							        <option value="03">tid</option>
							        <option value="04">qid </option>
							        <option value="05">qod</option>
						    	    <option value="06">qw</option>
							        <option value="07">biw </option>
							        <option value="08">tiw</option>
							        <option value="09">qow</option>
							        <option value="10">2w</option>
							        <option value="11">3w </option>
							        <option value="12">4w </option>
							        <option value="13">q1/2h</option>
							        <option value="14">qh</option>
							        <option value="15">q2h </option>
							        <option value="16">q3h </option>
							        <option value="17">q4h </option>
							        <option value="18">q6h</option>
							        <option value="19">q8h</option>
							        <option value="20">q12h </option>
							        <option value="21">st</option>
				              </select>
				           </div>
				            <label for="inputProjectusageId" class="col-sm-1 control-label">用法</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="usageId" required="required">
				      	            <option>请选择</option>
				      	           <option value="01">po</option>
							    <option value="02">ivdrip</option>
							    <option value="03">im</option>
							    <option value="04">iv </option>
							    <option value="05">ih</option>
							    <option value="06">ip</option>
							    <option value="07">sig </option>
							    <option value="08">ext</option>
							    <option value="09">in</option>
							    <option value="10">ig</option>
							    <option value="11">pr </option>
							    <option value="12">ac </option>
							    <option value="13">pc</option>
							    <option value="14">am</option>
							    <option value="15">pm </option>
							    <option value="16">om </option>
							    <option value="17">on </option>
							    <option value="18">hs</option>
							    <option value="19">sos</option>
							    <option value="20">prn </option>  
				              </select>
				           </div>
				         </div>
				         <div class="form-group">
				            <label for="inputProjectunit" class="col-sm-1 control-label">单位</label>
			               <div class="col-sm-5">
				              <select class="form-control" name="unit" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">盒</option>
							    	<option value="2">支</option>
								    <option value="3">瓶</option>
							    	<option value="4">袋</option>
								    <option value="5">张</option>
				              </select>
				           </div>
				              <label for="inputProjectspecification" class="col-sm-1 control-label">规格</label>
			               <div class="col-sm-5">
				              <input type="text" name="specification" class="form-control" id="specification" placeholder="规格" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <label for="inputProjectlimitedDays" class="col-sm-1 control-label">限定天数</label>
			               <div class="col-sm-5">
				              <input type="text" name="limitedDays" class="form-control" id="limitedDays" placeholder="限定天数" required="required">
				           </div>
				              <label for="inputProjectdrugTradeName" class="col-sm-1 control-label">药品商品名</label>
			               <div class="col-sm-5">
				              <input type="text" name="drugTradeName" class="form-control" id="drugTradeName" placeholder="药品商品名" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <label for="inputProjectpharmaceuticalFactory" class="col-sm-1 control-label">药厂名称</label>
			               <div class="col-sm-5">
				              <input type="text" name="pharmaceuticalFactory" class="form-control" id="pharmaceuticalFactory" placeholder="药厂名称" required="required">
				           </div>
				              <label for="inputProjectchineseMedicineQuasiCharacter" class="col-sm-1 control-label">国药准字</label>
			               <div class="col-sm-5">
				              <input type="text" name="chineseMedicineQuasiCharacter" class="form-control" id="chineseMedicineQuasiCharacter" placeholder="国药准字" required="required">
				           </div>
				         </div>
				          <div class="form-group">
				            <label for="inputProjectremarks" class="col-sm-1 control-label">备注</label>
			               <div class="col-sm-5">
				              <input type="text" name="remarks" class="form-control" id="remarks" placeholder="备注" required="required">
				           </div>
				              <label for="inputProjectnationalCatalogCode" class="col-sm-1 control-label">国家目录编码</label>
			               <div class="col-sm-5">
				              <input type="text" name="nationalCatalogCode" class="form-control" id="nationalCatalogCode" placeholder="国家目录编码" required="required">
				           </div>
				         </div>
				          <div class="form-group">
				            <label for="inputProjectrestrictedUsingScope" class="col-sm-1 control-label">限制使用范围</label>
			               <div class="col-sm-5">
				              <input type="text" name="restrictedUsingScope" class="form-control" id="restrictedUsingScope" placeholder="限制使用范围" required="required">
				           </div>
				              <label for="inputProjectplaceOfProduction" class="col-sm-1 control-label">产地</label>
			               <div class="col-sm-5">
				              <input type="text" name="placeOfProduction" class="form-control" id="placeOfProduction" placeholder="产地" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <div class="col-sm-offset-1 col-sm-10">
				              <button type="submit" class="btn btn-primary btn-block" onclick="addDiagnosisAndTreatmentProject()" >提交</button>
				            </div>
				        </div>		             
			       </form>
			       </div>
			    </div>
	</main>
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
</div>	    
 <script type="text/javascript">
 function addDiagnosisAndTreatmentProject(){
		confirm('你确定要提交吗?')
	}
 </script>
  
</body>
</html>