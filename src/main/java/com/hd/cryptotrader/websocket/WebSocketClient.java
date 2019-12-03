package com.hd.cryptotrader.websocket;

import java.net.URISyntaxException;

public interface WebSocketClient {
	public void startPriceMonitor() throws URISyntaxException, InterruptedException;
}
