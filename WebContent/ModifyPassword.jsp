<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
</head>
<body class="col-lg-12 col-lg-md-12">
<div class="container-fluid">
    <div class="row center-vertical">
        <div class="col-lg-4 col-md-4">
        </div>
        <div class="col-lg-4 col-md-4 panel panel-default">
            <h2>修改密码</h2>
            <form class="form-horizontal" action="ModifyPwd" method="post">
                <div class="col-lg-11 col-md-11">
                    <div class="form-group">
                        <label for="inputCode" class="col-md-2 control-label"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="text" name="jobNumber" class="form-control" id="jobNumber" placeholder="工号" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-md-2 control-label"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></label>
                        <div class="col-md-10">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-1 col-md-12">
                            <button type="submit" class="btn btn-default btn-block">提交</button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-1 col-md-1">
                </div>
            </form>

        </div>
        <div class="col-lg-4 col-md-4"></div>
    </div>

</div>
<div>
	<c:choose>
		<c:when test="${msg eq '修改成功' }">
			<script>
 					alert("修改成功！");
 					
 			</script>
		</c:when>
		<c:when test="${msg eq '修改失败' }">
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
function add(){
	confirm('你确定要提交吗?')
}
</script>
</body>
</html>