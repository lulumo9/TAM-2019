package ordering_program.products;

public class Electronics extends Product {

    public Electronics(String name, double price) {
        super(name, price);
    }

    public String getClassName()
    {
        return getClass().getSimpleName();
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return "The name of the current class is: " + getClassName() + "\n" + "Name: " + getName() + "\n" + "Price: " + getPrice();
    }

}
