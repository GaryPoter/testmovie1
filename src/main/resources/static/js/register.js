$('#register').on('click', function () {
	var name = $('input#username').val();
	var email = $('input#email').val();
    var password = $('input#password').val();
    var repassword = $('input#repassword').val();
	if(valid_email(email) && valid_password(password)){
		if(!(password == repassword)){
			alert("密码不一致");
			$('input#repassword').select().focus();
			return;
		}
		$.ajax({
        async: false,
        type: 'POST',
        dataType: 'json',
        data:{name:name, paswd:password},
        url: '/movie/user/registerAction',
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest);
            console.log(textStatus);
            console.log(errorThrown);
        },
        success: function(response){
            if(0 == response.code){
                // document.getElementById("moviePage").click();
                $('#moviePage').click();
            }else {
                $('#username').select().focus();
            }
        }
    	});
	}else{
		alert("密码或者邮箱格式错误！");
		$('input#email').select().focus();
	}
});