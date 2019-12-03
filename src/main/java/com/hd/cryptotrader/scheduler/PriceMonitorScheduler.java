package com.hd.cryptotrader.scheduler;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hd.cryptotrader.websocket.WebSocketClient;

import ch.qos.logback.classic.Level;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class PriceMonitorScheduler {

	@Autowired
	private WebSocketClient client;
	
	@Scheduled(cron = "30 59 23 * * ?")
	  public void binancePriceMonitor() throws InterruptedException {
			try {
				client.startPriceMonitor();
			}catch(Exception e) { 
				log.log(Level.ERROR, e.getMessage());
			}
	}
}