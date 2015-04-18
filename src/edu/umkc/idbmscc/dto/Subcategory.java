package edu.umkc.idbmscc.dto;

import java.io.Serializable;

/**
 * 
 * @author Rajesh
 *
 */
public class Subcategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2485969959209380973L;

	int subcategoryID;
	int categoryID;
	String category;
	String subcategory;


	public int getSubcategoryID() {
		return subcategoryID;
	}

	public void setSubcategoryID(int subcategoryID) {
		this.subcategoryID = subcategoryID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Subcategory [subcategoryID=" + subcategoryID + ", categoryID="
				+ categoryID + ", category=" + category + ", subcategory="
				+ subcategory + "]";
	}

}
