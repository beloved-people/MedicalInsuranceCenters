/**
 * 
 */
$(function() {
	$('#submit').click(function(){
		$.ajax({
			type:'POST',
			url:'LoginServlet',
			data:{
				operatorName:$('#inputName').val(),
				operatorPwd:$('#inputPassword').val(),
				jobNumber:$('#inputCode').val()
			},
			success:function(response,status,xhr){
				alert(response)
			}
		})
	})
})



