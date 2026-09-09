package it.uniroma3.siw.dto;
import it.uniroma3.siw.model.*;

public class CarDTO {


	private Long id;
	private String model;
	private String plate;
	private String country;

	public CarDTO(Automobile car) {
		this.id = car.getId();
		this.model = car.getModel();
		this.plate = car.getPlate();
		this.country = car.getCountry();
	}

	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}
	public String getModel() {
		return model;
	}

	public String getPlate() {
		return plate;
	}

}
