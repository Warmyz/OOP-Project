package oop;

public class Gadget extends LibraryItem {
    private String brand;
    private String spec;

    public Gadget(String name, String brand, String spec) {
        super(name);
        this.brand = brand;
        this.spec = spec;
    }

    public String getBrand() {
        return brand;
    }

    public String getSpec() {
        return spec;
    }


}
