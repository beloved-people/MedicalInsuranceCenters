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
<title>药品信息展示</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js" charset="utf-8"></script>
</head>
<body >
   <div class="container-fluid">
       <header>
        <nav class="navbar nav-pills navbar-fixed-top nav-top">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">${sessionScope.operator.operatorName }<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="OperatorSelf" target="_self"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>帮助</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <aside class="sidenav-main">
        <div class="brand-sidebar">
            <h1 class="logo-wapper">
                <a href="#" class="brand-logo">
                    <span class="brand-text">医疗保险中心系统</span>
                </a>
            </h1>
            <ul class="sidenav ps" style="transform: translateX(0px);">
                <li class="bold">
                    <a class="collapsible-header" id="menu1">
                        <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        <span class="menu-title">医保中心报销</span>
                        <span class="badge badge pill orange float-right mr-10">3</span>
                    </a>
                    <div class="collapsible-body" id="menu-ul">
                        <ul class="list-group" >
                            <li class="list-group-item" data-id="person-query">人员信息查询</li>
                  <!-- <li class="list-group-item">入院信息和处方明细信息维护</li> -->          
                            <li class="list-group-item" data-id="calculation">费用计算及打印清单</li>
                            <li class="list-group-item" data-id="disease">病种信息维护</li>
                        </ul>
                    </div>
                </li>
                <li class="bold">
                    <a class="collapsible-header" id="menu2">
                        <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        <span class="menu-title">信息查询</span>
                        <span class="badge badge pill orange float-right mr-10">3</span>
                    </a>
                    <div class="collapsible-body" id="menu-ul2">
                        <ul class="list-group" >
                            <li class="list-group-item" data-id="drug-info">药品信息维护</li> 
              <!--               <li class="list-group-item" data-id="diagnosis-treatment-project">诊疗项目信息维护</li>-->
                            <li class="list-group-item" data-id="service-facility">服务设施信息维护</li>
                            <li class="list-group-item" data-id="designated-medical-institutions">定点医疗机构信息维护</li>                      
              <!-- <li class="list-group-item" data-id="dayin">医疗待遇计算参数信息维护</li> -->              
                        </ul>
                    </div>
                </li>
                <li class="bold">
                    <a class="collapsible-header" id="menu3">
                        <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        <span class="menu-title">医疗基本信息维护</span>
                        <span class="badge badge pill orange float-right mr-10">2</span>
                    </a>
                    <div class="collapsible-body" id="menu-ul3">
                        <ul class="list-group">
                            <li class="list-group-item" data-id="add-unit-info">单位基本信息维护</li>
                            <li class="list-group-item" data-id="add-person">个人基本信息维护</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </aside>
       <main id="main">
          <div class="row">
             <h3 class="col-md-12">药品信息维护</h3>
           <ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">药品信息展示</li>
			</ol>
          </div>
          <div class="row">
			       <div class="col-md-12">
			          <h4 class="text-left">药品信息详单</h4>
			          <div>
			           <form class="form-inline" action="DrugInfo1Servlet" method="post">
			              <div class="form-group">
			                <label for="dc">药品编码</label>
			                <input type="text" class="form-control" name="dc" id="dc" value="${param.dc }">	                 
			             </div>
			             <div class="form-group">
			                <label for="medicineName">药品名称</label>
			                <input type="text" class="form-control"  name="medicineName" id="medicineName" value="${param.medicineName }">
			            </div>
			                <button type="submit" class="btn btn-default form-top-right">全部查询</button>
			           </form>
			          </div>
			          <div class="table-responsive">
			             <table class="table table-hover table-striped" id="datatable-responsive">
			                <thead>
			                   <tr>
			                   	  <th>序号</th>
					              <th>药品编码</th>
					              <th>药品名称</th>
					              <th>英文名称</th>
					              <th>收费类别</th>
					              <th>处方药标志</th>
					              <th>收费项目等级</th>
					              <th>药品剂量单位</th>
					              <th>最高限价</th>
					              <th>院内制剂标志</th>
					              <th>是否需要审批标志</th>
					              <th>医院等级</th>
					              <th>剂型</th>
					              <th>使用频次</th>
					              <th>用法</th>
					              <th>单位</th>
					              <th>规格</th>
				               	  <th>限定天数</th>
					              <th>药品商品名</th>
					              <th>药厂名称</th>
					              <th>国药准字</th>
					              <th>备注</th>
					              <th>国家目录编码</th>
					              <th>限制使用范围</th>
					              <th>产地</th>
					              <th>操作</th>
				              </tr>
			                </thead>
			                 <tbody>
			                    <c:forEach items="${pb.list}" var="DrugInfo"  varStatus="x" begin="0">
				                     <tr>
				                         <td>${x.index+1}</td>
				                         <td>${DrugInfo.dc}</td>
				                         <td>${DrugInfo.medicineName}</td>
				                         <td>${DrugInfo.medicineEnglishName}</td>
				                         <td>${DrugInfo.chargeCategory}</td>
				                         <td>${DrugInfo.prescriptionDrugMark}</td>
				                         <td>${DrugInfo.chargingItemLevel}</td>
				                         <td>${DrugInfo.drugDosageUnit}</td>
				                         <td>${DrugInfo.maximumPrice}</td>
				                         <td>${DrugInfo.inHospitalPreparationMark}</td>
				                         <td>${DrugInfo.approvalMarkRequired}</td>
				                         <td>${DrugInfo.hospitalLevel}</td>
				                         <td>${DrugInfo.dosageFormId}</td>
				                         <td>${DrugInfo.usageFrequencyId}</td>
				                         <td>${DrugInfo.usageId}</td>
				                         <td>${DrugInfo.unit}</td>
				                         <td>${DrugInfo.specification}</td>
				                         <td>${DrugInfo.limitedDays}</td>
				                         <td>${DrugInfo.drugTradeName}</td>
				                         <td>${DrugInfo.pharmaceuticalFactory}</td>
				                         <td>${DrugInfo.chineseMedicineQuasiCharacter}</td>
				                         <td>${DrugInfo.remarks}</td>
				                         <td>${DrugInfo.nationalCatalogCode}</td>
				                         <td>${DrugInfo.restrictedUsingScope}</td>
				                         <td>${DrugInfo.placeOfProduction}</td>
				                         <td><a href="DrugInfodelServlet?dc=${DrugInfo.dc}" class="btn btn-default btn-sm" type="button" onclick="toDelete()">删除</a>
				                         <a href="#"  class="btn btn-default btn-sm" type="button" data-toggle="modal" data-target="#myModal" id="${x.index+1}" onclick="update(this)">修改</a>
				                         </td>
				                      </tr>
				                 </c:forEach>
			                 </tbody>
			             </table>
			          </div>
			       </div>
			       <nav aria-label="Page navigation">
			           <ul class="pagination pager" style="float:right;">
			              <c:if test="${pb.currentPage ==1}">
			                  <li class="previous disabled">				 
					    	      <a href="#">
					        	    <span aria-hidden="true">&larr;</span>Older
					              </a>
				               </li>
			              </c:if>
			              
				    <c:forEach begin="1" end="${pb.totalPage }" var="i">
				       <c:if test="${pb.currentPage==i }">   
				       <li class="active">
							<a href="${pageContext.request.contextPath}/DrugInfo1Servlet?currentPage=${i}&rows=5&dc=${condition.dc[0]}&medicineName=${condition.medicineName[0]}">${i}</a>
				       	</li>
				       </c:if>   
				       <c:if test="${pb.currentPage!=i }">      
				       <li>
				       		<a href="${pageContext.request.contextPath}/DrugInfo1Servlet?currentPage=${i}&rows=5&dc=${condition.dc[0]}&medicineName=${condition.medicineName[0]}">${i}</a>
				       	</li>
				       </c:if> 
				    </c:forEach>
				    <c:if test="${pb.currentPage==pb.totalPage}">
				    	<li class="next disabled">
				    		<a href="#">Newer <span aria-hidden="true">&rarr;</span></a>
				    	</li>
				    </c:if>
				    <c:if test="${pb.currentPage!=pb.totalPage}">
					    <li class="next">
					      	<a href="${pageContext.request.contextPath}/DrugInfo1Servlet?currentPage=${pb.currentPage+1 }&rows=5&dc=${condition.dc[0]}&medicineName=${condition.medicineName[0]}">
					        Newer <span aria-hidden="true">&rarr;</span>
					      </a>
					    </li>
					</c:if>			
			           </ul>
			           <span class="label label-info" style="float: left;margin-top: 30px;">
				  	共
				  	<c:choose>
				  		<c:when test="${pb.totalCount==null}">0</c:when>
				  		<c:otherwise>${pb.totalCount}</c:otherwise>
				  	</c:choose>
				  	条数据,共
				  	<c:choose>
				  		<c:when test="${pb.totalPage==null}">0</c:when>
				  		<c:otherwise>${pb.totalPage}</c:otherwise>
				  	</c:choose>
				  	页
			       </span>
			      </nav>      
			    </div>
			<!-- 模态框 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			    <div class="modal-dialog" role="document">
			       <div class="modal-content">
			           <div class="modal-header">
			              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			              <h4 class="modal-title" id="exampleModalLabel">修改</h4>
			           </div>
			            <form action="DrugInfoModfiyServlt" method="post" class="form-horizontal">
			               <div class="modal-body">
			                  <div class="form-group">
			               <label for="DrugCode1" class="col-sm-2 control-label">药品编码</label>
			               <div class="col-sm-3">
				              <input type="text" class="form-control" id="DrugCode1" placeholder="药品编码" disabled="disabled">
				              <input type="hidden" name="dc" class="form-control" id="DrugCode2" placeholder="药品编码" required="required">
				           </div>
				           <label for="Nameofdrug" class="col-sm-2 control-label">药品名称</label>
			               <div class="col-sm-3">
				              <input type="text" name="medicineName" class="form-control" id="Nameofdrug" placeholder="药品名称" required="required">
				           </div>
			             </div>
			             <div class="form-group">
			               <label for="medicineEnglishName" class="col-sm-2 control-label">英文名称</label>
			               <div class="col-sm-3">
				              <input type="text" name="medicineEnglishName" class="form-control" id="medicineEnglishName" placeholder="英文名称" required="required">
				           </div>
				             <label for="category" class="col-sm-2 control-label">收费类别</label>
			               <div class="col-sm-3">
				               <select class="form-control" name="chargeCategory" id="category" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">甲类</option>
				      	            <option value="2">乙类</option>
				      	            <option value="3">丙类</option>
				                </select>
				           </div>
			             </div>
			              <div class="form-group">
			                 <label for="prescriptionDrug" class="col-sm-2 control-label">处方药标志</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="prescriptionDrugMark" id="prescriptionDrug" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">处方药(RX)</option>
				      	            <option value="2">非处方药(OTC)</option>
				             </select>
				           </div>
				             <label for="inputChargingItemLevel" class="col-sm-2 control-label">收费项目等级</label>
			               <div class="col-sm-3">
				               <select class="form-control" name="chargingItemLevel" id="inputChargingItemLevel" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">甲类(全额报销)</option>
				      	            <option value="2">乙类(50%报销)</option>
				      	            <option value="3">丙类(全额自费)</option>
				                </select>
				           </div>
			             </div>
			             <div class="form-group">
			                <label for="drugDosageUnit" class="col-sm-2 control-label">药品剂量单位</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="drugDosageUnit" id="drugDosageUnit" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">kg</option>
								    <option value="2">g</option>
								    <option value="3">mg</option>
								    <option value="4">μg</option>
								    <option value="5">l</option>
								    <option Value="6">ml</option>
				             </select>
				           </div>
				              <label for="maximumPrice" class="col-sm-2 control-label">最高限价</label>
				           <div class="col-sm-3">
				              <input type="text" name="maximumPrice" class="form-control" id="maximumPrice" placeholder="最高限价" required="required">
				            </div>
				           
			             </div>
			             <div class="form-group">
			                 <label for="inHospitalPreparationMark" class="col-sm-2 control-label">院内制剂标志</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="inHospitalPreparationMark" id="inHospitalPreparationMark" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">是</option>
								    <option value="2">否</option>
				              </select>
				           </div>
				             <label for="approvalMark" class="col-sm-2 control-label">是否需要审批标志</label>
			               <div class="col-sm-3">
				               <input type="text" name="approvalMarkRequired" class="form-control" id="approvalMark" value="是" required="required">
				           </div>
				         </div>
				         <div class="form-group">
			                 <label for="hospitalLev" class="col-sm-2 control-label">医院等级</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="hospitalLevel" id="hospitalLev" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">一级医院</option>
								    <option value="2">二级医院</option>
								    <option value="3">三级医院</option>
								    <option value="4">社区医院(全部医院)</option>
				              </select>
				           </div>
				             <label for="dosageFormId" class="col-sm-2 control-label">剂型</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="dosageFormId" id="dosageFormId" required="required">
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
				             <label for="usageFrequencyId" class="col-sm-2 control-label">使用频次</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="usageFrequencyId" id="usageFrequencyId" required="required">
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
				            <label for="usageId" class="col-sm-2 control-label">用法</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="usageId" id="usageId" required="required">
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
				            <label for="unit" class="col-sm-2 control-label">单位</label>
			               <div class="col-sm-3">
				              <select class="form-control" name="unit" id="unit" required="required">
				      	            <option>请选择</option>
				      	            <option value="1">盒</option>
							    	<option value="2">支</option>
								    <option value="3">瓶</option>
							    	<option value="4">袋</option>
								    <option value="5">张</option>
				              </select>
				           </div>
				              <label for="specification" class="col-sm-2 control-label">规格</label>
			               <div class="col-sm-3">
				              <input type="text" name="specification" class="form-control" id="specification" placeholder="规格" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <label for="limitedDays" class="col-sm-2 control-label">限定天数</label>
			               <div class="col-sm-3">
				              <input type="text" name="limitedDays" class="form-control" id="limitedDays" placeholder="限定天数" required="required">
				           </div>
				              <label for="drugTradeName" class="col-sm-2 control-label">药品商品名</label>
			               <div class="col-sm-3">
				              <input type="text" name="drugTradeName" class="form-control" id="drugTradeName" placeholder="药品商品名" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <label for="pharmaceuticalFactory" class="col-sm-2 control-label">药厂名称</label>
			               <div class="col-sm-3">
				              <input type="text" name="pharmaceuticalFactory" class="form-control" id="pharmaceuticalFactory" placeholder="药厂名称" required="required">
				           </div>
				              <label for="chineseMedicineQuasiCharacter" class="col-sm-2 control-label">国药准字</label>
			               <div class="col-sm-3">
				              <input type="text" name="chineseMedicineQuasiCharacter" class="form-control" id="chineseMedicineQuasiCharacter" placeholder="国药准字" required="required">
				           </div>
				         </div>
				          <div class="form-group">
				            <label for="remarks" class="col-sm-2 control-label">备注</label>
			               <div class="col-sm-3">
				              <input type="text" name="remarks" class="form-control" id="remarks" placeholder="备注" required="required">
				           </div>
				              <label for="nationalCatalogCode" class="col-sm-2 control-label">国家目录编码</label>
			               <div class="col-sm-3">
				              <input type="text" name="nationalCatalogCode" class="form-control" id="nationalCatalogCode" placeholder="国家目录编码" required="required">
				           </div>
				         </div>
				          <div class="form-group">
				            <label for="restrictedUsingScope" class="col-sm-2 control-label">限制使用范围</label>
			               <div class="col-sm-3">
				              <input type="text" name="restrictedUsingScope" class="form-control" id="restrictedUsingScope" placeholder="限制使用范围" required="required">
				           </div>
				              <label for="placeOfProduction" class="col-sm-2 control-label">产地</label>
			               <div class="col-sm-3">
				              <input type="text" name="placeOfProduction" class="form-control" id="placeOfProduction" placeholder="产地" required="required">
				           </div>
				         </div>
				         <div class="form-group">
				            <div class="col-sm-offset-2 col-sm-10">
				              <button type="submit" class="btn btn-primary btn-block" onclick="modify()">修改</button>
				            </div>
				        </div>
			               </div>
			            </form>
			       </div>
			    </div>
			</div>
       </main>
       <div>
	<c:choose>
		<c:when test="${msgs eq '修改成功' }">
			<script>
 					alert("修改成功！");
 			</script>
		</c:when>
		<c:when test="${msgs eq '修改失败' }">
			<script>
 					alert("修改失败！");
 			</script>
		</c:when>
		<c:otherwise>
			<script></script>
		</c:otherwise>
	</c:choose>
