package edu.umkc.idbmscc.dto;

import java.io.Serializable;

public class ChainStores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int chainID;
	private String name;
	private String page;
	private String homepage;
	private String logoBig;
	private String logoSmall;
	
	public int getChainID() {
		return chainID;
	}
	public void setChainID(int chainID) {
		this.chainID = chainID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getLogoBig() {
		return logoBig;
	}
	public void setLogoBig(String logoBig) {
		this.logoBig = logoBig;
	}
	public String getLogoSmall() {
		return logoSmall;
	}
	public void setLogoSmall(String logoSmall) {
		this.logoSmall = logoSmall;
	}
	
	@Override
	public String toString() {
		return "ChainStores [chainID=" + chainID + ", name=" + name + ", page="
				+ page + ", homepage=" + homepage + ", logoBig=" + logoBig
				+ ", logoSmall=" + logoSmall + "]";
	}
	
	
	
}
