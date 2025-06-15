package basics.collections.lambdaexpressions;

public class Car {
	private String carType; 
	private String make; 
	private String model; 
	private String engineCapacity;
	
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public Car(String carType, String make, String model, String engineCapacity) {
		super();
		this.carType = carType;
		this.make = make;
		this.model = model;
		this.engineCapacity = engineCapacity;
	} 

	@Override
	public String toString() {
		return "Car [carType=" + carType + ", make=" + make + ", model=" + model + ", engineCapacity=" + engineCapacity
				+ "]";
	}
}
