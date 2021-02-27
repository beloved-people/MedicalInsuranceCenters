

var usageFrequencyId = [
	["请选择使用频次"],
	"qd","bid","tid","qid","qod","qw","biw","tiw","qow","2w",
	"3w","4w","q1/2h","qh","q2h","q3h","q4h","q6h","q8h","q12h","st"
];
//var dosageFormId = [
//	["请选择剂型"],
//	"注射剂","溶液剂","散剂","片剂","丸剂","气雾剂","软膏剂","乳化剂","泼淋剂","胶囊剂",
//	"中药汤剂","酊剂"
//];

var usageId = [
	["请选择用法"],
	"po","ivdrip","im","iv","ih","qw","ip","sig","ext","in",
	"ig","pr","ac","pc","am","pm","om","on","hs","sos","prn"
];

function into(){
	var a = document.getElementById("usageFrequencyId");
	//var b = document.getElementById("dosageFormId");
	var c = document.getElementById("usageId");
	
	a.length = usageFrequencyId.length;
	//b.length = dosageFormId.length;
	c.length = usageId.length;

	for(var i=0;i<usageFrequencyId.length;i++){
		a.options[i].text=usageFrequencyId[i];
	}
	//for(var i=0;i<dosageFormId.length;i++){
		//b.options[i].text=dosageFormId[i];
	//}
	for(var i=0;i<usageId.length;i++){
		c.options[i].text=usageId[i];
	}
}





