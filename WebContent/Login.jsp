<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link  href="css/bootstrap.min.css" rel="stylesheet" >
<link href="css/login.css" rel="stylesheet">

</head>
<body class="col-lg-12 col-lg-md-12">
    <div class="container-fluid">
        <div class="row center-vertical">
            <div class="col-lg-4 col-md-4">
            </div>
            <div class="col-lg-4 col-md-4 panel panel-default">
                <h2>登录</h2>
                <form class="form-horizontal" method="post" action="LoginServlet">
                    <div class="col-lg-11 col-md-11">
                    <div class="form-group">
                        <label for="inputName" class="col-md-2 control-label"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="text" name="operatorName" class="form-control" id="inputName" placeholder="姓名" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-md-2 control-label"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="password" name="operatorPwd" class="form-control" id="inputPassword" placeholder="密码" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputCode" class="col-md-2 control-label"><span class="glyphicon glyphicon-briefcase" aria-hidden="true" ></span></label>
                        <div class="col-md-10">
                            <input type="text" name="jobNumber" class="form-control" id="inputCode" placeholder="工号" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="code" class="col-md-2 control-label"><span class="glyphicon glyphicon-console" aria-hidden="true"></span></label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="codeInput" placeholder="验证码" required="required">
                        </div>
                        <div class="col-md-4">
                        	<div id="v_container" style="width:90px;height:34px;border-radius:4px"></div><br/>
                        	<span id="error"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-1 col-md-12">
                            <button type="submit" class="btn btn-default btn-block" id="submit">登录</button>
                        </div>
                    </div>
                    </div>
                    <div class="col-lg-1 col-md-1">
                    </div>
                </form>
                <div class="row">
                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <a class="col-md-offset-2" href="Register.jsp" role="button">现在注册！</a>
                        </div>
                        <div class="btn-group" role="group">
                        </div>
                        <div class="btn-group" role="group">
                            <a class="col-md-offset-6" href="ModifyPassword.jsp" role="button">修改密码</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4"></div>
        </div>

    </div>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/gVerify.js" charset="utf-8" ></script>
    <script type="text/javascript" src="js/getVerify.js" charset="utf-8" ></script>
</body>
</html>