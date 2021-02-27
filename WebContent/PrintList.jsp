<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>市基本医疗保险报销医疗费用结算清单</title>
<link href="css/bootstrap.min.css" rel="stylesheet">	
<link href="css/welcome.css" rel="stylesheet">
<script type="text/javascript" src="vue/vue-router.js"></script>
<script type="text/javascript" src="vue/vue.js"></script>
</head>
<body>
	<div class="container-fluid">
	 <main id="main" style="padding:0;">
		<div class="row" >
			<form class="form-inline" action="Dayin" method="post">
				<div class="form-group">
    				<label for="DC">人员ID</label>
    				<input type="text" name="DC" class="form-control" id="DC" placeholder="输入人员ID即可预结算">
 				 </div>
				<button type="submit" class="btn btn-default" @click="start">确定</button>
			</form>
		</div>
		<div class="row" id="app">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h2 class="text-center">市基本医疗保险报销医疗费用结算清单</h2>
				<h4 class="text-right">结算日期：<strong>{{arr | myfilter1}}</strong></h4>
				<div class="panel panel-info">
   						 <table class="table table-bordered text-center">
   						 	<tr>
   						 		<td>单位名称</td>
   						 		<td colspan="2">${com1.companyName }</td>
   						 		<td>单位编号</td>
   						 		<td colspan="2">${pers.companyCode }</td>
   						 	</tr>
   						 	<tr>
   						 		<td style="width:100px;">姓名</td>
   						 		<td style="width:200px;">${pers.name }</td>
   						 		<td style="width:100px;">个人编号</td>
   						 		<td>${pers.personId }</td>
   						 		<td style="width:100px;">人员类别</td>
   						 		<td>${pers.certificateId }</td>
   						 	</tr>
   						 	<tr>
   						 		<td>性别</td>
			      				<td>${pers.gender }</td>
			      				<td>报销类别</td>
			      				<td></td>
			      				<td>住院次数</td>
			      				<td></td>
   						 	</tr>
   						 	<tr>
   						 		<td>就诊医院</td>
				  				<td colspan="2">${des1.serviceOrganizationName }</td>
				  				<td>就诊时间</td>
				  				<td colspan="2">${vis1.admissionDate }</td>
   						 	</tr>
						</table>
						<div class="panel-body">
							<h4><strong>结算明细：</strong></h4>
							<h5>起付标准:</h5>
							<p>(100)～10000 20%;10001～20000 10%;30000以上 5%;20000以上全部自费</p>
  							<h5>自费项目:</h5>
  							<div>
  								<table class="table table-bordered text-center">
	  								<thead>
									   <tr>
										   <td>编号</td>
										   <td>价格</td>
										    <td>数量</td>
											<td>金额</td>			    
										</tr>
								   	</thead>
								  	 <tbody>
										<c:forEach items="${chu1}"  var="item" >
											<tr>
												<td>${item.dc}</td>			
												<td>${item.medicineName }</td>		
												<td>${item.unitPrice }</td>
												<td>${item.amount}</td>
											</tr>
									  </c:forEach>
									</tbody>
  								</table>
  							</div>
  							<h5>乙类项目:</h5>
  							<div>
  								<table class="table table-bordered text-center">
									<thead>
									    <tr>
									    <td>编号</td>
									    <td>名称</td>
									    <td>价格</td>
									    <td>数量</td>
									    <td>金额</td>
									    </tr>
								    </thead>
								    <tbody>
										<c:forEach items="${chu2}"  var="item" >
											<tr>
												<td>${item.dc}</td>
												<td>${item.medicineName }</td>
												<td>${item.unitPrice }</td>
												<td>${item.amount }</td>
												<td>${item.sumMoney }</td>
											</tr>
										</c:forEach>
									</tbody>
							  </table>
  							</div>
  							<h5>甲类项目：</h5>
  							<div>
  								<table class="table table-bordered text-center">
								   	<thead>
									    <tr>
									    <td>编号</td>
									    <td>名称</td>
									    <td>价格</td>
									    <td>数量</td>
									    <td>金额</td>
									    </tr>
								    </thead>
								    <tbody>
										<c:forEach items="${chu3}"  var="item" >
											<tr>
												<td>${item.dc}</td>
												<td>${item.medicineName }</td>
												<td>${item.unitPrice }</td>
												<td>${item.amount }</td>
												<td>${item.sumMoney }</td>
											</tr>
										</c:forEach>
									</tbody>
							  </table>
  							</div>
  							<h5>个人自费费用：<strong>${zi1 }</strong></h5>
  							<h5>中心报销金额：<strong>${bao1 }</strong></h5>
  						</div>
  						<table class="table table-bordered text-center">
								<tr>
									<th class="text-center" rowspan="2"  width="100px" style="line-height:55px">拨付金额</th>	
									 <th>大写:
										   <strong>
										   ${str}
										   </strong>
									  </th>			
								</tr>
								<tr>
									<th>小写:<strong>${bao1 }</strong></th>
								</tr>
						</table>
				</div>
				<div class="text-left">本表一式三联，财务科、结算科、参保人各一联。</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row noprint">
			<div class="col-md-1"></div>
			<div class="col-md-10 btn-group" role="group" aria-label="...">
			 <OBJECT id="wb" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
			 <input type="button" class="btn btn-primary" value="打印" onclick="javascript:printit();" />
			 <input type="button" class="btn btn-primary" name="button_fh" value="返回" onclick="javascript:history.back();">
			</div>
			<div class="col-md-1"></div>
		</div>
<script type="text/javascript">   
	function printpreview(){
	  // 打印页面预览
	  wb.execwb(7,1);
	}
	function printit(){
		 if (confirm('确定打印吗？')){
		  wb.ExecWB(6,1);
		 }
	}
</script>		
<script type="text/javascript">
Vue.filter('myfilter1',function(data){				
	var d=new Date(data)
	var y=d.getFullYear()
	var m=d.getMonth()+1
	var date=d.getDate()
	var hour=d.getHours()
	var minute=d.getMinutes()
	return y+'-'+m+'-'+date+' '+hour+':'+minute
});
var vm=new Vue({
	el: '#app',
	data: {
		arr: new Date
	},
	methods: {
		start(){
			var that=this;
			setInterval(function(){
			var y=that.arr
			that.arr=arr},300)
		}
	}
})
</script>
</main>	
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>