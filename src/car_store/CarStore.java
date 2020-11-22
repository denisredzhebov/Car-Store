package car_store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import car_store.car.Car;
import car_store.enums.Model;
import car_store.exception.CarNotFoundException;

public class CarStore {
    private List<Car> list;

    public CarStore() {
        list = new ArrayList<>();
    }

    public boolean add(Car car) {
        if (list.contains(car)) {
            return false;
        }
        list.add(car);
        return true;
    }

    public boolean addAll(Collection<Car> cars) {
        boolean change = false;

        for (Car car : cars) {
            if (!(list.contains(car))) {
                list.add(car);
                change = true;
            }
        }
        return change;
    }

    public boolean remove(Car car) {
        if (list.contains(car)) {
            list.remove(car);
            return true;
        }
        return false;
    }

    public Car getCarByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistrationNumber().equals(registrationNumber)) {
                return list.get(i);
            }
        }
        throw new CarNotFoundException();
    }

    public int getNumberOfCars() {
        return list.size();
    }

    public int getTotalPriceForCars() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getPrice();
        }
        return sum;
    }
    // By default comparator
    public Collection<Car> getCars() {
        Collections.sort(list, new DefaultComparator());
        return list;
    }
    // User implements his comparator
    public Collection<Car> getCars(Comparator<Car> comparator) {
        Collections.sort(list, comparator);
        return list;
    }

    // User implements his comparator + whether to be reversed or not.
    public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed) {
        Collections.sort(list, comparator);
        if (isReversed) {
            Collections.sort(list, Collections.reverseOrder());
        }
        return list;
    }

    public Collection<Car> getCarsByModel(Model model) {
        List<Car> carsByModel = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getModel() == model) {
                carsByModel.add(list.get(i));
            }
        }
        Collections.sort(carsByModel, new YearComparator());
        return carsByModel;
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRegistrationNumber());
        }
    }

    public List getList() {
        return list;
    }

}
