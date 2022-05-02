package teste;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class Order {

    private String customerName;
    private UUID id;
    private LocalDateTime createDate;
    private Status status;

    public Order(String customerName, Status status) {
        this.customerName = customerName;
        this.id = UUID.randomUUID();
        this.createDate = LocalDateTime.now();
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario createUsuario(){
        return new Usuario(this.customerName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", id=" + id +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }
}
