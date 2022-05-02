package teste;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OrderExample {
    public static void main(String[] args) {
        Order order1 = new Order("Jose", Status.PENDING);
        Order order2 = new Order("Lud", Status.CONFIRMED);
        Order order3 = new Order("Fulano", Status.CONFIRMED);
        Order order4 = new Order("Tadeu", Status.PENDING);
        Order order5 = new Order("Joao", Status.CONFIRMED);
        List<Order> orderList = Arrays.asList(order1, order2, order3, order4, order5);

//        for (Order order :
//                orderList) {
//            System.out.println(order.getCustomerName());
//        }

        Consumer<Order> printer = new Printer();
//        Consumer<Order> consumer = new Consumer<Order>() {
//            @Override
//            public void accept(Order order) {
//
//                System.out.println("Pedido criado em: " + order.getCreateDate());
//            }
//        };
//        Consumer<Order> consumer = (Order order) -> {System.out.println("Pedido criado em: " + order.getCreateDate());};
//        Consumer<Order> consumer =  order -> {System.out.println("Pedido criado em: " + order.getCreateDate());};
        Consumer<Order> consumer = order -> System.out.println("Pedido criado em: " + order.getCreateDate());
        System.out.println("----------- ----- --------------");

        orderList.forEach(printer);

        System.out.println("----------- ----- --------------");

        orderList.forEach(order -> System.out.println("Pedido criado em: " + order.getCreateDate()));

        System.out.println("----------- FILTER --------------");
        orderList.stream()
                .filter( order -> order.getStatus().equals(Status.CONFIRMED))
                .forEach(printer);
        System.out.println("----------- MAP --------------");

        List<Usuario> usuarios = orderList.stream()
                .map(order -> new Usuario(order.getCustomerName()))
                .collect(Collectors.toList());

        usuarios.forEach(System.out::println);

        System.out.println("----------- MAP2 --------------");

        List<Usuario> usuarios2 = orderList.stream()
                .map(Usuario::map)
                .collect(Collectors.toList());

        usuarios2.forEach(System.out::println);

        System.out.println("----------- GROUP --------------");

        Map<Status, List<Order>> orderGroup =
                orderList.stream()
                        .collect(Collectors.groupingBy(Order::getStatus));

        orderGroup.forEach((status, orders) -> {
            System.out.println(status);
            orders.forEach(System.out::println);
        });
    }


    }

