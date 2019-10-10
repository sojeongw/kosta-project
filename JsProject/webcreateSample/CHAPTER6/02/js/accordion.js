jQuery(function(){
$("dd").css("display","none");
$("dt").click(function(){
	if($("+dd",this).css("display")=="none"){
		$("+dd",this).slideDown(250);
		$(this).addClass("selected");
	}
else{
		$("+dd",this).slideUp(250);
		$(this).removeClass("selected");
}
});
});

