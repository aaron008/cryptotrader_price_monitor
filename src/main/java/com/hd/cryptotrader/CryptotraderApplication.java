package com.hd.cryptotrader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.binance.api.client.domain.event.CandlestickEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.hd.cryptotrader"})
public class CryptotraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptotraderApplication.class, args);
	}

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
	
	@Bean(name = "binanceRestTemplate")
	public RestTemplate binanceRestTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}
	
	@Bean(name = "BTCCandlestickEvent")
	public CandlestickEvent btcCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "BTTCandlestickEvent")
	public CandlestickEvent bttCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "ETHCandlestickEvent")
	public CandlestickEvent ethCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "LINKCandlestickEvent")
	public CandlestickEvent linkCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "XRPCandlestickEvent")
	public CandlestickEvent xrpCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "WINCandlestickEvent")
	public CandlestickEvent winCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "TRXCandlestickEvent")
	public CandlestickEvent trxCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "XLMCandlestickEvent")
	public CandlestickEvent xlmCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "ADACandlestickEvent")
	public CandlestickEvent adaCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "EOSCandlestickEvent")
	public CandlestickEvent eosCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "ETCCandlestickEvent")
	public CandlestickEvent etcCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "LTCCandlestickEvent")
	public CandlestickEvent ltcCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "XMRCandlestickEvent")
	public CandlestickEvent xmrCandlestickEvent() {
		return new CandlestickEvent();
	}
	
	@Bean(name = "ZECCandlestickEvent")
	public CandlestickEvent zecCandlestickEvent() {
		return new CandlestickEvent();
	}
}
