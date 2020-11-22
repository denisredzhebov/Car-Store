package car_store.car;

import car_store.enums.EngineType;
import car_store.enums.Model;
import car_store.enums.Region;

public class SportsCar extends Car {

    public SportsCar(Model model, int year, int price, EngineType engineType,
                     Region region) {
        super(model, year, price, engineType, region);
    }

}
