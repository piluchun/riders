package com.leadtone.riders;

import java.util.Timer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.leadtone.mig.tools.annotations.Config;
import com.leadtone.riders.server.DbCheckTimerTask;
import com.leadtone.riders.utils.MemClientFactory;


@Component
public class InitEnvironment {
    
    private static final Logger log = Logger.getLogger(InitEnvironment.class);
    
    public static ApplicationContext context = null;
    
    @Config("memcached_servers")
    private String memcachedServers;
    
    @Config("check_consistence_thread")
    private int consistenceThread = 5;
    
    
    @Config("memcached_client_size")
    private int clientPoolSize = 10;
    
    
    @Config("memcached_client_check_period")
    private int cycleTime = 60;
    
    @Config("sync_memcached_key")
    private String syncMemcahcedKeys = "mobile,server,email,client";
    
    @Config("db_check_period")
    private int dbCheckPeriod = 30;
    
    public InitEnvironment() {
        
    }
    
    public static boolean initLog4j() {
        boolean result = false;
        try {
            DOMConfigurator.configure(ClassLoader
                .getSystemResource("log4j.xml"));
            result = true;
            log.info("init log4j successed!");
        } catch (Exception e) {
            log.error("init log4j error!" +  e.getMessage() ,e );
        }
        return result;
    }
    
    public static ApplicationContext initAppclicatContext() {
        try {
            context = new ClassPathXmlApplicationContext(
                new String[] {"classpath:applicationContext.xml"});
//            context.getBean("jdbcTemplate");
            log.info("init applicationContext successed!");
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("init applicationContext error! " + e.getMessage(),e);
        }
        
        return context;
    }
    
    public static ApplicationContext getAppclicatContextInstance(){
    	if (context == null){
    		initAppclicatContext();
    	}
    	return context;
    }
    
   
    
    public void initSchedule(){
    	Timer timer = new Timer();
        timer.schedule(new DbCheckTimerTask(),0,dbCheckPeriod*1000);
    }

    public boolean initMemClientFactory() {
        MemClientFactory mf = null;
        try {
           String [] keys = syncMemcahcedKeys.split(ServerConstants.SEPARATOR_COMMA);
           int clientSize = (consistenceThread)*(keys.length+1)+clientPoolSize;
           mf =  MemClientFactory.getInstance(memcachedServers, clientSize);
           mf.checkConnection(cycleTime*1000);
        } catch (Exception e) {
            log.error("init MemcachedClientFactory Error . " + e.getMessage() ,e);
        }
        
        return mf == null ? false : true;
        
    }
    
}
