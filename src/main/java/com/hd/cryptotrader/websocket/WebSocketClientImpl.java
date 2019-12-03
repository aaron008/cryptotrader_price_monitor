package com.hd.cryptotrader.websocket;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.market.CandlestickInterval;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
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
			log.log(Level.ERROR,e.getMessage());
		} 
		
	}
	
	protected void processCandleStick(CandlestickEvent response) {
		
		if("BTCUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(btcCandlestickEvent, response);
		}else if("ETHUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(ethCandlestickEvent, response);
		}else if("LINKUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(linkCandlestickEvent, response);
		}else if("ADAUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(adaCandlestickEvent, response);
		}else if("BTTUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(bttCandlestickEvent, response);
		}else if("EOSUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(eosCandlestickEvent, response);
		}else if("ETCUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(etcCandlestickEvent, response);
		}else if("LTCUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(ltcCandlestickEvent, response);
		}else if("TRXUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(trxCandlestickEvent, response);
		}else if("XLMUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(xlmCandlestickEvent, response);
		}else if("XMRUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(xmrCandlestickEvent, response);
		}else if("XRPUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(xrpCandlestickEvent, response);
		}else if("WINUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(winCandlestickEvent, response);
		}else if("ZECUSDT".equalsIgnoreCase(response.getSymbol())) {
			this.mapCandleStickEvent(zecCandlestickEvent, response);
		}
	}

	private void mapCandleStickEvent(CandlestickEvent symbolCandlestickEvent, CandlestickEvent response) {
		symbolCandlestickEvent.setClose(response.getClose());
		symbolCandlestickEvent.setOpen(response.getOpen());
		symbolCandlestickEvent.setBarFinal(response.getBarFinal());
		symbolCandlestickEvent.setCloseTime(response.getCloseTime());
		symbolCandlestickEvent.setEventTime(response.getEventTime());
		symbolCandlestickEvent.setEventType(response.getEventType());
		symbolCandlestickEvent.setFirstTradeId(response.getFirstTradeId());
		symbolCandlestickEvent.setHigh(response.getHigh());
		symbolCandlestickEvent.setLastTradeId(response.getLastTradeId());
		symbolCandlestickEvent.setLow(response.getLow());
		symbolCandlestickEvent.setNumberOfTrades(response.getNumberOfTrades());
		symbolCandlestickEvent.setOpen(response.getOpen());
		symbolCandlestickEvent.setOpenTime(response.getOpenTime());
		symbolCandlestickEvent.setQuoteAssetVolume(response.getQuoteAssetVolume());
		symbolCandlestickEvent.setSymbol(response.getSymbol());
		symbolCandlestickEvent.setTakerBuyBaseAssetVolume(response.getTakerBuyBaseAssetVolume());
		symbolCandlestickEvent.setTakerBuyQuoteAssetVolume(response.getTakerBuyQuoteAssetVolume());
		symbolCandlestickEvent.setVolume(response.getVolume());
	}
	
}