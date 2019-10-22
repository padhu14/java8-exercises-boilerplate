package com.learn.e05.datetime;

import java.time.LocalDate;
import java.util.Date;

public class Tablet {

	private String tabletName;
	private String manufacturer;
	private Date manufactureDate;
	private LocalDate expiryDate;
	
	

	public Tablet(String tabletName, String manufacturer, Date manufactureDate, LocalDate expiryDate) {
		this.tabletName = tabletName;
		this.manufacturer = manufacturer;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
	}

	public String getTabletName() {
		return tabletName;
	}

	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Tablet [tabletName=" + tabletName + ", manufacturer=" + manufacturer + ", manufactureDate="
				+ manufactureDate + ", expiryDate=" + expiryDate + "]";
	}
	
	

}
