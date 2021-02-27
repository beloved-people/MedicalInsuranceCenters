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
  <!-- <li class="list-group-item" data-id="diagnosis-treatment-project">诊疗项目信息维护</li> -->                          
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
			<h3 class="col-md-12">定点医疗机构信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">定点医疗机构信息展示</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-left">定点医疗机构信息详单</h4>
				<div>
					<form class="form-inline" action="ShowDesignatedMedicalInstitutionsServlet" method="post">
			            <div class="form-group">
			                <label for="designatedMedicalInstitutionCode">定点医疗机构编号</label>
			                <input type="text" class="form-control" value="${param.designatedMedicalInstitutionCode}" name="designatedMedicalInstitutionCode" id="designatedMedicalInstitutionCode">			                 
			            </div>
			            <div class="form-group">
			                <label for="serviceOrganizationName">服务机构名称</label>
			                <input type="text" class="form-control" value="${param.serviceOrganizationName}" name="serviceOrganizationName" id="serviceOrganizationName">
			            </div>
			            <button type="submit" class="btn btn-default form-top-right">全部查询</button>
			        </form>
				</div>
				<div class="table-responsive">
				  <table class="table table-hover table-striped" id="datatable-responsive">
				  	<thead>
				    	<tr>
				    		<th>序号</th>
				    		<th>定点医疗机构编号</th>
				    		<th>服务机构名称</th>
							<th>医院等级</th>
							<th>医疗机构类别</th>
							<th>邮政编码</th>
							<th>法定代表人姓名</th>
							<th>法人代表移动电话</th>
							<th>联系人姓名</th>
							<th>联系电话</th>
							<th>联系人移动电话</th>
							<th>地址</th>
							<th>备注</th>
							<th>操作</th>											    		
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach items="${pb.list}" var="DesignatedMedicalInstitutions" varStatus="x" begin="0">
			                <tr>         
			                	<td>${x.index+1}</td>
			                	<td>${DesignatedMedicalInstitutions.designatedMedicalInstitutionCode }</td>
			                	<td>${DesignatedMedicalInstitutions.serviceOrganizationName }</td>
			                	<td><c:choose>
			                    		<c:when test="${DesignatedMedicalInstitutions.hospitalLevel == 1}">一级医院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.hospitalLevel == 2}">二级医院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.hospitalLevel == 3}">三级医院</c:when>
			                    		<c:otherwise>四级医院</c:otherwise>
			                    	</c:choose>    
			                    </td>
			                	<td>
			                		<c:choose>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='01' }">综合医院、中医医院、中西医结合医院、民族医医院、专科医院、康复医院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='02' }">妇幼保健院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='03' }">中心卫生院、乡(镇)卫生院、街道卫生院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='04' }">疗养院</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='05' }">综合门诊部、专科门诊部、中医门诊部、中西医结合门诊部、民族医门诊部</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='06' }">诊所、中医诊所、民族医诊所、卫生所、医务室、卫生保健所、卫生站</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='07' }">村卫生室(所)</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='08' }">急救中心、急救站</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='09' }">临床检验中心</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='10' }">专科疾病防治院、专科疾病防治所、专科疾病防治站</c:when>
			                    		<c:when test="${DesignatedMedicalInstitutions.medicalInstitutionTypeId=='11' }">护理院、护理站</c:when>
			                    		<c:otherwise>其他诊疗机构</c:otherwise>
			                    	</c:choose>	                	
			                	</td>
			                	<td>${DesignatedMedicalInstitutions.postcode }</td>
			                	<td>${DesignatedMedicalInstitutions.legalRepresentativeName }</td>
			                	<td>${DesignatedMedicalInstitutions.legalRepresentativeCellphoneNumber }</td>
			                	<td>${DesignatedMedicalInstitutions.concatName }</td>
			                	<td>${DesignatedMedicalInstitutions.contactNumber }</td>
			                	<td>${DesignatedMedicalInstitutions.concatCellphoneNumber }</td>
			                	<td>${DesignatedMedicalInstitutions.address }</td>
			                	<td>${DesignatedMedicalInstitutions.remarks }</td>			
			                    <td>
			                    	<a href="#" class="btn btn-default btn-sm" type="button" data-toggle="modal" data-target="#myModal" id="${x.index+1}" onclick="update(this)">修改</a>
			                           <a class="btn btn-default btn-sm"
			                            href="javascript:toDelete(${DesignatedMedicalInstitutions.designatedMedicalInstitutionCode })">删除</a>
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
				    	<a href="${pageContext.request.contextPath}/ShowDesignatedMedicalInstitutionsServlet?currentPage=${pb.currentPage-1}&rows=5&designatedMedicalInstitutionCode=${condition.designatedMedicalInstitutionCode[0]}&serviceOrganizationName=${condition.serviceOrganizationName[0]}">
				        	<span aria-hidden="true">&larr;</span>Older
				      	</a>
				    </li>
				  </c:if>
				    <c:forEach begin="1" end="${pb.totalPage }" var="i">
				       <c:if test="${pb.currentPage==i }">   
				       <li class="active">
							<a href="${pageContext.request.contextPath}/ShowDesignatedMedicalInstitutionsServlet?currentPage=${i}&rows=5&designatedMedicalInstitutionCode=${condition.designatedMedicalInstitutionCode[0]}&serviceOrganizationName=${condition.serviceOrganizationName[0]}">${i}</a>
				       	</li>
				       </c:if>   
				       <c:if test="${pb.currentPage!=i }">      
				       <li>
				       		<a href="${pageContext.request.contextPath}/ShowDesignatedMedicalInstitutionsServlet?currentPage=${i}&rows=5&designatedMedicalInstitutionCode=${condition.designatedMedicalInstitutionCode[0]}&serviceOrganizationName=${condition.serviceOrganizationName[0]}">${i}</a>
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
					      	<a href="${pageContext.request.contextPath}/ShowDesignatedMedicalInstitutionsServlet?currentPage=${pb.currentPage+1 }&rows=5&designatedMedicalInstitutionCode=${condition.designatedMedicalInstitutionCode[0]}&serviceOrganizationName=${condition.serviceOrganizationName[0]}">
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
	      <form class="form-horizontal" action="UpdateDesignatedMedicalInstitutionsServlet" method="post">
		      <div class="modal-body">
					<div class="form-group">
				    <label for="imic" class="col-sm-2 control-label">定点医疗机构编号</label>
				    <div class="col-sm-10">
				      <input type="text" name="designatedMedicalInstitutionCode" class="form-control" id="imic" placeholder="定点医疗机构编号" required="required" disabled="disabled">
				      <input type="hidden" name="designatedMedicalInstitutionCode" class="form-control" id="imic2" placeholder="定点医疗机构编号" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="isom" class="col-sm-2 control-label">服务机构名称</label>
				    <div class="col-sm-10">
				      <input type="text" name="serviceOrganizationName" class="form-control" id="isom" placeholder="服务机构名称" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="isl" class="col-sm-2 control-label">医院等级</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="hospitalLevel" required="required" id="isl">
				      	<option>请选择</option>
				      	<option value="1">一级医院</option>
				      	<option value="2">二级医院</option>
				      	<option value="3">三级医院</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="mit" class="col-sm-2 control-label">医疗机构类别</label>
				    <div class="col-sm-10">
				      <select class="form-control" name="medicalInstitutionTypeID" required="required" id="mit"> 
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="pc" class="col-sm-2 control-label">邮政编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="postcode" class="form-control" id="pc" placeholder="邮政编码" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="rn" class="col-sm-2 control-label">法定代表人姓名</label>
				    <div class="col-sm-10">
				      <input type="text" name="legalRepresentativeName" class="form-control" id="rn" placeholder="法定代表人姓名" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="rcn" class="col-sm-2 control-label">法人代表移动电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="legalRepresentativeCellphoneNumber" class="form-control" id="rcn" placeholder="法人代表移动电话" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="cn" class="col-sm-2 control-label">联系人姓名</label>
				    <div class="col-sm-10">
				      <input type="text" name="concatName" class="form-control" id="cn" placeholder="联系人姓名" required="required">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="icn" class="col-sm-2 control-label">联系电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="contactNumber" class="form-control" id="icn" placeholder="联系电话" required="required">
				    </div>
				  </div>
				 <div class="form-group">
				    <label for="iccn" class="col-sm-2 control-label">联系人移动电话</label>
				    <div class="col-sm-10">
				      <input type="text" name="concatCellphoneNumber" class="form-control" id="iccn" placeholder="联系人移动电话" required="required">
				    </div>
				  </div>
				<div class="form-group">
				    <label for="ia" class="col-sm-2 control-label">地址</label>
				    <div class="col-sm-10">
				      <input type="text" name="address" class="form-control" id="ia" placeholder="地址" required="required">
				    </div>
				  </div> 
				<div class="form-group">
				    <label for="remarks" class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				      <input type="text" name="remarks" class="form-control" id="remarks" placeholder="备注" required="required">
				    </div>
				  </div> 
					  <div class="form-group">
					    <div class="col-sm-12">
					      <button type="submit" class="btn btn-primary btn-block" onclick="modify()" >修改</button>
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
		</div>
    </main>
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
	function toDelete(id){
		if (confirm("你确定要删除吗?")) {
	        location.href = "${pageContext.request.contextPath}/DeleteDesignatedMedicalInstitutionsServlet?id=" + id;
	    }
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
                pathn = "DrugInfo.jsp"
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
                i = 0
                $("#main").load(pathn)
                break
        }
