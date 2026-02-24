import java.util.List;
public class OrderCalculator {

    public static void main(String[] args) {
        Order order = createSampleOrder();
        System.out.println("=== Order Summary ===");
        System.out.println("client: "+order.getCustomerName());
        System.out.println("order no: "+order.getOrderId());
        double calculatedTotal = 0;
        int totalItems = 0;
        System.out.println("\n order details:");
        for (OrderItem item : order.getItems()) {
            double subtotal = item.getSubtotal();
            calculatedTotal += subtotal;
            totalItems += item.getQuantity();
            System.out.printf(" • %-22s × %2d=%8.2f $%n",
                    item.getProductName(), item.getQuantity(), subtotal);
        }
        System.out.printf("total:%8.2f $%n",calculatedTotal);
        System.out.printf("JSON total:%8.2f $%n", order.getTotal());
        System.out.printf("total number:%d number%n",totalItems);
        if (Math.abs(calculatedTotal - order.getTotal()) > 0.01) {
            System.out.println("Error: something wrong");
        } else {
            System.out.println("Total values is okey");
        }
    }
    private static Order createSampleOrder() {
        Order order = new Order();
        order.setOrderId("ORD-2026-0042");
        order.setCustomerName("revan abusov");

        OrderItem mouse = new OrderItem();
        mouse.setProductName("Wireless Mouse");
        mouse.setQuantity(2);
        mouse.setUnitPrice(45.50);

        OrderItem keyboard = new OrderItem();
        keyboard.setProductName("Mechanical Keyboard");
        keyboard.setQuantity(1);
        keyboard.setUnitPrice(120.00);

        OrderItem hub = new OrderItem();
        hub.setProductName("USB-C Hub");
        hub.setQuantity(3);
        hub.setUnitPrice(28.75);
        order.setItems(List.of(mouse, keyboard, hub));
        double total = mouse.getSubtotal() + keyboard.getSubtotal() + hub.getSubtotal();
        order.setTotal(total);
        return order;
    }
}