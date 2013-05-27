package com.leadtone.riders;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.leadtone.riders.server.RidersWebSocketServer;

public class RidersServer {
    private static Logger log = Logger.getLogger(RidersServer.class);
    
    public ApplicationContext context;
    
    public RidersWebSocketServer server;
    
    public void init() {
        context = InitEnvironment.initAppclicatContext();
        InitEnvironment.initLog4j();
//        context.getBean(InitEnvironment.class).initSchedule();
//        context.getBean(InitEnvironment.class).initMemClientFactory();
        server = context.getBean(RidersWebSocketServer.class);
    }
    

    
    
    public static void main(String args[]) {
        RidersServer service = new RidersServer();
            service.init();
            log.info("inited environment successed!");
            try {
				service.server.start();
			} catch (Exception e) {
				e.printStackTrace();
			} 
    }
    
}
