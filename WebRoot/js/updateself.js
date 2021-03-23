$("#update").click(function(){
	var u_id=$(".user").attr("id");
	var phone=$("#phone").val();
	var email=$("#email").val();
	var address=$("#address").val();
	var password=$("#password").val();
	var repassword=$("#repassword").val();
	if(phone==""||email==""||address==""||password==""||repassword==""){
		alert("必填信息不能为空");
	}else{
		if(isPoneAvailable(phone)=="no"){
			alert("请输入合法手机号");
		}else if(email.indexOf("@") == -1 ){
			alert("请输入合法邮箱");
		}else if(password!=repassword){
			alert("两次密码不一致");
		}else{
			$.ajax({
				url : "UserMsgUpdate",
				type: 'post',
				data:{u_id:u_id,password:password,phone:phone,email:email,address:address},
				success : function(data) {
					console.log(data);
					if(data!="No"){
						alert("修改成功！");
						response.sendRedirect("user.jsp");
					}else{
						alert("修改失败");
					}	
				}
			});
		}
	}
	
});
$("#cancle").click(function(){
	window.close();
});
function isPoneAvailable(phone) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(phone)) {
        return "no";
    } else {
        return "yes";
    }
}
$("#logout").click(function(){
	$.ajax({
		url : "Logout",
		type: 'post',
		success : function(data) {
			console.log(data);
			if(data!="OK"){
				window.location.href=="login.jsp";
			}
		}
	});
});