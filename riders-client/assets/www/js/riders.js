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

/**************************************
* 位置对象
* @property init 初始化一张默认的地图
*
**************************************/
var position = {init:function(){
  	var map = new BMap.Map("map_canvas");            // 创建Map实例
	var point = new BMap.Point(116.404, 39.915);    // 创建点坐标
	map.centerAndZoom(point,15);                     // 初始化地图,设置中心点坐标和地图级别。
	map.enableScrollWheelZoom();
}};



/**************************************
* 路书
* @param src 出发点
* @param target 目的地
*
**************************************/
function RidersLushu(src,target){
	this.src = src;
	this.target = target;
	var map;
	var lushu;
	this.init = function(){
		map = new BMap.Map('map_canvas');
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 13);
		//alert("init function :" +map);
		}
	this.query = function(){
		//alert("query function :" +map);
		var myIcon = new BMap.Icon("../img/2.gif",
					{width:40,height:40},{anchor:new BMap.Size(40,40)});  
		var drv = new BMap.DrivingRoute('北京', {
			onSearchComplete: function(res) {
				if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
					var arrPois = res.getPlan(0).getRoute(0).getPath();
					map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
					map.setViewport(arrPois);
					lushu = new BMapLib.LuShu(map,arrPois,{
					defaultContent:"从"+src+"到"+target,
					speed:4500,
					icon:myIcon,
					landmarkPois: [
					   {lng:116.314782,lat:39.913508,html:'加油站',pauseTime:2},
					   {lng:116.315391,lat:39.964429,html:'高速公路收费<div><img src="http://map.baidu.com/img/logo-map.gif"/></div>',pauseTime:3},
					   {lng:116.381476,lat:39.974073,html:'肯德基早餐<div><img src="http://ishouji.baidu.com/resource/images/map/show_pic04.gif"/></div>',pauseTime:2}
					]}); 
					//alert("query function :"+ lushu);
					lushu.start();  
				}
			}
		});
		drv.search(src, target);
		}
	}
  