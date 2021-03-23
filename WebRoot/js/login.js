function loginAction(){
	$(".btn").css({"background-color": "#449edd",
	"color":"#fff",
	"opacity": "0.9"});
	var username=$("#name").val();
	var password=$("#password").val();
	$.ajax({
	url : "LoginServlet",
	type: 'post',
	data:{username:username,password:password},
	success : function(data) {
		console.log(data);
		if(data!="No"){
			window.location.href=data;
		}else{
			alert("登录失败");
		}	
	}
});
	return false;
}