

import com.google.gson.Gson;

public class OrderProcessor {
    public static void main(String[] args) {
        String json = """
                {
                  "orderId": "ORD-2026-0042",
                  "customerName": "revan abusov",
                  "items": [
                    {"productName": "Wireless Mouse", "quantity": 2, "unitPrice": 45.50},
                    {"productName": "Mechanical Keyboard", "quantity": 1, "unitPrice": 120.00},
                    {"productName": "USB-C Hub", "quantity": 3, "unitPrice": 28.75}
                  ],
                  "total": 296.75
                }
                """;
        Gson gson = new Gson();
        Order order = gson.fromJson(json, Order.class);
        System.out.println("=== Parsed Order ===");
        System.out.println(order);
        System.out.println("\nItems:");
        for (OrderItem item : order.getItems()) {
            System.out.printf("  • %s × %d = %.2f $%n",
                    item.getProductName(), item.getQuantity(), item.getSubtotal());
        }
    }
}