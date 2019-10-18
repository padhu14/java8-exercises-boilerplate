package com.learn.e02.streams;

public class Country {

	private Integer countryId;
	private String countryName;
	
	

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(Integer countryId, String countryName) {
		
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	

}
