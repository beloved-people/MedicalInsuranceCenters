<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员信息查询</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/welcome.css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="vue/vue.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div id="container-fluid">
	<main id="main" style="padding:0;">
 		<div class="row">
			<h3 class="col-md-12">人员信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">人员信息查询</li>
			</ol>
		</div>
		<div id="row">
			<div class="col-sm-12">
				<h4 class="text-left">人员信息详单</h4>
				<div>
					<form class="form-inline" action="QueryPersonnel" method="post">
								<div class="form-group">
									<label for="id">人员ID</label>
									<input type="text" class="form-control" placeholder="请输入id" name="personId" required="required"/>			                 
								</div>
								<div class="form-group">
									<label for="name">人员姓名</label>
									<input type="text" class="form-control" placeholder="请输入姓名" name="name" required="required"/>		                 
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-info">搜索</button>
								</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">		
			<div class="col-md-12">
				<div class="table-responsive">
				<table class="table table-hover table-striped" id="show"></table>
					<table class="table table-hover table-striped" id="datatable-responsive">
						<thead>
							<tr>
								<th>序号</th>
								<th>个人ID</th>
								<th>证件类型</th>
								<th>证件编号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>民族</th>
								<th>出生日期</th>
								<th>参加工作日期</th>
								<th>离退休日期</th>
								<th>离退休状态</th>
								<th>户口性质</th>
								<th>户口所在地</th>
								<th>文化程度</th>
								<th>政治面貌</th>
								<th>个人身份</th>
								<th>用工形式</th>
								<th>专业技术职务</th>
								<th>国家职业资格等级（工人技术等级）</th>
								<th>婚姻状况</th>
								<th>行政职务</th>
								<th>备注</th>
								<th>单位编码</th>
								<th>医疗人员类别</th>
								<th>健康状况</th>
								<th>劳模标志</th>
								<th>干部标志</th>
								<th>公务员标志</th>
								<th>在编标志</th>
								<th>居民类别</th>
								<th>灵活就业标志</th>
								<th>农民工标志</th>
								<th>雇主标志</th>
								<th>军转人员标志</th>
								<th>社保卡号（系统自动生成）</th>
								<th>定点医疗机构编码</th>
						<!-- 		<th>操作</th> -->
							</tr>		
							</thead>
						<tbody>
									<tr>
										<td>1</td>
										<td>${pi.personId }</td>				
										<td>${pi.certificateName }</td>				
										<td>${pi.certificateNumber }</td>				
										<td>${pi.name }</td>				
										<td>${pi.gender }</td>				
										<td>${pi.nationName }</td>				
										<td>${pi.birthdate }</td>				
										<td>${pi.participationDate }</td>				
										<td>${pi.retirementDate }</td>				
										<td>
											<c:choose>
												<c:when test="${pi.retirementStatus==1 }">离休</c:when>
												<c:when test="${pi.retirementStatus==2 }">退休</c:when>
												<c:otherwise>离职</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${pi.retirementStatus==1 }">本市城镇</c:when>
												<c:when test="${pi.retirementStatus==2 }">本市农村</c:when>
												<c:when test="${pi.retirementStatus==3 }">外埠城镇</c:when>
												<c:when test="${pi.retirementStatus==4 }">外埠农村</c:when>
												<c:otherwise>外籍华人</c:otherwise>
											</c:choose>
										</td>				
										<td>${pi.accountLocation }</td>				
										<td>${pi.degreeName }</td>				
										<td>${pi.outlookName }</td>				
										<td>
											<c:choose>
												<c:when test="${pi.identity==1 }">干部（干部为大专以上学历人员）</c:when>
												<c:when test="${pi.identity==2 }">工人</c:when>
												<c:when test="${pi.identity==3 }">农民</c:when>
												<c:otherwise>其他</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${pi.employmentForm==1 }">全日制用工</c:when>
												<c:when test="${pi.employmentForm==2 }">劳务派遣用工</c:when>
												<c:otherwise>非全日制用工</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${pi.specializedTechnicalJob==1 }">高级</c:when>
												<c:when test="${pi.specializedTechnicalJob==2 }">中级</c:when>
												<c:otherwise>初级</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${pi.nvql==1 }">初级（五级）</c:when>
												<c:when test="${pi.nvql==2 }">中级（四级）</c:when>
												<c:when test="${pi.nvql==3 }">高级（三级）</c:when>
												<c:when test="${pi.nvql==4 }">技师（二级）</c:when>
												<c:otherwise>高级技师（一级）</c:otherwise>
											</c:choose>
										
										</td>				
										<td>${pi.maritalStatus==1?'已婚':'未婚' }</td>	
										<td>${pi.dutyName }</td>				
										<td>${pi.remarks }</td>				
										<td>${pi.companyCode }</td>				
										<td>${pi.personnelCategoryName }</td>				
										<td>
											<c:choose>
												<c:when test="${pi.healthStatus==1 }">健康</c:when>
												<c:when test="${pi.healthStatus==2 }">良好</c:when>
												<c:when test="${pi.healthStatus==3 }">一般</c:when>
												<c:when test="${pi.healthStatus==4 }">较差</c:when>
												<c:otherwise>残疾</c:otherwise>
											</c:choose>
										</td>	
										<td>${pi.lamorSign==1?'是':'否' }</td>				
										<td>${pi.cadreSign==1?'是':'否' }</td>				
										<td>${pi.civilServantSign==1?'是':'否' }</td>				
										<td>${pi.establishmentSign==1?'是':'否' }</td>
										<td>${pi.residentSign==1?'城市居民':'农村居民' }</td>
										<td>${pi.flexibleEmploymentSign==1?'是':'否' }</td>			
										<td>${pi.migrantWorkerSign==1?'是':'否' }</td>			
										<td>${pi.employerSign==1?'是':'否' }</td>			
										<td>${pi.militaryPersonnelSign==1?'是':'否' }</td>
										<td>${pi.socialSecurityNumber }</td>				
										<td>${pi.designatedMedicalInstitutionCode }</td>			
									</tr>
							<c:forEach var="u" items="${pageBean1.pageDate }" varStatus="x" begin="0">
									<tr>
										<td>${x.index+1}</td>
										<td>${u.personId }</td>				
										<td>${u.certificateName }</td>				
										<td>${u.certificateNumber }</td>				
										<td>${u.name }</td>				
										<td>${u.gender }</td>				
										<td>${u.nationName }</td>				
										<td>${u.birthdate }</td>				
										<td>${u.participationDate }</td>				
										<td>${u.retirementDate }</td>				
										<td>
											<c:choose>
												<c:when test="${u.retirementStatus==1 }">离休</c:when>
												<c:when test="${u.retirementStatus==2 }">退休</c:when>
												<c:otherwise>离职</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${u.retirementStatus==1 }">本市城镇</c:when>
												<c:when test="${u.retirementStatus==2 }">本市农村</c:when>
												<c:when test="${u.retirementStatus==3 }">外埠城镇</c:when>
												<c:when test="${u.retirementStatus==4 }">外埠农村</c:when>
												<c:otherwise>外籍华人</c:otherwise>
											</c:choose>
										</td>				
										<td>${u.accountLocation }</td>				
										<td>${u.degreeName }</td>				
										<td>${u.outlookName }</td>				
										<td>
											<c:choose>
												<c:when test="${u.identity==1 }">干部（干部为大专以上学历人员）</c:when>
												<c:when test="${u.identity==2 }">工人</c:when>
												<c:when test="${u.identity==3 }">农民</c:when>
												<c:otherwise>其他</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${u.employmentForm==1 }">全日制用工</c:when>
												<c:when test="${u.employmentForm==2 }">劳务派遣用工</c:when>
												<c:otherwise>非全日制用工</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${u.specializedTechnicalJob==1 }">高级</c:when>
												<c:when test="${u.specializedTechnicalJob==2 }">中级</c:when>
												<c:otherwise>初级</c:otherwise>
											</c:choose>
										</td>				
										<td>
											<c:choose>
												<c:when test="${u.nvql==1 }">初级（五级）</c:when>
												<c:when test="${u.nvql==2 }">中级（四级）</c:when>
												<c:when test="${u.nvql==3 }">高级（三级）</c:when>
												<c:when test="${u.nvql==4 }">技师（二级）</c:when>
												<c:otherwise>高级技师（一级）</c:otherwise>
											</c:choose>
										
										</td>				
										<td>${u.maritalStatus==1?'已婚':'未婚' }</td>	
										<td>${u.dutyName }</td>				
										<td>${u.remarks }</td>				
										<td>${u.companyCode }</td>				
										<td>${u.personnelCategoryName }</td>				
										<td>
											<c:choose>
												<c:when test="${u.healthStatus==1 }">健康</c:when>
												<c:when test="${u.healthStatus==2 }">良好</c:when>
												<c:when test="${u.healthStatus==3 }">一般</c:when>
												<c:when test="${u.healthStatus==4 }">较差</c:when>
												<c:otherwise>残疾</c:otherwise>
											</c:choose>
										</td>	
										<td>${u.lamorSign==1?'是':'否' }</td>				
										<td>${u.cadreSign==1?'是':'否' }</td>				
										<td>${u.civilServantSign==1?'是':'否' }</td>				
										<td>${u.establishmentSign==1?'是':'否' }</td>
										<td>${u.residentSign==1?'城市居民':'农村居民' }</td>
										<td>${u.flexibleEmploymentSign==1?'是':'否' }</td>			
										<td>${u.migrantWorkerSign==1?'是':'否' }</td>			
										<td>${u.employerSign==1?'是':'否' }</td>			
										<td>${u.militaryPersonnelSign==1?'是':'否' }</td>
										<td>${u.socialSecurityNumber }</td>				
										<td>${u.designatedMedicalInstitutionCode }</td>
								<!-- 		<td>
											<a href="#" class="btn btn-default btn-sm" type="button" data-toggle="modal" data-target="#myModal" id="${x.index+1}" onclick="update(this)">修改</a>
										</td>		 -->		
									</tr>
								</c:forEach>
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation">
					<ul class="pagination pager" style="float:right;">
						<c:if test="${pageBean1.currentPage==1 }">
							<li class="previous disabled">				 
						    	<a href="#">
						        	<span aria-hidden="true">&larr;</span>Older
						        </a>
				    		</li>
						</c:if>
						<c:if test="${pageBean1.currentPage!=1 }">
							<li class="previous active">				 
						    	<a href="PersonInfoPaging?currentPage=${pageBean1.currentPage-1 }">
						        	<span aria-hidden="true">&larr;</span>Older
						        </a>
				    		</li>
						</c:if>	
						<c:if test="${pageBean1.currentPage ==1}">
							<li class="active">
								<a href="#">${1 }</a>
							</li>
						</c:if>	
						<c:if test="${pageBean1.currentPage>1 }">
							<li class="active">
								<a href="#">${pageBean1.currentPage }</a>
							</li>
						</c:if>	
						
						<c:if test="${pageBean1.currentPage != pageBean1.totalPage}">
								<li class="next active">
									<a href="PersonInfoPaging?currentPage=${pageBean1.currentPage+1 }"> 
									Newer <span aria-hidden="true">&rarr;</span></a>
								</li>
						</c:if>
						<c:if test="${pageBean1.currentPage == pageBean1.totalPage}">
								 <li class="next disabled">
				    				<a href="#">Newer <span aria-hidden="true">&rarr;</span></a>
				    			</li>
							</c:if>
						</ul>
				<span class="label label-info" style="float: left;margin-top: 30px;">
				  	共
				  	<c:choose>
				  		<c:when test="${pageBean1.totalCount==null}">0</c:when>
				  		<c:otherwise>${pageBean1.totalCount}</c:otherwise>
				  	</c:choose>
				  	条数据,共
				  	<c:choose>
				  		<c:when test="${pageBean1.totalPage==null}">0</c:when>
				  		<c:otherwise>${pageBean1.totalPage}</c:otherwise>
				  	</c:choose>
				  	页
			  </span>
				</nav>
			</div>
			<div class="row"></div>
		</div>
		</main>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">修改</h4>
	      </div>
	      <form class="form-horizontal" action="ModifyPersonnel" method="post">
		     <div class="form-group">
					    <label for="certificateID" class="col-sm-1 control-label">证件类型</label>
					    <div class="col-sm-5">
					    	<select class="form-control" name="certificateID" id="certificateID">
							</select>
					    </div>
					    <label for="certificateNumber" class="col-sm-1 control-label">证件号码</label>
					    <div class="col-sm-5">
					    	<input type="text" class="form-control" v-model="certificateNumber" name="certificateNumber" id="certificateNumber" />
					    </div>
					 </div>
					<div class="form-group">
					    <label for="name" class="col-sm-1 control-label">姓名</label>
					    <div class="col-sm-5">
					    	<input type="text" class="form-control" name="name" id="name" />
					    </div>
					    <label for="gender" class="col-sm-1 control-label">性别</label>
					    <div class="col-sm-5">
					    <label class="radio-inline">
					    	<input type="radio" name="gender" id="gender1" value="男" />男
					    </label>
					    <label class="radio-inline">
							<input type="radio" name="gender" id="gender2" value="女" />女
						</label>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="nationID" class="col-sm-1 control-label">民族</label>
					    <div class="col-sm-5">
					    	<select class="form-control" name="nationID" id="nationID">
								</select>
					    </div>
					    <label for="birthdate" class="col-sm-1 control-label">出生日期</label>
					    <div class="col-sm-5">
					    	<input type="date" class="form-control" name="birthdate" id="birthdate" />
					    </div>
					 </div>
					<div class="form-group">
					    <label for="participationDate" class="col-sm-1 control-label">参加工作日期</label>
					    <div class="col-sm-5">
					    	<input type="date" class="form-control" name="participationDate" id="participationDate" />
					    </div>
					    <label for="retirementDate" class="col-sm-1 control-label">离退休日期</label>
					    <div class="col-sm-5">
					    	<input type="date" class="form-control" name="retirementDate" id="retirementDate" />
					    </div>
					 </div>
					<div class="form-group">
					    <label for="retirementStatus" class="col-sm-1 control-label">离退休状态</label>
					    <div class="col-sm-5">
							<select class="form-control"  name="retirementStatus" id="retirementStatus">
								<option>请选择</option>
								<option value="01">离休</option>
								<option value="02">退休</option>
								<option value="03">离职</option>
								<option value="04">未离职和退休</option>
							</select>
					    </div>
					    <label for="accountNature" class="col-sm-1 control-label">户口性质</label>
					    <div class="col-sm-5">
					    	<select class="form-control" name="accountNature" id="accountNature">
								<option>请选择</option>
								<option value="01">本市城镇</option>
								<option value="02">本市农村</option>
								<option value="03">外埠城镇</option>
								<option value="04">外埠农村</option>
								<option value="05">外籍华人</option>
							</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="accountLocation" class="col-sm-1 control-label">户口所在地</label>
					    <div class="col-sm-5">
					    	<input type="text" class="form-control" name="accountLocation" id="accountLocation" />
					    </div>
					    <label for="degreeID" class="col-sm-1 control-label">文化程度</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="degreeID" name="degreeID"></select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="employmentForm" class="col-sm-1 control-label">用工形式</label>
					    <div class="col-sm-5">
					    		<select class="form-control" id="employmentForm" name="employmentForm">
									<option>请选择</option>
									<option value ="01">全日制用工</option>
									<option value ="02">劳务派遣用工</option>
									<option value ="03">非全日制用工</option>
								</select>
					    </div>
					    <label for="specializedTechnicalJob" class="col-sm-1 control-label">专业技术职务</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="specializedTechnicalJob" name="specializedTechnicalJob">
									<option>请选择</option>
									<option value ="01">高级</option>
									<option value ="02">中级</option>
									<option value ="03">初级</option>
								</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="accountLocation" class="col-sm-1 control-label">政治面貌</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="outlookID" name="outlookID"></select>
					    </div>
					    <label for="degreeID" class="col-sm-1 control-label">个人身份</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="identity" name="identity">
					    			<option>请选择</option>
									<option value ="01">干部（干部为大专以上学历人员）</option>
									<option value ="02">工人</option>
									<option value ="03">农民</option>
									<option value ="04">其他</option>
								</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="NVQL" class="col-sm-1 control-label">国家职业资格等级(工人技术等级)</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="NVQL" name="NVQL">
									<option>请选择</option>
									<option value ="01">初级（五级）</option>
									<option value ="02">中级（四级）</option>
									<option value ="03">高级（三级）</option>
									<option value ="04">技师（二级）</option>
									<option value ="05">高级技师（一级）</option>
								</select>
					    </div>
					    <label for="maritalStatus" class="col-sm-1 control-label">婚姻状况</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="maritalStatus" name="maritalStatus">
									<option>请选择</option>
									<option value ="01">已婚</option>
									<option value ="02">未婚</option>
								</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="dutyID" class="col-sm-1 control-label">行政职务</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="dutyID" name="dutyID"></select>
					    </div>
					    <label for="remarks" class="col-sm-1 control-label">备注</label>
					    <div class="col-sm-5">
							<textarea class="form-control" id="remarks"  name="remarks" rows="2px" cols="40px">
							</textarea>
					    </div>
					 </div>
						<div class="form-group">
					    <label for="companyCode" class="col-sm-1 control-label">单位编码</label>
					    <div class="col-sm-5">
					    	<input type="text" class="form-control" name="companyCode" id="companyCode"/>
					    </div>
					    <label for="personnelCategoryID" class="col-sm-1 control-label">医疗人员类别</label>
					    <div class="col-sm-5">
							<select class="form-control" name="personnelCategoryID" id="personnelCategoryID"></select>
					    </div>
					 </div>
						<div class="form-group">
					    <label for="healthStatus" class="col-sm-1 control-label">健康状况</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="healthStatus" name="healthStatus">
									<option>请选择</option>
									<option value ="01">健康</option>
									<option value ="02">良好</option>
									<option value ="03">一般</option>
									<option value ="04">较差</option>
									<option value ="05">残疾</option>
								</select>
					    </div>
					    <label for="lamorSign" class="col-sm-1 control-label">劳模标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="lamorSign" name="lamorSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="cadreSign" class="col-sm-1 control-label">干部标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control"  id="cadreSign" name="cadreSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					    <label for="civilServantSign" class="col-sm-1 control-label">公务员标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control"  id="civilServantSign" name="civilServantSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					 </div>
						<div class="form-group">
					    <label for="establishmentSign" class="col-sm-1 control-label">在编标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="establishmentSign" name="establishmentSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					    <label for="residentSign" class="col-sm-1 control-label">居民类别</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="residentSign" name="residentSign">
									<option>请选择</option>
									<option value ="01">城市居民</option>
									<option value ="02">农村居民</option>
								</select>
					    </div>
					 </div>
						<div class="form-group">
					    <label for="flexibleEmploymentSign" class="col-sm-1 control-label">灵活就业标志</label>
					    <div class="col-sm-5">
								<select class="form-control" id="flexibleEmploymentSign" name="flexibleEmploymentSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					    <label for="migrantWorkerSign" class="col-sm-1 control-label">农民工标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="migrantWorkerSign" name="migrantWorkerSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					 </div>
						<div class="form-group">
					    <label for="employerSign" class="col-sm-1 control-label">雇主标志</label>
					    <div class="col-sm-5">
								<select class="form-control" id="employerSign" name="employerSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					    <label for="militaryPersonnelSign" class="col-sm-1 control-label">军转人员标志</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="militaryPersonnelSign" name="militaryPersonnelSign">
									<option>请选择</option>
									<option value ="01">是</option>
									<option value ="02">否</option>
								</select>
					    </div>
					 </div>
					<div class="form-group">
					    <label for="socialSecurityNumber" class="col-sm-1 control-label">社保卡号</label>
					    <div class="col-sm-5">
					    	<input type="text" class="form-control" id="socialSecurityNumber" :value="certificateNumber" placeholder="与身份证号一致"/>
					    </div>
					    <label for="designatedMedicalInstitutionCode" class="col-sm-1 control-label">定点医疗机构编码</label>
					    <div class="col-sm-5">
							<input type="text" class="form-control" name="designatedMedicalInstitutionCode" id="designatedMedicalInstitutionCode" />
					    </div>
					 </div>
					<div class="form-group">
					    <div class="col-sm-offset-1 col-sm-10">
					      <button type="submit" class="btn btn-primary btn-block" onclick="add()" >提交</button>
					    </div>
					  </div>
	      </form>
	    </div>
	  </div>
	</div>

