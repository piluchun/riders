
define(function(require, exports, module) {
	require("./jquery");
	
	var RidersLushu = require("./baidu_map");
	
	exports.init = function(){
		var src = "东大桥";
		var target = "富丰桥";
		var ridersLushu = new RidersLushu(src,target);
		ridersLushu.init();
		$("#go").click(function(){
			src = $("#src").val();
			target = $("#target").val();
			ridersLushu = new RidersLushu(src,target);
			var map = ridersLushu.init();
			ridersLushu.query(map);
		})
	};
})