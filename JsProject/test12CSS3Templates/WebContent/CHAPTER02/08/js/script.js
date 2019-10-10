/**
 * script
 * 
 * @copyright   RaNa design associates, inc.
 * @author      keisuke YAMAMOTO <keisukey@ranadesign.com>
 * @link        http://kaelab.ranadesign.com/
 * @version     1.0
 * @date        2012
 *
 */
(function($) {

	// メニューをクリックした時に、クラス名を切り替える。
	$(function() {
	
		$("nav a").click(function(event) {
			var page = this.hash.slice(1);
			$("body").removeClass().addClass(page);
			event.preventDefault();
		});
	});


})(jQuery);
