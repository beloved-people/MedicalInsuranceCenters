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
			<h3 class="col-md-12">病种信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">病种信息展示</li>
			</ol>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h4 class="text-left">病种信息详单</h4>
				<div>
					<form class="form-inline" action="ShowDisease" method="post">
			            <div class="form-group">
			                <label for="diseaseCode">疾病编码</label>
			                <input type="text" class="form-control" value="${param.diseaseCode}" name="diseaseCode" id="diseaseCode">			                 
			            </div>
			            <div class="form-group">
			                <label for="diseaseName">病种名称</label>
			                <input type="text" class="form-control" value="${param.diseaseName}" name="diseaseName" id="diseaseName">
			            </div>
			            <button type="submit" class="btn btn-default form-top-right">全部查询</button>
			        </form>
				</div>
				<div class="table-responsive">
				  <table class="table table-hover table-striped" id="datatable-responsive">
				  	<thead>
				    	<tr>
				    		<th>序号</th>
				    		<th>疾病编码</th>
							<th>病种名称</th>
							<th>疾病种类</th>							
							<th>病种报销标志</th>	
							<th>备注</th>
							<th>操作</th>											    		
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach items="${pb.list}" var="Disease" varStatus="x" begin="0">
			                <tr>         
			                	<td>${x.index+1}</td>
			                    <td>${Disease.diseaseCode }</td>
			                    <td>${Disease.diseaseName }</td>
			                    <td>
			                    	<c:choose>
			                    		<c:when test="${Disease.diseaseTypeId == '01'}">神经系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '02'}">消化系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '03'}">泌尿系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '04'}">生殖系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '05'}">循环系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '06'}">内分泌系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '07'}">运动系统类</c:when>
			                    		<c:when test="${Disease.diseaseTypeId == '08'}">呼吸系统类</c:when>
			                    		<c:otherwise>其他</c:otherwise>
			                    	</c:choose>		                    
			                    </td>
			                    <td>${Disease.diseaseReimbursementSign == 1 ? '可报销病种':'不可报销病种' }</td>
			                    <td>${Disease.remarks }</td>
			                    <td>
			                    	<a href="#" class="btn btn-default btn-sm" type="button" data-toggle="modal" data-target="#myModal" id="${x.index+1}" onclick="update(this)">修改</a>
			                        <a class="btn btn-default btn-sm" href="javascript:deleteDisease()">删除</a>
			              			<form action="DeleteDisease"  method="get" id="hi">
										<input type="hidden" class="form-control" value="${Disease.diseaseCode }" name="id" id="ids">
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
				    	<a href="${pageContext.request.contextPath}/ShowDisease?currentPage=${pb.currentPage-1}&rows=5&diseaseCode=${condition.diseaseCode[0]}&diseaseName=${condition.diseaseName[0]}">
				        	<span aria-hidden="true">&larr;</span>Older
				      	</a>
				    </li>
				  </c:if>
				    <c:forEach begin="1" end="${pb.totalPage }" var="i">
				       <c:if test="${pb.currentPage==i }">   
				       <li class="active">
							<a href="${pageContext.request.contextPath}/ShowDisease?currentPage=${i}&rows=5&diseaseCode=${condition.diseaseCode[0]}&diseaseName=${condition.diseaseName[0]}">${i}</a>
				       	</li>
				       </c:if>   
				       <c:if test="${pb.currentPage!=i }">      
				       <li>
				       		<a href="${pageContext.request.contextPath}/ShowDisease?currentPage=${i}&rows=5&diseaseCode=${condition.diseaseCode[0]}&diseaseName=${condition.diseaseName[0]}">${i}</a>
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
					      	<a href="${pageContext.request.contextPath}/ShowDisease?currentPage=${pb.currentPage+1 }&rows=5&diseaseCode=${condition.diseaseCode[0]}&diseaseName=${condition.diseaseName[0]}">
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
	      <form class="form-horizontal" action="UpdateDisease" method="post">
		      <div class="modal-body">
		  <div class="form-group">
				    <label for="inputDiseaseCode" class="col-sm-2 control-label">病种编码</label>
				    <div class="col-sm-10">
				      <input type="text" name="diseaseCode" class="form-control" id="inputDiseaseCode" placeholder="病种编码" required="required" disabled="disabled">
				      <input type="hidden" name="diseaseCode" class="form-control" id="inputDiseaseCode2" placeholder="病种编码" required="required">
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
					    <div class="col-sm-12">
					      <button type="submit" class="btn btn-primary btn-block" onclick="modify()">修改</button>
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
function deleteDisease(){
	if(confirm('你确定要删除吗?')){
		document.getElementById("hi").submit();//在表单里，一般都会指定表单的action：表单会把数据提交到action设定的页面。如果没有action，默认是提交给当前的页面。
	}
}

	function modify(){
		confirm('你确定要修改吗?')
	}

</script>
<script type="text/javascript">
function update(obj){
			var id = $(obj).attr("id")	
			var diseaseCode = document.getElementById("datatable-responsive").rows[id].cells[1].innerText
			var diseaseName = document.getElementById("datatable-responsive").rows[id].cells[2].innerText  	
			var diseaseTypeId = document.getElementById("datatable-responsive").rows[id].cells[3].innerText
			var diseaseReimbursementSign = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
			var remarks = document.getElementById("datatable-responsive").rows[id].cells[5].innerText  		
			$('#inputDiseaseCode').val(diseaseCode)
			$('#inputDiseaseCode2').val(diseaseCode)
			$('#inputDiseaseName').val(diseaseName)
			switch(diseaseTypeId){
			case '神经系统类':
				$('#diseaseType').val('01')
				break
			case '消化系统类':
				$('#diseaseType').val('02')
				break
			case '泌尿系统类':
				$('#diseaseType').val('03')
				break
			case '生殖系统类':
				$('#diseaseType').val('04')
				break
			case '循环系统类':
				$('#diseaseType').val('05')
				break
			case '内分泌系统类':
				$('#diseaseType').val('06')
				break
			case '运动系统类':
				$('#diseaseType').val('07')
				break
			case '呼吸系统类':
				$('#diseaseType').val('08')
				break
			default:
				$('#diseaseType').val('09')
				break
			}	
			if(diseaseReimbursementSign === 1) {
				$('#diseaseReimbursementSign').val(1)
			} else {
				$('#diseaseReimbursementSign').val(2)
			}	
			
			$('#inputRemarks').val(remarks)
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
                pathn = "PrintList.jsp"
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
</body>
</html>