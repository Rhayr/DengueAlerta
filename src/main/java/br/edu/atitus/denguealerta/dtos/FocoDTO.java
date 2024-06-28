package br.edu.atitus.denguealerta.dtos;

public class FocoDTO {

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private double latitude;
	
	private double longitude;
	
}
