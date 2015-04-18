package edu.umkc.idbmscc.dto;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class LocalDeals implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304454391747528901L;

	private String affiliate;
	private String name;
	private String address;
	private String address2;
	private int storeID;
	private int chainID;
	private int totalDealsInThisStore;
	private String homepage;
	private String phone;
	private String state;
	private String city;
	private String ZIP;
	private String URL;
	private String storeURL;
	private String dealSource;
	private String user;
	private String userID;
	private String ID;
	private String dealTitle;
	private String disclaimer;
	private String dealinfo;
	private String expirationDate;
	private String postDate;
	private String showImage;
	private String showImageStandardBig;
	private String showImageStandardSmall;
	private String showLogo;
	private String providerName;
	private String up;
	private String down;
	private int DealTypeID;
	private int categoryID;
	private int subcategoryID;
	private String lat;
	private String lon;
	private String distance;
	private String dealOriginalPrice;
	private String dealPrice;
	private String dealSavings;
	private String dealDiscountPercent;
	
	
	public String getAffiliate() {
		return affiliate;
	}
	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getChainID() {
		return chainID;
	}
	public void setChainID(int chainID) {
		this.chainID = chainID;
	}
	public int getTotalDealsInThisStore() {
		return totalDealsInThisStore;
	}
	public void setTotalDealsInThisStore(int totalDealsInThisStore) {
		this.totalDealsInThisStore = totalDealsInThisStore;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getStoreURL() {
		return storeURL;
	}
	public void setStoreURL(String storeURL) {
		this.storeURL = storeURL;
	}
	public String getDealSource() {
		return dealSource;
	}
	public void setDealSource(String dealSource) {
		this.dealSource = dealSource;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDealTitle() {
		return dealTitle;
	}
	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getDealinfo() {
		return dealinfo;
	}
	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}
	
	
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getShowImage() {
		return showImage;
	}
	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}
	public String getShowImageStandardBig() {
		return showImageStandardBig;
	}
	public void setShowImageStandardBig(String showImageStandardBig) {
		this.showImageStandardBig = showImageStandardBig;
	}
	public String getShowImageStandardSmall() {
		return showImageStandardSmall;
	}
	public void setShowImageStandardSmall(String showImageStandardSmall) {
		this.showImageStandardSmall = showImageStandardSmall;
	}
	public String getShowLogo() {
		return showLogo;
	}
	public void setShowLogo(String showLogo) {
		this.showLogo = showLogo;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getUp() {
		return up;
	}
	public void setUp(String up) {
		this.up = up;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public int getDealTypeID() {
		return DealTypeID;
	}
	public void setDealTypeID(int dealTypeID) {
		DealTypeID = dealTypeID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSubcategoryID() {
		return subcategoryID;
	}
	public void setSubcategoryID(int subcategoryID) {
		this.subcategoryID = subcategoryID;
	}
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
		return "LocalDeals [affiliate=" + affiliate + ", name=" + name
				+ ", address=" + address + ", address2=" + address2
				+ ", storeID=" + storeID + ", chainID=" + chainID
				+ ", totalDealsInThisStore=" + totalDealsInThisStore
				+ ", homepage=" + homepage + ", phone=" + phone + ", state="
				+ state + ", city=" + city + ", ZIP=" + ZIP + ", URL=" + URL
				+ ", storeURL=" + storeURL + ", dealSource=" + dealSource
				+ ", user=" + user + ", userID=" + userID + ", ID=" + ID
				+ ", dealTitle=" + dealTitle + ", disclaimer=" + disclaimer
				+ ", dealinfo=" + dealinfo + ", expirationDate="
				+ expirationDate + ", postDate=" + postDate + ", showImage="
				+ showImage + ", showImageStandardBig=" + showImageStandardBig
				+ ", showImageStandardSmall=" + showImageStandardSmall
				+ ", showLogo=" + showLogo + ", providerName=" + providerName
				+ ", up=" + up + ", down=" + down + ", DealTypeID="
				+ DealTypeID + ", categoryID=" + categoryID
				+ ", subcategoryID=" + subcategoryID + ", lat=" + lat
				+ ", lon=" + lon + ", distance=" + distance
				+ ", dealOriginalPrice=" + dealOriginalPrice + ", dealPrice="
				+ dealPrice + ", dealSavings=" + dealSavings
				+ ", dealDiscountPercent=" + dealDiscountPercent + "]";
	}
	
}
