<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<link href="css/register.css" rel="stylesheet">
</head>
<body class="col-lg-12 col-lg-md-12">
<div class="container-fluid">
    <div class="row center-vertical">
        <div class="col-lg-4 col-md-4">
        </div>
        <div class="col-lg-4 col-md-4 panel panel-default">
            <h2>专业人员注册</h2>
            <form class="form-horizontal" action="Register" method="post">
                <div class="col-lg-11 col-md-11">
                    <div class="form-group">
                        <label for="inputName" class="col-md-2 control-label"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="text" name="operatorName" class="form-control" id="operatorName" placeholder="姓名" required="required">
                            <span id="helpBlockName" class="help-block">你的真实姓名</span>
                        </div>
                    </div>
                    <div class="form-group" >
                        <label for="input" class="col-md-2 control-label"><span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                        	<label class="checkbox-inline">
  								<input type="radio" name="operatorGender" id="inlineCheckbox1" value="男" required="required">男
							</label>
							<label class="checkbox-inline">
							  	<input type="radio" name="operatorGender" id="inlineCheckbox2" value="女" required="required">女
							</label>
                        </div>
                    </div>
                    <div class="form-group" id="password">
                        <label for="inputPassword" class="col-md-2 control-label"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="password" name="operatorPwd" class="form-control" id="inputPassword" placeholder="密码" required="required">
                            <span id="helpBlockPassword" class="help-block">要求6-20位，只能有大小写字母和数字，并且大小写字母和数字都要有</span>
                        </div>
                    </div>                   
                    <div class="form-group">
                        <label for="code" class="col-md-2 control-label"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="text" name="operatorAccount" class="form-control" id="operatorAccount" placeholder="账号" required="required">
                            <span id="helpBlockCode" class="help-block">手机号</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="code" class="col-md-2 control-label"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="text" name="jobNumber" class="form-control" id="jobNumber" placeholder="工号" required="required"> 
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-1 col-md-12">
                            <button type="submit" class="btn btn-default btn-block" data-toggle="modal" id="register" onclick="add()">注册</button>                           
                        </div>
                    </div>
                </div>
                <div class="col-lg-1 col-md-1">
                </div>
            </form>
        </div>
        <div class="col-lg-4 col-md-4"></div>
    </div>
<div>
	<c:choose>
		<c:when test="${msg eq '注册成功' }">
			<script>
 					alert("注册成功！");
 					
 			</script>
		</c:when>
		<c:when test="${msg eq '注册失败' }">
			<script>
 					alert("注册失败！");
 			</script>
		</c:when>
		<c:otherwise>
			<script></script>
		</c:otherwise>
	</c:choose>
</div>

 </div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
function add(){
	confirm('你确定要提交吗?')
}
</script>
</body>
</html>