package ordering_program.orders;

import ordering_program.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order { /*

    public Order(Discount discount) {
        this.discount = discount;
    }

    Discount discount;
    */


    private List<OrderItem> orders;

    public Order() {
        this.orders = new ArrayList<>();
    }

    //Constructor
    public Order(List<OrderItem> orders) {
        this.orders = orders;
    }

    public void addItem(Product product, double qty) {
        if (qty < 0.00) {
            throw new IllegalArgumentException("Quantity input cannot be negative!");
        }
        orders.add(new OrderItem(product.name, product.price, qty));
    }

    public boolean deleteItem(String name) {
        orders.removeIf(orderItem -> orderItem.name == name);
        return true;
    }

    public void calculateOrderTotal()
    {
        double suma = orders.stream()
                .collect(Collectors.summingDouble(OrderItem::getAmount));

        System.out.println(" ***** -- The total amount of the order is: " + suma + " -- ***** ");
    }

    public void printItems() {

        System.out.println(orders.stream().collect(Collectors.toList()));

        //for (int i = 0; i < orders.size(); i++) {
        //    System.out.println(orders.get(i));
        //}
    }

}
