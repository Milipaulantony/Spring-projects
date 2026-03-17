package car.example.constructor.injection;

public class Car {
    private Car_Specifics specs;



    public Car(Car_Specifics specs) {
        this.specs = specs;
    }

    public void displayDetails(){
        System.out.println("Car details" + specs.toString());
    }
}
