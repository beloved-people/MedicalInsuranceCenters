<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="css/welcome.css" >
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
		<div class="jumbotron">
	  		<h1>欢迎进入</h1>
	  		<p>医疗保险中心系统</p>
	  		<p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
		</div>
    </main>

</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
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
        }
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
    }
</script>
</body>
</html>