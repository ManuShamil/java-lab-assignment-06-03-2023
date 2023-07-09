package electronics;

class Electronics {
    private double price;

    public Electronics(double price) {
        this.price = price;
    }

    // Getter and setter for price

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Television extends Electronics {
    private int screenSize;
    private String brand;

    public Television(double price, int screenSize, String brand) {
        super(price);
        this.screenSize = screenSize;
        this.brand = brand;
    }

    public void watch() {
        System.out.println("Watching TV on a " + screenSize + " inch " + brand + " television.");
    }

    // Getters and setters for screenSize and brand
}

class Smartphone extends Electronics {
    private String operatingSystem;
    private boolean isWaterproof;

    public Smartphone(double price, String operatingSystem, boolean isWaterproof) {
        super(price);
        this.operatingSystem = operatingSystem;
        this.isWaterproof = isWaterproof;
    }

    public void call() {
        System.out.println("Making a call on a smartphone with " + operatingSystem + " OS.");
    }

    // Getters and setters for operatingSystem and isWaterproof
}

public class Main {
    public static void main(String[] args) {
        Electronics[] devices = new Electronics[3];
        devices[0] = new Television(1000.0, 55, "Samsung");
        devices[1] = new Smartphone(800.0, "Android", true);
        devices[2] = new Television(1200.0, 65, "LG");

        for (Electronics device : devices) {
            if (device instanceof Television) {
                Television tv = (Television) device;
                tv.watch();
            } else if (device instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) device;
                smartphone.call();
            }
        }
    }
}
