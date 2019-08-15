package ordering_program.products;

import java.time.LocalDateTime;

public class Food extends Product {

    private LocalDateTime shelfDate;

    //Constructor with 3 parameters
    public Food(String name, double price, LocalDateTime shelfDate)
    {
        super(name, price);
        this.shelfDate = shelfDate;
    }

    //Constructor with 2 parameters
    public Food(String name, double price)
    {
        super(name, price);
        this.shelfDate = LocalDateTime.now().plusDays(5);
    }

    //Accessor and mutator methods for extra field "ShelfDate"
    public LocalDateTime getShelfDate() {
        return shelfDate;
    }
    public void setShelfDate(LocalDateTime shelfDate) {
        this.shelfDate = shelfDate;
    }



    public String getClassName() {
        return getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "The name of the current class is: " + getClassName() + "\n" + "Name: " + getName() + "\n" + "Price: " + getPrice() + "\n" + "Shelf date: " + getShelfDate();
    }


}
