package com.moneysupermarket.interview.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"15m",
"last",
"buy",
"sell",
"symbol"
})
public class BlockchainInfoResponse implements Comparable<BlockchainInfoResponse>{

@JsonProperty("15m")
private Double _15m;
@JsonProperty("last")
private Double last;
@JsonProperty("buy")
private Double buy;
@JsonProperty("sell")
private Double sell;
@JsonProperty("symbol")
private String symbol;

public BlockchainInfoResponse() {}

public BlockchainInfoResponse(Double _15m, Double last, Double buy, Double sell, String symbol) {
	super();
	this._15m = _15m;
	this.last = last;
	this.buy = buy;
	this.sell = sell;
	this.symbol = symbol;
}

@JsonProperty("15m")
public Double get15m() {
return _15m;
}

@JsonProperty("15m")
public void set15m(Double _15m) {
this._15m = _15m;
}

@JsonProperty("last")
public Double getLast() {
return last;
}

@JsonProperty("last")
public void setLast(Double last) {
this.last = last;
}

@JsonProperty("buy")
public Double getBuy() {
return buy;
}

@JsonProperty("buy")
public void setBuy(Double buy) {
this.buy = buy;
}

@JsonProperty("sell")
public Double getSell() {
return sell;
}

@JsonProperty("sell")
public void setSell(Double sell) {
this.sell = sell;
}

@JsonProperty("symbol")
public String getSymbol() {
return symbol;
}

@JsonProperty("symbol")
public void setSymbol(String symbol) {
this.symbol = symbol;
}

@Override
public String toString() {
	return "BlockchainInfoResponse [_15m=" + _15m + ", last=" + last + ", buy=" + buy + ", sell=" + sell + ", symbol="
			+ symbol + "]";
}

@Override
public int compareTo(BlockchainInfoResponse other) {
	// TODO Auto-generated method stub
	return this.symbol.compareTo(other.symbol);
}


}