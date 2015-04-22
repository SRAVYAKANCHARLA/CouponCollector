package edu.umkc.idbmscc.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Proxy.Type;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.Connection;

import edu.umkc.idbmscc.dto.Categories;
import edu.umkc.idbmscc.dto.ChainStores;
import edu.umkc.idbmscc.dto.DealType;
import edu.umkc.idbmscc.dto.LocalDeals;
import edu.umkc.idbmscc.dto.Subcategory;
import edu.umkc.idbmscc.jdbc.DBConnection;

/**
 * 
 * @author Rajesh Kapa
 *
 */
public class JsonParser {

	public static void main(String[] args) throws Exception {

	    String json = readUrl("http://api.8coupons.com/v1/getrealtimelocaldeals?key=e9c726dbd8e2bb665f2069d8b08ff22a0713912f80f99a31764f20a0abd63a5c35afcc69b91259161e2556d49fa6d674&page=33");
	    PreparedStatement prepStmt = null;
		ResultSet rs = null;
		DBConnection connection = new DBConnection();
		Connection conn = (Connection) connection.getConnection();
	    Gson gson = new Gson();        
	    
	    java.lang.reflect.Type collectionType = new TypeToken<List<LocalDeals>>(){}.getType();
	    List<LocalDeals> chainStores = (List<LocalDeals>) new Gson()
	                   .fromJson( json , collectionType);
	   // ChainStores[] chainStores = new Gson().fromJson(json, ChainStores[].class);;
	    String sql="";
	    for (LocalDeals subcat : chainStores){
	    	
	    sql = "INSERT INTO deals (id,categoryid,subcategoryid,dealtypeid,lat,lon,dealOriginalPrice,dealPrice,dealSavings,dealDiscountPercent,name,address,address2,storeID,chainID,totalDealsInThisStore,homepage,phone,statecode,city,ZIP,URL,storeURL,dealSource,username,userID,dealTitle,disclaimer,dealinfo,expirationDate,postDate,showImage,showImageStandardBig,showImageStandardSmall,showLogo,providerName) values (?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, subcat.getID());
		statement.setInt(2, subcat.getCategoryID());
		statement.setInt(3, subcat.getSubcategoryID());
		statement.setInt(4, subcat.getDealTypeID());
		statement.setString(5, subcat.getLat());
		statement.setString(6, subcat.getLon());
		statement.setString(7, subcat.getDealOriginalPrice());
		statement.setString(8, subcat.getDealPrice());
		statement.setString(9, subcat.getDealSavings());
		statement.setString(10, subcat.getDealDiscountPercent());
		statement.setString(11, subcat.getName());
		statement.setString(12, subcat.getAddress());
		statement.setString(13, subcat.getAddress2());
		statement.setInt(14, subcat.getStoreID());
		statement.setInt(15, subcat.getChainID());
		statement.setInt(16, subcat.getTotalDealsInThisStore());
		statement.setString(17, subcat.getHomepage());
		statement.setString(18, subcat.getPhone());
		statement.setString(19, subcat.getState());
		statement.setString(20, subcat.getCity());
		statement.setString(21, subcat.getZIP());
		statement.setString(22, subcat.getURL());
		statement.setString(23, subcat.getStoreURL());
		statement.setString(24, subcat.getDealSource());
		statement.setString(25, subcat.getUser());
		statement.setString(26, subcat.getUserID());
		statement.setString(27, subcat.getDealTitle());
		statement.setString(28, subcat.getDisclaimer());
		statement.setString(29, subcat.getDealinfo());
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date expdate = null;
		Date postdate = null;
		if(subcat.getExpirationDate()!=null && subcat.getPostDate()!=null){
			 expdate = (Date) format.parse(subcat.getExpirationDate());
			 postdate = (Date) format.parse(subcat.getPostDate());
		}else{
			expdate = new Date();
			 postdate = new Date();
		}
		
		 java.sql.Date sqlDate1 = new java.sql.Date(expdate.getTime());
		 java.sql.Date sqlDate2 = new java.sql.Date(postdate.getTime());
		statement.setDate(30,  sqlDate1);
		statement.setDate(31, sqlDate2);
		statement.setString(32, subcat.getShowImage());
		statement.setString(33, subcat.getShowImageStandardBig());
		statement.setString(34, subcat.getShowImageStandardSmall());
		statement.setString(35, subcat.getShowLogo());
		statement.setString(36, subcat.getProviderName());
		statement.executeUpdate();
	    }
	  
	}
	
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
