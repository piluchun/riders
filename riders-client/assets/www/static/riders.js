/**************************************
启动时自动加载底部菜单
**************************************/

var $page;
$(document).on("pagecreate", function(e) {
	$page = $(e.target);
	var pageId = $page.attr("id");
	//加载底部菜单
	createFooter($page,pageId);
	pageRefresh();
});
