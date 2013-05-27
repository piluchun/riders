package com.leadtone.riders.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import org.apache.log4j.Logger;

import com.leadtone.riders.protocol.beans.RidersMessage;

public class RidersRequestDataFilterHandler extends
		ChannelInboundMessageHandlerAdapter<Object> {

	private static Logger log = Logger.getLogger(RidersRequestDataFilterHandler.class);
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
	}
	
	
	
	 private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {

	        String request = ((TextWebSocketFrame) frame).text();
	        log.info(String.format("Channel %s received %s", ctx.channel().id(), request));
	        RidersMessage message = new RidersMessage();
	        
	    }
}
