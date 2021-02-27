<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>诊疗项目信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	
    <main id="main">
		<div class="row">
			<h3 class="col-md-12">诊疗项目信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">诊疗项目信息</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
  			<div class="col-md-10">
  				<h4 class="text-left">添加诊疗项目信息</h4>
  				<form class="form-horizontal" action="AddDiagnosisAndTreatmentProjectServlet" method="post">
				  <div class="form-group">
				    <label for="inputProjectCode" class="col-sm-2 control-label">项目编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="projectCode" class="form-control" id="inputProjectCode" placeholder="项目编码" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputProjectName" class="col-sm-2 control-label">项目名称</label>
				    <div class="col-sm-10">
				      <input type="text" name="projectName" class="form-control" id="inputProjectName" placeholder="项目名称" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputChargeCategory" class="col-sm-2 control-label">收费类别</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="chargeCategory" required="required">
				      	<option>请选择</option>
				      	<option value="1">甲</option>
				      	<option value="2">乙</option>
				      	<option value="3">丙</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputChargingItemLevel" class="col-sm-2 control-label">收费项目等级</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="chargingItemLevel" required="required">
				      <option>请选择</option>
				      	<option value="1">甲</option>
				      	<option value="2">乙</option>
				      	<option value="3">丙</option>
				      </select>
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
				    <label for="inputProjectApprovalMarkRequired" class="col-sm-2 control-label">是否需要审批标志</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="projectApprovalMarkRequired" disabled="disabled">
				      	<option value="1" selected="selected">是</option>
				      	<option value="2">否</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputProjectUnit" class="col-sm-2 control-label">单位</label>
				    <div class="col-sm-10">
				      <input type="text" name="projectUnit" class="form-control" id="inputProjectUnit" placeholder="单位，例如：床日、次、两根血管" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputRestrictedProjectUsingScope" class="col-sm-2 control-label">限制使用范围</label>
				    <div class="col-sm-10">
				      <input type="text" name="restrictedProjectUsingScope" class="form-control" id="inputRestrictedProjectUsingScope" placeholder="限制使用范围" required="required">
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
				      <button type="submit" class="btn btn-primary btn-block" onclick="addDiagnosisAndTreatmentProject()" >提交</button>
				    </div>
				  </div>
				</form>
  			</div>
 			 <div class="col-md-1"></div>
		</div>
		
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h4 class="text-left">诊疗项目信息详单</h4>
				<div>
					<form class="form-inline" action="ShowDiagnosisAndTreatmentProjectServlet" method="post">
			            <div class="form-group">
			                <label for="username">项目编号</label>
			                <input type="text" class="form-control" value="${param.projectCode}" name="projectCode" id="projectCode">			                 
			            </div>
			            <div class="form-group">
			                <label for="birthplace">项目名称</label>
			                <input type="text" class="form-control" value="${param.projectName}" name="projectName" id="projectName">
			            </div>
			            <button type="submit" class="btn btn-default form-top-right">全部查询</button>
			        </form>
				</div>
				<div class="table-responsive">
				  <table class="table table-hover table-striped" id="datatable-responsive">
				  	<thead>
				    	<tr>
				    		<th>序号</th>
				    		<th>项目编码</th>
							<th>项目名称</th>
							<th>收费类别</th>
							<th>收费项目等级</th>
							<th>医院等级</th>
							<th>是否需要审批标志</th>
							<th>单位</th>
							<th>限制使用范围</th>
							<th>备注</th>	
							<th>操作</th>											    		
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach items="${pb.list}" var="DiagnosisAndTreatmentProjectInfo" varStatus="x" begin="0">
			                <tr>         
			                	<td>${x.index+1}</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.projectCode }</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.projectName}</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.chargeCategory == 1? "甲":(DiagnosisAndTreatmentProjectInfo.chargeCategory == 2? "乙":"丙")}</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.chargingItemLevel == 1? "甲":(DiagnosisAndTreatmentProjectInfo.chargingItemLevel == 2? "乙":"丙")}</td>
			                    <td>
			              			<c:choose>
			                    		<c:when test="${DiagnosisAndTreatmentProjectInfo.hospitalLevel == 1}">一级医院</c:when>
			                    		<c:when test="${DiagnosisAndTreatmentProjectInfo.hospitalLevel == 2}">二级医院</c:when>
			                    		<c:when test="${DiagnosisAndTreatmentProjectInfo.hospitalLevel == 3}">三级医院</c:when>
			                    		<c:otherwise>四级医院</c:otherwise>
			                    	</c:choose>       
								</td>
			                    <td>是</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.projectUnit}</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.restrictedProjectUsingScope}</td>
			                    <td>${DiagnosisAndTreatmentProjectInfo.remarks}</td>
			                    <td>
			                    	<a href="#" class="btn btn-default btn-sm" type="button" data-toggle="modal" data-target="#myModal" id="${x.index+1}" onclick="toUpdate(this)">修改</a>
			                           <a class="btn btn-default btn-sm"
			                            href="javascript:deleteDiagnosisAndTreatmentProject()">删除</a>
			     					<form action="DeleteDiagnosisAndTreatmentProjectServlet"  method="get" id="hi">
										<input type="hidden" class="form-control" value="${DiagnosisAndTreatmentProjectInfo.projectCode }" name="ids" id="ids">
										<input type="hidden" class="form-control" value="${param.projectCode}" name="projectCode" id="code">
										<input type="hidden" class="form-control" value="${param.projectName}" name="projectName" id="name">
									</form>
								</td>
			                </tr>
		            </c:forEach>
		            </tbody>
				  </table>
				</div>				
		    <div>
		<nav aria-label="Page navigation">
			  <ul class="pagination pager" style="float:right;">
			  	<c:if test="${pb.currentPage ==1}">
			  		<li class="previous disabled">				 
					    	<a href="#">
					        	<span aria-hidden="true">&larr;</span>Older
					        </a>
				    </li>
			  	</c:if>
			  	<c:if test="${pb.currentPage !=1}">
				    <li class="previous active">				 
				    	<a href="${pageContext.request.contextPath}/ShowDiagnosisAndTreatmentProjectServlet?currentPage=${pb.currentPage-1}&rows=5&projectCode=${condition.projectCode[0]}&projectName=${condition.projectName[0]}">
				        	<span aria-hidden="true">&larr;</span>Older
				      	</a>
				    </li>
				  </c:if>
				    <c:forEach begin="1" end="${pb.totalPage }" var="i">
				       <c:if test="${pb.currentPage==i }">   
				       <li class="active">
							<a href="${pageContext.request.contextPath}/ShowDiagnosisAndTreatmentProjectServlet?currentPage=${i}&rows=5&projectCode=${condition.projectCode[0]}&projectName=${condition.projectName[0]}">${i}</a>
				       	</li>
				       </c:if>   
				       <c:if test="${pb.currentPage!=i }">      
				       <li>
				       		<a href="${pageContext.request.contextPath}/ShowDiagnosisAndTreatmentProjectServlet?currentPage=${i}&rows=5&projectCode=${condition.projectCode[0]}&projectName=${condition.projectName[0]}">${i}</a>
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
					      	<a href="${pageContext.request.contextPath}/ShowDiagnosisAndTreatmentProjectServlet?currentPage=${pb.currentPage+1 }&rows=5&projectCode=${condition.projectCode[0]}&projectName=${condition.projectName[0]}" >
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
	      <form class="form-horizontal" action="UpdateDiagnosisAndTreatmentProjectServlet" method="post">
		      <div class="modal-body">
					  <div class="form-group">
					    <label for="inputProjectCode" class="col-sm-2 control-label">项目编码</label>
					    <div class="col-sm-10">
					      <input type="text" name="projectCode" class="form-control" id="pCode" placeholder="项目编码" disabled="disabled">
					      <input type="hidden" name="projectCode" class="form-control" id="pCodeForm"> <!--用于表单提交-->
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputProjectName" class="col-sm-2 control-label">项目名称</label>
					    <div class="col-sm-10">
					      <input type="text" name="projectName" class="form-control" id="pName" placeholder="项目名称" required="required">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputChargeCategory" class="col-sm-2 control-label">收费类别</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="chargeCategory" required="required" id="pChargeCategory">
					      	<option>请选择</option>
					      	<option value="1">甲</option>
					      	<option value="2" >乙</option>
					      	<option value="3" >丙</option>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputChargingItemLevel" class="col-sm-2 control-label">收费项目等级</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="chargingItemLevel" required="required" id="pChargingItemLevel">
					      	<option>请选择</option>
					      	<option value="1">甲</option>
					      	<option value="2">乙</option>
					      	<option value="3">丙</option>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputHospitalLevel" class="col-sm-2 control-label">医院等级</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="hospitalLevel" required="required" id="pHospitalLevel">
					      <option>请选择</option>
					      	<option value="1">一级医院</option>
					      	<option value="2">二级医院</option>
					      	<option value="3">三级医院</option>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputProjectApprovalMarkRequired" class="col-sm-2 control-label">是否需要审批标志</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="projectApprovalMarkRequired" disabled="disabled" id="pApprovalMarkRequired">
					      	<option value="1" selected="selected">是</option>
					      	<option value="2">否</option>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputProjectUnit" class="col-sm-2 control-label">单位</label>
					    <div class="col-sm-10">
					      <input type="text" name="projectUnit" class="form-control" id="pUnit" placeholder="单位，例如：床日、次、两根血管" required="required">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputRestrictedProjectUsingScope" class="col-sm-2 control-label">限制使用范围</label>
					    <div class="col-sm-10">
					      <input type="text" name="restrictedProjectUsingScope" class="form-control" id="pUsingScope" placeholder="限制使用范围" required="required">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputRemarks" class="col-sm-2 control-label">备注</label>
					    <div class="col-sm-10">
					      <input type="text" name="remarks" class="form-control" id="pRemarks" placeholder="备注">
					    </div>
					  </div>		
					  <div class="form-group">
					    <div class="col-sm-12">
					      <button type="submit" class="btn btn-primary btn-block" onclick="modifyDiagnosisAndTreatmentProject()" >修改</button>
					    </div>
					  </div>		  		
		      		</div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
	      </form>
	    </div>
	  </div>
	</div>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function deleteDiagnosisAndTreatmentProject(){
		if(confirm('你确定要删除吗?')){
			document.getElementById("hi").submit();//在表单里，一般都会指定表单的action：表单会把数据提交到action设定的页面。如果没有action，默认是提交给当前的页面。
		}
	}
	function addDiagnosisAndTreatmentProject(){
		confirm('你确定要提交吗?')
	}
	function modifyDiagnosisAndTreatmentProject(){
		confirm('你确定要修改吗?')
	}
