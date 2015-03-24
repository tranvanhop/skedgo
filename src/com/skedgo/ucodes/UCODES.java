package com.skedgo.ucodes;

// UCODES class is one line in excel file
public class UCODES {

	private String station_code;
	private String station_name;
	private String iata_city;
	private String city_indicator;
	private String rail_distribut_ors;
	private String country_code;
	private String state_code;
	private String time_zone;
	private String no_name;
	private String latitude;
	private String longitude;
	private String address;

	public static final int index_station_code = 0;
	public static final int index_station_name = 1;
	public static final int index_iata_city = 2;
	public static final int index_city_indicator = 3;
	public static final int index_rail_distribut_ors = 4;
	public static final int index_country_code = 5;
	public static final int index_state_code = 6;
	public static final int index_time_zone = 7;
	public static final int index_no_name = 8;
	public static final int index_latitude = 9;
	public static final int index_longitude = 10;
	public static final int index_address = 11;

	public UCODES() {}

	public UCODES(String station_code, String station_name, String iata_city,
			String city_indicator, String rail_distribut_ors,
			String country_code, String state_code, String time_zone,
			String no_name, String latitude, String longitude, String address) {

		this.station_code = station_code;
		this.station_name = station_name;
		this.iata_city = iata_city;
		this.city_indicator = city_indicator;
		this.rail_distribut_ors = rail_distribut_ors;
		this.country_code = country_code;
		this.state_code = state_code;
		this.time_zone = time_zone;
		this.no_name = no_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getIata_city() {
		return iata_city;
	}

	public void setIata_city(String iata_city) {
		this.iata_city = iata_city;
	}

	public String getCity_indicator() {
		return city_indicator;
	}

	public void setCity_indicator(String city_indicator) {
		this.city_indicator = city_indicator;
	}

	public String getRail_distribut_ors() {
		return rail_distribut_ors;
	}

	public void setRail_distribut_ors(String rail_distribut_ors) {
		this.rail_distribut_ors = rail_distribut_ors;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public String getNo_name() {
		return no_name;
	}

	public void setNo_name(String no_name) {
		this.no_name = no_name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Print UCODES
	@Override
	public String toString() {
		String row = "Station Code\tStation Name\t\tIATA City\tCity Indicator\t\tRail Distribut ors\tCountry Code\tState Code\tTime Zone\t\t\tLatitude\tLongitude\tAddress\n";
		row += station_code + "\t" + station_name + "\t" + iata_city + "\t\t"
				+ city_indicator + "\t\t\t" + rail_distribut_ors + "\t\t\t"
				+ country_code + "\t\t" + state_code + "\t\t" + time_zone + "\t" + no_name + "\t" + latitude + "\t\t" + longitude + "\t\t" + address + "\n";
		return row;
	}

}
