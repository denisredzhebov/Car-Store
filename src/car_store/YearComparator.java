package car_store;

import java.util.Comparator;

import car_store.car.Car;

public class YearComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getYear(), car2.getYear());
    }

}