//        alert(pathn)
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
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
	var id = document.getElementById('mit')
	id.length = medicalInstitutionType.length
	id.options[0].text='请选择'
	for(var i=1;i<id.length;i++){
		id.options[i].text = medicalInstitutionType[i-1];
		id.options[i].value = num[i-1];
	}
</script>
<script type="text/javascript">
function update(obj){
			var id = $(obj).attr("id")	
			var designatedMedicalInstitutionCode = document.getElementById("datatable-responsive").rows[id].cells[1].innerText
			var serviceOrganizationName = document.getElementById("datatable-responsive").rows[id].cells[2].innerText  	
			var hospitalLevel = document.getElementById("datatable-responsive").rows[id].cells[3].innerText
			var medicalInstitutionTypeId = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
			var postcode = document.getElementById("datatable-responsive").rows[id].cells[5].innerText  		
			var legalRepresentativeName = document.getElementById("datatable-responsive").rows[id].cells[6].innerText  		
			var legalRepresentativeCellphoneNumber = document.getElementById("datatable-responsive").rows[id].cells[7].innerText  		
			var concatName = document.getElementById("datatable-responsive").rows[id].cells[8].innerText  		
			var contactNumber = document.getElementById("datatable-responsive").rows[id].cells[9].innerText  		
			var concatCellphoneNumber = document.getElementById("datatable-responsive").rows[id].cells[10].innerText  		
			var address = document.getElementById("datatable-responsive").rows[id].cells[11].innerText  		
			var remarks = document.getElementById("datatable-responsive").rows[id].cells[12].innerText  		
			$('#imic').val(designatedMedicalInstitutionCode)
			$('#imic2').val(designatedMedicalInstitutionCode)
			$('#isom').val(serviceOrganizationName)
			if(hospitalLevel === '一级医院') {
				$('#isl').val(1)
			} else if(hospitalLevel === '二级医院') {
				$('#isl').val(2)
			} else {
				$('#isl').val(3)
			}	
			switch(medicalInstitutionTypeId){
			case '综合医院、中医医院、中西医结合医院、民族医医院、专科医院、康复医院':
				$('#mit').val('01')
				break
			case '妇幼保健院':
				$('#mit').val('02')
				break
			case '中心卫生院、乡(镇)卫生院、街道卫生院':
				$('#mit').val('03')
				break
			case '疗养院':
				$('#mit').val('04')
				break
			case '综合门诊部、专科门诊部、中医门诊部、中西医结合门诊部、民族医门诊部':
				$('#mit').val('05')
				break
			case '诊所、中医诊所、民族医诊所、卫生所、医务室、卫生保健所、卫生站':
				$('#mit').val('06')
				break
			case '村卫生室(所)':
				$('#mit').val('07')
				break
			case '急救中心、急救站':
				$('#mit').val('08')
				break
			case '临床检验中心':
				$('#mit').val('09')
				break
			case '专科疾病防治院、专科疾病防治所、专科疾病防治站':
				$('#mit').val('10')
				break
			case '护理院、护理站':
				$('#mit').val('11')
				break
			default:
				$('#mit').val('12')
				break
			}		
			$('#pc').val(postcode)
			$('#rn').val(legalRepresentativeName)
			$('#rcn').val(legalRepresentativeCellphoneNumber)
			$('#cn').val(concatName)
			$('#icn').val(contactNumber)
			$('#iccn').val(concatCellphoneNumber)
			$('#ia').val(address)
			$('#remarks').val(remarks)
	}
</script>

</body>
</html>