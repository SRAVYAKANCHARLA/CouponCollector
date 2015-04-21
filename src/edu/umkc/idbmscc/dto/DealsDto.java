package edu.umkc.idbmscc.dto;

import java.io.Serializable;

public class DealsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7410859088551736097L;
	
	private String lat;
	private String lon;
	private String distance;
	private String dealOriginalPrice;
	private String dealPrice;
	private String dealSavings;
	private String dealDiscountPercent;
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDealOriginalPrice() {
		return dealOriginalPrice;
	}
	public void setDealOriginalPrice(String dealOriginalPrice) {
		this.dealOriginalPrice = dealOriginalPrice;
	}
	public String getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}
	public String getDealSavings() {
		return dealSavings;
	}
	public void setDealSavings(String dealSavings) {
		this.dealSavings = dealSavings;
	}
	public String getDealDiscountPercent() {
		return dealDiscountPercent;
	}
	public void setDealDiscountPercent(String dealDiscountPercent) {
		this.dealDiscountPercent = dealDiscountPercent;
	}
	
	@Override
	public String toString() {
		return "DealsDto [lat=" + lat + ", lon=" + lon + ", distance="
				+ distance + ", dealOriginalPrice=" + dealOriginalPrice
				+ ", dealPrice=" + dealPrice + ", dealSavings=" + dealSavings
				+ ", dealDiscountPercent=" + dealDiscountPercent + "]";
	}
	
	

}
