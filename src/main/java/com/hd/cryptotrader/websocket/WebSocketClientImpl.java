package com.hd.cryptotrader.websocket;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.market.CandlestickInterval;

public class WebSocketClientImpl implements WebSocketClient{

	private static final int HOURS23_MINUTES59 = 86340000;
	
	@Autowired
	@Qualifier("BTCCandlestickEvent")
	private CandlestickEvent btcCandlestickEvent;
	
	@Autowired
	@Qualifier("ETHCandlestickEvent")
	private CandlestickEvent ethCandlestickEvent;
	
	@Autowired
	@Qualifier("ADACandlestickEvent")
	private CandlestickEvent adaCandlestickEvent;
	
	@Autowired
	@Qualifier("BTTCandlestickEvent")
	private CandlestickEvent bttCandlestickEvent;
	
	@Autowired
	@Qualifier("LINKCandlestickEvent")
	private CandlestickEvent linkCandlestickEvent;
	
	@Autowired
	@Qualifier("EOSCandlestickEvent")
	private CandlestickEvent eosCandlestickEvent;
	
	@Autowired
	@Qualifier("ETCCandlestickEvent")
	private CandlestickEvent etcCandlestickEvent;
	
	@Autowired
	@Qualifier("LTCCandlestickEvent")
	private CandlestickEvent ltcCandlestickEvent;
	
	@Autowired
	@Qualifier("TRXCandlestickEvent")
	private CandlestickEvent trxCandlestickEvent;
	
	@Autowired
	@Qualifier("WINCandlestickEvent")
	private CandlestickEvent winCandlestickEvent;
	
	@Autowired
	@Qualifier("XLMCandlestickEvent")
	private CandlestickEvent xlmCandlestickEvent;
	
	@Autowired
	@Qualifier("XRPCandlestickEvent")
	private CandlestickEvent xrpCandlestickEvent;
	
	@Autowired
	@Qualifier("XMRCandlestickEvent")
	private CandlestickEvent xmrCandlestickEvent;
	
	@Autowired
	@Qualifier("ZECCandlestickEvent")
	private CandlestickEvent zecCandlestickEvent;
	
	@Override
	public void startPriceMonitor() throws URISyntaxException, InterruptedException {
		BinanceApiWebSocketClient webSocketClient = BinanceApiClientFactory.newInstance().newWebSocketClient();
		String markets = "linkusdt,btcusdt,ethusdt,adausdt,bttusdt,eosusdt,etcusdt,ltcusdt,trxusdt,xlmusdt,xmrusdt,xrpusdt,winusdt,zecusdt";
		Closeable onCandlestickEvent = webSocketClient.onCandlestickEvent(markets, CandlestickInterval.ONE_MINUTE, response -> processCandleStick(response));
		
		try {
			Thread.sleep(HOURS23_MINUTES59);
			onCandlestickEvent.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	protected void processCandleStick(CandlestickEvent response) {
		if("BTCUSDT".equalsIgnoreCase(response.getSymbol())) {
			btcCandlestickEvent = response;
		}else if("ETHUSDT".equalsIgnoreCase(response.getSymbol())) {
			ethCandlestickEvent = response;
		}else if("LINKUSDT".equalsIgnoreCase(response.getSymbol())) {
			linkCandlestickEvent = response;
		}else if("ADAUSDT".equalsIgnoreCase(response.getSymbol())) {
			adaCandlestickEvent = response;
		}else if("BTTUSDT".equalsIgnoreCase(response.getSymbol())) {
			bttCandlestickEvent = response;
		}else if("EOSUSDT".equalsIgnoreCase(response.getSymbol())) {
			eosCandlestickEvent = response;
		}else if("ETCUSDT".equalsIgnoreCase(response.getSymbol())) {
			etcCandlestickEvent = response;
		}else if("LTCUSDT".equalsIgnoreCase(response.getSymbol())) {
			ltcCandlestickEvent = response;
		}else if("TRXUSDT".equalsIgnoreCase(response.getSymbol())) {
			trxCandlestickEvent = response;
		}else if("XLMUSDT".equalsIgnoreCase(response.getSymbol())) {
			xlmCandlestickEvent = response;
		}else if("XMRUSDT".equalsIgnoreCase(response.getSymbol())) {
			xmrCandlestickEvent = response;
		}else if("XRPUSDT".equalsIgnoreCase(response.getSymbol())) {
			xrpCandlestickEvent = response;
		}else if("WINUSDT".equalsIgnoreCase(response.getSymbol())) {
			winCandlestickEvent = response;
		}else if("ZECUSDT".equalsIgnoreCase(response.getSymbol())) {
			zecCandlestickEvent = response;
		}
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		WebSocketClientImpl impl = new WebSocketClientImpl();
//		try {
//			System.out.println("zero run " + new Date() );
//			
//			impl.startPriceMonitor();
////			impl.client3("wss://stream.binance.com:9443/ws/bnbbtc@trade");
//			System.out.println("first run " + new Date() );
//			impl.startPriceMonitor();
//			System.out.println("Second run " + new Date() );
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}