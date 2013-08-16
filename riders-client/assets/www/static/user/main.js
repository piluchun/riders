// JavaScript Document
define(function(require,exports,module){
	
	require("./jquery");
	
	
	$(function() {
        $("#userList a").click(function(){
			var name = $("h2",this).text();
			if (name==""){
				 name = $(this).text().trim();
				}
			$.mobile.changePage("user.html?name="+name);
			}); 
        })






	});