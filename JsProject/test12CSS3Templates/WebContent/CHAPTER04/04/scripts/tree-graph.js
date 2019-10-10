/**
@prefix : <http://purl.org/net/ns/doas#> .
</assets/script/tree-graph.js> a :JavaScript;
 :shortdesc "tree-graph.js";
 :dependencies "jQeryに依存します。" .
*/

jQuery(function(){
	$('#nav01 li').each(function() {
		var linkHref = $(this).children('a').attr('href');
		$(this).append('<span>' + linkHref + '</span>');
		
	});
	$('#nav02 li').each(function() {
		var linkHref = $(this).children('a').attr('href');
		$(this).append('<span>' + linkHref + '</span>');
		
	});
});
