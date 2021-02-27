/**
 * 验证码getVerify.js
 */
$(function(){
	var verifyCode = new GVerify("v_container")
	function preventDefa(e){ 
		  if(window.event){ 
		    window.event.returnValue = false;  
		  } 
		  else{ 
		    e.preventDefault(); 
		  }  
	} 
		$('#submit').on('click',function(e){
			$('#error').empty()
			if(!verifyCode.validate($('#codeInput').val())){
				$('#error').html('skjfld')
			}
		})

})






