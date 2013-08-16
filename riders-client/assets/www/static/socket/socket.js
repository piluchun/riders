
define(function(require,exports,module){

	require("jquery");
	
	require("underscore");
	
	function Sock() {
		var socket;
        this.init = _.once(function(){
			if (!window.WebSocket) {
				window.WebSocket = window.MozWebSocket;
			}
	
			if (window.WebSocket) {
				socket = new WebSocket("ws://192.168.8.95:10009/websocket");
				socket.onmessage = function(event) {
					console.log(event.data); 
					};
			    socket.onopen = function(event) {
					console.log("Web Socket opened!");
				  };
				socket.onclose = function(event) {
					console.log("Web Socket closed"); 
				  };
				//return socket;
			} else {
				alert("Your browser does not support Web Socket.");
       		}
		});
	   this.send  = function(message) {
		  if (!window.WebSocket) { return; }
		  if (socket.readyState == WebSocket.OPEN) {
			socket.send(message);
		  } else {
			alert("The socket is not open.");
		  }
		}
    }

	
	module.exports = Sock;
	
})