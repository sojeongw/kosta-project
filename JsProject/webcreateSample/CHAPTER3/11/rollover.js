function rollover() {
  var off = "_off."
  var on = "_on."	
  if(document.getElementsByTagName) {
    var images = document.getElementsByTagName("img");
    for(var i=0; i < images.length; i++) {
      if(images[i].getAttribute("src").match(off))
      {
	images[i].onmouseover = function() {
	  this.setAttribute("src", this.getAttribute("src").replace(off, on));
        };
        images[i].onmouseout = function() {
					this.setAttribute("src", this.getAttribute("src").replace(on, off));
				};
			}
		}

		var inputs = document.getElementsByTagName("input");
		for(var j=0; j < inputs.length; j++) {
			if(inputs[j].getAttribute("src")!=null && inputs[j].getAttribute("src").match(off))
			{
				inputs[j].onmouseover = function() {
					this.setAttribute("src", this.getAttribute("src").replace(off, on));
				};
				inputs[j].onmouseout = function() {
					this.setAttribute("src", this.getAttribute("src").replace(on, off));
				};
			}
		}
	}
}
if(window.addEventListener) {
	window.addEventListener("load", rollover, false);
}
else if(window.attachEvent) {
	window.attachEvent("onload", rollover);
}

