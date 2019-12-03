package com.hd.cryptotrader.service;

import com.binance.api.client.domain.event.CandlestickEvent;

public interface CurrentTickerService {

	public CandlestickEvent getCurrentTicker(String market);
}
