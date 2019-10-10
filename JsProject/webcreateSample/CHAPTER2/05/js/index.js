jQuery(function(){

$('#moveMenu li a').mouseover(function(){


$('img:first-child',this).not(':animated').animate({
width: '100px',
height: '100px',
margin: '-10px',
}, 200);


for(i = 1; i < 20; i++) {

$('img[src*="_'+i+'."]',this).not(':animated').delay(i*100).animate({
width: '40px',
height: '40px',
margin: '-10px',
opacity: '0',
}, 200)
.animate({
width: '20px',
height: '20px',
margin: '0',
opacity: '1',
}, 200);

}

});


$('#moveMenu li a').mouseout(function(){

$('img:first-child',this).not(':animated').animate({
width: '84px',
height: '84px',
margin: '0',
}, 100);

$('img[src*="_"]',this).not(':animated').animate({
width: '20px',
height: '20px',
margin: '0',
opacity: '1',
}, 200);
});

});
