package com.hd.cryptotrader.response;

import com.binance.api.client.domain.event.CandlestickEvent;

import lombok.Data;

@Data
public class CurrentTickerResponse extends BasicResponse{

	private CandlestickEvent currentTicker;
}
