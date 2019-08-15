package ordering_program.orders;

public class OrderItem {
    public String name;
    public double price;
    public double quantity;
    public double discount;
    public double amount;

    public OrderItem(String name, double price, double quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        discount = 0;
        amount = price * quantity;
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

    public double getQty()
    {
        return quantity;
    }

    public double getDiscount()
    {
        return discount;
    }

    public double getAmount(){
        return amount;
    }

    private void  recalculateAmount(double newPrice, double newDiscount, double newQuantity) {

        discount = ((newPrice * newQuantity) * newDiscount)/100;
        amount = ((newQuantity * newPrice) - discount) ;
        System.out.println("New amount to be paid: " + amount);
    }

    @Override
    public String toString() {
        return "The name of the current class is: " + getClassName() + "\n" + "Name: " + getName() + "\n" + "Price: " + getPrice() + "\n" + "Quantity: " + getQty() + "\n" + "Discount: " + getDiscount() + "\n" + "Amount: " + getAmount();
    }

    public static void main(String[] args)
    {
        System.out.println("OrderItem class: ");
        System.out.println();
        OrderItem oI = new OrderItem("Huawei phone", 350.23, 3);
        System.out.println(oI.toString());
        System.out.println("After quantity and discount value have changed: ");
        oI.recalculateAmount(350.23, 3, 7);
    }
}
