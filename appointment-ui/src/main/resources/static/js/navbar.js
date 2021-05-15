var logout = function() {
	console.log("xxx");
	$.post("/logout", function() {
		$("#user").html('');
		$(".unauthenticated").show();
		$(".authenticated").hide();
		$.get("/");

	});
	return true;
};


function changeActiveNavItem(x) {
	var current = $(".active");
	current[0].className = current[0].className.replace(" active", "");
	$(x)[0].className += " active";
}