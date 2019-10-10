/**
@prefix : <http://purl.org/net/ns/doas#> .
</assets/script/ie6_7_8.js> a :JavaScript;
 :shortdesc "ie6_7_8.js";
 :dependencies "jQeryに依存します。" .
*/

jQuery(function(){
	$('#demoArea02 li').each(function() {
		var linkHref = $(this).children('a').attr('href');
		if(linkHref) {
			if(linkHref.match(/2011/)) { $(this).append('<span class="year2011">2011</span>'); }
			if(linkHref.match(/2010/)) { $(this).append('<span class="year2010">2010</span>'); }
			if(linkHref.match(/2009/)) { $(this).append('<span class="year2009">2009</span>'); }
		}
	});
	$('#demoArea02 li span').css({
		'width': '165px',
		'position': 'absolute',
		'top': '0',
		'left': '0',
		'text-align': 'center',
		'font-size': '77%',
		'font-weight': 'bold',
		'line-height': '2',
		'color': '#fff'
	});
	$('#demoArea02 li span.year2011').css({ 'background': '#f00' });
	$('#demoArea02 li span.year2010').css({ 'background': '#900' });
	$('#demoArea02 li span.year2009').css({ 'background': '#300' });
});
