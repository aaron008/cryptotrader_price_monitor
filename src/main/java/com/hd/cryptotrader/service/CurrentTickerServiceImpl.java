package com.hd.cryptotrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.binance.api.client.domain.event.CandlestickEvent;

@Service
public class CurrentTickerServiceImpl implements CurrentTickerService{

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
	

	
	public CandlestickEvent getCurrentTicker(String market){
		return getMarketTicker(market);
	}

	private CandlestickEvent getMarketTicker(String market) {
		CandlestickEvent currentPrice = null;
		if(market != null) {
			if (market.equalsIgnoreCase("BTCUSDT")) {
				currentPrice = btcCandlestickEvent;
			}else if (market.equalsIgnoreCase("ETHUSDT")) {
				currentPrice = ethCandlestickEvent;
			}else if (market.equalsIgnoreCase("LINKUSDT")) {
				currentPrice = linkCandlestickEvent;
			}else if (market.equalsIgnoreCase("ADAUSDT")) {
				currentPrice = adaCandlestickEvent;
			}else if (market.equalsIgnoreCase("BTTUSDT")) {
				currentPrice = bttCandlestickEvent;
			}else if (market.equalsIgnoreCase("EOSUSDT")) {
				currentPrice = eosCandlestickEvent;
			}else if (market.equalsIgnoreCase("ETCUSDT")) {
				currentPrice = etcCandlestickEvent;
			}else if (market.equalsIgnoreCase("LTCUSDT")) {
				currentPrice = ltcCandlestickEvent;
			}else if (market.equalsIgnoreCase("TRXUSDT")) {
				currentPrice = trxCandlestickEvent;
			}else if (market.equalsIgnoreCase("XLMUSDT")) {
				currentPrice = xlmCandlestickEvent;
			}else if (market.equalsIgnoreCase("XMRUSDT")) {
				currentPrice = xmrCandlestickEvent;
			}else if (market.equalsIgnoreCase("XRPUSDT")) {
				currentPrice = xrpCandlestickEvent;
			}else if (market.equalsIgnoreCase("ZECUSDT")) {
				currentPrice = zecCandlestickEvent;
			}else if (market.equalsIgnoreCase("WINUSDT")) {
				currentPrice = winCandlestickEvent;
			}
		}
		return currentPrice;
	}
	
}
