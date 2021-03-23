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

$(".btn").click(function(){
	 window.open("updateself.jsp");
});