</div>	
   </div>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
function toDelete(){
		confirm('你确定要删除吗?')
}

	function modify(){
		confirm('你确定要修改吗?')
	}

</script>
<script type="text/javascript">
	    $('#menu-ul').hide()
	    $('#menu-ul2').hide()
	    $('#menu-ul3').hide()
	    $('#menu1').click(function () {
	        $('#menu-ul').toggle(600)
	    })
	    $('#menu2').click(function () {
	        $('#menu-ul2').toggle(600)
	    })
	    $('#menu3').click(function () {
	        $('#menu-ul3').toggle(600)
	    })
</script>
<script type="text/javascript">
	$("#menu-ul").on("click", "li", function() {
	    var sId = $(this).data("id")//获取data-id的值
	    window.location.hash = sId //设置锚点
	    loadInner(sId)
	})
	function loadInner(sId) {
        var sId = window.location.hash
        var pathn, i
        switch(sId) {
            case "#person-query":
                pathn = "PersonInfoPaging"
                i = 0
                $("#main").load(pathn)
                break
            case "#calculation":
                pathn = "Dayin.jsp"
                i = 1
                $("#main").load(pathn)
                break
            default:
                pathn = "Disease.jsp"
                i = 2
                $("#main").load(pathn)
                break
        }
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
</script>
<script type="text/javascript">
	$("#menu-ul2").on("click", "li", function() {
	    var sId = $(this).data("id")//获取data-id的值
	    window.location.hash = sId //设置锚点
	    loadInner2(sId)
	})
	function loadInner2(sId) {
        var sId = window.location.hash
        var pathn, i
        switch(sId) {
            case "#drug-info":
                pathn = "DrugInfo1.jsp"
                i = 0
                $("#main").load(pathn)
                break
            case "#diagnosis-treatment-project":
                pathn = "DiagnosisAndTreatmentProject.jsp"
                i = 1
                $("#main").load(pathn)
                break
            case "#service-facility":
                pathn = "ServiceFacility.jsp"
                i = 2
                $("#main").load(pathn)
                break
            case "#designated-medical-institutions":
                pathn = "DesignatedMedicalInstitutions.jsp"
                i = 3
                $("#main").load(pathn)
                break
            default:
                pathn = "Dayin.jsp"
                i = 4
                $("#main").load(pathn)
                break
        }
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
</script>
<script type="text/javascript">
	$("#menu-ul3").on("click", "li", function() {
	    var sId = $(this).data("id")//获取data-id的值
	    window.location.hash = sId //设置锚点
	    loadInner3(sId)
	})
	function loadInner3(sId) {
        var sId = window.location.hash
        var pathn, i
        switch(sId) {
            case "#add-unit-info":
                pathn = "AddUnitInfo.jsp"
                i = 0
                $("#main").load(pathn)
                break
            default:
                pathn = "AddPersonnel.jsp"
                i = 1
                $("#main").load(pathn)
                break
        }
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
</script>
   <script type="text/javascript">
   function update(obj){
		var id = $(obj).attr("id")	
		var dc = document.getElementById("datatable-responsive").rows[id].cells[1].innerText
		var medicineName = document.getElementById("datatable-responsive").rows[id].cells[2].innerText  	
		var medicineEnglishName = document.getElementById("datatable-responsive").rows[id].cells[3].innerText
		var chargeCategory = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
		var prescriptionDrugMark = document.getElementById("datatable-responsive").rows[id].cells[5].innerText 
		var chargingItemLevel = document.getElementById("datatable-responsive").rows[id].cells[6].innerText
		var drugDosageUnit = document.getElementById("datatable-responsive").rows[id].cells[7].innerText
		var maximumPrice = document.getElementById("datatable-responsive").rows[id].cells[8].innerText
		var inHospitalPreparationMark = document.getElementById("datatable-responsive").rows[id].cells[9].innerText
		var approvalMarkRequired = document.getElementById("datatable-responsive").rows[id].cells[10].innerText
		var hospitalLevel = document.getElementById("datatable-responsive").rows[id].cells[11].innerText
		var dosageFormId = document.getElementById("datatable-responsive").rows[id].cells[12].innerText
		var usageFrequencyId = document.getElementById("datatable-responsive").rows[id].cells[13].innerText
		var usageId = document.getElementById("datatable-responsive").rows[id].cells[14].innerText
		var unit = document.getElementById("datatable-responsive").rows[id].cells[15].innerText
		var specification = document.getElementById("datatable-responsive").rows[id].cells[16].innerText
		var limitedDays = document.getElementById("datatable-responsive").rows[id].cells[17].innerText
		var drugTradeName = document.getElementById("datatable-responsive").rows[id].cells[18].innerText
		var pharmaceuticalFactory = document.getElementById("datatable-responsive").rows[id].cells[19].innerText
		var chineseMedicineQuasiCharacter = document.getElementById("datatable-responsive").rows[id].cells[20].innerText
		var remarks = document.getElementById("datatable-responsive").rows[id].cells[21].innerText
		var nationalCatalogCode = document.getElementById("datatable-responsive").rows[id].cells[22].innerText
		var restrictedUsingScope = document.getElementById("datatable-responsive").rows[id].cells[23].innerText
		var placeOfProduction = document.getElementById("datatable-responsive").rows[id].cells[24].innerText
		$('#DrugCode1').val(dc)
		$('#DrugCode2').val(dc)
		$('#Nameofdrug').val(medicineName)
		$('#medicineEnglishName').val(medicineEnglishName)
		$('#category').val(chargeCategory)
		$('#prescriptionDrug').val(prescriptionDrugMark)
		$('#inputChargingItemLevel').val(chargingItemLevel)
		$('#drugDosageUnit').val(drugDosageUnit)
		$('#maximumPrice').val(maximumPrice)
		$('#inHospitalPreparationMark').val(inHospitalPreparationMark)
		$('#approvalMark').val(approvalMarkRequired)
		$('#hospitalLev').val(hospitalLevel)
		$('#dosageFormId').val(dosageFormId)
		$('#usageFrequencyId').val(usageFrequencyId)
		$('#usageId').val(usageId)
		$('#unit').val(unit)
		$('#specification').val(specification)
		$('#limitedDays').val(limitedDays)
		$('#drugTradeName').val(drugTradeName)
		$('#pharmaceuticalFactory').val(pharmaceuticalFactory)
		$('#chineseMedicineQuasiCharacter').val(chineseMedicineQuasiCharacter)
		$('#remarks').val(remarks)
		$('#nationalCatalogCode').val(nationalCatalogCode)
		$('#restrictedUsingScope').val(restrictedUsingScope)
		$('#placeOfProduction').val(placeOfProduction)
} 
   </script>
   
</body>
</html>