package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {
    int plateNb;
    int modelYear;
    String manufacture;
    int estimatedValue;
    int carDamage;

    // Constructor
    public Vehicle(int plateNb, int modelYear, String manufacture, int estimatedValue, int carDamage) {
        this.plateNb = plateNb;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }

    // Getters and setters
    public int getPlateNb() {
        return plateNb;
    }

    public void setPlateNb(int plateNb) {
        this.plateNb = plateNb;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    // toString

    @Override
    public String toString() {
        return "Plate Number: " + plateNb +
                "\nModelYear: " + modelYear +
                "\nManufacture: " + manufacture +
                "\n EstimatedValue: " + estimatedValue +
                "\n Car Damage Level: " + carDamage;
    }
}
