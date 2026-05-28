package car.example.constructor.injection;

public class Car_Specifics {
    private String make_of_car;
    private String model_of_car;

    public String getMake_of_car() {
        return make_of_car;
    }

    public void setMake_of_car(String make_of_car) {
        this.make_of_car = make_of_car;
    }

    public String getModel_of_car() {
        return model_of_car;
    }

    public void setModel_of_car(String model_of_car) {
        this.model_of_car = model_of_car;
    }


    @Override
    public String toString() {
        return "Car_Specifics{" +
                "make_of_car='" + make_of_car + '\'' +
                ", model_of_car='" + model_of_car + '\'' +
                '}';
    }
}
