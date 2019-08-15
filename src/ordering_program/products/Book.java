package ordering_program.products;

public class Book extends Product {

    private String author;

    //Constructor with 3 parameters
    public Book(String name, double price, String author)
    {
        super(name, price);
        this.author = author;
    }

    //Constructor with 2 parameters
    public Book(String name, double price)
    {
        super(name, price);
        this.author = "No Author";
    }

    //Accessor and mutator methods for extra field "Author"
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {//I am saying, the field Author, will received the value of Author parameter
        this.author = author;
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
        return "The name of the current class is: " + getClassName() + "\n" + "Name: " + getName() + "\n" + "Price: " + getPrice() + "\n" + "Author: " + getAuthor();
    }

}
