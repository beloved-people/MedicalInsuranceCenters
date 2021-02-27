<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>系统操作人员信息</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <main id="main" style="padding:0;">
		<div class="row">
			<h3 class="col-md-12">个人信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li><a href="">个人信息详情</a></li>
			</ol>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function toDelete(id){
		if (confirm("你确定要删除吗?")) {
	        location.href = "${pageContext.request.contextPath}/DeleteServiceFacilityServlet?id=" + id;
	    }
	}
	function modify(){
		confirm('你确定要修改吗?')
	}

</script>
<script type="text/javascript">
function update(obj){
			var id = $(obj).attr("id")	
			var medicalServiceFacilityCode = document.getElementById("datatable-responsive").rows[id].cells[1].innerText
			var serviceFacilitiesName = document.getElementById("datatable-responsive").rows[id].cells[2].innerText  	
			var chargeCategory = document.getElementById("datatable-responsive").rows[id].cells[3].innerText
			var remarks = document.getElementById("datatable-responsive").rows[id].cells[4].innerText
			var restrictedUsingScope = document.getElementById("datatable-responsive").rows[id].cells[5].innerText  		
			$('#pCode').val(medicalServiceFacilityCode)
			$('#pCodeForm').val(medicalServiceFacilityCode)
			$('#pName').val(serviceFacilitiesName)
			if(chargeCategory === '甲') {
				$('#pChargeCategory').val(1)
			} else if(chargeCategory === '乙') {
				$('#pChargeCategory').val(2)
			} else {
				$('#pChargeCategory').val(3)
			}	
			$('#pRemarks').val(remarks)
			$('#pUsingScope').val(restrictedUsingScope)	
	}
</script>
</body>
</html>