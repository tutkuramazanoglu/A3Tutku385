package a3.icecream.a3tutku385;

public class IceCream {
    private String flavour;
    private String description;
    private double price;
    private int quantity;

    public IceCream(String flavour, String description, double price, int quantity) {
        this.flavour = flavour;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
