package edu.umkc.idbmscc.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class SaveDataDB {
	private static String tableName = "divisions";
	public static void main(String[] args) throws Exception {
		   String json = readUrl("https://partner-api.groupon.com/division.json");
		   JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(json);
		   JSONArray jsonArr = jsonObject.getJSONArray("divisions");
		   JSONObject obj = null;
		   JSONArray nameArr = null;
		   JSONArray valArr = null;
		   
		   try {
		   for (int i = 0; i < jsonArr.size(); i++) {
		    obj = jsonArr.getJSONObject(i);
		    nameArr = obj.names();
		    valArr = obj.toJSONArray(nameArr);
		    saveRecord(nameArr, valArr);
		   }
		  } catch (Exception e) {
		   e.printStackTrace();
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
	
	 private static void saveRecord(JSONArray nameArray, JSONArray valArray) {
		 DBConnection dbConnection = new DBConnection();
		  Connection conn = dbConnection.getConnection();
		  StringBuffer sb = new StringBuffer("insert into " + tableName + "(");
		  int size = nameArray.size();
		  int count = 0;
		  Iterator<Object> iterator = nameArray.iterator();
		  
		  while (iterator.hasNext()) {
		   if (count < (size - 1))
		    sb.append(iterator.next() + ",");
		   else
		    sb.append(iterator.next() + ")");
		   count++;
		  }
		  sb.append(" values(");
		 
		  for (int i = 0; i < size; i++) {  
		   if (i < (size - 1))
		    sb.append("?,");
		   else
		    sb.append("?)");  
		  }
		  System.out.println(sb.toString());
		  try {
		   PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		   bindVariables(valArray, pstmt);
		   pstmt.executeUpdate();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		 }
		 private static void bindVariables(JSONArray valArray,
		   PreparedStatement pstmt) throws SQLException {
		  Iterator<Object> iterator = valArray.iterator();
		  int cnt = 0;
		  while (iterator.hasNext()) {
		   Object obj = iterator.next();
		   if (obj instanceof String) {
		    pstmt.setString(++cnt, (String) obj);
		   } else if (obj instanceof Integer) {
		    pstmt.setLong(++cnt, (Integer) obj);
		   } else if (obj instanceof Long) {
		    pstmt.setLong(++cnt, (Long) obj);
		   } else if (obj instanceof Double) {
		    pstmt.setDouble(++cnt, (Double) obj);
		   }
		  }
		 }
}
