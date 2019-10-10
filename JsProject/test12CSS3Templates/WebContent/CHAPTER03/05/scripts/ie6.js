/**
@prefix : <http://purl.org/net/ns/doas#> .
</assets/script/ie6.js> a :JavaScript;
 :shortdesc "ie6.js";
 :dependencies "jQeryに依存します。" .
*/

jQuery(function(){
	$('#demoArea01 li').each(function() {
		var linkHref = $(this).children('a').attr('href');
		var linkTitle = $(this).children('a').attr('title');
		if(linkHref) {
			if(linkHref.match(/.xls$/)) { $(this).children('a').css({ 'background': 'url(./images/demoarea_icon_01.gif) no-repeat left 0' }); }
			if(linkHref.match(/.doc$/)) { $(this).children('a').css({ 'background': 'url(./images/demoarea_icon_02.gif) no-repeat left 0' }); }
			if(linkHref.match(/.pdf$/)) { $(this).children('a').css({ 'background': 'url(./images/demoarea_icon_03.gif) no-repeat left 0' }); }
		}
		if(linkTitle) {
			if(linkTitle.match(/alreadyRead/)) { $(this).children('a').css({ 'background': 'url(./images/demoarea_icon_04.gif) no-repeat left 0' }); }
			if(linkTitle.match(/unread/)) { $(this).children('a').css({ 'background': 'url(./images/demoarea_icon_05.gif) no-repeat left 0' }); }
		}
	});
});