<script type="text/javascript">
	var vm = new Vue({
		el:"#container-fluid",
		data:{
			certificateNumber:''
		},
		methods:{
			
		}
	})
</script>
<script type="text/javascript">
var nation = ["汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",
	"哈尼族","哈萨克族","傣族","黎族","僳僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",
	"土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族","乌孜别克族",
	"俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"
	];
	var certificate = ["居民身份证（户口簿）","中国人民解放军军官证","中国人民武装警察警官证" ,"香港特区护照/港澳居民来往内地通行证",
	"澳门特区护照/港澳居民来往内地通行证","台湾居民来往大陆通行证","外国人永久居住证","外国人护照","残疾人证","军烈属证明","外国人就业证",
	"外国专家证","外国人常驻记者证","台港澳人员就业证","回国（来华）定居专家证","中国护照","社会保障卡","其他身份证件"
	];
	var degree = ["研究生","大学本科（简称：本科）","大学专科和专科学校","中专或中技",
	"技工学校","高中","初中","小学","文盲或半文盲"
	];
	var outlook = ["中共党员","中共预备党员","共青团员","民革党员","民盟盟员","民建会员","民进会员","农工党党员",
	"致公党党员","九三学社社员","台盟盟员","无党派人士","群众（现称普通居民，与居民身份证相对应）"
	];
	var duty = ["国家级正职","国家级副职","部级正职","部级副职","厅局级正职","厅局级副职","县处级正职","县处级副职",
	"乡科级正职","乡科级副职","科员级","办事员级"
	];
	var category = ["单位在岗","个体","自由职业","非正规就业","非全日制就业","中心一次性缴费","中心协保","中心退养","其他"
	];
	var num = [
		"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
		"22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42",
		"43","45","46","47","48","49","50","51","52","53","54","55","56","57"
	]
	function into(){
		var n = document.getElementById("nationID");
		var c = document.getElementById("certificateID");
		var d = document.getElementById("degreeID");
		var o = document.getElementById("outlookID");
		var du = document.getElementById("dutyID");
		var ca = document.getElementById("personnelCategoryID");
		n.length = nation.length;
		c.length = certificate.length;
		d.length = degree.length;
		o.length = outlook.length;
		du.length = duty.length;
		ca.length = category.length;
		n.options[0].text='请选择'
			for(var i=1;i<n.length;i++){
				n.options[i].text = nation[i-1];
				n.options[i].value = num[i-1];
			}
			c.options[0].text='请选择'
			for(var i=1;i<c.length;i++){
				c.options[i].text = certificate[i-1];
				c.options[i].value = num[i-1];
			}
			o.options[0].text='请选择'
			for(var i=1;i<d.length;i++){
				d.options[i].text = degree[i-1];
				d.options[i].value = num[i-1];
			}
			o.options[0].text='请选择'
			for(var i=1;i<o.length;i++){
				o.options[i].text = outlook[i-1];
				o.options[i].value = num[i-1];
			}
			du.options[0].text='请选择'
			for(var i=1;i<du.length;i++){
				du.options[i].text = duty[i-1];
				du.options[i].value = num[i-1];
			}
			ca.options[0].text='请选择'
			for(var i=1;i<ca.length;i++){
				ca.options[i].text = category[i-1];
				ca.options[i].value = num[i-1];
			}
	};
