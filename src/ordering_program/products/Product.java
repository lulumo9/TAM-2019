package ordering_program.products;

public abstract class Product {

    public String name;
    public double price;


    //Constructor for both
    public Product(String name, double price) {
        if (price < 0.00)
            throw new IllegalArgumentException("Price input cannot be negative!");
        this.name = name;
        this.price = price;
    }

    public String toString()
    {
        return "You never should see this!";
    }

}
