package com.hd.cryptotrader.scheduler;


import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.hd.cryptotrader.websocket.WebSocketClient;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PriceMonitorScheduler {

	@Autowired
	private WebSocketClient client;
	
	@Scheduled(cron = "59 * * * * ?")
	  public void binancePriceMonitor() throws InterruptedException {
			try {
				client.startPriceMonitor();
			}catch(Exception e) { 
				log.log(Level.ERROR, e.getMessage());
			}
	}
}