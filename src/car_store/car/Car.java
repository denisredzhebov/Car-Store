package car_store.car;

import java.util.HashMap;
import java.util.Random;

import car_store.enums.EngineType;
import car_store.enums.Model;
import car_store.enums.Region;

public abstract class Car {

    private Model model;
    private int year;
    private int price;
    private EngineType engineType;
    private Region region;
    private static HashMap<String, Integer> regionAndNumber;
    private String registrationNumber;

    static {
        regionAndNumber = new HashMap<>();
        regionAndNumber.put("A", 1000);
        regionAndNumber.put("CB", 1000);
        regionAndNumber.put("B", 1000);
        regionAndNumber.put("BH", 1000);
        regionAndNumber.put("BP", 1000);
        regionAndNumber.put("EB", 1000);
        regionAndNumber.put("PB", 1000);
        regionAndNumber.put("P ", 1000);
    }

    public Car(Model model, int year, int price, EngineType engineType, Region region) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.region = region;

        StringBuilder number = new StringBuilder();

        number.append(region.getPrefix());
        number.append(regionAndNumber.get(region.getPrefix()));

        regionAndNumber.replace(region.getPrefix(), regionAndNumber.get(region.getPrefix()) + 1);

        Random random = new Random();

        number.append((char) (random.nextInt(26) + 'A'));
        number.append((char) (random.nextInt(26) + 'A'));

        registrationNumber = number.toString();
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Region getRegion() {
        return region;
    }
}
