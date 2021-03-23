$(document).ready(function() {
	$("#page").load("AllUsermsg?count="+0);
	$("#page").on('click', "a", function(){
		 $("#page").load("AllUsermsg?count="+$(this).attr("id"));
	});
	$("#page").on('click', "span", function(){
		var count=$(this).html()-1;
		$("#page").load("AllUsermsg?count="+count);
	});
	$("#page").on('click', "#add", function(){
		$("#panel_default").css("display","none");
		$("#panel_add").css("display","block");	
	});
});
$("#logout").click(function(){
	$.ajax({
		url : "Logout",
		type: 'post',
		success : function(data) {
			console.log(data);
			if(data!="No"){
				window.location.href="login.jsp";
			}
		}
	});
});
$("#btn_add").click(function(){
	var name=$("#name").val();
	var gender=$("#gender").val();
	var phone=$("#phone").val();
	var email=$("#email").val();
	var address=$("#address").val();
	var password=$("#password").val();
	var repassword=$("#repassword").val();
	if(name==""||gender==""||phone==""||email==""||address==""||password==""||repassword==""){
		alert("必填信息不能为空");
	}else{
		if(gender!="男"&&gender!="女"){
			alert("请输入合法的性别(男/女)");
		}
		if(isPoneAvailable(phone)=="no"){
			alert("请输入合法手机号");
		}else if(email.indexOf("@") == -1 ){
			alert("请输入合法邮箱");
		}else if(password!=repassword){
			alert("两次密码不一致");
		}else{
			alert(name+gender+phone+email+address+password+repassword);
			$.ajax({
				url : "AddUser",
				type: 'post',
				data:{name:name,gender:gender,password:password,phone:phone,email:email,address:address,r_id:3},
				success : function(data) {
					console.log(data);
					if(data!="No"){
						alert("添加成功");
						$("#page").load("AllUsermsg?count="+0);
						$("#panel_add").css("display","none");	
					}else{
						alert("添加失败");
					}	
				}
			});
		}
	}
});
$("#cancle").click(function(){
	$("#panel_add").css("display","none");	
	$("#panel_default").fadeIn(1500);
});
function isPoneAvailable(phone) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(phone)) {
        return "no";
    } else {
        return "yes";
    }
}