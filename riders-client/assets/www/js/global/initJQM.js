// JavaScript Document
$(document).bind('mobileinit',function(){
	$.mobile.loadingMessage = '加载中...';
    $.mobile.buttonMarkup.hoverDelay = "false";
	$.mobile.page.prototype.options.addBackBtn=true;
	$.mobile.page.prototype.options.backBtnText = "返回";
	$.mobile.page.prototype.options.backBtnTheme = "b";
	//$.mobile.ajaxEnabled = false;
	//$.mobile.linkBindingEnabled = false;
	

});
