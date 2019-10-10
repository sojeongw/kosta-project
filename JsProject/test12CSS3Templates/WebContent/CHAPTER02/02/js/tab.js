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

	$(function() {
		// CSS3に対応していないIE用
		if ($.browser.msie && $.browser.version < 9) {
			$(".page").each(function() {
				var _this = this;
				$(".tab a", this).click(function() {
					$(".content").hide();
					$(".content", _this).show();
					return false;
				});
			});
		}

		// 初回表示用の処理
		if (!location.hash.length) {
			location.hash = "page-1";
		}
	});

})(jQuery);
