package com.hd.cryptotrader.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance.api.client.domain.event.CandlestickEvent;
import com.hd.cryptotrader.response.CurrentTickerResponse;
import com.hd.cryptotrader.service.CurrentTickerService;

@RestController
@RequestMapping("/api/v1")
public class CurrentMarketTickerController {
	
	@Autowired
	private CurrentTickerService service;
	
	
	@GetMapping(value = "/price/{market}")
	public ResponseEntity<CurrentTickerResponse> placeETHOrdersOnExchanges(@PathParam(value = "market") String market) throws Exception{
		CandlestickEvent currentTicker = service.getCurrentTicker(market);
		CurrentTickerResponse currentTickerResponse = new CurrentTickerResponse();
		currentTickerResponse.setCurrentTicker(currentTicker);
		currentTickerResponse.setSuccess(true);
		return ResponseEntity.ok(currentTickerResponse);
	}
}