</script>
<script type="text/javascript">
function toUpdate(obj){
			var id = $(obj).attr("id")	
			var projectCode = document.getElementById("datatable-responsive").rows[id].cells[1].innerText
			var projectName = document.getElementById("datatable-responsive").rows[id].cells[2].innerText  	
			var chargeCategory = document.getElementById("datatable-responsive").rows[id].cells[3].innerText
			var chargingItemLevel = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
			var hospitalLevel = document.getElementById("datatable-responsive").rows[id].cells[5].innerText	
			var projectUnit = document.getElementById("datatable-responsive").rows[id].cells[7].innerText
			var restrictedProjectUsingScope = document.getElementById("datatable-responsive").rows[id].cells[8].innerText  
			var remarks = document.getElementById("datatable-responsive").rows[id].cells[9].innerText
			$('#pCode').val(projectCode)
			$('#pCodeForm').val(projectCode)
			$('#pName').val(projectName)
			if(chargeCategory === '甲') {
				$('#pChargeCategory').val(1)
			} else if(chargeCategory === '乙') {
				$('#pChargeCategory').val(2)
			} else {
				$('#pChargeCategory').val(3)
			}	
			if(chargingItemLevel === '甲') {
				$('#pChargingItemLevel').val(1)		
			} else if(chargingItemLevel === '乙') {
				$('#pChargingItemLevel').val(2)		
			} else {
				$('#pChargingItemLevel').val(3)		
			}			
			if(hospitalLevel === '一级医院'){
				$('#pHospitalLevel').val(1)
			} else if(hospitalLevel === '二级医院'){
				$('#pHospitalLevel').val(2)
			} else {
				$('#pHospitalLevel').val(3)
			}
			$('#pUnit').val(projectUnit)
			$('#pUsingScope').val(restrictedProjectUsingScope)
			$('#pRemarks').val(remarks)
	}
</script>


</body>
</html>