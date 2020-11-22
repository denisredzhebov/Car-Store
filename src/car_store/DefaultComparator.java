package car_store;

import java.util.Comparator;

import car_store.car.Car;

public class DefaultComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        int model = car1.getModel().toString().compareTo(car2.getModel().toString());
        if (model != 0) {
            return model;
        }
        return Integer.compare(car1.getYear(), car2.getYear());
    }

}
