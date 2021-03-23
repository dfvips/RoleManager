$(document).ready(function() {
	$("#page").load("AdminAll?count="+0);
	$("#page").on('click', "a", function(){
		 $("#page").load("AdminAll?count="+$(this).attr("id"));
	});
	$("#page").on('click', "span", function(){
		var count=$(this).html()-1;
		$("#page").load("AdminAll?count="+count);
	});
	$("#page").on('click', "#add", function(){
		$("#panel_default").css("display","none");
		$("#panel_add").css("display","block");	
	});
	$("#page").on('click', "#msg", function(){
		$("#panel_default").css("display","none");
		$("#alter").fadeIn(1500);
		var id=$(this).find("td")[0].id;
		var name=$(this).find("td")[0].innerHTML;
		var gender=$(this).find("td")[1].innerHTML;
		var phone=$(this).find("td")[2].innerHTML;
		var email=$(this).find("td")[3].innerHTML;
		var address=$(this).find("td")[4].innerHTML;
		$("#update_name").val(name);
		$("#update_gender").val(gender);
		$("#update_phone").val(phone);
		$("#update_email").val(email);
		$("#update_address").val(address);
		$("#update_name").attr("class",id);
	});
	$("#page").on('click',"#delete",function(){
		$("#panel_default").css("display","none");
		$("#page1").load("AdminDelete?count="+0);
		$("#panel_delete").css("display","block");	
	});
});
$("#page1").on('click',"#delete_cancle",function(){
		$("#panel_delete").css("display","none");
		$("#panel_default").fadeIn(1500);
});
$("#page1").on('click',"#delete_msg",function(){
	if(confirm("确实要删除吗？")){
		var id=$("#delete_msg").find("td")[0].id;
		$.ajax({
			url : "Delete",
			type: 'post',
			data:{id:id},
			success : function(data) {
				console.log(data);
				if(data!="No"){
					alert("刪除成功");
				}
			}
		});
		$("#panel_delete").css("display","none");
        $("#panel_default").fadeIn(1500);
    }else {
        alert("已经取消了删除操作");
    }
});
$("#page1").on('click', "a", function(){
	 $("#page1").load("AdminDelete?count="+$(this).attr("id"));
});
$("#page1").on('click', "span", function(){
	var count=$(this).html()-1;
	$("#page1").load("AdminDelete?count="+count);
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
$("#btn_update").click(function(){
	var id=$("#update_name").attr("class");
	var name=$("#update_name").val();
	var gender=$("#update_gender").val();
	var phone=$("#update_phone").val();
	var email=$("#update_email").val();
	var address=$("#update_address").val();
	var password=$("#update_password").val();
	var repassword=$("#update_repassword").val();
	console.log(name+gender+phone+email+address+password+repassword);
	
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
				url : "AdminUpdate",
				type: 'post',
				data:{name:name,gender:gender,password:password,phone:phone,email:email,address:address,id:id},
				success : function(data) {
					console.log(data);
					if(data!="No"){
						alert("修改成功");
						$("#page").load("AllUsermsg?count="+0);
						$("#alter").css("display","none");	
						$("#panel_default").fadeIn(1500);
					}else{
						alert("修改失败");
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
$("#btn_cancle").click(function(){
	$("#alter").css("display","none");	
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