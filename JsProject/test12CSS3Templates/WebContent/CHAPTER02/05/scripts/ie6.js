/**
@prefix : <http://purl.org/net/ns/doas#> .
</assets/script/ie6.js> a :JavaScript;
 :shortdesc "ie6.js";
 :dependencies "jQeryに依存します。" .
*/

jQuery(function(){
	$('#menu li').hover(function(){
		$(this).children('ul').show();
	}, function(){
		$(this).children('ul').hide();
	});
});
