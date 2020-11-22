package car_store.enums;

public enum Region {
    SOFIA("CB"), BURGAS("A"), VARNA("B"), PLOVDIV("PB"), RUSE("P"), GABROVO("EB"), VIDIN("BH"), VRATSA("BP");

    private String region;

    Region(String region) {
        this.region = region;
    }

    public String getPrefix() {
        return region;
    }

}
