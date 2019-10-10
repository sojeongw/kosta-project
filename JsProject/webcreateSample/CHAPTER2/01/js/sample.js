//パンくずリスト(IE8対策)
jQuery(function(){
if(!jQuery.support.opacity){
for(i = 0; i <= 10; i++) {
zIndexNum = 20 - i;
$("#breadcrumbs a:eq("+i+")").css("zIndex",zIndexNum);
}
}
});
