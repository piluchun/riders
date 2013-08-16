define(function(require, exports, module) {

    var u = require("./protocol_utils");
    require("underscore");

    function Message() {
        this.msg = null;
        this.baseMsg = {
            "version" : "1.0",
            "msg_id" : u.getCurrentTime(),
            "from" : u.getCurrentUser(),
            "to" : "server",
            "content" : {},
            "createDate" : u.getCurrentTime(),
            "status" : "0"
        }
    }


    Message.prototype = {
        getSubject : function() {
            if (!_.isNull(this.msg)) {
                return this.msg.subject;
            }
            return null;
        },
        setSubject : function(value) {
            if (!_.isNull(this.msg)) {
                this.msg["subject"] = value;
            }
            this.baseMsg["subject"] = value;
        },
        getType : function() {
            if (!_.isNull(this.msg)) {
                return this.msg.content.type;
            }
            return null;
        },
        setType : function(value) {
            if (!_.isNull(this.msg)) {
                this.msg.content["type"] = value;
            }
            this.baseMsg.content["type"] = value;
        },
        getData : function() {
            if (!_.isNull(this.msg)) {
                return this.msg.content.data;
            }
            return null;
        },
        setData : function(value) {
            if (!_.isNull(this.msg)) {
                this.msg.content["data"] = value;
            }
            this.baseMsg.content["data"] = value;
        },
        setMessage : function(message) {
            this.msg = message;
        },
        getMessage : function(message) {
            if (!_.isNull(this.msg)) {
                return this.msg;
            }
            return this.baseMsg;
        }
    };

    module.exports = Message;

})

