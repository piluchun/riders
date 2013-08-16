define(function(require, exports, module) {

    var Message = require("./Message");
    
    var utils = require("./protocol_utils");
    
    var m = {
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

    var message = new Message();
    document.write("new Message's Subject : " + message.getSubject() + "<br>");
    document.write("new Message's type : " + message.getType() + "<br>");
    document.write("new Message's data : " + message.getData() + "<br>");
    message.setMessage(m);
    document.write("setMessage's Subject : " + message.getSubject() + "<br>");
    document.write("setMessage's type : " + message.getType() + "<br>");
    document.write("setMessage's data : " + JSON.stringify(message.getData()) + "<br>");
    message.setSubject("activity");
    message.setType("add_activity");
    message.setData({
        "id" : 11,
        "title" : "this moring",
        "content" : "dddd"
    });
    document.write("new ubject : " + message.getSubject() + "<br>");
    document.write("new type : " + message.getType() + "<br>");
    document.write("new data : " + JSON.stringify(message.getData()) + "<br>");

    var m1 = new Message();

    document.write("base Message : " + JSON.stringify(m1.getMessage()) + "<br>");
    
    var v = utils.Base64.encode("吕齐");
    document.write("base64 encoded :" + v +  "<br>");
    var v1 = utils.Base64.decode(v);
    document.write("base64 encoded :" + v1+ "<br>");
})