$(function(){
	$('#register').click(function(){
		$.ajax({
			type: 'POST',
			url: 'Register',
			data: {
				operatorName:$('#operatorName').val(),
				operatorGender:$('input[name="operatorGender"]:checked').val(),
				operatorPwd:$('#inputPassword').val(),
				operatorAccount:$('#operatorAccount').val(),
				jobNumber:$('#jobNumber').val()
			},
			success: function(response, status, xhr) {
				alert(response)
			}
		})
	})
})











