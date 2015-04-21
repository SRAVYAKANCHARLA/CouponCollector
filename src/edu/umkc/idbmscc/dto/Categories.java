package edu.umkc.idbmscc.dto;

import java.io.Serializable;

/**
 * 
 * @author Rajesh Kapa
 *
 */
/**
 * This cla
 */
public class Categories implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int categoryID;
	String category;
	
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categories [categoryID=");
		builder.append(categoryID);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
