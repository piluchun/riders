
define(function(require, exports, module) {
	
require("lushu");

/**************************************
* 路书
* @param src 出发点
* @param target 目的地
*
**************************************/
function RidersLushu(src,target){
	this.src = src;
	this.target = target;
	var map = this.init();
	this.query(map);
	}
	
	RidersLushu.prototype.init = function(){
		var map = new BMap.Map('map_canvas');
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 13);
		map.enableScrollWheelZoom();
		//alert("init function :" +map);
		return map;
		}
	
	RidersLushu.prototype.query = function(map){
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
					defaultContent:"从"+src.value+"到"+target.value,
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
		drv.search(this.src, this.target);
		};
	
	module.exports = RidersLushu;
	})


  