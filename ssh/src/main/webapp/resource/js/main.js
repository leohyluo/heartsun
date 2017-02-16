//全局变量
var param = null;

function changePage(target) {
	var currentUrl = window.location.href;
	var preUrl = {preUrl : currentUrl};
	if(param != null) {
		param = $.extend(param, preUrl);
	} else {
		param = preUrl;
	}
	target += ".html";
	$.mobile.chagePage(target, {transition : 'slideup'});
}