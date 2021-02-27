<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link href="css/welcome.css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	$("#searchbtn").click(function(){
		$.ajax({
			type:"post",
			url:"QueryUnitInfo",
			data:{
				id:$("#id").val(),
				name:$("#name").val()
			},
			success:function(response,stutas,xhr){
				var x = $.parseJSON(response);
				var h = "<tr><th>单位编号</th><th>单位名称</th><th>联系电话</th><th>详细资料/操作</th></tr>";
				h += "<tr><td>"+x.id+"</td><td>"+x.name
					+"</td><td>"+x.companyContactNumber
					+"</td><td><button id=\"examine\" type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">查看</button>"
					+"</td></tr>";
				$("#show").html(h);
				$("#companyCode").val(x.id);
				$("#companyName").val(x.name);
				$("#companyType").val(x.companyType);
				$("#companyContactNumber").val(x.companyContactNumber);
				$("#companyAddress").val(x.companyAddress);
				$("#companyPostcode").val(x.companyPostcode);
			}
		})
	});
	$("#del").click(function(){
		$.ajax({
			type:"post",
			url:"DeleteUnitInfo",
			data:{
				id:$("#companyCode").val(),
			},
			success:function(response,stutas,xhr){
				location.reload(true) ;
				alert(response)
			}
		})
	});
})

</script>
</head>
<body onload="into()">
<div id="container-fluid" class="container-fluid">
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
		<h3 class="col-md-12">单位信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">单位信息查询</li>
			</ol>
	</div>
	<div id="row">
		<div class="col-sm-2" ></div>
		<div class="col-sm-1"><a href="Paging" class="btn btn-info">查看全部</a></div>
		<div class="col-sm-3">
			<input type="text" class="form-control" placeholder="请输入单位编号" name="id" id="id" />
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" placeholder="请输入单位名称" name="name" id="name" />
		</div>
		<button type="button" class="btn btn-info" id="searchbtn">搜索</button>
	</div>
	<div class="table-responsive">
		<table id="show" align="left" class="table table-hover table-striped"></table>	
	</div>
	<!-- 分页 -->
	<table class="table table-hover table-striped" align="center">
	<tr>
		<th>单位编号</th>
		<th>单位名称</th>
		<th>联系电话</th>
		
	</tr>
	<c:forEach var="u" items="${pageBean.pageDate }">
		<tr>
			<td>${u.companyCode }</td>
			<td>${u.companyName }</td>
			<td>${u.companyContactNumber }</td>
			
		</tr>
	</c:forEach>
</table>
<nav aria-label="Page navigation">
	<ul class="pagination pager" style="float:right;">
						<c:if test="${pageBean.currentPage==1 }">
							<li class="previous disabled">				 
						    	<a href="#">
						        	<span aria-hidden="true">&larr;</span>Older
						        </a>
				    		</li>
						</c:if>
						<c:if test="${pageBean.currentPage!=1 }">
							<li class="previous active">				 
						    	<a href="Paging?currentPage=${pageBean.currentPage-1 }">
						        	<span aria-hidden="true">&larr;</span>Older
						        </a>
				    		</li>
						</c:if>	
						<c:if test="${pageBean.currentPage ==1}">
							<li class="active">
								<a href="#">${1 }</a>
							</li>
						</c:if>	
						<c:if test="${pageBean.currentPage>1 }">
							<li class="active">
								<a href="#">${pageBean.currentPage }</a>
							</li>
						</c:if>	
					<c:if test="${pageBean.currentPage !=pageBean.totalPage}">
						<li class="next active"><a href="Paging?currentPage=${pageBean.currentPage+1 }">Newer <span aria-hidden="true">&rarr;</span></a></li>
					</c:if>
					<c:if test="${pageBean.currentPage==pageBean.totalPage}">
						<li class="next disabled">
							    <a href="#">Newer <span aria-hidden="true">&rarr;</span></a>
						</li>
					</c:if>
		</ul>
		<span class="label label-info" style="float: left;margin-top: 30px;">
				  	共
				  	<c:choose>
				  		<c:when test="${pageBean.totalCount==null}">0</c:when>
				  		<c:otherwise>${pageBean.totalCount}</c:otherwise>
				  	</c:choose>
				  	条数据,共
				  	<c:choose>
				  		<c:when test="${pageBean.totalPage==null}">0</c:when>
				  		<c:otherwise>${pageBean.totalPage}</c:otherwise>
				  	</c:choose>
				  	页
			  </span>
</nav>
	<!-- 模态框声明 -->
	<div id="myModal" class="modal" tabindex="-1">
		<!-- 窗口声明 -->
		<div id="" class="modal-dialog modal-lg">
			<!-- 内容声明 -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">单位信息</h4>
				</div>
				<div class="panel-body">
					<form action="ModifyUnitInfo" method="post" class="form-horizontal">
						<div class="form-group">
							<label for="companyCode" class="col-sm-4 control-label" >单位编号:</label>
							<div class="col-sm-4">
								<input type="text" value="abcdefg" class="form-control" name="companyCode" id="companyCode" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="age" class="col-sm-4 control-label">单位名称:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="companyName" name="companyName" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label">单位类型:</label>
							<div class="col-sm-4">
								<select name="companyType" id="companyType"></select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label">地址:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="companyAddress" id="companyAddress" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="place" class="col-sm-4 control-label">邮编:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="companyPostcode" id="companyPostcode" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label">联系电话:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="companyContactNumber" id="companyContactNumber" />
							</div>
						</div>
						<!-- 提交 -->
						<div class="form-group">
							<label class="col-sm-5 control-label"></label>
							<div class="col-sm-1">
								<button type="submit" class="btn btn-info">确定修改</button>
								<button id="del" type="submit" class="btn btn-danger">确定删除</button>
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	</main>
</div>

<script type="text/javascript">

</script>
<script type="text/javascript">
var companyType = ["政府部门","院校","科研所","国有企业","集体企业","股份合作企业","联营企业",
"有限责任公司","股份有限公司","私营企业","港澳台商投资企业","外商投资企业","其他"];
var number = ["1","2","3","4","5","6","7","8","9","10","11","12","13"];
function into(){
	
	var com = document.getElementById("companyType");
	com.length = companyType.length;
	for(var i=0;i<com.length;i++){
		com.options[i].text = companyType[i];
		com.options[i].value = number[i];
	}
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