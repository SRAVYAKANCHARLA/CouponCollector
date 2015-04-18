package edu.umkc.idbmscc.dto;

import java.io.Serializable;
/**
 * 
 * @author Rajesh Kapa
 *
 */
public class DealType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7053871898914252711L;

	private int dealtypeid;
	private String TypeName;
	
	public int getDealtypeid() {
		return dealtypeid;
	}
	public void setDealtypeid(int dealtypeid) {
		this.dealtypeid = dealtypeid;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	
	@Override
	public String toString() {
		return "DealType [dealtypeid=" + dealtypeid + ", TypeName=" + TypeName
				+ "]";
	}
	
	
	
}
