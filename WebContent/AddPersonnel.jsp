<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>个人基本信息维护</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/welcome.css" rel="stylesheet">
<script src="vue/vue.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body onload="into()">
<div class="container-fluid" >
 <main id="main" style="padding:0;">
 		<div class="row">
			<h3 class="col-md-12">人员信息</h3>
			<ol class="breadcrumb">
  				<li><a href="Welcome.jsp">主页</a></li>
  				<li class="active">人员信息添加</li>

			</ol>
		</div>
		<div id="container-fluid" class="row">
			<div class="col-md-12">
				<h4 class="text-left">添加人员信息</h4>
				<form action="AddPersonnel" method="post" class="form-horizontal">
					<div class="form-group">
					    <label for="certificateID" class="col-sm-1 control-label">证件类型</label>
					    <div class="col-sm-5">
					    	<select class="form-control" name="certificateID" id="certificateID">
					    		<option>请选择</option>
					    		<option value="01">居民身份证（户口簿）</option>
					    		<option value="02">中国人民解放军军官证</option>
					    		<option value="03">中国人民武装警察警官证</option>
					    		<option value="04">香港特区护照/港澳居民来往内地通行证</option>
					    		<option value="05">香港特区护照/港澳居民来往内地通行证</option>
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
					    		<option>请选择</option>
					    		<option value="1">汉族</option>
								<option value="2">蒙古族</option>
								<option value="3">彝族</option>
								<option value="4">侗族</option>
								<option value="5">哈萨克族</option>
								<option value="6">畲族</option>
								<option value="7">纳西族</option>
								<option value="8">仫佬族</option>
								<option value="9">仡佬族</option>
								<option value="10">怒族</option>
								<option value="11">保安族</option>
								<option value="12">鄂伦春族</option>
								<option value="13">回族</option>
								<option value="14">壮族</option>
								<option value="15">瑶族</option>
								<option value="16">傣族</option>
								<option value="17">高山族</option>
								<option value="18">景颇族</option>
								<option value="19">羌族</option>
								<option value="20">锡伯族</option>
								<option value="21">乌孜别克族</option>
								<option value="22">裕固族</option>
								<option value="23">赫哲族</option>
								<option value="24">藏族</option>
								<option value="25">布依族</option>
								<option value="26">白族</option>
								<option value="27">黎族</option>
								<option value="28">拉祜族</option>
								<option value="29">柯尔克孜族</option>
								<option value="30">布朗族</option>
								<option value="31">阿昌族</option>
								<option value="32">俄罗斯族</option>
								<option value="33">京族</option>
								<option value="34">门巴族</option>
								<option value="35">维吾尔族</option>
								<option value="36">朝鲜族</option>
								<option value="37">土家族</option>
								<option value="38">傈僳族</option>
								<option value="39">水族</option>
								<option value="40">土族</option>
								<option value="41">撒拉族</option>
								<option value="42">普米族</option>
								<option value="43">鄂温克族</option>
								<option value="44">塔塔尔族</option>
								<option value="45">珞巴族</option>
								<option value="46">苗族</option>
								<option value="47">满族</option>
								<option value="48">哈尼族</option>
								<option value="49">佤族</option>
								<option value="50">东乡族</option>
								<option value="51">达斡尔族</option>
								<option value="52">毛南族</option>
								<option value="53">塔吉克族</option>
								<option value="54">德昂族</option>
								<option value="55">独龙族</option>
								<option value="56">基诺族</option>					    	
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
					    	<select class="form-control" id="degreeID" name="degreeID">
					    		<option>请选择</option>
								<option value="01">研究生</option>
								<option value="02">大学本科（简称：本科）</option>
								<option value="03">大学专科和专科学校</option>
								<option value="04">中专或中技</option>
								<option value="05">高中</option>
								<option value="06">初中</option>
								<option value="07">小学</option>
								<option value="08">文盲或半文盲</option>
					    	</select>
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
					    <label for="outlookID" class="col-sm-1 control-label">政治面貌</label>
					    <div class="col-sm-5">
					    	<select class="form-control" id="outlookID" name="outlookID">
					    			<option>请选择</option>
									<option value ="01">中共党员</option>
									<option value ="02">共青团员</option>
									<option value ="03">民革党员</option>
									<option value ="04">民盟盟员</option>
					    	</select>
					    </div>
					    <label for="identity" class="col-sm-1 control-label">个人身份</label>
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
					    	<select class="form-control" id="dutyID" name="dutyID">
					    		<option>请选择</option>
								<option value ="01">国家级正职</option>
								 <option value ="02">国家级副职</option>
					    	</select>
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
							<select class="form-control" name="personnelCategoryID" id="personnelCategoryID">
								<option>请选择</option>
								<option value ="01">单位在岗</option>
								 <option value ="02">个体</option>
							</select>
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
		<script type="text/javascript">
			var vm = new Vue({
				el:"#container-fluid",
				data:{
					certificateNumber:''
				}
			})
		</script>
		</main>
</div>
<div>
	<c:choose>
		<c:when test="${msg eq '添加成功' }">
			<script>
 					alert("添加成功！");
 			</script>
		</c:when>
		<c:when test="${msg eq '添加失败' }">
			<script>
 					alert("添加失败！");
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
		"技工学校","高中","初中","小学","文盲或半文盲"];
		var outlook = ["中共党员","中共预备党员","共青团员","民革党员","民盟盟员","民建会员","民进会员","农工党党员",
		"致公党党员","九三学社社员","台盟盟员","无党派人士","群众（现称普通居民，与居民身份证相对应）"
		];
		var duty = ["国家级正职","国家级副职","部级正职","部级副职","厅局级正职","厅局级副职","县处级正职","县处级副职",
		"乡科级正职","乡科级副职","科员级","办事员级","无"];
		var category = ["单位在岗","个体","自由职业","非正规就业","非全日制就业","中心一次性缴费","中心协保","中心退养","其他"
		];
		var num = [
			"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
			"22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42",
			"43","45","46","47","48","49","50","51","52","53","54","55","56","57"
		];
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
		}
	</script>
	</body>
</html>