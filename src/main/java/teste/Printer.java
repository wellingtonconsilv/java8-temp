package teste;

import java.util.function.Consumer;

public class Printer implements Consumer<Order> {

    @Override
    public void accept(Order o) {
        System.out.println("numero do pedido: " + o.getId() + " Cliente: " + o.getCustomerName());

    }
}
