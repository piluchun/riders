// JavaScript Document

define(function(require, exports, module) {

    require("jquery");
    require("underscore");
    var Sock = require("../socket/socket");

    var Message = require("../protocol/Message");

    var loginRequest = {
        "version" : "1.0",
        "msg_id" : "1vafd",
        "from" : "lvqi@leadtone.com",
        "to" : "server",
        "subject" : "user",
        "content" : {
            "type" : "login",
            "data" : {
                "email" : "lvqi@leadtone.com",
                "pwd" : "1234"
            }
        },
        "createDate" : "20130227121212",
        "status" : "0"
    };

    var sock = new Sock();
    sock.init();

    $(function() {
        $("#login_btn").click(function() {
            var type = "login";
            var subject = "user";
            var email = $("#email").val();
            var password = $("#password").val();
            var message = new Message();
            message.setSubject(subject);
            message.setType(type);
            message.setData({
                "email" : email,
                "pwd" : password
            });
            var request;
            if(_.isNull(message.msg)){
                 //console.log(JSON.stringify(message.baseMsg));
                 request = JSON.stringify(message.baseMsg);
            }else{
                //console.log(JSON.stringify(message.msg));
                 request = JSON.stringify(message.msg);
            }
            sock.send(request);
        });
    });

})