</script>
<script type="text/javascript">
function update(obj){
	var nation = ["汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族","满族","侗族","瑶族","白族","土家族",
		"哈尼族","哈萨克族","傣族","黎族","僳僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",
		"土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛南族","仡佬族","锡伯族","阿昌族","普米族","塔吉克族","怒族","乌孜别克族",
		"俄罗斯族","鄂温克族","德昂族","保安族","裕固族","京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"
		];
		var certificate = ["居民身份证（户口簿）","中国人民解放军军官证","中国人民武装警察警官证" ,"香港特区护照/港澳居民来往内地通行证",
		"澳门特区护照/港澳居民来往内地通行证","台湾居民来往大陆通行证","外国人永久居住证","外国人护照","残疾人证","军烈属证明","外国人就业证",
		"外国专家证","外国人常驻记者证","台港澳人员就业证","回国（来华）定居专家证","中国护照","社会保障卡","其他身份证件"
		];
		var degree = ["研究生","大学本科（简称：本科）","大学专科和专科学校","中专或中技",
		"技工学校","高中","初中","小学","文盲或半文盲"
		];
		var outlook = ["中共党员","中共预备党员","共青团员","民革党员","民盟盟员","民建会员","民进会员","农工党党员",
		"致公党党员","九三学社社员","台盟盟员","无党派人士","群众（现称普通居民，与居民身份证相对应）"
		];
		var duty = ["国家级正职","国家级副职","部级正职","部级副职","厅局级正职","厅局级副职","县处级正职","县处级副职",
		"乡科级正职","乡科级副职","科员级","办事员级"
		];
		var category = ["单位在岗","个体","自由职业","非正规就业","非全日制就业","中心一次性缴费","中心协保","中心退养","其他"
		];
			var id = $(obj).attr("id")	
			var certificateID = document.getElementById("datatable-responsive").rows[id].cells[2].innerText
			console.log(certificateID)
			var certificateNumber = document.getElementById("datatable-responsive").rows[id].cells[3].innerText  	
			var name = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
			var gender = document.getElementById("datatable-responsive").rows[id].cells[5].innerText
			var nationID = document.getElementById("datatable-responsive").rows[id].cells[6].innerText  		
			var birthdate = document.getElementById("datatable-responsive").rows[id].cells[7].innerText  		
			var participationDate = document.getElementById("datatable-responsive").rows[id].cells[8].innerText  		
			var retirementDate = document.getElementById("datatable-responsive").rows[id].cells[9].innerText  		
			var retirementStatus = document.getElementById("datatable-responsive").rows[id].cells[10].innerText  		
			var accountNature = document.getElementById("datatable-responsive").rows[id].cells[11].innerText  		
			var accountLocation = document.getElementById("datatable-responsive").rows[id].cells[12].innerText  		
			var degreeID = document.getElementById("datatable-responsive").rows[id].cells[13].innerText  		
			var employmentForm = document.getElementById("datatable-responsive").rows[id].cells[14].innerText  		
			var specializedTechnicalJob = document.getElementById("datatable-responsive").rows[id].cells[15].innerText  		
			var outlookID = document.getElementById("datatable-responsive").rows[id].cells[16].innerText  		
			var identity = document.getElementById("datatable-responsive").rows[id].cells[17].innerText  		
			var NVQL = document.getElementById("datatable-responsive").rows[id].cells[18].innerText  		
			var maritalStatus = document.getElementById("datatable-responsive").rows[id].cells[19].innerText  		
			var dutyID = document.getElementById("datatable-responsive").rows[id].cells[20].innerText  		
			var remarks = document.getElementById("datatable-responsive").rows[id].cells[21].innerText  		
			var companyCode = document.getElementById("datatable-responsive").rows[id].cells[22].innerText  		
			var personnelCategoryID = document.getElementById("datatable-responsive").rows[id].cells[23].innerText  		
			var healthStatus = document.getElementById("datatable-responsive").rows[id].cells[24].innerText  		
			var lamorSign = document.getElementById("datatable-responsive").rows[id].cells[25].innerText  		
			var cadreSign = document.getElementById("datatable-responsive").rows[id].cells[26].innerText  		
			var civilServantSign = document.getElementById("datatable-responsive").rows[id].cells[27].innerText  		
			var establishmentSign = document.getElementById("datatable-responsive").rows[id].cells[28].innerText  		
			var residentSign = document.getElementById("datatable-responsive").rows[id].cells[29].innerText  		
			var flexibleEmploymentSign = document.getElementById("datatable-responsive").rows[id].cells[30].innerText  		
			var militaryPersonnelSign = document.getElementById("datatable-responsive").rows[id].cells[31].innerText  		
			var employerSign = document.getElementById("datatable-responsive").rows[id].cells[32].innerText  		
			var militaryPersonnelSign = document.getElementById("datatable-responsive").rows[id].cells[33].innerText  		
			var socialSecurityNumber = document.getElementById("datatable-responsive").rows[id].cells[34].innerText  		 		
			var designatedMedicalInstitutionCode = document.getElementById("datatable-responsive").rows[id].cells[35].innerText  		
			$("#name").val(name);
			for (var i = 0; i < certificate.length; i++) {
				if (certificateID === certificate[i]) {
					$("#certificateID").val('0'+(i+1));
				}
			}			
			$("#certificateNumber").val(certificateNumber);
			if (gender==='男') {
				$("#gender1").val('男')
			}  
			if (gender==='女') {
				$("#gender2").val('女')
			}
			
			for (var i = 0; i < nation.length; i++) {
				if (nationID === nation[i]) {
					$("#nationID").val('0'+(i+1));
				}
			}	
			$("#birthdate").val(birthdate);
			$("#participationDate").val(participationDate);
			$("#retirementDate").val(retirementDate);
			if (retirementStatus === '离休') {
				$("#retirementStatus").val('01')
			} else if (retirementStatus === '退休') {
				$("#retirementStatus").val('02')
			} else if (retirementStatus === '离职') {
				$("#retirementStatus").val('03')
			} else {
				$("#retirementStatus").val('04')
			}
			switch(accountNature){
			case '本市城镇':
				$("#accountNature").val('01')
				break
			case '本市农村':
				$("#accountNature").val('02')
				break
			case '外埠城镇':
				$("#accountNature").val('03')
				break
			case '外埠农村':
				$("#accountNature").val('04')
				break
			default:
				$("#accountNature").val('05')
				break
			}
			$("#accountLocation").val(accountLocation);
			for (var i = 0; i < degree.length; i++) {
				if (degreeID === degree[i]) {
					$("#degreeID").val('0'+(i+1));
				}
			}	
			for (var i = 0; i < outlook.length; i++) {
				if (outlookID === outlook[i]) {
					$("#outlookID").val('0'+(i+1));
				}
			}	
			switch(identity){
			case '干部（干部为大专以上学历人员）':
				$("#identity").val('01')
				break
			case '工人':
				$("#identity").val('02')
				break
			case '农民':
				$("#identity").val('03')
				break
			default:
				$("#identity").val('05')
				break
			}
			
			$("#employmentForm").val(employmentForm);
			$("#specializedTechnicalJob").val(specializedTechnicalJob);
			$("#NVQL").val(NVQL);
			$("#maritalStatus").val(maritalStatus);
			$("#dutyID").val(dutyID);
			$("#remarks").val(remarks);
			$("#companyCode").val(companyCode);
			$("#personnelCategoryId").val(personnelCategoryID);
			$("#healthStatus").val(healthStatus);
			$("#lamorSign").val(lamorSign);
			$("#cadreSign").val(cadreSign);
			$("#civilServantSign").val(civilServantSign);
			$("#establishmentSign").val(establishmentSign);
			$("#residentSign").val(residentSign);
			$("#flexibleEmploymentSign").val(flexibleEmploymentSign);
			$("#migrantWorkerSign").val(migrantWorkerSign);
			$("#employerSign").val(employerSign);
			$("#militaryPersonnelSign").val(militaryPersonnelSign);
			$("#socialSecurityId").val(certificateNumber);
			$("#designatedMedicalInstitutionCode").val(designatedMedicalInstitutionCode);
	}
</script>

</body>
</html>