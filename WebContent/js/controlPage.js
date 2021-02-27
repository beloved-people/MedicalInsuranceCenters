/**
 * 实现页面切换
 */
$(function() {
	
    $("#menu-ul").on("click", "li", function() {
        var sId = $(this).data("id") //获取data-id的值
        window.location.hash = sId //设置锚点
        loadInner(sId)
    });
    $("#menu-ul2").on("click", "li", function() {
        var sId = $(this).data("id")//获取data-id的值
        window.location.hash = sId //设置锚点
        loadInner2(sId)
    });
    $("#menu-ul3").on("click", "li", function() {
        var sId = $(this).data("id")//获取data-id的值
        window.location.hash = sId //设置锚点
        loadInner3(sId)
    });
    function loadInner(sId) {
        var sId = window.location.hash
        var pathn, i
        switch(sId) {
            case "#diagnosis-treatment-project":
                pathn = "DiagnosisAndTreatmentProject.jsp"
                i = 0
                $("#main").load(pathn)
                break
            case "#":
                pathn = ""
                i = 1
                $("#main").load(pathn)
                break
            case "#":
                pathn = ""
                i = 2
                $("#main").load(pathn)
                break
            case "#":
                pathn = ""
                i = 3
                $("#main").load(pathn)
                break
            default:
                pathn = ""
                i = 0
                $("#main").load(pathn)
                break
        }
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
    
    function loadInner2(sId) {
        var sId = window.location.hash
        var pathn, i
        switch(sId) {
            case "#drug-info":
                pathn = "DrugInfo.jsp"
                i = 0
                $("#main").load(pathn)
                //$("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
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
                pathn = "ShowDesignatedMedicalInstitutions.jsp"
                i = 3
                $("#main").load(pathn)
                break
            default:
                pathn = "Dayin.jsp"
                i = 0
                $("#main").load(pathn)
                break
        }
//        alert(pathn)
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
    function loadInner3(sId) {
        var sId = window.location.hash;
        var pathn, i;
        switch(sId) {
            case "#diagnosis-treatment-project":
                pathn = "DiagnosisAndTreatmentProject.jsp"
                i = 0
                $("#main").load(pathn)
                break
            case "#":
                pathn = "AddPersonnel.jsp"
                i = 1
                $("#main").load(pathn)
                break
            case "#":
                pathn = ""
                i = 2
                $("#main").load(pathn)
                break
            case "#":
                pathn = ""
                i = 3
                $("#main").load(pathn)
                break
            default:
                pathn = ""
                i = 0
                $("#main").load(pathn)
                break
        }
        //$("#main").load(pathn); //加载相对应的内容
//        $("#ceshi li").eq(i).addClass("active").siblings().removeClass("active"); //当前列表高亮
    }
    var sId = window.location.hash;
    loadInner(sId);
})





























